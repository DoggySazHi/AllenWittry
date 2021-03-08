import java.util.*;
import java.lang.Math;
/**
 * The test class FunctionsGoneWildPartIII.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FunctionsGoneWildPartIII
{
   public static int f1(int n)
   {
      if (n >= 50)
         if ((n & 1) == 0)
            return f1(n - 5 * n / 3 - 7) / f1(n / 11 - 2);
         else
            return f1(2 * Math.abs(n - f1(n % 50)) % n) - f1(2 + f1(n - 49) % n / 7);
      else if (n >= 25)
         return 4 * f1(n - 23) - f1(n - 11) + 2 * (int) Math.round(Math.pow(n, 1 + n % 3));
      return 2 * n * n * n - 3 * n * n - 5 * n + 37; // I don't like Math.pow, since casting may cause rounding errors.
   }

   public static double f2(int a, int b)
   {
      double accum = 0;
      for(int i = a; i <= b; i++)
         accum += (a + i) * Math.sin(Math.pow((a % 9), i % 13)) / Math.pow(1 + Math.abs(i), Math.cos(b));
      return accum;
   }

   public static double f3(double x, double y, double z)
   {
      return 11.0 * Math.sqrt(Math.sqrt(x + Math.pow(z, y)) / x) + Math.pow(5 * Math.sqrt(3.0 * y + x * z) / Math.pow(z, x + 2.0 * y), 1.0 / (x + 2.0 * z));
   }

   public static double f4(double a, double b, double c)
   {
      return 100.0 * Math.pow(Math.pow(Math.sin(b + Math.sqrt(c)), 2) + Math.tan((3.0 * a + 2.0 * b + c) % (Math.PI / 4.0)), 1.0 / a);
   }

   public static double f5(double a, double b)
   {
      if (Math.pow(a, b) > Math.pow(Math.PI, a))
         return Math.pow(Math.PI + Math.E, Math.abs(Math.sin(a))) + Math.pow(Math.log(a), Math.E * Math.pow(Math.cos(b), 2));
      return Math.E + Math.log10(99.0 * b + Math.log(a * Math.PI)) + (Math.PI + Math.pow(b, Math.E))/(Math.pow(Math.PI, a) - Math.E);
   }

   public static double f6(double x, double y, double z)
   {
      return Math.pow(Math.abs(Math.cos(Math.pow(x, y + z))), Math.tan(x + y)) + Math.sqrt(Math.pow(Math.tan((x + z) / (y - 2.0 * z)), 2)) / Math.pow(3 * z, Math.sqrt(10.0 / x)) + (y * Math.pow(x, x + 2.0 * y) - Math.pow(z, x + z)) / (x - Math.sin(4.5 * y));
   }

   public static boolean f7(boolean x, boolean y, boolean z)
   {
      return y && !z || x && !y;
   }

   public static boolean f8(boolean j, boolean k, boolean m, boolean n)
   {
      return !k && m && n || !j && k && !m || !j && k && !n || j && n;
   }

   public static double f9(double a, double b, double x, double y, double z)
   {
      return Math.pow(f4(x, 4 * f3(5 - x, Math.PI, Math.sqrt(Math.E)), 2), Math.PI) + f5(b + x, Math.sqrt(f4(z, Math.E / Math.abs(z - (a + x)), 2 * a + 3 * y))) / f6(Math.cos(x), Math.sqrt(Math.pow(y, 2) + 17), Math.pow(z, 2));
   }

   public static boolean f10(boolean a, boolean b, boolean c, boolean d, boolean e)
   {
      return f8(d || f7(a, b && !e, c), a && !(c || d), e || !c, a) || f7(c, d, a) && !f7(f8(a && c, a || b && e, d, !c), f7(c, d, a), f7(e, c,a));
   }
}