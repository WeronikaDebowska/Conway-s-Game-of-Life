package gameOfLife;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        final int WIDTH = 1400;
        final int HEIGHT = 800;


        Board gameBoard = new Board(10,10);
        BoardView gameBoardView = new BoardView(gameBoard);
        gameBoardView.render();
        Game game = new Game(gameBoard);
        GameLoop gameLoop = new GameLoop(gameBoard, gameBoardView, game);
        gameLoop.start();

        Scene scene = new Scene(gameBoardView, WIDTH,HEIGHT);

        primaryStage.setTitle("Game Of Life");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
