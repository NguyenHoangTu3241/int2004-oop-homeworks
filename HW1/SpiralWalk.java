import java.util.ArrayList;

public class SpiralWalk {
    private static void preDraw(int x, int y) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, 0.45);
    }
    private static void postDraw(int x, int y) {
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledSquare(x, y, 0.45);
        StdDraw.show();
        StdDraw.pause(40);
    }
    public static void main (String[] args) {
        int n = Integer.parseInt(args[0]);

        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int steps = 1;
        while(true) {
            for(int i = 0; i < steps; i++) {
                preDraw(x, y);
                x++;
                postDraw(x, y);
            }
            for(int i = 0; i < steps; i++) {
                preDraw(x, y);
                y++;
                postDraw(x, y);
            }
            steps++;
            for(int i = 0; i < steps; i++) {
                preDraw(x, y);
                x--;
                postDraw(x, y);
            }
            for(int i = 0; i < steps; i++) {
                preDraw(x, y);
                y--;
                postDraw(x, y);
            }
            steps++;
            if(Math.abs(x) > n - 1 && Math.abs(y) > n - 1)break;
        }
        for(int i = 1; i < steps; i++) {
            preDraw(x, y);
            x++;
            postDraw(x, y);
        }
    }

}
