package GameOfLife;


public class Board  {

    int width;

    int height;
    Cell[][] gameBoard;

    public Board(int width, int height) {

        this.width = width;
        this.height = height ;

        gameBoard = new Cell[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                gameBoard[i][j] = new Cell();
            }
        }
        gameBoard[2][4].setCellAlive();
        gameBoard[3][2].setCellAlive();
        gameBoard[3][4].setCellAlive();
        gameBoard[4][3].setCellAlive();
        gameBoard[4][4].setCellAlive();
        gameBoard[7][8].setCellAlive();
        gameBoard[7][7].setCellAlive();
        gameBoard[7][6].setCellAlive();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

