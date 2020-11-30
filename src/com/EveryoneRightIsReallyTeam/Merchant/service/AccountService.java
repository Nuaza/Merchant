package com.EveryoneRightIsReallyTeam.Merchant.service;

import com.EveryoneRightIsReallyTeam.Merchant.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> showAll();//管理员管理专用，显示所有账户信息

    int newAccount(String name,String password);//传递一个Account参数，建立一个新的账户

    Account returnAccount(String account);//通过用户名搜索，返回一个Account账户

    int login(String account,String password);//通过输入用户名和密码来登录，返回0表示普通用户登录，返回1表示管理员用户登录，返回2表示登录失败
}
