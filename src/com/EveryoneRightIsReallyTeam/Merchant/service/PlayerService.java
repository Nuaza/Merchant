package com.EveryoneRightIsReallyTeam.Merchant.service;

import com.EveryoneRightIsReallyTeam.Merchant.entity.Player;

import java.sql.Date;
import java.util.List;

public interface PlayerService {
    List<Player> showAll();

    int newGame(String name);

    int goNorth(int id);    //返回1表示向北移动成功，同时时间加1天。否则移动失败

    int goEast(int id);    //返回1表示向东移动成功，同时时间加1天。否则移动失败

    int goWest(int id);    //返回1表示向西移动成功，同时时间加1天。否则移动失败

    int goSouth(int id);    //返回1表示向南移动成功，同时时间加1天。否则移动失败

    void addDate(int id);   //时间加1天，一般不单独用

    int getNowin(int id);   //获得玩家现在所在位置，一般不单独用

    Date getDate(int id);   //获得当前时间

    int changeName(int id, String name);    //更改玩家名称

    int checkDate(int id);//返回1表示还未到limit时间，返回0表示时间已到，开始检查债务是否为0。如果为0则游戏成功，否则游戏失败！

    double checkCash(int id);//返回现金

    double checkDebt(int id);//返回债务

    int remainDate(int id);//返回剩余日期

    int payDebt(int id,double money);//返回0表示还债成功，返回1表示还债失败
}
