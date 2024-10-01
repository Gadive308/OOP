//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
    private boolean[][] grid;

    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     * @param grid
     */
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }


    /**
     * Does row-clearing on the grid (see handout).
     */
    public void clearRows() {
        int numRows = grid.length;
        int numCols = grid[0].length;

        for (int i = 0; i < numRows; i++) {
            boolean fullRow = true;

            for (int j = 0; j < numCols; j++) {
                if (!grid[i][j]) {
                    fullRow = false;
                    break;
                }
            }

            if (fullRow) {
                for (int k = i; k > 0; k--) {
                    grid[k] = grid[k - 1];
                }
                for (int j = 0; j < numCols; j++) {
                    grid[0][j] = false;
                }
                i--;
            }
        }
    }

    /**
     * Returns the internal 2d grid array.
     * @return 2d grid array
     */
    boolean[][] getGrid() {
        return grid; // YOUR CODE HERE
    }
}
