package yq.oa.util;

import java.sql.*;

/**
 * 数据库连接与关闭工具类。
 *
 * @author 北大青鸟
 */
public class DatabaseUtil {

    /**
     * 获取数据库连接对象。
     *
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
//        // 获取连接并捕获异常
//        Connection conn = null;
//        try {
//            Context ctx = new InitialContext();
//            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oasys");
//            conn = ds.getConnection();
//        } catch (NamingException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
        //1、加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2、创建连接对象
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/oasys?serverTimezone=GMT-8", "root", "2004923");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return conn;
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
