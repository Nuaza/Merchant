package com.EveryoneRightIsReallyTeam.Merchant.util;
import java.sql.*;

public class ConnectionFunction{
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/tradingmap?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC"
                    ,"root"
                    ,"123456");//
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs){
        try {
            if (rs != null)  rs.close();
            if (stmt != null)   stmt.close();
            if (conn != null)   conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}