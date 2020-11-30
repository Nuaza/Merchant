package com.EveryoneRightIsReallyTeam.Merchant.controller;

import com.EveryoneRightIsReallyTeam.Merchant.entity.Player;
import com.EveryoneRightIsReallyTeam.Merchant.service.*;
import com.EveryoneRightIsReallyTeam.Merchant.service.impl.*;
import com.EveryoneRightIsReallyTeam.Merchant.view.character.SelectCharacter;
import com.EveryoneRightIsReallyTeam.Merchant.view.userView.UserMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class PlayerTableController implements Initializable {
    private AccountService accountService = new AccountServiceImpl();
    private ClassifyService classifyService = new ClassifyServiceImpl();
    private GoodsService goodsService = new GoodsServiceImpl();
    private PlayerService playerService = new PlayerServiceImpl();
    private ProvinceService provinceService = new ProvinceServiceImpl();
    private RegionService regionService = new RegionServiceImpl();
    private SaleService saleService = new SaleServiceImpl();
    private StorageService storageService = new StorageServiceImpl();

    private final ObservableList<Player> data = FXCollections.observableArrayList(playerService.showAll());

    private @FXML Button select;
    private @FXML TableView plist;

    private @FXML TableColumn<Player,Boolean> ColumnSelected;

    private @FXML TextField pname;
    private @FXML TableColumn<Player,String> ColumnPname;

    private @FXML TextField pcash;
    private @FXML TableColumn<Player,Double> ColumnPcash;

    private @FXML TextField pdebt;
    private @FXML TableColumn<Player,Double> ColumnPdebt;

    private @FXML TextField pdate;
    private @FXML TableColumn<Player,Date> ColumnPdate;

    private @FXML TextField pnowin;
    private @FXML TableColumn<Player,Integer> ColumnPnowin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ColumnPname.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
        ColumnPcash.setCellValueFactory(new PropertyValueFactory<Player,Double>("cash"));
        ColumnPdebt.setCellValueFactory(new PropertyValueFactory<Player,Double>("debt"));
        ColumnPdate.setCellValueFactory(new PropertyValueFactory<Player,Date>("date"));
        ColumnPnowin.setCellValueFactory(new PropertyValueFactory<Player,Integer>("nowin"));
        plist.setItems(data);
        plist.setEditable(true);

    }

    public void select(ActionEvent actionEvent) throws Exception{
        Stage stage = (Stage) select.getScene().getWindow();
        stage.close();
        UserMain open = new UserMain();
        open.start(new Stage());
    }
}
