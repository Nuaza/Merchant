package com.EveryoneRightIsReallyTeam.Merchant.dao.impl;

import com.EveryoneRightIsReallyTeam.Merchant.dao.StorageDao;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Sale;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Storage;
import com.EveryoneRightIsReallyTeam.Merchant.util.ConnectionFunction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StorageDaoImpl implements StorageDao {

    //MySQL数据库层面建立一个触发器，自动算出平均价格
//    create trigger getAvgPrice before update on `storage` for each row
//    begin
//	if new.cost != old.cost then set new.avgprice = new.cost / new.number;
//    end if;
//    end

    private Connection conn;
    private PreparedStatement pstmt,pstmt2,pstmt3;
    private ResultSet rs;
    private int number;
    @Override
    public List<Storage> selectAll(int id) {
        List<Storage> list = new ArrayList<>();
        conn = ConnectionFunction.getConnection();
        try {
            pstmt = conn.prepareStatement("select * from storage where id = ?");
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            while(rs.next()){
                list.add(new Storage(rs.getInt("id"),rs.getInt("gid"),rs.getInt("number"),rs.getDouble("cost"),rs.getDouble("avgprice")));
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
    public int setLessNumber(int id,int gid, int numb) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select number from storage where id = ? and gid = ?");
            pstmt.setInt(1,id);
            pstmt.setInt(2,gid);
            rs = pstmt.executeQuery();
            if(rs.next()){
                number = rs.getInt("number");
            }else{
                return 0;
            }
            if(number >= numb){
                pstmt2 = conn.prepareStatement("update storage set number = number - ? where id = ? and gid = ?");
                pstmt2.setInt(1,numb);
                pstmt2.setInt(2,id);
                pstmt2.setInt(3,gid);
                pstmt2.executeUpdate();
                return 1;
            }else{
                return 0;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
    }

    @Override
    public int setMoreNumber(int id,int gid, int numb) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("update storage set number = number + ? where id = ? and gid = ?");
            pstmt.setInt(1,numb);
            pstmt.setInt(2,id);
            pstmt.setInt(3,gid);
            pstmt.executeUpdate();
            return 1;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
    }

    @Override
    public int initStorage(int id) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("truncate `storage`");
            pstmt.executeUpdate();
            pstmt2 = conn.prepareStatement("select gid from goods");
            rs = pstmt2.executeQuery();
            while (rs.next()){
                pstmt3 = conn.prepareStatement("insert into storage (`id`,`gid`,`number`,`cost`,`avgprice`) values (?,?,0,0,0)");
                pstmt3.setInt(1,id);
                pstmt3.setInt(2,rs.getInt("gid"));
                pstmt3.executeUpdate();
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
    public int updateCost(double cost,int id,int gid) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("update storage set cost = cost + ? where id = ? and gid = ?");
            pstmt.setDouble(1,cost);
            pstmt.setInt(2,id);
            pstmt.setInt(3,gid);
            pstmt.executeUpdate();
            return 1;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
    }
}
