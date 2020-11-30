package com.EveryoneRightIsReallyTeam.Merchant.dao.impl;

import com.EveryoneRightIsReallyTeam.Merchant.dao.ClassifyDao;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Classify;
import com.EveryoneRightIsReallyTeam.Merchant.util.ConnectionFunction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassifyDaoImpl implements ClassifyDao {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    @Override
    public List<Classify> selectAll() {
        List<Classify> list = new ArrayList<>();
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select * from classify");
            rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(new Classify(rs.getInt("cid"),rs.getString("cname")));
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
    public int createClassify(Classify classify) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("insert into classify (`cid`,`cname`) values (?,?)");
            pstmt.setInt(1,classify.getCid());
            pstmt.setString(2,classify.getCname());
            return pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }

    }
}
