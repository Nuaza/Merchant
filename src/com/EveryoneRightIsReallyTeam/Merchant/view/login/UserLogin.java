package com.EveryoneRightIsReallyTeam.Merchant.view.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserLogin extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("userLogin.fxml"));
        primaryStage.setTitle("用户登录成功");
        primaryStage.setScene(new Scene(root, 502, 138));
        primaryStage.show();
    }
}
