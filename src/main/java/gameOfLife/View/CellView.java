package gameOfLife.View;

import gameOfLife.Model.Cell;
import gameOfLife.Model.CellState;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class CellView extends Rectangle {

    CellView(Cell cell) {

        double SIZE = 9;

        this.setHeight(SIZE);
        this.setWidth(SIZE);

        this.updateCellColor(cell);

        this.setOnMouseClicked(lambda -> {
            cell.bringToLife();
            updateCellColor(cell);
        });
    }

    void updateCellColor(Cell cell) {
        this.setFill((cell.getActualCellState().equals(CellState.ALIVE)) ? Color.WHITE : Color.CADETBLUE);
    }
}
