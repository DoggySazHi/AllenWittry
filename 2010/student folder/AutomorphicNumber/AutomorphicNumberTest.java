import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  Don Allen
 * @version 2010 programming contest
 */
public class AutomorphicNumberTest extends junit.framework.TestCase
{
   public void testAutomorphicNumber01()
   {
      AutomorphicNumber h = new AutomorphicNumber();

      assertEquals(false, h.isAutomorphicNumber(7));
      assertEquals(true, h.isAutomorphicNumber(5));
      assertEquals(true, h.isAutomorphicNumber(76));
      assertEquals(false, h.isAutomorphicNumber(11));

      int [] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 24, 25, 26, 75, 76};
//      ArrayList<Integer> ans = h.getAutomorphicNumberFromArray(numbers);
      ArrayList<Integer> sol = new ArrayList<Integer>();
      sol.add(new Integer(1));
      sol.add(new Integer(5));
      sol.add(new Integer(6));
      sol.add(new Integer(25));
      sol.add(new Integer(76));
      assertEquals(sol, h.getAutomorphicNumberFromArray(numbers));
   }
}