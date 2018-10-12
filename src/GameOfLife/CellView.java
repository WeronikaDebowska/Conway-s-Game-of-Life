package GameOfLife;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class CellView extends Rectangle {
    final double SIZE = 10;
    private Color fillColor;
    int height;


    public CellView(Cell cell) {
        this.setHeight(SIZE);
        this.setWidth(SIZE);
        this.setCellColor(cell);
        this.setClickHandler(cell);
    }

    private void setClickHandler(Cell cell) {
         this.setOnMouseClicked(cell.eventHandler);
    }

    private void setCellColor(Cell cell){
        setFill((!cell.getIsAlive()) ? Color.CADETBLUE : Color.WHITE);
    }


}
