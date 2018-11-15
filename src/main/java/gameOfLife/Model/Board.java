package gameOfLife.Model;

import java.util.LinkedList;

public class Board {

    private int numberOfRows;
    private int numberOfColumns;

    private Cell[][] generation;

//    private LinkedList<Cell> cellsToBeChecked = new LinkedList<>();

    public Board(int numberOfRows, int numberOfColumns) {

        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;

        generation = new Cell[numberOfRows][numberOfColumns];
        createBoard();
        findAllCellsNeighbours();
        setObserversOnNeighbours();
    }

    private void createBoard() {
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                generation[row][column] = new Cell();
            }
        }
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

    private void setObserversOnNeighbours() {

        for (int row = 1; row < numberOfRows - 1; row++) {
            for (int column = 1; column < numberOfColumns - 1; column++) {
                addCellAsNeighboursObserver(row, column);
            }
        }
    }

    private void addCellAsNeighboursObserver(int row, int column) {

        Cell observerToBe = getCell(row, column);

        for (Cell neighbour : observerToBe.getNeighbours()) {
            neighbour.addObserver(observerToBe);
        }
    }



    public Cell[][] getGeneration() {
        return generation;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public Cell getCell(int column, int row) {
        return generation[column][row];
    }
}
