package gameOfLife.Model;

public class Board {

    private int cellVertically;
    private int cellHorizontally;
    private Cell[][] generation;

    public Board(int cellHorizontally, int cellVertically) {

        this.cellHorizontally = cellHorizontally;
        this.cellVertically = cellVertically;

        generation = new Cell[cellHorizontally][cellVertically];
        createBoard();
    }

    private void createBoard() {
        for (int column = 0; column < cellHorizontally; column++) {
            for (int row = 0; row < cellVertically; row++) {
                generation[column][row] = new Cell();
            }
        }
    }

    public Cell[][] getGeneration() {
        return generation;
    }

    public int getCellHorizontally() {
        return cellHorizontally;
    }

    public int getCellVertically() {
        return cellVertically;
    }

    public int getPadding() {
        int padding = 1;
        return padding;
    }
}
