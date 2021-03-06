import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MoreFunctionsGoneWildTest extends junit.framework.TestCase
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
}