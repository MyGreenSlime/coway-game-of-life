public class World {
    private boolean[][]board;
    private int heightBoard;
    private int widthBoard;
    public World(int Height, int Width) {
        this.heightBoard = Height;
        this.widthBoard = Width;
        this.board = new boolean[Height+2][Width+2];
        for (int y = 0; y < heightBoard+2; y++) {
            for (int x = 0; x < widthBoard+2; x++) {
                board[y][x] = false;
            }
        }
    }

    public boolean[][] getBoard() {
        return board;
    }

    public int getHeightBoard() {
        return heightBoard;
    }

    public int getWidthBoard() {
        return widthBoard;
    }

    public void setAlive(int x, int y, boolean alive) {
        this.board[y][x] = alive;
    }

    public boolean[][] copyArray2D(boolean[][] src) {
        boolean[][] temp = new boolean[heightBoard+2][widthBoard+2];
        for (int y = 0; y < heightBoard+2; y++) {
            for (int x = 0; x < widthBoard+2; x++) {
                temp[y][x] = src[y][x];
            }
        }
        return temp;
    }

    public int countNeighbor(boolean[][] src, int x, int y) {
        int[][] dir = { {-1,-1}, {0,-1}, {1,-1}, {-1,0}, {1,0}, {-1,+1}, {0,+1}, {+1,+1} };
        int count = 0;

        for (int i = 0; i < 8; i++) {
            if(y + (int)dir[i][1] < 0 || x + (int)dir[i][0] < 0 ) {
                continue;
            }
            if (src[y + (int)dir[i][1]][x + (int)dir[i][0]]) {

                count++;
            }
        }
        return count;
    }

    public boolean[][] update() {
        boolean[][] tempboard = copyArray2D(board);
        for (int y = 0; y < heightBoard; y++) {
            for (int x = 0; x < widthBoard; x++) {
                int neighbors = countNeighbor(tempboard, x, y);
                if(tempboard[y][x]) {
                    if(neighbors < 2) {
                        setAlive(x, y, false);
                    }
                    else if(neighbors <= 3) {
                        setAlive(x, y, true);
                    }
                    else {
                        setAlive(x, y, false);
                    }
                }
                else {
                    if(neighbors == 3) {
                        setAlive(x, y, true);
                    }
                }
            }
        }
        return tempboard;
    }
}
