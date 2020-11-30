package com.EveryoneRightIsReallyTeam.Merchant.dao;

import com.EveryoneRightIsReallyTeam.Merchant.entity.Goods;

import java.util.List;

public interface GoodsDao {
    List<Goods> selectAll();

    int createGoods(Goods goods);

    int updateGprice(String gname,double gprice);

    int updateGclass(String gname,int gclass);

    Goods selectGoodsByName(String gname);

    int selectIDByName(String gname);

    String selectNameByID(int id);
}
