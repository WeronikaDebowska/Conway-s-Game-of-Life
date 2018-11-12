package test.java.gameOfLife;

import main.java.gameOfLife.Controller.*;
import main.java.gameOfLife.Model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    // ---------------------- checking basic rules ----------------------

    @Test
        // Check if any live cell with fewer than two live neighbors dies, as if by underpopulation
    void willAliveCellDieInUnderpopulationArea() {

        //create 7x7 board to test on
        BoardCreator testingBoard = new BoardCreator(7, 7);

        testingBoard.getGameBoard()[2][1].setActualCellState(CellState.ALIVE);
        testingBoard.getGameBoard()[3][2].setActualCellState(CellState.ALIVE);

        //perform next generation
        Game game = new Game(testingBoard);
        game.playGame();

        //check if both cells are dead
        assertEquals(CellState.DEAD, testingBoard.getGameBoard()[2][1].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGameBoard()[3][2].getActualCellState());

    }

    @Test
        // Check if any live cell with two or three live neighbors lives on to the next generation
    void willAliveCellSurviveNextToTwoOrThreeAliveNeighbours() {

        //create 7x7 board to test on
        BoardCreator testingBoard = new BoardCreator(7, 7);

        testingBoard.getGameBoard()[2][1].setActualCellState(CellState.ALIVE);
        testingBoard.getGameBoard()[3][1].setActualCellState(CellState.ALIVE);
        testingBoard.getGameBoard()[3][2].setActualCellState(CellState.ALIVE);

        //perform next generation
        Game game = new Game(testingBoard);
        game.playGame();

        //check if both cells are dead
        assertEquals(CellState.ALIVE, testingBoard.getGameBoard()[2][1].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGameBoard()[3][1].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGameBoard()[3][2].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGameBoard()[2][2].getActualCellState());

    }

    @Test
        // Check if any live cell with more than three live neighbors dies, as if by overpopulation
    void willAliveCellDieInOverpopulatedArea() {

        //create 7x7 board to test on
        BoardCreator testingBoard = new BoardCreator(7, 7);

        testingBoard.getGameBoard()[2][2].setActualCellState(CellState.ALIVE);
        testingBoard.getGameBoard()[3][2].setActualCellState(CellState.ALIVE);      // the cell should die
        testingBoard.getGameBoard()[4][2].setActualCellState(CellState.ALIVE);
        testingBoard.getGameBoard()[3][3].setActualCellState(CellState.ALIVE);
        testingBoard.getGameBoard()[3][1].setActualCellState(CellState.ALIVE);


        //perform next generation
        Game game = new Game(testingBoard);
        game.playGame();

        //check if both cells are dead
        assertEquals(CellState.DEAD, testingBoard.getGameBoard()[3][2].getActualCellState());

    }


    @Test
        // Check if any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    void willDeadCellBecomeAliveNextToThreeAliveNeighbours() {

        //create 7x7 board to test on
        BoardCreator testingBoard = new BoardCreator(7, 7);

        testingBoard.getGameBoard()[2][2].setActualCellState(CellState.ALIVE);
        testingBoard.getGameBoard()[3][2].setActualCellState(CellState.DEAD);      // the cell become alive
        testingBoard.getGameBoard()[4][2].setActualCellState(CellState.ALIVE);
        testingBoard.getGameBoard()[3][3].setActualCellState(CellState.ALIVE);

        //perform next generation
        Game game = new Game(testingBoard);
        game.playGame();

        //check if both cells are dead
        assertEquals(CellState.ALIVE, testingBoard.getGameBoard()[3][2].getActualCellState());


    }


    // ---------------------- checking various patterns ----------------------

    @Test
    void isBlinkerPatternWorking() {

        //create 7x7 board to test on
        BoardCreator testingBoard = new BoardCreator(7, 7);

        //set blinker pattern i.e. 3 cells in a row alive

        testingBoard.getGameBoard()[2][1].setActualCellState(CellState.ALIVE);
        testingBoard.getGameBoard()[2][2].setActualCellState(CellState.ALIVE);
        testingBoard.getGameBoard()[2][3].setActualCellState(CellState.ALIVE);

        //perform next generation
        Game game = new Game(testingBoard);
        game.playGame();

        //check if pattern is ok in next generation i.e 3 cells vertically alive
        assertEquals(CellState.ALIVE, testingBoard.getGameBoard()[1][2].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGameBoard()[2][1].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGameBoard()[2][2].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGameBoard()[2][3].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGameBoard()[3][2].getActualCellState());

        game.playGame();

        //check if pattern is ok after 2 generations i.e 3 cells horizontally alive
        assertEquals(CellState.ALIVE, testingBoard.getGameBoard()[2][1].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGameBoard()[2][2].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGameBoard()[2][3].getActualCellState());


    }

    @Test
    void isBlockPatternWorking() {

        //create 7x7 board to test on
        BoardCreator testingBoard = new BoardCreator(7, 7);

        //set block pattern i.e. 4 cells in square's corners alive

        testingBoard.getGameBoard()[2][1].setActualCellState(CellState.ALIVE);
        testingBoard.getGameBoard()[2][2].setActualCellState(CellState.ALIVE);
        testingBoard.getGameBoard()[3][1].setActualCellState(CellState.ALIVE);
        testingBoard.getGameBoard()[3][2].setActualCellState(CellState.ALIVE);

        //perform next generation
        Game game = new Game(testingBoard);
        game.playGame();

        //check if pattern is ok i.e 3 cells vertically alive
        assertEquals(CellState.ALIVE, testingBoard.getGameBoard()[2][1].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGameBoard()[2][2].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGameBoard()[3][1].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGameBoard()[3][2].getActualCellState());

        assertEquals(CellState.DEAD, testingBoard.getGameBoard()[1][0].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGameBoard()[1][1].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGameBoard()[1][2].getActualCellState());

        assertEquals(CellState.DEAD, testingBoard.getGameBoard()[2][0].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGameBoard()[2][3].getActualCellState());

        assertEquals(CellState.DEAD, testingBoard.getGameBoard()[3][0].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGameBoard()[3][3].getActualCellState());

        assertEquals(CellState.DEAD, testingBoard.getGameBoard()[4][1].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGameBoard()[4][2].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGameBoard()[4][1].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGameBoard()[4][2].getActualCellState());

    }

}
