package com.EveryoneRightIsReallyTeam.Merchant.dao;

import com.EveryoneRightIsReallyTeam.Merchant.entity.Player;

import java.sql.Date;
import java.util.List;

public interface PlayerDao {
    int createPlayer(String name);

    int SelectNowinByID(int id);

    double SelectDebtByID(int id);

    double selectCash(int id);

    void updateNowinByPID(int id,int pid);

    void updateDate(int id);

    int selectDateLimit(int id);

    int selectDatediff(int id);

    int updateDebt(int id, double money);

    int getCash(int id, double money);

    int loseCash(int id, double money);

    int updateName(int id, String name);

    List<Player> selectAll();

    Date selectDate(int id);


}
