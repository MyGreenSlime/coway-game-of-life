import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorldTest extends TestCase {
    public WorldTest(String name) {
        super(name);
    }

    @Test
    public void testBoardInit() {
        World world = new World(30,30);
        boolean[][] board = world.getBoard();
        for (int y = 0; y < 30; y++) {
            for (int x = 0; x<30; x++) {
                assert(!board[y][x]);
            }
        }
    }

    public void testSetAlive() {
        World world = new World(30,30);
        world.setAlive(10,10,true);
        world.setAlive(11,10,true);
        world.setAlive(10,11,true);
        world.setAlive(11,11,true);
        boolean[][]board = world.getBoard();
        assert(board[10][10] && board[11][10] && board[10][11] && board[11][11]);
    }

}