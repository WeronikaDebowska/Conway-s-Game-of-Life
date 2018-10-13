package gameOfLife;

import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {

    private Board gameBoard;
    private BoardView boardView;
    private Game game;

    public GameLoop(Board gameBoard, BoardView boarView, Game game) {
        this.gameBoard = gameBoard;
        this.boardView = boardView;
        this.game = game;
    }


    @Override
    public void handle(long now) {

        if (now % 10 == 0) {
            game.playGame();
//          this.boardView.renderBoardView();
        }
    }
}
