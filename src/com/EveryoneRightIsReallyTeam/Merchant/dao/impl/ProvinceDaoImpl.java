package com.EveryoneRightIsReallyTeam.Merchant.dao.impl;

import com.EveryoneRightIsReallyTeam.Merchant.dao.ProvinceDao;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Account;
import com.EveryoneRightIsReallyTeam.Merchant.util.ConnectionFunction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinceDaoImpl implements ProvinceDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    @Override
    public int getNorthp(int pid) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select northp from province where pid = ?");
            pstmt.setInt(1,pid);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt("northp");
            }
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
        return 0;
    }

    @Override
    public int getEastp(int pid) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select eastp from province where pid = ?");
            pstmt.setInt(1,pid);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt("eastp");
            }
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
        return 0;
    }

    @Override
    public int getWestp(int pid) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select westp from province where pid = ?");
            pstmt.setInt(1,pid);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt("westp");
            }
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
        return 0;
    }

    @Override
    public int getSouthp(int pid) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select southp from province where pid = ?");
            pstmt.setInt(1,pid);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt("southp");
            }
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
        return 0;
    }

    @Override
    public String selectNameByID(int pid) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select pname from province where pid = ?");
            pstmt.setInt(1,pid);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getString("pname");
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
        return null;
    }
}
