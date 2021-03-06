import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  (your name)
 * @version 2010 programming contest
 */
public class CirclesTest extends junit.framework.TestCase
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
}