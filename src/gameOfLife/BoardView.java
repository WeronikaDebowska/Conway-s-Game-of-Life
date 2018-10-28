package gameOfLife;

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

        for (int i = 0; i < gameBoard.getCellHorizontally(); i++) {
            for (int j = 0; j < gameBoard.getCellVertically(); j++) {
                this.add(new CellView(gameBoard.gameBoard[i][j]), i, j);
            }
        }
    }
}


