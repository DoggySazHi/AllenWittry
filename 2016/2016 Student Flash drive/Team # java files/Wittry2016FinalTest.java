import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class Wittry2016FinalTest.
 *
 * @author  Don Allen
 * @version 2016 tester Wittry Contest
 */
public class Wittry2016FinalTest extends junit.framework.TestCase
{
   public void testRummikub01()
   {
      ArrayList<RummikubTiles> tiles = new ArrayList<RummikubTiles>();
      tiles.add(new RummikubTiles("red", 5));
      tiles.add(new RummikubTiles("blue", 5));
      tiles.add(new RummikubTiles("orange", 5));
      tiles.add(new RummikubTiles("red", 6));
      tiles.add(new RummikubTiles("red", 7));
      tiles.add(new RummikubTiles("blue", 13));
      tiles.add(new RummikubTiles("red", 12));
      tiles.add(new RummikubTiles("orange", 1));
      tiles.add(new RummikubTiles("orange", 9));
      tiles.add(new RummikubTiles("black", 1));
      tiles.add(new RummikubTiles("black", 2));
      tiles.add(new RummikubTiles("black", 7));
      tiles.add(new RummikubTiles("black", 8));
      tiles.add(new RummikubTiles("black", 12));

      Rummikub r = new Rummikub(tiles);

      assertEquals(true, r.hasGroup());
      assertEquals(true, r.hasRun());
      assertEquals(18, r.maxPointValueInHand());
      tiles.set(0, new RummikubTiles("red", 2));
      assertEquals(false, r.hasGroup());
      assertEquals(false, r.hasRun());
      assertEquals(0, r.maxPointValueInHand());

      ArrayList<RummikubTiles> play= new ArrayList<RummikubTiles>();
      play.add(new RummikubTiles("orange", 5));
      play.add(new RummikubTiles("orange", 4));
      play.add(new RummikubTiles("orange", 6));
      assertEquals(4+5+6, Rummikub.pointValue(play));

      play= new ArrayList<RummikubTiles>();
      play.add(new RummikubTiles("red", 13));
      play.add(new RummikubTiles("orange", 13));
      play.add(new RummikubTiles("black", 13));
      assertEquals(3*13, Rummikub.pointValue(play));
   }

/*
*   Groups are 3 or 4 of a kind of a different color tile
*      possible colors are:  black, red, blue, orange
*/
   public void testRummikubHasGroupof3or4ofaKind02()
   {
      ArrayList<RummikubTiles> hand = new ArrayList<RummikubTiles>();
      hand.add(new RummikubTiles("black", 1));
      hand.add(new RummikubTiles("red", 1));
      hand.add(new RummikubTiles("black", 2));
      hand.add(new RummikubTiles("black", 3));
      hand.add(new RummikubTiles("black", 4));
      hand.add(new RummikubTiles("blue", 5));
      hand.add(new RummikubTiles("orange", 5));
      hand.add(new RummikubTiles("red", 6));
      hand.add(new RummikubTiles("black", 7));
      hand.add(new RummikubTiles("red", 7));
      hand.add(new RummikubTiles("orange", 8));
      hand.add(new RummikubTiles("orange", 9));
      hand.add(new RummikubTiles("red", 12));
      hand.add(new RummikubTiles("blue", 13));

      Rummikub r = new Rummikub(hand);
      assertEquals(false, r.hasGroup());

      hand.set(12, new RummikubTiles("orange", 3));
      hand.set(13, new RummikubTiles("blue", 3));
      r = new Rummikub(hand);
      assertEquals(true, r.hasGroup());

      hand.set(12, new RummikubTiles("orange", 6));
      hand.set(1, new RummikubTiles("blue", 2));
      r = new Rummikub(hand);
      assertEquals(false, r.hasGroup());

      hand.set(12, new RummikubTiles("orange", 7));
      hand.set(1, new RummikubTiles("blue", 7));
      r = new Rummikub(hand);
      assertEquals(true, r.hasGroup());
   }

   public void testRummikubHasRunOfLength3Or4_03()
   {
      ArrayList<RummikubTiles> hand = new ArrayList<RummikubTiles>();
      hand.add(0, new RummikubTiles("red", 5));
      hand.add(1, new RummikubTiles("blue", 5));
      hand.add(2, new RummikubTiles("orange", 5));
      hand.add(3, new RummikubTiles("red", 8));
      hand.add(4, new RummikubTiles("red", 7));
      hand.add(5, new RummikubTiles("blue", 13));
      hand.add(6, new RummikubTiles("red", 12));
      hand.add(7, new RummikubTiles("orange", 1));
      hand.add(8, new RummikubTiles("orange", 9));
      hand.add(9, new RummikubTiles("black", 1));
      hand.add(10, new RummikubTiles("black", 2));
      hand.add(11, new RummikubTiles("black", 4));
      hand.add(12, new RummikubTiles("black", 7));
      hand.add(13, new RummikubTiles("black", 12));

      Rummikub r = new Rummikub(hand);
      assertEquals(false, r.hasRun());

      hand.set(11, new RummikubTiles("black", 3));
      r = new Rummikub(hand);
      assertEquals(true, r.hasRun());

      hand.set(9, new RummikubTiles("red", 4));
      hand.set(2, new RummikubTiles("red", 6));
      r = new Rummikub(hand);
      assertEquals(true, r.hasRun());

      hand.set(2, new RummikubTiles("orange", 12));
      r = new Rummikub(hand);
      boolean ans = r.hasRun();
      assertEquals(false, ans);
   }

 /*
 *     runs are three or more consecutive tiles of the same color
 */
   public void testRummikubHasRunOfLength5OrMore04()
   {
      ArrayList<RummikubTiles> hand = new ArrayList<RummikubTiles>();
      hand.add(0, new RummikubTiles("red", 5));
      hand.add(1, new RummikubTiles("blue", 5));
      hand.add(2, new RummikubTiles("orange", 5));
      hand.add(3, new RummikubTiles("red", 8));
      hand.add(4, new RummikubTiles("red", 7));
      hand.add(5, new RummikubTiles("blue", 13));
      hand.add(6, new RummikubTiles("red", 12));
      hand.add(7, new RummikubTiles("orange", 1));
      hand.add(8, new RummikubTiles("orange", 9));
      hand.add(9, new RummikubTiles("black", 1));
      hand.add(10, new RummikubTiles("black", 2));
      hand.add(11, new RummikubTiles("black", 4));
      hand.add(12, new RummikubTiles("black", 7));
      hand.add(13, new RummikubTiles("black", 12));

      hand.set(9, new RummikubTiles("blue", 12));
      hand.set(12, new RummikubTiles("blue", 10));
      hand.set(6, new RummikubTiles("red", 11));
      Rummikub r = new Rummikub(hand);
      boolean ans = r.hasRun();
      assertEquals(false, ans);

      hand.set(11, new RummikubTiles("blue", 9));
      hand.set(4, new RummikubTiles("blue", 7));
      r = new Rummikub(hand);
      assertEquals(false, r.hasRun());

      hand.set(13, new RummikubTiles("blue", 11));
      r = new Rummikub(hand);
      assertEquals(true, r.hasRun());

      hand.set(3, new RummikubTiles("blue", 8));
      r = new Rummikub(hand);
      assertEquals(true, r.hasRun());
   }


/*
 *   you may assume that all cards in tiles are used in scoring
 *   
 *   That is,if tiles.size() == n, the all n cards will be used in forming the run or forming the group
 *   
 *   preCondition:  tiles contains either a group or a run, but not both a group and a run
 */
   public void testRummikubGetPointValueGroupOf3_05()
   {
      ArrayList<RummikubTiles> hand = new ArrayList<RummikubTiles>();
      hand.add(new RummikubTiles("red", 7));
      hand.add(new RummikubTiles("blue", 7));
      hand.add(new RummikubTiles("orange", 7));

      Rummikub r = new Rummikub(hand);
      assertEquals(21, Rummikub.pointValue(hand));

      ArrayList<RummikubTiles> play = new ArrayList<RummikubTiles>();
      play.add(new RummikubTiles("red", 13));
      play.add(new RummikubTiles("orange", 13));
      play.add(new RummikubTiles("black", 13));
      assertEquals(3*13, Rummikub.pointValue(play));

      play = new ArrayList<RummikubTiles>();
      play.add(new RummikubTiles("red", 4));
      play.add(new RummikubTiles("orange", 4));
      play.add(new RummikubTiles("black", 4));
      assertEquals(3*4, Rummikub.pointValue(play));
   }

   public void testRummikubGetPointValueGroupOf4_06()
   {
      ArrayList<RummikubTiles> hand = new ArrayList<RummikubTiles>();
      hand.add(new RummikubTiles("red", 8));
      hand.add(new RummikubTiles("blue", 8));
      hand.add(new RummikubTiles("orange", 8));
      hand.add(new RummikubTiles("black", 8));
      Rummikub r = new Rummikub(hand);
      assertEquals(4*8, Rummikub.pointValue(hand));

      ArrayList<RummikubTiles> play = new ArrayList<RummikubTiles>();
      play.add(new RummikubTiles("red", 1));
      play.add(new RummikubTiles("blue", 1));
      play.add(new RummikubTiles("orange", 1));
      play.add(new RummikubTiles("black", 1));
      assertEquals(4*1, Rummikub.pointValue(play));

      play = new ArrayList<RummikubTiles>();
      play.add(new RummikubTiles("red", 3));
      play.add(new RummikubTiles("black", 3));
      play.add(new RummikubTiles("blue", 3));
      play.add(new RummikubTiles("orange", 3));
      assertEquals(4*3, Rummikub.pointValue(play));

      play = new ArrayList<RummikubTiles>();
      play.add(new RummikubTiles("red", 11));
      play.add(new RummikubTiles("black",11));
      play.add(new RummikubTiles("blue", 11));
      play.add(new RummikubTiles("orange", 11));
      assertEquals(4*11, Rummikub.pointValue(play));
   }

   public void testRummikubGetPointValueRunOfLength3_07()
   {
      ArrayList<RummikubTiles> hand = new ArrayList<RummikubTiles>();
      hand.add(new RummikubTiles("red", 7));
      hand.add(new RummikubTiles("red", 6));
      hand.add(new RummikubTiles("red", 5));

      Rummikub r = new Rummikub(hand);
      assertEquals(5+6+7, Rummikub.pointValue(hand));

      ArrayList<RummikubTiles> play = new ArrayList<RummikubTiles>();
      play.add(new RummikubTiles("orange", 11));
      play.add(new RummikubTiles("orange", 13));
      play.add(new RummikubTiles("orange", 12));
      assertEquals(11+12+13, Rummikub.pointValue(play));

      play = new ArrayList<RummikubTiles>();
      play.add(new RummikubTiles("blue", 9));
      play.add(new RummikubTiles("blue", 11));
      play.add(new RummikubTiles("blue", 10));
      assertEquals(9+10+11, Rummikub.pointValue(play));
   }

   public void testRummikubGetPointValueRunOfLength4_08()
   {
      ArrayList<RummikubTiles> hand = new ArrayList<RummikubTiles>();
      hand.add(new RummikubTiles("orange", 9));
      hand.add(new RummikubTiles("orange", 6));
      hand.add(new RummikubTiles("orange", 8));
      hand.add(new RummikubTiles("orange", 7));

      Rummikub r = new Rummikub(hand);
      assertEquals(6+7+8+9, Rummikub.pointValue(hand));

      ArrayList<RummikubTiles> play = new ArrayList<RummikubTiles>();
      play.add(new RummikubTiles("black", 5));
      play.add(new RummikubTiles("black", 2));
      play.add(new RummikubTiles("black", 4));
      play.add(new RummikubTiles("black", 3));
      assertEquals(2+3+4+5, Rummikub.pointValue(play));

      play = new ArrayList<RummikubTiles>();
      play.add(new RummikubTiles("red", 10));
      play.add(new RummikubTiles("red", 8));
      play.add(new RummikubTiles("red", 9));
      play.add(new RummikubTiles("red", 11));
      assertEquals(8+9+10+11, Rummikub.pointValue(play));
   }

   public void testRummikubGetMaxPointValueInHand09()
   {
      ArrayList<RummikubTiles> hand = new ArrayList<RummikubTiles>();
      hand.add(0, new RummikubTiles("red", 1));
      hand.add(1, new RummikubTiles("blue", 5));
      hand.add(2, new RummikubTiles("orange", 5));
      hand.add(3, new RummikubTiles("red", 8));
      hand.add(4, new RummikubTiles("red", 7));
      hand.add(5, new RummikubTiles("blue", 13));
      hand.add(6, new RummikubTiles("red", 12));
      hand.add(7, new RummikubTiles("orange", 1));
      hand.add(8, new RummikubTiles("orange", 9));
      hand.add(9, new RummikubTiles("black", 10));
      hand.add(10, new RummikubTiles("black", 2));
      hand.add(11, new RummikubTiles("black", 4));
      hand.add(12, new RummikubTiles("black", 7));
      hand.add(13, new RummikubTiles("black", 12));

      Rummikub r = new Rummikub(hand);
      assertEquals(0, r.maxPointValueInHand());

      hand.set(10, new RummikubTiles("black", 1));
      r = new Rummikub(hand);
      assertEquals(3, r.maxPointValueInHand());

      hand.set(1, new RummikubTiles("red", 9));
      r = new Rummikub(hand);
      assertEquals(Math.max(3, 7+8+9), r.maxPointValueInHand());

      hand.set(5, new RummikubTiles("blue", 12));
      hand.set(8, new RummikubTiles("orange", 12));
      r = new Rummikub(hand);
      assertEquals(Math.max(4*12, Math.max(3, 7+8+9)), r.maxPointValueInHand());

      hand.set(2, new RummikubTiles("black", 11));
      hand.set(3, new RummikubTiles("black", 8));
      hand.set(12, new RummikubTiles("black", 9));
      r = new Rummikub(hand);
      assertEquals(Math.max(Math.max(4*12, 8+9+10+11+12), Math.max(3, 7+8+9)), r.maxPointValueInHand());
      assertEquals(50, r.maxPointValueInHand());
   }

   public void testRummikubTestAll10()
   {
      testRummikubHasGroupof3or4ofaKind02();
      testRummikubHasRunOfLength3Or4_03();
      testRummikubHasRunOfLength5OrMore04();
      testRummikubGetPointValueGroupOf3_05();
      testRummikubGetPointValueGroupOf4_06();
      testRummikubGetPointValueRunOfLength3_07();
      testRummikubGetPointValueRunOfLength4_08();
      testRummikubGetMaxPointValueInHand09();

      ArrayList<RummikubTiles> hand = new ArrayList<RummikubTiles>();
      hand.add(0, new RummikubTiles("red", 5));
      hand.add(1, new RummikubTiles("blue", 5));
      hand.add(2, new RummikubTiles("orange", 5));
      hand.add(3, new RummikubTiles("red", 4));
      hand.add(4, new RummikubTiles("red", 7));
      hand.add(5, new RummikubTiles("blue", 4));
      hand.add(6, new RummikubTiles("red", 12));
      hand.add(7, new RummikubTiles("orange", 1));
      hand.add(8, new RummikubTiles("orange", 4));
      hand.add(9, new RummikubTiles("black", 10));
      hand.add(10, new RummikubTiles("black", 2));
      hand.add(11, new RummikubTiles("black", 4));
      hand.add(12, new RummikubTiles("black", 7));
      hand.add(13, new RummikubTiles("black", 12));

      Rummikub r = new Rummikub(hand);
      assertEquals(16, r.maxPointValueInHand());
   }

   public void testFunWith2DArrays01()
   {
      FunWith2DArrays f2d = new FunWith2DArrays();
      int[] walk = { 3, 6, 5, 2, 1, 0, 7, 4, 3};
      int[][] ans = FunWith2DArrays.pathWalk(4, 2, 1, walk);
      assertEquals(1, ans[0][0]);
      assertEquals(1, ans[0][1]);
      assertEquals(0, ans[0][2]);
      assertEquals(0, ans[0][3]);

      assertEquals(0, ans[1][0]);
      assertEquals(1, ans[1][1]);
      assertEquals(0, ans[1][2]);
      assertEquals(0, ans[1][3]);

      assertEquals(0, ans[2][0]);
      assertEquals(2, ans[2][1]);
      assertEquals(1, ans[2][2]);
      assertEquals(0, ans[2][3]);

      assertEquals(0, ans[3][0]);
      assertEquals(1, ans[3][1]);
      assertEquals(3, ans[3][2]);
      assertEquals(0, ans[3][3]);

      assertEquals(true, FunWith2DArrays.hasGynnProperty(41587));
      assertEquals(false, FunWith2DArrays.hasGynnProperty(2587));
      int[][] gynnNumbers1 = { {3, 6, 5, 2}, {1, 0, 7, 49}, {23, 66, 10, 88}, {48, 53, 200, 308} };
      assertEquals(true, FunWith2DArrays.hasArrayGynnProperty(gynnNumbers1));
      int[][] gynnNumbers2 = { {39, 6, 5, 8}, {1, 0, 72, 49}, {93, 66, 1, 88}, {428, 53, 0, 308} };
      assertEquals(false, FunWith2DArrays.hasArrayGynnProperty(gynnNumbers2));
      int[][] superGynnNumbers1 = { {3, 659, 5, 17}, {1, 0, 7, 49}, {23, 66, 10, 88}, {48, 53, 200, 308} };
      assertEquals(true, FunWith2DArrays.hasArraySuperGynnProperty(superGynnNumbers1));
      int[][] superGynnNumbers2 = { {3, 659, 5, 127}, {1, 0, 7, 49}, {23, 66, 10, 88}, {48, 53, 200, 308} };
      assertEquals(false, FunWith2DArrays.hasArraySuperGynnProperty(superGynnNumbers2));
    }

   public void testFunWith2DArraysPathWalkWithNoWrapAround02()
   {
      FunWith2DArrays f2d = new FunWith2DArrays();
      int[] walk = {0, 1, 3, 4, 5, 6, 5, 2, 0, 6, 7, 0, 2, 2, 2, 0, 6, 4 };
      int[][] ans = FunWith2DArrays.pathWalk(5, 2, 2, walk);
      assertEquals(0, ans[0][0]);
      assertEquals(0, ans[0][1]);
      assertEquals(1, ans[0][2]);
      assertEquals(2, ans[0][3]);
      assertEquals(0, ans[0][4]);

      assertEquals(1, ans[1][0]);
      assertEquals(1, ans[1][1]);
      assertEquals(3, ans[1][2]);
      assertEquals(1, ans[1][3]);
      assertEquals(1, ans[1][4]);

      assertEquals(1, ans[2][0]);
      assertEquals(0, ans[2][1]);
      assertEquals(1, ans[2][2]);
      assertEquals(0, ans[2][3]);
      assertEquals(1, ans[2][4]);

      assertEquals(0, ans[3][0]);
      assertEquals(1, ans[3][1]);
      assertEquals(2, ans[3][2]);
      assertEquals(1, ans[3][3]);
      assertEquals(0, ans[3][4]);

      assertEquals(0, ans[4][0]);
      assertEquals(1, ans[4][1]);
      assertEquals(1, ans[4][2]);
      assertEquals(0, ans[4][3]);
      assertEquals(0, ans[4][4]);
   }

   public void testFunWith2DArraysPathWalkWithWrapAround03()
   {
      FunWith2DArrays f2d = new FunWith2DArrays();
      int[] walk = { 3, 5, 6, 5, 0, 2, 7, 1, 7, 2, 0, 6, 4, 7, 4, 5, 3, 6, 1, 7, 2, 2, 4, 3, 4};
      int[][] ans = FunWith2DArrays.pathWalk(6, 2, 3, walk);
      assertEquals(1, ans[0][0]);
      assertEquals(1, ans[0][1]);
      assertEquals(1, ans[0][2]);
      assertEquals(0, ans[0][3]);
      assertEquals(0, ans[0][4]);
      assertEquals(0, ans[0][5]);

      assertEquals(2, ans[1][0]);
      assertEquals(3, ans[1][1]);
      assertEquals(1, ans[1][2]);
      assertEquals(0, ans[1][3]);
      assertEquals(0, ans[1][4]);
      assertEquals(1, ans[1][5]);

      assertEquals(1, ans[2][0]);
      assertEquals(1, ans[2][1]);
      assertEquals(1, ans[2][2]);
      assertEquals(1, ans[2][3]);
      assertEquals(0, ans[2][4]);
      assertEquals(1, ans[2][5]);

      assertEquals(1, ans[3][0]);
      assertEquals(1, ans[3][1]);
      assertEquals(1, ans[3][2]);
      assertEquals(0, ans[3][3]);
      assertEquals(1, ans[3][4]);
      assertEquals(1, ans[3][5]);

      assertEquals(0, ans[4][0]);
      assertEquals(1, ans[4][1]);
      assertEquals(3, ans[4][2]);
      assertEquals(1, ans[4][3]);
      assertEquals(0, ans[4][4]);
      assertEquals(0, ans[4][5]);

      assertEquals(0, ans[5][0]);
      assertEquals(1, ans[5][1]);
      assertEquals(0, ans[5][2]);
      assertEquals(0, ans[5][3]);
      assertEquals(0, ans[5][4]);
      assertEquals(0, ans[5][5]);

      f2d = new FunWith2DArrays();
      int[] walk1 = { 1, 3, 0, 4, 7, 5};
      int[][] ans1 = FunWith2DArrays.pathWalk(5, 0, 2, walk1);
      assertEquals(0, ans1[0][0]);
      assertEquals(0, ans1[0][1]);
      assertEquals(2, ans1[0][2]);
      assertEquals(0, ans1[0][3]);
      assertEquals(2, ans1[0][4]);

      assertEquals(0, ans1[1][0]);
      assertEquals(0, ans1[1][1]);
      assertEquals(0, ans1[1][2]);
      assertEquals(0, ans1[1][3]);
      assertEquals(0, ans1[1][4]);

      assertEquals(0, ans1[2][0]);
      assertEquals(0, ans1[2][1]);
      assertEquals(0, ans1[2][2]);
      assertEquals(0, ans1[2][3]);
      assertEquals(0, ans1[2][4]);

      assertEquals(0, ans1[3][0]);
      assertEquals(0, ans1[3][1]);
      assertEquals(0, ans1[3][2]);
      assertEquals(0, ans1[3][3]);
      assertEquals(0, ans1[3][4]);

      assertEquals(0, ans1[4][0]);
      assertEquals(0, ans1[4][1]);
      assertEquals(0, ans1[4][2]);
      assertEquals(2, ans1[4][3]);
      assertEquals(1, ans1[4][4]);
   }

   public void testFunWith2DArraysPathWalkWithCornerWrapAround04()
   {
      FunWith2DArrays f2d = new FunWith2DArrays();
      int[] walk = { 6, 7, 5, 2, 1, 0, 6, 4, 3, 0, 5, 3};
      int[][] ans = FunWith2DArrays.pathWalk(6, 0, 1, walk);
      assertEquals(2, ans[0][0]);
      assertEquals(1, ans[0][1]);
      assertEquals(0, ans[0][2]);
      assertEquals(0, ans[0][3]);
      assertEquals(1, ans[0][4]);
      assertEquals(2, ans[0][5]);

      assertEquals(1, ans[1][0]);
      assertEquals(0, ans[1][1]);
      assertEquals(0, ans[1][2]);
      assertEquals(0, ans[1][3]);
      assertEquals(0, ans[1][4]);
      assertEquals(0, ans[1][5]);

      assertEquals(0, ans[2][0]);
      assertEquals(0, ans[2][1]);
      assertEquals(0, ans[2][2]);
      assertEquals(0, ans[2][3]);
      assertEquals(0, ans[2][4]);
      assertEquals(0, ans[2][5]);

      assertEquals(0, ans[3][0]);
      assertEquals(0, ans[3][1]);
      assertEquals(0, ans[3][2]);
      assertEquals(0, ans[3][3]);
      assertEquals(0, ans[3][4]);
      assertEquals(0, ans[3][5]);

      assertEquals(1, ans[4][0]);
      assertEquals(0, ans[4][1]);
      assertEquals(0, ans[4][2]);
      assertEquals(0, ans[4][3]);
      assertEquals(0, ans[4][4]);
      assertEquals(1, ans[4][5]);

      assertEquals(2, ans[5][0]);
      assertEquals(0, ans[5][1]);
      assertEquals(0, ans[5][2]);
      assertEquals(0, ans[5][3]);
      assertEquals(0, ans[5][4]);
      assertEquals(2, ans[5][5]);
   }

   public void testFunWith2DArraysHasGynnPropertyPositiveNumbersOnly05()
   {
      assertEquals(true, FunWith2DArrays.hasGynnProperty(0));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(111111));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(33333));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(4444));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(5555));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(777));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(8888));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(10000));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(345780));

      assertEquals(false, FunWith2DArrays.hasGynnProperty(111119));
      assertEquals(false, FunWith2DArrays.hasGynnProperty(23333));
      assertEquals(false, FunWith2DArrays.hasGynnProperty(4442555));
      assertEquals(false, FunWith2DArrays.hasGynnProperty(666977));
   }

   public void testFunWith2DArraysHasGynnPropertyBothPosAndNegNumbers06()
   {
      assertEquals(true, FunWith2DArrays.hasGynnProperty(-111111));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(-33333));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(-4444));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(-5555));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(-777));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(-8888));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(-10000));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(-345780));

      assertEquals(false, FunWith2DArrays.hasGynnProperty(111119));
      assertEquals(false, FunWith2DArrays.hasGynnProperty(-23333));
      assertEquals(false, FunWith2DArrays.hasGynnProperty(4442555));
      assertEquals(false, FunWith2DArrays.hasGynnProperty(-666977));
   }

   public void testFunWith2DArraysHasArrayGynnPropertyPositiveNumbersOnly07()
   {
      int[][] num = { { 1,  8, 29, 12, 39},
                      { 1,  3,  4,  5,  6},
                      {70, 16, 34, 85,  0},
                      {12, 30, 17,  6,  5},
                      {12, 19, 29, 20, 90} };
      assertEquals(true, FunWith2DArrays.hasArrayGynnProperty(num));

      int[][] num1 = { { 1,  8, 29, 12,  3},
                       { 1,  3,  4,  5, 26},
                       {70, 16, 34, 85, 20},
                       {12, 30, 17,  6,  5},
                       { 1,  1,  5, 30,  0} };
      assertEquals(true, FunWith2DArrays.hasArrayGynnProperty(num1));

      int[][] num2 = { { 1,  8, 29, 12, 93},
                       { 1,  3,  4,  5, 26},
                       {70, 16, 34, 85, 20},
                       {12, 30, 17,  6,  5},
                       { 1,  1,  5, 30,  0} };
      assertEquals(false, FunWith2DArrays.hasArrayGynnProperty(num2));

      int[][] num3 = { { 1,  8, 29, 12,  3},
                       {91,  3,  4,  5, 26},
                       {70, 12, 34, 85, 20},
                       {18, 30, 27, 96,  5},
                       {21, 91,  5, 30,  0} };
      assertEquals(true, FunWith2DArrays.hasArrayGynnProperty(num3));

      int[][] num4 = { { 1,  8, 29, 12,  3},
                       {91,  3, 29,  5, 26},
                       {70, 12, 34, 85, 20},
                       {18, 30, 27, 96,  5},
                       {21, 91,  5, 30,  0} };
      assertEquals(false, FunWith2DArrays.hasArrayGynnProperty(num4));
   }

   public void testFunWith2DArraysHasArrayGynnPropertyPosAndNegNumbers08()
   {
      int[][] num = { { -1,   8, -29, -12,  39},
                      {  1,   3,   4,  -5,  -6},
                      {-70, -16, -34, -85,   0},
                      {-12,  30,  17,   6,  -5},
                      {-12, -19, -29, -20, -90} };
      assertEquals(true, FunWith2DArrays.hasArrayGynnProperty(num));

      int[][] num1 = { {  1,   8, -29, -12,   3},
                       { -1,  -3,   4,   5, -26},
                       {-70,  16, -34,  85,  20},
                       { 12,  30,  17,  -6,  -5},
                       {  1,  -1,  -5,  30,   0} };
      assertEquals(true, FunWith2DArrays.hasArrayGynnProperty(num1));

      int[][] num2 = { { 1,  8, 29, 12, 93},
                       { 1,  3,  4,  5, 26},
                       {70, 16, 34, 85, 20},
                       {12, 30, 17,  6,  5},
                       { 1,  1,  5, 30,  0} };
      assertEquals(false, FunWith2DArrays.hasArrayGynnProperty(num2));

      int[][] num3 = { { -1,   8,  29,  12,  -3},
                       { 91,  -3,   4,   5,  26},
                       { 70,  12, -34, -85,  20},
                       {-18, -30,  27,  96,  -5},
                       { 21,  91,  -5, -30,   0} };
      assertEquals(true, FunWith2DArrays.hasArrayGynnProperty(num3));

      int[][] num4 = { { 1,  8, 29, 12,  3},
                       {91,  3, 29,  5, 26},
                       {70, 12, 34, 85, 20},
                       {18, 30, 27, 96,  5},
                       {21, 91,  5, 30,  0} };
      assertEquals(false, FunWith2DArrays.hasArrayGynnProperty(num4));
   }

   public void testFunWith2DArraysHasArraySuperGynnPropertyPositiveNumbersOnly09()
   {
      int[][] num = { { 1,  8, 29, 12, 39},
                      { 1,  3,  4,  5,  6},
                      {70, 16, 34, 85,  0},
                      {12, 30, 17,  6,  5},
                      {12, 19, 29, 20, 90} };
      assertEquals(false, FunWith2DArrays.hasArraySuperGynnProperty(num));

      int[][] num1 = { { 1,  8, 29, 12,  3},
                       { 1,  3,  4,  5, 26},
                       {70, 16, 34, 85, 20},
                       {12, 30, 17,  6,  5},
                       { 1,  1,  5, 30,  0} };
      assertEquals(true, FunWith2DArrays.hasArraySuperGynnProperty(num1));

      int[][] num2 = { { 1,  8, 29, 12, 93},
                       { 1,  3,  4,  5, 26},
                       {70, 16, 34, 85, 20},
                       {12, 30, 17,  6,  5},
                       { 1,  1,  5, 30,  0} };
      assertEquals(false, FunWith2DArrays.hasArraySuperGynnProperty(num2));

      int[][] num3 = { { 1,  8, 29, 12,  3},
                       {91,  3,  4,  5, 26},
                       {70, 12, 34, 85, 20},
                       {18, 30, 27, 96,  5},
                       {21, 91,  5, 30,  0} };
      assertEquals(true, FunWith2DArrays.hasArraySuperGynnProperty(num3));

      int[][] num4 = { { 1,  8, 29, 12,  3},
                       {91,  3, 29,  5, 26},
                       {70, 12, 34, 85, 20},
                       {18, 30, 27, 96,  5},
                       {21, 91,  5, 30,  0} };
      assertEquals(false, FunWith2DArrays.hasArraySuperGynnProperty(num4));
    }

   public void testFunWith2DArraysHasArraySuperGynnPropertyBothPosAndNegNumbers10()
   {
      int[][] num = { { -1,   8, -29, -12,  39},
                      {  1,   3,   4,  -5,  -6},
                      {-70, -16, -34, -85,   0},
                      {-12,  30,  17,   6,  -5},
                      {-12, -19, -29, -20, -90} };
      assertEquals(false, FunWith2DArrays.hasArraySuperGynnProperty(num));

      int[][] num1 = { {  1,   8, -29, -12,   3},
                       { -1,  -3,   4,   5, -26},
                       {-70,  16, -34,  85,  20},
                       { 12,  30,  17,  -6,  -5},
                       {  1,  -1,  -5,  30,   0} };
      assertEquals(true, FunWith2DArrays.hasArraySuperGynnProperty(num1));

      int[][] num2 = { { 1,  8, 29, 12, 93},
                       { 1,  3,  4,  5, 26},
                       {70, 16, 34, 85, 20},
                       {12, 30, 17,  6,  5},
                       { 1,  1,  5, 30,  0} };
      assertEquals(false, FunWith2DArrays.hasArraySuperGynnProperty(num2));

      int[][] num3 = { { -1,   8,  29,  12,  -3},
                       { 91,  -3,   4,   5,  26},
                       { 70,  12, -34, -85,  20},
                       {-18, -30,  27,  96,  -5},
                       { 21,  91,  -5, -30,   0} };
      assertEquals(true, FunWith2DArrays.hasArraySuperGynnProperty(num3));

      int[][] num4 = { { 1,  8, 29, 12,  3},
                       {91,  3, 29,  5, 26},
                       {70, 12, 34, 85, 20},
                       {18, 30, 27, 96,  5},
                       {21, 91,  5, 30,  0} };
      assertEquals(false, FunWith2DArrays.hasArraySuperGynnProperty(num4));
    }

    public void testIncreasingSequence01()
   {
      Increasing h = new Increasing();

      ArrayList<Integer> num = new ArrayList<Integer>();
      num.add(new Integer(5));
      num.add(new Integer(13));
      num.add(new Integer(23));
      num.add(new Integer(29));

      List<Integer> inc = h.longestIncreasingSequence(num);
      assertEquals(4, inc.size());
      assertEquals(new Integer(5), inc.get(0));
      assertEquals(new Integer(13), inc.get(1));
      assertEquals(new Integer(23), inc.get(2));
      assertEquals(new Integer(29), inc.get(3));

      num = new ArrayList<Integer>();           //5, -4, 7, -2,  6, 8, 4 3, 9, 7
      num.add(new Integer(5));
      num.add(new Integer(-4));
      num.add(new Integer(7));
      num.add(new Integer(-2));
      num.add(new Integer(6));
      num.add(new Integer(8));
      num.add(new Integer(4));
      num.add(new Integer(3));
      num.add(new Integer(9));
      num.add(new Integer(7));

      inc = h.longestIncreasingSequence(num);   //  -4 -2 6 8 9
      assertEquals(5, inc.size());
      assertEquals(new Integer(-4), inc.get(0));
      assertEquals(new Integer(-2), inc.get(1));
      assertEquals(new Integer(6), inc.get(2));
      assertEquals(new Integer(8), inc.get(3));
      assertEquals(new Integer(9), inc.get(4));
   }

   public void testIncreasingSequenceLength3_02()
   {
      Increasing h = new Increasing();

      int[] num1 = {100, 1, 98, 12, 97, 57, 21, 5};
      ArrayList<Integer> num = new ArrayList<Integer>();
      for (int x : num1)  num.add(x);

      List<Integer> inc = h.longestIncreasingSequence(num);
      assertEquals(3, inc.size());
      assertEquals(new Integer(1), inc.get(0));
      assertEquals(new Integer(12), inc.get(1));
      assertEquals(new Integer(21), inc.get(2));


      int[] num2 = {0, 11, 8, 7, 1, 3};
      num = new ArrayList<Integer>();
      for (int x : num2)  num.add(x);

      inc = h.longestIncreasingSequence(num);
      assertEquals(3, inc.size());
      assertEquals(new Integer(0), inc.get(0));
      assertEquals(new Integer(1), inc.get(1));
      assertEquals(new Integer(3), inc.get(2));
   }

   public void testIncreasingSequenceLength4_03()
   {
      Increasing h = new Increasing();

      int[] num1 = {1, 198, 192, 191, 57, 171, 155, 169};
      ArrayList<Integer> num = new ArrayList<Integer>();
      for (int x : num1)  num.add(x);

      List<Integer> inc = h.longestIncreasingSequence(num);
      assertEquals(4, inc.size());
      assertEquals(new Integer(1), inc.get(0));
      assertEquals(new Integer(57), inc.get(1));
      assertEquals(new Integer(155), inc.get(2));
      assertEquals(new Integer(169), inc.get(3));

      int[] num2 = {30, 11, -8, -7, 1, 3};
      num = new ArrayList<Integer>();
      for (int x : num2)  num.add(x);

      inc = h.longestIncreasingSequence(num);
      assertEquals(4, inc.size());
      assertEquals(new Integer(-8), inc.get(0));
      assertEquals(new Integer(-7), inc.get(1));
      assertEquals(new Integer(1), inc.get(2));
      assertEquals(new Integer(3), inc.get(3));
   }

   public void testIncreasingSequenceLength5_04()
   {
      Increasing h = new Increasing();

      int[] num1 = {2011, 198, 9, 11, 157, 141, 135, 16, 29, 31};
      ArrayList<Integer> num = new ArrayList<Integer>();
      for (int x : num1)  num.add(x);

      List<Integer> inc = h.longestIncreasingSequence(num);
      assertEquals(5, inc.size());
      assertEquals(new Integer(9), inc.get(0));
      assertEquals(new Integer(11), inc.get(1));
      assertEquals(new Integer(16), inc.get(2));
      assertEquals(new Integer(29), inc.get(3));
      assertEquals(new Integer(31), inc.get(4));

      int[] num2 = {30, -51, 11, -33, -8, -20, -7, -19, -11, -32};
      num = new ArrayList<Integer>();
      for (int x : num2)  num.add(x);

      inc = h.longestIncreasingSequence(num);
      assertEquals(5, inc.size());
      assertEquals(new Integer(-51), inc.get(0));
      assertEquals(new Integer(-33), inc.get(1));
      assertEquals(new Integer(-20), inc.get(2));
      assertEquals(new Integer(-19), inc.get(3));
      assertEquals(new Integer(-11), inc.get(4));
   }

   public void testIncreasingSequenceLength6_05()
   {
      Increasing h = new Increasing();

      int[] num1 = {2011, 1998, 9, 1911, 157, 1141, 165, 1016, 229, 931, 231, 333, 230};
      ArrayList<Integer> num = new ArrayList<Integer>();
      for (int x : num1)  num.add(x);

      List<Integer> inc = h.longestIncreasingSequence(num);
      assertEquals(6, inc.size());
      assertEquals(new Integer(9), inc.get(0));
      assertEquals(new Integer(157), inc.get(1));
      assertEquals(new Integer(165), inc.get(2));
      assertEquals(new Integer(229), inc.get(3));
      assertEquals(new Integer(231), inc.get(4));
      assertEquals(new Integer(333), inc.get(5));

      int[] num2 = {300, 251, 211, -33, -28, -20, -7, 199, 181, 179, 160, -2, 3};
      num = new ArrayList<Integer>();
      for (int x : num2)  num.add(x);

      inc = h.longestIncreasingSequence(num);
      assertEquals(6, inc.size());
      assertEquals(new Integer(-33), inc.get(0));
      assertEquals(new Integer(-28), inc.get(1));
      assertEquals(new Integer(-20), inc.get(2));
      assertEquals(new Integer(-7), inc.get(3));
      assertEquals(new Integer(-2), inc.get(4));
      assertEquals(new Integer(3), inc.get(5));
   }

   public void testIncreasingSequenceLength7_06()
   {
      Increasing h = new Increasing();

      int[] num1 = {2011, 1998, 9, 1911, 157, 1141, 165, 1016, 229, 931, 231, 899, 877, 333, 334};
      ArrayList<Integer> num = new ArrayList<Integer>();
      for (int x : num1)  num.add(x);

      List<Integer> inc = h.longestIncreasingSequence(num);
      assertEquals(7, inc.size());
      assertEquals(new Integer(9), inc.get(0));
      assertEquals(new Integer(157), inc.get(1));
      assertEquals(new Integer(165), inc.get(2));
      assertEquals(new Integer(229), inc.get(3));
      assertEquals(new Integer(231), inc.get(4));
      assertEquals(new Integer(333), inc.get(5));
      assertEquals(new Integer(334), inc.get(6));

      int[] num2 = {300, 251, 211, -33, -28, -20, -7, 199, 181, 179, -2,160, 3, 11};
      num = new ArrayList<Integer>();
      for (int x : num2)  num.add(x);

      inc = h.longestIncreasingSequence(num);
      assertEquals(7, inc.size());
      assertEquals(new Integer(-33), inc.get(0));
      assertEquals(new Integer(-28), inc.get(1));
      assertEquals(new Integer(-20), inc.get(2));
      assertEquals(new Integer(-7), inc.get(3));
      assertEquals(new Integer(-2), inc.get(4));
      assertEquals(new Integer(3), inc.get(5));
      assertEquals(new Integer(11), inc.get(6));
   }

   public void testIncreasingSequenceLength4_Length5_07()
   {
      testIncreasingSequenceLength4_03();
      testIncreasingSequenceLength5_04();
   }

   public void testIncreasingSequenceLength4_Length5_Length6_08()
   {
      testIncreasingSequenceLength4_Length5_07();
      testIncreasingSequenceLength6_05();
   }

   public void testIncreasingSequenceLength4_Length5_Length6_Length7_09()
   {
      testIncreasingSequenceLength4_Length5_Length6_08();
      testIncreasingSequenceLength7_06();
   }

   public void testIncreasingSequenceLengthMisc_10()
   {
      Increasing h = new Increasing();

      int[] num3 = {-4, 2, 11};
      ArrayList<Integer> num = new ArrayList<Integer>();
      for (int x : num3)  num.add(x);

      List<Integer> inc = h.longestIncreasingSequence(num);
      assertEquals(3, inc.size());
      assertEquals(new Integer(-4), inc.get(0));
      assertEquals(new Integer(2), inc.get(1));
      assertEquals(new Integer(11), inc.get(2));

      int[] num4 = {3, 11, 18, 27};
      num = new ArrayList<Integer>();
      for (int x : num4)  num.add(x);

      inc = h.longestIncreasingSequence(num);
      assertEquals(4, inc.size());
      assertEquals(new Integer(3), inc.get(0));
      assertEquals(new Integer(11), inc.get(1));
      assertEquals(new Integer(18), inc.get(2));
      assertEquals(new Integer(27), inc.get(3));

      int[] num5 = {3, 11, 15, 18, 27};
      num = new ArrayList<Integer>();
      for (int x : num5)  num.add(x);

      inc = h.longestIncreasingSequence(num);
      assertEquals(5, inc.size());
      assertEquals(new Integer(3), inc.get(0));
      assertEquals(new Integer(11), inc.get(1));
      assertEquals(new Integer(15), inc.get(2));
      assertEquals(new Integer(18), inc.get(3));
      assertEquals(new Integer(27), inc.get(4));

      int[] num6 = {3, 11, 15, 18, 27, 49};
      num = new ArrayList<Integer>();
      for (int x : num6)  num.add(x);

      inc = h.longestIncreasingSequence(num);
      assertEquals(6, inc.size());
      assertEquals(new Integer(3), inc.get(0));
      assertEquals(new Integer(11), inc.get(1));
      assertEquals(new Integer(15), inc.get(2));
      assertEquals(new Integer(18), inc.get(3));
      assertEquals(new Integer(27), inc.get(4));
      assertEquals(new Integer(49), inc.get(5));

      int[] num7 = {3, 11, 15, 18, 27, 49, 77};
      num = new ArrayList<Integer>();
      for (int x : num7)  num.add(x);

      inc = h.longestIncreasingSequence(num);
      assertEquals(7, inc.size());
      assertEquals(new Integer(3), inc.get(0));
      assertEquals(new Integer(11), inc.get(1));
      assertEquals(new Integer(15), inc.get(2));
      assertEquals(new Integer(18), inc.get(3));
      assertEquals(new Integer(27), inc.get(4));
      assertEquals(new Integer(49), inc.get(5));
      assertEquals(new Integer(77), inc.get(6));
   }

   public void testPartitionThis01()
   {
      assertEquals(4, PartitionThis.sumDigits(103));
      assertEquals(6, PartitionThis.sumDigits(-24));
      assertEquals(9+2+3+7, PartitionThis.sumDigits(-9237));
      assertEquals(1+5+0+8+6, PartitionThis.sumDigits(15086));
      assertEquals(true, PartitionThis.isPartitionable(415041131, 5));
      assertEquals(true, PartitionThis.isPartitionable(410250101, 7));
      assertEquals(false, PartitionThis.isPartitionable(415041132, 5));

      assertEquals(0, PartitionThis.minPartitionDegree(0));
      assertEquals(5, PartitionThis.minPartitionDegree(415041131));
      assertEquals(28, PartitionThis.minPartitionDegree(3054628));
   }

   public void testPartitionThisPositiveNumberSumDigits02()
   {
      assertEquals(1+3, PartitionThis.sumDigits(13));
      assertEquals(2+1+3, PartitionThis.sumDigits(213));
      assertEquals(7+4+6+5, PartitionThis.sumDigits(7465));
      assertEquals(9+8+2+7+5, PartitionThis.sumDigits(98275));
      assertEquals(4+0+6+9+5+5, PartitionThis.sumDigits(406955));
      assertEquals(8+8+9+9+0+0+5, PartitionThis.sumDigits(8899005));
   }

   public void testPartitionThisNegativeNumberSumDigits03()
   {
      assertEquals(1+3, PartitionThis.sumDigits(-31));
      assertEquals(2+1+3, PartitionThis.sumDigits(-213));
      assertEquals(7+4+6+5, PartitionThis.sumDigits(-7465));
      assertEquals(9+8+2+7+5, PartitionThis.sumDigits(-98275));
      assertEquals(4+0+6+9+5+5, PartitionThis.sumDigits(-406955));
      assertEquals(8+8+9+9+0+0+5, PartitionThis.sumDigits(-8899005));
   }

   public void testPartitionThisAllNumberSumDigits04()
   {
      testPartitionThisPositiveNumberSumDigits02();
      testPartitionThisNegativeNumberSumDigits03();
   }

   public void testPartitionThisDegree2_3_4isPartitionable05()
   {
      assertEquals(true, PartitionThis.isPartitionable(10011012, 2));       //  2
      assertEquals(true, PartitionThis.isPartitionable(20132013, 3));       //  3
      assertEquals(true, PartitionThis.isPartitionable(413120104, 4));      //  4

      assertEquals(false, PartitionThis.isPartitionable(1212, 2));
      assertEquals(false, PartitionThis.isPartitionable(11321, 3));
      assertEquals(false, PartitionThis.isPartitionable(413201, 4));
   }

   public void testPartitionThisDegree5_6_7isPartitionable06()
   {
      assertEquals(true, PartitionThis.isPartitionable(41504132, 5));
      assertEquals(true, PartitionThis.isPartitionable(4101501, 6));
      assertEquals(true, PartitionThis.isPartitionable(3003516, 6));
      assertEquals(true, PartitionThis.isPartitionable(741025101, 7));

      assertEquals(false, PartitionThis.isPartitionable(10212, 5));
      assertEquals(false, PartitionThis.isPartitionable(11321, 6));
      assertEquals(false, PartitionThis.isPartitionable(4132101, 7));
   }

   public void testPartitionThisDegree8_9_10isPartitionable07()
   {
      assertEquals(true, PartitionThis.isPartitionable(8700126, 8));
      assertEquals(true, PartitionThis.isPartitionable(501010144, 8));
      assertEquals(true, PartitionThis.isPartitionable(45010701, 9));
      assertEquals(true, PartitionThis.isPartitionable(930011481, 9));
      assertEquals(true, PartitionThis.isPartitionable(415041131, 10));
      assertEquals(true, PartitionThis.isPartitionable(91827364, 10));
      assertEquals(true, PartitionThis.isPartitionable(50000005, 10));

      assertEquals(false, PartitionThis.isPartitionable(87288, 8));
      assertEquals(false, PartitionThis.isPartitionable(91132102, 9));
      assertEquals(false, PartitionThis.isPartitionable(415041132, 10));
   }

   public void testPartitionThisDegreeAllisPartitionable08()
   {
      assertEquals(true, PartitionThis.isPartitionable(0, 0));
      assertEquals(true, PartitionThis.isPartitionable(20925483, 11));
      assertEquals(true, PartitionThis.isPartitionable(-1111111, 1));
      assertEquals(true, PartitionThis.isPartitionable(100000, 1));
      assertEquals(true, PartitionThis.isPartitionable(90909, 27));
      assertEquals(true, PartitionThis.isPartitionable(9815995, 23));
      assertEquals(true, PartitionThis.isPartitionable(41504932, 14));

      assertEquals(false, PartitionThis.isPartitionable(100000, 0));
      assertEquals(false, PartitionThis.isPartitionable(1111112, 1));
      assertEquals(false, PartitionThis.isPartitionable(0, 1));
      assertEquals(false, PartitionThis.isPartitionable(41504931, 14));
   }

   public void testPartitionThisMinPartionDegree09()
   {
      assertEquals(0, PartitionThis.minPartitionDegree(0));
      assertEquals(5, PartitionThis.minPartitionDegree(415041131));
      assertEquals(28, PartitionThis.minPartitionDegree(3054628));
   }

   public void testPartitionThisAllTest10()
   {
      testPartitionThis01();
      testPartitionThisAllNumberSumDigits04();
      testPartitionThisDegree2_3_4isPartitionable05();
      testPartitionThisDegree5_6_7isPartitionable06();
      testPartitionThisDegree8_9_10isPartitionable07();
      testPartitionThisDegreeAllisPartitionable08();
      testPartitionThisMinPartionDegree09();
   }

   public void testFunWith1DArrays01()
   {
      assertEquals(true, FunWith1DArrays.hasVasco("bookkeeper"));
      assertEquals(true, FunWith1DArrays.hasVasco("zuzim"));
      assertEquals(false, FunWith1DArrays.hasVasco("java"));
      assertEquals(false, FunWith1DArrays.hasVasco("computer"));

      String[] str1 = {"bookkeeper", "zuzim", "java", "computer", "program", "orange"};
      assertEquals(true, FunWith1DArrays.isMorath(str1));

      String[] str2 = {"bookkeeper", "zuzim", "java", "computer", "abba"};
      assertEquals(false, FunWith1DArrays.isMorath(str2));

      int[] num1 = {74, 23, 17, 80};
      assertEquals(true, FunWith1DArrays.has737(num1));

      int[] num2 = {74, 23, 17, 30};
      assertEquals(false, FunWith1DArrays.has737(num2));

      assertEquals(186, FunWith1DArrays.removeD(158556, 5));
      assertEquals(2168, FunWith1DArrays.removeD(201680, 0));
      assertEquals(57, FunWith1DArrays.removeD(100057, 1));
      assertEquals(-123, FunWith1DArrays.removeD(-123, 7));

      int[] num = {1195, 941, 100057, 3186};
      assertEquals(3186, FunWith1DArrays.largestWithOutDigitD(num, 1).get(0).intValue());
      assertEquals(1, FunWith1DArrays.largestWithOutDigitD(num, 1).size());

      int[] nums = {30936, 9334, 30137, 393336};
      assertEquals(true, FunWith1DArrays.largestWithOutDigitD(nums, 3).contains(new Integer(30936)));
      assertEquals(true, FunWith1DArrays.largestWithOutDigitD(nums, 3).contains(new Integer(393336)));
      assertEquals(2, FunWith1DArrays.largestWithOutDigitD(nums, 3).size());

      int[] n1 = {4, 3, 2, 1};
      assertEquals(6, FunWith1DArrays.degreeOfInversion(n1));
      int[] n2 = {1, 2, 3, 4};
      assertEquals(0, FunWith1DArrays.degreeOfInversion(n2));

      String[] st1 = {"d", "c", "i", "c", "g"};
      int[] ans = FunWith1DArrays.arrayRank(st1);
      assertEquals(5, ans.length);
      assertEquals(2, ans[0]);
      assertEquals(0, ans[1]);
      assertEquals(4, ans[2]);
      assertEquals(1, ans[3]);
      assertEquals(3, ans[4]);

      Comparable[] com2 = {new  Double(3.5), new  Double(39.5), new  Double(15.7), new  Double(3.7), 
                               new  Double(16.9), new  Double(5.9), new  Double(5.8) };
      ans = FunWith1DArrays.arrayRank(com2);
      assertEquals(7, ans.length);
      assertEquals(0, ans[0]);
      assertEquals(6, ans[1]);
      assertEquals(4, ans[2]);
      assertEquals(1, ans[3]);
      assertEquals(5, ans[4]);
      assertEquals(3, ans[5]);
      assertEquals(2, ans[6]);
   }

   public void testFunWith1DArraysHasVasco_02()
   {
      assertEquals(true, FunWith1DArrays.hasVasco("keepr"));
      assertEquals(true, FunWith1DArrays.hasVasco("myuim"));
      assertEquals(true, FunWith1DArrays.hasVasco("qwertyuioplkjhgfdsazxcvbnqm"));
      assertEquals(true, FunWith1DArrays.hasVasco("qwertyuioplkjhgfdjsazxcvbnm"));
      assertEquals(true, FunWith1DArrays.hasVasco("qwertvyuioplkjhgfdsazxcvbnm"));
      assertEquals(true, FunWith1DArrays.hasVasco("qmwertyuioplkjhgfdsazxcvbnm"));

      assertEquals(false, FunWith1DArrays.hasVasco("javel"));
      assertEquals(false, FunWith1DArrays.hasVasco("book"));
      assertEquals(false, FunWith1DArrays.hasVasco("ohio"));
      assertEquals(false, FunWith1DArrays.hasVasco("qwertyuioplkjhgfdsazxcvbnm"));
      assertEquals(false, FunWith1DArrays.hasVasco(""));
   }

   public void testFunWith1DArraysIsMorath_03()
   {
      String[] str1 = {"bookkeeper", "zuzim", "java", "computer", "program", "orange", ""};
      assertEquals(false, FunWith1DArrays.isMorath(str1));

      String[] str1a = {""};
      assertEquals(false, FunWith1DArrays.isMorath(str1a));

      String[] str1b = {"book", "zuzim", "java", "program", "eeee"};
      assertEquals(false, FunWith1DArrays.isMorath(str1b));

      String[] str1c = {"abcde", "fghij", "asfa", "qwewt", "abgha", "hbsah"};
      assertEquals(true, FunWith1DArrays.isMorath(str1c));

      String[] str2 = {"bioub", "uzium", "java", "", "abvba"};
      assertEquals(true, FunWith1DArrays.isMorath(str2));

      String[] str2a = {"abcde", "fghij", "asfa", "qwewt", "abgha", "hbsah", "ommni"};
      assertEquals(true, FunWith1DArrays.isMorath(str2a));

      String[] str2b = {"kiock", "ntion", "java", "abvba", ""};
      assertEquals(true, FunWith1DArrays.isMorath(str2b));
   }

   public void testFunWith1DArraysHas737_04()
   {
      int[] num1 = {74, 7023, 137, 70000, 3, 7};
      assertEquals(true, FunWith1DArrays.has737(num1));

      int[] num1a = {4, 2, 1, 70000, 3, 7};
      assertEquals(true, FunWith1DArrays.has737(num1a));

      int[] num1b = {74, 273, 137, 70000, 3, 7, 45, 12, 67, 7000000, 3000000, -7};
      assertEquals(true, FunWith1DArrays.has737(num1b));

      int[] num1c = {4, 2, 17, 70000, 7};
      assertEquals(true, FunWith1DArrays.has737(num1c));

      int[] num1d = {};
      assertEquals(true, FunWith1DArrays.has737(num1d));

      int[] num2 = {23, 17, 30};
      assertEquals(false, FunWith1DArrays.has737(num2));

      int[] num2a = {74, 23, 17, 30, 700000, 3, 456};
      assertEquals(false, FunWith1DArrays.has737(num2a));

      int[] num2b = {47, 23, 137, 30, 89};
      assertEquals(false, FunWith1DArrays.has737(num2b));

      int[] num2c = {74, 23, 17, 30};
      assertEquals(false, FunWith1DArrays.has737(num2c));

      int[] num2d = {-3, 12};
      assertEquals(false, FunWith1DArrays.has737(num2d));

      int[] num2e = {3};
      assertEquals(false, FunWith1DArrays.has737(num2e));
   }

   public void testFunWith1DArraysRemoveD_05()
   {
      assertEquals(12345678, FunWith1DArrays.removeD(123456780, 0));
      assertEquals(23456789, FunWith1DArrays.removeD(123456789, 1));
      assertEquals(13456789, FunWith1DArrays.removeD(123456789, 2));
      assertEquals(12456789, FunWith1DArrays.removeD(123456789, 3));
      assertEquals(12356789, FunWith1DArrays.removeD(123456789, 4));
      assertEquals(12346789, FunWith1DArrays.removeD(123456789, 5));
      assertEquals(12345789, FunWith1DArrays.removeD(123456789, 6));
      assertEquals(12345689, FunWith1DArrays.removeD(123456789, 7));
      assertEquals(12345679, FunWith1DArrays.removeD(123456789, 8));
      assertEquals(12345678, FunWith1DArrays.removeD(123456789, 9));
      assertEquals(0, FunWith1DArrays.removeD(999, 9));
      assertEquals(-10, FunWith1DArrays.removeD(-14044, 4));
   }

   public void testFunWith1DArraysLargestWithOutDigitD_06()
   {
      int[] num = {1195, 941, 100057, 316, 11011, 9113};
      assertEquals(1195, FunWith1DArrays.largestWithOutDigitD(num, 1).get(0).intValue());
      assertEquals(1, FunWith1DArrays.largestWithOutDigitD(num, 1).size());

      int[] num1 = {4904, 8043, 174, 3146, 45411, 96};
      assertEquals(8043, FunWith1DArrays.largestWithOutDigitD(num1, 4).get(0).intValue());
      assertEquals(1, FunWith1DArrays.largestWithOutDigitD(num1, 4).size());

      int[] num2 = {31506, 13506, 135063, 315063, 15063, 135306};
      List<Integer> ans = FunWith1DArrays.largestWithOutDigitD(num2, 3);
      assertEquals(true, ans.contains(new Integer(31506)));
      assertEquals(true, ans.contains(new Integer(13506)));
      assertEquals(true, ans.contains(new Integer(135063)));
      assertEquals(true, ans.contains(new Integer(315063)));
      assertEquals(true, ans.contains(new Integer(15063)));
      assertEquals(true, ans.contains(new Integer(135306)));
      assertEquals(6, ans.size());
   }

   public void testFunWith1DArraysRemoveDAndDegreeOfInversionWithNonPositive_07()
   {
      assertEquals(-10, FunWith1DArrays.removeD(-14044, 4));
      assertEquals(0, FunWith1DArrays.removeD(-77770, 7));
      assertEquals(-23456789, FunWith1DArrays.removeD(-123456789, 1));
      assertEquals(-13456789, FunWith1DArrays.removeD(-123456789, 2));
      assertEquals(-12456789, FunWith1DArrays.removeD(-123456789, 3));
      assertEquals(-12356789, FunWith1DArrays.removeD(-123456789, 4));
      assertEquals(-12346789, FunWith1DArrays.removeD(-123456789, 5));
      assertEquals(-12345789, FunWith1DArrays.removeD(-123456789, 6));
      assertEquals(-12345689, FunWith1DArrays.removeD(-123456789, 7));
      assertEquals(-12345679, FunWith1DArrays.removeD(-123456789, 8));
      assertEquals(-12345678, FunWith1DArrays.removeD(-123456789, 9));

      List<Integer> ans;

      int[] num = {-1191, -941, -1020057, -316, -9151, -110119};
      ans = FunWith1DArrays.largestWithOutDigitD(num, 1);
      assertEquals(2, ans.size());
      assertEquals(true, ans.contains(new Integer(-1191)));
      assertEquals(true, ans.contains(new Integer(-110119)));

      int[] num1 = {-4905, 8043, 174, 3146, -95411, -96};
      assertEquals(8043, FunWith1DArrays.largestWithOutDigitD(num1, 4).get(0).intValue());
      assertEquals(1, FunWith1DArrays.largestWithOutDigitD(num1, 4).size());

      int[] num2 = {31506, -13506, -135063, 315063, 15063, -135306, 135035};
      ans = FunWith1DArrays.largestWithOutDigitD(num2, 3);
      assertEquals(3, ans.size());
      assertEquals(true, ans.contains(new Integer(31506)));
//      assertEquals(true, ans.contains(new Integer(-13506)));
//      assertEquals(true, ans.contains(new Integer(-135063)));
      assertEquals(true, ans.contains(new Integer(315063)));
      assertEquals(true, ans.contains(new Integer(15063)));
//      assertEquals(true, ans.contains(new Integer(-135306)));
   }

   public void testFunWith1DArraysDegreeOfInversion_08()
   {
      int[] n = {8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
      assertEquals(0, FunWith1DArrays.degreeOfInversion(n));

      int[] n1 =  {8, 4, 11, 3, 0, 2, -6, 1, 10, 9};
      assertEquals(6+ 5+ 7+  3 +2+ 2+ 0  +1, FunWith1DArrays.degreeOfInversion(n1));

      int[] n2 = {18, 12, -6, 23, -4, 15, 9,  1, -1, 8};
      assertEquals(8  +6  +0  +6   +0  +4 +3 + 1, FunWith1DArrays.degreeOfInversion(n2));

      int[] n3 = {564, 423, 292, 199, 113, 97, 85, 69, 65, 55, 23, 0, -1, -5};
      assertEquals(13+12+11+10+9+8+7+6+5+4+3+2+1, FunWith1DArrays.degreeOfInversion(n3));
      
      int[] n4 = {-51, -12, 23, 47, 96, 123, 234, 345, 456, 567, 9999};
      assertEquals(0, FunWith1DArrays.degreeOfInversion(n4));
   }

   public void testFunWith1DArrays_ArrayRank_09()
   {
      String[] st1 = {"q", "w", "e", "r", "t", "y"};
      int[] ans = FunWith1DArrays.arrayRank(st1);
      assertEquals(st1.length, ans.length);
      assertEquals(1, ans[0]);
      assertEquals(4, ans[1]);
      assertEquals(0, ans[2]);
      assertEquals(2, ans[3]);
      assertEquals(3, ans[4]);
      assertEquals(5, ans[5]);

      String[] st1a = {"c", "e", "f", "g", "h", "k", "m", "q", "u", "y"};
      ans = FunWith1DArrays.arrayRank(st1a);
      assertEquals(st1a.length, ans.length);
      assertEquals(0, ans[0]);
      assertEquals(1, ans[1]);
      assertEquals(2, ans[2]);
      assertEquals(3, ans[3]);
      assertEquals(4, ans[4]);
      assertEquals(5, ans[5]);
      assertEquals(6, ans[6]);
      assertEquals(7, ans[7]);
      assertEquals(8, ans[8]);
      assertEquals(9, ans[9]);

      Comparable[] com2 = {new  Integer(3), new  Integer(39), new  Integer(157), new  Integer(37), 
                               new  Integer(16), new  Integer(59), new  Integer(58),
                               new  Integer(16), new  Integer(59), new  Integer(58) };
      ans = FunWith1DArrays.arrayRank(com2);
      assertEquals(com2.length, ans.length);
      assertEquals(0, ans[0]);
      assertEquals(4, ans[1]);
      assertEquals(9, ans[2]);
      assertEquals(3, ans[3]);
      assertEquals(1, ans[4]);
      assertEquals(7, ans[5]);
      assertEquals(5, ans[6]);
      assertEquals(2, ans[7]);
      assertEquals(8, ans[8]);
      assertEquals(6, ans[9]);

      Comparable[] com3 = {new  Integer(9993), new  Integer(9539), new  Integer(7557), new  Integer(6937), 
                               new  Integer(1069), new  Integer(59), new  Integer(58) };
      ans = FunWith1DArrays.arrayRank(com3);
      assertEquals(com3.length, ans.length);
      assertEquals(6, ans[0]);
      assertEquals(5, ans[1]);
      assertEquals(4, ans[2]);
      assertEquals(3, ans[3]);
      assertEquals(2, ans[4]);
      assertEquals(1, ans[5]);
      assertEquals(0, ans[6]);

      Comparable[] com4 = {new  Integer(27), new  Integer(33), new  Integer(45557), new  Integer(33937), new  Integer(27),
                               new  Integer(27), new  Integer(59), new  Integer(27), new  Integer(127) };
      ans = FunWith1DArrays.arrayRank(com4);
      assertEquals(com4.length, ans.length);
      assertEquals(0, ans[0]);
      assertEquals(4, ans[1]);
      assertEquals(8, ans[2]);
      assertEquals(7, ans[3]);
      assertEquals(1, ans[4]);
      assertEquals(2, ans[5]);
      assertEquals(5, ans[6]);
      assertEquals(3, ans[7]);
      assertEquals(6, ans[8]);
   }

   public void testFunWith1DArrays_All_10()
   {
      testFunWith1DArrays_ArrayRank_09();
      testFunWith1DArraysDegreeOfInversion_08();
      testFunWith1DArraysRemoveDAndDegreeOfInversionWithNonPositive_07();
      testFunWith1DArraysLargestWithOutDigitD_06();
      testFunWith1DArraysRemoveD_05();
      testFunWith1DArraysHas737_04();
      testFunWith1DArraysIsMorath_03();
      testFunWith1DArraysHasVasco_02();
      testFunWith1DArrays01();
   }

   public void testFunctionsGoneWild2016_00()
   {
      assertEquals(26, FunctionsGoneWild2016.f1(5));
      assertEquals(45.2562, FunctionsGoneWild2016.f2(11), 0.05);
      assertEquals(3.4025, FunctionsGoneWild2016.f3(1.5, 1.9), 0.05);
      assertEquals(.00025277, FunctionsGoneWild2016.f4(2.5, 4.7),  0.000025);
      assertEquals(0.0745626, FunctionsGoneWild2016.f5(Math.PI, 2.5, 3.3), 0.0005);
      assertEquals(1+1+1+1, FunctionsGoneWild2016.f6(4, 2, 1));
      assertEquals(1+3+6+5+4+2+1+9, FunctionsGoneWild2016.f7("lEgS have ZelGi") );
      assertEquals(2+2+2+2+2+1+1+0+0, FunctionsGoneWild2016.f8("HUMUHUMUNUKUNUKUAPUAA", "UK") );
      assertEquals(true, FunctionsGoneWild2016.f9(false, false, false) );
      assertEquals(false, FunctionsGoneWild2016.f10(false, false, false, false) );
   }

   public void testFunctionsGoneWild2016_f1()
   {
      assertEquals(64, FunctionsGoneWild2016.f1(7));
      assertEquals(188, FunctionsGoneWild2016.f1(11));
      assertEquals(628, FunctionsGoneWild2016.f1(19));

      assertEquals(37, FunctionsGoneWild2016.f1(20));
      assertEquals(219, FunctionsGoneWild2016.f1(45));
      assertEquals(1008, FunctionsGoneWild2016.f1(93));

      assertEquals(137, FunctionsGoneWild2016.f1(100));
      assertEquals(305, FunctionsGoneWild2016.f1(145));
      assertEquals(1151, FunctionsGoneWild2016.f1(294));

      assertEquals(1935, FunctionsGoneWild2016.f1(1294));
      assertEquals(4515, FunctionsGoneWild2016.f1(2947));
      assertEquals(6372, FunctionsGoneWild2016.f1(4240));
      assertEquals(33604, FunctionsGoneWild2016.f1(23941));
      assertEquals(52892, FunctionsGoneWild2016.f1(35056));
   }

   public void testFunctionsGoneWild2016_f2()
   {
      assertEquals(1.0, FunctionsGoneWild2016.f2(2.6), 0.05);
      assertEquals(-6.984, FunctionsGoneWild2016.f2(197.), 0.5);
      assertEquals(48.9386, FunctionsGoneWild2016.f2(683.3), 0.05);
      assertEquals(-6.9984, FunctionsGoneWild2016.f2(1881.), 0.05);
      assertEquals(48.8951, FunctionsGoneWild2016.f2(400.), 0.05);
      assertEquals(1.0, FunctionsGoneWild2016.f2(1605), 0.05);
      assertEquals(47.0204, FunctionsGoneWild2016.f2(21), 0.05);
      assertEquals(49.62887, FunctionsGoneWild2016.f2(-67.), 0.05);
   }

   public void testFunctionsGoneWild2016_f3()
   {
      assertEquals(-.18704, FunctionsGoneWild2016.f3(7.9, 9.7), 0.05);
      assertEquals(-8.080098, FunctionsGoneWild2016.f3(-23.9, 0.7), 0.05);
      assertEquals(-.830476, FunctionsGoneWild2016.f3(3.1, -19.2), 0.05);
      assertEquals(-1.23784, FunctionsGoneWild2016.f3(.9, .17), 0.05);
   }

   public void testFunctionsGoneWild2016_f1_f2_f3()
   {
      testFunctionsGoneWild2016_f1();
      testFunctionsGoneWild2016_f2();
      testFunctionsGoneWild2016_f3();
   }
   
   public void testFunctionsGoneWild2016_f4()
   {
      assertEquals(-311.45, FunctionsGoneWild2016.f4(1361, 3), 0.05);
      assertEquals(-9.7566, FunctionsGoneWild2016.f4(5, -15), 0.05);
      assertEquals(1.78953, FunctionsGoneWild2016.f4(-12, 6), 0.05);
      assertEquals(0, FunctionsGoneWild2016.f4(Math.PI, Math.PI/2), 0.05);
      assertEquals(0, FunctionsGoneWild2016.f4(Math.PI, -Math.PI/2), 0.05);

      assertEquals(-1.30125, FunctionsGoneWild2016.f4(4, 2), 0.05);
      assertEquals(-3.98861, FunctionsGoneWild2016.f4(8, -3), 0.05);
   }

   public void testFunctionsGoneWild2016_f5()
   {
      assertEquals(23.5480, FunctionsGoneWild2016.f5(3*Math.E, 1, 3.3), 0.05);
      assertEquals(25.8847, FunctionsGoneWild2016.f5(3*Math.E, 2, 3.3), 0.05);
      assertEquals(12827560.52, FunctionsGoneWild2016.f5(33, 6, 4.75), 10.);
      assertEquals(2.752941, FunctionsGoneWild2016.f5(3, -2, 1.8), 0.05);

      assertEquals(0.9631676, FunctionsGoneWild2016.f5(6*Math.E, 18, 3.3), 0.025);
      assertEquals(-60.01719, FunctionsGoneWild2016.f5(Math.pow(Math.E, Math.PI), 5, -2), 0.05);
      assertEquals(3.1274882, FunctionsGoneWild2016.f5(Math.log10(99), 10, 16), 0.05);
      assertEquals(-.382971, FunctionsGoneWild2016.f5(0.1, 2.7, -25), 0.025);
   }

   public void testFunctionsGoneWild2016_f6()
   {
      assertEquals(73, FunctionsGoneWild2016.f6(15, 8, 11));
      assertEquals(25, FunctionsGoneWild2016.f6(21, 7, -3));
      assertEquals(3850, FunctionsGoneWild2016.f6(102, 94, 59));
      assertEquals(1776, FunctionsGoneWild2016.f6(67, 27, 56));
      assertEquals(11289, FunctionsGoneWild2016.f6(213, 195, 17));
      assertEquals(12190, FunctionsGoneWild2016.f6(213, 17, 195));
      assertEquals(1540, FunctionsGoneWild2016.f6(1234, 3, 1));
   }

   public void testFunctionsGoneWild2016_f4_f5_f6()
   {
      testFunctionsGoneWild2016_f4();
      testFunctionsGoneWild2016_f5();
      testFunctionsGoneWild2016_f6();
   }

   public void testFunctionsGoneWild2016_f7()
   {
      assertEquals(1, FunctionsGoneWild2016.f7("i love") );
      assertEquals(2, FunctionsGoneWild2016.f7("Zipper") );
      assertEquals(3+3+3, FunctionsGoneWild2016.f7("EVERYONE") );
      assertEquals(9+0+4+1+5+7+3+3+7, FunctionsGoneWild2016.f7("GO hIS LEVEL") );
      assertEquals(8+6+8+8, FunctionsGoneWild2016.f7("Big Bad Boys") );
      assertEquals(5+4+2+2+7+3, FunctionsGoneWild2016.f7("ShiZZLE") );
      assertEquals(4+1+5+1+7+7, FunctionsGoneWild2016.f7("he IS ILL") );
      assertEquals(1+4+6, FunctionsGoneWild2016.f7("qwertyuiopasdfghjklzxcvbnm") );
      assertEquals(1+2+3+5+7+8+9, FunctionsGoneWild2016.f7("QWERTYUIOPLKJHGFDSAZXCVBNM") );
      assertEquals(0, FunctionsGoneWild2016.f7(" O ") );
   }

   public void testFunctionsGoneWild2016_f8()
   {
      assertEquals(2+2+2+2+2+1+1+0+0, FunctionsGoneWild2016.f8("HUMUHUMUNUKUNUKUAPUAA", "UK") );
      assertEquals(2+1+1, FunctionsGoneWild2016.f8("PEPPER", "PE") );
      assertEquals(4+2, FunctionsGoneWild2016.f8("ASSASSIN", "AS") );
      assertEquals(2*6, FunctionsGoneWild2016.f8("BEEKEEPERESS", "ES") );
      assertEquals(2, FunctionsGoneWild2016.f8("WILLIWAW", "WL") );
      assertEquals(2, FunctionsGoneWild2016.f8("WILLIWAW", "LI") );
      assertEquals(1, FunctionsGoneWild2016.f8("EARTHBOUND", "ED") );
      assertEquals(0, FunctionsGoneWild2016.f8("ROUNDTABLES", "SR") );
      assertEquals(4+2+1, FunctionsGoneWild2016.f8("ADDERADADAERT", "AD") );
      assertEquals(3+3+2+1, FunctionsGoneWild2016.f8("ADDERADADAEDRT", "DA") );
   }

   public void testFunctionsGoneWild2016_f7_f8()
   {
      testFunctionsGoneWild2016_f7();
      testFunctionsGoneWild2016_f8();
   }

   public void testFunctionsGoneWild2016_f9()
   {
      assertEquals(true, FunctionsGoneWild2016.f9(false, false, false) );
      assertEquals(true, FunctionsGoneWild2016.f9(false, false, true) );
      assertEquals(true, FunctionsGoneWild2016.f9(false, true, false) );
      assertEquals(false, FunctionsGoneWild2016.f9(false, true, true) );
      assertEquals(false, FunctionsGoneWild2016.f9(true, false, false) );
      assertEquals(true, FunctionsGoneWild2016.f9(true, false, true) );
      assertEquals(false, FunctionsGoneWild2016.f9(true, true, false) );
      assertEquals(true, FunctionsGoneWild2016.f9(true, true, true) );
   }

   public void testFunctionsGoneWild2016_f10()
   {
      assertEquals(false, FunctionsGoneWild2016.f10(false, false, false, false) );
      assertEquals(true, FunctionsGoneWild2016.f10(false, false, false, true) );
      assertEquals(true, FunctionsGoneWild2016.f10(false, false, true, false) );
      assertEquals(true, FunctionsGoneWild2016.f10(false, false, true, true) );
      assertEquals(false, FunctionsGoneWild2016.f10(false, true, false, false) );
      assertEquals(false, FunctionsGoneWild2016.f10(false, true, false, true) );
      assertEquals(true, FunctionsGoneWild2016.f10(false, true, true, false) );
      assertEquals(false, FunctionsGoneWild2016.f10(false, true, true, true) );
      assertEquals(false, FunctionsGoneWild2016.f10(true, false, false, false) );
      assertEquals(true, FunctionsGoneWild2016.f10(true, false, false, true) );
      assertEquals(true, FunctionsGoneWild2016.f10(true, false, true, false) );
      assertEquals(false, FunctionsGoneWild2016.f10(true, false, true, true) );
      assertEquals(false, FunctionsGoneWild2016.f10(true, true, false, false) );
      assertEquals(true, FunctionsGoneWild2016.f10(true, true, false, true) );
      assertEquals(true, FunctionsGoneWild2016.f10(true, true, true, false) );
      assertEquals(false, FunctionsGoneWild2016.f10(true, true, true, true) );
   }

   public void testFunctionsGoneWild2016_f9_f10()
   {
      testFunctionsGoneWild2016_f9();
      testFunctionsGoneWild2016_f10();
   }

   public void testFunctionsGoneWild2016_All()
   {
      testFunctionsGoneWild2016_f1();
      testFunctionsGoneWild2016_f2();
      testFunctionsGoneWild2016_f3();
      testFunctionsGoneWild2016_f4();
      testFunctionsGoneWild2016_f5();
      testFunctionsGoneWild2016_f6();
      testFunctionsGoneWild2016_f7();
      testFunctionsGoneWild2016_f8();
      testFunctionsGoneWild2016_f9();
      testFunctionsGoneWild2016_f10();
   }

   public void testMakeChange01()
   {
      MakeChange mc = new MakeChange(3, 1, 2, 4);
      assertEquals(true, mc.changePossible(3));
      assertEquals(false, mc.changePossible(4));
      assertEquals(true, mc.changePossible(3+5+20+100));
      assertEquals(false, mc.changePossible(64));
      assertEquals(false, mc.changePossible(129));
   }

   public void testMakeChangeWithPennies02()
   {
      MakeChange mc = new MakeChange(0, 1, 2, 4);
      assertEquals(false, mc.changePossible(1));
      mc = new MakeChange(1, 0, 2, 4);
      assertEquals(true, mc.changePossible(1));
      assertEquals(false, mc.changePossible(2));
      mc = new MakeChange(2, 0, 2, 4);
      assertEquals(true, mc.changePossible(1));
      assertEquals(true, mc.changePossible(2));
      assertEquals(false, mc.changePossible(3));
      mc = new MakeChange(3, 2, 0, 3);
      assertEquals(true, mc.changePossible(1));
      assertEquals(true, mc.changePossible(2));
      assertEquals(true, mc.changePossible(3));
      assertEquals(false, mc.changePossible(4));
      mc = new MakeChange(4, 0, 0, 3);
      assertEquals(true, mc.changePossible(1));
      assertEquals(true, mc.changePossible(2));
      assertEquals(true, mc.changePossible(3));
      assertEquals(true, mc.changePossible(4));
      mc = new MakeChange(11, 0, 0, 0);
      for (int index = 1; index < 12; index++)
         assertEquals(true, mc.changePossible(index));
      assertEquals(false, mc.changePossible(12));
   }

   public void testMakeChangeWithNickels03()
   {
      MakeChange mc = new MakeChange(0, 0, 2, 4);
      assertEquals(false, mc.changePossible(5));
      mc = new MakeChange(1, 1, 0, 0);
      assertEquals(true, mc.changePossible(5));
      assertEquals(false, mc.changePossible(10));
      mc = new MakeChange(2, 2, 0, 4);
      assertEquals(true, mc.changePossible(5));
      assertEquals(true, mc.changePossible(10));
      assertEquals(false, mc.changePossible(15));
      mc = new MakeChange(0, 5, 0, 0);
      assertEquals(true, mc.changePossible(5));
      assertEquals(true, mc.changePossible(10));
      assertEquals(true, mc.changePossible(15));
      assertEquals(true, mc.changePossible(20));
      assertEquals(true, mc.changePossible(25));
      assertEquals(false, mc.changePossible(30));
   }

   public void testMakeChangeWithDimes04()
   {
      MakeChange mc = new MakeChange(0, 1, 0, 4);
      assertEquals(false, mc.changePossible(10));
      mc = new MakeChange(1, 0, 1, 4);
      assertEquals(true, mc.changePossible(10));
      assertEquals(false, mc.changePossible(15));
      assertEquals(false, mc.changePossible(20));
      mc = new MakeChange(2, 0, 2, 0);
      assertEquals(true, mc.changePossible(10));
      assertEquals(true, mc.changePossible(20));
      assertEquals(false, mc.changePossible(30));
      mc = new MakeChange(3, 1, 3, 0);
      assertEquals(true, mc.changePossible(10));
      assertEquals(true, mc.changePossible(20));
      assertEquals(true, mc.changePossible(30));
      assertEquals(false, mc.changePossible(40));
      mc = new MakeChange(4, 0, 5, 0);
      assertEquals(true, mc.changePossible(10));
      assertEquals(true, mc.changePossible(20));
      assertEquals(true, mc.changePossible(30));
      assertEquals(true, mc.changePossible(40));
      assertEquals(true, mc.changePossible(50));
      assertEquals(false, mc.changePossible(60));
   }

   public void testMakeChangeWithQuarters05()
   {
      MakeChange mc = new MakeChange(4, 1, 1, 0);
      assertEquals(false, mc.changePossible(25));
      mc = new MakeChange(4, 2, 1, 1);
      assertEquals(true, mc.changePossible(25));
      assertEquals(false, mc.changePossible(50));
      mc = new MakeChange(2, 0, 2, 2);
      assertEquals(true, mc.changePossible(25));
      assertEquals(true, mc.changePossible(50));
      assertEquals(false, mc.changePossible(75));
      mc = new MakeChange(3, 1, 1, 3);
      assertEquals(true, mc.changePossible(25));
      assertEquals(true, mc.changePossible(50));
      assertEquals(true, mc.changePossible(75));
      assertEquals(false, mc.changePossible(100));
      mc = new MakeChange(4, 4, 0, 4);
      assertEquals(true, mc.changePossible(25));
      assertEquals(true, mc.changePossible(50));
      assertEquals(true, mc.changePossible(75));
      assertEquals(true, mc.changePossible(100));
      assertEquals(false, mc.changePossible(125));
   }

   public void testMakeChangeWithPenniesAndNickels06()
   {
      MakeChange mc = new MakeChange(0, 0, 0, 0);
      assertEquals(true, mc.changePossible(0));
      assertEquals(false, mc.changePossible(1));
      mc = new MakeChange(4, 1, 0, 0);
      assertEquals(true, mc.changePossible(0));
      assertEquals(true, mc.changePossible(1));
      assertEquals(true, mc.changePossible(5));
      assertEquals(true, mc.changePossible(9));
      assertEquals(false, mc.changePossible(10));
      mc = new MakeChange(4, 2, 0, 0);
      assertEquals(true, mc.changePossible(2));
      assertEquals(true, mc.changePossible(3));
      assertEquals(true, mc.changePossible(4));
      assertEquals(true, mc.changePossible(6));
      assertEquals(true, mc.changePossible(7));
      assertEquals(true, mc.changePossible(8));
      assertEquals(true, mc.changePossible(10));
      assertEquals(true, mc.changePossible(11));
      assertEquals(true, mc.changePossible(12));
      assertEquals(true, mc.changePossible(13));
      assertEquals(true, mc.changePossible(14));
      assertEquals(false, mc.changePossible(15));
   }

   public void testMakeChangeWithPenniesAndDimes07()
   {
      MakeChange mc = new MakeChange(2, 0, 1, 0);
      assertEquals(true, mc.changePossible(0));
      assertEquals(true, mc.changePossible(1));
      assertEquals(false, mc.changePossible(3));
      assertEquals(false, mc.changePossible(5));
      assertEquals(false, mc.changePossible(7));
      assertEquals(true, mc.changePossible(10));
      assertEquals(true, mc.changePossible(11));
      assertEquals(true, mc.changePossible(12));
      assertEquals(false, mc.changePossible(13));
      mc = new MakeChange(3, 0, 3, 0);
      assertEquals(true, mc.changePossible(13));
      assertEquals(false, mc.changePossible(34));
      assertEquals(true, mc.changePossible(21));
      assertEquals(true, mc.changePossible(13));
      assertEquals(false, mc.changePossible(15));
   }

   public void testMakeChangeWithPenniesAndQuarters08()
   {
      MakeChange mc = new MakeChange(2, 0, 0, 1);
      assertEquals(true, mc.changePossible(0));
      assertEquals(true, mc.changePossible(1));
      assertEquals(false, mc.changePossible(3));
      assertEquals(false, mc.changePossible(5));
      assertEquals(false, mc.changePossible(7));
      assertEquals(true, mc.changePossible(25));
      assertEquals(true, mc.changePossible(26));
      assertEquals(true, mc.changePossible(27));
      assertEquals(false, mc.changePossible(23));
      mc = new MakeChange(1, 0, 0, 4);
      assertEquals(true, mc.changePossible(26));
      assertEquals(false, mc.changePossible(27));
      assertEquals(true, mc.changePossible(50));
      assertEquals(true, mc.changePossible(76));
      assertEquals(true, mc.changePossible(100));
      assertEquals(true, mc.changePossible(101));
      assertEquals(false, mc.changePossible(99));
   }

   public void testMakeChangeWithPenniesAndNickelsAndDimes09()
   {
      MakeChange mc = new MakeChange(2, 1, 1, 0);
      assertEquals(true, mc.changePossible(0));
      assertEquals(true, mc.changePossible(1));
      assertEquals(false, mc.changePossible(3));
      assertEquals(true, mc.changePossible(5));
      assertEquals(true, mc.changePossible(7));
      assertEquals(false, mc.changePossible(9));
      assertEquals(true, mc.changePossible(10));
      assertEquals(true, mc.changePossible(16));
      assertEquals(true, mc.changePossible(17));
      assertEquals(false, mc.changePossible(19));
      mc = new MakeChange(3, 1, 3, 0);
      assertEquals(true, mc.changePossible(18));
      assertEquals(false, mc.changePossible(29));
      assertEquals(true, mc.changePossible(35));
      assertEquals(true, mc.changePossible(38));
      assertEquals(false, mc.changePossible(39));
   }

   public void testMakeChangeWithPenniesAndNickelsAndDimesAndQuarters10()
   {
      MakeChange mc = new MakeChange(3, 2, 1, 3);
      assertEquals(true, mc.changePossible(3));
      assertEquals(true, mc.changePossible(1));
      assertEquals(false, mc.changePossible(4));
      assertEquals(true, mc.changePossible(5));
      assertEquals(true, mc.changePossible(7));
      assertEquals(false, mc.changePossible(9));
      assertEquals(false, mc.changePossible(14));
      assertEquals(true, mc.changePossible(28));
      assertEquals(true, mc.changePossible(78));
      assertEquals(true, mc.changePossible(88));
      assertEquals(true, mc.changePossible(98));
      assertEquals(false, mc.changePossible(99));
      mc = new MakeChange(1, 1, 2, 1);
      assertEquals(true, mc.changePossible(1));
      assertEquals(false, mc.changePossible(2));
      assertEquals(true, mc.changePossible(6));
      assertEquals(true, mc.changePossible(16));
      assertEquals(false, mc.changePossible(22));
      assertEquals(true, mc.changePossible(21));
      assertEquals(false, mc.changePossible(22));
      assertEquals(true, mc.changePossible(45));
      assertEquals(true, mc.changePossible(51));
      assertEquals(false, mc.changePossible(52));

      mc = new MakeChange(4, 3, 2, 5);
      assertEquals(true, mc.changePossible(14));
      assertEquals(true, mc.changePossible(19));
      assertEquals(false, mc.changePossible(125+20+15+5));
      assertEquals(true, mc.changePossible(79));
      assertEquals(true, mc.changePossible(83));
      assertEquals(false, mc.changePossible(166));
      assertEquals(true, mc.changePossible(107));
      assertEquals(true, mc.changePossible(156));
      assertEquals(true, mc.changePossible(117));
      assertEquals(false, mc.changePossible(167));

      mc = new MakeChange(1, 0, 0, 50);
      assertEquals(true, mc.changePossible(49*25+1));
      assertEquals(true, mc.changePossible(50*25+1));
      assertEquals(false, mc.changePossible(50*25+2));
   }

   public void testSoonerOrLater01()
   {
      int[] n = {2, 1, 3, 5, 2, 7, 12, 3, 2, 5, 5, 3, 6, 4, 2, 1, 7, 3, 5, 4, 6};
      SoonerOrLater sl = new SoonerOrLater(n);
      assertEquals(18, sl.visit(0));
      assertEquals(18, sl.visit(1));
      assertEquals(18, sl.visit(2));
      assertEquals(16, sl.visit(3));
      assertEquals(18, sl.visit(4));
      assertEquals(18, sl.visit(5));
      assertEquals(18, sl.visit(6));
      assertEquals(16, sl.visit(7));
      assertEquals(16, sl.visit(8));
      assertEquals(16, sl.visit(9));
      assertEquals(16, sl.visit(10));
      assertEquals(16, sl.visit(11));
      assertEquals(18, sl.visit(12));
      assertEquals(20, sl.visit(13));
      assertEquals(16, sl.visit(14));
      assertEquals(16, sl.visit(15));
      assertEquals(16, sl.visit(16));
      assertEquals(20, sl.visit(17));
      assertEquals(18, sl.visit(18));
      assertEquals(19, sl.visit(19));
      assertEquals(20, sl.visit(20));
      assertEquals(2, sl.itBeginsHere());
   }

   public void testSoonerOrLater02()
   {
      int[] n = {1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3, 8, 4, 6, 2, 6, 4, 3, 3, 8, 3, 2};
      SoonerOrLater sl = new SoonerOrLater(n);
      assertEquals(25, sl.visit(0));
      assertEquals(25, sl.visit(1));
      assertEquals(26, sl.visit(2));
      assertEquals(26, sl.visit(3));
      assertEquals(26, sl.visit(4));
      assertEquals(25, sl.visit(5));
      assertEquals(25, sl.visit(6));
      assertEquals(25, sl.visit(7));
      assertEquals(26, sl.visit(8));
      assertEquals(25, sl.visit(9));
      assertEquals(26, sl.visit(10));
      assertEquals(26, sl.visit(11));
      assertEquals(25, sl.visit(12));
      assertEquals(26, sl.visit(13));
      assertEquals(25, sl.visit(14));
      assertEquals(25, sl.visit(15));
      assertEquals(25, sl.visit(16));
      assertEquals(25, sl.visit(17));
      assertEquals(26, sl.visit(18));
      assertEquals(25, sl.visit(19));
      assertEquals(26, sl.visit(20));
      assertEquals(27, sl.visit(21));
      assertEquals(26, sl.visit(22));
      assertEquals(26, sl.visit(23));
      assertEquals(27, sl.visit(24));
      assertEquals(25, sl.visit(25));
      assertEquals(26, sl.visit(26));
      assertEquals(27, sl.visit(27));
   }

   public void testSoonerOrLater03()
   {
      int[] n = {3, 9, 14, 9, 4, 6, 19, 9, 5, 2, 2, 4, 7, 3, 11, 7, 2, 1, 7, 2, 6, 4, 3, 7, 2, 5, 2, 24, 17};
      SoonerOrLater sl = new SoonerOrLater(n);
      assertEquals(25, sl.visit(0));
      assertEquals(25, sl.visit(1));
      assertEquals(25, sl.visit(2));
      assertEquals(25, sl.visit(3));
      assertEquals(25, sl.visit(4));
      assertEquals(25, sl.visit(5));
      assertEquals(25, sl.visit(6));
      assertEquals(25, sl.visit(7));
      assertEquals(25, sl.visit(8));
      assertEquals(25, sl.visit(9));
      assertEquals(25, sl.visit(10));
      assertEquals(25, sl.visit(11));
      assertEquals(25, sl.visit(12));
      assertEquals(25, sl.visit(13));
      assertEquals(25, sl.visit(14));
      assertEquals(25, sl.visit(15));
      assertEquals(25, sl.visit(16));
      assertEquals(25, sl.visit(17));
      assertEquals(25, sl.visit(18));
      assertEquals(25, sl.visit(19));
      assertEquals(28, sl.visit(20));
      assertEquals(25, sl.visit(21));
      assertEquals(25, sl.visit(22));
      assertEquals(23, sl.visit(23));
      assertEquals(28, sl.visit(24));
      assertEquals(25, sl.visit(25));
      assertEquals(28, sl.visit(26));
      assertEquals(27, sl.visit(27));
      assertEquals(28, sl.visit(28));
   }

   public void testSoonerOrLater04()
   {
      int[] n = {6, 20, 4, 11, 8, 8, 1, 7, 10, 10, 3, 1, 3, 7, 3, 3, 4, 4, 6, 8, 3, 8, 7, 5, 2, 8, 6, 5, 87, 5};
      SoonerOrLater sl = new SoonerOrLater(n);
      assertEquals(29, sl.visit(0));
      assertEquals(29, sl.visit(1));
      assertEquals(29, sl.visit(2));
      assertEquals(29, sl.visit(3));
      assertEquals(26, sl.visit(4));
      assertEquals(28, sl.visit(5));
      assertEquals(29, sl.visit(6));
      assertEquals(29, sl.visit(7));
      assertEquals(26, sl.visit(8));
      assertEquals(27, sl.visit(9));
      assertEquals(28, sl.visit(10));
      assertEquals(26, sl.visit(11));
      assertEquals(26, sl.visit(12));
      assertEquals(28, sl.visit(13));
      assertEquals(29, sl.visit(14));
      assertEquals(26, sl.visit(15));
      assertEquals(28, sl.visit(16));
      assertEquals(29, sl.visit(17));
      assertEquals(26, sl.visit(18));
      assertEquals(27, sl.visit(19));
      assertEquals(28, sl.visit(20));
      assertEquals(29, sl.visit(21));
      assertEquals(29, sl.visit(22));
      assertEquals(28, sl.visit(23));
      assertEquals(26, sl.visit(24));
      assertEquals(25, sl.visit(25));
      assertEquals(26, sl.visit(26));
      assertEquals(27, sl.visit(27));
      assertEquals(28, sl.visit(28));
      assertEquals(29, sl.visit(29));
      assertEquals(3, sl.itBeginsHere());
   }

   public void testSoonerOrLater05()
   {
      int[] n = {5, 3, 9, 9, 3, 8, 2, 3, 3, 7, 4, 8, 8, 6, 2, 2, 2, 4, 12, 3, 2, 1, 6, 15, 5, 2, 9, 4, 4, 5, 5, 6, 3, 3, 9, 8, 1, 7, 6, 1, 7, 1, 1, 8, 8, 4,
                   1, 9, 8, 6, 7, 8, 5, 9, 10, 6, 6, 3, 5, 7, 3, 5, 2, 8, 13, 7, 7, 8, 4, 15, 7, 4, 3, 7, 4, 4, 7, 2, 2, 4, 8, 4};
      SoonerOrLater sl = new SoonerOrLater(n);
      assertEquals(80, sl.visit(0));
      assertEquals(80, sl.visit(1));
      assertEquals(80, sl.visit(2));
      assertEquals(80, sl.visit(3));
      assertEquals(80, sl.visit(4));
      assertEquals(80, sl.visit(5));
      assertEquals(80, sl.visit(6));
      assertEquals(80, sl.visit(7));
      assertEquals(80, sl.visit(8));
      assertEquals(80, sl.visit(9));
      assertEquals(80, sl.visit(10));
      assertEquals(80, sl.visit(11));
      assertEquals(80, sl.visit(12));
      assertEquals(80, sl.visit(13));
      assertEquals(80, sl.visit(14));
      assertEquals(80, sl.visit(15));
      assertEquals(80, sl.visit(16));
      assertEquals(80, sl.visit(17));
      assertEquals(80, sl.visit(18));
      assertEquals(80, sl.visit(19));
      assertEquals(80, sl.visit(20));
      assertEquals(80, sl.visit(21));
      assertEquals(80, sl.visit(22));
      assertEquals(79, sl.visit(23));
      assertEquals(80, sl.visit(24));
      assertEquals(79, sl.visit(25));
      assertEquals(80, sl.visit(26));
      assertEquals(79, sl.visit(27));
      assertEquals(80, sl.visit(28));
      assertEquals(80, sl.visit(29));
      assertEquals(80, sl.visit(30));
      assertEquals(79, sl.visit(31));
      assertEquals(80, sl.visit(32));
      assertEquals(79, sl.visit(33));
      assertEquals(80, sl.visit(34));
      assertEquals(80, sl.visit(35));
      assertEquals(79, sl.visit(36));
      assertEquals(79, sl.visit(37));
      assertEquals(79, sl.visit(38));
      assertEquals(79, sl.visit(39));
      assertEquals(79, sl.visit(40));
      assertEquals(80, sl.visit(41));
      assertEquals(80, sl.visit(42));
      assertEquals(80, sl.visit(43));
      assertEquals(79, sl.visit(44));
      assertEquals(80, sl.visit(45));
      assertEquals(79, sl.visit(46));
      assertEquals(79, sl.visit(47));
      assertEquals(79, sl.visit(48));
      assertEquals(80, sl.visit(49));
      assertEquals(79, sl.visit(50));
      assertEquals(80, sl.visit(51));
      assertEquals(79, sl.visit(52));
      assertEquals(79, sl.visit(53));
      assertEquals(79, sl.visit(54));
      assertEquals(80, sl.visit(55));
      assertEquals(79, sl.visit(56));
      assertEquals(79, sl.visit(57));
      assertEquals(79, sl.visit(58));
      assertEquals(80, sl.visit(59));
      assertEquals(79, sl.visit(60));
      assertEquals(80, sl.visit(61));
      assertEquals(79, sl.visit(62));
      assertEquals(79, sl.visit(63));
      assertEquals(79, sl.visit(64));
      assertEquals(79, sl.visit(65));
      assertEquals(80, sl.visit(66));
      assertEquals(79, sl.visit(67));
      assertEquals(79, sl.visit(68));
      assertEquals(69, sl.visit(69));
      assertEquals(79, sl.visit(70));
      assertEquals(79, sl.visit(71));
      assertEquals(79, sl.visit(72));
      assertEquals(80, sl.visit(73));
      assertEquals(80, sl.visit(74));
      assertEquals(79, sl.visit(75));
      assertEquals(76, sl.visit(76));
      assertEquals(79, sl.visit(77));
      assertEquals(80, sl.visit(78));
      assertEquals(79, sl.visit(79));
      assertEquals(80, sl.visit(80));
      assertEquals(81, sl.visit(81));
      assertEquals(22, sl.itBeginsHere());
   }

   public void testSoonerOrLater06()
   {
      int[] n = {1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3, 8, 4, 6, 2, 6, 4, 3, 3, 8, 3, 2};
      SoonerOrLater sl = new SoonerOrLater(n);
      assertEquals(1, sl.itBeginsHere());
   }

   public void testSoonerOrLater07()
   {
      int[] n = {3, 9, 14, 9, 4, 6, 19, 9, 5, 2, 2, 4, 7, 3, 11, 7, 2, 1, 7, 2, 6, 4, 3, 7, 2, 5, 2, 24, 17};
      SoonerOrLater sl = new SoonerOrLater(n);
      assertEquals(19, sl.itBeginsHere());
   }

   public void testSoonerOrLater08()
   {
      int[] n = {6, 20, 4, 11, 8, 8, 1, 7, 10, 10, 3, 1, 3, 7, 3, 3, 4, 4, 6, 8, 3, 8, 7, 5, 2, 8, 6, 5, 87, 5};
      SoonerOrLater sl = new SoonerOrLater(n);
      assertEquals(3, sl.itBeginsHere());
   }

   public void testSoonerOrLater09()
   {
      int[] n = {5, 3, 9, 9, 3, 8, 2, 3, 3, 7, 4, 8, 8, 6, 2, 2, 2, 4, 12, 3, 2, 1, 6, 15, 5, 2, 9, 4, 4, 5, 5, 6, 3, 3, 9, 8, 1, 7, 6, 1, 7, 1, 1, 8, 8, 4,
                   1, 9, 8, 6, 7, 8, 5, 9, 10, 6, 6, 3, 5, 7, 3, 5, 2, 8, 13, 7, 7, 8, 4, 15, 7, 4, 3, 7, 4, 4, 7, 2, 2, 4, 8, 4};
      SoonerOrLater sl = new SoonerOrLater(n);
      assertEquals(22, sl.itBeginsHere());
   }

   public void testSoonerOrLater10()
   {
      int[] n = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
      SoonerOrLater sl = new SoonerOrLater(n);
      for (int k : n)
         assertEquals(n.length-1, sl.visit(k));
      assertEquals(n.length-1, sl.itBeginsHere());
   }

   public void testContiguousWord01()
   {
      ContiguousWord cw = new ContiguousWord();

      assertEquals(true, cw.isContiguousWord("aaabb"));
      assertEquals(true, cw.isContiguousWord("abc"));
      assertEquals(false, cw.isContiguousWord("bitotsav"));

//  testers for 2      
      List<String> segment1 = new ArrayList<String>();
      segment1.add("ac");
      segment1.add("ca");
      List<String> ans = cw.buildContiguousWord(segment1);
      assertEquals(0, ans.size());

//  testers for 3
      List<String> segment2 = new ArrayList<String>();
      segment2.add("zzzz");
      segment2.add("zz");
      segment2.add("z");
      ans = cw.buildContiguousWord(segment2);
      assertEquals(1, ans.size());
      assertEquals("zzzzzzz", ans.get(0));

//  testers for 4
      List<String> segment3 = new ArrayList<String>();
      segment3.add("r");
      segment3.add("o");
      segment3.add("a");
      segment3.add("r");
      ans = cw.buildContiguousWord(segment3);
      assertEquals(6, ans.size());
      assertEquals(true, ans.contains("aorr"));
      assertEquals(true, ans.contains("oarr"));
      assertEquals(true, ans.contains("arro"));
      assertEquals(true, ans.contains("orra"));
      assertEquals(true, ans.contains("rroa"));
      assertEquals(true, ans.contains("rrao"));

//  testers for 5
      List<String> segment4 = new ArrayList<String>();
      segment4.add("r");
      segment4.add("o");
      segment4.add("a");
      segment4.add("r");
      segment4.add("a");
      ans = cw.buildContiguousWord(segment4);
      assertEquals(6, ans.size());
      assertEquals(true, ans.contains("aaorr"));
      assertEquals(true, ans.contains("oaarr"));
      assertEquals(true, ans.contains("aarro"));
      assertEquals(true, ans.contains("orraa"));
      assertEquals(true, ans.contains("rroaa"));
      assertEquals(true, ans.contains("rraao"));
   }

   public void testIsContiguousWord02()
   {
      ContiguousWord cw = new ContiguousWord();

      assertEquals("aaabbcccefghh", true, cw.isContiguousWord("aaabbcccefghh"));
      assertEquals("acehzs", true, cw.isContiguousWord("acehzs"));
      assertEquals("bnb", false, cw.isContiguousWord("bnb"));
      assertEquals("bnnnnnb", false, cw.isContiguousWord("bnnnnnb"));
   }

   public void testBuildContiguousWordArrayListSize2_03()
   {
      ContiguousWord cw = new ContiguousWord();

      String[] seg1 = {"acx", "cxa"};
      List<String> segment1 = new ArrayList<String>();
      for(String s : seg1)
         segment1.add(s);
      List<String> ans = cw.buildContiguousWord(segment1);
      assertEquals(0, ans.size());

      String[] seg2 = {"ac", "cx"};
      List<String> segment2 = new ArrayList<String>();
      for(String s : seg2)
         segment2.add(s);
      ans = cw.buildContiguousWord(segment2);
      assertEquals(1, ans.size());
      String[] temp = new String[ans.size()];
      for(int g = 0; g < ans.size(); g++)
         temp[g] = ans.get(g);
      Arrays.sort(temp);
      assertEquals("accx", temp[0]);

      String[] seg3 = {"cc", "a"};
      List<String> segment3 = new ArrayList<String>();
      for(String s : seg3)
         segment3.add(s);
      ans = cw.buildContiguousWord(segment3);
      assertEquals(2, ans.size());
      temp = new String[ans.size()];
      for(int g = 0; g < ans.size(); g++)
         temp[g] = ans.get(g);
      Arrays.sort(temp);
      assertEquals("acc", temp[0]);
      assertEquals("cca", temp[1]);

      String[] seg4 = {"cac", "ac"};
      List<String> segment4 = new ArrayList<String>();
      for(String s : seg4)
         segment4.add(s);
      ans = cw.buildContiguousWord(segment4);
      assertEquals(0, ans.size());
   }

   public void testBuildContiguousWordArrayListSize3_04()
   {
      ContiguousWord cw = new ContiguousWord();

      String[] seg1 = {"zx", "xa", "a"};
      List<String> segment1 = new ArrayList<String>();
      for(String s : seg1)
         segment1.add(s);
      List<String> ans = cw.buildContiguousWord(segment1);
      assertEquals(1, ans.size());
      String[] temp = new String[ans.size()];
      for(int g = 0; g < ans.size(); g++)
         temp[g] = ans.get(g);
      Arrays.sort(temp);
      assertEquals("zxxaa", temp[0]);

      String[] seg2 = {"ac", "x", "c"};
      List<String> segment2 = new ArrayList<String>();
      for(String s : seg2)
         segment2.add(s);
      ans = cw.buildContiguousWord(segment2);
      assertEquals(2, ans.size());
      temp = new String[ans.size()];
      for(int g = 0; g < ans.size(); g++)
         temp[g] = ans.get(g);
      Arrays.sort(temp);
      assertEquals("accx", temp[0]);
      assertEquals("xacc", temp[1]);

      String[] seg3 = {"cc", "a", "x"};
      List<String> segment3 = new ArrayList<String>();
      for(String s : seg3)
         segment3.add(s);
      ans = cw.buildContiguousWord(segment3);
      assertEquals(6, ans.size());
      temp = new String[ans.size()];
      for(int g = 0; g < ans.size(); g++)
         temp[g] = ans.get(g);
      Arrays.sort(temp);
      assertEquals("accx", temp[0]);
      assertEquals("axcc", temp[1]);
      assertEquals("ccax", temp[2]);
      assertEquals("ccxa", temp[3]);
      assertEquals("xacc", temp[4]);
      assertEquals("xcca", temp[5]);
   }

   public void testBuildContiguousWordArrayListSize4_05()
   {
      ContiguousWord cw = new ContiguousWord();

      String[] seg1 = {"r", "o", "ta", "rt"};    //  rrtta
      List<String> segment1 = new ArrayList<String>();
      for(String s : seg1)
         segment1.add(s);
      List<String> ans = cw.buildContiguousWord(segment1);
      assertEquals(2, ans.size());
      String[] temp = new String[ans.size()];
      for(int g = 0; g < ans.size(); g++)
         temp[g] = ans.get(g);
      Arrays.sort(temp);
      assertEquals("orrtta", temp[0]);
      assertEquals("rrttao", temp[1]);

      String[] seg2 = {"ac", "x", "c", "d", "d"};    //  acc   dd   x
      List<String> segment2 = new ArrayList<String>();
      for(String s : seg2)
         segment2.add(s);
      ans = cw.buildContiguousWord(segment2);
      assertEquals(6, ans.size());
      temp = new String[ans.size()];
      for(int g = 0; g < ans.size(); g++)
         temp[g] = ans.get(g);
      Arrays.sort(temp);
      assertEquals("accddx", temp[0]);
      assertEquals("accxdd", temp[1]);
      assertEquals("ddaccx", temp[2]);
      assertEquals("ddxacc", temp[3]);
      assertEquals("xaccdd", temp[4]);
      assertEquals("xddacc", temp[5]);

      String[] seg3 = {"ca", "q", "x", "ta", "z"};
      List<String> segment3 = new ArrayList<String>();
      for(String s : seg3)
         segment3.add(s);
      ans = cw.buildContiguousWord(segment3);
      assertEquals(0, ans.size());

      String[] seg4 = {"ca", "zq", "ax", "dc", "xz"};
      List<String> segment4 = new ArrayList<String>();
      for(String s : seg4)
         segment4.add(s);
      ans = cw.buildContiguousWord(segment4);
      assertEquals(1, ans.size());
      temp = new String[ans.size()];
      for(int g = 0; g < ans.size(); g++)
         temp[g] = ans.get(g);
      Arrays.sort(temp);
      assertEquals("dccaaxxzzq", temp[0]);
  }

   public void testBuildContiguousWordArrayListSize5_06()
   {
      ContiguousWord cw = new ContiguousWord();

      String[] seg1 = {"r", "o", "a", "r", "at"};
      List<String> segment1 = new ArrayList<String>();
      for(String s : seg1)
         segment1.add(s);
      List<String> ans = cw.buildContiguousWord(segment1);    //   rr aat o 
      assertEquals(6, ans.size());
      String[] temp = new String[ans.size()];
      for(int g = 0; g < ans.size(); g++)
         temp[g] = ans.get(g);
      Arrays.sort(temp);
      assertEquals("aatorr", temp[0]);
      assertEquals("aatrro", temp[1]);
      assertEquals("oaatrr", temp[2]);
      assertEquals("orraat", temp[3]);
      assertEquals("rraato", temp[4]);
      assertEquals("rroaat", temp[5]);

      String[] seg2 = {"wm", "os", "fr", "rw", "sf"};
      List<String> segment2 = new ArrayList<String>();
      for(String s : seg2)
         segment2.add(s);
      ans = cw.buildContiguousWord(segment2);
      assertEquals(1, ans.size());
      temp = new String[ans.size()];
      for(int g = 0; g < ans.size(); g++)
         temp[g] = ans.get(g);
      Arrays.sort(temp);
      assertEquals("ossffrrwwm", temp[0]);

      String[] seg3 = {"w", "m", "f", "wq", "f"};
      List<String> segment3 = new ArrayList<String>();
      for(String s : seg3)
         segment3.add(s);
      ans = cw.buildContiguousWord(segment3);    //   ff m wwq 
      assertEquals(3*2, ans.size());
      temp = new String[ans.size()];
      for(int g = 0; g < ans.size(); g++)
         temp[g] = ans.get(g);
      Arrays.sort(temp);
      assertEquals("ffmwwq", temp[0]);
      assertEquals("ffwwqm", temp[1]);
      assertEquals("mffwwq", temp[2]);
      assertEquals("mwwqff", temp[3]);
      assertEquals("wwqffm", temp[4]);
      assertEquals("wwqmff", temp[5]);

      String[] seg4 = {"wm", "sos", "fr", "rw", "sf"};
      List<String> segment4 = new ArrayList<String>();
      for(String s : seg4)
         segment4.add(s);
      ans = cw.buildContiguousWord(segment4);
      assertEquals(0, ans.size());
   }

   public void testBuildContiguousWordArrayListSize2and3_07()
   {
      testBuildContiguousWordArrayListSize2_03();
      testBuildContiguousWordArrayListSize3_04();
   }

   public void testBuildContiguousWordArrayListSize2and3and4_8()
   {
      testBuildContiguousWordArrayListSize2_03();
      testBuildContiguousWordArrayListSize3_04();
      testBuildContiguousWordArrayListSize4_05();
   }

   public void testBuildContiguousWordArrayListSize2and3and4and5_9()
   {
      testBuildContiguousWordArrayListSize2_03();
      testBuildContiguousWordArrayListSize3_04();
      testBuildContiguousWordArrayListSize4_05();
      testBuildContiguousWordArrayListSize5_06();
   }

   public void testAllContiguousWord()
   {
      testIsContiguousWord02();
      testBuildContiguousWordArrayListSize2_03();
      testBuildContiguousWordArrayListSize3_04();
      testBuildContiguousWordArrayListSize4_05();
      testBuildContiguousWordArrayListSize5_06();
   }

   public void testZipper01()
   {
      Zipper zip = new Zipper("tcraete");

      assertEquals(true, zip.canBuild("cat", "tree"));
      assertEquals(true, zip.canBuild("tcae", "etre"));
      assertEquals(false, zip.canBuild("cat", "ret"));
      assertEquals(true, zip.canBuild("teak", "crochet"));

      Zipper zip1 = new Zipper("tcraete");
      assertEquals(true, zip1.canZipper("cat", "tree"));
      Zipper zip2 = new Zipper("catrtee");
      assertEquals(true, zip2.canZipper("cat", "tree"));
      Zipper zip3 = new Zipper("cttaree");
      assertEquals(false, zip3.canZipper("cat", "ret"));
      Zipper zip4 = new Zipper("jejunator");
      assertEquals(true, zip4.canZipper("dejeuner", "jubilation"));
      Zipper zip5 = new Zipper("to or too");
      assertEquals(false, zip5.canZipper("tor ", "ot oo"));
      assertEquals(true, zip5.canZipper("to r", "o too"));
   }

   public void testCanBuildNoDuplicateLetters02()
   {
      Zipper zip = new Zipper("abcde");

      assertEquals(true, zip.canBuild("aeb", "cwd"));
      assertEquals(true, zip.canBuild("edcba", "quit"));
      assertEquals(false, zip.canBuild("abd", "def"));

      zip = new Zipper("edcba");

      assertEquals(true, zip.canBuild("aeb", "cwd"));
      assertEquals(true, zip.canBuild("edcba", "quit"));
      assertEquals(false, zip.canBuild("abd", "def"));
   }

   public void testCanBuildWithDuplicateLetters03()
   {
      Zipper zip = new Zipper("wearecs");

      assertEquals(true, zip.canBuild("arsa", "ecwe"));
      assertEquals(true, zip.canBuild("sceraew", ""));

      assertEquals(false, zip.canBuild("wear", "cs"));
      assertEquals(false, zip.canBuild("ec", "ceaew"));
   }

   public void testCanBuildBoth04()
   {
      testCanBuildNoDuplicateLetters02();
      testCanBuildWithDuplicateLetters03();
   }

   public void testCanZipperNoDuplicateLettersNoSpaces05()
   {
      Zipper zip = new Zipper("comp");
      assertEquals(true, zip.canZipper("cmu", "xopl"));

      zip = new Zipper("computer");

      assertEquals(true, zip.canZipper("computer", "science"));
      assertEquals(true, zip.canZipper("science", "computer"));
      assertEquals(true, zip.canZipper("cmue", "optr"));
      assertEquals(true, zip.canZipper("cmuwe", "xopltnr"));
      assertEquals(true, zip.canZipper("czmquwe", "xopgkltnbir"));

      assertEquals(false, zip.canZipper("comp","utre"));
      assertEquals(false, zip.canZipper("cxzom", "ptqweru"));
   }

   public void testCanZipperWithDuplicateLettersWithSpaces06()
   {
      Zipper zip = new Zipper("computerscience");
      assertEquals(true, zip.canZipper("ctmutececn", "xoplrtsiece"));
      assertEquals(true, zip.canZipper("omutien", "cperscce"));
      assertEquals(false, zip.canZipper("omutien", "cperscec"));

      zip = new Zipper("oroonoko");

      assertEquals(true, zip.canZipper("ooooo", "rnk"));
      assertEquals(true, zip.canZipper("noko", "oroo"));
      assertEquals(true, zip.canZipper("rooo", "onko"));
      assertEquals(true, zip.canZipper("oroonoko", ""));
      assertEquals(true, zip.canZipper("nrqqowwoorrr", "rvokknko"));

      assertEquals(false, zip.canZipper("ooooor","nk"));
      assertEquals(false, zip.canZipper("roooomko", "o"));

      zip = new Zipper("gaggle or giggle");

      assertEquals(true, zip.canZipper("  ", "gaggleorgiggle"));
      assertEquals(true, zip.canZipper("ggg rggg", "aleo ile"));
      assertEquals(true, zip.canZipper("ggg oggg", "aler ile"));
      assertEquals(true, zip.canZipper("gal rg ggl", "ggeo ie"));

      assertEquals(false, zip.canZipper("gggggg", "aleile"));
      assertEquals(false, zip.canZipper("gggggg ", "aleile "));
      assertEquals(false, zip.canZipper("ggagleggg", "aleile"));
   }

   public void testCanZipperAll07()
   {
      testCanZipperNoDuplicateLettersNoSpaces05();
      testCanZipperWithDuplicateLettersWithSpaces06();
   }

   public void testCanBuildCanZipperNODuplicateLetters08()
   {
      testCanBuildNoDuplicateLetters02();
      testCanZipperNoDuplicateLettersNoSpaces05();
   }

   public void testCanBuildCanZipperWithDuplicateLetters09()
   {
      testCanBuildWithDuplicateLetters03();
      testCanZipperWithDuplicateLettersWithSpaces06();
   }

   public void testAll10()
   {
      testZipper01();
      testCanBuildCanZipperNODuplicateLetters08();
      testCanBuildCanZipperWithDuplicateLetters09();
   }
}
