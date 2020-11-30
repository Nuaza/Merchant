package com.EveryoneRightIsReallyTeam.Merchant.dao.impl;

import com.EveryoneRightIsReallyTeam.Merchant.dao.GoodsDao;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Account;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Classify;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Goods;
import com.EveryoneRightIsReallyTeam.Merchant.util.ConnectionFunction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    @Override
    public List<Goods> selectAll() {
        List<Goods> list = new ArrayList<>();
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select * from goods");
            rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(new Goods(rs.getInt("gid"),rs.getString("gname"),rs.getDouble("gprice"),rs.getInt("gclass")));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
    }

    @Override
    public int createGoods(Goods goods) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("insert into goods (`gid`,`gname`,`gprice`,`gclass`) values (?,?,?,?)");
            pstmt.setInt(1,goods.getGid());
            pstmt.setString(2,goods.getGname());
            pstmt.setDouble(3,goods.getGprice());
            pstmt.setInt(4,goods.getGclass());
            return pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
    }

    @Override
    public int updateGprice(String gname, double gprice) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("update goods set gprice = ? where gname = ?");
            pstmt.setDouble(1,gprice);
            pstmt.setString(2,gname);
            return pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
    }

    @Override
    public int updateGclass(String gname, int gclass) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("update goods set gclass = ? where gname = ?");
            pstmt.setInt(1,gclass);
            pstmt.setString(2,gname);
            return pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
    }

    @Override
    public Goods selectGoodsByName(String gname) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select * from goods where gname = ?");
            pstmt.setString(1,gname);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return new Goods(rs.getInt("gid"),rs.getString("gname"),rs.getDouble("gprice"),rs.getInt("gclass"));
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
        return null;
    }

    @Override
    public int selectIDByName(String gname) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select gid from goods where gname = ?");
            pstmt.setString(1,gname);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt("gid");
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
    public String selectNameByID(int id) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select gname from goods where gid = ?");
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getString("gname");
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
