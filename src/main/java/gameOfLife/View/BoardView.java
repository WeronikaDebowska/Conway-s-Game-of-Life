package gameOfLife.View;

import gameOfLife.Model.Board;
import javafx.scene.layout.GridPane;

public class BoardView extends GridPane {

    private Board gameBoard;

    public BoardView(Board gameBoard) {
        this.setHgap(1.0);
        this.setVgap(1.0);
        this.gameBoard = gameBoard;
        createBoardView();
    }

    public void createBoardView() {

        this.getChildren().clear();

        int numberOfRows = gameBoard.getNumberOfRows();
        int numberOfColumns = gameBoard.getNumberOfColumns();

        final int PADDING = 2;  //size of invisible rows and columns od board

        for (int row = PADDING; row < numberOfRows - PADDING; row++) {
            for (int column = PADDING; column < numberOfColumns - PADDING; column++) {

                CellView cellView = new CellView(gameBoard.getGeneration()[row][column]);

                GridPane.setColumnIndex(cellView, column);
                GridPane.setRowIndex(cellView, row);

                this.getChildren().addAll(cellView);
            }
        }
    }
}


