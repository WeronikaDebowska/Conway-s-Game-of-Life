package GameOfLife;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Cell {

    private boolean isAlive;
    private CellView cellView;


    public CellView getCellView() {
        return cellView;
    }

    public void setCellView(CellView cellView) {
        this.cellView = cellView;
    }


    public void setIsAlive(boolean alive) {
        isAlive = alive;
    }

    public void killCell(){ this.setIsAlive(false);

    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setCellAlive() {
        this.setIsAlive(true);
    }

    public Cell () {
        this.isAlive = false;

    }

    EventHandler<MouseEvent> eventHandler = event -> {
        this.setIsAlive(!getIsAlive());
        System.out.println("clicked");
    };



}
