package com.EveryoneRightIsReallyTeam.Merchant.view.tableView;

import com.EveryoneRightIsReallyTeam.Merchant.entity.Player;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Sale;
import com.EveryoneRightIsReallyTeam.Merchant.entity.Storage;
import com.EveryoneRightIsReallyTeam.Merchant.service.*;
import com.EveryoneRightIsReallyTeam.Merchant.service.impl.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TablesView extends Application {
    private int act;
    private String str = null;
    public TablesView(int act){
        this.act = act;
    }
    public TablesView(int act,String str){
        this.act = act;
        this.str = str;
    }
    private GoodsService goodsService = new GoodsServiceImpl();
    private ProvinceService provinceService = new ProvinceServiceImpl();
    private SaleService saleService = new SaleServiceImpl();
    private StorageService storageService = new StorageServiceImpl();
    private TableView<SaleInfo> saleTable = new TableView<SaleInfo>();
    private TableView<StorageInfo> storageTable = new TableView<StorageInfo>();
    private final ObservableList<SaleInfo> saleData = FXCollections.observableArrayList(getSaleList(saleService.FindAll()));
    private final ObservableList<StorageInfo> storageData = FXCollections.observableArrayList(getStorageList(storageService.showAll(1)));

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Merchant");
        primaryStage.setWidth(440);
        primaryStage.setHeight(500);
        saleTable.setPrefWidth(400);
        saleTable.setEditable(false);
        storageTable.setEditable(false);
        storageTable.setEditable(false);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        if(act == 1){
            TableColumn pid = new TableColumn("位置信息");
            pid.setCellValueFactory(new PropertyValueFactory<SaleInfo,String>("pname"));
            TableColumn gid = new TableColumn("货物信息");
            gid.setCellValueFactory(new PropertyValueFactory<SaleInfo,String>("gname"));
            TableColumn realprice = new TableColumn("单个价格");
            realprice.setCellValueFactory(new PropertyValueFactory<SaleInfo,Double>("realprice"));
            TableColumn number = new TableColumn("数量");
            number.setCellValueFactory(new PropertyValueFactory<SaleInfo,Integer>("number"));
            saleTable.setItems(saleData);
            saleTable.getColumns().addAll(pid,gid,realprice,number);
            vbox.getChildren().addAll(saleTable);
        }
        else if(act == 2){
            final ObservableList<SaleInfo> saleData1 = FXCollections.observableArrayList(getSaleList(saleService.FindByProvince(str)));
            TableColumn pid = new TableColumn("位置信息");
            pid.setCellValueFactory(new PropertyValueFactory<SaleInfo,String>("pname"));
            TableColumn gid = new TableColumn("货物信息");
            gid.setCellValueFactory(new PropertyValueFactory<SaleInfo,String>("gname"));
            TableColumn realprice = new TableColumn("单个价格");
            realprice.setCellValueFactory(new PropertyValueFactory<SaleInfo,Double>("realprice"));
            TableColumn number = new TableColumn("数量");
            number.setCellValueFactory(new PropertyValueFactory<SaleInfo,Integer>("number"));
            saleTable.setItems(saleData1);
            saleTable.getColumns().addAll(pid,gid,realprice,number);
            vbox.getChildren().addAll(saleTable);
        }
        else if(act == 3){
            final ObservableList<SaleInfo> saleData1 = FXCollections.observableArrayList(getSaleList(saleService.FindByGname(str)));
            TableColumn pid = new TableColumn("位置信息");
            pid.setCellValueFactory(new PropertyValueFactory<SaleInfo,String>("pname"));
            TableColumn gid = new TableColumn("货物信息");
            gid.setCellValueFactory(new PropertyValueFactory<SaleInfo,String>("gname"));
            TableColumn realprice = new TableColumn("单个价格");
            realprice.setCellValueFactory(new PropertyValueFactory<SaleInfo,Double>("realprice"));
            TableColumn number = new TableColumn("数量");
            number.setCellValueFactory(new PropertyValueFactory<SaleInfo,Integer>("number"));
            saleTable.setItems(saleData1);
            saleTable.getColumns().addAll(pid,gid,realprice,number);
            vbox.getChildren().addAll(saleTable);
        }
        else{
            //查看仓库
            TableColumn gname = new TableColumn("货物信息");
            gname.setCellValueFactory(new PropertyValueFactory<StorageInfo,String>("gname"));
            TableColumn number = new TableColumn("数量");
            number.setCellValueFactory(new PropertyValueFactory<StorageInfo,Integer>("number"));
            TableColumn cost = new TableColumn("花费");
            cost.setCellValueFactory(new PropertyValueFactory<StorageInfo,Double>("cost"));
            TableColumn avgprice = new TableColumn("平均价格");
            avgprice.setCellValueFactory(new PropertyValueFactory<StorageInfo,Double>("avgprice"));
            storageTable.setItems(storageData);
            storageTable.getColumns().addAll(gname,number,cost,avgprice);
            vbox.getChildren().addAll(storageTable);
        }
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public List<SaleInfo> getSaleList(List<Sale> list){
        List<SaleInfo> newlist = new ArrayList<SaleInfo>();
        for(Sale data : list){
            newlist.add(new SaleInfo(provinceService.getName(data.getPid()),goodsService.getGoodsName(data.getGid()),data.getRealprice(),data.getNumber()));
        }
        return newlist;
    }
    public class SaleInfo implements Serializable{
        private String pname;
        private String gname;
        private double realprice;
        private int number;

        public SaleInfo(String pname, String gname, double realprice, int number) {
            this.pname = pname;
            this.gname = gname;
            this.realprice = realprice;
            this.number = number;
        }

        public String getPname() {
            return pname;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public String getGname() {
            return gname;
        }

        public void setGname(String gname) {
            this.gname = gname;
        }

        public double getRealprice() {
            return realprice;
        }

        public void setRealprice(double realprice) {
            this.realprice = realprice;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }

    public List<StorageInfo> getStorageList(List<Storage> list){
        List<StorageInfo> newlist = new ArrayList<StorageInfo>();
        for(Storage data : list){
            if(data.getNumber() != 0){
                newlist.add(new StorageInfo(goodsService.getGoodsName(data.getGid()),data.getNumber(),data.getCost(),data.getAvgprice()));
            }
        }
        return newlist;
    }
    public class StorageInfo implements Serializable{
        private String gname;
        private int number;
        private double cost;
        private double avgprice;

        public String getGname() {
            return gname;
        }

        public void setGname(String gname) {
            this.gname = gname;
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

        public StorageInfo(String gname, int number, double cost, double avgprice) {
            this.gname = gname;
            this.number = number;
            this.cost = cost;
            this.avgprice = avgprice;
        }
    }
}
