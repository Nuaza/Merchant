package com.EveryoneRightIsReallyTeam.Merchant.service;

public interface ProvinceService {
    int northPlace(int pid);    //获得某地北方位置的id

    int eastPlace(int pid);    //获得某地东方位置的id

    int westPlace(int pid);    //获得某地西方位置的id

    int southPlace(int pid);    //获得某地南方位置的id

    String getName(int pid);    //获得某地的名称
}
