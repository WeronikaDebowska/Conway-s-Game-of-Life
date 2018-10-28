
package gameOfLife;

class Game {

    private BoardCreator gameBoard;
    private BoardCreator nextGeneration;

    Game(BoardCreator gameBoard) {
        this.gameBoard = gameBoard;
    }
//    int generation = 0;

    private Cell[] findNeighbours(int cellCoX, int cellCoY) {
        Cell[] neighbours = new Cell[8];    //constant number of cell's neighbours
        int index = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    neighbours[index] = gameBoard.gameBoard[cellCoX + i][cellCoY + j];
                    gameBoard.gameBoard[cellCoX + i][cellCoY + j].addObserver(gameBoard.gameBoard[cellCoX][cellCoY]);
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
            if (neighbourCell.getActualCellState().equals(CellState.ALIVE)) {
                countAlive++;
            }
        }
        if (gameBoard.gameBoard[cellCoX][cellCoY].getActualCellState().equals(CellState.ALIVE)) {
            return countAlive >= 2 && countAlive <= 3;
        } else
            return !gameBoard.gameBoard[cellCoX][cellCoY].getActualCellState().equals(CellState.ALIVE) && countAlive == 3;
    }


    BoardCreator playGame() {

        nextGeneration = new BoardCreator(gameBoard.getCellHorizontally(), gameBoard.getCellVertically());
//        System.out.println(" -------- next generation --------");
        for (int i=1; i <gameBoard.gameBoard.length-1; i++ ){
            for (int j=1; j <gameBoard.gameBoard[i].length-1; j++ ) {

                if (willCellSurvive(i, j)) {
                    nextGeneration.gameBoard[i][j].setActualCellState(CellState.ALIVE);
//                    System.out.println("ALIVE " + i + " " + j);
                } else {
                    nextGeneration.gameBoard[i][j].setActualCellState(CellState.DEAD);
//                    System.out.println("DEAD " + i + " " + j);
                }
            }
        }
        gameBoard.setGameBoard(nextGeneration.gameBoard);
//        BoardCreator next = new BoardCreator(nextGeneration);
        return nextGeneration;

//        renderNextGeneration();
//        BoardView next = new BoardView(nextGeneration);
//        next.render();
//        gameBoard.gameBoard = nextGeneration.gameBoard;
    }


//    private void renderNextGeneration() {
//        BoardView next = new BoardView(nextGeneration);
//        next.render();
//    }

}

