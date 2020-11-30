package com.EveryoneRightIsReallyTeam.Merchant.view.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminLogin extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("adminLogin.fxml"));
        primaryStage.setTitle("管理员登录成功");
        primaryStage.setScene(new Scene(root, 502, 138));
        primaryStage.show();
    }
}
