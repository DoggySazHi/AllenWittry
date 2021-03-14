import java.lang.Math;
/**
 * The test class FunctionsGoneWildPartIII.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FunctionsGoneWild2012
{
   public static int f1(int n)
   {
      if (n > 70)
         if ((n & 1) == 0)
            return f1(8888 / (n - 10));
         else
            return f1(9999 / (n - 11));
      else if (n >= 25)
         return f1((int) (Math.abs((n - 47) / Math.pow(3, n % 5))));
      return 3 * n * n * n - 4 * n - 11;
   }

   public static double f2(double x, double y, double z)
   {
      return Math.floor((4.0 * Math.pow(z, y)) / Math.sqrt(Math.pow(3, x))) + Math.pow(Math.sqrt(2.0 * y - x / (3.0 * z)) / Math.pow(z, x + y), y / Math.abs(x - z));
   }

   public static double f3(double a, double b)
   {
      return Math.pow(Math.sin(a * b / Math.sqrt(a + b)), Math.cos(b * b)) + Math.PI * Math.tan(a * b + Math.cos(Math.abs(a - b)));
   }

   public static double f4(double a, double b, double c)
   {
      if (Math.cos(a + b) > 0)
         return Math.pow(Math.PI + Math.E, Math.sin(a)) + Math.pow(Math.log(4 + Math.abs(b * c)), Math.cos(b));
      return Math.log10(b - Math.log(1 / Math.abs(Math.pow(a, Math.PI)))) + Math.pow((Math.pow(Math.E, b * Math.PI) - Math.pow(b, c))/ (Math.pow(a, Math.PI) + Math.E), a + b * c);
   }

   public static int f5(int a, int b, int c)
   {
      double accum = 0;
      for(int i = a; i <= a + b + c; ++i)
         accum += Math.ceil(i * c / b + i * a);
      return (int) accum;
   }

   public static int f6(int a, int b, int c, int d)
   {
      int accum = 0;
      for(int i = a + b; i <= c + d; ++i)
         accum += (int) Math.pow(-1.0, i) * ((int) Math.pow(a + c, (b + d) * i) - (int) Math.pow(a - c, i));
      return accum;
   }

   public static boolean f7(boolean x, boolean y, boolean z)
   {
      return !x && !z || y && !z || x && !y && z;
   }

   public static boolean f8(boolean j, boolean k, boolean m, boolean n)
   {
      return !j && !k && !n || !k && m && !n || !j && k && m || j && !m && n || j && k && !m || j && k && n;
   }

   public static double f9(double a, double b, double c, double d)
   {
      // WS says e, but there is no e. what?
      return f3(Math.max(Math.pow(a, b), Math.pow(b, c)), -f4(1.0 - d, 2.0 * Math.PI / Math.pow(Math.E, 2), -c)) + (double) f6(2, (int) (Math.floor(b + d)), (int) (Math.ceil(f3(d, 2.0 * a * c))), (int) ((93.0 * a) % 10)) / (double) f5((int) ((Math.pow(a, 2) * Math.pow(b, 4)) % 5), (int) Math.max(6, Math.min(Math.pow(d, c), Math.pow(c, d)) % 17), (int) Math.floor(Math.pow(b, 2)));
   }

   public static boolean f10(boolean v, boolean w, boolean x, boolean y, boolean z)
   {
      return f8(!v && f7(w && z, y, !x || !y), v && (z || w), w, x || !y) || f7(z, x, z || w && y) && f7(f7(x, w, v), f7(w, x, z), f8(!w, !z || v, !x, y));
   }
}