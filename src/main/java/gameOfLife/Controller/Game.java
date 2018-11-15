package gameOfLife.Controller;

import gameOfLife.Model.Board;
import gameOfLife.Model.Cell;
import gameOfLife.Model.CellState;

public class Game {

    private Board currentGeneration;

    private int numberOfRows;
    private int numberOfColumns;


    public Game(Board generation) {
        currentGeneration = generation;
        numberOfRows = currentGeneration.getNumberOfRows();
        numberOfColumns = currentGeneration.getNumberOfColumns();
    }


    public Board playGame() {

        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                getCell(row, column).setFutureCellState();
            }
        }

        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {

                getCell(row, column).setActualCellState(getCell(row, column).getFutureCellState());
                getCell(row, column).setFutureCellState(CellState.DEAD);
            }
        }
        return currentGeneration;
    }

    private Cell getCell(int row, int column) {
        return currentGeneration.getCell(row, column);
    }

}