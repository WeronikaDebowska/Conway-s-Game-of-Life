package main.java.gameOfLife.Controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class KeyControls {

    private final Scene SCENE;
    private GameLoop gameLoop;


    KeyControls(GameLoop gameLoop, Scene scene) {
        this.gameLoop = gameLoop;
        this.SCENE = scene;
        setKeysControls(gameLoop);
    }

    private void setKeysControls(GameLoop gameLoop) {

        SCENE.setOnKeyTyped(e -> {
            if (e.getCharacter().equals("p")) {
                gameLoop.setGamePaused(!gameLoop.isGamePaused());
            }
        });

        SCENE.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                gameLoop.speedUp();
            } else if (e.getCode() == KeyCode.DOWN) {
                gameLoop.slowDown();
            }
        });
    }

}
