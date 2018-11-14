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
        findAllCellsNeighbours();
    }

    private void findAllCellsNeighbours() {

        for (int row = 1; row < numberOfRows - 1; row++) {
            for (int column = 1; column < numberOfColumns - 1; column++) {
                findCellsNeighbours(row, column);
            }
        }
    }

    private void findCellsNeighbours(int row, int column) {
        getCell(row, column).setNeighbours(new Cell[]{
                getCell(row - 1, column - 1), getCell(row - 1, column), getCell(row - 1, column + 1),
                getCell(row, column - 1), getCell(row, column + 1),
                getCell(row + 1, column - 1), getCell(row + 1, column), getCell(row + 1, column + 1)
        });
    }


    public Board playGame() {

        for (int row = 1; row < numberOfRows - 1; row++) {      //omitting edges
            for (int column = 1; column < numberOfColumns - 1; column++) {
                getCell(row, column).setFutureCellState();
            }
        }

        for (int row = 1; row < numberOfRows - 1; row++) {
            for (int column = 1; column < numberOfColumns - 1; column++) {

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