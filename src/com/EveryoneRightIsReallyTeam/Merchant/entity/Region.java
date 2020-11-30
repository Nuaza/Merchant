package com.EveryoneRightIsReallyTeam.Merchant.entity;

import java.io.Serializable;

public class Region implements Serializable {
    private int rid;
    private String rname;

    public Region(int rid, String rname) {
        this.rid = rid;
        this.rname = rname;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}
