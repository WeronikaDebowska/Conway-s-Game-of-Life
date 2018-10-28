package gameOfLife;

import java.util.Observable;
import java.util.Observer;

public class Cell extends Observable implements Observer {

//    private boolean isAlive;

    private CellState actualCellState;
    private CellState futureCellState;
    private Game game;
//    private Cell[] neighbours;

    public Cell() {
        this.actualCellState = CellState.DEAD;

    }

    public CellState getActualCellState() {
        return actualCellState;
    }

    public void setActualCellState(CellState actualCellState) {
        this.actualCellState = actualCellState;
        this.futureCellState = actualCellState;
    }

    void changeState() {
        if (actualCellState == CellState.DEAD) {
            futureCellState = CellState.ALIVE;
        } else {
            futureCellState = CellState.DEAD;
        }
        setChanged();
        notifyObservers();
        clearChanged();
    }

    private boolean shouldChangeState() {
        return true;
    }


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("OBS");
        if (shouldChangeState()) {
            changeState();
        }
    }
}