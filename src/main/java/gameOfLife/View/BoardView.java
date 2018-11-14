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

        int numberOfColumns = gameBoard.getCellHorizontally();
        int numberOfRows = gameBoard.getCellVertically();

        int padding = gameBoard.getPadding();

        for (int i = padding; i < numberOfColumns - padding; i++) {
            for (int j = padding; j < numberOfRows - padding; j++) {

                CellView cellView = new CellView(gameBoard.getGeneration()[i][j]);

                GridPane.setColumnIndex(cellView, i);
                GridPane.setRowIndex(cellView, j);

                this.getChildren().addAll(cellView);
            }
        }
    }
}


