public class WorldRenderer {
    private World world;
    public WorldRenderer(World world) {
        this.world = world;
    }
    public void render() {
        boolean[][]board = world.getBoard();
        for (int y = 0; y < world.getHeightBoard(); y++) {
            for (int x = 0; x < world.getWidthBoard(); x++) {
                if (board[y][x]) {
                    System.out.print("#");
                }
                else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        world.update();
    }

}
