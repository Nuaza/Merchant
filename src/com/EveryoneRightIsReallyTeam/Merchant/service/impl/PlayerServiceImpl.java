package com.EveryoneRightIsReallyTeam.Merchant.service.impl;

import com.EveryoneRightIsReallyTeam.Merchant.dao.PlayerDao;
import com.EveryoneRightIsReallyTeam.Merchant.dao.ProvinceDao;
import com.EveryoneRightIsReallyTeam.Merchant.dao.impl.PlayerDaoImpl;
import com.EveryoneRightIsReallyTeam.Merchant.dao.impl.ProvinceDaoImpl;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Player;
import com.EveryoneRightIsReallyTeam.Merchant.service.PlayerService;

import java.sql.Date;
import java.util.List;

public class PlayerServiceImpl implements PlayerService {
    PlayerDao pld = new PlayerDaoImpl();
    ProvinceDao pod = new ProvinceDaoImpl();

    @Override
    public List<Player> showAll() {
        return pld.selectAll();
    }

    @Override
    public int newGame(String name) {
        return pld.createPlayer(name);
    }

    @Override
    public int goNorth(int id) {
        int pid = pld.SelectNowinByID(id);
        int destination = pod.getNorthp(pid);
        if(destination != 0){
            pld.updateNowinByPID(id,destination);
            pld.updateDate(id);
            return 1;
        }
        return 0;
    }

    @Override
    public int goEast(int id) {
        int pid = pld.SelectNowinByID(id);
        int destination = pod.getEastp(pid);
        if(destination != 0){
            pld.updateNowinByPID(id,destination);
            pld.updateDate(id);
            return 1;
        }
        return 0;
    }

    @Override
    public int goWest(int id) {
        int pid = pld.SelectNowinByID(id);
        int destination = pod.getWestp(pid);
        if(destination != 0){
            pld.updateNowinByPID(id,destination);
            pld.updateDate(id);
            return 1;
        }
        return 0;
    }

    @Override
    public int goSouth(int id) {
        int pid = pld.SelectNowinByID(id);
        int destination = pod.getSouthp(pid);
        if(destination != 0){
            pld.updateNowinByPID(id,destination);
            pld.updateDate(id);
            return 1;
        }
        return 0;
    }

    @Override
    public void addDate(int id) {
        pld.updateDate(id);
    }

    @Override
    public int getNowin(int id) {
        return pld.SelectNowinByID(id);
    }

    @Override
    public Date getDate(int id) {
        return pld.selectDate(id);
    }

    @Override
    public int changeName(int id, String name) {
        return pld.updateName(id,name);
    }

    @Override
    public int checkDate(int id) {
        return pld.selectDateLimit(id);
    }

    @Override
    public double checkCash(int id) {
        return pld.selectCash(id);
    }

    @Override
    public double checkDebt(int id) {
        return pld.SelectDebtByID(id);
    }

    @Override
    public int remainDate(int id) {
        return pld.selectDatediff(id);
    }

    @Override
    public int payDebt(int id, double money) {
        return pld.updateDebt(id,money);
    }
}
