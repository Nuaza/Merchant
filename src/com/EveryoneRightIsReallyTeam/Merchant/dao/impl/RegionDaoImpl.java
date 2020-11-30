package com.EveryoneRightIsReallyTeam.Merchant.dao.impl;

import com.EveryoneRightIsReallyTeam.Merchant.dao.RegionDao;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Classify;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Region;
import com.EveryoneRightIsReallyTeam.Merchant.util.ConnectionFunction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionDaoImpl implements RegionDao {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    @Override
    public int createRegion(Region region) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("insert into region (`rid`,`rname`) values (?,?)");
            pstmt.setInt(1,region.getRid());
            pstmt.setString(2,region.getRname());
            return pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }

    }
}
