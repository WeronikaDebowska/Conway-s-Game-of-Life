package gameOfLife.Model;

import gameOfLife.Controller.Game;

import java.util.Observable;
import java.util.Observer;

public class Cell extends Observable implements Observer {

    private CellState actualCellState;
    private CellState futureCellState;

    private Cell[] neighbours = new Cell[8];

    private Game game;


    Cell() {
        actualCellState = CellState.DEAD;
        futureCellState = CellState.DEAD;
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
            if (neighbourCell.actualCellState.equals(CellState.ALIVE)) {
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

    public boolean stateChanges() {
        return !(actualCellState.equals(futureCellState));
    }

    public void notifyAllCellsObserving() {
        setChanged();
        notifyObservers();
        clearChanged();

    }

    public void changeActualState() {
        if (actualCellState == CellState.DEAD) {
            actualCellState = CellState.ALIVE;
        } else {
            actualCellState = CellState.DEAD;
        }
    }

    public void bringToLife() {
        changeActualState();
        game.getCellsToBeCheckedInThisGeneration().add(this);
        for (Cell clickedCellNeighbour : neighbours) {
            game.getCellsToBeCheckedInThisGeneration().add(clickedCellNeighbour);
        }
    }

    public Cell[] getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Cell[] neighbours) {
        this.neighbours = neighbours;
    }

    public void setNeighbour(Cell neighbour, int index) {
        neighbours[index] = neighbour;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void update(Observable o, Object arg) {
        game.getCellsToBeCheckedInNextGeneration().add(this);
    }
}
