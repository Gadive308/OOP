public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int minRow = grid.length;
        int minCol = grid[0].length;
        int maxRow = -1;
        int maxCol = -1;

        for (int row =0; row < grid.length; row++) {
            for (int col =0; col < grid[0].length; col++) {
                if (grid[row][col] == ch) {
                    minRow = Math.min(row, minRow);
                    minCol = Math.min(col, minCol);
                    maxRow = Math.max(row, maxRow);
                    maxCol = Math.max(col, maxCol);
                }
            }
        }
        if (maxRow == -1) {
            return 0;
        }
        return (maxRow - minRow +1) * (maxCol - minCol + 1);
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     * @return number of + in grid
     */
    public int countPlus() {
        int cnt = 0;
        for (int row = 0; row < grid.length-1; row++) {
            for (int col = 0; col < grid[0].length-1; col++) {
                char center = grid[row][col];
                int lengthArm = FindlengthArm(row,col,center);
                if (lengthArm > 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private int FindlengthArm(int row, int col, char center) {
        int length = 0;

        while (( row - length - 1 > 0 ) && (row + length + 1 < grid.length) && (col - length -1 > 0 ) && (col + length +1 < grid[0].length)
                && grid[row - length - 1 ][col] == center && grid[row + length + 1][col] == center && grid[row][col - length -1] == center && grid[row][col - length -1 ] == center ) {
            length++;
        }
        if (length >= 1) {
            return length;
        } else {
            return 0;
        }
    }

}