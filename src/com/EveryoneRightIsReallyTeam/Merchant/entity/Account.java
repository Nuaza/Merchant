package com.EveryoneRightIsReallyTeam.Merchant.entity;

import java.io.Serializable;

public class Account implements Serializable {
    private int pid;
    private String account;
    private String password;
    private int classify;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }

    public Account(String account,String password,int classify) {
        this.account = account;
        this.password = password;
        this.classify = classify;
    }

    public Account(int pid, String account) {
        this.pid = pid;
        this.account = account;
    }
}
