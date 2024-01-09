package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    private SceneController sceneController = new SceneController();
    @FXML
    protected void onClickStartGame(ActionEvent event) throws IOException {
        String gameMode = getGameMode();
        String mapSize = getMapSize();
        if (Objects.equals(mapSize, "19 X 19")) {
            sceneController.switchToSceneBord19(event);
        }
        else if (Objects.equals(mapSize, "13 X 13")) {
            sceneController.switchToSceneBord13(event);
        }
        else {
            sceneController.switchToSceneBord9(event);
        }

    }

    @FXML
    private ChoiceBox<String> ChoiceBoxGameMode;
    @FXML
    private ChoiceBox<String> ChoiceBoxMapSize;
    @FXML
    private Label LabelGameMode;
    @FXML
    private Label LabelMapSize;

    private String[] GameModeOptions = {"Player vs Player", "Player vs Bot"};
    private String[] MapSizeOptions = {"19 X 19", "13 X 13", "9 X 9"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChoiceBoxGameMode.getItems().addAll(GameModeOptions);
        ChoiceBoxMapSize.getItems().addAll(MapSizeOptions);
        ChoiceBoxGameMode.setOnAction(this::changeLabelGameMode);
        ChoiceBoxMapSize.setOnAction(this::changeLabelMapSize);


    }

    public void changeLabelGameMode(ActionEvent event) {
        LabelGameMode.setText(ChoiceBoxGameMode.getValue());

    }

    public void changeLabelMapSize(ActionEvent event) {
        LabelMapSize.setText(ChoiceBoxMapSize.getValue());

    }



    public String getGameMode() {
        return LabelGameMode.getText();
    }

    public String getMapSize() {
        return LabelMapSize.getText();
    }




}