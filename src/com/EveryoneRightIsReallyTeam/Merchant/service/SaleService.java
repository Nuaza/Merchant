package com.EveryoneRightIsReallyTeam.Merchant.service;

import com.EveryoneRightIsReallyTeam.Merchant.entity.Sale;

import java.util.List;

public interface SaleService {
    int InitSale();

    int UpdateSale();

    List<Sale> FindAll();

    List<Sale> FindByProvince(String pname);

    List<Sale> FindByGname(String gname);
}
