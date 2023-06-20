package com.ysoyso.annotation.orm;

import com.ysoyso.annotation.orm.runtime.Column;
import com.ysoyso.annotation.orm.runtime.Table;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private Connection connection;
    private String host;
    private String port;
    private String username;
    private String password;
    private String database;

    private DatabaseManager() {

    }

    private static final class Holder {
        public static final DatabaseManager MANAGER = new DatabaseManager();
    }

    public static DatabaseManager getInstance() {
        return Holder.MANAGER;
    }

    public boolean connect(String host, String port, String username, String password, String database) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database; // 数据库URL
        try {
            connection = DriverManager.getConnection(url, username, password);
            return true;
        } catch (SQLException e) {
            System.out.println("MySQL数据库连接失败：" + e.getMessage());
        }
        return false;
    }

    public void disconnect() {
        if (null == connection) {
            return;
        }
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void retry() {
        connect(host, port, username, password, database);
    }


    /**
     * CREATE TABLE `tableName` (
     * `field` type(length) UNSIGNED/COLLATE utf8mb4_unicode_ci NOT NULL AUTO_INCREMENT DEFAULT 'normal' COMMENT 'description',
     * PRIMARY KEY (`field`),
     * UNIQUE KEY `field` (`field`) USING BTREE,
     * INDEX (`field`)
     * ) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='description'
     *
     * @param clazz
     * @param <T>
     */
    public <T> boolean createTable(Class<T> clazz) {
        if (null == connection || null == clazz) {
            return false;
        }
        boolean isTable = clazz.isAnnotationPresent(Table.class);
        if (!isTable) {
            System.out.println(clazz.getSimpleName() + "不是表");
            return false;
        }
        // 获取表信息
        Table table = clazz.getAnnotation(Table.class);
        String name = table.name();
        if (null == name || "".equals(name)) {
            name = clazz.getSimpleName();
        }
        // 获取所有字段
        Field[] fields = clazz.getDeclaredFields();
        // 创建列的字符串
        StringBuilder fieldSql = new StringBuilder();
        // 创建索引的字符串
        StringBuilder indexKey = new StringBuilder();
        for (Field field : fields) {
            field.setAccessible(true);
            String type = getColumnType(field);
            if (null == type) {
                continue;
            }
            String fieldName = field.getName();
            // 分两种情况，1. 根据注解来生成列，2. 根据没有注解来生成列
            boolean hasAnnotation = field.isAnnotationPresent(Column.class);
            if (hasAnnotation) {
                Column column = field.getAnnotation(Column.class);
                if (column.skip()) {
                    continue;
                }
                String columnName = column.name();
                if (null != columnName && !"".equals(columnName)) {
                    fieldName = columnName;
                }
                // 生成 `fieldName` type 语句
                fieldSql.append("`").append(fieldName).append("` ").append(type).append(" ");
                if (column.identity()) { // 主键
                    fieldSql.append("PRIMARY KEY ");
                }
                if (!column.nullable()) { // 非空
                    fieldSql.append("NOT NULL ");
                }
                if (column.unique()) { // 唯一索引
                    fieldSql.append("UNIQUE ");
                }
                if (column.autoincrement()) { // 自增
                    fieldSql.append("AUTO_INCREMENT ");
                }
                if (null != column.description() && !"".equals(column.description())) { // 注释
                    fieldSql.append("COMMENT '").append(column.description()).append("' ");
                }
                fieldSql.append(", \r\n");

                if (column.index()) { // 拼接索引列，生成 name,sex, 语句，下面再前后补充 INDEX() 语句
                    indexKey.append(fieldName).append(",");
                }
            } else { // 没有注解时生成语句，默认非空
                fieldSql.append("`").append(fieldName).append("` ").append(type).append(" NOT NULL , \r\n");
            }

        }
        // 去除索引字段最后一个逗号，并且前后拼接成完整语句
        if (indexKey.length() > 0) {
            indexKey.deleteCharAt(indexKey.length() - 1);
            indexKey.insert(0, "INDEX(").append(") \r\n");
        }

        String engine = table.engine();
        String comment = table.description();
        String sql = "CREATE TABLE IF NOT EXISTS `" + name + "`( \r\n" +
                fieldSql + indexKey +
                ") ENGINE=" + engine + " COMMENT='" + comment + "';";

        System.out.println(sql);
        try {
            Statement statement = connection.createStatement();
            return statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("SQL异常：" + e.getMessage());
        }
        return false;
    }

    public <T> int insert(T t) {
        if (null == connection || null == t) {
            return -1;
        }
        Class<?> clazz = t.getClass();
        boolean isTable = clazz.isAnnotationPresent(Table.class);
        if (!isTable) {
            System.out.println(clazz.getSimpleName() + "不是表");
            return -1;
        }
        try {
            if (connection.isClosed()) {
                return -1;
            }
            Statement statement = connection.createStatement();
            // 获取表信息
            Table table = clazz.getAnnotation(Table.class);
            String name = table.name();
            // 如果没有设置表名就要用类名
            if (null == name || "".equals(name)) {
                name = clazz.getSimpleName();
            }
            // 存储插入字段
            StringBuilder insertFields = new StringBuilder();
            // 存储插入的值
            StringBuilder insertValues = new StringBuilder();

            Field[] fields = clazz.getDeclaredFields();
            // 遍历所有字段，生成要插入的字段和值
            for (Field field : fields) {
                field.setAccessible(true);
                String type = getColumnType(field);
                if (null == type) {
                    continue;
                }
                String fieldName = field.getName();
                // 这里如果有注解，需要根据注解来获取列名，否则的话就用属性名作为列名
                boolean hasAnnotation = field.isAnnotationPresent(Column.class);
                if (hasAnnotation) {
                    Column column = field.getAnnotation(Column.class);
                    if (column.skip()) {
                        continue;
                    }
                    if (column.autoincrement()) {
                        continue;
                    }
                    String columnName = column.name();
                    if (null != columnName && !"".equals(columnName)) {
                        fieldName = columnName;
                    }
                }
                // 生成列名，name,sex,age...
                insertFields.append(fieldName).append(",");
                // 生成值, '老王','1','1'...
                insertValues.append("'").append(field.get(t)).append("',");
            }
            // 去掉最后一个逗号
            insertFields.deleteCharAt(insertFields.length() - 1);
            insertValues.deleteCharAt(insertValues.length() - 1);
            System.out.println("INSERT INTO " + name + "(" + insertFields + ") VALUES (" + insertValues + ")");
            // 执行插入语句
            return statement.executeUpdate("INSERT INTO " + name + "(" + insertFields + ") VALUES (" + insertValues + ")");
        } catch (SQLException e) {
            System.out.println("SQL异常：" + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("反射异常：" + e.getMessage());
        }
        return -1;
    }

    public <T> int update(T t, T where) {
        if (null == connection || null == t || null == where) {
            return -1;
        }
        Class<?> clazz = t.getClass();
        Class<?> clazzWhere = t.getClass();
        boolean isTable = clazz.isAnnotationPresent(Table.class);
        boolean isWhereTable = clazzWhere.isAnnotationPresent(Table.class);
        if (!isTable || !isWhereTable) {
            System.out.println(clazz.getSimpleName() + " 或 " + clazzWhere.getSimpleName() + "不是表");
            return -1;
        }
        try {
            if (connection.isClosed()) {
                return -1;
            }
            Statement statement = connection.createStatement();
            // 获取表信息
            Table table = clazz.getAnnotation(Table.class);
            String name = table.name();
            // 如果没有设置表名就要用类名
            if (null == name || "".equals(name)) {
                name = clazz.getSimpleName();
            }
            StringBuilder setStatements = new StringBuilder();
            StringBuilder whereStatements = new StringBuilder();

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String type = getColumnType(field);
                // null == field.get(t) 如果要更新的数据中没有值，就不要设置
                if (null == type || null == field.get(t)) {
                    continue;
                }
                String fieldName = field.getName();
                boolean hasAnnotation = field.isAnnotationPresent(Column.class);
                // 这里如果有注解，需要根据注解来获取列名，否则的话就用属性名作为列名
                if (hasAnnotation) {
                    Column column = field.getAnnotation(Column.class);
                    if (column.skip()) {
                        continue;
                    }
                    String columnName = column.name();
                    if (null != columnName && !"".equals(columnName)) {
                        fieldName = columnName;
                    }
                }
                setStatements.append(fieldName).append("='").append(field.get(t)).append("',");
            }

            Field[] whereFields = clazzWhere.getDeclaredFields();
            for (Field field : whereFields) {
                field.setAccessible(true);
                String type = getColumnType(field);
                // null == field.get(t) 如果要更新的数据中没有值，就不要设置
                if (null == type || null == field.get(where)) {
                    continue;
                }
                String fieldName = field.getName();
                boolean hasAnnotation = field.isAnnotationPresent(Column.class);
                // 这里如果有注解，需要根据注解来获取列名，否则的话就用属性名作为列名
                if (hasAnnotation) {
                    Column column = field.getAnnotation(Column.class);
                    if (column.skip()) {
                        continue;
                    }
                    String columnName = column.name();
                    if (null != columnName && !"".equals(columnName)) {
                        fieldName = columnName;
                    }
                }
                whereStatements.append(fieldName).append("='").append(field.get(where)).append("' AND ");
            }
            // 去掉最后一个逗号
            setStatements.deleteCharAt(setStatements.length() - 1);
            // 去掉最后一个AND和空格
            whereStatements.delete(whereStatements.length() - 4, whereStatements.length());
            System.out.println("UPDATE " + name + " SET " + setStatements + " WHERE " + whereStatements);
            // UPDATE student SET age = ? WHERE name = ?
            return statement.executeUpdate("UPDATE " + name + " SET " + setStatements + " WHERE " + whereStatements);
        } catch (SQLException e) {
            System.out.println("SQL异常：" + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("反射异常：" + e.getMessage());
        }
        return -1;
    }

    public <T> List<T> queryAll(T t) {
        if (null == t) {
            return null;
        }
        List<T> list = new ArrayList<>();
        try {
            if (connection.isClosed()) {
                return list;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(createQueryStatement(t));
            setStatement(preparedStatement, t);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Object bean = t.getClass().newInstance();
                Field[] fields = t.getClass().getDeclaredFields();
                for (Field field : fields) {
                    // 设置可访问
                    field.setAccessible(true);
                    // 不是基本类型就继续
                    if (null == getColumnType(field)) {
                        continue;
                    }
                    // 过滤不是字段的属性
                    String columnName = field.getName();
                    if (field.isAnnotationPresent(Column.class)) {
                        Column column = field.getAnnotation(Column.class);
                        if (column.skip()) {
                            continue;
                        }
                        if (null != column.name() && !"".equals(column.name())) {
                            columnName = column.name();
                        }
                    }
                    field.set(bean, resultSet.getObject(columnName, field.getType()));
                }
                list.add((T) bean);
            }

        } catch (SQLException e) {
            System.out.println("SQL异常：" + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("反射异常：" + e.getMessage());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public <T> int delete(T t) {
        // TODO
        return -1;
    }

    private <T> void setStatement(PreparedStatement statement, T t) throws SQLException, IllegalAccessException {
        Class<?> clazz = t.getClass();
        boolean isTable = clazz.isAnnotationPresent(Table.class);
        if (!isTable) {
            return;
        }
        Field[] fields = clazz.getDeclaredFields();
        int index = 0;
        for (Field field : fields) {
            // 设置可访问
            field.setAccessible(true);
            // 没有数据就跳过
            if (null == field.get(t)) {
                continue;
            }
            // 标识跳过也要跳过
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                if (column.skip()) {
                    continue;
                }
            }
            // 获取值
            checkAndSet(statement, t, field, index);
            index++;
        }
    }

    private <T> String createQueryStatement(T t) throws IllegalAccessException, SQLException {
        Class<?> clazz = t.getClass();
        boolean isTable = clazz.isAnnotationPresent(Table.class);
        if (!isTable) {
            return null;
        }
        // 初始化查询语句
        StringBuilder builder = new StringBuilder("SELECT * FROM ");
        Table table = clazz.getAnnotation(Table.class);
        String name = table.name();
        // 如果没有设置表名就要用类名
        if (null == name || "".equals(name)) {
            name = clazz.getSimpleName();
        }
        builder.append(name);
        Field[] fields = clazz.getDeclaredFields();
        int index = 0;
        for (Field field : fields) {
            // 设置可访问
            field.setAccessible(true);
            // 没有数据就跳过
            if (null == field.get(t)) {
                continue;
            }
            String columnName = field.getName();
            // 标识跳过也要跳过
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                if (column.skip()) {
                    continue;
                }
                // 获取列名
                String cName = column.name();
                if (null != cName && !"".equals(cName)) {
                    columnName = column.name();
                }
            }
            // 设置 WHERE 子句
            if (index == 0) {
                builder.append(" WHERE ");
            } else {
                builder.append(" AND ");
            }
            index++;
            builder.append(columnName).append(" = ? ");
        }
        return builder.toString();
    }


    private <T> void checkAndSet(PreparedStatement statement, T t, Field field, int index) throws IllegalAccessException, SQLException {
        if (null == field.get(t)) {
            return;
        }
        Class<?> type = field.getType();
        if (type.equals(byte.class) || type.equals(Byte.class)) {
            statement.setByte(index, field.getByte(t));
        } else if (type.equals(short.class) || type.equals(Short.class)) {
            statement.setShort(index, field.getShort(t));
        } else if (type.equals(int.class) || type.equals(Integer.class)) {
            statement.setInt(index, field.getShort(t));
        } else if (type.equals(long.class) || type.equals(Long.class)) {
            statement.setLong(index, field.getShort(t));
        } else if (type.equals(float.class) || type.equals(Float.class)) {
            statement.setFloat(index, field.getShort(t));
        } else if (type.equals(double.class) || type.equals(Double.class)) {
            statement.setDouble(index, field.getShort(t));
        } else if (type.equals(char.class) || type.equals(Character.class)) {
            statement.setString(index, field.getChar(t) + "");
        } else if (type.equals(boolean.class) || type.equals(Boolean.class)) {
            statement.setBoolean(index, field.getBoolean(t));
        } else if (type.equals(String.class)) {
            statement.setString(index, field.get(t).toString());
        } else {
            // TODO 如果是对象类型，可增加其他注解，根据注解来选择是哪种查询
        }
    }

    private <T> String getColumnType(Field field) {
        Class<?> type = field.getType();
        if (type.equals(byte.class) || type.equals(Byte.class)) {
            return "TINYINT";
        } else if (type.equals(short.class) || type.equals(Short.class)) {
            return "INT";
        } else if (type.equals(int.class) || type.equals(Integer.class)) {
            return "INT";
        } else if (type.equals(long.class) || type.equals(Long.class)) {
            return "BIGINT";
        } else if (type.equals(float.class) || type.equals(Float.class)) {
            return "FLOAT";
        } else if (type.equals(double.class) || type.equals(Double.class)) {
            return "DOUBLE";
        } else if (type.equals(char.class) || type.equals(Character.class)) {
            return "CHAR";
        } else if (type.equals(boolean.class) || type.equals(Boolean.class)) {
            return "BOOLEAN";
        } else if (type.equals(String.class)) {
            return "VARCHAR(32)";
        } else {
            return null;
        }
    }
}
