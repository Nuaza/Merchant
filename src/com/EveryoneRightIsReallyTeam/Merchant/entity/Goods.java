package com.EveryoneRightIsReallyTeam.Merchant.entity;

import java.io.Serializable;

public class Goods implements Serializable {
    private int gid;
    private String gname;
    private double gprice;
    private int gclass;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public int getGclass() {
        return gclass;
    }

    public void setGclass(int gclass) {
        this.gclass = gclass;
    }

    public Goods(int gid, String gname, double gprice, int gclass) {
        this.gid = gid;
        this.gname = gname;
        this.gprice = gprice;
        this.gclass = gclass;
    }
}
