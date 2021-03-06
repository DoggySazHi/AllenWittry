import java.util.*;

/**
 * The test class FinalTest.
 *
 * @author  Don Allen
 * @version 2019 Wittry programming contest
 */
public class Wittry2019FinalTest extends junit.framework.TestCase
{
   public void testStudentSnake01()
   {
      String[][] myBoard = { { " ", " ", " ", " "},
                             { " ", " ", " ", " "},
                             { "F", " ", " ", " "},
                             { " ", " ", " ", " "},
                             { " ", " ", " ", " "} };
      List<SnakeLocation> mySnake = new ArrayList<SnakeLocation>();
      mySnake.add(new SnakeLocation(2,2));
      mySnake.add(new SnakeLocation(2,3));
      mySnake.add(new SnakeLocation(3,3));
      mySnake.add(new SnakeLocation(3,2));
      Snakes sn = new Snakes(myBoard, mySnake);

      assertEquals("L", sn.getDirection());
      
      List<SnakeLocation> snake = sn.getSnakeBody();
      assertEquals( 4, snake.size()); 
      assertEquals( 2, snake.get(0).getX());
      assertEquals( 2, snake.get(0).getY());
      assertEquals( 2, snake.get(1).getX());
      assertEquals( 3, snake.get(1).getY());
      assertEquals( 3, snake.get(2).getX());
      assertEquals( 3, snake.get(2).getY());
      assertEquals( 3, snake.get(3).getX());
      assertEquals( 2, snake.get(3).getY());
      
      assertEquals(true, sn.move("D"));
      assertEquals( 4, sn.getSnakeBody().size());
      assertEquals("D", sn.getDirection());           // head at (3, 2)
      assertEquals( 4, sn.getSnakeBody().size());     // head at (3, 2), (2,2), (2, 3), (3, 3)
      assertEquals( new SnakeLocation(3,2), sn.getSnakeBody().get(0));     // head at (3, 2), (2,2), (2, 3), (3, 3)
      assertEquals( new SnakeLocation(2,2), sn.getSnakeBody().get(1));     // head at (3, 2), (2,2), (2, 3), (3, 3)
      assertEquals( new SnakeLocation(2,3), sn.getSnakeBody().get(2));     // head at (3, 2), (2,2), (2, 3), (3, 3)
      assertEquals( new SnakeLocation(3,3), sn.getSnakeBody().get(3));     // head at (3, 2), (2,2), (2, 3), (3, 3)

      assertEquals(true, sn.move("L"));
      assertEquals( 4, sn.getSnakeBody().size());
      assertEquals("L", sn.getDirection());           // head at (3, 1)
      assertEquals( 4, sn.getSnakeBody().size());     // head at (3, 1), (3, 2), (2,2), (2, 3)

      assertEquals(true, sn.move(" "));
      assertEquals( 4, sn.getSnakeBody().size());     // head at (3, 0), (3, 1), (3, 2), (2, 2)
      assertEquals("L", sn.getDirection());           // head at (3, 0)

      assertEquals(true, sn.move("U"));
      assertEquals( 4, sn.getSnakeBody().size());     // head at (2, 0), (3, 0), (3, 1), (3, 2)

      assertEquals(true, sn.move("R"));
      assertEquals( 5, sn.getSnakeBody().size());     // head at (2, 1), (2, 0), (3, 0), (3, 1), (3, 2)

      assertEquals(false, sn.move("D"));
   }

    public void testGetDirection02()
    {
        String[][] myBoard = { { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "} };
        List<SnakeLocation> mySnake = new ArrayList<SnakeLocation>();
        mySnake.add(new SnakeLocation(1, 2));
        mySnake.add(new SnakeLocation(2, 2));
        mySnake.add(new SnakeLocation(3, 2));
        Snakes sn = new Snakes(myBoard, mySnake);
        assertEquals("U", sn.getDirection());

        mySnake.add(0, new SnakeLocation(1, 3));
        sn = new Snakes(myBoard, mySnake);
        assertEquals("R", sn.getDirection());

        mySnake.add(0, new SnakeLocation(2, 3));
        sn = new Snakes(myBoard, mySnake);
        assertEquals("D", sn.getDirection());

        mySnake.remove(mySnake.size()-1);
        mySnake.remove(mySnake.size()-1);
        mySnake.add(0, new SnakeLocation(2, 2));
        sn = new Snakes(myBoard, mySnake);
        assertEquals("L", sn.getDirection());
    }

    /*
     *    test:  moves all four directions
     *    
     *    does not test:   running into itself
     *                     running off edge of world
     *                     finding food
     */
    public void testMoveFreely03()
    {
        String[][] myBoard = { { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "} };
        List<SnakeLocation> mySnake = new ArrayList<SnakeLocation>();
        mySnake.add(new SnakeLocation(0, 2));
        mySnake.add(new SnakeLocation(0, 1));
        mySnake.add(new SnakeLocation(0, 0));
        Snakes sn = new Snakes(myBoard, mySnake);

        assertEquals(true, sn.move(" "));
        assertEquals( 3, sn.getSnakeBody().size());

        assertEquals(true, sn.move("D"));
        assertEquals(true, sn.move(" "));
        assertEquals(true, sn.move(" "));
        assertEquals( 3, sn.getSnakeBody().size());     // body at: (3, 3), (2, 3), (1, 3)

        assertEquals(true, sn.move("L"));               // moves body to: ??????
        assertEquals(true, sn.move(" "));               // moves body to: ??????
        assertEquals(true, sn.move(" "));               // moves body to: ??????

        assertEquals(true, sn.move("D"));
        assertEquals(true, sn.move(" "));
        assertEquals(true, sn.move(" "));
        assertEquals( 3, sn.getSnakeBody().size());     // body at: (6, 0), (5, 0), (4, 0)

        assertEquals(true, sn.move("R"));               // moves body to: ????????
        assertEquals(true, sn.move("R"));               // moves body to: ????????
        assertEquals(true, sn.move(" "));               // moves body to: ????????
        assertEquals( 3, sn.getSnakeBody().size());     // body at: (6, 3), (6, 2), (6, 1)
        assertEquals(new SnakeLocation(6, 3), sn.getSnakeBody().get(0));
        assertEquals(new SnakeLocation(6, 2), sn.getSnakeBody().get(1));
        assertEquals(new SnakeLocation(6, 1), sn.getSnakeBody().get(2));

        assertEquals(true, sn.move("U"));
        assertEquals(true, sn.move(" "));
        assertEquals(true, sn.move(" "));
        assertEquals( 3, sn.getSnakeBody().size());     // body at: (3, 3), (4, 3), (5, 3)
        assertEquals(new SnakeLocation(3, 3), sn.getSnakeBody().get(0));
        assertEquals(new SnakeLocation(4, 3), sn.getSnakeBody().get(1));
        assertEquals(new SnakeLocation(5, 3), sn.getSnakeBody().get(2));
    }

    /*
     *    test: moves all four directions
     *          running off edge of world
     *    
     *    does not test: finding food
     *                   running into itself
     */
    public void testMoveOffGrid04()
    {
        String[][] myBoard = { { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "} };
        List<SnakeLocation> mySnake = new ArrayList<SnakeLocation>();
        mySnake.add(new SnakeLocation(0, 2));
        mySnake.add(new SnakeLocation(0, 1));
        mySnake.add(new SnakeLocation(0, 0));
        Snakes sn = new Snakes(myBoard, mySnake);

        assertEquals(false, sn.move("U"));
        assertEquals( 3, sn.getSnakeBody().size());

        mySnake = new ArrayList<SnakeLocation>();
        mySnake.add(new SnakeLocation(0, 0));
        mySnake.add(new SnakeLocation(1, 0));
        mySnake.add(new SnakeLocation(2, 0));
        sn = new Snakes(myBoard, mySnake);

        assertEquals(false, sn.move("L"));
        assertEquals( 3, sn.getSnakeBody().size());

        mySnake = new ArrayList<SnakeLocation>();
        mySnake.add(new SnakeLocation(6, 5));
        mySnake.add(new SnakeLocation(6, 4));
        mySnake.add(new SnakeLocation(6, 3));
        sn = new Snakes(myBoard, mySnake);

        assertEquals(false, sn.move("R"));
        assertEquals( 3, sn.getSnakeBody().size());

        mySnake = new ArrayList<SnakeLocation>();
        mySnake.add(new SnakeLocation(6, 5));
        mySnake.add(new SnakeLocation(6, 4));
        mySnake.add(new SnakeLocation(6, 3));
        sn = new Snakes(myBoard, mySnake);

        assertEquals(false, sn.move("D"));
        assertEquals( 3, sn.getSnakeBody().size());
    }

    /*
     *    test: moves all four directions
     *          running into itself
     *    
     *    does not test: finding food
     *                   running off edge of world
     */
    public void testMoveOntoSelf05()
    {
        String[][] myBoard = { { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " ", " "} };

        List<SnakeLocation> mySnake = new ArrayList<SnakeLocation>();
        mySnake.add(new SnakeLocation(3, 2));
        mySnake.add(new SnakeLocation(4, 2));       //   HT
        mySnake.add(new SnakeLocation(4, 3));       //   12
        mySnake.add(new SnakeLocation(3, 3));       //   
        Snakes sn = new Snakes(myBoard, mySnake);   
        assertEquals(true, sn.move("R"));

        mySnake.add(new SnakeLocation(3, 4));
        sn = new Snakes(myBoard, mySnake);             //   H3T
        assertEquals( 5, sn.getSnakeBody().size());    //   12
        assertEquals(false, sn.move("R"));             //
        assertEquals( 5, sn.getSnakeBody().size());

        mySnake = new ArrayList<SnakeLocation>();
        mySnake.add(new SnakeLocation(4, 2));
        mySnake.add(new SnakeLocation(4, 3));       //   TH
        mySnake.add(new SnakeLocation(3, 3));       //   21
        mySnake.add(new SnakeLocation(3, 2));       //   
        sn = new Snakes(myBoard, mySnake);   
        assertEquals(true, sn.move("L"));

        mySnake.add(new SnakeLocation(1, 2));
        sn = new Snakes(myBoard, mySnake);             //   T3H
        assertEquals( 5, sn.getSnakeBody().size());    //    21
        assertEquals(false, sn.move("R"));             //
        assertEquals( 5, sn.getSnakeBody().size());

        mySnake = new ArrayList<SnakeLocation>();
        mySnake.add(new SnakeLocation(3, 4));
        mySnake.add(new SnakeLocation(3, 3));       //   1H
        mySnake.add(new SnakeLocation(4, 3));       //   2T
        mySnake.add(new SnakeLocation(4, 4));       //   
        sn = new Snakes(myBoard, mySnake);   
        assertEquals(true, sn.move("D"));

        mySnake.add(new SnakeLocation(5, 4));
        sn = new Snakes(myBoard, mySnake);             //   1H
        assertEquals( 5, sn.getSnakeBody().size());    //   23
        assertEquals(false, sn.move("D"));             //    T
        assertEquals( 5, sn.getSnakeBody().size());

        mySnake = new ArrayList<SnakeLocation>();
        mySnake.add(new SnakeLocation(4, 3));
        mySnake.add(new SnakeLocation(4, 2));       //   2T
        mySnake.add(new SnakeLocation(3, 2));       //   1H
        mySnake.add(new SnakeLocation(3, 3));       //   
        sn = new Snakes(myBoard, mySnake);   
        assertEquals(true, sn.move("U"));

        mySnake.add(new SnakeLocation(3, 4));
        sn = new Snakes(myBoard, mySnake);             //   23T
        assertEquals( 5, sn.getSnakeBody().size());    //   1H
        assertEquals(false, sn.move("U"));             //    
        assertEquals( 5, sn.getSnakeBody().size());
    }

    /*
     *    test: finding food
     *    
     *    does not test: finding food
     *                   running into itself
     *                   running off edge of world
     */
    public void testMoveOffFood06()
    {
        String[][] myBoard = { { " ", " ", " ", " ", " ", " ", " "},
                               { " ", "F", " ", " ", " ", " ", " "},
                               { " ", " ", " ", " ", " ", " ", " "},
                               { " ", " ", " ", " ", " ", " ", " "},
                               { " ", " ", " ", " ", " ", "F", " "},
                               { "F", " ", " ", " ", " ", " ", " "},
                               { " ", " ", " ", " ", " ", " ", " "},
                               { " ", " ", "F", " ", " ", " ", " "},
                               { " ", " ", " ", " ", " ", " ", " "} };

        List<SnakeLocation> mySnake = new ArrayList<SnakeLocation>();
        mySnake.add(new SnakeLocation(1, 1));
        mySnake.add(new SnakeLocation(2, 1));
        mySnake.add(new SnakeLocation(3, 1));
        Snakes sn = new Snakes(myBoard, mySnake);

        assertEquals(true, sn.move("U"));
        assertEquals( 4, sn.getSnakeBody().size());
        assertEquals(new SnakeLocation(0, 1), sn.getSnakeBody().get(0));
        assertEquals(new SnakeLocation(1, 1), sn.getSnakeBody().get(1));
        assertEquals(new SnakeLocation(2, 1), sn.getSnakeBody().get(2));
        assertEquals(new SnakeLocation(3, 1), sn.getSnakeBody().get(3));

        mySnake = new ArrayList<SnakeLocation>();
        mySnake.add(new SnakeLocation(4, 5));
        mySnake.add(new SnakeLocation(5, 5));
        mySnake.add(new SnakeLocation(5, 4));
        mySnake.add(new SnakeLocation(5, 3));
        mySnake.add(new SnakeLocation(4, 3));
        mySnake.add(new SnakeLocation(4, 2));
        sn = new Snakes(myBoard, mySnake);

        assertEquals(true, sn.move("R"));
        assertEquals( 7, sn.getSnakeBody().size());
        assertEquals(new SnakeLocation(4, 6), sn.getSnakeBody().get(0));
        assertEquals(new SnakeLocation(4, 5), sn.getSnakeBody().get(1));
        assertEquals(new SnakeLocation(5, 5), sn.getSnakeBody().get(2));
        assertEquals(new SnakeLocation(5, 4), sn.getSnakeBody().get(3));
        assertEquals(new SnakeLocation(5, 3), sn.getSnakeBody().get(4));
        assertEquals(new SnakeLocation(4, 3), sn.getSnakeBody().get(5));
        assertEquals(new SnakeLocation(4, 2), sn.getSnakeBody().get(6));

        mySnake = new ArrayList<SnakeLocation>();
        mySnake.add(new SnakeLocation(4, 5));
        mySnake.add(new SnakeLocation(5, 5));
        mySnake.add(new SnakeLocation(5, 4));
        mySnake.add(new SnakeLocation(5, 3));
        mySnake.add(new SnakeLocation(4, 3));
        sn = new Snakes(myBoard, mySnake);

        assertEquals(true, sn.move("L"));
        assertEquals( 6, sn.getSnakeBody().size());
        assertEquals(new SnakeLocation(4, 4), sn.getSnakeBody().get(0));
        assertEquals(new SnakeLocation(4, 5), sn.getSnakeBody().get(1));
        assertEquals(new SnakeLocation(5, 5), sn.getSnakeBody().get(2));
        assertEquals(new SnakeLocation(5, 4), sn.getSnakeBody().get(3));
        assertEquals(new SnakeLocation(5, 3), sn.getSnakeBody().get(4));
        assertEquals(new SnakeLocation(4, 3), sn.getSnakeBody().get(5));

        mySnake = new ArrayList<SnakeLocation>();
        mySnake.add(new SnakeLocation(5, 0));
        mySnake.add(new SnakeLocation(5, 1));
        mySnake.add(new SnakeLocation(5, 2));
        mySnake.add(new SnakeLocation(5, 3));
        sn = new Snakes(myBoard, mySnake);

        assertEquals(true, sn.move("D"));
        assertEquals( 5, sn.getSnakeBody().size());
        assertEquals(new SnakeLocation(6, 0), sn.getSnakeBody().get(0));
        assertEquals(new SnakeLocation(5, 0), sn.getSnakeBody().get(1));
        assertEquals(new SnakeLocation(5, 1), sn.getSnakeBody().get(2));
        assertEquals(new SnakeLocation(5, 2), sn.getSnakeBody().get(3));
        assertEquals(new SnakeLocation(5, 3), sn.getSnakeBody().get(4));

        mySnake = new ArrayList<SnakeLocation>();
        mySnake.add(new SnakeLocation(5, 0));
        mySnake.add(new SnakeLocation(5, 1));
        mySnake.add(new SnakeLocation(5, 2));
        mySnake.add(new SnakeLocation(5, 3));
        sn = new Snakes(myBoard, mySnake);

        assertEquals(true, sn.move("D"));
        assertEquals( 5, sn.getSnakeBody().size());
        assertEquals(new SnakeLocation(6, 0), sn.getSnakeBody().get(0));
        assertEquals(new SnakeLocation(5, 0), sn.getSnakeBody().get(1));
        assertEquals(new SnakeLocation(5, 1), sn.getSnakeBody().get(2));
        assertEquals(new SnakeLocation(5, 2), sn.getSnakeBody().get(3));
        assertEquals(new SnakeLocation(5, 3), sn.getSnakeBody().get(4));
    }

    public void testGetDirectionMoveFreely07()
    {
       testGetDirection02();
       testMoveFreely03();
    }

    public void testmoveOffGridOntoSelf08()
    {
       testMoveOffGrid04();
       testMoveOntoSelf05();
    }

    public void testOntoSelfOffFood09()
    {
       testMoveOntoSelf05();
       testMoveOffFood06();
    }

    public void testOffGridOffFood09()
    {
       testMoveOffGrid04();
       testMoveOffFood06();
    }
    
    public void testMarbles01()
    {
        Fraction temp = new Fraction(2*5*7*7, 2*3*7);
        temp.reduce();
        assertEquals(5*7, temp.getNumerator());
        assertEquals(3, temp.getDenominator());

        temp = new Fraction(0, 2*5*7*7*2*3*7);
        temp.reduce();
        assertEquals(0, temp.getNumerator());
        assertEquals(1, temp.getDenominator());

        List<Integer> bag = new ArrayList<Integer>();
        bag.add( new Integer(7));
        bag.add( new Integer(3));
        bag.add( new Integer(0));
        bag.add( new Integer(3));
        bag.add( new Integer(11));
        bag.add( new Integer(6));
        bag.add( new Integer(9));
        bag.add( new Integer(9));
        bag.add( new Integer(5));
        bag.add( new Integer(1));

        Marbles m = new Marbles(bag);

        assertEquals(0+1+3, m.getMinSum(3) );
        assertEquals(9+9+11, m.getMaxSum(3) );

        Fraction f = m.getProbability(3, 0+9+11);
        assertEquals(1, f.getNumerator() );  //  2*(0 + 9 + 11), 2*(3+6+11), 2*(9+6+5) 
        assertEquals(20, f.getDenominator());
    }

    public void testReduceFractionMarbles02()
    {
        Fraction temp = new Fraction(3*5*7, 3*5*5*7*11);
        temp.reduce();
        assertEquals("3*5*7, 3*5*5*7*11",    1, temp.getNumerator());
        assertEquals("3*5*7, 3*5*5*7*11", 5*11, temp.getDenominator());

        temp = new Fraction(2*5*5*17, 5*17);
        temp.reduce();
        assertEquals("2*5*5*17 / 5*17", 2*5, temp.getNumerator());
        assertEquals("2*5*5*17 / 5*17",   1, temp.getDenominator());

        temp = new Fraction(2*3*5*5*17*23*31, 2*5*7*17*19*29);
        temp.reduce();
        assertEquals("2*3*5*5*17*23*31 / 2*5*7*17*19*29", 3*5*23*31, temp.getNumerator());
        assertEquals("2*3*5*5*17*23*31 / 2*5*7*17*19*29",   7*19*29, temp.getDenominator());

        temp = new Fraction(0, 2*5*17*31*73);
        temp.reduce();
        assertEquals(0, temp.getNumerator());
        assertEquals(1, temp.getDenominator());
    }

    public void testMinSumMarbles03()
    {
        List<Integer> bag = new ArrayList<Integer>();
        bag.add( new Integer(41));
        bag.add( new Integer(21));
        bag.add( new Integer(17));
        bag.add( new Integer(1));
        bag.add( new Integer(311));
        bag.add( new Integer(20));
        bag.add( new Integer(19));
        bag.add( new Integer(3));
        bag.add( new Integer(99));
        Marbles m = new Marbles(bag);

        assertEquals(1+3+17, m.getMinSum(3) );

        bag.add( new Integer(55));
        bag.add( new Integer(6));
        bag.add( new Integer(27));
        m = new Marbles(bag);

        assertEquals(1+3+6+17, m.getMinSum(4) );

        bag.add(0, new Integer(2));
        bag.add( new Integer(9));
        m = new Marbles(bag);

        assertEquals(1, m.getMinSum(1) );
        assertEquals(1+2+3+6+9+17, m.getMinSum(6) );
        assertEquals(41+21+17+1+311+20+19+3+99+55+6+27+2+9, m.getMinSum(bag.size()) );
    }

    public void testMaxSumMarbles04()
    {
        List<Integer> bag = new ArrayList<Integer>();
        bag.add( new Integer(41));
        bag.add( new Integer(21));
        bag.add( new Integer(17));
        bag.add( new Integer(1));
        bag.add( new Integer(311));
        bag.add( new Integer(20));
        bag.add( new Integer(19));
        bag.add( new Integer(3));
        bag.add( new Integer(99));
        Marbles m = new Marbles(bag);

        assertEquals(311, m.getMaxSum(1) );
        assertEquals(311+99, m.getMaxSum(2) );

        bag.add( new Integer(155));
        bag.add( new Integer(6));
        bag.add( new Integer(3));
        bag.add( new Integer(27));
        m = new Marbles(bag);

        assertEquals(311+155, m.getMaxSum(2) );
        assertEquals(311+155+99, m.getMaxSum(3) );

        bag.add(0, new Integer(209));
        bag.add( new Integer(79));
        m = new Marbles(bag);

        assertEquals(311+209+155+99+79+41, m.getMaxSum(6) );
        assertEquals(41+21+17+1+311+20+19+3+99+155+6+3+27+209+79, m.getMaxSum(bag.size()) );
    }

    public void testMinAndMaxSumMarbles05()
    {
        testMinSumMarbles03();
        testMaxSumMarbles04();
    }

    public void testProbabilityMarbles06()
    {
        List<Integer> bag = new ArrayList<Integer>();
        bag.add( new Integer(1));
        bag.add( new Integer(2));
        bag.add( new Integer(4));
        bag.add( new Integer(8));
        bag.add( new Integer(16));
        bag.add( new Integer(32));
        bag.add( new Integer(64));
        bag.add( new Integer(128));
        Marbles m = new Marbles(bag);

        Fraction f = m.getProbability(1, 4);
        assertEquals(1, f.getNumerator() );  //  2*(0 + 9 + 11), 2*(3+6+11), 2*(9+6+5) 
        assertEquals(8, f.getDenominator());

        f = m.getProbability(3, 4+16+64);
        assertEquals(1, f.getNumerator() );  //  2*(0 + 9 + 11), 2*(3+6+11), 2*(9+6+5) 
        assertEquals(56, f.getDenominator());

        f = m.getProbability(8, 255);
        assertEquals(1, f.getNumerator() );  //  2*(0 + 9 + 11), 2*(3+6+11), 2*(9+6+5) 
        assertEquals(1, f.getDenominator());
    }

    public void testProbabilityMarbles07()
    {
        List<Integer> bag = new ArrayList<Integer>();
        bag.add( new Integer(4));
        bag.add( new Integer(6));
        bag.add( new Integer(8));
        bag.add( new Integer(12));
        bag.add( new Integer(16));
        bag.add( new Integer(1));
        bag.add( new Integer(32));
        bag.add( new Integer(2));
        bag.add( new Integer(10));
        bag.add( new Integer(20));
        bag.add( new Integer(4));
        bag.add( new Integer(2));
        Marbles m = new Marbles(bag);

        Fraction f = m.getProbability(2, 14);
        assertEquals(5, f.getNumerator() );  
        assertEquals(66, f.getDenominator());

        f = m.getProbability(5, 10+12+16+20+32);
        assertEquals(1, f.getNumerator() );  
        assertEquals(792, f.getDenominator());

        f = m.getProbability(5, 4+12+16+20+32);
        assertEquals(1, f.getNumerator() );  
        assertEquals(792/3, f.getDenominator());
    }

    public void testProbabilityMarbles08()
    {
        List<Integer> bag = new ArrayList<Integer>();
        bag.add( new Integer(11));
        bag.add( new Integer(3));
        bag.add( new Integer(12));
        bag.add( new Integer(1));
        bag.add( new Integer(4));
        bag.add( new Integer(3));
        bag.add( new Integer(4));
        bag.add( new Integer(20));
        bag.add( new Integer(1));
        bag.add( new Integer(8));
        bag.add( new Integer(7));
        Marbles m = new Marbles(bag);

        Fraction f = m.getProbability(1, 3);
        assertEquals(2, f.getNumerator() );  
        assertEquals(11, f.getDenominator());

        f = m.getProbability(3, 99);
        assertEquals(0, f.getNumerator() );  
        assertEquals(1, f.getDenominator());

        f = m.getProbability(4, 16);
        assertEquals(2, f.getNumerator() );  
        assertEquals(55, f.getDenominator());
    }

    public void testProbabilityMarbles09()
    {
        List<Integer> bag = new ArrayList<Integer>();
        bag.add( new Integer(2));
        bag.add( new Integer(3));
        bag.add( new Integer(1));
        bag.add( new Integer(1));
        bag.add( new Integer(4));
        bag.add( new Integer(3));
        bag.add( new Integer(4));
        bag.add( new Integer(2));
        bag.add( new Integer(1));
        bag.add( new Integer(2));
        bag.add( new Integer(3));
        Marbles m = new Marbles(bag);

        Fraction f = m.getProbability(8, 20);
        assertEquals(34, f.getNumerator() );  
        assertEquals(165, f.getDenominator());

        f = m.getProbability(3, 3);
        assertEquals(1, f.getNumerator() );  
        assertEquals(165, f.getDenominator());

        f = m.getProbability(1, 3);
        assertEquals(3, f.getNumerator() );  
        assertEquals(11, f.getDenominator());
    }

    public void testAllMarbles10()
    {
        testMarbles01();
        testReduceFractionMarbles02();
        testMinSumMarbles03();
        testMaxSumMarbles04();
        testProbabilityMarbles06();
        testProbabilityMarbles07();
        testProbabilityMarbles08();
        testProbabilityMarbles09();
    }
    
    public void testFarySequence01()
   {
        Fraction temp = new Fraction(2*5*7*7, 2*3*7);
        temp.reduce();
        assertEquals(5*7, temp.getNumerator());
        assertEquals(3, temp.getDenominator());

        temp = new Fraction(0, 2*5*7*7*2*3*7);
        temp.reduce();
        assertEquals(0, temp.getNumerator());
        assertEquals(1, temp.getDenominator());

        List<Fraction> sol = FareySequence.generateOrder(7);
        assertEquals(new Fraction(0, 1), sol.get(0));
        assertEquals(new Fraction(1, 7), sol.get(1));
        assertEquals(new Fraction(1, 6), sol.get(2));
        assertEquals(new Fraction(1, 5), sol.get(3));
        assertEquals(new Fraction(1, 4), sol.get(4));
        assertEquals(new Fraction(2, 7), sol.get(5));
        assertEquals(new Fraction(1, 3), sol.get(6));
        assertEquals(new Fraction(2, 5), sol.get(7));
        assertEquals(new Fraction(3, 7), sol.get(8));
        assertEquals(new Fraction(1, 2), sol.get(9));
        assertEquals(new Fraction(4, 7), sol.get(10));

        assertEquals(new Fraction(3, 5), sol.get(11));
        assertEquals(new Fraction(2, 3), sol.get(12));
        assertEquals(new Fraction(5, 7), sol.get(13));
        assertEquals(new Fraction(3, 4), sol.get(14));
        assertEquals(new Fraction(4, 5), sol.get(15));
        assertEquals(new Fraction(5, 6), sol.get(16));
        assertEquals(new Fraction(6, 7), sol.get(17));
        assertEquals(new Fraction(1, 1), sol.get(18));

        assertEquals(new Fraction(201, 64), FareySequence.getApproximation(Math.PI, new Fraction(3, 1), new Fraction(16, 5)));
        assertEquals(new Fraction(29, 41), FareySequence.getApproximation(Math.sqrt(2)/2., new Fraction(0, 1), new Fraction(1, 1)));
   }

   public void testFarySequenceGetOrder02()
   {
        List<Fraction> sol = FareySequence.generateOrder(1);
        assertEquals(new Fraction(0, 1), sol.get(0));
        assertEquals(new Fraction(1, 1), sol.get(1));

        sol = FareySequence.generateOrder(2);
        assertEquals(new Fraction(0, 1), sol.get(0));
        assertEquals(new Fraction(1, 2), sol.get(1));
        assertEquals(new Fraction(1, 1), sol.get(2));
   }

   public void testFarySequenceGetOrder03()
   {
        List<Fraction> sol = FareySequence.generateOrder(3);
        assertEquals(new Fraction(0, 1), sol.get(0));
        assertEquals(new Fraction(1, 3), sol.get(1));
        assertEquals(new Fraction(1, 2), sol.get(2));
        assertEquals(new Fraction(2, 3), sol.get(3));
        assertEquals(new Fraction(1, 1), sol.get(4));

        sol = FareySequence.generateOrder(4);
        assertEquals(new Fraction(0, 1), sol.get(0));
        assertEquals(new Fraction(1, 4), sol.get(1));
        assertEquals(new Fraction(1, 3), sol.get(2));
        assertEquals(new Fraction(1, 2), sol.get(3));
        assertEquals(new Fraction(2, 3), sol.get(4));
        assertEquals(new Fraction(3, 4), sol.get(5));
        assertEquals(new Fraction(1, 1), sol.get(6));

        sol = FareySequence.generateOrder(5);
        assertEquals(new Fraction(0, 1), sol.get(0));
        assertEquals(new Fraction(1, 5), sol.get(1));
        assertEquals(new Fraction(1, 4), sol.get(2));
        assertEquals(new Fraction(1, 3), sol.get(3));
        assertEquals(new Fraction(2, 5), sol.get(4));
        assertEquals(new Fraction(1, 2), sol.get(5));
        assertEquals(new Fraction(3, 5), sol.get(6));
        assertEquals(new Fraction(2, 3), sol.get(7));
        assertEquals(new Fraction(3, 4), sol.get(8));
        assertEquals(new Fraction(4, 5), sol.get(9));
        assertEquals(new Fraction(1, 1), sol.get(10));
   }

   public void testFarySequenceGetOrder04()
   {
        List<Fraction> sol = FareySequence.generateOrder(6);
        assertEquals(new Fraction(0, 1), sol.get(0));
        assertEquals(new Fraction(1, 6), sol.get(1));
        assertEquals(new Fraction(1, 5), sol.get(2));
        assertEquals(new Fraction(1, 4), sol.get(3));
        assertEquals(new Fraction(1, 3), sol.get(4));
        assertEquals(new Fraction(2, 5), sol.get(5));
        assertEquals(new Fraction(1, 2), sol.get(6));
        assertEquals(new Fraction(3, 5), sol.get(7));
        assertEquals(new Fraction(2, 3), sol.get(8));
        assertEquals(new Fraction(3, 4), sol.get(9));
        assertEquals(new Fraction(4, 5), sol.get(10));
        assertEquals(new Fraction(5, 6), sol.get(11));
        assertEquals(new Fraction(1, 1), sol.get(12));

        sol = FareySequence.generateOrder(8);
        assertEquals(new Fraction(0, 1), sol.get(0));
        assertEquals(new Fraction(1, 8), sol.get(1));
        assertEquals(new Fraction(1, 7), sol.get(2));
        assertEquals(new Fraction(1, 6), sol.get(3));
        assertEquals(new Fraction(1, 5), sol.get(4));
        assertEquals(new Fraction(1, 4), sol.get(5));
        assertEquals(new Fraction(2, 7), sol.get(6));
        assertEquals(new Fraction(1, 3), sol.get(7));
        assertEquals(new Fraction(3, 8), sol.get(8));
        assertEquals(new Fraction(2, 5), sol.get(9));
        assertEquals(new Fraction(3, 7), sol.get(10));
        assertEquals(new Fraction(1, 2), sol.get(11));
        assertEquals(new Fraction(4, 7), sol.get(12));
        assertEquals(new Fraction(3, 5), sol.get(13));
        assertEquals(new Fraction(5, 8), sol.get(14));
        assertEquals(new Fraction(2, 3), sol.get(15));
        assertEquals(new Fraction(5, 7), sol.get(16));
        assertEquals(new Fraction(3, 4), sol.get(17));
        assertEquals(new Fraction(4, 5), sol.get(18));
        assertEquals(new Fraction(5, 6), sol.get(19));
        assertEquals(new Fraction(6, 7), sol.get(20));
        assertEquals(new Fraction(7, 8), sol.get(21));
        assertEquals(new Fraction(1, 1), sol.get(22));
   }

   public void testFarySequenceGetOrder05()
   {
        List<Fraction> sol = FareySequence.generateOrder(10);
        assertEquals(new Fraction(0, 1), sol.get(0));
        assertEquals(new Fraction(1, 10), sol.get(1));
        assertEquals(new Fraction(1, 9), sol.get(2));
        assertEquals(new Fraction(1, 8), sol.get(3));
        assertEquals(new Fraction(1, 7), sol.get(4));
        assertEquals(new Fraction(1, 6), sol.get(5));
        assertEquals(new Fraction(1, 5), sol.get(6));
        assertEquals(new Fraction(2, 9), sol.get(7));
        assertEquals(new Fraction(1, 4), sol.get(8));
        assertEquals(new Fraction(2, 7), sol.get(9));
        assertEquals(new Fraction(3, 10), sol.get(10));
        assertEquals(new Fraction(1, 3), sol.get(11));
        assertEquals(new Fraction(3, 8), sol.get(12));
        assertEquals(new Fraction(2, 5), sol.get(13));
        assertEquals(new Fraction(3, 7), sol.get(14));
        assertEquals(new Fraction(4, 9), sol.get(15));
        assertEquals(new Fraction(1, 2), sol.get(16));
        assertEquals(new Fraction(5, 9), sol.get(17));
        assertEquals(new Fraction(4, 7), sol.get(18));
        assertEquals(new Fraction(3, 5), sol.get(19));
        assertEquals(new Fraction(5, 8), sol.get(20));
        assertEquals(new Fraction(2, 3), sol.get(21));
        assertEquals(new Fraction(7, 10), sol.get(22));
        assertEquals(new Fraction(5, 7), sol.get(23));
        assertEquals(new Fraction(3, 4), sol.get(24));
        assertEquals(new Fraction(7, 9), sol.get(25));
        assertEquals(new Fraction(4, 5), sol.get(26));
        assertEquals(new Fraction(5, 6), sol.get(27));
        assertEquals(new Fraction(6, 7), sol.get(28));
        assertEquals(new Fraction(7, 8), sol.get(29));
        assertEquals(new Fraction(8, 9), sol.get(30));
        assertEquals(new Fraction(9, 10), sol.get(31));
        assertEquals(new Fraction(1, 1), sol.get(32));
   }

   public void testFarySequenceGetOrder06()
   {
        List<Fraction> sol = FareySequence.generateOrder(13);
        assertEquals(new Fraction(0, 1), sol.get(0));
        assertEquals(new Fraction(1, 13), sol.get(1));
        assertEquals(new Fraction(1, 12), sol.get(2));
        assertEquals(new Fraction(1, 11), sol.get(3));
        assertEquals(new Fraction(1, 10), sol.get(4));
        assertEquals(new Fraction(1, 9), sol.get(5));
        assertEquals(new Fraction(1, 8), sol.get(6));
        assertEquals(new Fraction(1, 7), sol.get(7));
        assertEquals(new Fraction(2, 13), sol.get(8));
        assertEquals(new Fraction(1, 6), sol.get(9));
        assertEquals(new Fraction(2, 11), sol.get(10));
        assertEquals(new Fraction(1, 5), sol.get(11));
        assertEquals(new Fraction(2, 9), sol.get(12));
        assertEquals(new Fraction(3, 13), sol.get(13));
        assertEquals(new Fraction(1, 4), sol.get(14));
        assertEquals(new Fraction(3, 11), sol.get(15));
        assertEquals(new Fraction(2, 7), sol.get(16));
        assertEquals(new Fraction(3, 10), sol.get(17));
        assertEquals(new Fraction(4, 13), sol.get(18));
        assertEquals(new Fraction(1, 3), sol.get(19));
        assertEquals(new Fraction(4, 11), sol.get(20));
        assertEquals(new Fraction(3, 8), sol.get(21));
        assertEquals(new Fraction(5, 13), sol.get(22));
        assertEquals(new Fraction(2, 5), sol.get(23));
        assertEquals(new Fraction(5, 12), sol.get(24));
        assertEquals(new Fraction(3, 7), sol.get(25));
        assertEquals(new Fraction(4, 9), sol.get(26));
        assertEquals(new Fraction(5, 11), sol.get(27));
        assertEquals(new Fraction(6, 13), sol.get(28));
        assertEquals(new Fraction(1, 2), sol.get(29));
        assertEquals(new Fraction(7, 13), sol.get(30));
        assertEquals(new Fraction(6, 11), sol.get(31));
        assertEquals(new Fraction(5, 9), sol.get(32));
        assertEquals(new Fraction(4, 7), sol.get(33));
        assertEquals(new Fraction(7, 12), sol.get(34));
        assertEquals(new Fraction(3, 5), sol.get(35));
        assertEquals(new Fraction(8, 13), sol.get(36));
        assertEquals(new Fraction(5, 8), sol.get(37));
        assertEquals(new Fraction(7, 11), sol.get(38));
        assertEquals(new Fraction(2, 3), sol.get(39));
        assertEquals(new Fraction(9, 13), sol.get(40));
        assertEquals(new Fraction(7, 10), sol.get(41));
        assertEquals(new Fraction(5, 7), sol.get(42));
        assertEquals(new Fraction(8, 11), sol.get(43));
        assertEquals(new Fraction(3, 4), sol.get(44));
        assertEquals(new Fraction(10, 13), sol.get(45));
        assertEquals(new Fraction(7, 9), sol.get(46));
        assertEquals(new Fraction(4, 5), sol.get(47));
        assertEquals(new Fraction(9, 11), sol.get(48));
        assertEquals(new Fraction(5, 6), sol.get(49));
        assertEquals(new Fraction(11, 13), sol.get(50));
        assertEquals(new Fraction(6, 7), sol.get(51));
        assertEquals(new Fraction(7, 8), sol.get(52));
        assertEquals(new Fraction(8, 9), sol.get(53));
        assertEquals(new Fraction(9, 10), sol.get(54));
        assertEquals(new Fraction(10, 11), sol.get(55));
        assertEquals(new Fraction(11, 12), sol.get(56));
        assertEquals(new Fraction(12, 13), sol.get(57));
        assertEquals(new Fraction(1, 1), sol.get(58));
   }

   public void testFaryGetApproximationLeftOnly07()
   {
        assertEquals("getApproximation(0.7805, new Fraction(7, 9), new Fraction(4, 5))", new Fraction(25, 32),
                                     FareySequence.getApproximation(0.7805, new Fraction(7, 9), new Fraction(4, 5)));

        assertEquals("getApproximation(0.0768, new Fraction(0, 1), new Fraction(1, 6))", new Fraction(1, 13),
                                     FareySequence.getApproximation(0.0768, new Fraction(0, 1), new Fraction(1, 6)));
   }

   public void testFaryGetApproximationRightOnly08()
   {
        assertEquals("getApproximation(0.85366, new Fraction(11, 13), new Fraction(6, 7))", new Fraction(29, 34),
                                     FareySequence.getApproximation(0.85366, new Fraction(11, 13), new Fraction(6, 7)));

        assertEquals("getApproximation(0.933334, new Fraction(10, 11), new Fraction(1, 1))", new Fraction(14, 15),
                                     FareySequence.getApproximation(0.933334, new Fraction(10, 11), new Fraction(1, 1)));
   }

   public void testFaryGetApproximationBothDirections09()
   {
        assertEquals("getApproximation(0.43755, new Fraction(0, 1), new Fraction(1, 1))", new Fraction(7, 16),
                                     FareySequence.getApproximation(0.43755, new Fraction(0, 1), new Fraction(1, 1)));

        assertEquals("getApproximation(0.72093, new Fraction(2, 3), new Fraction(3, 4))", new Fraction(18, 25),
                                     FareySequence.getApproximation(0.72093, new Fraction(2, 3), new Fraction(3, 4)));
   }


   public void testFarySequenceAndApproximation10()
   {
        testFaryGetApproximationBothDirections09();

        testFarySequenceGetOrder05();
   }

   
   public void testSemiPerfect01()
   {
       int[] divs = SemiPerfect.getDivisors(6);
       assertEquals(3, divs.length);
       assertEquals(1, divs[0]);
       assertEquals(2, divs[1]);
       assertEquals(3, divs[2]);

       assertEquals("9 is semiperfect", true, SemiPerfect.isSemiPerfect(6));
       assertEquals("96 is semiperfect", true, SemiPerfect.isSemiPerfect(96));
       assertEquals("106 is not semiperfect", false, SemiPerfect.isSemiPerfect(106));
       assertEquals("945 is not semiperfect", true, SemiPerfect.isSemiPerfect(945));
   }

   public void testGetDivisor02()
   {
       int[] divs = SemiPerfect.getDivisors(2 * 5 * 11 * 13);
       assertEquals(15, divs.length);
       assertEquals(1, divs[0]);
       assertEquals(2, divs[1]);
       assertEquals(5, divs[2]);
       assertEquals(10, divs[3]);
       assertEquals(11, divs[4]);
       assertEquals(13, divs[5]);
       assertEquals(22, divs[6]);
       assertEquals(26, divs[7]);
       assertEquals(55, divs[8]);
       assertEquals(65, divs[9]);
       assertEquals(2*5*11, divs[10]);
       assertEquals(2*5*13, divs[11]);
       assertEquals(11*13, divs[12]);
       assertEquals(2*11*13, divs[13]);
       assertEquals(5*11*13, divs[14]);
   }

   public void testGetDivisor03()
   {
       int[] divs = SemiPerfect.getDivisors(2 * 2 * 11 * 11 * 13);
       assertEquals(17,divs.length);
       assertEquals(1, divs[0]);
       assertEquals(2, divs[1]);
       assertEquals(4, divs[2]);
       assertEquals(11, divs[3]);
       assertEquals(13, divs[4]);
       assertEquals(22, divs[5]);
       assertEquals(26, divs[6]);
       assertEquals(44, divs[7]);
       assertEquals(52, divs[8]);
       assertEquals(121, divs[9]);
       assertEquals(143, divs[10]);
       assertEquals(242, divs[11]);
       assertEquals(286, divs[12]);
       assertEquals(484, divs[13]);
       assertEquals(572, divs[14]);
       assertEquals(1573, divs[15]);
       assertEquals(2*121*13, divs[16]);
   }

   public void testSemiPerfectLessThan250_04()
   {
       assertEquals("104 is semiperfect", true, SemiPerfect.isSemiPerfect(104));
       assertEquals("198 is semiperfect", true, SemiPerfect.isSemiPerfect(198));
       assertEquals("220 is semiperfect", true, SemiPerfect.isSemiPerfect(220));
       assertEquals("246 is semiperfect", true, SemiPerfect.isSemiPerfect(246));

       assertEquals("86 is NOT semiperfect", false, SemiPerfect.isSemiPerfect(86));
       assertEquals("128 is NOT semiperfect", false, SemiPerfect.isSemiPerfect(128));
       assertEquals("166 is NOT semiperfect", false, SemiPerfect.isSemiPerfect(166));
   }

   public void testSemiPerfect250To500_05()
   {
       assertEquals("264 is semiperfect", true, SemiPerfect.isSemiPerfect(264));
       assertEquals("372 is semiperfect", true, SemiPerfect.isSemiPerfect(372));
       assertEquals("460 is semiperfect", true, SemiPerfect.isSemiPerfect(460));

       assertEquals("266 is NOT semiperfect", false, SemiPerfect.isSemiPerfect(266));
       assertEquals("488 is NOT semiperfect", false, SemiPerfect.isSemiPerfect(488));
   }

   public void testSemiPerfect501To750_06()
   {
       assertEquals("544 is semiperfect", true, SemiPerfect.isSemiPerfect(544));
       assertEquals("732 is semiperfect", true, SemiPerfect.isSemiPerfect(732));

       assertEquals("526 is NOT semiperfect", false, SemiPerfect.isSemiPerfect(526));
       assertEquals("698 is NOT semiperfect", false, SemiPerfect.isSemiPerfect(698));
   }

   public void testSemiPerfect1000To1500_07()
   {
       assertEquals("1020 is semiperfect", true, SemiPerfect.isSemiPerfect(1020));
       assertEquals("1484 is semiperfect", true, SemiPerfect.isSemiPerfect(1484));

       assertEquals("1108 is NOT semiperfect", false, SemiPerfect.isSemiPerfect(1108));
       assertEquals("1388 is NOT semiperfect", false, SemiPerfect.isSemiPerfect(1388));
   }

   public void testSemiPerfect1500To1750_08()
   {
       assertEquals("1590 is semiperfect", true, SemiPerfect.isSemiPerfect(1590));
       assertEquals("1722 is semiperfect", true, SemiPerfect.isSemiPerfect(1722));

       assertEquals("1508 is NOT semiperfect", false, SemiPerfect.isSemiPerfect(1508));
       assertEquals("1724 is NOT semiperfect", false, SemiPerfect.isSemiPerfect(1724));
   }

   public void testGetDivisorAndSemiPerfect_09()
   {
       int[] divs = SemiPerfect.getDivisors(11*23*97);
       assertEquals(7, divs.length);
       assertEquals(1, divs[0]);
       assertEquals(11, divs[1]);
       assertEquals(23, divs[2]);
       assertEquals(97, divs[3]);
       assertEquals(11*23, divs[4]);
       assertEquals(11*97, divs[5]);
       assertEquals(23*97, divs[6]);

       assertEquals("630 is semiperfect", true, SemiPerfect.isSemiPerfect(630));
       assertEquals("800 is semiperfect", true, SemiPerfect.isSemiPerfect(800));

       assertEquals("626 is NOT semiperfect", false, SemiPerfect.isSemiPerfect(626));
       assertEquals("890 is NOT semiperfect", false, SemiPerfect.isSemiPerfect(890));
   }

   public void testGetDivisorAndSemiPerfect_10()
   {
       int[] divs = SemiPerfect.getDivisors(11*23*97);
       assertEquals(7, divs.length);
       assertEquals(1, divs[0]);
       assertEquals(11, divs[1]);
       assertEquals(23, divs[2]);
       assertEquals(97, divs[3]);
       assertEquals(11*23, divs[4]);
       assertEquals(11*97, divs[5]);
       assertEquals(23*97, divs[6]);

       assertEquals("624 is semiperfect", true, SemiPerfect.isSemiPerfect(624));
       assertEquals("704 is semiperfect", true, SemiPerfect.isSemiPerfect(704));

       assertEquals("658 is NOT semiperfect", false, SemiPerfect.isSemiPerfect(658));
       assertEquals("956 is NOT semiperfect", false, SemiPerfect.isSemiPerfect(956));
   }
   
   private Player bryant = new Player("Bryant", 14, 49, 10, 4, 6, 1, 3, 2, 5, 15, 41);
    private Player james = new Player("James",  19, 52,  9, 3, 7, 2, 2, 3, 4, 17, 43);
    private Player harden = new Player("Harden",  17, 40,  8, 3, 3, 4, 1, 1, 3, 16, 39);
    private Player durant = new Player("Durant",  13, 45, 10, 4, 7, 2, 3, 3, 4, 14, 38);
    private Player leonard = new Player("Leonard", 10, 42,  9, 5, 9, 1, 4, 4, 2, 13, 27);
    private Player curry = new Player("Curry", 21, 55, 15, 7, 8, 0, 1, 1, 4, 17, 37);

    public void testAwards01()
    {
        assertEquals(14+2*49+3*10, bryant.getPointsScored());
        assertEquals(3*6+5*1, bryant.getReboundEfficiency());
        assertEquals(4+3+15-2-5, bryant.getBallControlEfficiency());
        assertEquals( 2 * ((14+2*49+3*10) + (3*6+5*1) + (4+3+15-2-5))
            - Math.max((14+2*49+3*10), Math.max(3*6+5*1, (4+3+15-2-5)))
            - Math.min((14+2*49+3*10), Math.min(3*6+5*1, (4+3+15-2-5))), bryant.getMVPrating());
        assertEquals( 6, bryant.getAssistToTurnoverMargin());
        assertEquals(14+2*49+3*10 + (3*6+5*1) - 41 * 2 , bryant.getValueRatio());

        List<Player> ps = new ArrayList<Player>();
        ps.add(bryant);
        ps.add(james);
        ps.add(harden);
        ps.add(durant);
        ps.add(leonard);
        ps.add(curry);

        Awards aw = new Awards(ps);
        assertEquals( curry, aw.getMVP());
        assertEquals( james, aw.getOffensivePlayer());
        assertEquals( harden, aw.getDefensivePlayer());
        assertEquals( bryant, aw.getMostEffective());
    }

    /*
    assertEquals( 244 , curry.getMVPrating());
    assertEquals( 201 , leonard.getMVPrating());
    assertEquals( 209 , durant.getMVPrating());
    assertEquals( 195 , harden.getMVPrating());
    assertEquals( 227 , james.getMVPrating());

    assertEquals(176, curry.getPointsScored());
    assertEquals(150, james.getPointsScored());

    assertEquals(83, bryant.getValueRatio());
    assertEquals(52, james.getValueRatio());
    assertEquals(111, harden.getValueRatio());
    assertEquals(50, durant.getValueRatio());
    assertEquals(45, leonard.getValueRatio());
    assertEquals(163, curry.getValueRatio());
     */

    public void testGetPointsScored02()
    {
        Player p1 = new Player("p1", 2, 100, 0, 4, 6, 1, 3, 2, 5, 15, 41);
        assertEquals(202, p1.getPointsScored());
        p1 = new Player("p1", 0, 10, 11, 4, 6, 1, 3, 2, 5, 15, 41);
        assertEquals(53, p1.getPointsScored());
        p1 = new Player("p1", 21, 0, 11, 4, 6, 1, 3, 2, 5, 15, 41);
        assertEquals(54, p1.getPointsScored());
    }

    public void testGetReboundEfficiency03()
    {
        Player p1 = new Player("p1", 2, 100, 0, 4, 0, 7, 3, 2, 5, 15, 41);
        assertEquals(35, p1.getReboundEfficiency());
        p1 = new Player("p1", 2, 100, 0, 4, 11, 0, 3, 2, 5, 15, 41);
        assertEquals(33, p1.getReboundEfficiency());
        p1 = new Player("p1", 2, 100, 0, 4, 11, 9, 3, 2, 5, 15, 41);
        assertEquals(78, p1.getReboundEfficiency());
    }

    public void testGetBallControlEfficiency04()
    {
        Player p1 = new Player("p1", 2, 100, 0, 14, 0, 7, 8, 4, 7, 18, 41);
        assertEquals(14+8+18-4-7, p1.getBallControlEfficiency());
        p1 = new Player("p1", 2, 100, 0, 0, 0, 7, 3, 4, 11, 8, 41);
        assertEquals(0+3+8-4-11, p1.getBallControlEfficiency());
    }

    public void testGetMVPrating05()
    {
        Player p1 = new Player("p1", 2, 100, 0, 4, 0, 7, 3, 2, 5, 15, 41);
        assertEquals(287, p1.getMVPrating());
        p1 = new Player("p1", 21, 10, 1, 14, 10, 17, 28, 4, 2, 18, 41);
        assertEquals(267, p1.getMVPrating());
        p1 = new Player("p1", 12, 25, 0, 1, 11, 20, 3, 2, 5, 8, 41);
        assertEquals(262, p1.getMVPrating());
        p1 = new Player("p1", 2, 4, 2, 4, 2, 2, 3, 7, 1, 15, 41);
        assertEquals(16+16+14+16, p1.getMVPrating());
        p1 = new Player("p1", 12, 4, 2, 6, 2, 2, 3, 7, 1, 15, 41);
        assertEquals(26+16+16+16, p1.getMVPrating());
    }

    public void testGetAssistToTurnoverMargin06()
    {
        Player p1 = new Player("p1", 0, 0, 0, 14, 0, 0, 3, 12, 5, 15, 41);
        assertEquals(16, p1.getAssistToTurnoverMargin());
        p1 = new Player("p1", 0, 0, 0, 4, 0, 0, 2, 14, 12, 8, 1);
        assertEquals(-6, p1.getAssistToTurnoverMargin());
        p1 = new Player("p1", 12, 25, 0, 11, 11, 20, 0, 0, 5, 8, 41);
        assertEquals(22, p1.getAssistToTurnoverMargin());
    }

    public void testGetValueRatio07()
    {
        Player p1 = new Player("p1", 1, 2, 3, 99, 5, 6, 3, 12, 5, 15, 4);
        assertEquals(11, p1.getValueRatio());
        p1 = new Player("p1", 0, 0, 0, 0, 0, 0, 0, 14, 12, 8, 2);
        assertEquals(-28, p1.getValueRatio());
        p1 = new Player("p1", 12, 25, 0, 11, 11, 20, 0, 0, 5, 8, 41);
        assertEquals(195, p1.getValueRatio());
    }

    public void testGetMVP_highestRating08()
    {
        Player p1 = new Player("p1", 14, 49, 10, 4, 6, 1, 3, 2, 5, 15, 41);
        Player p2 = new Player("p2", 19, 52,  9, 3, 7, 2, 2, 3, 4, 17, 43);
        Player p3 = new Player("p3", 17, 40,  8, 3, 3, 4, 1, 1, 3, 16, 39);
        Player p4 = new Player("p4", 13, 45, 10, 4, 7, 2, 3, 3, 4, 14, 38);
        Player p5 = new Player("p5", 10, 42,  9, 5, 9, 1, 4, 4, 2, 13, 27);

        List<Player> ps = new ArrayList<Player>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);
        ps.add(p5);

        Awards aw = new Awards(ps);
        assertEquals( p2, aw.getMVP());

        Player p6 = new Player("p6", 21, 55, 15, 7, 6, 0, 1, 1, 4, 17, 37);
        ps.add(p6);
        aw = new Awards(ps);
        assertEquals( p6, aw.getMVP());
    }

    public void testGetMVP_MinSalary09()
    {
        Player p1 = new Player("p1", 13, 47, 11, 4, 6, 1, 3, 2, 5, 15, 41);
        Player p2 = new Player("p2", 13, 48,  9, 3, 7, 2, 2, 7, 9, 14, 43);
        Player p3 = new Player("p3", 17, 40,  8, 3, 3, 4, 1, 1, 3, 16, 39);
        Player p4 = new Player("p4", 15, 44, 10, 7, 6, 2, 3, 3, 4,  9, 38);
        Player p5 = new Player("p5",  9, 42,  9, 5, 9, 1, 4, 3, 2, 13, 27);
        //         assertEquals(201, p1.getMVPrating());
        //         assertEquals(201, p2.getMVPrating());
        //         assertEquals(195, p3.getMVPrating());
        //         assertEquals(201, p4.getMVPrating());
        //         assertEquals(201, p5.getMVPrating());

        List<Player> ps = new ArrayList<Player>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);
        ps.add(p5);

        Awards aw = new Awards(ps);
        assertEquals( p5, aw.getMVP());

        Player p6 = new Player("p6", 17, 37,  8, 13, 3, 4, 1, 1, 1, 16, 19);
        assertEquals(201, p6.getMVPrating());
        ps.add(p6);
        aw = new Awards(ps);
        assertEquals( p6, aw.getMVP());
    }

    public void testGetOffensivePlayerMostPoints10()
    {
        Player p1 = new Player("p1", 14, 47, 11, 4, 6, 1, 3, 2, 5, 15, 41);
        Player p2 = new Player("p2", 13, 48,  9, 3, 7, 2, 2, 7, 9, 14, 43);
        Player p3 = new Player("p3", 17, 40,  8, 3, 3, 4, 1, 1, 3, 16, 39);
        Player p4 = new Player("p4", 15, 44, 10, 7, 6, 2, 3, 3, 4,  9, 38);
        Player p5 = new Player("p5",  9, 42,  9, 5, 9, 1, 4, 3, 2, 13, 27);
        assertEquals(202, p1.getMVPrating());
        assertEquals(201, p2.getMVPrating());
        assertEquals(195, p3.getMVPrating());
        assertEquals(201, p4.getMVPrating());
        assertEquals(201, p5.getMVPrating());

        assertEquals(141, p1.getPointsScored());
        assertEquals(136, p2.getPointsScored());
        assertEquals(121, p3.getPointsScored());
        assertEquals(133, p4.getPointsScored());
        assertEquals(120, p5.getPointsScored());

        List<Player> ps = new ArrayList<Player>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);
        ps.add(p5);

        Awards aw = new Awards(ps);
        assertEquals( p2, aw.getOffensivePlayer());

        Player p6 = new Player("p6", 17, 37,  8, 15, 4, 3, 2, 1, 1, 16, 19);
        assertEquals(115, p6.getPointsScored());
        assertEquals(204, p6.getMVPrating());
        ps.add(p6);
        aw = new Awards(ps);
        assertEquals( p1, aw.getOffensivePlayer());

        Player p7 = new Player("p7", 17, 47,  10, 13, 3, 4, 1, 1, 1, 16, 19);
        assertEquals(141, p7.getPointsScored());
        assertEquals( 227, p7.getMVPrating());
        ps.add(p7);
        aw = new Awards(ps);
        assertEquals( p1, aw.getOffensivePlayer());
    }

    public void testGetOffensivePlayerAssistTurnoverRatio11()
    {
        Player p1 = new Player("p1", 14, 47, 14, 4, 6, 1, 3, 2, 5, 15, 41);
        Player p2 = new Player("p2", 13, 48,  9, 3, 7, 2, 2, 7, 9, 14, 43);
        Player p3 = new Player("p3", 17, 40,  8, 3, 3, 4, 1, 1, 3, 16, 39);
        Player p4 = new Player("p4", 15, 44, 11, 7, 6, 2, 3, 3, 4,  9, 38);
        Player p5 = new Player("p5",  9, 42,  9, 5, 9, 1, 4, 3, 2, 13, 27);
        assertEquals(211, p1.getMVPrating());
        assertEquals(201, p2.getMVPrating());
        assertEquals(195, p3.getMVPrating());
        assertEquals(204, p4.getMVPrating());
        assertEquals(201, p5.getMVPrating());

        assertEquals(150, p1.getPointsScored());
        assertEquals(136, p2.getPointsScored());
        assertEquals(121, p3.getPointsScored());
        assertEquals(136, p4.getPointsScored());
        assertEquals(120, p5.getPointsScored());

        assertEquals(6, p1.getAssistToTurnoverMargin());
        assertEquals(-1, p2.getAssistToTurnoverMargin());
        assertEquals(5, p3.getAssistToTurnoverMargin());
        assertEquals(11, p4.getAssistToTurnoverMargin());
        assertEquals(7, p5.getAssistToTurnoverMargin());

        List<Player> ps = new ArrayList<Player>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);
        ps.add(p5);

        Awards aw = new Awards(ps);
        assertEquals( p4, aw.getOffensivePlayer());

        Player p6 = new Player("p6", 17, 37, 15, 15, 4, 3, 2, 1, 1, 16, 19);
        assertEquals(136, p6.getPointsScored());
        assertEquals(225, p6.getMVPrating());
        ps.add(p6);
        aw = new Awards(ps);
        assertEquals( p1, aw.getOffensivePlayer());

        Player p7 = new Player("p7", 28, 46,  10, 13, 3, 4, 1, 1, 1, 0, 19);
        assertEquals(150, p7.getPointsScored());
        assertEquals( 220, p7.getMVPrating());
        assertEquals(25, p7.getAssistToTurnoverMargin());
        ps.add(p7);
        aw = new Awards(ps);
        assertEquals( p7, aw.getOffensivePlayer());
    }

    public void testGetDefensivePlayerMostSteals12()
    {
        Player p1 = new Player("p1", 14, 47, 14, 4, 6, 1, 3, 2, 5, 15, 41);
        Player p2 = new Player("p2", 13, 48,  9, 3, 7, 2, 2, 7, 9, 14, 43);
        Player p3 = new Player("p3", 17, 40,  8, 3, 3, 4, 1, 1, 3, 16, 39);
        Player p4 = new Player("p4", 15, 44, 11, 7, 6, 2, 3, 3, 4,  9, 38);
        Player p5 = new Player("p5",  9, 42,  9, 5, 9, 1, 4, 3, 2, 13, 27);
        Player p6 = new Player("p6", 11, 43, 12, 5, 7, 5, 4, 3, 2, 13, 27);
        assertEquals(211, p1.getMVPrating());
        assertEquals(201, p2.getMVPrating());
        assertEquals(195, p3.getMVPrating());
        assertEquals(204, p4.getMVPrating());
        assertEquals(201, p5.getMVPrating());
        assertEquals(242, p6.getMVPrating());

        assertEquals(150, p1.getPointsScored());
        assertEquals(136, p2.getPointsScored());
        assertEquals(121, p3.getPointsScored());
        assertEquals(136, p4.getPointsScored());
        assertEquals(120, p5.getPointsScored());
        assertEquals(133, p6.getPointsScored());

        List<Player> ps = new ArrayList<Player>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);
        ps.add(p5);
        ps.add(p6);

        Awards aw = new Awards(ps);
        assertEquals( p3, aw.getDefensivePlayer());
        p2 = new Player("p2", 13, 48,  9, 3, 7, 2, 2, 7, 9, 23, 43);
        assertEquals(210, p2.getMVPrating());
        ps.set(1, p2);
        assertEquals( p3, aw.getDefensivePlayer());

        aw = new Awards(ps);
        assertEquals( p2, aw.getDefensivePlayer());

        ps.set(0, p2);
        ps.set(1, p1);
        aw = new Awards(ps);
        assertEquals( p2, aw.getDefensivePlayer());

        ps.set(0, p5);
        ps.set(5, p2);
        aw = new Awards(ps);
        assertEquals( p2, aw.getDefensivePlayer());
    }

    public void testGetDefensivePlayerFewestFouls13()
    {
        Player p1 = new Player("p1", 14, 47, 14, 4, 6, 1, 3, 2, 5, 15, 41);
        Player p2 = new Player("p2", 13, 48,  9, 3, 7, 2, 2, 7, 9, 13, 43);
        Player p3 = new Player("p3", 17, 40,  8, 3, 3, 4, 1, 1, 3, 13, 39);
        Player p4 = new Player("p4", 15, 44, 11, 7, 6, 2, 3, 3, 4,  9, 38);
        Player p5 = new Player("p5",  9, 42,  9, 5, 9, 1, 4, 3, 2, 13, 27);
        Player p6 = new Player("p6", 11, 43, 12, 5, 7, 5, 4, 3, 1, 13, 27);
        assertEquals(211, p1.getMVPrating());
        assertEquals(200, p2.getMVPrating());
        assertEquals(192, p3.getMVPrating());
        assertEquals(204, p4.getMVPrating());
        assertEquals(201, p5.getMVPrating());
        assertEquals(243, p6.getMVPrating());

        assertEquals(150, p1.getPointsScored());
        assertEquals(136, p2.getPointsScored());
        assertEquals(121, p3.getPointsScored());
        assertEquals(136, p4.getPointsScored());
        assertEquals(120, p5.getPointsScored());
        assertEquals(133, p6.getPointsScored());

        List<Player> ps = new ArrayList<Player>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);
        ps.add(p5);
        ps.add(p6);

        Awards aw = new Awards(ps);
        assertEquals( p5, aw.getDefensivePlayer());

        ps.set(2, p5);
        ps.set(4, p3);
        aw = new Awards(ps);
        assertEquals( p5, aw.getDefensivePlayer());

        ps.set(0, p5);
        ps.set(2, p1);
        aw = new Awards(ps);
        assertEquals( p5, aw.getDefensivePlayer());

        p3 = new Player("p3", 17, 40,  8, 3, 3, 4, 1, 1, 1, 13, 39);
        ps.set(4, p3);
        aw = new Awards(ps);
        assertEquals(194, p3.getMVPrating());
        assertEquals(121, p3.getPointsScored());
        assertEquals( p3, aw.getDefensivePlayer());
    }

    public void testGetMostEffectiveHighestValueRatio14()
    {
        Player p1 = new Player("p1", 14, 47, 14, 4, 6, 1, 3, 2, 5, 15, 41);
        Player p2 = new Player("p2", 13, 48,  9, 3, 7, 2, 2, 7, 9, 12, 43);
        Player p3 = new Player("p3", 17, 40,  8, 3, 3, 4, 1, 1, 3, 13, 39);
        Player p4 = new Player("p4", 15, 44, 11, 7, 6, 2, 3, 3, 4,  9, 38);
        Player p5 = new Player("p5",  9, 42,  9, 5, 9, 1, 4, 3, 2, 14, 27);
        Player p6 = new Player("p6", 11, 43, 12, 5, 7, 5, 4, 3, 1, 13, 27);
        Player p7 = new Player("p7", 10, 45,  9, 8, 3, 4, 1, 2, 5, 11, 27);
        assertEquals(211, p1.getMVPrating());
        assertEquals(199, p2.getMVPrating());
        assertEquals(192, p3.getMVPrating());
        assertEquals(204, p4.getMVPrating());
        assertEquals(202, p5.getMVPrating());
        assertEquals(243, p6.getMVPrating());
        assertEquals(198, p7.getMVPrating());

        assertEquals(150, p1.getPointsScored());
        assertEquals(136, p2.getPointsScored());
        assertEquals(121, p3.getPointsScored());
        assertEquals(136, p4.getPointsScored());
        assertEquals(120, p5.getPointsScored());
        assertEquals(133, p6.getPointsScored());
        assertEquals(127, p7.getPointsScored());

        assertEquals(91, p1.getValueRatio());
        assertEquals(-134, p2.getValueRatio());
        assertEquals(111, p3.getValueRatio());
        assertEquals(50, p4.getValueRatio());
        assertEquals(71, p5.getValueRatio());
        assertEquals(98, p6.getValueRatio());
        assertEquals(102, p7.getValueRatio());

        List<Player> ps = new ArrayList<Player>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);
        ps.add(p5);
        ps.add(p6);

        Awards aw = new Awards(ps);
        assertEquals( p3, aw.getMostEffective());

        ps.set(2, p5);
        ps.set(4, p3);
        aw = new Awards(ps);
        assertEquals( p3, aw.getMostEffective());

        p3 = new Player("p3", 17, 40,  8, 3, 3, 4, 1, 1, 1, 13, 39);
        assertEquals(111, p3.getValueRatio());
        ps.set(4, p3);
        aw = new Awards(ps);
        assertEquals(194, p3.getMVPrating());
        assertEquals(121, p3.getPointsScored());
        assertEquals( p3, aw.getMostEffective());
        assertEquals( p3, aw.getMostEffective());
    }

    public void testGetMostEffectiveMostFreeThrowsMade15()
    {
        Player p1 = new Player("p1", 14, 47, 14, 4, 6, 1, 3, 2, 5, 15, 41);
        Player p2 = new Player("p2", 13, 48,  9, 3, 7, 2, 2, 7, 9, 12, 43);
        Player p3 = new Player("p3", 10, 42,  9, 3, 3, 4, 1, 1, 3, 13, 39);
        Player p4 = new Player("p4", 15, 44, 11, 7, 6, 2, 3, 3, 4,  9, 38);
        Player p5 = new Player("p5",  9, 42,  9, 5, 9, 1, 4, 3, 2, 14, 27);
        Player p6 = new Player("p6", 11, 43, 12, 5, 7, 5, 4, 3, 1, 13, 27);
        Player p7 = new Player("p7", 13, 45,  8, 8, 6, 4, 1, 2, 5, 11, 27);
        assertEquals(211, p1.getMVPrating());
        assertEquals(199, p2.getMVPrating());
        assertEquals(192, p3.getMVPrating());
        assertEquals(204, p4.getMVPrating());
        assertEquals(202, p5.getMVPrating());
        assertEquals(243, p6.getMVPrating());
        assertEquals(216, p7.getMVPrating());

        assertEquals(150, p1.getPointsScored());
        assertEquals(136, p2.getPointsScored());
        assertEquals(121, p3.getPointsScored());
        assertEquals(136, p4.getPointsScored());
        assertEquals(120, p5.getPointsScored());
        assertEquals(133, p6.getPointsScored());
        assertEquals(127, p7.getPointsScored());

        assertEquals(91, p1.getValueRatio());
        assertEquals(-134, p2.getValueRatio());
        assertEquals(111, p3.getValueRatio());
        assertEquals(50, p4.getValueRatio());
        assertEquals(71, p5.getValueRatio());
        assertEquals(98, p6.getValueRatio());
        assertEquals(111, p7.getValueRatio());

        List<Player> ps = new ArrayList<Player>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);
        ps.add(p5);
        ps.add(p6);
        ps.add(p7);

        Awards aw = new Awards(ps);
        assertEquals( p7, aw.getMostEffective());

        ps.set(6, p3);
        ps.set(4, p7);
        aw = new Awards(ps);
        assertEquals( p7, aw.getMostEffective());

        p3 = new Player("p3", 14, 40,  9, 3, 3, 4, 1, 1, 3, 13, 39);
        assertEquals(111, p3.getValueRatio());
        ps.set(6, p3);
        aw = new Awards(ps);
        assertEquals(192, p3.getMVPrating());
        assertEquals(121, p3.getPointsScored());
        assertEquals( p3, aw.getMostEffective());
        assertEquals( p3, aw.getMostEffective());
    }
    
    public void testDoubleMinded01()
    {
        assertEquals(true, DoubleMindedNumbers.isDoubleMindedNumber(112034));
        assertEquals(true, DoubleMindedNumbers.isDoubleMindedNumber(26964));
        assertEquals(true, DoubleMindedNumbers.isDoubleMindedNumber(1036850));
        assertEquals(true, DoubleMindedNumbers.isDoubleMindedNumber(66));

        assertEquals(false, DoubleMindedNumbers.isDoubleMindedNumber(8));
        assertEquals(false, DoubleMindedNumbers.isDoubleMindedNumber(2964));
        assertEquals(false, DoubleMindedNumbers.isDoubleMindedNumber(1003650));
        assertEquals(false, DoubleMindedNumbers.isDoubleMindedNumber(16861));

        assertEquals("8 to 11 is 3", 3, DoubleMindedNumbers.distanceToNextDoubleMindedNumber(8));
        assertEquals("295 to 299 is 4", 4, DoubleMindedNumbers.distanceToNextDoubleMindedNumber(295));
        assertEquals("66 to 66 is 0", 0, DoubleMindedNumbers.distanceToNextDoubleMindedNumber(66));
        assertEquals("111261 to 112034 is 773", 773, DoubleMindedNumbers.distanceToNextDoubleMindedNumber(111261));

        int[] ans = DoubleMindedNumbers.getDoubleMindedBetween(34, 65);
        assertEquals("min = 34 to max = 65", 2, ans.length);
        int num = 44;
        assertEquals(""+num, true, ans[0] == num || ans[1] == num);
        num = 55;
        assertEquals(""+num, true, ans[0] == num || ans[1] == num);

        ans = DoubleMindedNumbers.getDoubleMindedBetween(121, 131);
        assertEquals("min = 121 to max = 131", 3, ans.length);
        assertEquals("121 is missing", true, ans[0] == 121 || ans[1] == 121 || ans[2] == 121);
        assertEquals("122 is missing", true, ans[0] == 122 || ans[1] == 122 || ans[2] == 122);
        assertEquals("131 is missing", true, ans[0] == 131 || ans[1] == 131 || ans[2] == 131);
    }

    public void testIsDoubleMindedNumber02()
    {
        assertEquals("66", true, DoubleMindedNumbers.isDoubleMindedNumber(66));
        assertEquals("909", true, DoubleMindedNumbers.isDoubleMindedNumber(909));
        assertEquals("100", true, DoubleMindedNumbers.isDoubleMindedNumber(100));
        assertEquals("533", true, DoubleMindedNumbers.isDoubleMindedNumber(533));

        assertEquals("9", false, DoubleMindedNumbers.isDoubleMindedNumber(8));
        assertEquals("98", false, DoubleMindedNumbers.isDoubleMindedNumber(98));
        assertEquals("111", false, DoubleMindedNumbers.isDoubleMindedNumber(111));
        assertEquals("1144", false, DoubleMindedNumbers.isDoubleMindedNumber(1144));
        assertEquals("7557", false, DoubleMindedNumbers.isDoubleMindedNumber(7557));
        assertEquals("2727", false, DoubleMindedNumbers.isDoubleMindedNumber(2727));
    }

    public void testIsDoubleMindedNumber03()
    {
        assertEquals("123456781", true, DoubleMindedNumbers.isDoubleMindedNumber(123456781));
        assertEquals("123456728", true, DoubleMindedNumbers.isDoubleMindedNumber(123456728));
        assertEquals("10235607", true, DoubleMindedNumbers.isDoubleMindedNumber(10235607));
        assertEquals("12345578", true, DoubleMindedNumbers.isDoubleMindedNumber(12345578));

        assertEquals("123465789", false, DoubleMindedNumbers.isDoubleMindedNumber(123465789));
        assertEquals("888888", false, DoubleMindedNumbers.isDoubleMindedNumber(888888));
        assertEquals("7799", false, DoubleMindedNumbers.isDoubleMindedNumber(7799));
        assertEquals("10222040", false, DoubleMindedNumbers.isDoubleMindedNumber(10222040));
        assertEquals("7512357", false, DoubleMindedNumbers.isDoubleMindedNumber(7512357));
        assertEquals("10561230", false, DoubleMindedNumbers.isDoubleMindedNumber(10561230));
    }

    public void testDistanceToNextDoubleMindedNumber04()
    {
        assertEquals("55", 0, DoubleMindedNumbers.distanceToNextDoubleMindedNumber(55));
        assertEquals("100235", 0, DoubleMindedNumbers.distanceToNextDoubleMindedNumber(100235));
        assertEquals("607869", 0, DoubleMindedNumbers.distanceToNextDoubleMindedNumber(607869));
    }

    public void testDistanceToNextDoubleMindedNumber05()
    {
        assertEquals("87", 1, DoubleMindedNumbers.distanceToNextDoubleMindedNumber(87));
        assertEquals("123450", 1, DoubleMindedNumbers.distanceToNextDoubleMindedNumber(123450));
        assertEquals("1133", 1, DoubleMindedNumbers.distanceToNextDoubleMindedNumber(1133));
    }

    public void testDistanceToNextDoubleMindedNumber06()
    {
        assertEquals("11811", 11820-11811, DoubleMindedNumbers.distanceToNextDoubleMindedNumber(11811));
        assertEquals("555178", 556012 - 555178, DoubleMindedNumbers.distanceToNextDoubleMindedNumber(555178));
        assertEquals("696912", 697001 - 696912, DoubleMindedNumbers.distanceToNextDoubleMindedNumber(696912));
    }

    public void testDistanceToNextDoubleMindedNumber07()
    {
        assertEquals("99900", 100234-99900, DoubleMindedNumbers.distanceToNextDoubleMindedNumber(99900));
        assertEquals("5533210", 5534012 - 5533210, DoubleMindedNumbers.distanceToNextDoubleMindedNumber(5533210));
        assertEquals("111000", 112034 - 111000, DoubleMindedNumbers.distanceToNextDoubleMindedNumber(111000));
    }

    public void testGetDoubleMindedBetween08()
    {
        int[] ans = DoubleMindedNumbers.getDoubleMindedBetween(999, 1061);
        assertEquals("min = 999 to max = 1061", 30, ans.length);
        int[] nums = {1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1012, 1013, 1014, 1015, 1016, 1017, 1018, 1019,
                       1030, 1031, 1033, 1040, 1041, 1044, 1050, 1051, 1055, 1060, 1061};
        for (int num : nums)
        {
            boolean hasIt = false;
            for (int a :ans)
               hasIt = hasIt || a == num;
            assertEquals(""+num, true, hasIt);
        }
    }

    public void testGetDoubleMindedBetween09()
    {
        int[] ans = DoubleMindedNumbers.getDoubleMindedBetween(111000, 112200);
        assertEquals("min = 111000 to max = 112200", 42, ans.length);
        int[] nums = {112034, 112035, 112036, 112037, 112038, 112039, 112043, 112045, 112046, 112047, 112048, 112049,
                      112053, 112054, 112056, 112057, 112058, 112059, 112063, 112064, 112065, 112067, 112068, 112069,
                      112073, 112074, 112075, 112076, 112078, 112079, 112083, 112084, 112085, 112086, 112087, 112089,
                      112093, 112094, 112095, 112096, 112097, 112097};
        for (int num : nums)
        {
            boolean hasIt = false;
            for (int a :ans)
               hasIt = hasIt || a == num;
            assertEquals(""+num, true, hasIt);
        }
    }

    public void testGetDoubleMindedbetween10()
    {
        int[] ans = DoubleMindedNumbers.getDoubleMindedBetween(11079, 11201);
        assertEquals("min = 11023 to max = 11201", 15, ans.length);
        int[] nums = {11079, 11082, 11083, 11084, 11085, 11086, 11087, 11089, 11092, 11093, 11094, 11095, 11096, 11097, 11098};
        for (int num : nums)
        {
            boolean hasIt = false;
            for (int a :ans)
               hasIt = hasIt || a == num;
            assertEquals(""+num, true, hasIt);
        }
    }
    
    public void testMIU01()
    {
        MIU_System m = new MIU_System("MI");

        assertEquals("MII", m.doubleAfterM());

        m = new MIU_System("MUIIU");
        assertEquals("MUIIUUIIU", m.doubleAfterM());

        m = new MIU_System("MII");
        assertEquals("MIIU", m.endsWithI());

        m = new MIU_System("MIU");
        assertEquals("MIU", m.endsWithI());

        m = new MIU_System("MIIIUIII");
        assertEquals("MUUIII", m.trade3IsForSingleU());

        m = new MIU_System("MUIUUIUU");
        assertEquals("MUII", m.remove2Us());

        m = new MIU_System("MUUUIUUUU");
        assertEquals("MUI", m.remove2Us());

        m = new MIU_System("MI");
        assertEquals(true, m.isPossible("MII"));

        m = new MIU_System("MUI");
        assertEquals(false, m.isPossible("MII"));

        m = new MIU_System("MI");
        assertEquals(1, m.minNumModifications("MII"));
        assertEquals(3, m.minNumModifications("MUI"));
        assertEquals(2, m.minNumModifications("MIIII"));
        assertEquals(3, m.minNumModifications("MIIIIIIII"));
        assertEquals(4, m.minNumModifications("MUIIIII"));
        assertEquals(5, m.minNumModifications("MUUII"));
        assertEquals(6, m.minNumModifications("MUUIIU"));
        assertEquals(7, m.minNumModifications("MUUIIUUUIIU"));
        assertEquals(3, m.minNumModifications("MIIUIIU"));
    }

    public void testEndsWithI02()
    {
        MIU_System m = new MIU_System("MIIII");
        assertEquals("MIIIIU", m.endsWithI());

        m = new MIU_System("MIIIIU");
        assertEquals("MIIIIU", m.endsWithI());

        m = new MIU_System("MIUIIUI");
        assertEquals("MIUIIUIU", m.endsWithI());

        m = new MIU_System("M");
        assertEquals("M", m.endsWithI());
    }

    public void testDoubleAfterM03()
    {
        MIU_System m = new MIU_System("MIII");
        assertEquals("MIIIIII", m.doubleAfterM());

        m = new MIU_System("MUIIUIIU");
        assertEquals("MUIIUIIUUIIUIIU", m.doubleAfterM());

        m = new MIU_System("M");
        assertEquals("M", m.doubleAfterM());
    }

    public void testTrade3IsForSingleU04()
    {
        MIU_System m = new MIU_System("MIII");
        assertEquals("MU", m.trade3IsForSingleU());

        m = new MIU_System("MUIIIUIIU");
        assertEquals("MUUUIIU", m.trade3IsForSingleU());

        m = new MIU_System("MUIIUIIIUIII");
        assertEquals("MUIIUUUIII", m.trade3IsForSingleU());

        m = new MIU_System("M");
        assertEquals("M", m.trade3IsForSingleU());
    }

    public void testRemove2UsU05()
    {
        MIU_System m = new MIU_System("MUIIIU");
        assertEquals("MUIIIU", m.remove2Us());

        m = new MIU_System("MUUIIIUUIIUU");
        assertEquals("MIIIII", m.remove2Us());

        m = new MIU_System("MUIUIUIUIIUUIII");
        assertEquals("MUIUIUIUIIIII", m.remove2Us());

        m = new MIU_System("M");
        assertEquals("M", m.remove2Us());
    }

    public void testAllModifingMethods06()
    {
        testEndsWithI02();
        testDoubleAfterM03();
        testTrade3IsForSingleU04();
        testRemove2UsU05();
    }

    public void testIsPossible07()
    {
        MIU_System m = new MIU_System("MIUIU");

        assertEquals(true, m.isPossible("MIUIU"));
        assertEquals(true, m.isPossible("MIUIUIUIU"));
        assertEquals(false, m.isPossible("MUU"));
        assertEquals(false, m.isPossible("MI"));

        m = new MIU_System("MIUII");
        assertEquals(true, m.isPossible("MIUII"));
        assertEquals(true, m.isPossible("MIUIIU"));
        assertEquals(false, m.isPossible("MU"));

        m = new MIU_System("MUUIUU");
        assertEquals(true, m.isPossible("MUUIUU"));
        assertEquals(true, m.isPossible("MUUIUUUUIUU"));
        assertEquals(true, m.isPossible("MI"));
        assertEquals(false, m.isPossible("MUUI"));

        m = new MIU_System("MUUIIIUI");
        assertEquals(true, m.isPossible("MUUIIIUIUUIIIUI"));
        assertEquals(true, m.isPossible("MUUUUI"));
        assertEquals(true, m.isPossible("MIIIUI"));
        assertEquals(false, m.isPossible("MUI"));
        assertEquals(false, m.isPossible("MUUUI"));
    }

    public void testMinNumModifications08()
    {
        /*
         *    remember:   max returned value < 10
         */
        MIU_System m = new MIU_System("MIUII");

        assertEquals(0, m.minNumModifications("MIUII"));
        assertEquals(1, m.minNumModifications("MIUIIIUII"));
        assertEquals(1, m.minNumModifications("MIUIIU"));

        assertEquals(2, m.minNumModifications("MIUIIIUIIIUIIIUII"));
        assertEquals(2, m.minNumModifications("MIUUUII"));

        assertEquals(2, m.minNumModifications("MIUIIUIUIIU"));
    }

    public void testMinNumModifications09()
    {
        /*
         *    remember:   max returned value < 10
         */
        MIU_System m = new MIU_System("MIIIU");

        assertEquals(2, m.minNumModifications("M"));

        assertEquals(3, m.minNumModifications("MIIIUIIIUIIIUIIIUIIIUIIIUIIIUIIIU"));
        assertEquals(3, m.minNumModifications("MUUUUUUUU"));

        assertEquals(4, m.minNumModifications("MIIIUIIIUIIIUIIIUIIIUIIIUIIIUIIIUIIIUIIIUIIIUIIIUIIIUIIIUIIIUIIIU"));
        assertEquals(4, m.minNumModifications("MUUUUUUUUUUUUUUUU"));

        m = new MIU_System("MIIUI");
        assertEquals(1, m.minNumModifications("MIIUIIIUI"));
        assertEquals(1, m.minNumModifications("MIIUIU"));
        assertEquals(2, m.minNumModifications("MIIUIIIUIU"));
        assertEquals(2, m.minNumModifications("MIIUIUIIUIU"));
        assertEquals(3, m.minNumModifications("MIIUUUIU"));
        assertEquals(3, m.minNumModifications("MIIUIUIIUIUIIUIUIIUIU"));
        assertEquals(4, m.minNumModifications("MIIUUUIUIIUUUIU"));
        assertEquals(5, m.minNumModifications("MIIUUUIUIIUUUIUIIUUUIUIIUUUIU"));
    }

    public void testMinNumModifications10()
    {
        /*
         *    remember:   max returned value < 10
         */
        MIU_System m = new MIU_System("MUI");
        /*
        assertEquals(0, m.minNumModifications("MUI"));
        assertEquals(1, m.minNumModifications("MUIUI"));
        assertEquals(1, m.minNumModifications("MUIU"));
        assertEquals(2, m.minNumModifications("MUIUIUIUI"));
        assertEquals(2, m.minNumModifications("MUIUUIU"));
        assertEquals(3, m.minNumModifications("MUIUIUIUIUIUIUIUI"));
        assertEquals(3, m.minNumModifications("MUIUUIUUIUUIU"));
        assertEquals(3, m.minNumModifications("MUIIU"));
        assertEquals(4, m.minNumModifications("MUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUI"));
        assertEquals(4, m.minNumModifications("MUIUUIUUIUUIUUIUUIUUIUUIU"));
        assertEquals(4, m.minNumModifications("MUIIIIU"));
        assertEquals(5, m.minNumModifications("MUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUIUI"));
        assertEquals(5, m.minNumModifications("MUIUUIUUIUUIUUIUUIUUIUUIUUIUUIUUIUUIUUIUUIUUIUUIU"));
        assertEquals(5, m.minNumModifications("MUIIIIIIIIU"));
        assertEquals(5, m.minNumModifications("MUUIU"));
        assertEquals(5, m.minNumModifications("MUIIIIUUIIIIU"));
        assertEquals(6, m.minNumModifications("MUIIIIIIIIIIIIIIIIU"));
        assertEquals(6, m.minNumModifications("MUUIIIIIU"));
        assertEquals(6, m.minNumModifications("MUUIUUUIU"));
        assertEquals(6, m.minNumModifications("MIU"));
        assertEquals(6, m.minNumModifications("MUUIUUIIIIU"));
         */
        assertEquals(7, m.minNumModifications("MUUIIIIIIIIIIIIIU"));
        assertEquals(7, m.minNumModifications("MUIIIIIIIIIIIIIIIIUUIIIIIIIIIIIIIIIIU"));
        assertEquals(7, m.minNumModifications("MIIIIIU"));
        assertEquals(7, m.minNumModifications("MUUIIIIIUUUIIIIIU"));
        assertEquals(7, m.minNumModifications("MUUIUUUIUUUIUUUIU"));
        assertEquals(7, m.minNumModifications("MIUIU"));
        assertEquals(7, m.minNumModifications("MIUIU"));
        assertEquals(8, m.minNumModifications("MUUIIIIIUUUIIIIIUUUIIIIIUUUIIIIIU"));
        assertEquals(8, m.minNumModifications("MIUIUIUIU"));
        assertEquals(9, m.minNumModifications("MUUUIIUUUIIIIIUUUIIIIIUUUIIIIIU"));
        assertEquals(9, m.minNumModifications("MIUIUIUIUIUIUIUIU"));
    }
    
    /*
     *   Spectrum:
     *   
     *     true  = light is NOT absorbed
     *     
     *     false = dark band is absorbed
     */
    public void testFraunhoferLines01()
    {
        List<Element> els = new ArrayList<Element>();
        els.add(new Element("H",  new int[] {2, 5, 16} ));
        els.add(new Element("He", new int[] {1, 5, 15} ));
        els.add(new Element("C",  new int[] {1, 13, 19} ));
        els.add(new Element("N",  new int[] {2, 8, 17} ));
        els.add(new Element("O",  new int[] {2, 5, 7} ));
        els.add(new Element("Ne", new int[] {0, 4, 6, 11, 17} ));
        els.add(new Element("Si", new int[] {4, 10, 11} ));
        els.add(new Element("Cl", new int[] {1, 5, 14, 18} ));
        els.add(new Element("Ar", new int[] {0, 3, 9, 12, 17, 18} ));
        els.add(new Element("Zn", new int[] {0, 3, 9, 18, 19} ));
        els.add(new Element("Kr", new int[] {1, 9, 17} ));
        els.add(new Element("Xe", new int[] {0, 3, 9, 11, 18} ));
        els.add(new Element("Ba", new int[] {11, 12, 17} ));

        FraunhoferLines fl = new FraunhoferLines(els);
        //                      0      1      2     3     4     5      6      7     8       9
        boolean[] spectrum = {  true,  true, false, true, false, false, true, false, true, true,
                               false, false,  true, true, true,   true, true,  true, true, true };

        List<Element> ans = fl.getPossibleElements(spectrum);
        assertEquals(2, ans.size());
        assertEquals("contains \"O\"",  true, ans.contains(new Element("O",  new int[] {2, 5, 7} )));
        assertEquals("contains \"Si\"", true, ans.contains(new Element("Si", new int[] {4, 10, 11})));
        assertEquals("does not contain \"Ar\"",  false, ans.contains(new Element("Ar", new int[] {0, 3, 9, 12, 17, 18})));
        assertEquals("does not contain \"Cl\"", false, ans.contains(new Element("Cl", new int[] {1, 5, 14, 18})));

        //                      0      1      2     3     4     5      6      7     8       9
        boolean[] spectrum1 = { false, true, true,  false, true, true,  true, true, true, false,
                                true,  false,  false, true, true, true, true, false, false, false };
                               
        ans = fl.getRequiredElements(spectrum1);
        assertEquals(1, ans.size());
        assertEquals("contains \"Zn\"", true, ans.contains(new Element("Zn", new int[] {0, 3, 9, 18, 19} )));

        boolean[] spectrum2 = {false, true, false, true, true, false, false, false, false, true,     //  H, N  and O
                                true, true,  true, true, true,  true, false, false,  true, true};    //  add bands:  0, 6  &&  14
        List<Integer> bandAns = fl.getMissingBands(spectrum2);                             
        int num = bandAns.size();
        assertEquals(2, num);
        assertEquals("missing band 0", true, bandAns.contains(new Integer(0) ) );
        assertEquals("missing band 6", true, bandAns.contains(new Integer(6) ) );
    }

    public void testGetPossibleElements02()
    {
        List<Element> els = new ArrayList<Element>();
        els.add(new Element("H",  new int[] {2, 5, 16} ));
        els.add(new Element("He", new int[] {1, 5, 15} ));
        els.add(new Element("C",  new int[] {1, 13, 19} ));
        els.add(new Element("N",  new int[] {2, 8, 17} ));
        els.add(new Element("O",  new int[] {2, 5, 7} ));
        els.add(new Element("Ne", new int[] {0, 4, 6, 11, 17} ));
        els.add(new Element("Si", new int[] {4, 10, 11} ));
        els.add(new Element("Cl", new int[] {1, 5, 14, 18} ));
        els.add(new Element("Ar", new int[] {0, 3, 9, 12, 17, 18} ));
        els.add(new Element("Zn", new int[] {0, 3, 9, 18, 19} ));
        els.add(new Element("Kr", new int[] {1, 9, 17} ));
        els.add(new Element("Xe", new int[] {0, 3, 9, 11, 18} ));

        FraunhoferLines fl = new FraunhoferLines(els);
        //                      0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        boolean[] spectrum = {false, true, false, false, false, false, false, true, true, false, false, false, true, true, true, true, false, false, false, true};     //     H,  Ne,   Si,   Xe

        List<Element> ans = fl.getPossibleElements(spectrum);
        assertEquals(4, ans.size());
        assertEquals("contains \"H\"", true, ans.contains(new Element("H",  new int[] {2, 5, 16} ) ));
        assertEquals("contains \"Ne\"", true, ans.contains(new Element("Ne", new int[] {0, 4, 6, 11, 17} ) ));
        assertEquals("contains \"Si\"", true, ans.contains(new Element("Si", new int[] {4, 10, 11} ) ));
        assertEquals("contains \"Xe\"", true, ans.contains(new Element("Xe", new int[] {0, 3, 9, 11, 18} ) ));
    }

    public void testGetPossibleElements03()
    {
        List<Element> els = new ArrayList<Element>();
        els.add(new Element("H",  new int[] {2, 5, 16} ));
        els.add(new Element("He", new int[] {1, 5, 15} ));
        els.add(new Element("C",  new int[] {1, 13, 19} ));
        els.add(new Element("N",  new int[] {2, 8, 17} ));
        els.add(new Element("O",  new int[] {2, 5, 7} ));
        els.add(new Element("Ne", new int[] {0, 4, 6, 11, 17} ));
        els.add(new Element("Si", new int[] {4, 10, 11} ));
        els.add(new Element("Cl", new int[] {1, 5, 14, 18} ));
        els.add(new Element("Ar", new int[] {0, 3, 9, 12, 17, 18} ));
        els.add(new Element("Zn", new int[] {0, 3, 9, 18, 19} ));
        els.add(new Element("Kr", new int[] {1, 9, 17} ));
        els.add(new Element("Xe", new int[] {0, 3, 9, 11, 18} ));

        FraunhoferLines fl = new FraunhoferLines(els);
        //                      0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        boolean[] spectrum = {false, false, false, false, true, false, true, false, true, false, true, true, true, false, true, false, true, true, false, false};     //   He,    C,     O,     Zn

        List<Element> ans = fl.getPossibleElements(spectrum);
        assertEquals(4, ans.size());
        assertEquals("contains \"He\"", true, ans.contains(new Element("He", new int[] {1, 5, 15} ) ));
        assertEquals("contains \"C\"", true, ans.contains(new Element("C",  new int[] {1, 13, 19} )));
        assertEquals("contains \"O\"", true, ans.contains(new Element("O",  new int[] {2, 5, 7} )));
        assertEquals("contains \"Zn\"", true, ans.contains(new Element("Zn", new int[] {0, 3, 9, 18, 19} )));
    }

    public void testGetPossibleElementsWithMissingBands04()
    {
        List<Element> els = new ArrayList<Element>();
        els.add(new Element("H",  new int[] {2, 5, 16} ));
        els.add(new Element("He", new int[] {1, 5, 15} ));
        els.add(new Element("C",  new int[] {1, 13, 19} ));
        els.add(new Element("N",  new int[] {2, 8, 17} ));
        els.add(new Element("O",  new int[] {2, 5, 7} ));
        els.add(new Element("Ne", new int[] {0, 4, 6, 11, 17} ));
        els.add(new Element("Si", new int[] {4, 10, 11} ));
        els.add(new Element("Cl", new int[] {1, 5, 14, 18} ));
        els.add(new Element("Ar", new int[] {0, 3, 9, 12, 17, 18} ));
        els.add(new Element("Zn", new int[] {0, 3, 9, 18, 19} ));
        els.add(new Element("Kr", new int[] {1, 9, 17} ));
        els.add(new Element("Xe", new int[] {0, 3, 9, 11, 18} ));

        FraunhoferLines fl = new FraunhoferLines(els);
        //                      0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        boolean[] spectrum = {false, false, false, false, true, false, false, true, false, false, true, true, false, true, false, true, true, false, false, true};    //  N,   Cl,    Ar,   Kr

        List<Element> ans = fl.getPossibleElements(spectrum);
        assertEquals(4, ans.size());
        assertEquals("contains \"N\"", true, ans.contains(new Element("N",  new int[] {2, 8, 17} )));
        assertEquals("contains \"Cl\"", true, ans.contains(new Element("Cl", new int[] {1, 5, 14, 18})));
        assertEquals("contains \"Ar\"", true, ans.contains(new Element("Ar", new int[] {0, 3, 9, 12, 17, 18})));
        assertEquals("contains \"Kr\"", true, ans.contains(new Element("Kr", new int[] {1, 9, 17} )));
    }

    public void testGetRequiredElements05()
    {
        List<Element> els = new ArrayList<Element>();
        els.add(new Element("H",  new int[] {2, 5, 16} ));
        els.add(new Element("He", new int[] {1, 5, 15} ));
        els.add(new Element("C",  new int[] {1, 13, 19} ));
        els.add(new Element("N",  new int[] {2, 8, 17} ));
        els.add(new Element("O",  new int[] {2, 5, 7} ));
        els.add(new Element("Ne", new int[] {0, 4, 6, 11, 17} ));
        els.add(new Element("Si", new int[] {4, 10, 11} ));
        els.add(new Element("Cl", new int[] {1, 5, 14, 18} ));
        els.add(new Element("Ar", new int[] {0, 3, 9, 12, 17, 18} ));
        els.add(new Element("Zn", new int[] {0, 3, 9, 18, 19} ));
        els.add(new Element("Kr", new int[] {1, 9, 17} ));
        els.add(new Element("Xe", new int[] {0, 3, 9, 11, 18} ));

        FraunhoferLines fl = new FraunhoferLines(els);
        //                      0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        boolean[] spectrum = {false, false, false, false, true, false, true, true, true, false, true, false, true, false, true, true, false, true, false, false};    //  H(16),   Xe,   Zn,   C

        List<Element> ans = fl.getRequiredElements(spectrum);
        assertEquals(3, ans.size());
        assertEquals("contains \"H\"", true, ans.contains(new Element("H",  new int[] {2, 5, 16} )));
        assertEquals("contains \"Xe\"", true, ans.contains(new Element("Xe", new int[] {0, 3, 9, 11, 18} )));
        assertEquals("contains \"C\"", true, ans.contains(new Element("C",  new int[] {1, 13, 19} )));
    }

    public void testGetRequiredElements06()
    {
        List<Element> els = new ArrayList<Element>();
        els.add(new Element("H",  new int[] {2, 5, 16} ));
        els.add(new Element("He", new int[] {1, 5, 15} ));
        els.add(new Element("C",  new int[] {1, 13, 19} ));
        els.add(new Element("N",  new int[] {2, 8, 17} ));
        els.add(new Element("O",  new int[] {2, 5, 7} ));
        els.add(new Element("Ne", new int[] {0, 4, 6, 11, 17} ));
        els.add(new Element("Si", new int[] {4, 10, 11} ));
        els.add(new Element("Cl", new int[] {1, 5, 14, 18} ));
        els.add(new Element("Ar", new int[] {0, 3, 9, 12, 17, 18} ));
        els.add(new Element("Zn", new int[] {0, 3, 9, 18, 19} ));
        els.add(new Element("Kr", new int[] {1, 9, 17} ));
        els.add(new Element("Xe", new int[] {0, 3, 9, 11, 18} ));

        FraunhoferLines fl = new FraunhoferLines(els);
        //                      0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        boolean[] spectrum = {false, false, true, false, true, false, true, true, true, false, true, true, false, true, false, false, true, false, false, true};   //  He,   Cl,  Kr,  Ar

        List<Element> ans = fl.getRequiredElements(spectrum);
        assertEquals(3, ans.size());
        assertEquals("contains \"He\"", true, ans.contains(new Element("He", new int[] {1, 5, 15} )));
        assertEquals("contains \"Cl\"", true, ans.contains(new Element("Cl", new int[] {1, 5, 14, 18})));
        assertEquals("contains \"Ar\"", true, ans.contains(new Element("Ar", new int[] {0, 3, 9, 12, 17, 18})));
    }

    public void testGetRequiredElements07()
    {
        List<Element> els = new ArrayList<Element>();
        els.add(new Element("H",  new int[] {2, 5, 16} ));
        els.add(new Element("He", new int[] {1, 5, 15} ));
        els.add(new Element("C",  new int[] {1, 13, 19} ));
        els.add(new Element("N",  new int[] {2, 8, 17} ));
        els.add(new Element("O",  new int[] {2, 5, 7} ));
        els.add(new Element("Ne", new int[] {0, 4, 6, 11, 17} ));
        els.add(new Element("Si", new int[] {4, 10, 11} ));
        els.add(new Element("Cl", new int[] {1, 5, 14, 18} ));
        els.add(new Element("Ar", new int[] {0, 3, 9, 12, 17, 18} ));
        els.add(new Element("Zn", new int[] {0, 3, 9, 18, 19} ));
        els.add(new Element("Kr", new int[] {1, 9, 17} ));
        els.add(new Element("Xe", new int[] {0, 3, 9, 11, 18} ));

        FraunhoferLines fl = new FraunhoferLines(els);
        //                      0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        boolean[] spectrum = {false, true, false, true, false, false, false, false, false, true, false, false, true, true, true, true, true, false, true, true};   //  N,   O,   Ne,   Si

        List<Element> ans = fl.getRequiredElements(spectrum);
        assertEquals(4, ans.size());
        assertEquals("contains \"N\"", true, ans.contains(new Element("N",  new int[] {2, 8, 17} )));
        assertEquals("contains \"Si\"", true, ans.contains(new Element("Si", new int[] {4, 10, 11})));
        assertEquals("contains \"O\"", true, ans.contains(new Element("O",  new int[] {2, 5, 7} )));
        assertEquals("contains \"Ne\"", true, ans.contains(new Element("Ne", new int[] {0, 4, 6, 11, 17} )));
    }

    public void testGetMissingBands08()
    {
        List<Element> els = new ArrayList<Element>();
        els.add(new Element("H",  new int[] {2, 5, 16} ));
        els.add(new Element("He", new int[] {1, 5, 15} ));
        els.add(new Element("C",  new int[] {1, 13, 19} ));
        els.add(new Element("N",  new int[] {2, 8, 17} ));
        els.add(new Element("O",  new int[] {2, 5, 7} ));
        els.add(new Element("Ne", new int[] {0, 4, 6, 11, 17} ));
        els.add(new Element("Si", new int[] {4, 10, 11} ));
        els.add(new Element("Cl", new int[] {1, 5, 14, 18} ));
        els.add(new Element("Ar", new int[] {0, 3, 9, 12, 17, 18} ));
        els.add(new Element("Zn", new int[] {0, 3, 9, 18, 19} ));
        els.add(new Element("Kr", new int[] {1, 9, 17} ));
        els.add(new Element("Xe", new int[] {0, 3, 9, 11, 18} ));

        FraunhoferLines fl = new FraunhoferLines(els);
        //                      0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        boolean[] spectrum = {false, true, true, false, false, true, true, true, true, false, false, false, true, true, true, true, true, false, false, false};    //   Zn, Si,  Xe  && band 17

        List<Integer> bandAns = fl.getMissingBands(spectrum);
        assertEquals(1, bandAns.size());
        assertEquals("contains one missing band, band 17 missing", new Integer(17), bandAns.get(0));
    }

    public void testGetMissingBands09()
    {
        List<Element> els = new ArrayList<Element>();
        els.add(new Element("H",  new int[] {2, 5, 16} ));
        els.add(new Element("He", new int[] {1, 5, 15} ));
        els.add(new Element("C",  new int[] {1, 13, 19} ));
        els.add(new Element("N",  new int[] {2, 8, 17} ));
        els.add(new Element("O",  new int[] {2, 5, 7} ));
        els.add(new Element("Ne", new int[] {0, 4, 6, 11, 17} ));
        els.add(new Element("Si", new int[] {4, 10, 11} ));
        els.add(new Element("Cl", new int[] {1, 5, 14, 18} ));
        els.add(new Element("Ar", new int[] {0, 3, 9, 12, 17, 18} ));
        els.add(new Element("Zn", new int[] {0, 3, 9, 18, 19} ));
        els.add(new Element("Kr", new int[] {1, 9, 17} ));
        els.add(new Element("Xe", new int[] {0, 3, 9, 11, 18} ));

        FraunhoferLines fl = new FraunhoferLines(els);
        //                      0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        boolean[] spectrum = {true, true, true, true, true, true, false, false, false, true, false, true, false, false, false, false, false, true, true, true};

        List<Integer> bandAns = fl.getMissingBands(spectrum);
        assertEquals(9, bandAns.size());
        assertEquals("band 6 missing", true, bandAns.contains(new Integer(6)));
        assertEquals("band 7 missing", true, bandAns.contains(new Integer(7)));
        assertEquals("band 8 missing", true, bandAns.contains(new Integer(8)));
        assertEquals("band 10 missing", true, bandAns.contains(new Integer(10)));
        assertEquals("band 12 missing", true, bandAns.contains(new Integer(12)));
        assertEquals("band 13 missing", true, bandAns.contains(new Integer(13)));
        assertEquals("band 14 missing", true, bandAns.contains(new Integer(14)));
        assertEquals("band 15 missing", true, bandAns.contains(new Integer(15)));
        assertEquals("band 16 missing", true, bandAns.contains(new Integer(16)));
    }

    public void testGetMissingBands10()
    {
        List<Element> els = new ArrayList<Element>();
        els.add(new Element("H",  new int[] {2, 5, 16} ));
        els.add(new Element("He", new int[] {1, 5, 15} ));
        els.add(new Element("C",  new int[] {1, 13, 19} ));
        els.add(new Element("N",  new int[] {2, 8, 17} ));
        els.add(new Element("O",  new int[] {2, 5, 7} ));
        els.add(new Element("Ne", new int[] {0, 4, 6, 11, 17} ));
        els.add(new Element("Si", new int[] {4, 10, 11} ));
        els.add(new Element("Cl", new int[] {1, 5, 14, 18} ));
        els.add(new Element("Ar", new int[] {0, 3, 9, 12, 17, 18} ));
        els.add(new Element("Zn", new int[] {0, 3, 9, 18, 19} ));
        els.add(new Element("Kr", new int[] {1, 9, 17} ));
        els.add(new Element("Xe", new int[] {0, 3, 9, 11, 18} ));

        FraunhoferLines fl = new FraunhoferLines(els);
        //                      0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        boolean[] spectrum = {false, false, false, false, false, false, false, false, false, true, true, false, true, false, true, false, false, false, false, false};

        List<Integer> bandAns = fl.getMissingBands(spectrum);
        assertEquals(2, bandAns.size());
        assertEquals("band 3 missing", true, bandAns.contains(new Integer(3)));
        assertEquals("band 18 missing", true, bandAns.contains(new Integer(18)));
    }
    
    public void testDiceFromPennies01()
    {
        DiceFromPennies dfp = new DiceFromPennies(6);
        assertEquals(1, dfp.getRoll("HHH"));
        assertEquals(2, dfp.getRoll("HHT"));
        assertEquals(3, dfp.getRoll("HTH"));
        assertEquals(4, dfp.getRoll("HTT"));
        assertEquals(5, dfp.getRoll("THH"));
        assertEquals(6, dfp.getRoll("THT"));
        assertEquals(-1, dfp.getRoll("TTT"));
        assertEquals(1, dfp.getRoll("TTTHHH"));

        dfp = new DiceFromPennies(20);
        assertEquals(18, dfp.getRoll("THHHTHHHHT"));
        assertEquals(6, dfp.getRoll("TTHHTHHTHT"));

        dfp = new DiceFromPennies(2);
        assertEquals(3, dfp.getRolls(2, "HT"));
        assertEquals(7, dfp.getRolls(5, "HTTHHHTHTHTHTHTHT"));

        dfp = new DiceFromPennies(15);

        assertEquals(33, dfp.getRolls(4, "HTTHHHTHTHTHTHTT"));
    }

    public void test2To8SidedDiceFromPennies02()
    {
        DiceFromPennies dfp = new DiceFromPennies(2);
        assertEquals("2 sided HH", 1, dfp.getRoll("HH"));
        assertEquals("2 sided TH", 2, dfp.getRoll("TH"));

        dfp = new DiceFromPennies(3);
        assertEquals("3 sided HH", 1, dfp.getRoll("HH"));
        assertEquals("3 sided TT", -1, dfp.getRoll("TT"));

        dfp = new DiceFromPennies(4);
        assertEquals(2, dfp.getRoll("HT"));
        assertEquals("4 sided TT", 4, dfp.getRoll("TT"));

        dfp = new DiceFromPennies(5);
        assertEquals("5 sided THH", 5, dfp.getRoll("THH"));
        assertEquals("5 sided THT", -1, dfp.getRoll("THT"));

        dfp = new DiceFromPennies(7);
        assertEquals("6 sided TTH", 7, dfp.getRoll("TTH"));
        assertEquals("6 sided TTT", -1, dfp.getRoll("TTT"));

        dfp = new DiceFromPennies(8);
        assertEquals("7 sided HTH", 3, dfp.getRoll("HTH"));
        assertEquals("7 sided TTH", 7, dfp.getRoll("TTH"));
    }

    public void test2To8SidedDiceFromPennies03()
    {
        DiceFromPennies dfp = new DiceFromPennies(2);
        assertEquals("2 sided TTTHTTHT", 2, dfp.getRoll("TTTTHT"));

        dfp = new DiceFromPennies(3);
        assertEquals("3 sided TTTTTTTH", 3, dfp.getRoll("TH"));

        dfp = new DiceFromPennies(5);
        assertEquals("4 sided THTTTTTTHTTTHHH", 1, dfp.getRoll("THTTTTTTHTTTHHH"));
        assertEquals("4 sided TTTTTHHTT", 4, dfp.getRoll("TTTTTHHTT"));
        assertEquals("4 sided TTHTTTTHT", -1, dfp.getRoll("TTHTTTTHT"));

        dfp = new DiceFromPennies(7);
        assertEquals("7 sided TTTHTH", 3, dfp.getRoll("HTH"));
        assertEquals("7 sided TTTTTTTTTTHT", 6, dfp.getRoll("THT"));

        dfp = new DiceFromPennies(8);
        assertEquals(4, dfp.getRoll("HTTHTTHTTHTT"));
    }

    public void test9To31SidedDiceFromPennies04()
    {
        DiceFromPennies dfp = new DiceFromPennies(9);
        assertEquals("9 sided THHT", -1, dfp.getRoll("THHT"));

        dfp = new DiceFromPennies(10);
        assertEquals("10 sided HTTT", 8, dfp.getRoll("HTTT"));
        assertEquals("10 sided THHT", 10, dfp.getRoll("THHT"));

        dfp = new DiceFromPennies(11);
        assertEquals("11 sided HHHT", 2, dfp.getRoll("HHHT"));
        assertEquals("11 sided HHTT", 4, dfp.getRoll("HHTT"));

        dfp = new DiceFromPennies(12);
        assertEquals("12 sided THTT", 12, dfp.getRoll("THTT"));
        assertEquals("12 sided TTHH", -1, dfp.getRoll("TTHH"));

        dfp = new DiceFromPennies(13);
        assertEquals("13 sided HHHH", 1, dfp.getRoll("HHHH"));

        dfp = new DiceFromPennies(14);
        assertEquals("14 sided THTT", 12, dfp.getRoll("THTT"));

        dfp = new DiceFromPennies(15);
        assertEquals("15 sided THHH", 9, dfp.getRoll("THHH"));

        dfp = new DiceFromPennies(16);
        assertEquals("16 sided TTTT", 16, dfp.getRoll("TTTT"));

        dfp = new DiceFromPennies(17);
        assertEquals("17 sided THHHH", 17, dfp.getRoll("THHHH"));
        assertEquals("17 sided THHHT", -1, dfp.getRoll("THHHT"));

        dfp = new DiceFromPennies(18);
        assertEquals("18 sided THHHH", 17, dfp.getRoll("THHHH"));

        dfp = new DiceFromPennies(19);
        assertEquals("19 sided HHTTH", 7, dfp.getRoll("HHTTH"));

        dfp = new DiceFromPennies(23);
        assertEquals("23 sided THTTH", 23, dfp.getRoll("THTTH"));
        assertEquals("23 sided THTTT", -1, dfp.getRoll("THTTT"));

        dfp = new DiceFromPennies(27);
        assertEquals("27 sided THTTH", 23, dfp.getRoll("THTTH"));
        assertEquals("27 sided TTHTT", -1, dfp.getRoll("TTHTT"));


        dfp = new DiceFromPennies(31);
        assertEquals("31 sided TTTTH", 31, dfp.getRoll("TTTTH"));

        dfp = new DiceFromPennies(32);
        assertEquals("32 sided HHHHH", 1, dfp.getRoll("HHHHH"));
        assertEquals("32 sided TTTTT", 32, dfp.getRoll("TTTTT"));
    }

    public void test9To31SidedDiceFromPennies05()
    {
        DiceFromPennies dfp = new DiceFromPennies(9);
        assertEquals("9 sided THHTTTHHTTTHHTTH", 7, dfp.getRoll("THHTTTHHTTTHHTTH"));

        dfp = new DiceFromPennies(10);
        assertEquals("10 sided THTHTTHHTTHTHTTT", 8, dfp.getRoll("THTHTTHHTTHTHTTT"));

        dfp = new DiceFromPennies(11);
        assertEquals("11 sided TTTTTTTHTHTH", 11, dfp.getRoll("TTTTTTTHTHTH"));

        dfp = new DiceFromPennies(12);
        assertEquals("12 sided TTTTTTTHHHHH", 1, dfp.getRoll("TTTTTTTHHHHH"));

        dfp = new DiceFromPennies(13);
        assertEquals("13 sided TTTTTTTHTTHT", -1, dfp.getRoll("TTTTTTTHTTHT"));

        dfp = new DiceFromPennies(14);
        assertEquals("14 sided TTTHTTTHTTTHTTTHTTTHTTTHTTHT", 14, dfp.getRoll("TTTHTTTHTTTHTTTHTTTHTTTHTTHT"));

        dfp = new DiceFromPennies(15);
        assertEquals("15 sided TTTTHHTT", 4, dfp.getRoll("TTTTHHTT"));

        dfp = new DiceFromPennies(16);
        assertEquals("16 sided HHHHHHHTHHTHHHTT", 1, dfp.getRoll("HHHHHHHTHHTHHHTT"));

        dfp = new DiceFromPennies(19);
        assertEquals("19 sided TTHTTTTTTTTHTTTHHTTH", 7, dfp.getRoll("TTHTTTTTTTTHTTTHHTTH"));

        dfp = new DiceFromPennies(22);
        assertEquals("22 sided TTTTHTHTTTTHTTHTHHHT", 18, dfp.getRoll("TTTTHTHTTTTHTTHTHHHT"));

        dfp = new DiceFromPennies(30);
        assertEquals("30 sided TTTTHTTTTTTTTHT", 30, dfp.getRoll("TTTTHTTTTTTTTHT"));
    }

    public void testRollUpTo20SidedDiceTwice06()
    {
        DiceFromPennies dfp = new DiceFromPennies(5);
        assertEquals("5 sided HTTHTH", 4+3, dfp.getRolls(2, "HTTHTH"));

        dfp = new DiceFromPennies(14);
        assertEquals("14 sided THHTHHTH", 10+3, dfp.getRolls(2, "THHTHHTH"));

        dfp = new DiceFromPennies(16);
        assertEquals("16 sided TTHHHTTH", 13+7, dfp.getRolls(2, "TTHHHTTH"));
    }

    public void testRollUpTo20SidedDiceTwiceWithNon07()
    {
        DiceFromPennies dfp = new DiceFromPennies(3);
        assertEquals("3 sided TTTTHTTTTTTTTH", 2+3, dfp.getRolls(2, "TTTTHTTTTTTTTH"));

        dfp = new DiceFromPennies(6);
        assertEquals("6 sided TTTTHTTTTTTHTTHHHT", 6+2, dfp.getRolls(2, "TTTTHTTTTTTHTTHHHT"));

        dfp = new DiceFromPennies(19);
        assertEquals("19 sided TTTTHTTHHHTHHTHTHHTTHTHHTHHHHH", 19+10, dfp.getRolls(2, "TTTTHTTHHHTHHTHTHHTTHTHHTHHHHH"));

        dfp = new DiceFromPennies(11);
        assertEquals("11 sided TTTTHTTHTTHHTTHTTH", 7+9, dfp.getRolls(2, "TTTTHTTHTTHHTTHTTHHH"));

        dfp = new DiceFromPennies(19);
        assertEquals("19 sided TTTTHTTTHTTHTTHHHHHTHTHTHTHHHHTHHTH", 2+11+17+19, dfp.getRolls(4, "TTTTHTTTHTTHTTHHHHHTHTHTHTHHHHTHHTH"));
    }

    public void testRollMoreThan20SidedDiceTwice08()
    {
        DiceFromPennies dfp = new DiceFromPennies(20);
        assertEquals("20 sided HTHHTHTHTH", 10+11, dfp.getRolls(2, "HTHHTHTHTH"));

        dfp = new DiceFromPennies(27);
        assertEquals("27 sided THHTHHTHHH", 19+9, dfp.getRolls(2, "THHTHHTHHH"));

        dfp = new DiceFromPennies(31);
        assertEquals("31 sided THHTHHTHTH", 7+6, dfp.getRolls(2, "HHTTHHHTHT"));
    }

    public void testRollingUpTo20SidedDiceSeveralTimes09()
    {
        DiceFromPennies dfp = new DiceFromPennies(5);
        assertEquals("5 sided TTTTHHHTTHTHTTHHHHHHTHTH", 5+4+3+1+2, dfp.getRolls(5, "TTTTHHHTTHTHTTHHHHHHTHTH"));
        assertEquals("5 sided TTTHHHHTHHHTTTHHHHHTTTTT", 1+3+2+1+4, dfp.getRolls(5, "TTTHHHHTHHHTTTHHHHHTTTTT"));

        dfp = new DiceFromPennies(9);
        assertEquals("9 sided TTTTHTTTTTTHTTHHHHHTHTHT", 8+2+6, dfp.getRolls(3, "TTTTHTTTTTTHTTHHHHHTHTHT"));
        assertEquals("9 sided TTTTHTHTTTTHTTHHHHTHTTHTTTHHHTTH", 6+3+7, dfp.getRolls(3, "TTTTHTHTTTTHTTHHHHTHTTHTTTHHHTTH"));

        dfp = new DiceFromPennies(13);
        assertEquals("13 sided TTTTHTTHHHTHHTHTHHTTHTHHTHHHHH", 7+11+12+5, dfp.getRolls(4, "TTTHHTTHTHTHTHTTTTHTTTTTHTHHHTTTT"));

        dfp = new DiceFromPennies(17);
        assertEquals("17 sided TTTTHTTHTTHHTTHTTH", 16+7+3, dfp.getRolls(3, "HTTTTTTTTHTTHTTHHTTHHHHTHT"));

        dfp = new DiceFromPennies(15);
        assertEquals("15 sided HHHHHTTTTHHTTTHHTTTHTTTTHTTHTTHTTHTTHHTTHHTHHH", 1+8+10+13+15+7+14+12+4, dfp.getRolls(9, "HHHHHTTTTHHTTTHHTTTHTTTTHTTHTTHTTHTTHHTTHHTHHH"));
    }

    public void testRollingAllDiceSeveralTimes10()
    {
        DiceFromPennies dfp = new DiceFromPennies(2);
        assertEquals("2 sided TTTTHHHTTHTHTTHHHHHHT", 1+2+1+1+1, dfp.getRolls(5, "HTHHHTTTHHHTTHTHTTHHHHHHT"));
        assertEquals("2 sided TTTTHHHTTHTHTTHHTTTHHHHTTTHHHHHHTTH", 35+17, dfp.getRolls(35, "TTTTHHHTTHTHTTHHTTTHHHHTTTHHHHHHTTH"));

        dfp = new DiceFromPennies(25);
        assertEquals("25 sided TTTTHTTHHTTHTTHHHHHTTTHTHHHTHHHHHHTTTHTHTTHHHHHH", 23+2+5, dfp.getRolls(3, "TTTTHTTHHTTHTTHHHHHTTTHTHHHTHHHHHHTTTHTHTTHHHHHH"));

        dfp = new DiceFromPennies(32);
        assertEquals("32 sided TTTTHTTHTTHHTTHTTH", 16+31+28+7+3+20, dfp.getRolls(6, "HTTTTTTTTHTTHTTHHTTHHHHTHTHHTTHTTHT"));

        assertEquals("32 sided HTTTTTTTTHTTHTTTTTTTHHHHH", 16+31+28+32+1, dfp.getRolls(5, "HTTTTTTTTHTTHTTTTTTTHHHHH"));
    }
    
    public void testFunctionsGoneWild2019_00()
    {
        assertEquals(2, FunctionsGoneWild2019.f1(2, 1));
        assertEquals(2+2*2+2, FunctionsGoneWild2019.f1(2, 2));
        assertEquals(8 + 2*8 + 2, FunctionsGoneWild2019.f1(2, 3));
        assertEquals(4+4*4+4, FunctionsGoneWild2019.f1(4, 2));
        assertEquals(1023, FunctionsGoneWild2019.f1(3, 5));

        assertEquals(21, FunctionsGoneWild2019.f2(0.5, 3.6, 1.1, 8.1));
        assertEquals(28, FunctionsGoneWild2019.f2(-1.3, 5.0, -4.6, -0.9));
        assertEquals(54, FunctionsGoneWild2019.f2(-3.1, 2.9, 0.95, 9.03));

        assertEquals(1771, FunctionsGoneWild2019.f3(202));
        assertEquals(422, FunctionsGoneWild2019.f3(135));
        assertEquals(-727, FunctionsGoneWild2019.f3(35));
        assertEquals(63, FunctionsGoneWild2019.f3(5));

        assertEquals(12, FunctionsGoneWild2019.f4(1, 1, 1));
        assertEquals(144, FunctionsGoneWild2019.f4(2, 2, 2));
        assertEquals(34, FunctionsGoneWild2019.f4(2, 1, 2));

        assertEquals("3.00", FunctionsGoneWild2019.f5("H", 0.001));
        assertEquals("11.00", FunctionsGoneWild2019.f5("OH", 0.001));
        assertEquals("1.92", FunctionsGoneWild2019.f5("H", 0.012));

        assertEquals(0.545199900, FunctionsGoneWild2019.f6(2, 1, 3), 0.05);
        assertEquals(10.1819565, FunctionsGoneWild2019.f6(2, 2, 3), 0.05);

        assertEquals(20, FunctionsGoneWild2019.f7("CODE", "CODE"));
        assertEquals(20, FunctionsGoneWild2019.f7("SCore", "Score"));
        assertEquals(17, FunctionsGoneWild2019.f7("@Precede*", "#proceed*"));
        assertEquals(9, FunctionsGoneWild2019.f7("#abcde", "#acCex"));

        assertEquals("plrgfsxvcwtbzdhnkmjq", FunctionsGoneWild2019.f8("bcdfghjklmnpqrstvwxz") );
        assertEquals("bcdfghjklmnpqrstvwxz", FunctionsGoneWild2019.f8("plrgfsxvcwtbzdhnkmjq") );
        assertEquals("ouyaei", FunctionsGoneWild2019.f8("aeiouy") );
        assertEquals("aeiouy", FunctionsGoneWild2019.f8("ouyaei") );
        assertEquals("faar xap", FunctionsGoneWild2019.f8("good job") );
        assertEquals("good job", FunctionsGoneWild2019.f8("faar xap") );

        assertEquals(false, FunctionsGoneWild2019.f9(false, false, false) );

        assertEquals(false, FunctionsGoneWild2019.f10(false, false, false, false) );
    }

    public void testFunctionsGoneWild2019_function01()
    {
        assertEquals(0, FunctionsGoneWild2019.f1(-2, 4));
        assertEquals(7775, FunctionsGoneWild2019.f1(5, 5));
        assertEquals(0, FunctionsGoneWild2019.f1(61, 0));
        assertEquals(11, FunctionsGoneWild2019.f1(11, 1));

    }

    public void testFunctionsGoneWild2019_function02()
    {
        assertEquals(11*5, FunctionsGoneWild2019.f2(-5, 5, 8, 12));
        assertEquals(55*2, FunctionsGoneWild2019.f2(-4, 50, 2, 3));
        assertEquals(11*61, FunctionsGoneWild2019.f2(5.2, 16.5, 21.5, 82.9));
        assertEquals(6*16, FunctionsGoneWild2019.f2(0, 5.2, -16.5, -0.2));
    }

    public void testFunctionsGoneWild2019_function03()
    {
        assertEquals(-1247, FunctionsGoneWild2019.f3(296));
        assertEquals(1544, FunctionsGoneWild2019.f3(170));

        assertEquals(386, FunctionsGoneWild2019.f3(123));
        assertEquals(638, FunctionsGoneWild2019.f3(207));

        assertEquals(-597, FunctionsGoneWild2019.f3(28));
        assertEquals(1766, FunctionsGoneWild2019.f3(84));

        assertEquals(120, FunctionsGoneWild2019.f3(8));
        assertEquals(728, FunctionsGoneWild2019.f3(24));
    }

    public void testFunctionsGoneWild2019_function04()
    {
        assertEquals(274, FunctionsGoneWild2019.f4(3, 2, 1));
        /*
        a = 3 b = 2 c = 1
        min2 = -1
        max2 = 7
         */

        assertEquals(1319, FunctionsGoneWild2019.f4(2, 4, 3));
        /*
        a = 2 b = 4 c = 3
        min1 = 5
        max1 = 14
         */

        assertEquals(1656, FunctionsGoneWild2019.f4(6, 2, 9));
        /*
        a = 6 b = 2 c = 9  
        min1 = 3
        max1 = 24
         */

        assertEquals(11647, FunctionsGoneWild2019.f4(5, 8, 5));
        /*
        a = 5 b = 8 c = 5
        min1/2 = 35
        max1/2 = 45
         */
    }

    public void testFunctionsGoneWild2019_function05()
    {
        assertEquals("1.19", FunctionsGoneWild2019.f5("H", 0.065));
        assertEquals("1.20", FunctionsGoneWild2019.f5("H", 0.0631));

        assertEquals("2.52", FunctionsGoneWild2019.f5("H", 0.003));
        assertEquals("0.08", FunctionsGoneWild2019.f5("H", 0.837));
        assertEquals("7.60", FunctionsGoneWild2019.f5("H", 0.000000025));

        assertEquals("12.81", FunctionsGoneWild2019.f5("OH", 0.065));
        assertEquals("12.80", FunctionsGoneWild2019.f5("OH", 0.0631));

        assertEquals("11.48", FunctionsGoneWild2019.f5("OH", 0.003));
        assertEquals("13.92", FunctionsGoneWild2019.f5("OH", 0.837));
        assertEquals("6.40", FunctionsGoneWild2019.f5("OH", 0.000000025));
    }

    public void testFunctionsGoneWild2019_function06()
    {
        assertEquals(76.723,   FunctionsGoneWild2019.f6( 0, 44, 59), 1.5);
        assertEquals(41.0055,   FunctionsGoneWild2019.f6(4, 14, 11), 1.0);

        assertEquals(1.9707,   FunctionsGoneWild2019.f6( 34.9, 0.51, 1.0), 0.2);
        assertEquals(30.536,   FunctionsGoneWild2019.f6( -2.6, -1.7, 3.0), 3.);

        assertEquals(-69.6597,   FunctionsGoneWild2019.f6( -19.507, 1.9, 23.5), 5.0);
        assertEquals(57.9456,   FunctionsGoneWild2019.f6( -5.48, -6.3, -2.4), 5.0);
    }

    public void testFunctionsGoneWild2019_function07()
    {
        assertEquals(0, FunctionsGoneWild2019.f7("asdfg", "@hjkl"));
        assertEquals(24, FunctionsGoneWild2019.f7("wperty", "wperty"));
        assertEquals(4, FunctionsGoneWild2019.f7("compute", "mputeee"));
        assertEquals(0, FunctionsGoneWild2019.f7("ONETWO", "TWORED"));
        assertEquals(32, FunctionsGoneWild2019.f7("FISHTWOFISH", "FISHREDfish"));
        assertEquals(8*5, FunctionsGoneWild2019.f7("FISHTWOFISH", "FISHREDFISH"));
    }

    public void testFunctionsGoneWild2019_function08()
    {
        assertEquals("bkxznhdcwgpvjqtsrlmf", FunctionsGoneWild2019.f8("pvjqtsrlmfbkxznhdcwg") );

        assertEquals("nsu zeylv pdamt gaj xewbh akud nsu coqi raf", FunctionsGoneWild2019.f8("the quick brown fox jumps over the lazy dog"));
        assertEquals("hebudlocygdofycyhnylujbyocyralyaeh", FunctionsGoneWild2019.f8("supercalifragilisticexpialidocious"));
        assertEquals("supercalifragilisticexpialidocious", FunctionsGoneWild2019.f8("hebudlocygdofycyhnylujbyocyralyaeh"));
        assertEquals("bnudifawotrypecod qkx ", FunctionsGoneWild2019.f8("pterygomandibular zvj "));
        assertEquals("pterygomandibular zvj ", FunctionsGoneWild2019.f8("bnudifawotrypecod qkx "));
        assertEquals("utlubsocawialodrynyh utlubsocawialodrynyh xzvm", FunctionsGoneWild2019.f8("encephalomyocarditis encephalomyocarditis jqkw"));
        assertEquals("encephalomyocarditis encephalomyocarditis jqkw", FunctionsGoneWild2019.f8("utlubsocawialodrynyh utlubsocawialodrynyh xzvm"));
    }

    public void testFunctionsGoneWild2019_function09()
    {
        assertEquals(false, FunctionsGoneWild2019.f9(false, false, false) );
        assertEquals(true, FunctionsGoneWild2019.f9(false, false, true) );
        assertEquals(false, FunctionsGoneWild2019.f9(false, true, false) );
        assertEquals(false, FunctionsGoneWild2019.f9(false, true, true) );
        assertEquals(true, FunctionsGoneWild2019.f9(true, false, false) );
        assertEquals(true, FunctionsGoneWild2019.f9(true, false, true) );
        assertEquals(false, FunctionsGoneWild2019.f9(true, true, false) );
        assertEquals(false, FunctionsGoneWild2019.f9(true, true, true) );
    }

    public void testFunctionsGoneWild2019_function10()
    {
        assertEquals(false, FunctionsGoneWild2019.f10(false, false, false, false) );
        assertEquals(true, FunctionsGoneWild2019.f10(false, false, false, true) );
        assertEquals(false, FunctionsGoneWild2019.f10(false, false, true, false) );
        assertEquals(false, FunctionsGoneWild2019.f10(false, false, true, true) );
        assertEquals(true, FunctionsGoneWild2019.f10(false, true, false, false) );
        assertEquals(true, FunctionsGoneWild2019.f10(false, true, false, true) );
        assertEquals(false, FunctionsGoneWild2019.f10(false, true, true, false) );
        assertEquals(true, FunctionsGoneWild2019.f10(false, true, true, true) );
        assertEquals(false, FunctionsGoneWild2019.f10(true, false, false, false) );
        assertEquals(false, FunctionsGoneWild2019.f10(true, false, false, true) );
        assertEquals(false, FunctionsGoneWild2019.f10(true, false, true, false) );
        assertEquals(true, FunctionsGoneWild2019.f10(true, false, true, true) );
        assertEquals(false, FunctionsGoneWild2019.f10(true, true, false, false) );
        assertEquals(true, FunctionsGoneWild2019.f10(true, true, false, true) );
        assertEquals(false, FunctionsGoneWild2019.f10(true, true, true, false) );
        assertEquals(true, FunctionsGoneWild2019.f10(true, true, true, true) );
    }

    public void testFunctionsGoneWild2019_Bonusfunction01_03()
    {
        testFunctionsGoneWild2019_function01();
        testFunctionsGoneWild2019_function02();
        testFunctionsGoneWild2019_function03();
    }

    public void testFunctionsGoneWild2019_Bonusfunction04_06()
    {
        testFunctionsGoneWild2019_function04();
        testFunctionsGoneWild2019_function05();
        testFunctionsGoneWild2019_function06();
    }

    public void testFunctionsGoneWild2019_Bonusfunction07_08()
    {
        testFunctionsGoneWild2019_function07();
        testFunctionsGoneWild2019_function08();
    }

    public void testFunctionsGoneWild2019_Bonusfunction09_10()
    {
        testFunctionsGoneWild2019_function09();
        testFunctionsGoneWild2019_function10();
    }

    public void testFunctionsGoneWild2019_Bonus_All()
    {
        testFunctionsGoneWild2019_Bonusfunction01_03();
        testFunctionsGoneWild2019_Bonusfunction04_06();
        testFunctionsGoneWild2019_Bonusfunction07_08();
        testFunctionsGoneWild2019_Bonusfunction09_10();
    }
}