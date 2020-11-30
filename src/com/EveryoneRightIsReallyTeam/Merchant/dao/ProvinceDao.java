package com.EveryoneRightIsReallyTeam.Merchant.dao;

public interface ProvinceDao {
    int getNorthp(int pid);

    int getEastp(int pid);

    int getWestp(int pid);

    int getSouthp(int pid);

    String selectNameByID(int pid);
}
