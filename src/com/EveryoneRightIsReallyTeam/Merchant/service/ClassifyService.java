package com.EveryoneRightIsReallyTeam.Merchant.service;

import com.EveryoneRightIsReallyTeam.Merchant.entity.Classify;

import java.util.List;

public interface ClassifyService {
    List<Classify> showAll();//管理员管理专用，显示所有商品类别

    int newClassify(Classify classify);//管理员管理专用，新建一个分类
}
