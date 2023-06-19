package com.yq.utils;

import java.sql.*;

/**
 * 数据库连接与关闭工具类。
 *
 * @author 北大青鸟
 */
public class DatabaseUtil {
    private static String driver = ConfigManager.getInstance().getValue("driver");// 数据库驱动字符串
    private static String url = ConfigManager.getInstance().getValue("url");// 连接URL字符串
    private static String user = ConfigManager.getInstance().getValue("username"); // 数据库用户名
    private static String password = ConfigManager.getInstance().getValue("password"); // 用户密码

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象。
     *
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        // 获取连接并捕获异常
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return conn;// 返回连接对象
    }

    /**
     * 关闭数据库连接。
     *
     * @param conn 数据库连接
     * @param stmt Statement对象
     * @param rs   结果集
     */
    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        // 若结果集对象不为空，则关闭
        try {
            if (rs != null && !rs.isClosed())
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 若Statement对象不为空，则关闭
        try {
            if (stmt != null && !stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 若数据库连接对象不为空，则关闭
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
