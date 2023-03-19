package controller.events;

import controller.TicTacToeController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class OnCellClickedEvent implements EventHandler<MouseEvent> {
    private int line;
    private int column;
    private TicTacToeController controller;
    private VBox eventTarget;
    private final static String RESOURCE_PATH = "/resources/";
    
    public OnCellClickedEvent(int line, int column, TicTacToeController controller, VBox eventTarget) {
        this.line = line;
        this.column = column;
        this.controller = controller;
        this.eventTarget = eventTarget;
    }


    @Override
    public void handle(MouseEvent event) {
        controller.play(line, column);
        String imagePath = controller.getGame().isPlayerOneAfterRound() ?
                RESOURCE_PATH + "x.png" :
                RESOURCE_PATH + "o.png";

        eventTarget.getChildren().setAll(
            new ImageView(new Image(imagePath, 100, 100, false, false)));
    }
    
}
