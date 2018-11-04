package gameOfLife.View;

import gameOfLife.Model.Cell;
import gameOfLife.Model.CellState;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


class CellView extends Rectangle {

    private Cell cell;

    CellView(Cell cell) {

        double SIZE = 10;

        this.setHeight(SIZE);
        this.setWidth(SIZE);

        this.updateCellColor(cell);

        this.setOnMouseClicked(lambda -> {
            cell.changeActualState();

            updateCellColor(cell);
        });
    }

    void updateCellColor(Cell cell) {
        this.setFill((cell.getActualCellState().equals(CellState.ALIVE)) ? Color.WHITE : Color.CADETBLUE);
    }

    public Cell getCell() {
        return cell;
    }

}
