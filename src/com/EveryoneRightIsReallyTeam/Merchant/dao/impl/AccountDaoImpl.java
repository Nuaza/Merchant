package com.EveryoneRightIsReallyTeam.Merchant.dao.impl;

import com.EveryoneRightIsReallyTeam.Merchant.dao.AccountDao;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Account;
import com.EveryoneRightIsReallyTeam.Merchant.util.ConnectionFunction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    @Override
    public List<Account> selectAll() {
        conn = ConnectionFunction.getConnection();
        List<Account> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("select * from account");
            rs = pstmt.executeQuery();
            while(rs.next()){
                list.add(new Account(rs.getInt("pid"),rs.getString("account")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            ConnectionFunction.close(conn, pstmt, null);
        }
    }

    @Override
    public int createAccount(String name,String password) {
        conn = ConnectionFunction.getConnection();
        try {
            pstmt = conn.prepareStatement("insert into account (`account`,`password`,`classify`) values (?,?,0)");
            pstmt.setString(1,name);
            pstmt.setString(2,password);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            ConnectionFunction.close(conn, pstmt, null);
        }

    }

    @Override
    public Account selectAccountByName(String account) {
        conn = ConnectionFunction.getConnection();
        try {
            pstmt = conn.prepareStatement("select * from account where account = ?");
            pstmt.setString(1, account);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Account(rs.getString("account"), rs.getString("password"), 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            ConnectionFunction.close(conn, pstmt, null);
        }
        return null;
    }

    @Override
    public int getLogin(String account, String password) {
        conn = ConnectionFunction.getConnection();
        try {
            pstmt = conn.prepareStatement("select * from account");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if (account.equals(rs.getString("account"))) {
                    if (password.equals(rs.getString("password"))) {
                        return rs.getInt("classify");//classify为1表示管理员，为0表示普通玩家
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 2;
        } finally {
            ConnectionFunction.close(conn, pstmt, null);
        }
        return 2;   //返回2表示登录失败
    }
}
