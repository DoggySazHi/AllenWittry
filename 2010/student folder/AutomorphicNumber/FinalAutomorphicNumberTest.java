import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  Don Allen
 * @version 2010 programming contest
 */
public class FinalAutomorphicNumberTest extends junit.framework.TestCase
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

   public void testAutomorphicNumber02()
   {
      AutomorphicNumber h = new AutomorphicNumber();

      assertEquals(true, h.isAutomorphicNumber(9376));
      assertEquals(true, h.isAutomorphicNumber(76));
      assertEquals(true, h.isAutomorphicNumber(5));
      assertEquals(false, h.isAutomorphicNumber(36));
      assertEquals(false, h.isAutomorphicNumber(125));
   }

   public void testAutomorphicNumber03()
   {
      AutomorphicNumber h = new AutomorphicNumber();

      int [] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 24, 25, 26, 75, 76, 77, 376, 377, 624, 625, 626, 9375, 9376, 9377};
//      ArrayList<Integer> ans = h.getAutomorphicNumberFromArray(numbers);
      ArrayList<Integer> sol = new ArrayList<Integer>();
      sol.add(new Integer(1));
      sol.add(new Integer(5));
      sol.add(new Integer(6));
      sol.add(new Integer(25));
      sol.add(new Integer(76));
      sol.add(new Integer(376));
      sol.add(new Integer(625));
      sol.add(new Integer(9376));
      assertEquals(sol, h.getAutomorphicNumberFromArray(numbers));
   }

   public void testAutomorphicNumber04()
   {
      AutomorphicNumber h = new AutomorphicNumber();

      assertEquals(false, h.isAutomorphicNumber(7));
      assertEquals(true, h.isAutomorphicNumber(5));
      assertEquals(true, h.isAutomorphicNumber(76));
      assertEquals(true, h.isAutomorphicNumber(9376));
      assertEquals(false, h.isAutomorphicNumber(11));
      assertEquals(false, h.isAutomorphicNumber(36));
      assertEquals(false, h.isAutomorphicNumber(125));
   }

   public void testAutomorphicNumber05()
   {
      AutomorphicNumber h = new AutomorphicNumber();

      int [] numbers = {2, 3, 4, 5, 6, 7, 8, 9, 10, 24, 26, 27, 28, 75, 77, 377, 624, 626, 9375, 9377};
      ArrayList<Integer> sol = new ArrayList<Integer>();
      sol.add(new Integer(5));
      sol.add(new Integer(6));
      assertEquals(sol, h.getAutomorphicNumberFromArray(numbers));
   }

   public void testAutomorphicNumber06()
   {
      AutomorphicNumber h = new AutomorphicNumber();

      int [] numbers = new int[1000];
      for (int k = 0; k < numbers.length; k++)
         numbers[k] = k+1;
      ArrayList<Integer> sol = new ArrayList<Integer>();
      sol.add(new Integer(1));
      sol.add(new Integer(5));
      sol.add(new Integer(6));
      sol.add(new Integer(25));
      sol.add(new Integer(76));
      sol.add(new Integer(376));
      sol.add(new Integer(625));
      assertEquals(sol, h.getAutomorphicNumberFromArray(numbers));
   }

   public void testAutomorphicNumber07()
   {
      AutomorphicNumber h = new AutomorphicNumber();
      assertEquals(true, h.isAutomorphicNumber(1));
      assertEquals(true, h.isAutomorphicNumber(5));
      assertEquals(true, h.isAutomorphicNumber(6));
      assertEquals(true, h.isAutomorphicNumber(25));
      assertEquals(true, h.isAutomorphicNumber(76));
      assertEquals(true, h.isAutomorphicNumber(376));
      assertEquals(true, h.isAutomorphicNumber(625));
      assertEquals(true, h.isAutomorphicNumber(9376));
      for (int k = 626; k < 9376; k++)
         assertEquals(false, h.isAutomorphicNumber(k));
   }

   public void testAutomorphicNumber08()
   {
      testAutomorphicNumber01();
      testAutomorphicNumber02();
      testAutomorphicNumber03();
   }

   public void testAutomorphicNumber09()
   {
      testAutomorphicNumber04();
      testAutomorphicNumber05();
      testAutomorphicNumber06();
   }

   public void testAutomorphicNumber10()
   {
      testAutomorphicNumber08();
      testAutomorphicNumber09();
   }
}