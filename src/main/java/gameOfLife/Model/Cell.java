package main.java.gameOfLife.Model;

public class Cell {

    private CellState actualCellState;
    private CellState futureCellState;

    Cell() {
        this.actualCellState = CellState.DEAD;
        this.futureCellState = CellState.DEAD;
    }

    public CellState getActualCellState() {
        return actualCellState;
    }

    public void setActualCellState(CellState actualCellState) {
        this.actualCellState = actualCellState;
    }

    public CellState getFutureCellState() {
        return futureCellState;
    }

    public void setFutureCellState(CellState futureCellState) {
        this.futureCellState = futureCellState;
    }

    public void changeActualState() {
        if (actualCellState == CellState.DEAD) {
            actualCellState = CellState.ALIVE;
        } else {
            actualCellState = CellState.DEAD;
        }
    }
}
