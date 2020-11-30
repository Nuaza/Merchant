package com.EveryoneRightIsReallyTeam.Merchant.controller;

import com.EveryoneRightIsReallyTeam.Merchant.service.*;
import com.EveryoneRightIsReallyTeam.Merchant.service.impl.*;
import com.EveryoneRightIsReallyTeam.Merchant.view.about.About;
import com.EveryoneRightIsReallyTeam.Merchant.view.tableView.TablesView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class UserMainController implements Initializable {
    //定义所有Service层控件
    private AccountService accountService = new AccountServiceImpl();
    private ClassifyService classifyService = new ClassifyServiceImpl();
    private GoodsService goodsService = new GoodsServiceImpl();
    private PlayerService playerService = new PlayerServiceImpl();
    private ProvinceService provinceService = new ProvinceServiceImpl();
    private RegionService regionService = new RegionServiceImpl();
    private SaleService saleService = new SaleServiceImpl();
    private StorageService storageService = new StorageServiceImpl();

    private int id = 1; //id本应根据Player表来选择，但是实在是做不出来根据点击表格来获取id的功能
    private int day = 8;
    private int prompt = 0; //提示submit操作数

    private @FXML ImageView map;
    private @FXML Button submitBtn;
    private @FXML Label nowin;
    private @FXML Label northplace;
    private @FXML Label eastplace;
    private @FXML Label westplace;
    private @FXML Label southplace;
    private @FXML Label nowDate;
    private @FXML Label freshDay;
    private @FXML Label endDay;
    private @FXML Label cash;
    private @FXML Label debt;
    private @FXML Label freshState;
    private @FXML Label moveState;
    private @FXML TextField inputNumber;
    private @FXML TextField inputName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refresh(2);
    }

    public void about(ActionEvent actionEvent) throws Exception{
        About open = new About();
        open.start(new Stage());
    }

    public void goNorth(ActionEvent actionEvent) throws Exception{
        if(playerService.goNorth(id)==1){
//            UserMain userMain = new UserMain();
//            userMain.start(new Stage());
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            refresh(1);
                        }
                    });
                }
            },100);
        }else{
            moveState.setText("移动失败！");
        }
    }

    public void goEast(ActionEvent actionEvent) throws Exception{
        if(playerService.goEast(id)==1){
//            UserMain userMain = new UserMain();
//            userMain.start(new Stage());
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            refresh(1);
                        }
                    });
                }
            },100);
        }else{
            moveState.setText("移动失败！");
        }
    }

    public void goWest(ActionEvent actionEvent) throws Exception{
        if(playerService.goWest(id)==1){
//            UserMain userMain = new UserMain();
//            userMain.start(new Stage());
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            refresh(1);
                        }
                    });
                }
            },100);
        }else{
            moveState.setText("移动失败！");
        }
    }

    public void goSouth(ActionEvent actionEvent) throws Exception{
        if(playerService.goSouth(id)==1){
//            UserMain userMain = new UserMain();
//            userMain.start(new Stage());
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            refresh(1);
                        }
                    });
                }
            },100);
        }else{
            moveState.setText("移动失败！");
        }
    }

    public void restart(ActionEvent actionEvent) {
        playerService.newGame("Player");
        storageService.newStorage(id);
        day = 8;
        refresh(2);
    }

    public void payDebt(ActionEvent actionEvent) {
        inputNumber.setDisable(false);
        submitBtn.setDisable(false);
        inputName.setPromptText("请在上方输入金额");
        prompt = 1; //使用submit按钮，用的是1号操作
    }

    public void buy(ActionEvent actionEvent){
        inputNumber.setDisable(false);
        inputName.setDisable(false);
        submitBtn.setDisable(false);
        inputName.setPromptText("请在上方输入数量");
        inputNumber.setPromptText("请在下方输入名称");
        prompt = 2; //使用submit按钮，用的是2号操作
    }

    public void sell(ActionEvent actionEvent){
        inputNumber.setDisable(false);
        inputName.setDisable(false);
        submitBtn.setDisable(false);
        inputName.setPromptText("请在上方输入数量");
        inputNumber.setPromptText("请在下方输入名称");
        prompt = 3; //使用submit按钮，用的是3号操作
    }


    public void seeNation(ActionEvent actionEvent) throws Exception{
        TablesView tablesView = new TablesView(1);
        tablesView.start(new Stage());
    }


    public void seeLocal(ActionEvent actionEvent) throws Exception{
        TablesView tablesView = new TablesView(2,provinceService.getName(playerService.getNowin(id)));
        tablesView.start(new Stage());
    }

    public void seeStorage(ActionEvent actionEvent) throws Exception{
        TablesView tablesView = new TablesView(4);
        tablesView.start(new Stage());
    }


    public void seeSomewhere(ActionEvent actionEvent) {
        inputName.setDisable(false);
        submitBtn.setDisable(false);
        inputNumber.setPromptText("请在下方输入名称");
        prompt = 4; //使用submit按钮，用的是4号操作
    }

    public void seeSomething(ActionEvent actionEvent) {
        inputName.setDisable(false);
        submitBtn.setDisable(false);
        inputNumber.setPromptText("请在下方输入名称");
        prompt = 5; //使用submit按钮，用的是5号操作
    }

    public void submit(ActionEvent actionEvent)throws Exception{
        switch (prompt){
            case 1: //还债操作
                if(Double.parseDouble(inputNumber.getText()) <=0 ){ //判断输入是否为正数
                    freshState.setText("还债失败!请输入正确格式的金钱");
                    break;
                }
                if(playerService.payDebt(id, Double.parseDouble(inputNumber.getText())) == 0){
                    freshState.setText("还债成功!");
                    refresh(0);
                }
                else{
                    freshState.setText("还债失败！可能是金钱不足");
                }
                break;
            case 2: //购入商品操作
                if(Integer.parseInt(inputNumber.getText()) <= 0){ //判断输入是否为正数
                    freshState.setText("购买失败!请输入正确格式的商品数量");
                    break;
                }
                if(storageService.buy(id,goodsService.getGoodsID(inputName.getText()), Integer.parseInt(inputNumber.getText())) == 1){
                    freshState.setText("购买成功!");
                    refresh(0);
                }else{
                    freshState.setText("购买失败！可能是金钱不足或当地商品缺货或输入的商品名称错误");
                }
                break;
            case 3: //出售商品操作
                if(Integer.parseInt(inputNumber.getText()) <= 0){ //判断输入是否为正数
                    freshState.setText("购买失败!请输入正确格式的商品数量");
                    break;
                }
                if(storageService.sell(id,goodsService.getGoodsID(inputName.getText()), Integer.parseInt(inputNumber.getText())) == 1){
                    freshState.setText("出售成功!");
                    refresh(0);
                }else{
                    freshState.setText("出售失败！可能是您的仓库缺货或者输入的商品名称错误");
                }
                break;
            case 4: //查看某地市场
                TablesView tablesView1 = new TablesView(2,inputName.getText());
                tablesView1.start(new Stage());
                refresh(0);
                break;
            case 5: //查看某种商品
                TablesView tablesView2 = new TablesView(3,inputName.getText());
                tablesView2.start(new Stage());
                refresh(0);
                break;
        }
    }

    void refresh(int act){  //act表示刷新的程度，2表示全部刷新，1表示不刷新提示信息，0表示不刷新提示信息和市场
        if(act == 2){
            //更新提示信息
            moveState.setText("");
            freshState.setText("");
        }
        if((act == 2) || (act == 1)){
            //刷新市场
            if(day == 1){
                saleService.UpdateSale();
                freshState.setText("市场已刷新！");
                day = 8;
            }else{
                freshState.setText("市场尚未刷新");
            }
//            double random = Math.random();
//            if(random<0.10){
//                saleService.UpdateSale();
//                freshState.setText("市场已刷新！");
//            }else{
//                freshState.setText("市场尚未刷新");
//            }
            day--;
        }

        //更新左下操作区状态
        submitBtn.setDisable(true);
        inputName.setDisable(true);
        inputName.setText("");
        inputNumber.setDisable(true);
        inputNumber.setText("");
        moveState.setText("");

        //获得并显示位置信息
        nowin.setText(provinceService.getName(playerService.getNowin(id)));
        northplace.setText(provinceService.getName(provinceService.northPlace(playerService.getNowin(id))));
        eastplace.setText(provinceService.getName(provinceService.eastPlace(playerService.getNowin(id))));
        westplace.setText(provinceService.getName(provinceService.westPlace(playerService.getNowin(id))));
        southplace.setText(provinceService.getName(provinceService.southPlace(playerService.getNowin(id))));

        //获得并显示时间信息
        nowDate.setText(String.valueOf(playerService.getDate(id)));
        endDay.setText(String.valueOf(playerService.remainDate(id)));
        freshDay.setText(String.valueOf(day));

        //获得并显示账户信息
        cash.setText(String.valueOf(playerService.checkCash(id)));
        debt.setText(String.valueOf(playerService.checkDebt(id)));

        //获得并显示每个地方的地图信息
        String imageStr = "file:images/"+playerService.getNowin(id)+".png";
        map.setImage(new Image(imageStr));
    }

}
