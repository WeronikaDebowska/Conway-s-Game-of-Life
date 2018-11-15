package gameOfLife.controller;

import gameOfLife.Controller.Game;
import gameOfLife.Model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    // ---------------------- checking basic rules ----------------------

    @Test
        // Check if any live cell with fewer than two live neighbors dies, as if by underpopulation
    void willAliveCellDieInUnderpopulationArea() {

        //create 7x7 board to test on
        Board testingBoard = new Board(17, 17);

        testingBoard.getGeneration()[8][11].bringToLife();
        testingBoard.getGeneration()[8][12].bringToLife();

        //perform next generation
        Game game = new Game(testingBoard);
        game.playGame();

        //check if both cells are dead
        assertEquals(CellState.DEAD, testingBoard.getGeneration()[2][1].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGeneration()[3][2].getActualCellState());

    }

    @Test
        // Check if any live cell with two or three live neighbors lives on to the next generation
    void willAliveCellSurviveNextToTwoOrThreeAliveNeighbours() {

        //create 7x7 board to test on
        Board testingBoard = new Board(7, 7);

        testingBoard.getGeneration()[2][1].bringToLife();
        testingBoard.getGeneration()[3][1].bringToLife();
        testingBoard.getGeneration()[3][2].bringToLife();

        //perform next generation
        Game game = new Game(testingBoard);
        game.playGame();

        //check if both cells are dead
        assertEquals(CellState.ALIVE, testingBoard.getGeneration()[2][1].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGeneration()[3][1].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGeneration()[3][2].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGeneration()[2][2].getActualCellState());

    }

    @Test
        // Check if any live cell with more than three live neighbors dies, as if by overpopulation
    void willAliveCellDieInOverpopulatedArea() {

        //create 7x7 board to test on
        Board testingBoard = new Board(7, 7);

        testingBoard.getGeneration()[2][2].bringToLife();
        testingBoard.getGeneration()[3][2].bringToLife();    // the cell should die
        testingBoard.getGeneration()[4][2].bringToLife();
        testingBoard.getGeneration()[3][3].bringToLife();
        testingBoard.getGeneration()[3][1].bringToLife();


        //perform next generation
        Game game = new Game(testingBoard);
        game.playGame();

        //check if both cells are dead
        assertEquals(CellState.DEAD, testingBoard.getGeneration()[3][2].getActualCellState());

    }


    @Test
        // Check if any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    void willDeadCellBecomeAliveNextToThreeAliveNeighbours() {

        //create 7x7 board to test on
        Board testingBoard = new Board(7, 7);

        testingBoard.getGeneration()[2][2].bringToLife();
//        testingBoard.getGeneration()[3][2]     the cell become alive
        testingBoard.getGeneration()[4][2].bringToLife();
        testingBoard.getGeneration()[3][3].bringToLife();

        //perform next generation
        Game game = new Game(testingBoard);
        game.playGame();

        //check if both cells are dead
        assertEquals(CellState.ALIVE, testingBoard.getGeneration()[3][2].getActualCellState());


    }


    // ---------------------- checking various patterns ----------------------

    @Test
    void isBlinkerPatternWorking() {

        //create 7x7 board to test on
        Board testingBoard = new Board(7, 7);

        //set blinker pattern i.e. 3 cells in a row alive

        testingBoard.getGeneration()[2][1].bringToLife();
        testingBoard.getGeneration()[2][2].bringToLife();
        testingBoard.getGeneration()[2][3].bringToLife();

        //perform next generation
        Game game = new Game(testingBoard);
        game.playGame();

        //check if pattern is ok in next generation i.e 3 cells vertically alive
        assertEquals(CellState.ALIVE, testingBoard.getGeneration()[1][2].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGeneration()[2][1].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGeneration()[2][2].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGeneration()[2][3].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGeneration()[3][2].getActualCellState());

        game.playGame();

        //check if pattern is ok after 2 generations i.e 3 cells horizontally alive
        assertEquals(CellState.ALIVE, testingBoard.getGeneration()[2][1].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGeneration()[2][2].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGeneration()[2][3].getActualCellState());


    }

    @Test
    void isBlockPatternWorking() {

        //create 7x7 board to test on
        Board testingBoard = new Board(7, 7);

        //set block pattern i.e. 4 cells in square's corners alive

        testingBoard.getGeneration()[2][1].bringToLife();
        testingBoard.getGeneration()[2][2].bringToLife();
        testingBoard.getGeneration()[3][1].bringToLife();
        testingBoard.getGeneration()[3][2].bringToLife();

        //perform next generation
        Game game = new Game(testingBoard);
        game.playGame();

        //check if pattern is ok i.e 3 cells vertically alive
        assertEquals(CellState.ALIVE, testingBoard.getGeneration()[2][1].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGeneration()[2][2].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGeneration()[3][1].getActualCellState());
        assertEquals(CellState.ALIVE, testingBoard.getGeneration()[3][2].getActualCellState());

        assertEquals(CellState.DEAD, testingBoard.getGeneration()[1][0].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGeneration()[1][1].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGeneration()[1][2].getActualCellState());

        assertEquals(CellState.DEAD, testingBoard.getGeneration()[2][0].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGeneration()[2][3].getActualCellState());

        assertEquals(CellState.DEAD, testingBoard.getGeneration()[3][0].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGeneration()[3][3].getActualCellState());

        assertEquals(CellState.DEAD, testingBoard.getGeneration()[4][1].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGeneration()[4][2].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGeneration()[4][1].getActualCellState());
        assertEquals(CellState.DEAD, testingBoard.getGeneration()[4][2].getActualCellState());

    }

}
