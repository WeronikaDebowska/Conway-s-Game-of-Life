package gameOfLife;

public class BoardCreator {

    int cellVertically;
    private int cellHorizntally;

    Cell[][] gameBoard;

    public BoardCreator(int cellHorizntally, int cellVertically) {

        this.cellHorizntally = cellHorizntally;
        this.cellVertically = cellVertically;

        gameBoard = new Cell[cellHorizntally][cellVertically];
        createBoard();
    }

    private void createBoard() {
        for (int i = 0; i < cellHorizntally; i++) {
            for (int j = 0; j < cellVertically; j++) {
                gameBoard[i][j] = new Cell();
            }
        }

//        gameBoard[2][2].setActualCellState(CellState.ALIVE);
//        gameBoard[2][3].setActualCellState(CellState.ALIVE);
//        gameBoard[2][4].setActualCellState(CellState.ALIVE);
//        gameBoard[2][5].setActualCellState(CellState.ALIVE);
        gameBoard[15][7].setActualCellState(CellState.ALIVE);
        gameBoard[16][7].setActualCellState(CellState.ALIVE);
        gameBoard[17][7].setActualCellState(CellState.ALIVE);
        gameBoard[18][7].setActualCellState(CellState.ALIVE);
        gameBoard[19][7].setActualCellState(CellState.ALIVE);
        gameBoard[20][7].setActualCellState(CellState.ALIVE);
        gameBoard[21][7].setActualCellState(CellState.ALIVE);
        gameBoard[22][7].setActualCellState(CellState.ALIVE);

        gameBoard[15][8].setActualCellState(CellState.ALIVE);
        gameBoard[17][8].setActualCellState(CellState.ALIVE);
        gameBoard[18][8].setActualCellState(CellState.ALIVE);
        gameBoard[19][8].setActualCellState(CellState.ALIVE);
        gameBoard[20][8].setActualCellState(CellState.ALIVE);
        gameBoard[22][8].setActualCellState(CellState.ALIVE);


        gameBoard[15][9].setActualCellState(CellState.ALIVE);
        gameBoard[16][9].setActualCellState(CellState.ALIVE);
        gameBoard[17][9].setActualCellState(CellState.ALIVE);
        gameBoard[18][9].setActualCellState(CellState.ALIVE);
        gameBoard[19][9].setActualCellState(CellState.ALIVE);
        gameBoard[20][9].setActualCellState(CellState.ALIVE);
        gameBoard[21][9].setActualCellState(CellState.ALIVE);
        gameBoard[22][9].setActualCellState(CellState.ALIVE);
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
}

