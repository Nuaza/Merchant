package com.EveryoneRightIsReallyTeam.Merchant.view.register;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Register extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        primaryStage.setTitle("用户注册");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
