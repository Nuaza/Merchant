package com.EveryoneRightIsReallyTeam.Merchant.view.register;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterFail extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("registerFail.fxml"));
        primaryStage.setTitle("注册失败");
        primaryStage.setScene(new Scene(root, 502, 138));
        primaryStage.show();
    }
}
