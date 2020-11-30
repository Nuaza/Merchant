package com.EveryoneRightIsReallyTeam.Merchant.service.impl;

import com.EveryoneRightIsReallyTeam.Merchant.dao.AccountDao;
import com.EveryoneRightIsReallyTeam.Merchant.dao.impl.AccountDaoImpl;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Account;
import com.EveryoneRightIsReallyTeam.Merchant.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    AccountDao ad = new AccountDaoImpl();

    @Override
    public List<Account> showAll() {
        return ad.selectAll();
    }

    @Override
    public int newAccount(String name,String password) {
        return ad.createAccount(name,password);
    }

    @Override
    public Account returnAccount(String account) {
        return ad.selectAccountByName(account);
    }

    @Override
    public int login(String account, String password) {
        return ad.getLogin(account,password);
    }
}
