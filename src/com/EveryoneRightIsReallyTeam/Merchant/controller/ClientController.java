package com.EveryoneRightIsReallyTeam.Merchant.controller;

import com.EveryoneRightIsReallyTeam.Merchant.entity.Player;
import com.EveryoneRightIsReallyTeam.Merchant.service.*;
import com.EveryoneRightIsReallyTeam.Merchant.service.impl.*;
import com.EveryoneRightIsReallyTeam.Merchant.view.about.About;
import com.EveryoneRightIsReallyTeam.Merchant.view.character.SelectCharacter;
import com.EveryoneRightIsReallyTeam.Merchant.view.login.AdminLogin;
import com.EveryoneRightIsReallyTeam.Merchant.view.login.Login;
import com.EveryoneRightIsReallyTeam.Merchant.view.login.LoginFail;
import com.EveryoneRightIsReallyTeam.Merchant.view.login.UserLogin;
import com.EveryoneRightIsReallyTeam.Merchant.view.quit.QuitAsk;
import com.EveryoneRightIsReallyTeam.Merchant.view.register.Register;
import com.EveryoneRightIsReallyTeam.Merchant.view.register.RegisterFail;
import com.EveryoneRightIsReallyTeam.Merchant.view.register.RegisterSuccess;
import com.EveryoneRightIsReallyTeam.Merchant.view.userView.UserMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    //定义所有Service层控件
    private AccountService accountService = new AccountServiceImpl();
    private ClassifyService classifyService = new ClassifyServiceImpl();
    private GoodsService goodsService = new GoodsServiceImpl();
    private PlayerService playerService = new PlayerServiceImpl();
    private ProvinceService provinceService = new ProvinceServiceImpl();
    private RegionService regionService = new RegionServiceImpl();
    private SaleService saleService = new SaleServiceImpl();
    private StorageService storageService = new StorageServiceImpl();


    //与FXML中控件绑定
    private @FXML Button closeButton;
    private @FXML PasswordField setPassword;
    private @FXML PasswordField getPassword;
    private @FXML TextField setUsername;
    private @FXML TextField getUsername;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void quitask(ActionEvent actionEvent) throws Exception{
        QuitAsk open = new QuitAsk();
        open.start(new Stage());
    }

    public void about(ActionEvent actionEvent) throws Exception{
        About open = new About();
        open.start(new Stage());
    }

    public void quit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void register(ActionEvent actionEvent)throws Exception{
        Register open = new Register();
        open.start(new Stage());
    }

    public void registerJudge(ActionEvent actionEvent) throws Exception{
        if(accountService.newAccount(setUsername.getText(),setPassword.getText()) != 0){    //注册成功
            //关闭当前窗口
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
            //展示一个登录窗口
            Login login = new Login();
            login.start(new Stage());
            //提示注册成功
            RegisterSuccess registerSuccess = new RegisterSuccess();
            registerSuccess.start(new Stage());
        }else{      //注册失败
            RegisterFail open = new RegisterFail();
            open.start(new Stage());
        }
    }

    public void login(ActionEvent actionEvent) throws Exception{
        Login open = new Login();
        open.start(new Stage());
    }

    public void loginJudge(ActionEvent actionEvent) throws Exception{
        Stage stage = (Stage) closeButton.getScene().getWindow();
        switch (accountService.login(getUsername.getText(),getPassword.getText())){
            case 0:     //普通用户登录
                stage.close();
                UserLogin userLogin = new UserLogin();
                userLogin.start(new Stage());
                break;
            case 1:     //管理员用户登录
                stage.close();
                AdminLogin adminLogin = new AdminLogin();
                adminLogin.start(new Stage());
                break;
            default:    //登录失败
                LoginFail loginFail = new LoginFail();
                loginFail.start(new Stage());
        }
    }

    public void chooseCharacter(ActionEvent actionEvent) throws Exception{
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        SelectCharacter open = new SelectCharacter();
        open.start(new Stage());
    }

    public void adminGame(ActionEvent actionEvent) {
    }
}
