package gameOfLife.Model;

public class Board {

    private int numberOfRows;
    private int numberOfColumns;
    private Cell[][] generation;

    public Board(int numberOfRows, int numberOfColumns) {

        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;

        generation = new Cell[numberOfRows][numberOfColumns];
        createBoard();
    }

    private void createBoard() {
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                generation[row][column] = new Cell();
            }
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
