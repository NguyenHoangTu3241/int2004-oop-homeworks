public class TetrisGrid {
    private boolean[][] grid;
    TetrisGrid(boolean[][] g) {
        grid = g;
    }

    boolean[][] getGrid() {
        return grid;
    }

    void clearRows() {
        for (int y = 0; y < grid[0].length; y++) {
            boolean shouldClear = true;
            for (int x = 0; x < grid.length; x++) {
                if (!grid[x][y]) {
                    shouldClear = false;
                    break;
                }
            }
            if (shouldClear) {
                for (int yy = y; yy < grid[0].length - 1; yy++)
                    for (int x = 0; x < grid.length; x++)
                        grid[x][yy] = grid[x][yy + 1];

                for(int x = 0; x < grid.length; x++)
                    grid[x][grid[0].length - 1] = false;
            }
        }
    }

}