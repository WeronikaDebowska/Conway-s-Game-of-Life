package gameOfLife.Controller;

import gameOfLife.Controller.Game;
import gameOfLife.Controller.GameLoop;
import gameOfLife.Controller.KeyControls;
import gameOfLife.Model.BoardCreator;
import gameOfLife.View.BoardView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        final int WIDTH = 1400;             //window width
        final int HEIGHT = 800;             //window height


        BoardCreator initialBoard = new BoardCreator(40, 40);
        BoardView initialBoardView = new BoardView(initialBoard);
        Game game = new Game(initialBoard);
        Scene scene = new Scene(initialBoardView, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Game Of Life");
        primaryStage.show();

        GameLoop gameLoop = new GameLoop(game, scene);
        new KeyControls(gameLoop, scene);
        gameLoop.updateGame();

    }
}
