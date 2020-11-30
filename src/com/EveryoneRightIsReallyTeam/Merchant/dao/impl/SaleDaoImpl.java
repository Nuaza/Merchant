package com.EveryoneRightIsReallyTeam.Merchant.dao.impl;

import com.EveryoneRightIsReallyTeam.Merchant.dao.SaleDao;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Account;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Sale;
import com.EveryoneRightIsReallyTeam.Merchant.util.ConnectionFunction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleDaoImpl implements SaleDao {

    //MySQL数据库层面在sale表中加入两个触发器，负责在插入或者更新number和realprice时自动计算出totalprice的值，所以在Dao层面不用刻意管totalnumber项
//    create trigger AccountTotalprice before insert on sale for each row
//    begin
//    set new.totalprice = new.realprice * new.number;
//    end

//    create trigger UpdateTotalprice before update on sale for each row
//    begin
//    set new.totalprice = new.realprice * new.number;
//    end

    //MySQL数据库层面在sale表中加入一个触发器，负责模拟市场商品数量变动导致商品价格的变动，每次交易会导致价格浮动0.1%。
    //例如大量抛售某种商品，则该商品单价会迅速下降；而大量购入某种商品导致其剩余数量变少，则会导致该商品单价急剧上升。
//    create trigger MarketRule before update on sale for each row
//    begin
//	if new.number > old.number then set new.realprice = new.realprice - new.realprice * (new.number - old.number) * 0.001;
//    elseif new.number < old.number then set new.realprice = new.realprice + new.realprice * (old.number - new.number) * 0.001;
//	else set new.realprice = old.realprice;
//    end if;
//    end

    private Connection conn;
    private PreparedStatement pstmt,pstmt2;
    private ResultSet rs;
    private int pid,gid,number;
    private double realprice;
    @Override
    public int InitAll() {
        conn = ConnectionFunction.getConnection();
        try{
            for(pid = 1; pid <=34; pid++){
                pstmt = conn.prepareStatement("select gid, gprice from goods");
                rs = pstmt.executeQuery();
                while(rs.next()){
                    gid = rs.getInt("gid");
                    realprice = rs.getDouble("gprice") * (Math.random()*0.4+0.8);   //商品价格浮动在80%到120%之间
                    number = (int) (Math.random()*380+20);    //随机生成商品数量
                    pstmt2 = conn.prepareStatement("insert into sale (`pid`,`gid`,`realprice`,`number`) values (?,?,?,?)");
                    pstmt2.setInt(1,pid);
                    pstmt2.setInt(2,gid);
                    pstmt2.setDouble(3,realprice);
                    pstmt2.setInt(4,number);
                    pstmt2.executeUpdate();
                }
            }
            return 0;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
    }

    @Override
    public int UpdateAll() {
        conn = ConnectionFunction.getConnection();
        try{
            for(pid = 1; pid <=34; pid++){
                pstmt = conn.prepareStatement("select gid, gprice from goods");
                rs = pstmt.executeQuery();
                while(rs.next()){
                    gid = rs.getInt("gid");
                    realprice = rs.getDouble("gprice") * (Math.random()*0.4+0.8);   //商品价格浮动在80%到120%之间
                    number = (int) (Math.random()*380+20);    //随机生成商品数量
                    pstmt2 = conn.prepareStatement("update sale set realprice=?,number=? where pid=? and gid=?");
                    pstmt2.setDouble(1,realprice);
                    pstmt2.setInt(2,number);
                    pstmt2.setInt(3,pid);
                    pstmt2.setInt(4,gid);
                    pstmt2.executeUpdate();
                }
            }
            return 0;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }
    }

    @Override
    public double getMoneyByNumber(int pid,int gid,int numb) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select ? * realprice as money from sale where pid=? and gid=?");
            pstmt.setInt(1,numb);
            pstmt.setInt(2,pid);
            pstmt.setInt(3,gid);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getDouble("money");
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
    public double setLessNumber(int pid, int gid, int numb) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select * from sale where pid = ? and gid = ?");
            pstmt.setInt(1,pid);
            pstmt.setInt(2,gid);
            rs = pstmt.executeQuery();
            if(rs.next()){
                number = rs.getInt("number");
                realprice = rs.getDouble("realprice");
            }else{
                return 0;
            }
            if(number >= numb){
                pstmt2 = conn.prepareStatement("update sale set number = number - ? where pid = ? and gid = ?");
                pstmt2.setInt(1,numb);
                pstmt2.setInt(2,pid);
                pstmt2.setInt(3,gid);
                pstmt2.executeUpdate();
                return realprice * numb;
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
    public double setMoreNumber(int pid, int gid, int numb) {
        conn = ConnectionFunction.getConnection();
        try{
            pstmt = conn.prepareStatement("select * from sale where pid = ? and gid = ?");
            pstmt.setInt(1,pid);
            pstmt.setInt(2,gid);
            rs = pstmt.executeQuery();
            if(rs.next()){
                number = rs.getInt("number");
                realprice = rs.getDouble("realprice");
            }else{
                return 0;
            }
            if(number > numb){
                pstmt2 = conn.prepareStatement("update sale set number = number + ? where pid = ? and gid = ?");
                pstmt2.setInt(1,numb);
                pstmt2.setInt(2,pid);
                pstmt2.setInt(3,gid);
                pstmt2.executeUpdate();
                return realprice * numb;
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
    public List<Sale> SelectAll() {
        List<Sale> list = new ArrayList<>();
        conn = ConnectionFunction.getConnection();
        try {
            pstmt = conn.prepareStatement("select * from sale");
            rs = pstmt.executeQuery();
            while(rs.next()){
                list.add(new Sale(rs.getInt("pid"),rs.getInt("gid"),rs.getDouble("realprice"),rs.getInt("number"),rs.getDouble("totalprice")));
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
    public List<Sale> SelectByPname(String pname) {
        List<Sale> list = new ArrayList<>();
        conn = ConnectionFunction.getConnection();
        try {
            pstmt = conn.prepareStatement("select * from sale where pid=(select pid from province where pname = ?)");
            pstmt.setString(1,pname);
            rs = pstmt.executeQuery();
            while(rs.next()){
                list.add(new Sale(rs.getInt("pid"),rs.getInt("gid"),rs.getDouble("realprice"),rs.getInt("number"),rs.getDouble("totalprice")));
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
    public List<Sale> SelectByGname(String gname) {
        List<Sale> list = new ArrayList<>();
        conn = ConnectionFunction.getConnection();
        try {
            pstmt = conn.prepareStatement("select * from sale where gid=(select gid from goods where gname = ?)");
            pstmt.setString(1,gname);
            rs = pstmt.executeQuery();
            while(rs.next()){
                list.add(new Sale(rs.getInt("pid"),rs.getInt("gid"),rs.getDouble("realprice"),rs.getInt("number"),rs.getDouble("totalprice")));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }finally {
            ConnectionFunction.close(conn,pstmt,null);
        }

    }
}
