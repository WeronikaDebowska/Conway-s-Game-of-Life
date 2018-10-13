package gameOfLife;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class CellView extends Rectangle {
    private final double SIZE = 10;
    private Cell cell;
    private EventHandler<MouseEvent> eventHandler = event -> {
        cell.setIsAlive(!cell.getIsAlive());
        System.out.println("clicked");
    };

    public CellView(Cell cell) {
        this.cell = cell;
        this.setHeight(SIZE);
        this.setWidth(SIZE);
        this.updateCellColor(cell);
        this.setClickHandler();
    }

    private void setClickHandler() {
        this.setOnMouseClicked(this.eventHandler);
    }

    private void updateCellColor(Cell cell) {
        this.setFill((!cell.getIsAlive()) ? Color.CADETBLUE : Color.WHITE);
    }

}
