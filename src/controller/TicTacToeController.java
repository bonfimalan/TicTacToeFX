package controller;

import static game.TicTacToe.BOARD_SIZE;

import java.net.URL;
import java.util.ResourceBundle;

import controller.events.OnCellClickedEvent;
import game.CellFiledException;
import game.TicTacToe;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TicTacToeController implements Initializable {
    @FXML
    private GridPane board;
    @FXML
    private Label playerOneLabel;
    @FXML
    private Label playerTwoLabel;

    private int cont = 0;
    private VBox[][] cells = new VBox[BOARD_SIZE][BOARD_SIZE];
    private TicTacToe game = new TicTacToe();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addAndConfigureCells();
        this.playerOneLabel.setVisible(game.isPlayerOne());
        this.playerTwoLabel.setVisible(!game.isPlayerOne());
    }

    private void addAndConfigureCells () {
        for(int i = 0; i < BOARD_SIZE; i++) {
            for(int j = 0; j < BOARD_SIZE; j++) {
                cells[i][j] = new VBox();
                VBox cell = cells[i][j];
                cell.setOnMouseClicked(new OnCellClickedEvent(i, j, this, cell));
                cell.setAlignment(Pos.CENTER);
                board.add(cell, i, j);
            }
        }
    }

    public void play(int line, int column) {
        try {
            toggleLabels();
            if(game.play(line, column)) {
                showFinishGameStage();
            } else {
                cont++;
                if (cont == 9) { 
                    showFinishGameStage();
                }
            }
        } catch (CellFiledException e) { System.out.println("bbbb");}
    }
    

    private void showFinishGameStage() {
        Label endLabel;
        if (cont == 9) {
            endLabel = new Label("Draw");
        }
        else {
            endLabel = game.isPlayerOneAfterRound() ? new Label("Player one won") : new Label("Player two won");
        }
        VBox vBox = new VBox(10, endLabel);
        vBox.setPrefSize(300, 200);
        vBox.setAlignment(Pos.CENTER);

        Stage stage = new Stage();
        stage.setScene(new Scene(vBox));
        stage.show();

        stage.setOnCloseRequest(event -> reset());
    }

    private void reset() {
        this.cont = 0;
        this.game = new TicTacToe();
        for(VBox[] cellsLine : cells) {
            for(VBox cell : cellsLine) {
                cell.getChildren().clear();
            }
        }
    }

    public TicTacToe getGame() {
        return this.game;
    }

    private void toggleLabels() {
        this.playerOneLabel.setVisible(game.isPlayerOneAfterRound());
        this.playerTwoLabel.setVisible(!game.isPlayerOneAfterRound());
    }
}
