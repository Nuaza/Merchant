package com.EveryoneRightIsReallyTeam.Merchant.service;

import com.EveryoneRightIsReallyTeam.Merchant.entity.Storage;

import java.util.List;

public interface StorageService {
    List<Storage> showAll(int id);

    int newStorage(int id);

    int buy(int id,int gid,int number);

    int sell(int id,int gid,int number);
}
