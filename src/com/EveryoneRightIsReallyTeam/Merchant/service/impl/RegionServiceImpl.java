package com.EveryoneRightIsReallyTeam.Merchant.service.impl;

import com.EveryoneRightIsReallyTeam.Merchant.dao.RegionDao;
import com.EveryoneRightIsReallyTeam.Merchant.dao.impl.RegionDaoImpl;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Region;
import com.EveryoneRightIsReallyTeam.Merchant.service.RegionService;

public class RegionServiceImpl implements RegionService {
    RegionDao rd = new RegionDaoImpl();
    @Override
    public int newRegion(Region region) {
        return rd.createRegion(region);
    }
}
