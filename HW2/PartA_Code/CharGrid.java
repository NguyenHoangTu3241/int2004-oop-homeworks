public class CharGrid {
    private char[][] Grid;
    CharGrid(char[][] grid) {
        Grid = grid;
    }
    int charArea(int ch) {
        int minX = Grid[0].length, minY = Grid.length;
        int maxX = -1, maxY = -1;
        int area = 0;
        boolean exist = false;
        for (int i = 0; i < Grid.length; i ++)
            for (int j = 0; j < Grid[0].length; j++)
                if (Grid[i][j] == ch) {
                    minX = Math.min(minX, j);
                    maxX = Math.max(maxX, j);
                    minY = Math.min(minY, i);
                    maxY = Math.max(maxY, i);
                    exist = true;
                }
        if (exist) area = (maxY - minY + 1) * (maxX - minX + 1);
        return area;
    }

    int countPlus() {
        int minX = 0, maxX = Grid[0].length - 1;
        int minY = 0, maxY = Grid.length - 1;
        if (Grid.length < 3 || Grid[0].length < 3) return 0;
        int count = 0, x1, x2, y1, y2;

        for (int y = 1; y < maxY; y++)
            for (int x = 1; x < maxX; x++) {
                if (Grid[y][x] == ' ') continue;
                x1 = x;
                x2 = x;
                y1 = y;
                y2 = y;
                boolean check = true;

                while (x1 > minX && Grid[y][x1 - 1] == Grid[y][x]) {
                    if (Grid[y - 1][x1 - 1] == Grid[y][x] || Grid[y + 1][x1 - 1] == Grid[y][x]) {
                        check = false;
                        break;
                    }
                    x1--;
                }
                if (!check) continue;

                while (x2 < maxX && Grid[y][x2 + 1] == Grid[y][x]) {
                    if (Grid[y - 1][x2 + 1] == Grid[y][x] || Grid[y + 1][x2 + 1] == Grid[y][x]) {
                        check = false;
                        break;
                    }
                    x2++;
                }
                if (!check) continue;

                while (y1 > minY && Grid[y1 - 1][x] == Grid[y][x]) {
                    if (Grid[y1 - 1][x - 1] == Grid[y][x] || Grid[y1 - 1][x + 1] == Grid[y][x]) {
                        check = false;
                        break;
                    }
                    y1--;
                }
                if (!check) continue;

                while (y2 < maxY && Grid[y2 + 1][x] == Grid[y][x]) {
                    if (Grid[y2 + 1][x - 1] == Grid[y][x] || Grid[y2 + 1][x + 1] == Grid[y][x]) {
                        check = false;
                        break;
                    }
                    y2++;
                }
                if (!check) continue;

                if (x1 == x || y1 == y || x2 == x || y2 == y) continue;
                if (x1 + x2 != x + x || y1 + y2 != y + y) continue;
                if (x - x1 != y - y1) continue;
                count++;
            }

        return count;
    }
}