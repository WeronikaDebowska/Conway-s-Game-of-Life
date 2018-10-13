package gameOfLife;

import javafx.scene.layout.GridPane;

public class BoardView extends GridPane {

    private Board gameBoard;

    public BoardView(Board gameBoard) {
        this.setHgap(1.0);
        this.setVgap(1.0);
        this.gameBoard = gameBoard;
    }

    public void render() {

        this.getChildren().clear();

        for (int i = 0; i < gameBoard.width; i++) {
            for (int j = 0; j < gameBoard.height; j++) {
                this.add(new CellView(gameBoard.gameBoard[i][j]), i, j);
            }
        }
    }
}

