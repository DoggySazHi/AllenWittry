import java.util.*;

public class TrainTracks {

//  add your own instance variables
   private int[][] g;

   public TrainTracks(int [][] g)
   {
      this.g = g;
   }

   public ArrayList<String> getRoute()
   {
      ArrayList<String> sol = new ArrayList<String>();
      sol.add("A1");
      int x = 0;
      int y = 0;
      int dir = 3; // right up left down
      while (true) {
         dir = nextDir(dir, g[x][y]);
         switch (dir) {
            case 0:
               ++y;
               break;
            case 1:
               --x;
               break;
            case 2:
               --y;
               break;
            case 3:
               ++x;
               break;
         }
         if (x < 0 || y < 0 || x >= g.length || y >= g[0].length)
            break;
         sol.add((char)((int) 'A' + x) + "" + (y + 1));
      }

      return sol;
   }

   private int nextDir(int oldDir, int block) {
      switch (block) {
         case 1:
            switch (oldDir) {
               case 0:
                  return 0;
               case 1:
                  return 1;
               case 2:
                  return 2;
               case 3:
                  return 3;
            }
         case 2:
            switch (oldDir) {
               case 0:
                  return 1;
               case 1:
                  return 0;
               case 2:
                  return 3;
               case 3:
                  return 2;
            }
         case 3:
            switch (oldDir) {
               case 0:
                  return 3;
               case 1:
                  return 2;
               case 2:
                  return 1;
               case 3:
                  return 0;
            }
      }
      return 0; // Crap!
   }
}