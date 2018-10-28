package gameOfLife;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        final int WIDTH = 1400;             //window width
        final int HEIGHT = 800;             //window height


        BoardCreator gameBoard = new BoardCreator(140, 80);
        BoardView gameBoardView = new BoardView(gameBoard);
        Game game = new Game(gameBoard);
        Scene scene = new Renderer().renderBoard(gameBoardView);
        GameLoop gameLoop = new GameLoop(game, primaryStage);
        gameLoop.start();

        primaryStage.setTitle("Game Of Life");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
