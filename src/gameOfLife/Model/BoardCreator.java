package gameOfLife.Model;

public class BoardCreator {

    private int cellVertically;
    private Cell[][] gameBoard;
    private int cellHorizontally;

    public BoardCreator(int cellHorizontally, int cellVertically) {

        this.cellHorizontally = cellHorizontally;
        this.cellVertically = cellVertically;

        gameBoard = new Cell[cellHorizontally][cellVertically];
        createBoard();
    }

    private void createBoard() {
        for (int i = 0; i < cellHorizontally; i++) {
            for (int j = 0; j < cellVertically; j++) {
                gameBoard[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Cell[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public int getCellHorizontally() {
        return cellHorizontally;
    }

    public int getCellVertically() {
        return cellVertically;
    }

    public int getPadding() {
        int padding = 1;
        return padding;
    }
}
