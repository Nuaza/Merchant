package com.EveryoneRightIsReallyTeam.Merchant.entity;

import java.io.Serializable;

public class Classify implements Serializable {
    private int cid;
    private String cname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Classify(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }
}
