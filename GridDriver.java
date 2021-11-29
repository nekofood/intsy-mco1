//This just where i tested the grid thingies

public class GridDriver {
    final int MAX = 8;

    public static void main (String[] args) {
        Miner mi = new Miner(0, 0);
        Grid board = new Grid (8, mi);

        board.printGrid ();
    }
}
