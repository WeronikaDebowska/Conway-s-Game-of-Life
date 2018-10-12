package GameOfLife;

import javafx.animation.AnimationTimer;

public class Game extends AnimationTimer {

    private Board gameBoard;
    public Game(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    private Cell[] findNeighbours(Board gameBoard, int cellCoX, int cellCoY){
        Cell[] neighbours = new Cell[8];    //constant number of cell's neighbours
        neighbours[0] = gameBoard.gameBoard[cellCoX-1][cellCoY-1];
        neighbours[1] = gameBoard.gameBoard[cellCoX-1][cellCoY];
        neighbours[2] = gameBoard.gameBoard[cellCoX-1][cellCoY+1];
        neighbours[3] = gameBoard.gameBoard[cellCoX][cellCoY-1];
        neighbours[4] = gameBoard.gameBoard[cellCoX][cellCoY+1];
        neighbours[5] = gameBoard.gameBoard[cellCoX+1][cellCoY-1];
        neighbours[6] = gameBoard.gameBoard[cellCoX+1][cellCoY];
        neighbours[7] = gameBoard.gameBoard[cellCoX+1][cellCoY+1];
        return neighbours;
    }

    private boolean willCellSurvive(Board gameBoard, int cellCoX, int cellCoY){
        Cell[] neighbours = findNeighbours(gameBoard, cellCoX, cellCoY);
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


    public void playGame(Board gameBoard) {

        Board nextGeneration = new Board(gameBoard.getWidth(), gameBoard.getHeight());

        for (int i=1; i <gameBoard.gameBoard.length-1; i++ ){
            for (int j=1; j <gameBoard.gameBoard[i].length-1; j++ ) {

                if (willCellSurvive(gameBoard, i, j)){
                    nextGeneration.gameBoard[i][j].setCellAlive();
                    System.out.println("ALIVE " + i + " " + j);
                } else {
                    nextGeneration.gameBoard[i][j].killCell();
                    System.out.println("DEAD " + i + " " + j);
                }
            }
        }

        new BoardView(nextGeneration);
        gameBoard.gameBoard = nextGeneration.gameBoard;
    }

    @Override
    public void handle(long now) {

        if (now % 10 == 0){
            playGame(gameBoard);
            generation ++;
        }
    }
}

