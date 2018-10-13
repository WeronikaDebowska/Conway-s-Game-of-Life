package gameOfLife;

public class Game {

    private Board gameBoard;
    public Game(Board gameBoard) {
        this.gameBoard = gameBoard;
    }
//    int generation = 0;

    private Cell[] findNeighbours(int cellCoX, int cellCoY) {
        Cell[] neighbours = new Cell[8];    //constant number of cell's neighbours
        int index = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else {
                    neighbours[index] = gameBoard.gameBoard[cellCoX + i][cellCoY + j];
                    index++;
                }
            }
        }
        return neighbours;
    }

    private boolean willCellSurvive(int cellCoX, int cellCoY) {
        Cell[] neighbours = findNeighbours(cellCoX, cellCoY);
        int countAlive = 0;
        for (Cell neighbourCell : neighbours){
            if (neighbourCell.getIsAlive()){
                countAlive++;
            }
        }
        if (gameBoard.gameBoard[cellCoX][cellCoY].getIsAlive()){
            return countAlive >= 2 && countAlive <= 3;
        } else return !gameBoard.gameBoard[cellCoX][cellCoY].getIsAlive() && countAlive == 3;
    }


    public void playGame() {

        Board nextGeneration = new Board(gameBoard.getWidth(), gameBoard.getHeight());
        System.out.println(" -------- next generation --------");
        for (int i=1; i <gameBoard.gameBoard.length-1; i++ ){
            for (int j=1; j <gameBoard.gameBoard[i].length-1; j++ ) {

                if (willCellSurvive(i, j)) {
                    nextGeneration.gameBoard[i][j].setCellAlive();
                    System.out.println("ALIVE " + i + " " + j);
                } else {
                    nextGeneration.gameBoard[i][j].killCell();
                    System.out.println("DEAD " + i + " " + j);
                }
            }
        }

        new BoardView(nextGeneration).render();
        gameBoard.gameBoard = nextGeneration.gameBoard;
    }

}

