package com.example.go.GraWGo.src.main.java.org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartMenu extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Главное окно");

        Button startButton = new Button("Start");
        startButton.setOnAction(e -> {
            ChangeSizeOfTable tableSizeSelector = new ChangeSizeOfTable();
            tableSizeSelector.start(new Stage());
            primaryStage.hide();
        });

        Scene scene = new Scene(startButton, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
