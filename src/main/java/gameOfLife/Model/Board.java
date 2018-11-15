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

        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                findCellsNeighbours(row, column);
            }
        }
    }

    private void findCellsNeighbours(int row, int column) {


        if (row == 0 && column == 0) {                           //upper left corner
            getCell(row, column).setNeighbours(new Cell[]{
                    getCell(numberOfRows - 1, numberOfColumns - 1), getCell(numberOfRows - 1, column), getCell(numberOfRows - 1, column + 1),
                    getCell(row, numberOfColumns - 1), getCell(row, column + 1),
                    getCell(row + 1, numberOfColumns - 1), getCell(row + 1, column), getCell(row + 1, column + 1)
            });
        } else if (row == 0 && column == numberOfColumns - 1) {   // upper right corner
            getCell(row, column).setNeighbours(new Cell[]{
                    getCell(numberOfRows - 1, column - 1), getCell(numberOfRows - 1, column), getCell(numberOfRows - 1, 0),
                    getCell(row, column - 1), getCell(row, 0),
                    getCell(row + 1, column - 1), getCell(row + 1, column), getCell(row + 1, 0)
            });
        } else if (row == numberOfRows - 1 && column == 0) {         //down left corner
            getCell(row, column).setNeighbours(new Cell[]{
                    getCell(row - 1, numberOfColumns - 1), getCell(row - 1, column), getCell(row - 1, column + 1),
                    getCell(row, numberOfColumns - 1), getCell(row, column + 1),
                    getCell(0, numberOfColumns - 1), getCell(0, column), getCell(0, column + 1)
            });
        } else if (row == numberOfRows - 1 && column == numberOfColumns - 1) {     //down right corner
            getCell(row, column).setNeighbours(new Cell[]{
                    getCell(row - 1, numberOfColumns - 1), getCell(row - 1, column), getCell(row - 1, 0),
                    getCell(row, numberOfColumns - 1), getCell(row, 0),
                    getCell(0, numberOfColumns - 1), getCell(0, column), getCell(0, 0)
            });
        } else if (row == 0) {                                   // upper edge
            getCell(row, column).setNeighbours(new Cell[]{
                    getCell(numberOfRows - 1, column - 1), getCell(numberOfRows - 1, column), getCell(numberOfRows - 1, column + 1),
                    getCell(row, column - 1), getCell(row, column + 1),
                    getCell(row + 1, column - 1), getCell(row + 1, column), getCell(row + 1, column + 1)
            });
        } else if (row == numberOfRows - 1) {                    // down edge
            getCell(row, column).setNeighbours(new Cell[]{
                    getCell(row - 1, column - 1), getCell(row - 1, column), getCell(row - 1, column + 1),
                    getCell(row, column - 1), getCell(row, column + 1),
                    getCell(0, column - 1), getCell(0, column), getCell(0, column + 1)
            });
        } else if (column == 0) {                                // left edge
            getCell(row, column).setNeighbours(new Cell[]{
                    getCell(row - 1, numberOfColumns - 1), getCell(row - 1, column), getCell(row - 1, column + 1),
                    getCell(row, numberOfColumns - 1), getCell(row, column + 1),
                    getCell(row + 1, numberOfColumns - 1), getCell(row + 1, column), getCell(row + 1, column + 1)
            });
        } else if (column == numberOfColumns - 1) {                  // right edge
            getCell(row, column).setNeighbours(new Cell[]{
                    getCell(row - 1, column - 1), getCell(row - 1, column), getCell(row - 1, 0),
                    getCell(row, column - 1), getCell(row, 0),
                    getCell(row + 1, column - 1), getCell(row + 1, column), getCell(row + 1, 0)
            });
        } else {
            getCell(row, column).setNeighbours(new Cell[]{
                    getCell(row - 1, column - 1), getCell(row - 1, column), getCell(row - 1, column + 1),
                    getCell(row, column - 1), getCell(row, column + 1),
                    getCell(row + 1, column - 1), getCell(row + 1, column), getCell(row + 1, column + 1)
            });
        }
    }

    private void setObserversOnNeighbours() {

        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
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

    public Cell getCell(int row, int column) {
        return generation[row][column];
    }
}
