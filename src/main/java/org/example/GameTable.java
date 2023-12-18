package com.example.go.GraWGo.src.main.java.org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameTable extends Application {

    private final int size;

    public GameTable(int size) {
        this.size = size;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GOTABLE " + size + "x" + size);

        Label sizeLabel = new Label("GOTABLE " + size + "x" + size);
        Button closeButton = new Button("down");
        closeButton.setOnAction(e -> {
            StartMenu startMenu = new StartMenu();
            startMenu.start(new Stage());
            primaryStage.hide();
        });

        VBox layout = new VBox(10, sizeLabel, closeButton);
        Scene scene = new Scene(layout, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
