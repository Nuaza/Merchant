package com.EveryoneRightIsReallyTeam.Merchant.entity;

import java.io.Serializable;

public class Sale implements Serializable {
    private int pid;
    private int gid;
    private double realprice;
    private int number;
    private double totalprice;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public double getRealprice() {
        return realprice;
    }

    public void setRealprice(double realprice) {
        this.realprice = realprice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public Sale(int pid, int gid, double realprice, int number, double totalprice) {
        this.pid = pid;
        this.gid = gid;
        this.realprice = realprice;
        this.number = number;
        this.totalprice = totalprice;
    }
}
