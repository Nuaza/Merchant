package com.EveryoneRightIsReallyTeam.Merchant.entity;

import java.io.Serializable;
import java.sql.Date;

public class Player implements Serializable {
    private int id;
    private String name;
    private double cash;
    private double debt;
    private Date date;
    private Date limit;
    private int nowin;

    private boolean selected = false;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNowin() {
        return nowin;
    }

    public void setNowin(int nowin) {
        this.nowin = nowin;
    }

    public Date getLimit() {
        return limit;
    }

    public void setLimit(Date limit) {
        this.limit = limit;
    }

    public Player(int id, String name, double cash, double debt, Date date, Date limit, int nowin) {
        this.id = id;
        this.name = name;
        this.cash = cash;
        this.debt = debt;
        this.date = date;
        this.limit = limit;
        this.nowin = nowin;
    }
}
