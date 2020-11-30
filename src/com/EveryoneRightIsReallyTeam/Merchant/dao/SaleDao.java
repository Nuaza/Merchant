package com.EveryoneRightIsReallyTeam.Merchant.dao;

import com.EveryoneRightIsReallyTeam.Merchant.entity.Sale;

import java.util.List;

public interface SaleDao {
    int InitAll();

    int UpdateAll();

    double getMoneyByNumber(int pid,int gid,int numb);

    double setLessNumber(int pid,int gid,int numb);//直接返回总价值

    double setMoreNumber(int pid,int gid,int numb);

    List<Sale> SelectAll();

    List<Sale> SelectByPname(String pname);

    List<Sale> SelectByGname(String gname);
}
