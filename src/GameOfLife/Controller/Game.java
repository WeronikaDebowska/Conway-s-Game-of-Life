
package gameOfLife.Controller;

import gameOfLife.Model.BoardCreator;
import gameOfLife.Model.Cell;
import gameOfLife.Model.CellState;

class Game {

    private BoardCreator currentGeneration;
    //    private LinkedList <Cell> aliveCellsList;
    private Cell[] neighbours = new Cell[8];

    Game(BoardCreator currentGeneration) {
        this.currentGeneration = currentGeneration;
    }

    private Cell[] findNeighbours(int cellCoX, int cellCoY) {
//        Cell[] neighbours = new Cell[8];    //constant number of cell's neighbours
        int index = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    neighbours[index] = currentGeneration.getGameBoard()[cellCoX + i][cellCoY + j];
//                    currentGeneration.gameBoard[cellCoX + i][cellCoY + j].addObserver(currentGeneration.gameBoard[cellCoX][cellCoY]); //setting the cell as an observer of its neighbours
                    index++;
                }
            }
        }
        return neighbours;
    }

    private void changeCellStatusIfNeeded(int cellCoX, int cellCoY) {

        Cell[] neighbours = findNeighbours(cellCoX, cellCoY);
        Cell cell = currentGeneration.getGameBoard()[cellCoX][cellCoY];

        boolean cellIsAlive = cell.getActualCellState().equals(CellState.ALIVE);
        int aliveNeighboursCount = 0;

        for (Cell neighbourCell : neighbours) {
            if (neighbourCell.getActualCellState().equals(CellState.ALIVE)) {
                aliveNeighboursCount++;
            }
        }

        if ((cellIsAlive && (aliveNeighboursCount == 2 || aliveNeighboursCount == 3))) {
            cell.setFutureCellState(CellState.ALIVE);
        } else if (!cellIsAlive && aliveNeighboursCount == 3) {
            cell.setFutureCellState(CellState.ALIVE);
        } else {
            cell.setFutureCellState(CellState.DEAD);
            if (cell.getActualCellState().equals(CellState.ALIVE)) {
            }
        }
    }

//    private boolean shouldStatusBeChangedd(Cell cell){
////        int cellCoX = cell.getRow();
////        int cellCoY = cell.getColumn();
////
////        Cell[] neighbours = findNeighbours(cellCoX, cellCoY);
////        Cell cell = currentGeneration.gameBoard[cellCoX][cellCoY];
//
//        boolean cellIsAlive = cell.getActualCellState().equals(CellState.ALIVE);
//        int aliveNeighboursCount = 0;
//
//        for (Cell neighbourCell : neighbours){
//            if (neighbourCell.getActualCellState().equals(CellState.ALIVE)) {
//                aliveNeighboursCount++;
//            }
//        }
//
//        if ((cellIsAlive && (aliveNeighboursCount == 2 || aliveNeighboursCount == 3))){
////            cell.setFutureCellState(CellState.ALIVE);
//            aliveCellsList.add(cell);
//            return true;
//        } else if (!cellIsAlive && aliveNeighboursCount == 3){
////            cell.setFutureCellState(CellState.ALIVE);
//            aliveCellsList.add(cell);
//            return true;
//        } else {
////            cell.setFutureCellState(CellState.DEAD);
//            if (cell.getActualCellState().equals(CellState.ALIVE)){
//                aliveCellsList.remove(cell);
//            }
//            return false;
//        }
//    }


    BoardCreator playGame() {

        BoardCreator nextGeneration;
        nextGeneration = new BoardCreator(currentGeneration.getCellHorizontally(), currentGeneration.getCellVertically());

//        int row;
//        int column;
//
//        for (Cell aliveCell : aliveCellsList ){
//            row = aliveCell.getRow();
//            column = aliveCell.getColumn();
//            if (shouldStatusBeChangedd(aliveCell)){
//                aliveCell.changeFutureState();
//                notifyAll();
//            }
//            nextGeneration.gameBoard[row][column].setActualCellState(aliveCell.getFutureCellState());
//            nextGeneration.gameBoard[row][column].setActualCellState(CellState.DEAD);
//        }


        for (int i = currentGeneration.getPadding(); i < currentGeneration.getGameBoard().length - currentGeneration.getPadding(); i++) {
            for (int j = currentGeneration.getPadding(); j < currentGeneration.getGameBoard()[i].length - currentGeneration.getPadding(); j++) {

                changeCellStatusIfNeeded(i, j);

                nextGeneration.getGameBoard()[i][j].setActualCellState(currentGeneration.getGameBoard()[i][j].getFutureCellState());
                nextGeneration.getGameBoard()[i][j].setFutureCellState(CellState.DEAD);
            }
        }

        currentGeneration.setGameBoard(nextGeneration.getGameBoard());
        return nextGeneration;
    }


}

