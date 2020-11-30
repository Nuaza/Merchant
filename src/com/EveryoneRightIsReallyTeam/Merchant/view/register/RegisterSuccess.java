package com.EveryoneRightIsReallyTeam.Merchant.view.register;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterSuccess extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("registerSuccess.fxml"));
        primaryStage.setTitle("注册成功");
        primaryStage.setScene(new Scene(root, 502, 138));
        primaryStage.show();
    }
}
