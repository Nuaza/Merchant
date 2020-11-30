package com.EveryoneRightIsReallyTeam.Merchant.service.impl;

import com.EveryoneRightIsReallyTeam.Merchant.dao.ProvinceDao;
import com.EveryoneRightIsReallyTeam.Merchant.dao.impl.ProvinceDaoImpl;
import com.EveryoneRightIsReallyTeam.Merchant.service.ProvinceService;

public class ProvinceServiceImpl implements ProvinceService {
    ProvinceDao pd = new ProvinceDaoImpl();
    @Override
    public int northPlace(int pid) {
        return pd.getNorthp(pid);
    }

    @Override
    public int eastPlace(int pid) {
        return pd.getEastp(pid);
    }

    @Override
    public int westPlace(int pid) {
        return pd.getWestp(pid);
    }

    @Override
    public int southPlace(int pid) {
        return pd.getSouthp(pid);
    }

    @Override
    public String getName(int pid) {
        return pd.selectNameByID(pid);
    }
}
