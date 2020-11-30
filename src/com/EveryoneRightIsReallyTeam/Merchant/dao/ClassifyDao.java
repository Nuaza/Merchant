package com.EveryoneRightIsReallyTeam.Merchant.dao;

import com.EveryoneRightIsReallyTeam.Merchant.entity.Classify;

import java.util.List;

public interface ClassifyDao {
    List<Classify> selectAll();

    int createClassify(Classify classify);
}
