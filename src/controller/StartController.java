package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class StartController implements Initializable {
    @FXML
    private Button buttonStart;
    @FXML
    private VBox root;

    public StartController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonStart.setOnAction(event -> loadGameScene());
    }

    private void loadGameScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/tic-tc-toe-view.fxml"));
            loader.setController(new TicTacToeController());
            root.getChildren().setAll((Node) loader.load());
        } catch (IOException e) { }
    }
}
