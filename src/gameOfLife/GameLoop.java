package gameOfLife;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameLoop extends AnimationTimer {

    private BoardView boardView;
    private Game game;
    private Stage primaryStage;
    private Renderer renderer;

    public GameLoop(Game game, Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.game = game;
        renderer = new Renderer();
    }


    @Override

    public void handle(long now) {

        if (now % 5 == 0) {
            BoardCreator nextGeneration = game.playGame();
            BoardView nextView = new BoardView(nextGeneration);
            Scene scene = renderer.renderBoard(nextView);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

}
