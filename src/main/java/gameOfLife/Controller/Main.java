package gameOfLife.Controller;

import gameOfLife.Model.Board;
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

        final int WIDTH = 700;             //window width
        final int HEIGHT = 400;             //window height

        final int NUMBER_OF_ROWS = 40;
        final int NUMBER_OF_COLUMNS = 70;


        Board initialBoard = new Board(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
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
