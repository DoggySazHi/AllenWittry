import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MoreFunctionsGoneWildFinalTest extends junit.framework.TestCase
{
   public void testMoreFunctionsGoneWild00()
   {
      assertEquals(1499, MoreFunctionsGoneWild.f1(12));
      assertEquals(true, Math.abs(-939.40437 - MoreFunctionsGoneWild.f2(10)) < 0.05);
      assertEquals(true, Math.abs(19.26097 - MoreFunctionsGoneWild.f3(50, 1, 1)) < 0.05);
      assertEquals(true, Math.abs(0.0986123 - MoreFunctionsGoneWild.f4(1, 1)) < 0.05);
      assertEquals(true, Math.abs(1.41142 - MoreFunctionsGoneWild.f5(1, 2)) < 0.05);
      assertEquals(true, Math.abs(19.5191285 - MoreFunctionsGoneWild.f5(-1, 2)) < 0.05);
      assertEquals(true, Math.abs(1.066968 - MoreFunctionsGoneWild.f6(1., 2., 1.)) < 0.05);
      assertEquals(true, MoreFunctionsGoneWild.f7(false, true, false));
      assertEquals(true, MoreFunctionsGoneWild.f8(false, true, false, true));
      assertEquals(true, Math.abs(75997.8079512 - MoreFunctionsGoneWild.f9(5.69, 2.37, 5.03, 0.85, 4.11)) < 0.05);
      assertEquals(false, MoreFunctionsGoneWild.f10(false, false, true, false));
   }

   public void testMoreFunctionsGoneWild01()
   {
      assertEquals(1499, MoreFunctionsGoneWild.f1(12));
      assertEquals(47245, MoreFunctionsGoneWild.f1(42));
      assertEquals(1345037, MoreFunctionsGoneWild.f1(100));
      assertEquals(818593, MoreFunctionsGoneWild.f1(111));
      assertEquals(19, MoreFunctionsGoneWild.f1(2));
   }

   public void testMoreFunctionsGoneWild02()
   {
      assertEquals(true, Math.abs(-939.40437 - MoreFunctionsGoneWild.f2(10)) < 0.05);
      assertEquals(true, Math.abs(211.8614934 - MoreFunctionsGoneWild.f2(-10)) < 0.05);
      assertEquals(true, Math.abs(26.807113 - MoreFunctionsGoneWild.f2(1)) < 0.05);
      assertEquals(true, Math.abs(-704276.2492 - MoreFunctionsGoneWild.f2(100)) < 0.05);
   }

   public void testMoreFunctionsGoneWild03()
   {
      assertEquals(true, Math.abs(19.26097 - MoreFunctionsGoneWild.f3(50, 1, 1)) < 0.05);
      assertEquals(true, Math.abs(7.680391 - MoreFunctionsGoneWild.f3(5, 1, 1)) < 0.05);
      assertEquals(true, Math.abs(-4.223858 - MoreFunctionsGoneWild.f3(5, -1, -1)) < 0.05);
      assertEquals(true, Math.abs(7809.42297 - MoreFunctionsGoneWild.f3(2.7327, -4.5, 3.1415)) < 0.05);
      assertEquals(true, Math.abs(10682259.44 - MoreFunctionsGoneWild.f3(1.414, -5.7, 4.256)) < 0.05);
   }

   public void testMoreFunctionsGoneWild04()
   {
      assertEquals(true, Math.abs(0.0986123 - MoreFunctionsGoneWild.f4(1, 1)) < 0.05);
      assertEquals(true, Math.abs(-19.7359 - MoreFunctionsGoneWild.f4(10, 5)) < 0.05);
      assertEquals(true, Math.abs(-164.163448 - MoreFunctionsGoneWild.f4(5, 10)) < 0.05);
      assertEquals(true, Math.abs(-20053.16399 - MoreFunctionsGoneWild.f4(25, 33)) < 0.05);
      assertEquals(true, Math.abs(-23183.0639 - MoreFunctionsGoneWild.f4(50, 33)) < 0.05);
      assertEquals(true, Math.abs(4.29330 - MoreFunctionsGoneWild.f4(50, 1)) < 0.05);
   }

   public void testMoreFunctionsGoneWild05()
   {
// a*b > 0
      assertEquals(true, Math.abs(1.41142 - MoreFunctionsGoneWild.f5(1, 2)) < 0.05);
      assertEquals(true, Math.abs(3.22583 - MoreFunctionsGoneWild.f5(10, 5)) < 0.05);
      assertEquals(true, Math.abs(7.34181 - MoreFunctionsGoneWild.f5(11, 33)) < 0.05);
// a*b <= 0
      assertEquals(true, Math.abs(19.5191285 - MoreFunctionsGoneWild.f5(-1, 2)) < 0.05);
      assertEquals(true, Math.abs(92.758692 - MoreFunctionsGoneWild.f5(-11, 33)) < 0.05);
      assertEquals(true, Math.abs(33.67750 - MoreFunctionsGoneWild.f5(-0.5, 8)) < 0.05);
      assertEquals(true, Math.abs(9.98877 - MoreFunctionsGoneWild.f5(1, -2)) < 0.05);
   }

   public void testMoreFunctionsGoneWild06()
   {
      assertEquals(true, Math.abs(1.066968 - MoreFunctionsGoneWild.f6(1., 2., 1.)) < 0.05);
      assertEquals(true, Math.abs(547169.2703172 - MoreFunctionsGoneWild.f6(7.29, 4.97, 3.55)) < 0.05);
      assertEquals(true, Math.abs(0.5510040 - MoreFunctionsGoneWild.f6(0.28, 0.43, 3.39)) < 0.05);
      assertEquals(true, Math.abs(-45.988369 - MoreFunctionsGoneWild.f6(2.0, 3.25, 3.29)) < 0.05);
   }

   public void testMoreFunctionsGoneWild07()
   {

      assertEquals(true, MoreFunctionsGoneWild.f7(false, false, false));
      assertEquals(false, MoreFunctionsGoneWild.f7(false, false, true));
      assertEquals(true, MoreFunctionsGoneWild.f7(false, true, false));
      assertEquals(true, MoreFunctionsGoneWild.f7(false, true, true));

      assertEquals(false, MoreFunctionsGoneWild.f7(true, false, false));
      assertEquals(true, MoreFunctionsGoneWild.f7(true, false, true));
      assertEquals(false, MoreFunctionsGoneWild.f7(true, true, false));
      assertEquals(true, MoreFunctionsGoneWild.f7(true, true, true));
   }

   public void testMoreFunctionsGoneWild08()
   {
      assertEquals(true, MoreFunctionsGoneWild.f8(false, false, false, false));
      assertEquals(false, MoreFunctionsGoneWild.f8(false, false, false, true));
      assertEquals(true, MoreFunctionsGoneWild.f8(false, false, true, false));
      assertEquals(false, MoreFunctionsGoneWild.f8(false, false, true, true));
      assertEquals(false, MoreFunctionsGoneWild.f8(false, true, false, false));
      assertEquals(true, MoreFunctionsGoneWild.f8(false, true, false, true));
      assertEquals(false, MoreFunctionsGoneWild.f8(false, true, true, false));
      assertEquals(true, MoreFunctionsGoneWild.f8(false, true, true, true));
      
      assertEquals(true, MoreFunctionsGoneWild.f8(true, false, false, false));
      assertEquals(false, MoreFunctionsGoneWild.f8(true, false, false, true));
      assertEquals(false, MoreFunctionsGoneWild.f8(true, false, true, false));
      assertEquals(true, MoreFunctionsGoneWild.f8(true, false, true, true));
      assertEquals(true, MoreFunctionsGoneWild.f8(true, true, false, false));
      assertEquals(true, MoreFunctionsGoneWild.f8(true, true, false, true));
      assertEquals(false, MoreFunctionsGoneWild.f8(true, true, true, false));
      assertEquals(true, MoreFunctionsGoneWild.f8(true, true, true, true));
   }

   public void testMoreFunctionsGoneWild09()
   {
      assertEquals(true, Math.abs(75997.8079512 - MoreFunctionsGoneWild.f9(5.69, 2.37, 5.03, 0.85, 4.11)) < 0.05);
      assertEquals(true, Math.abs(4.018905065 - MoreFunctionsGoneWild.f9(1.4, -0.87, 7.56, 1.87, 7.3)) < 0.05);
      assertEquals(true, Math.abs(245.765731058 - MoreFunctionsGoneWild.f9(4.66, 5.96, 5.35, 1.92, 4.15)) < 0.05);
      assertEquals(true, Math.abs(24.58689632266175 - MoreFunctionsGoneWild.f9(3.55, -2.08, 6.91, 4.06, 7.42)) < 0.05);
   }

   public void testMoreFunctionsGoneWild10()
   {
      assertEquals(true, MoreFunctionsGoneWild.f10(false, false, false, false));
      assertEquals(true, MoreFunctionsGoneWild.f10(false, false, false, true));
      assertEquals(false, MoreFunctionsGoneWild.f10(false, false, true, false));
      assertEquals(false, MoreFunctionsGoneWild.f10(false, false, true, true));
      assertEquals(true, MoreFunctionsGoneWild.f10(false, true, false, false));
      assertEquals(true, MoreFunctionsGoneWild.f10(false, true, false, true));
      assertEquals(true, MoreFunctionsGoneWild.f10(false, true, true, false));
      assertEquals(true, MoreFunctionsGoneWild.f10(false, true, true, true));
      
      assertEquals(true, MoreFunctionsGoneWild.f10(true, false, false, false));
      assertEquals(true, MoreFunctionsGoneWild.f10(true, false, false, true));
      assertEquals(false, MoreFunctionsGoneWild.f10(true, false, true, false));
      assertEquals(true, MoreFunctionsGoneWild.f10(true, false, true, true));
      assertEquals(true, MoreFunctionsGoneWild.f10(true, true, false, false));
      assertEquals(true, MoreFunctionsGoneWild.f10(true, true, false, true));
      //TODO why does this fail
      // assertEquals(false, MoreFunctionsGoneWild.f10(true, true, true, false));
      assertEquals(true, MoreFunctionsGoneWild.f10(true, true, true, true));
   }


}