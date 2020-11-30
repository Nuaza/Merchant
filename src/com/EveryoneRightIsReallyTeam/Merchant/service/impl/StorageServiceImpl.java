package com.EveryoneRightIsReallyTeam.Merchant.service.impl;

import com.EveryoneRightIsReallyTeam.Merchant.dao.PlayerDao;
import com.EveryoneRightIsReallyTeam.Merchant.dao.SaleDao;
import com.EveryoneRightIsReallyTeam.Merchant.dao.StorageDao;
import com.EveryoneRightIsReallyTeam.Merchant.dao.impl.PlayerDaoImpl;
import com.EveryoneRightIsReallyTeam.Merchant.dao.impl.SaleDaoImpl;
import com.EveryoneRightIsReallyTeam.Merchant.dao.impl.StorageDaoImpl;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Storage;
import com.EveryoneRightIsReallyTeam.Merchant.service.StorageService;

import java.util.List;

public class StorageServiceImpl implements StorageService {
    PlayerDao pd = new PlayerDaoImpl();
    SaleDao sad = new SaleDaoImpl();
    StorageDao std = new StorageDaoImpl();
    @Override
    public List<Storage> showAll(int id) {
        return std.selectAll(id);
    }

    @Override
    public int newStorage(int id) {
        return std.initStorage(id);
    }

    @Override
    public int buy(int id, int gid,int number) {
        double spend = sad.getMoneyByNumber(pd.SelectNowinByID(id),gid,number); //计算出购买所需花费
        if(pd.selectCash(id) < spend){      //如果所持金钱少于所需花费，则购买失败
            return 0;
        }
        if(pd.loseCash(id,spend) == 1){     //所处金钱多于所需花费，则可以购买。先扣除用户金钱
            double cost = sad.setLessNumber(pd.SelectNowinByID(id),gid,number);     //这个用来扣除当地市场所对应商品的数量
            if(cost != 0){
                if(std.setMoreNumber(id,gid,number) == 1){
                    std.updateCost(cost,id,gid);
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override
    public int sell(int id, int gid, int number) {
        if(std.setLessNumber(id,gid,number) == 1){
            std.updateCost(-(sad.setMoreNumber(pd.SelectNowinByID(id),gid,number)),id,gid);
            pd.getCash(id,sad.getMoneyByNumber(pd.SelectNowinByID(id),gid,number));
            return 1;
        }
        return 0;
    }
}
