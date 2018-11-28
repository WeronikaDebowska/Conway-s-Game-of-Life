package gameOfLife.Model;

public class Cell {

    private CellState actualCellState;
    private CellState futureCellState;

    private Cell[] neighbours = new Cell[8];



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

    public void setFutureCellState() {

        boolean cellIsAlive = actualCellState.equals(CellState.ALIVE);
        int aliveNeighboursCount = 0;

        for (Cell neighbourCell : neighbours) {
            if (neighbourCell.getActualCellState().equals(CellState.ALIVE)) {
                aliveNeighboursCount++;
            }
        }

        if ((cellIsAlive && (aliveNeighboursCount == 2 || aliveNeighboursCount == 3))) {
            futureCellState = CellState.ALIVE;
        } else if (!cellIsAlive && aliveNeighboursCount == 3) {
            futureCellState = CellState.ALIVE;
        } else {
            futureCellState = CellState.DEAD;
        }
    }

    public void changeActualState() {
        if (actualCellState == CellState.DEAD) {
            actualCellState = CellState.ALIVE;
        } else {
            actualCellState = CellState.DEAD;
        }
    }

    public void setNeighbour(Cell neighbour, int index) {
        neighbours[index] = neighbour;
    }

    public Cell[] getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Cell[] neighbours) {
        this.neighbours = neighbours;
    }
}
