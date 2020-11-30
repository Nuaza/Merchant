package com.EveryoneRightIsReallyTeam.Merchant.dao;

import com.EveryoneRightIsReallyTeam.Merchant.entity.Storage;

import java.util.List;

public interface StorageDao {
    List<Storage> selectAll(int id);

    int setLessNumber(int id,int gid,int numb);

    int setMoreNumber(int id,int gid,int numb);

    int initStorage(int id);

    int updateCost(double cost,int id,int gid);
}
