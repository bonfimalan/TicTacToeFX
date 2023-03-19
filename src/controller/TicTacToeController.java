package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TicTacToeController implements Initializable {
    @FXML
    private GridPane board;

    @FXML
    private Label playerOneLabel;

    @FXML
    private Label playerTwoLabel;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
