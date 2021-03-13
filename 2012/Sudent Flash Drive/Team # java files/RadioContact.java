import java.util.*;

public class RadioContact 
{
   private final ArrayList<Location> al;

   public RadioContact()   {
      al = new ArrayList<>();
   }

   public RadioContact(ArrayList<Location> l)
   {
      al = l;
   }

   public int getNumberSquads()
   {
      var counter = 0;
      var divider = new ArrayList<>(al);
      while (!divider.isEmpty()) {
         filterSquad(divider.get(0), divider);
         ++counter;
      }
      return counter;
   }

   private void filterSquad(Location main, ArrayList<Location> list) {
      list.remove(main);
      // Today we play the game of "Will William get a ConcurrentModificationException?"
      // (P.S. He doesn't, fortunately)
      var it = list.iterator();
      while (it.hasNext()) {
         var soldier = it.next();
         if (withinRange(main, soldier)) {
            filterSquad(soldier, list);
            it = list.iterator(); // Update the iterator because we might have modified the list
            // Not the most efficient thing, but eh.
         }
      }
   }

/*
 *    Range <= 50 units
 */
   public boolean withinRange(Location loc1, Location loc2)
   {
      return Math.sqrt(Math.pow(loc1.getX() - loc2.getX(), 2) + Math.pow(loc1.getY() - loc2.getY(), 2)) <= 50;
   }
}