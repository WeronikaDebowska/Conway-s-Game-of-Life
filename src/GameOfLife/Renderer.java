package gameOfLife;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Renderer {

    private BoardView boardView;
//    private Stage primaryStage;

    public Renderer() {
//        this.boardView = boardView;
//        this.primaryStage = primaryStage;
    }


    Scene renderBoard(BoardView boardView) {
//       System.out.println("RENDERING");
        Scene scene = new Scene(boardView, 1400, 800);
//       primaryStage.setScene(scene);
//       primaryStage.show();
        return scene;
    }
}

