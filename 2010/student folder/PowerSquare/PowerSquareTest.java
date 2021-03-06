import org.junit.Ignore;

import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PowerSquareTest extends junit.framework.TestCase
{
   public void testPowerSquare01()
   {
      PowerSquare sq = new PowerSquare(3);
      sq.swapZeroDown();
      sq.swapZeroRight();

      int[] ans = sq.getFourPossibleNeighbors();
      ArrayList<Integer> temp = new ArrayList<Integer>();
      temp.add(new Integer(7));
      temp.add(new Integer(1));
      temp.add(new Integer(5));
      temp.add(new Integer(4));

      Set<Integer> s = new HashSet<Integer>();
      assertEquals(ans.length, temp.size());
      for (int j = 0; j < ans.length; j++)
      {
         assertEquals(true, temp.contains(ans[j]));
         s.add(ans[j]);
      }
      assertEquals(ans.length, s.size());
   }

   @Ignore
   public void testOperations() {
      var sq = new PowerSquare(4);
      sq.shiftZeroRight();
      sq = new PowerSquare(4);
      sq.shiftZeroLeft();
      sq = new PowerSquare(4);
      sq.shiftZeroDown();
      sq = new PowerSquare(4);
      sq.shiftZeroUp();
      sq = new PowerSquare(4);
      sq.swapZeroRight();
      sq = new PowerSquare(4);
      sq.swapZeroLeft();
      sq = new PowerSquare(4);
      sq.swapZeroUp();
      sq = new PowerSquare(4);
      sq.swapZeroDown();
   }
}