package gameOfLife.Model;

public class BoardCreator {

    int cellVertically;
    Cell[][] gameBoard;
    private int cellHorizntally;
    private int padding = 1;

    public BoardCreator(int cellHorizontally, int cellVertically) {

        this.cellHorizntally = cellHorizontally;
        this.cellVertically = cellVertically;

        gameBoard = new Cell[cellHorizontally][cellVertically];
        createBoard();
    }

    private void createBoard() {
        for (int i = 0; i < cellHorizntally; i++) {
            for (int j = 0; j < cellVertically; j++) {
                gameBoard[i][j] = new Cell(i, j);
            }
        }
//
//        gameBoard[2][2].setActualCellState(CellState.ALIVE);
//        gameBoard[2][3].setActualCellState(CellState.ALIVE);
//        gameBoard[2][4].setActualCellState(CellState.ALIVE);

//        gameBoard[2][2].setFutureCellState(CellState.ALIVE);
//        gameBoard[2][3].setFutureCellState(CellState.ALIVE);
//        gameBoard[2][4].setFutureCellState(CellState.ALIVE);

//
//        gameBoard[20][2].setActualCellState(CellState.ALIVE);
//        gameBoard[20][3].setActualCellState(CellState.ALIVE);
//        gameBoard[20][4].setActualCellState(CellState.ALIVE);
//
//        gameBoard[20][2].setFutureCellState(CellState.ALIVE);
//        gameBoard[20][3].setFutureCellState(CellState.ALIVE);
//        gameBoard[20][4].setFutureCellState(CellState.ALIVE);

//        gameBoard[15][7].setActualCellState(CellState.ALIVE);
//        gameBoard[16][7].setActualCellState(CellState.ALIVE);
//        gameBoard[17][7].setActualCellState(CellState.ALIVE);
//        gameBoard[18][7].setActualCellState(CellState.ALIVE);
//        gameBoard[19][7].setActualCellState(CellState.ALIVE);
//        gameBoard[20][7].setActualCellState(CellState.ALIVE);
//        gameBoard[21][7].setActualCellState(CellState.ALIVE);
//        gameBoard[22][7].setActualCellState(CellState.ALIVE);
//
//        gameBoard[15][8].setActualCellState(CellState.ALIVE);
//        gameBoard[17][8].setActualCellState(CellState.ALIVE);
//        gameBoard[18][8].setActualCellState(CellState.ALIVE);
//        gameBoard[19][8].setActualCellState(CellState.ALIVE);
//        gameBoard[20][8].setActualCellState(CellState.ALIVE);
//        gameBoard[22][8].setActualCellState(CellState.ALIVE);
//
//
//        gameBoard[15][9].setActualCellState(CellState.ALIVE);
//        gameBoard[16][9].setActualCellState(CellState.ALIVE);
//        gameBoard[17][9].setActualCellState(CellState.ALIVE);
//        gameBoard[18][9].setActualCellState(CellState.ALIVE);
//        gameBoard[19][9].setActualCellState(CellState.ALIVE);
//        gameBoard[20][9].setActualCellState(CellState.ALIVE);
//        gameBoard[21][9].setActualCellState(CellState.ALIVE);
//        gameBoard[22][9].setActualCellState(CellState.ALIVE);
    }

    public Cell[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Cell[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public int getCellHorizontally() {
        return cellHorizntally;
    }

    public int getCellVertically() {
        return cellVertically;
    }

    public int getPadding() {
        return padding;
    }
}

