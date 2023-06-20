package com.ysoyso.annotation.orm.compile;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public abstract class AbstractDao<T> {

    protected final List<Property> properties = new ArrayList<>();
    protected TableBean bean;
    private final Connection connection = DbManager.getInstance().getConnection();

    public boolean createTable() {
        if (null == connection) {
            return false;
        }

        String sql = "CREATE TABLE IF NOT EXISTS `" + getTableName() + "`( \r\n" +
                getCreateTableColumns() + getCreateTableIndexKey() +
                ") ENGINE=" + getTableEngine() + " COMMENT='" + getTableComment() + "';";

        System.out.println(sql);
        try {
            if (connection.isClosed()) {
                return false;
            }
            Statement statement = connection.createStatement();
            return statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("SQL异常：" + e.getMessage());
        }
        return false;
    }

    private String getCreateTableColumns() {
        StringBuilder sql = new StringBuilder();
        for (Property property : properties) {
            sql.append(property.getCreateTableColumn());
        }
        return sql.toString();
    }

    private String getCreateTableIndexKey() {
        StringBuilder sql = new StringBuilder();
        for (Property property : properties) {
            if (property.isIndex()) {
                sql.append(property.getColumns());
            }
        }
        if (sql.length() > 0) {
            sql.deleteCharAt(sql.length() - 1);
        }
        return sql.toString();
    }

    private String getTableName() {
        return bean.getName();
    }


    private String getTableEngine() {
        return bean.getEngine();
    }

    private String getTableComment() {
        return bean.getComment();
    }

    public int insert(T t) {
        if (null == connection || null == t) {
            return -1;
        }
        try {
            if (connection.isClosed()) {
                return -1;
            }
            System.out.println("INSERT INTO " + getTableName() + "(" + getInsertFields() + ") VALUES (" + getInsertValues(t) + ")");
            // 执行插入语句
            Statement statement = connection.createStatement();
            return statement.executeUpdate("INSERT INTO " + getTableName() + "(" + getInsertFields() + ") VALUES (" + getInsertValues(t) + ")");
        } catch (SQLException e) {
            System.out.println("SQL异常：" + e.getMessage());
        }
        return -1;
    }

    private String getInsertFields() {
        StringBuilder sql = new StringBuilder();
        for (Property property : properties) {
            sql.append(property.getColumns());
        }
        if (sql.length() > 0) {
            sql.deleteCharAt(sql.length() - 1);
        }
        return sql.toString();
    }

    private String getInsertValues(T t) {
        StringBuilder sql = new StringBuilder();
        for (Property property : properties) {
            sql.append("'").append(property.getValue(t)).append("',");
        }
        if (sql.length() > 0) {
            sql.deleteCharAt(sql.length() - 1);
        }
        return sql.toString();
    }

    public int update() {
        if (null == connection) {
            return -1;
        }
        try {
            if (connection.isClosed()) {
                return -1;
            }
            Statement statement = connection.createStatement();
            System.out.println("UPDATE " + getTableName() + " SET " + getUpdateFields() + " WHERE " + getWhereStatement());
            // UPDATE student SET age = ? WHERE name = ?
            return statement.executeUpdate("UPDATE " + getTableName() + " SET " + getUpdateFields() + " WHERE " + getWhereStatement());
        } catch (SQLException e) {
            System.out.println("SQL异常：" + e.getMessage());
        }
        return -1;
    }

    protected abstract String getUpdateFields();

    protected abstract String getWhereStatement();

    public List<T> queryAll(T t) {
        if (null == t) {
            return null;
        }
        List<T> list = new ArrayList<>();
        try {
            if (connection.isClosed()) {
                return list;
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + getTableName() + " WHERE " + getWhereStatement());
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            List<String> columns = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
                columns.add(metaData.getColumnName(i));
            }
            while (resultSet.next()) {
                Iterator<String> iterator = columns.iterator();
                T bean = (T) t.getClass().newInstance();
                while (iterator.hasNext()) {
                    String column = iterator.next();
                    Object value = resultSet.getObject(column);
                    Field field = bean.getClass().getField(column);
                    field.setAccessible(true);
                    field.set(bean, value);
                }
                list.add(bean);
            }
        } catch (SQLException e) {
            System.out.println("SQL异常：" + e.getMessage());
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            System.out.println("反射异常：" + e.getMessage());
        }
        return list;
    }

}
