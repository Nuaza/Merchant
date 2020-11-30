package com.EveryoneRightIsReallyTeam.Merchant.dao;

import com.EveryoneRightIsReallyTeam.Merchant.entity.Account;

import java.util.List;

public interface AccountDao {
    List<Account> selectAll();

    int createAccount(String name,String password);

    Account selectAccountByName(String account);

    int getLogin(String account,String password);
}
