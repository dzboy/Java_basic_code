package com.ysoyso.annotation.orm.compile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {

    private Connection connection;
    private String host;
    private String port;
    private String username;
    private String password;
    private String database;

    private DbManager() {

    }

    private static final class Holder {
        public static final DbManager MANAGER = new DbManager();
    }

    public static DbManager getInstance() {
        return DbManager.Holder.MANAGER;
    }

    public void init(String host, String port, String username, String password, String database) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    public boolean connect() {
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

    public Connection getConnection() {
        return connection;
    }
}
