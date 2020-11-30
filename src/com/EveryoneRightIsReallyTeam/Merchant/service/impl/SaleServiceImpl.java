package com.EveryoneRightIsReallyTeam.Merchant.service.impl;

import com.EveryoneRightIsReallyTeam.Merchant.dao.SaleDao;
import com.EveryoneRightIsReallyTeam.Merchant.dao.impl.SaleDaoImpl;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Sale;
import com.EveryoneRightIsReallyTeam.Merchant.service.SaleService;

import java.util.List;

public class SaleServiceImpl implements SaleService {
    SaleDao sd = new SaleDaoImpl();
    @Override
    public int InitSale() {
        return sd.InitAll();
    }

    @Override
    public int UpdateSale() {
        return sd.UpdateAll();
    }

    @Override
    public List<Sale> FindAll() {
        return sd.SelectAll();
    }

    @Override
    public List<Sale> FindByProvince(String pname) {
        return sd.SelectByPname(pname);
    }

    @Override
    public List<Sale> FindByGname(String gname) {
        return sd.SelectByGname(gname);
    }
}
