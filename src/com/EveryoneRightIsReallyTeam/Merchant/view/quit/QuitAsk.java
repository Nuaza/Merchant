package com.EveryoneRightIsReallyTeam.Merchant.view.quit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class QuitAsk extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("quitask.fxml"));
        primaryStage.setTitle("提示");
        primaryStage.setScene(new Scene(root, 502, 138));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
