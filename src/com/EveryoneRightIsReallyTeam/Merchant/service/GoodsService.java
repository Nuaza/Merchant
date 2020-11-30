package com.EveryoneRightIsReallyTeam.Merchant.service;

import com.EveryoneRightIsReallyTeam.Merchant.entity.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> showAll();//管理员管理专用，显示所有商品信息

    int getGoodsID(String gname);//根据商品名称查找对应ID

    String getGoodsName(int id);//根据ID查找商品名称

    int newGoods(Goods goods);//管理员管理专用，新增商品

    int setGprice(String gname,double gprice);//管理员专用，设置商品价格

    int setGclass(String gname,int gclass);//管理员专用，设置商品种类

    Goods returnGoods(String gname);//根据商品名称查找商品信息
}
