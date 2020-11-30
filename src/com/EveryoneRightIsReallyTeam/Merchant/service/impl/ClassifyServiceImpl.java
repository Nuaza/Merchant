package com.EveryoneRightIsReallyTeam.Merchant.service.impl;

import com.EveryoneRightIsReallyTeam.Merchant.dao.ClassifyDao;
import com.EveryoneRightIsReallyTeam.Merchant.dao.impl.ClassifyDaoImpl;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Classify;
import com.EveryoneRightIsReallyTeam.Merchant.service.ClassifyService;

import java.util.List;

public class ClassifyServiceImpl implements ClassifyService {
    ClassifyDao cd = new ClassifyDaoImpl();

    @Override
    public List<Classify> showAll() {
        return cd.selectAll();
    }

    @Override
    public int newClassify(Classify classify) {
        return cd.createClassify(classify);
    }
}
