package com.EveryoneRightIsReallyTeam.Merchant.view.character;

import com.EveryoneRightIsReallyTeam.Merchant.entity.Player;
import com.EveryoneRightIsReallyTeam.Merchant.service.PlayerService;
import com.EveryoneRightIsReallyTeam.Merchant.service.ProvinceService;
import com.EveryoneRightIsReallyTeam.Merchant.service.impl.PlayerServiceImpl;
import com.EveryoneRightIsReallyTeam.Merchant.service.impl.ProvinceServiceImpl;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.Date;

//这个类已经废了，真的做不出来选择角色的界面QAQ
public class SelectCharacter extends Application {
    private PlayerService playerService = new PlayerServiceImpl();
    private ProvinceService provinceService = new ProvinceServiceImpl();
    private TableView<Player> table = new TableView<Player>();
    private final ObservableList<Player> data = FXCollections.observableArrayList(playerService.showAll());

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("selectCharacter.fxml"));
        primaryStage.setTitle("Merchant");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
//        table.setEditable(false);
//
//        TableColumn playername = new TableColumn("姓名");
//        playername.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
//        TableColumn playercash = new TableColumn("现金");
//        playercash.setCellValueFactory(new PropertyValueFactory<Player,Double>("cash"));
//        TableColumn playerdebt = new TableColumn("债务");
//        playerdebt.setCellValueFactory(new PropertyValueFactory<Player,Double>("debt"));
//        TableColumn playerdate = new TableColumn("日期");
//        playerdate.setCellValueFactory(new PropertyValueFactory<Player,Date>("date"));
//        TableColumn activity = new TableColumn("操作");
//
//        table.setItems(data);
//        table.getColumns().addAll(playername,playercash,playerdebt,playerdate,activity);
//
//        final VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(10, 0, 0, 10));
//        vbox.getChildren().addAll(label, table);
//
//        ((Group) scene.getRoot()).getChildren().addAll(vbox);
//
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }
}
