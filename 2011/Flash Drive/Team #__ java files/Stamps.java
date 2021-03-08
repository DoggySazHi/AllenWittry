import java.util.*;
import java.lang.Math;
import java.lang.Number;
import java.math.BigInteger;
/**
 * Stamps.
 *
 * @author
 * @version (a version number or a date)
 */
public class Stamps
{
   private final int maxStamps;
   private final int[] values;
   private final Set<Integer> possible;

   public Stamps(int n, int[] arr)
   {
      maxStamps = n;
      values = arr;
      possible = new HashSet<>();
      calculatePossibleStamps(1, 0);
   }

   private void calculatePossibleStamps(int depth, int count) {
      for(var v : values) {
         var curCount = count + v;
         possible.add(curCount);
         if (depth < maxStamps)
            calculatePossibleStamps(depth + 1, curCount);
      }
   }

   public int getMaxRange()
   {
      int range = 0;
      while (possible.contains(range + 1))
         ++range;
      return range;
   }
}