package com.example.go.GraWGo.src.main.java.org.example;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChangeSizeOfTable extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Выбор размера стола");

        Button smallTableButton = new Button("9x9");
        smallTableButton.setOnAction(e -> openGameTable(primaryStage, 9));

        Button mediumTableButton = new Button("13x13");
        mediumTableButton.setOnAction(e -> openGameTable(primaryStage, 13));

        Button largeTableButton = new Button("19x19");
        largeTableButton.setOnAction(e -> openGameTable(primaryStage, 19));

        VBox layout = new VBox(10, smallTableButton, mediumTableButton, largeTableButton);
        Scene scene = new Scene(layout, 200, 150);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openGameTable(Stage primaryStage, int size) {
        GameTable gameTable = new GameTable(size);
        gameTable.start(new Stage());
        primaryStage.hide();
    }
}
