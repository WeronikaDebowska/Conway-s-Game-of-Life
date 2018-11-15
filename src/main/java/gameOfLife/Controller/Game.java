package gameOfLife.Controller;

import gameOfLife.Model.Board;
import gameOfLife.Model.Cell;
import gameOfLife.Model.CellState;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Game {

    private Board currentGeneration;

    private int numberOfRows;
    private int numberOfColumns;

    private static Set<Cell> cellsToBeCheckedInThisGeneration = new HashSet<>();
    private static Set<Cell> cellsToBeCheckedInNextGeneration = new HashSet<>();

    public Game(Board generation) {
        currentGeneration = generation;
        numberOfRows = currentGeneration.getNumberOfRows();
        numberOfColumns = currentGeneration.getNumberOfColumns();
    }

    public static Set<Cell> getCellsToBeCheckedInThisGeneration() {
        return cellsToBeCheckedInThisGeneration;
    }

    private Cell getCell(int row, int column) {
        return currentGeneration.getCell(row, column);
    }

    public static Set<Cell> getCellsToBeCheckedInNextGeneration() {
        return cellsToBeCheckedInNextGeneration;
    }

    public Board playGame() {

        for (Cell cellToBeChecked : cellsToBeCheckedInThisGeneration) {
            cellToBeChecked.setFutureCellState();
            if (cellToBeChecked.stateChanges()) {
                cellToBeChecked.notifyAllCellsObserving();
            }
        }

        for (Cell cellToBeChecked : cellsToBeCheckedInThisGeneration) {
            cellToBeChecked.setActualCellState(cellToBeChecked.getFutureCellState());
            cellToBeChecked.setFutureCellState(CellState.DEAD);
        }

        cellsToBeCheckedInThisGeneration.clear();
        cellsToBeCheckedInThisGeneration.addAll(cellsToBeCheckedInNextGeneration);

        cellsToBeCheckedInNextGeneration.clear();

        return currentGeneration;
    }

    public Set<Cell> getCellsToBeChecked() {
        return cellsToBeCheckedInThisGeneration;
    }

    public void setCellsToBeChecked(Set<Cell> cellsToBeChecked) {
        this.cellsToBeCheckedInThisGeneration = cellsToBeChecked;
    }

}