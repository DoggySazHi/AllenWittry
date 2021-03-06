import org.junit.Test;

import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  Don Allen
 * @version 2010 programming contest
 */
public class CirclesFinalTest extends junit.framework.TestCase
{
   public void testCircle01()
   {
      Point a = new Point(2, 4);
      Point b = new Point(6, 8);
      Point c = new Point(12, 4);
      
      Circle ans = new Circle(a, b, c);
      Point cc = new Point(7., 3.);

      assertEquals(cc.getX(), ans.getCenter().getX());
      assertEquals(cc.getY(), ans.getCenter().getY());
      assertEquals(Math.sqrt(26.), ans.getRadius());
   }

   public void testCircle02()
   {
      Point a = new Point(2, 3);
      Point b = new Point(2, 9);
      Point c = new Point(14, 15);
      
      Circle ans = new Circle(a, b, c);
      Point cc = new Point(11., 6.);

      for (int k = 0; k < 3; k++)
      {
          assertEquals(cc.getX(), ans.getCenter().getX());
          assertEquals(cc.getY(), ans.getCenter().getY());
          assertEquals(Math.sqrt(90.), ans.getRadius());
      }

      a = new Point(3, 7);
      b = new Point(13, 21);
      c = new Point(13, -3);
      
      ans = new Circle(a, b, c);
      cc = new Point(15., 9.);

      boolean flag = Math.abs(cc.getX() - ans.getCenter().getX()) < 0.0002;
      assertEquals(true, flag);
      assertEquals(cc.getY(), ans.getCenter().getY());
      flag = Math.abs( Math.sqrt(148.) - ans.getRadius()) < 0.0002;
      assertEquals(true, flag);
    }

   public void testCircle03()
   {
      Point a = new Point(-6, -6);
      Point b = new Point(0, 0);
      Point c = new Point(10, 0);
      
      Circle ans = new Circle(a, b, c);
      Point cc = new Point(5, -11);

      boolean flag = Math.abs(cc.getX() - ans.getCenter().getX()) < 0.0002;
      assertEquals(true, flag);
      assertEquals(cc.getY(), ans.getCenter().getY());
      flag = Math.abs( Math.sqrt(146) - ans.getRadius()) < 0.0002;
      assertEquals(true, flag);

      a = new Point(0, 0);
      b = new Point(20, 0);
      c = new Point(40, -20);
      
      ans = new Circle(a, b, c);
      cc = new Point(10, -30.);

      flag = Math.abs(cc.getX() - ans.getCenter().getX()) < 0.0002;
      assertEquals(true, flag);
      assertEquals(cc.getY(), ans.getCenter().getY());
      flag = Math.abs( Math.sqrt(1000.) - ans.getRadius()) < 0.0002;
      assertEquals(true, flag);
    }

    public void testCircle04()
   {
      Point a = new Point(3, 7);
      Point b = new Point(3, 21);
      Point c = new Point(13, 21);
      
      Circle ans = new Circle(a, b, c);
      Point cc = new Point(8, 14);

      boolean flag = Math.abs(cc.getX() - ans.getCenter().getX()) < 0.0002;
      assertEquals(true, flag);
      assertEquals(cc.getY(), ans.getCenter().getY());
      flag = Math.abs( Math.sqrt(25.+49) - ans.getRadius()) < 0.0002;
      assertEquals(true, flag);

      a = new Point(3, 27);
      b = new Point(23, 27);
      c = new Point(23, 43);
      
      ans = new Circle(a, b, c);
      cc = new Point(13, 35.);

      flag = Math.abs(cc.getX() - ans.getCenter().getX()) < 0.0002;
      assertEquals(true, flag);
      assertEquals(cc.getY(), ans.getCenter().getY());
      flag = Math.abs( Math.sqrt(164.) - ans.getRadius()) < 0.0002;
      assertEquals(true, flag);
   }

   public void testCircle05()
   {
      Point a = new Point(-2, -7);
      Point b = new Point(4, -12);
      Point c = new Point(14, -8);
      
      Circle ans = new Circle(a, b, c);
      Point cc = new Point(232./37, -235/74.);

      boolean flag = Math.abs(cc.getX() - ans.getCenter().getX()) < 0.0002;
      assertEquals(true, flag);
      flag = Math.abs(cc.getY() - ans.getCenter().getY()) < 0.0002;
      assertEquals(true, flag);
      flag = Math.abs( Math.sqrt(454633./5476) - ans.getRadius()) < 0.0002;
      assertEquals(true, flag);

      a = new Point(11, 40);
      b = new Point(31, 22);
      c = new Point(87, 66);
      
      ans = new Circle(a, b, c);
      cc = new Point(11031./236, 7033./118);

      flag = Math.abs(cc.getX() - ans.getCenter().getX()) < 0.0002;
      assertEquals(true, flag);
      assertEquals(cc.getY(), ans.getCenter().getY());
      flag = Math.abs( Math.sqrt(1661.683) - ans.getRadius()) < 0.0002;
      assertEquals(true, flag);
    }

   public void testCircle06()
   {
      Point a = new Point(-50, -40);
      Point b = new Point(-30, -10);
      Point c = new Point(-10, -50);
      
      Circle ans = new Circle(a, b, c);
      Point cc = new Point(-190./7, -235/7.);

      boolean flag = Math.abs(cc.getX() - ans.getCenter().getX()) < 0.0002;
      assertEquals(true, flag);
      flag = Math.abs(cc.getY() - ans.getCenter().getY()) < 0.0002;
      assertEquals(true, flag);
      flag = Math.abs( Math.sqrt(563.7755) - ans.getRadius()) < 0.0002;
      assertEquals(true, flag);

      a = new Point(-100, 25);
      b = new Point(30, 31);
      c = new Point(20, -55);
      
      ans = new Circle(a, b, c);
      cc = new Point(-4652./139, -2169./417);

      flag = Math.abs(cc.getX() - ans.getCenter().getX()) < 0.0002;
      assertEquals(true, flag);
      assertEquals(cc.getY(), ans.getCenter().getY());
      flag = Math.abs( Math.sqrt(5338.683712) - ans.getRadius()) < 0.0002;
      assertEquals(true, flag);
    }

   public void testCircle07()
   {
      Point a = new Point(-50, 201);
      Point b = new Point(-200, -175);
      Point c = new Point(-26, -100);
      
      Circle ans = new Circle(a, b, c);
      Point cc = new Point(-1705127./9029, 38.47208993);

      boolean flag = Math.abs(cc.getX() - ans.getCenter().getX()) < 0.0002;
      assertEquals(true, flag);
      flag = Math.abs(cc.getY() - ans.getCenter().getY()) < 0.0002;
      assertEquals(true, flag);
      flag = Math.abs( Math.sqrt(45694.65482) - ans.getRadius()) < 0.0002;
      assertEquals(true, flag);

      a = new Point(300, 500);
      b = new Point(700, 700);
      c = new Point(50, 200);
      
      ans = new Circle(a, b, c);
      cc = new Point(6625./7, -2050./7);

      flag = Math.abs(cc.getX() - ans.getCenter().getX()) < 0.0002;
      assertEquals(true, flag);
      flag = Math.abs(cc.getY() - ans.getCenter().getY()) < 0.0002;
      assertEquals(true, flag);
      flag = Math.abs( Math.sqrt(1046492.347) - ans.getRadius()) < 0.0002;
      assertEquals(true, flag);
    }

   public void testCircle08()
   {
      Point a = new Point(-50, 0);
      Point b = new Point(-200, 0);
      Point c = new Point(-26, 0);
      
      Circle ans = new Circle(a, b, c);
      Point cc = null;

      boolean flag = (cc == null);
      assertEquals(true, flag);
      assertEquals(-1., ans.getRadius());

      for (int k = 1; k < 1005; k = k + 200)
      {
          a = new Point(-1000, -500);
          b = new Point(-1000 + 2 * k, -500 + 2 * k);
          c = new Point(-1000 + 4 * k, -500 + 4 * k);
          
          ans = new Circle(a, b, c);
          cc = null;
    
          flag = ( cc == null);
          assertEquals(true, flag);
          assertEquals(-1., ans.getRadius());
      }
   }

   public void testCircle09()
   {
      testCircle01();
      testCircle02();
      testCircle03();
      testCircle04();
      testCircle05();
   }

   public void testCircle10()
   {
      testCircle06();
      testCircle07();
      testCircle08();
      testCircle09();
   }
}