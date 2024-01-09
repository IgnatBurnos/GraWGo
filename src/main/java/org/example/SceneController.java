package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private int window_size = 1000;

    public void switchToSceneMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view2.fxml"));
        root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneBord9(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        GuiBoard guiBoard = new GuiBoard(9, window_size / 9 - 100/9);
        scene = new Scene(guiBoard, window_size,window_size);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneBord13(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        GuiBoard guiBoard = new GuiBoard(13, window_size / 13 - 100/13);
        scene = new Scene(guiBoard, window_size,window_size);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneBord19(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        GuiBoard guiBoard = new GuiBoard(19, window_size / 19 - 100/19);
        scene = new Scene(guiBoard, window_size,window_size);
        stage.setScene(scene);
        stage.show();
    }
}
