package com.EveryoneRightIsReallyTeam.Merchant.service.impl;

import com.EveryoneRightIsReallyTeam.Merchant.dao.GoodsDao;
import com.EveryoneRightIsReallyTeam.Merchant.dao.impl.GoodsDaoImpl;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Goods;
import com.EveryoneRightIsReallyTeam.Merchant.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    GoodsDao gd = new GoodsDaoImpl();

    @Override
    public List<Goods> showAll() {
        return gd.selectAll();
    }

    @Override
    public int getGoodsID(String gname) {
        return gd.selectIDByName(gname);
    }

    @Override
    public String getGoodsName(int id) {
        return gd.selectNameByID(id);
    }

    @Override
    public int newGoods(Goods goods) {
        return gd.createGoods(goods);
    }

    @Override
    public int setGprice(String gname, double gprice) {
        return gd.updateGprice(gname,gprice);
    }

    @Override
    public int setGclass(String gname, int gclass) {
        return gd.updateGclass(gname,gclass);
    }

    @Override
    public Goods returnGoods(String gname) {
        return gd.selectGoodsByName(gname);
    }
}
