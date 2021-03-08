import java.util.*;
import java.lang.Math;
import java.lang.Number;
import java.math.BigInteger;
/**
 * Bad To The Bone
 *
 * @author  
 * @version (a version number or a date)
 */
public class BadToTheBone
{
   private boolean containedMatch;
   private final Domino[] processed;

   public BadToTheBone(ArrayList<Domino> dominos)
   {
      var work = new ArrayList<>(dominos);
      int counter;
      do {
         counter = 0;
         for(int i = 0; i < work.size() - 1; i++) {
            var cur = work.get(i);
            var next = work.get(i + 1);
            if (cur.getRight() == next.getLeft()) {
               work.remove(i + 1);
               work.remove(i); // I agree IntelliJ, this is kinda suspicious.
               ++counter;
               containedMatch = true;
            }
         }
      } while (counter > 0);

      processed = new Domino[work.size()];
      for(int i = 0; i < work.size(); ++i)
         processed[i] = work.get(i);
   }

   public Domino[] processDraw()
   {
      return processed;
   }

   public boolean containsMatchingEdges()
   {
      return containedMatch;
   }
}