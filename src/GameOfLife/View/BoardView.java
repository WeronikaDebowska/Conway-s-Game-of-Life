package gameOfLife.View;

import gameOfLife.Model.BoardCreator;
import javafx.scene.layout.GridPane;

public class BoardView extends GridPane {

    private BoardCreator gameBoard;

    public BoardView(BoardCreator gameBoard) {
        this.setHgap(1.0);
        this.setVgap(1.0);
        this.gameBoard = gameBoard;
        createBoardView();
    }

    public void createBoardView() {

        this.getChildren().clear();

        int numberOfRows = gameBoard.getCellHorizontally();
        int numberOfColumns = gameBoard.getCellVertically();


        for (int i = gameBoard.getPadding(); i < numberOfRows - gameBoard.getPadding(); i++) {
            for (int j = gameBoard.getPadding(); j < numberOfColumns - gameBoard.getPadding(); j++) {

                CellView cellView = new CellView(gameBoard.getGameBoard()[i][j]);

                GridPane.setColumnIndex(cellView, i);
                GridPane.setRowIndex(cellView, j);

                this.getChildren().addAll(cellView);
            }
        }


    }

    public BoardCreator getGameBoard() {
        return gameBoard;
    }
}


