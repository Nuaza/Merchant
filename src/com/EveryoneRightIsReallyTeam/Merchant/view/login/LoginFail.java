package com.EveryoneRightIsReallyTeam.Merchant.view.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginFail extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("loginfail.fxml"));
        primaryStage.setTitle("登录失败!");
        primaryStage.setScene(new Scene(root, 502, 138));
        primaryStage.show();
    }
}
