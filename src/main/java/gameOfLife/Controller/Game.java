package gameOfLife.Controller;

import gameOfLife.Model.Board;
import gameOfLife.Model.Cell;
import gameOfLife.Model.CellState;

public class Game {

    private Board currentGeneration;
    private Cell[] neighbours = new Cell[8];


    public Game(Board currentGeneration) {
        this.currentGeneration = currentGeneration;
        findAllCellsNeighbours();
    }

    private void findAllCellsNeighbours() {
        for (int column = 1; column < currentGeneration.getGeneration().length - 1; column++) {
            for (int row = 1; row < currentGeneration.getGeneration()[column].length - 1; row++) {
                findCellsNeighbours(column, row);
            }
        }
    }

    private void findCellsNeighbours(int column, int row) {
        getCell(column, row).setNeighbours(new Cell[]{
                getCell(column - 1, row - 1), getCell(column - 1, row), getCell(column - 1, row + 1),
                getCell(column, row - 1), getCell(column, row + 1),
                getCell(column + 1, row - 1), getCell(column + 1, row), getCell(column + 1, row + 1)
        });
    }


    public Board playGame() {

        for (int i = currentGeneration.getPadding(); i < currentGeneration.getGeneration().length - currentGeneration.getPadding(); i++) {
            for (int j = currentGeneration.getPadding(); j < currentGeneration.getGeneration()[i].length - currentGeneration.getPadding(); j++) {
                getCell(i, j).setFutureCellState();
            }
        }

        for (int i = currentGeneration.getPadding(); i < currentGeneration.getGeneration().length - currentGeneration.getPadding(); i++) {
            for (int j = currentGeneration.getPadding(); j < currentGeneration.getGeneration()[i].length - currentGeneration.getPadding(); j++) {

                getCell(i, j).setActualCellState(currentGeneration.getGeneration()[i][j].getFutureCellState());
                getCell(i, j).setFutureCellState(CellState.DEAD);
            }
        }


        return currentGeneration;
    }

    private Cell getCell(int column, int row) {
        return currentGeneration.getGeneration()[column][row];
    }

}