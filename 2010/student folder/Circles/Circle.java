import java.util.*;

public class Circle 
{
// add your own instancevariables
   private Point center;
   private double radius;

   public Circle (Point x, Point y, Point z)
   {
      var sol = Determinants.cramer(new double[][] {
              {x.getX(), x.getY(), 1, - (x.getX() * x.getX()) - (x.getY() * x.getY())},
              {y.getX(), y.getY(), 1, - (y.getX() * y.getX()) - (y.getY() * y.getY())},
              {z.getX(), z.getY(), 1, - (z.getX() * z.getX()) - (z.getY() * z.getY())}
      });
      if (sol == null) {
         center = new Point(x.getX(), y.getY());
         radius = -1;
         return;
      }
      center = new Point(-sol[0][0]/2, -sol[1][0]/2);
      radius = Math.sqrt(center.getX() * center.getX() + center.getY() * center.getY() - sol[2][0]);
   }

   public Point getCenter()
   {
      return center;
   }

   public double getRadius()
   {
      return radius;
   }
}