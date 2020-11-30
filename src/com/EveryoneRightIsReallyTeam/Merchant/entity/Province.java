package com.EveryoneRightIsReallyTeam.Merchant.entity;

import java.io.Serializable;

public class Province implements Serializable {
    private int pid;
    private String pname;
    private int pregion;
    private int northp;
    private int eastp;
    private int westp;
    private int southp;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPregion() {
        return pregion;
    }

    public void setPregion(int pregion) {
        this.pregion = pregion;
    }

    public int getNorthp() {
        return northp;
    }

    public void setNorthp(int northp) {
        this.northp = northp;
    }

    public int getEastp() {
        return eastp;
    }

    public void setEastp(int eastp) {
        this.eastp = eastp;
    }

    public int getWestp() {
        return westp;
    }

    public void setWestp(int westp) {
        this.westp = westp;
    }

    public int getSouthp() {
        return southp;
    }

    public void setSouthp(int southp) {
        this.southp = southp;
    }

}
