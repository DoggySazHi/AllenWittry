public class Point
{
   private final double x;
   private final double y;

   /**
	* Constructor for objects of class Point
	*/
   public Point(double a, double b)
   {
      x = a;
      y = b;
   }

   public double getX()
   {
      return x;
   }

   public double getY()
   {
      return y;
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof Point))
         return false;
      Point temp = (Point) obj;

      return Math.abs(x - temp.getX()) < 0.002 && Math.abs(y - temp.getY() ) < 0.002;
   }

   public int hashCode()
   {
      int t = (int) (x * y);
      return Integer.hashCode(t);
   }
}