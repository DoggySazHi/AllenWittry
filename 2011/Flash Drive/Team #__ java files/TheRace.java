import java.util.*;
import java.lang.*;

/**
 * The test class TheRace.
 *
 * @author  (your name)
 * @version 2010 Wittry Programming contest
 */
public class TheRace
{
   private final Map<String, Integer> boardPos;
   private final int boardSize;
   private final ArrayList<String> winners;

   public TheRace(String[] numbers, int size)
   {
      boardPos = new HashMap<>();
      for (var s: numbers)
         boardPos.put(s, 0);
      boardSize = size;
      winners = new ArrayList<>();
      /*   add more code as needed   */
   }
/*
      String[] names1 = {"George", "John", "Thomas", "James"};
      TheRace tr = new TheRace(names1, 12);
      PlayerMove[] pm1 = { new PlayerMove("George", 4),
                           new PlayerMove("John", 2),
                           new PlayerMove("Thomas", 3),
                           new PlayerMove("James", 1)
                         };
      assertEquals(false, tr.playRound(pm1));
*/
/*
 * returns true if a player has finished the race
 *         false otherwise - no player has finished the race
 */
   private boolean updatePlayer(String name, int diff) {
      // You lied to me!
      // •	A player may pass the finish line.
      // "but the final location will never be greater than the board size".
      // Yes they can!!! See main tester.
      var value = Math.max(0, boardPos.get(name) + diff);
      boardPos.put(name, value);
      return value >= boardSize;
   }

   public boolean playRound(PlayerMove[] numbers)
   {
      var moves = new HashMap<Integer, List<String>>();
      for(var move : numbers) {
         var item = moves.getOrDefault(move.getChoice(), new ArrayList<>());
         item.add(move.getName());
         moves.put(move.getChoice(), item);
      }

      for(var key : moves.keySet()) {
         var players = moves.get(key);
         if (players.size() == 1) {
            if (updatePlayer(players.get(0), key) && !winners.contains(players.get(0)))
               winners.add(players.get(0));
         }
         else if (players.size() >= 3)
            for(var player : players)
               updatePlayer(player, -key);
      }
      return boardPos.keySet().stream().anyMatch(o -> boardPos.get(o) >= boardSize);
   }

   public int getPlayerLocation(String player)
   {
      return boardPos.get(player);
   }

/*
 *    returns an ArrayList of all Player names who have finished the race.  The ArrayList is empty if no player has finished
 *    In case of tie, the order of the player does not matter!  That is, the players on the same square maybe returned in any order
 */
   public ArrayList<String> getResults()
   {
      return winners;
   }
}