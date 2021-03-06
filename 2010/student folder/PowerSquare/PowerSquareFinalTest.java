import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  Don Allen
 * @version 2010 programming contest
 */
public class PowerSquareFinalTest extends junit.framework.TestCase
{
   public void testPowerSquare01()
   {
      PowerSquare sq = new PowerSquare(3);
      sq.swapZeroDown();
      sq.swapZeroRight();

      int[] ans = sq.getFourPossibleNeighbors();
      ArrayList<Integer> temp = new ArrayList<Integer>();
      temp.add(new Integer(1));
      temp.add(new Integer(5));
      temp.add(new Integer(4));
      temp.add(new Integer(7));

      Set<Integer> s = new HashSet<Integer>();
      assertEquals(ans.length, temp.size());
      for (int j = 0; j < ans.length; j++)
      {
         assertEquals(true, temp.contains(ans[j]));
         s.add(ans[j]);
      }
      assertEquals(ans.length, s.size());

      ArrayList<Integer> ansl = sq.getEightPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(1));
      temp.add(new Integer(5));
      temp.add(new Integer(4));
      temp.add(new Integer(7));
      temp.add(new Integer(3));
      temp.add(new Integer(2));
      temp.add(new Integer(6));
      temp.add(new Integer(8));

      s = new HashSet<Integer>();
      assertEquals(ansl.size(), temp.size());
      for (int j = 0; j < ans.length; j++)
      {
         assertEquals(true, temp.contains(ansl.get(j)));
         s.add(ansl.get(j));
      }
      assertEquals(ans.length, s.size());
   }

   public void testPowerSquare02()    // test all methods
   {
      PowerSquare sq = new PowerSquare(3);

      ArrayList<Integer> ans = sq.getEightPossibleNeighbors();
      ArrayList<Integer> temp = new ArrayList<Integer>();
      temp.add(new Integer(3));
      temp.add(new Integer(1));
      temp.add(new Integer(4));

      Set<Integer> s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      sq = new PowerSquare(3);
      sq.shiftZeroRight();
      sq.shiftZeroUp();
      sq.shiftZeroRight();
      sq.swapZeroRight();

      int[] arrAns = sq.getFourPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(3));
      temp.add(new Integer(6));

      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());

      ans = sq.getEightPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(6));
      temp.add(new Integer(7));
      temp.add(new Integer(3));

      s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      sq.shiftZeroDown();
      sq.shiftZeroLeft();
      sq.shiftZeroUp();
      sq.swapZeroLeft();
      sq.swapZeroLeft();

      arrAns = sq.getFourPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(3));
      temp.add(new Integer(2));

      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());

      ans = sq.getEightPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(7));
      temp.add(new Integer(2));
      temp.add(new Integer(3));

      s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      sq.swapZeroDown();
      sq.swapZeroLeft();
      sq.swapZeroUp();
      sq.swapZeroRight();
      sq.swapZeroUp();
      sq.swapZeroRight();
      sq.swapZeroDown();
      sq.shiftZeroUp();
 
      arrAns = sq.getFourPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(1));
      temp.add(new Integer(3));
      temp.add(new Integer(7));
      temp.add(new Integer(8));

      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());

      ans = sq.getEightPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(1));
      temp.add(new Integer(2));
      temp.add(new Integer(3));
      temp.add(new Integer(4));
      temp.add(new Integer(5));
      temp.add(new Integer(6));
      temp.add(new Integer(7));
      temp.add(new Integer(8));

      s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());
    }

   public void testPowerSquare03()   //  test swaps
   {
      PowerSquare sq = new PowerSquare(4);

      ArrayList<Integer> ans = sq.getEightPossibleNeighbors();
      ArrayList<Integer> temp = new ArrayList<Integer>();
      temp.add(new Integer(1));
      temp.add(new Integer(4));
      temp.add(new Integer(5));

      Set<Integer> s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      sq.swapZeroUp();
      sq.swapZeroLeft();
      sq.swapZeroDown();

      ans = sq.getEightPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(2));
      temp.add(new Integer(6));
      temp.add(new Integer(7));

      s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      int[] arrAns = sq.getFourPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(2));
      temp.add(new Integer(7));

      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());

      sq.swapZeroLeft();
      sq.swapZeroDown();

      ans = sq.getEightPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(1));
      temp.add(new Integer(6));
      temp.add(new Integer(2));
      temp.add(new Integer(7));
      temp.add(new Integer(10));
      temp.add(new Integer(11));
      temp.add(new Integer(9));
      temp.add(new Integer(5));

      s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      arrAns = sq.getFourPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(6));
      temp.add(new Integer(10));
      temp.add(new Integer(5));
      temp.add(new Integer(7));

      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());

      sq.swapZeroRight();

      ans = sq.getEightPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(6));
      temp.add(new Integer(2));
      temp.add(new Integer(7));
      temp.add(new Integer(10));
      temp.add(new Integer(11));

      s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      arrAns = sq.getFourPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(2));
      temp.add(new Integer(7));
      temp.add(new Integer(11));

      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());
   }

   public void testPowerSquare04()    //  test swaps
   {
      PowerSquare sq = new PowerSquare(5);
      sq.swapZeroRight();
      sq.swapZeroRight();

      ArrayList<Integer> ans = sq.getEightPossibleNeighbors();
      ArrayList<Integer> temp = new ArrayList<Integer>();
      temp.add(new Integer(2));
      temp.add(new Integer(3));
      temp.add(new Integer(6));
      temp.add(new Integer(7));
      temp.add(new Integer(8));

      Set<Integer> s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      int[] arrAns = sq.getFourPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(3));
      temp.add(new Integer(2));
      temp.add(new Integer(7));

      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());

      sq.swapZeroUp();
      sq.swapZeroUp();
      sq.swapZeroUp();

      ans = sq.getEightPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(11));
      temp.add(new Integer(13));
      temp.add(new Integer(16));
      temp.add(new Integer(18));
      temp.add(new Integer(12));
      temp.add(new Integer(6));
      temp.add(new Integer(7));
      temp.add(new Integer(8));

      s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      arrAns = sq.getFourPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(7));
      temp.add(new Integer(11));
      temp.add(new Integer(13));
      temp.add(new Integer(12));

      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());

      sq.swapZeroLeft();
      sq.swapZeroUp();
      sq.swapZeroLeft();

      ans = sq.getEightPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(1));
      temp.add(new Integer(2));
      temp.add(new Integer(5));
      temp.add(new Integer(6));
      temp.add(new Integer(10));

      s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      arrAns = sq.getFourPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(10));
      temp.add(new Integer(1));
      temp.add(new Integer(5));

      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());
   }

   public void testPowerSquare05()    //   shifts only
   {
      PowerSquare sq = new PowerSquare(6);
      sq.shiftZeroUp();
      sq.shiftZeroUp();

      ArrayList<Integer> ans = sq.getEightPossibleNeighbors();
      ArrayList<Integer> temp = new ArrayList<Integer>();
      temp.add(new Integer(30));
      temp.add(new Integer(19));
      temp.add(new Integer(25));
      temp.add(new Integer(31));
      temp.add(new Integer(6));

      Set<Integer> s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      int[] arrAns = sq.getFourPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(30));
      temp.add(new Integer(25));
      temp.add(new Integer(6));

      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());

      sq.shiftZeroLeft();
      sq.shiftZeroUp();

      ans = sq.getEightPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(23));
      temp.add(new Integer(16));
      temp.add(new Integer(22));
      temp.add(new Integer(29));
      temp.add(new Integer(35));

      s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      arrAns = sq.getFourPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(23));
      temp.add(new Integer(22));
      temp.add(new Integer(35));

      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());

      sq.shiftZeroRight();
      sq.shiftZeroRight();
      sq.shiftZeroDown();

      ans = sq.getEightPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(22));
      temp.add(new Integer(13));
      temp.add(new Integer(30));
      temp.add(new Integer(25));
      temp.add(new Integer(27));
      temp.add(new Integer(6));
      temp.add(new Integer(26));
      temp.add(new Integer(32));

      s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      arrAns = sq.getFourPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(13));
      temp.add(new Integer(25));
      temp.add(new Integer(27));
      temp.add(new Integer(26));

      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());
   }

   public void testPowerSquare06()    //    shifts only
   {
      PowerSquare sq = new PowerSquare(5);
      sq.shiftZeroRight();
      sq.shiftZeroUp();

      ArrayList<Integer> ans = sq.getEightPossibleNeighbors();
      ArrayList<Integer> temp = new ArrayList<Integer>();
      temp.add(new Integer(15));
      temp.add(new Integer(21));
      temp.add(new Integer(17));
      temp.add(new Integer(20));
      temp.add(new Integer(22));

      Set<Integer> s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      int[] arrAns = sq.getFourPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(21));
      temp.add(new Integer(20));
      temp.add(new Integer(22));

      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());

      sq.shiftZeroLeft();
      sq.shiftZeroLeft();
      sq.shiftZeroLeft();
      sq.shiftZeroUp();
      sq.shiftZeroLeft();
      sq.shiftZeroDown();

      ans = sq.getEightPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(17));
      temp.add(new Integer(12));
      temp.add(new Integer(19));
      temp.add(new Integer(24));
      temp.add(new Integer(2));

      s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      arrAns = sq.getFourPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(12));
      temp.add(new Integer(2));
      temp.add(new Integer(24));

      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());

      sq.shiftZeroUp();
      sq.shiftZeroUp();
      sq.shiftZeroLeft();
      sq.shiftZeroDown();

      ans = sq.getEightPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(16));
      temp.add(new Integer(11));
      temp.add(new Integer(18));
      temp.add(new Integer(21));
      temp.add(new Integer(20));
      temp.add(new Integer(23));
      temp.add(new Integer(17));
      temp.add(new Integer(1));

      s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      arrAns = sq.getFourPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(11));
      temp.add(new Integer(21));
      temp.add(new Integer(20));
      temp.add(new Integer(17));

      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());

      sq.shiftZeroUp();
      sq.shiftZeroRight();
      sq.shiftZeroDown();
      sq.shiftZeroLeft();

      ans = sq.getEightPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(10));
      temp.add(new Integer(16));
      temp.add(new Integer(12));
      temp.add(new Integer(17));
      temp.add(new Integer(19));
      temp.add(new Integer(23));
      temp.add(new Integer(24));
      temp.add(new Integer(20));

      s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      arrAns = sq.getFourPossibleNeighbors();
      temp = new ArrayList<Integer>();
      temp.add(new Integer(16));
      temp.add(new Integer(17));
      temp.add(new Integer(19));
      temp.add(new Integer(24));

      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());
   }

   public void testPowerSquare07()
   {
      testPowerSquare01();
      testPowerSquare02();
   }

   public void testPowerSquare08()
   {
      testPowerSquare03();
      testPowerSquare04();
   }

   public void testPowerSquare09()
   {
      testPowerSquare05();
      testPowerSquare06();
   }

   public void testPowerSquare10()
   {
      testPowerSquare07();
      testPowerSquare08();
      testPowerSquare09();
   }

   public void testPowerSquare11()    //    shift get four
   {
      PowerSquare sq = new PowerSquare(4);
      sq.shiftZeroRight();
      sq.shiftZeroDown();
      sq.shiftZeroRight();
      sq.shiftZeroDown();
      sq.shiftZeroLeft();
      sq.shiftZeroUp();

      int[] arrAns = sq.getFourPossibleNeighbors();
      ArrayList<Integer> temp = new ArrayList<Integer>();
      temp.add(new Integer(4));
      temp.add(new Integer(7));
      temp.add(new Integer(1));
      temp.add(new Integer(9));

      Set<Integer> s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());

      sq.shiftZeroRight();
      sq.shiftZeroRight();
      sq.shiftZeroRight();
      sq.shiftZeroRight();
      sq.shiftZeroUp();
      sq.shiftZeroUp();
      sq.shiftZeroUp();
      sq.shiftZeroUp();
      sq.shiftZeroLeft();
      sq.shiftZeroLeft();
      sq.shiftZeroLeft();
      sq.shiftZeroLeft();
      sq.shiftZeroDown();
      sq.shiftZeroDown();
      sq.shiftZeroDown();
      sq.shiftZeroDown();

      sq.getFourPossibleNeighbors();

      arrAns = sq.getFourPossibleNeighbors();
      s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());
   }

   public void testPowerSquare12()    //    shift get eight
   {
      PowerSquare sq = new PowerSquare(4);
      sq.shiftZeroRight();
      sq.shiftZeroDown();
      sq.shiftZeroRight();
      sq.shiftZeroDown();
      sq.shiftZeroLeft();
      sq.shiftZeroUp();

      ArrayList<Integer> ans = sq.getEightPossibleNeighbors();
      ArrayList<Integer> temp = new ArrayList<Integer>();
      temp.add(new Integer(4));
      temp.add(new Integer(7));
      temp.add(new Integer(1));
      temp.add(new Integer(9));
      temp.add(new Integer(14));
      temp.add(new Integer(3));
      temp.add(new Integer(11));
      temp.add(new Integer(5));

      Set<Integer> s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());

      sq.shiftZeroRight();
      sq.shiftZeroRight();
      sq.shiftZeroRight();
      sq.shiftZeroRight();
      sq.shiftZeroUp();
      sq.shiftZeroUp();
      sq.shiftZeroUp();
      sq.shiftZeroUp();
      sq.shiftZeroLeft();
      sq.shiftZeroLeft();
      sq.shiftZeroLeft();
      sq.shiftZeroLeft();
      sq.shiftZeroDown();
      sq.shiftZeroDown();
      sq.shiftZeroDown();
      sq.shiftZeroDown();

      sq.getFourPossibleNeighbors();

      ans = sq.getEightPossibleNeighbors();
      s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());
   }

   public void testPowerSquare13()    //    swap get four
   {
      PowerSquare sq = new PowerSquare(10);
      sq.swapZeroDown();
      sq.swapZeroDown();
      sq.swapZeroDown();
      sq.swapZeroRight();
      sq.swapZeroRight();
      sq.swapZeroRight();
      sq.swapZeroRight();
      sq.swapZeroDown();
      sq.swapZeroRight();
      sq.swapZeroDown();
      sq.swapZeroRight();
      
      sq.swapZeroDown();
      sq.swapZeroLeft();
      sq.swapZeroDown();
      sq.swapZeroLeft();

      sq.swapZeroUp();
      sq.swapZeroUp();
      sq.swapZeroUp();
      sq.swapZeroUp();

      sq.swapZeroRight();
      sq.swapZeroUp();
      sq.swapZeroLeft();
      sq.swapZeroUp();
      sq.swapZeroLeft();

      int[] arrAns = sq.getFourPossibleNeighbors();
      ArrayList<Integer> temp = new ArrayList<Integer>();
      temp.add(new Integer(3));
      temp.add(new Integer(12));
      temp.add(new Integer(13));
      temp.add(new Integer(23));

      Set<Integer> s = new HashSet<Integer>();
      assertEquals(arrAns.length, temp.size());
      for (int j = 0; j < arrAns.length; j++)
      {
         assertEquals(true, temp.contains(arrAns[j]));
         s.add(arrAns[j]);
      }
      assertEquals(arrAns.length, s.size());

   }

   public void testPowerSquare14()    //    swap get eight
   {
      PowerSquare sq = new PowerSquare(10);
      sq.swapZeroDown();
      sq.swapZeroDown();
      sq.swapZeroDown();
      sq.swapZeroRight();
      sq.swapZeroRight();
      sq.swapZeroRight();
      sq.swapZeroRight();
      sq.swapZeroDown();
      sq.swapZeroRight();
      sq.swapZeroDown();
      sq.swapZeroRight();
      
      sq.swapZeroDown();
      sq.swapZeroLeft();
      sq.swapZeroDown();
      sq.swapZeroLeft();

      sq.swapZeroUp();
      sq.swapZeroUp();
      sq.swapZeroUp();
      sq.swapZeroUp();

      sq.swapZeroRight();
      sq.swapZeroUp();
      sq.swapZeroLeft();
      sq.swapZeroUp();
      sq.swapZeroLeft();

      ArrayList<Integer> ans = sq.getEightPossibleNeighbors();
      ArrayList<Integer> temp = new ArrayList<Integer>();
      temp.add(new Integer(2));
      temp.add(new Integer(3));
      temp.add(new Integer(4));
      temp.add(new Integer(12));
      temp.add(new Integer(13));
      temp.add(new Integer(22));
      temp.add(new Integer(23));
      temp.add(new Integer(14));

      Set<Integer> s = new HashSet<Integer>();
      assertEquals(ans.size(), temp.size());
      for (int j = 0; j < ans.size(); j++)
      {
         assertEquals(true, temp.contains(ans.get(j)));
         s.add(ans.get(j));
      }
      assertEquals(ans.size(), s.size());
   }
}