package com.EveryoneRightIsReallyTeam.Merchant.dao.impl;

import com.EveryoneRightIsReallyTeam.Merchant.dao.PlayerDao;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Player;
import com.EveryoneRightIsReallyTeam.Merchant.util.ConnectionFunction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDaoImpl implements PlayerDao {

//    MySQL数据库层面在Player表加入了一个触发器，在新建用户时自动算出当前时间一年后的时间放入limit字段，作为游戏结束限制时间
//create trigger getLimit before insert on player for each row
//    begin
//    set new.`limit` = date_add(new.date,interval 1 year);
//    end

//    MySQL数据库层面在Player表加入了一个触发器，日期每流逝一天则债务上涨0.1%
//create trigger DebtRule before update on player for each row
//    begin
//	if new.date > old.date then set new.debt = new.debt + new.debt * 0.001;
//    end if;
//    end

    private Connection conn;
    private PreparedStatement pstmt,pstmt2;
    private ResultSet rs;
    private double cash;
    Date time= new java.sql.Date(new java.util.Date().getTime());
    @Override


    public int createPlayer(String name) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("update player set `name`=?,cash=1000,debt=100000,date=?,nowin=1");
            pstmt.setString(1,name);
            pstmt.setDate(2,time);

            return pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
    }

    @Override
    public int SelectNowinByID(int id) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select nowin from player where id = ?");
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt("nowin");
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
    public double SelectDebtByID(int id) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select debt from player where id = ?");
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getDouble("debt");
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
    public double selectCash(int id) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select cash from player where id = ?");
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getDouble("cash");
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
    public void updateNowinByPID(int id,int pid) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("update player set nowin = ? where id = ?");
            pstmt.setInt(1,pid);
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return ;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
    }

    @Override
    public void updateDate(int id) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("update player set date = date_add(date,interval 1 day) where id = ?");
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return ;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
    }

    @Override
    public int selectDateLimit(int id) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select `date`<`limit` from player where id = ?");
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt("`date`<`limit`"); //返回1表示还未到limit时间，返回0表示时间已到，gameover!
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
    public int selectDatediff(int id) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select datediff(`limit`,`date`) from player where id = ?");
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt("datediff(`limit`,`date`)");
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
    public int updateDebt(int id, double money) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select cash,debt from player where id = ?");
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                double cash = rs.getDouble("cash");
                double debt = rs.getDouble("debt");
                if(money <= cash){
                    pstmt2 = conn.prepareStatement("update player set cash = ?, debt = ?");
                    pstmt2.setDouble(1,cash-money);
                    pstmt2.setDouble(2,debt-money);
                    pstmt2.executeUpdate();
                    return 0;
                }
                else    return 1;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return 1;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
        return 1;
    }

    @Override
    public int getCash(int id, double money) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("update player set cash = cash + ? where id = ?");
            pstmt.setDouble(1,money);
            pstmt.setInt(2,id);
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
    public int loseCash(int id, double money) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("update player set cash = cash - ? where id = ?");
            pstmt.setDouble(1,money);
            pstmt.setInt(2,id);
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
    public int updateName(int id, String name) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("update player set name = ? where id = ?");
            pstmt.setString(1,name);
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
        return 0;
    }

    @Override
    public List<Player> selectAll() {
        List<Player> list = new ArrayList<>();
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select * from player");
            rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(new Player(rs.getInt("id"),rs.getString("name"),rs.getDouble("cash"),rs.getDouble("debt"),rs.getDate("date"),rs.getDate("limit"),rs.getInt("nowin")));
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
    public Date selectDate(int id) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select date from player where id = ?");
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getDate("date");
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
