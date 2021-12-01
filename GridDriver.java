//This just where i tested the anything rly

import java.util.*;

public class GridDriver {
    final int MAX = 8;

    public static void main (String[] args) {
        Scanner kb = new Scanner (System.in);
        Miner mi = new Miner(0, 0);
        Grid board = new Grid (32);
        Searcher se = new Searcher (board, mi);
        int i = 0;

        
        se.switchAgent();

        se.getGrid ().printGrid ();
        kb.nextLine ();     //just keep pressing enter

        while (se.checkWinCon() == 0) {
            se.Search ();
            se.getGrid ().printGrid ();

            kb.nextLine ();     //just keep pressing enter
        }

        if (se.checkWinCon () == 1)
            System.out.println ("LETS GOOOOOOOOOOOOOOOOOOOOLD");
        else
            System.out.println ("L");
            
        se.printDirections ();    //Shows the directions it moved
        System.out.println ("It took " + se.getMoveCount () + " move/s");

    }
}
