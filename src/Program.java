public class Program {

    public static void main(String[] args) {
        World world = new World(30,30);
        world.setAlive(10,10, true);
        world.setAlive(10,11, true);
        world.setAlive(11,10, true);
        world.setAlive(11,11, true);
        WorldRenderer worldRenderer = new WorldRenderer(world);

        worldRenderer.render();
        worldRenderer.render();
    }

}
