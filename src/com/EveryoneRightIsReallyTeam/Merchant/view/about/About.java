package com.EveryoneRightIsReallyTeam.Merchant.view.about;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class About extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("about.fxml"));
        primaryStage.setTitle("关于");
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();
    }
}
