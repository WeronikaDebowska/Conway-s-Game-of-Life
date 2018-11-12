package main.java.gameOfLife.Controller;

import main.java.gameOfLife.Model.BoardCreator;
import main.java.gameOfLife.Model.Cell;
import main.java.gameOfLife.Model.CellState;

public class Game {

    private BoardCreator currentGeneration;
    private Cell[] neighbours = new Cell[8];

    public Game(BoardCreator currentGeneration) {
        this.currentGeneration = currentGeneration;
    }

    private Cell[] findNeighbours(int cellCoX, int cellCoY) {
        int index = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    neighbours[index] = currentGeneration.getGeneration()[cellCoX + i][cellCoY + j];
                    index++;
                }
            }
        }
        return neighbours;
    }

    private void updateCellStatus(int cellCoX, int cellCoY) {

        Cell[] neighbours = findNeighbours(cellCoX, cellCoY);
        Cell cell = currentGeneration.getGeneration()[cellCoX][cellCoY];

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

    public BoardCreator playGame() {

        for (int i = currentGeneration.getPadding(); i < currentGeneration.getGeneration().length - currentGeneration.getPadding(); i++) {
            for (int j = currentGeneration.getPadding(); j < currentGeneration.getGeneration()[i].length - currentGeneration.getPadding(); j++) {

                updateCellStatus(i, j);
            }
        }

        for (int i = currentGeneration.getPadding(); i < currentGeneration.getGeneration().length - currentGeneration.getPadding(); i++) {
            for (int j = currentGeneration.getPadding(); j < currentGeneration.getGeneration()[i].length - currentGeneration.getPadding(); j++) {

//                System.out.println(i + " " + j + " " + currentGeneration.getGeneration()[i][j].getActualCellState());
                currentGeneration.getGeneration()[i][j].setActualCellState(currentGeneration.getGeneration()[i][j].getFutureCellState());
                currentGeneration.getGeneration()[i][j].setFutureCellState(CellState.DEAD);


            }
        }
//        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        return currentGeneration;
    }


}