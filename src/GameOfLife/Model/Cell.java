package gameOfLife.Model;

import java.util.Observable;
import java.util.Observer;

public class Cell extends Observable implements Observer {

    private CellState actualCellState;
    private CellState futureCellState;

    private int row;
    private int column;

    Cell(int row, int column) {
        this.actualCellState = CellState.DEAD;
        this.futureCellState = CellState.DEAD;
        this.row = row;
        this.column = column;
    }

    public CellState getActualCellState() {
        return actualCellState;
    }

    public CellState getFutureCellState() {
        return futureCellState;
    }

    public void setFutureCellState(CellState futureCellState) {
        this.futureCellState = futureCellState;
    }

    public void setActualCellState(CellState actualCellState) {
        this.actualCellState = actualCellState;
    }

    public void changeActualState() {
        if (actualCellState == CellState.DEAD) {
            actualCellState = CellState.ALIVE;
        } else {
            actualCellState = CellState.DEAD;
        }
    }

    void changeFutureState() {
        if (actualCellState == CellState.DEAD) {
            futureCellState = CellState.ALIVE;
        } else {
            futureCellState = CellState.DEAD;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("OBS");
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}