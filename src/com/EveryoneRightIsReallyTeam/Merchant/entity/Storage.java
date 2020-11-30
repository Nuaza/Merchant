package com.EveryoneRightIsReallyTeam.Merchant.entity;

import java.io.Serializable;

public class Storage implements Serializable {
    private int id;
    private int gid;
    private int number;
    private double cost;
    private double avgprice;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getAvgprice() {
        return avgprice;
    }

    public void setAvgprice(double avgprice) {
        this.avgprice = avgprice;
    }

    public Storage(int id,int gid, int number, double cost, double avgprice) {
        this.id = id;
        this.gid = gid;
        this.number = number;
        this.cost = cost;
        this.avgprice = avgprice;
    }
}
