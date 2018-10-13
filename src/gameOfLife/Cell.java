package gameOfLife;

public class Cell {

    private boolean isAlive;

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



}
