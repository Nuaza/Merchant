package com.EveryoneRightIsReallyTeam.Merchant.test;

import com.EveryoneRightIsReallyTeam.Merchant.service.SaleService;
import com.EveryoneRightIsReallyTeam.Merchant.service.impl.SaleServiceImpl;

public class InitSale {
    public static void main(String[] args) {
        //测试用，刷新一下市场
        SaleService saleService = new SaleServiceImpl();
        saleService.InitSale();
    }
}
