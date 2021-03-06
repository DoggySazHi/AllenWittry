import java.util.*;

/**
 * The test class AllProgramTest.
 *
 * @author  Don Allen
 * @version (a version number or a date)
 */
public class AllProgramTest extends junit.framework.TestCase
{
   public void testFunctionsGoneWildPartIII00()
   {
      assertEquals(3001, FunctionsGoneWildPartIII.f1(12));
      assertEquals( 28.20085, FunctionsGoneWildPartIII.f2(1, 4), 0.05);
      assertEquals( 5.2293327, FunctionsGoneWildPartIII.f3(50, 2, 1), 0.05);
      assertEquals( 102.26664, FunctionsGoneWildPartIII.f4(6, 4, 2),  0.25);
      assertEquals( 6.55907, FunctionsGoneWildPartIII.f5(5, 5), 0.05);
      assertEquals( 200.4808, FunctionsGoneWildPartIII.f5(1, 5), 0.05);
      assertEquals( -133.28760, FunctionsGoneWildPartIII.f6(1., 2., 3.), 0.05);
      assertEquals(true, FunctionsGoneWildPartIII.f7(false, true, false));
      assertEquals(true, FunctionsGoneWildPartIII.f8(false, true, false, true));
      assertEquals(2395425.206, FunctionsGoneWildPartIII.f9(8.7, 4.9, 4.8, 3.1, 24.3), 0.5);
      assertEquals(true, FunctionsGoneWildPartIII.f10(false, false, true, false, true));
   }

   public void testFunctionsGoneWildPartIII01()
   {
      assertEquals(31, FunctionsGoneWildPartIII.f1(2));
      assertEquals(49, FunctionsGoneWildPartIII.f1(3));
      assertEquals(2281, FunctionsGoneWildPartIII.f1(11));
      assertEquals(3001, FunctionsGoneWildPartIII.f1(12));
      assertEquals(4867, FunctionsGoneWildPartIII.f1(14));
      assertEquals(6037, FunctionsGoneWildPartIII.f1(15));
      assertEquals(-3493, FunctionsGoneWildPartIII.f1(25));
      assertEquals(29311, FunctionsGoneWildPartIII.f1(26));
      assertEquals(-7105, FunctionsGoneWildPartIII.f1(37));
      assertEquals(-6771, FunctionsGoneWildPartIII.f1(48));
      assertEquals(-4367, FunctionsGoneWildPartIII.f1(60));
      assertEquals(-6820, FunctionsGoneWildPartIII.f1(61));
   }

   public void testFunctionsGoneWildPartIII02()
   {
      assertEquals( -51.77998, FunctionsGoneWildPartIII.f2(-14, -2), 0.05);
      assertEquals( -185.985623,  FunctionsGoneWildPartIII.f2(-14, -9), 0.05);
      assertEquals( 416143.7325, FunctionsGoneWildPartIII.f2(100, 147), 0.05);
      assertEquals( 28.20085, FunctionsGoneWildPartIII.f2(1, 4), 0.05);
      assertEquals( -0.34961, FunctionsGoneWildPartIII.f2(-5, -2), 0.05);
      assertEquals( -11.55167, FunctionsGoneWildPartIII.f2(-5, 4), 0.05);  // cannot include 0 -> divide by zero
      assertEquals( 5.631349, FunctionsGoneWildPartIII.f2(-1, 8), 0.05);
      assertEquals( -0.00146, FunctionsGoneWildPartIII.f2(21, 31), 0.05);
   }

   public void testFunctionsGoneWildPartIII03()
   {
      assertEquals( 5.2293327, FunctionsGoneWildPartIII.f3(50, 2, 1), 0.05);
      assertEquals( 28.07598,  FunctionsGoneWildPartIII.f3(5, 10, 2), 0.05);
      assertEquals( 690.233523, FunctionsGoneWildPartIII.f3(15, 20, 3), 0.05);
      assertEquals( 15.3312379, FunctionsGoneWildPartIII.f3(3, 3, 3), 0.05);
      assertEquals( 49.748290, FunctionsGoneWildPartIII.f3(6, 4, 11), 0.05);
      assertEquals( 9.111018, FunctionsGoneWildPartIII.f3(5, 0, 1), 0.05);
   }

   public void testFunctionsGoneWildPartIII04()
   {
      assertEquals( 102.26664, FunctionsGoneWildPartIII.f4(6, 4, 2), 0.25);
      assertEquals( 91.77026, FunctionsGoneWildPartIII.f4(10, 14, 5), 0.25);
      assertEquals( 104.6982, FunctionsGoneWildPartIII.f4(11, 0, 21), 0.25);
      assertEquals( 111.52787, FunctionsGoneWildPartIII.f4(3, 11, 0), 0.25);
      assertEquals( 99.72469, FunctionsGoneWildPartIII.f4(99, 25, 0), 0.25);
      assertEquals( 151.6096, FunctionsGoneWildPartIII.f4(1, 55, 10), 0.25);
      assertEquals( 121.807, FunctionsGoneWildPartIII.f4(1, Math.PI, Math.E), 0.25);
   }

   public void testFunctionsGoneWildPartIII05()
   {
// a^b > PI^a
      assertEquals( 6.55907, FunctionsGoneWildPartIII.f5(5, 5),  0.05);
      assertEquals( 7.81821, FunctionsGoneWildPartIII.f5(15, 7), 0.05);
      assertEquals( 6.92431, FunctionsGoneWildPartIII.f5(8, 5), 0.05);
      assertEquals( 3.81678, FunctionsGoneWildPartIII.f5(10, 5), 0.05);
      assertEquals( 5.64493, FunctionsGoneWildPartIII.f5(2, 4), 0.05);
// a^b <= PI^a
      assertEquals( 200.4808, FunctionsGoneWildPartIII.f5(1, 5), 0.05);
      assertEquals( 5.320, FunctionsGoneWildPartIII.f5(10, 4), 0.05);
      assertEquals( 5.1969, FunctionsGoneWildPartIII.f5(20, 3), 0.05);
      assertEquals( 8.4034, FunctionsGoneWildPartIII.f5(2, 3), 0.05);
      assertEquals( 5.1229, FunctionsGoneWildPartIII.f5(4, 2), 0.05);
      assertEquals( 4.729, FunctionsGoneWildPartIII.f5(11, 1), 0.05);
      assertEquals( 3.33, FunctionsGoneWildPartIII.f5(21, 0), 0.05);
      assertEquals( 2532.9715, FunctionsGoneWildPartIII.f5(1, 13), 0.05);
   }

   public void testFunctionsGoneWildPartIII06()
   {
      assertEquals( -133.28760, FunctionsGoneWildPartIII.f6(1., 2., 3.), 0.05);
      assertEquals( 5302.66473, FunctionsGoneWildPartIII.f6(5, .77, 7/3.), 0.05);
      assertEquals( 6.307414, FunctionsGoneWildPartIII.f6(Math.sqrt(2), 1.2, 9./31), 0.05);
      assertEquals( 9.05334, FunctionsGoneWildPartIII.f6(11./7, 73/21., 3.), 0.05);
      assertEquals( 130.4960, FunctionsGoneWildPartIII.f6(1./2, Math.sqrt(3), Math.PI), 0.05);
      assertEquals( -0.568377, FunctionsGoneWildPartIII.f6(1., 0., 1.), 0.05);
   }

   public void testFunctionsGoneWildPartIII07()
   {
      assertEquals(false, FunctionsGoneWildPartIII.f7(false, false, false));
      assertEquals(false, FunctionsGoneWildPartIII.f7(false, false, true));
      assertEquals(true, FunctionsGoneWildPartIII.f7(false, true, false));
      assertEquals(false, FunctionsGoneWildPartIII.f7(false, true, true));

      assertEquals(true, FunctionsGoneWildPartIII.f7(true, false, false));
      assertEquals(true, FunctionsGoneWildPartIII.f7(true, false, true));
      assertEquals(true, FunctionsGoneWildPartIII.f7(true, true, false));
      assertEquals(false, FunctionsGoneWildPartIII.f7(true, true, true));
   }

   public void testFunctionsGoneWildPartIII08()
   {
      assertEquals(false, FunctionsGoneWildPartIII.f8(false, false, false, false));
      assertEquals(false, FunctionsGoneWildPartIII.f8(false, false, false, true));
      assertEquals(false, FunctionsGoneWildPartIII.f8(false, false, true, false));
      assertEquals(true, FunctionsGoneWildPartIII.f8(false, false, true, true));
      assertEquals(true, FunctionsGoneWildPartIII.f8(false, true, false, false));
      assertEquals(true, FunctionsGoneWildPartIII.f8(false, true, false, true));
      assertEquals(true, FunctionsGoneWildPartIII.f8(false, true, true, false));
      assertEquals(false, FunctionsGoneWildPartIII.f8(false, true, true, true));
      
      assertEquals(false, FunctionsGoneWildPartIII.f8(true, false, false, false));
      assertEquals(true, FunctionsGoneWildPartIII.f8(true, false, false, true));
      assertEquals(false, FunctionsGoneWildPartIII.f8(true, false, true, false));
      assertEquals(true, FunctionsGoneWildPartIII.f8(true, false, true, true));
      assertEquals(false, FunctionsGoneWildPartIII.f8(true, true, false, false));
      assertEquals(true, FunctionsGoneWildPartIII.f8(true, true, false, true));
      assertEquals(false, FunctionsGoneWildPartIII.f8(true, true, true, false));
      assertEquals(true, FunctionsGoneWildPartIII.f8(true, true, true, true));
   }

   public void testFunctionsGoneWildPartIII09()
   {
//   8.691612777994472 4.981520633329909 4.805871559401717 3.1180634783838626 24.313659957547003 634430.9614759745
      assertEquals( 634430.9614759, FunctionsGoneWildPartIII.f9(8.691612777994472, 4.981520633329909,
                                4.805871559401717, 3.1180634783838626, 24.313659957547003), 0.5);
//   2.484671694984233 6.253144630893522 1.0631928961105308 29.74995372036117 23.04363218761831 3670695.6754352716
      assertEquals( 3670695.6754352716, FunctionsGoneWildPartIII.f9(2.484671694984233, 6.253144630893522,
                                1.0631928961105308, 29.74995372036117, 23.04363218761831), 0.5);
//   0.032934059226121803 11.314616385575833 1.4420408304623789 9.239745791496718 27.064783978059463 840694.7307079892
      assertEquals( 840694.7307079892, FunctionsGoneWildPartIII.f9(0.032934059226121803, 11.314616385575833,
                                1.4420408304623789, 9.239745791496718, 27.064783978059463), 0.5);
//   6.924132679125553 8.058647794617956 1.4404817873442577 26.21443254678289 11.218636574692692 766343.1413232929
      assertEquals( 766343.1413232929, FunctionsGoneWildPartIII.f9(6.924132679125553, 8.058647794617956,
                                1.4404817873442577, 26.21443254678289, 11.218636574692692), 0.5);
//   21.268029440687 3.732419792839765 1.5176828734563708 7.482167563673365 20.853904870516892 2217037.109201724
      assertEquals( 2217037.109201724, FunctionsGoneWildPartIII.f9(21.268029440687, 3.732419792839765,
                                1.5176828734563708, 7.482167563673365, 20.853904870516892), 0.5);

      assertEquals( 4185440.176623337, FunctionsGoneWildPartIII.f9(6.313551283204704, 9.059556749278055,
                                1.1600657999203179, 17.137741986797142, 9.048263968492186), 0.5); 
   }

   public void testFunctionsGoneWildPartIII10()
   {
      assertEquals(false, FunctionsGoneWildPartIII.f10(false, false, false, false, false));
      assertEquals(false, FunctionsGoneWildPartIII.f10(false, false, false, false, true));
      assertEquals(false, FunctionsGoneWildPartIII.f10(false, false, false, true, false));
      assertEquals(true, FunctionsGoneWildPartIII.f10(false, false, false, true, true));
      assertEquals(true, FunctionsGoneWildPartIII.f10(false, false, true, false, false));
      assertEquals(true, FunctionsGoneWildPartIII.f10(false, false, true, false, true));
      assertEquals(true, FunctionsGoneWildPartIII.f10(false, false, true, true, false));
      assertEquals(true, FunctionsGoneWildPartIII.f10(false, false, true, true, true));

      assertEquals(false, FunctionsGoneWildPartIII.f10(false, true, false, false, false));
      assertEquals(false, FunctionsGoneWildPartIII.f10(false, true, false, false, true));
      assertEquals(false, FunctionsGoneWildPartIII.f10(false, true, false, true, false));
      assertEquals(true, FunctionsGoneWildPartIII.f10(false, true, false, true, true));
      assertEquals(true, FunctionsGoneWildPartIII.f10(false, true, true, false, false));
      assertEquals(true, FunctionsGoneWildPartIII.f10(false, true, true, false, true));
      assertEquals(true, FunctionsGoneWildPartIII.f10(false, true, true, true, false));
      assertEquals(true, FunctionsGoneWildPartIII.f10(false, true, true, true, true));

      assertEquals(true, FunctionsGoneWildPartIII.f10(true, false, false, false, false));
      assertEquals(true, FunctionsGoneWildPartIII.f10(true, false, false, false, true));
      assertEquals(true, FunctionsGoneWildPartIII.f10(true, false, false, true, false));
      assertEquals(true, FunctionsGoneWildPartIII.f10(true, false, false, true, true));
      assertEquals(true, FunctionsGoneWildPartIII.f10(true, false, true, false, false));
      assertEquals(true, FunctionsGoneWildPartIII.f10(true, false, true, false, true));
      assertEquals(true, FunctionsGoneWildPartIII.f10(true, false, true, true, false));
      assertEquals(true, FunctionsGoneWildPartIII.f10(true, false, true, true, true));

      assertEquals(true, FunctionsGoneWildPartIII.f10(true, true, false, false, false));
      assertEquals(true, FunctionsGoneWildPartIII.f10(true, true, false, false, true));
      assertEquals(true, FunctionsGoneWildPartIII.f10(true, true, false, true, false));
      assertEquals(true, FunctionsGoneWildPartIII.f10(true, true, false, true, true));
      assertEquals(false, FunctionsGoneWildPartIII.f10(true, true, true, false, false));
      assertEquals(true, FunctionsGoneWildPartIII.f10(true, true, true, false, true));
      assertEquals(true, FunctionsGoneWildPartIII.f10(true, true, true, true, false));
      assertEquals(true, FunctionsGoneWildPartIII.f10(true, true, true, true, true));
   }

   public void testFunctionsGoneWildPartIII11()
   {
      testFunctionsGoneWildPartIII01();
      testFunctionsGoneWildPartIII02();
      testFunctionsGoneWildPartIII03();
      testFunctionsGoneWildPartIII04();
   }

   public void testMoreFunctionsGoneWild12()
   {
      testFunctionsGoneWildPartIII05();
      testFunctionsGoneWildPartIII06();
      testFunctionsGoneWildPartIII07();
      testFunctionsGoneWildPartIII08();
   }

   public void testFunctionsGoneWildPartIII13()
   {
      testFunctionsGoneWildPartIII09();
      testFunctionsGoneWildPartIII10();
   }

   public void testFunctionsGoneWildPartIII14()
   {
      testFunctionsGoneWildPartIII11();
      testMoreFunctionsGoneWild12();
      testFunctionsGoneWildPartIII13();
   }

   public void testMonsterYear01()
   {
       assertEquals(true, MonsterYear.isMonsterYear(1978));
       assertEquals(false, MonsterYear.isMonsterYear(1979));

       int[] temp = MonsterYear.getMonsterYearBetween(1800, 2000);
       int[] ans = {1868, 1978};
       assertEquals(ans.length, temp.length);
       for (int k = 0; k < ans.length; k++)
          assertEquals(ans[k], temp[k]);
   }

   public void testMonsterYear02()
   {
       assertEquals(true, MonsterYear.isMonsterYear(2417));
       assertEquals(true, MonsterYear.isMonsterYear(1318));
       assertEquals(true, MonsterYear.isMonsterYear(5604));
       assertEquals(true, MonsterYear.isMonsterYear(6813));

       assertEquals(false, MonsterYear.isMonsterYear(2417+1));
       assertEquals(false, MonsterYear.isMonsterYear(2417-1));
       assertEquals(false, MonsterYear.isMonsterYear(1318+1));
       assertEquals(false, MonsterYear.isMonsterYear(1318-1));
       assertEquals(false, MonsterYear.isMonsterYear(5604+1));
       assertEquals(false, MonsterYear.isMonsterYear(6813+1));

   }

   public void testMonsterYear03()
   {
       int[] temp = MonsterYear.getMonsterYearBetween(5935, 9999);
       int[] ans = {6703, 6813, 6923, 7802, 7912, 8901};
       assertEquals(ans.length, temp.length);
       for (int k = 0; k < ans.length; k++)
          assertEquals(ans[k], temp[k]);
   }

   public void testMonsterYear04()
   {
      testMonsterYear02();
      testMonsterYear03();
   }

   public void testMonsterYear05()
   {
       assertEquals(true, MonsterYear.isMonsterYear(1428));
       assertEquals(true, MonsterYear.isMonsterYear(4725));
       assertEquals(true, MonsterYear.isMonsterYear(5934));
       assertEquals(true, MonsterYear.isMonsterYear(2307));
       assertEquals(true, MonsterYear.isMonsterYear(5604));
       assertEquals(true, MonsterYear.isMonsterYear(1868));

       assertEquals(false, MonsterYear.isMonsterYear(1428+1));
       assertEquals(false, MonsterYear.isMonsterYear(1428-1));
       assertEquals(false, MonsterYear.isMonsterYear(4725+1));
       assertEquals(false, MonsterYear.isMonsterYear(4725-1));
       assertEquals(false, MonsterYear.isMonsterYear(5934+1));
       assertEquals(false, MonsterYear.isMonsterYear(2307+1));
       assertEquals(false, MonsterYear.isMonsterYear(5604+1));
       assertEquals(false, MonsterYear.isMonsterYear(1868-1));
   }

   public void testMonsterYear06()
   {
       int[] temp = MonsterYear.getMonsterYearBetween(1000, 1999);
       int[] ans = {1208, 1318, 1428, 1538, 1648, 1758, 1868, 1978};
       assertEquals(ans.length, temp.length);
       for (int k = 0; k < ans.length; k++)
          assertEquals(ans[k], temp[k]);
   }

   public void testMonsterYear07()
   {
      testMonsterYear04();
      testMonsterYear05();
      testMonsterYear06();
   }

   public void testMonsterYear08()
   {
       assertEquals(true, MonsterYear.isMonsterYear(2637));
       assertEquals(true, MonsterYear.isMonsterYear(2747));
       assertEquals(true, MonsterYear.isMonsterYear(2857));
       assertEquals(true, MonsterYear.isMonsterYear(2967));
       assertEquals(true, MonsterYear.isMonsterYear(3406));
       assertEquals(true, MonsterYear.isMonsterYear(5824));
       assertEquals(true, MonsterYear.isMonsterYear(4615));
       assertEquals(true, MonsterYear.isMonsterYear(4945));
       assertEquals(true, MonsterYear.isMonsterYear(3956));

       assertEquals(false, MonsterYear.isMonsterYear(2637+1));
       assertEquals(false, MonsterYear.isMonsterYear(2747-1));
       assertEquals(false, MonsterYear.isMonsterYear(2857+1));
       assertEquals(false, MonsterYear.isMonsterYear(2967-1));
       assertEquals(false, MonsterYear.isMonsterYear(3406+1));
       assertEquals(false, MonsterYear.isMonsterYear(5824+1));
       assertEquals(false, MonsterYear.isMonsterYear(4615+1));
       assertEquals(false, MonsterYear.isMonsterYear(4945-1));
   }

   public void testMonsterYear09()
   {
       int[] temp = MonsterYear.getMonsterYearBetween(2999, 4011);
       int[] ans = {3406, 3516, 3626, 3736, 3846, 3956};
       assertEquals(ans.length, temp.length);
       for (int k = 0; k < ans.length; k++)
          assertEquals(ans[k], temp[k]);
   }

   public void testMonsterYear10()
   {
      assertEquals(true, MonsterYear.isMonsterYear(4505));
      assertEquals(true, MonsterYear.isMonsterYear(4835));
      assertEquals(true, MonsterYear.isMonsterYear(5714));

      assertEquals(false, MonsterYear.isMonsterYear(5714+1));
      assertEquals(false, MonsterYear.isMonsterYear(4835-1));
      assertEquals(false, MonsterYear.isMonsterYear(4505+1));

      testMonsterYear07();
      testMonsterYear08();
      testMonsterYear09();
   }

   public void testNagelPoint01()
   {
      Point x = new Point(0, 0);
      Point y = new Point(8, 0);
      Point z = new Point(8, 6);
      NagelPoint np = new NagelPoint( x, y, z);
      Point ans = new Point(8, 4);
      assertEquals(ans.getX(), np.getBisectedPerimeterPoint(x, y, z).getX(), 0.05);
      assertEquals(ans.getY(), np.getBisectedPerimeterPoint(x, y, z).getY(), 0.05);
      ans = new Point(3.2, 2.4);
      assertEquals(ans.getX(), np.getBisectedPerimeterPoint(y, z, x).getX(), 0.05);
      assertEquals(ans.getY(), np.getBisectedPerimeterPoint(y, z, x).getY(), 0.05);
      double per = np.getPerimeter();
      assertEquals(8+6+10, np.getPerimeter(), 0.02);

      Point nagelPoint = np.getNagelPoint();
      assertEquals(2, nagelPoint.getY(), 0.02);
      assertEquals(4, nagelPoint.getX(), 0.02);
   }

   public void testNagelPoint02()    //  perimeter
   {
      Point x = new Point(1, 1);
      Point y = new Point(5, 2);
      Point z = new Point(3, 4);
      NagelPoint np = new NagelPoint( x, y, z);
      double per = np.getPerimeter();
      assertEquals(Math.sqrt(17) + Math.sqrt(8) + Math.sqrt(13), per, 0.02);

      x = new Point(-31, 12);
      y = new Point(5, -21);
      z = new Point(-3, 41);
      np = new NagelPoint( x, y, z);
      per = np.getPerimeter();
      assertEquals(Math.sqrt(33*33+36*36) + Math.sqrt(62*62+8*8) + Math.sqrt(29*29+28*28), per, 0.02);

      x = new Point(73, 121);
      y = new Point(-157, -211);
      z = new Point(307, -421);
      np = new NagelPoint( x, y, z);
      per = np.getPerimeter();
      assertEquals(Math.sqrt(230*230+332*332) + Math.sqrt(464*464+210*210) + Math.sqrt(234*234+542*542), per, 0.02);
   }
   
   public void testNagelPoint03()      //  biscetedPerimeterPoint 

   {
      Point x = new Point(1, 1);
      Point y = new Point(5, 2);
      Point z = new Point(3, 4);
      NagelPoint np = new NagelPoint( x, y, z);

      Point ans1 = new Point(4.182983095, 2.817016905);
      assertEquals(ans1.getX(), np.getBisectedPerimeterPoint(x, y, z).getX(), 0.05);
      assertEquals(ans1.getY(), np.getBisectedPerimeterPoint(x, y, z).getY(), 0.05);
      ans1 = new Point(1.640920791, 1.961381186);
      assertEquals(ans1.getX(), np.getBisectedPerimeterPoint(y, z, x).getX(), 0.05);
      assertEquals(ans1.getY(), np.getBisectedPerimeterPoint(y, z, x).getY(), 0.05);
      
      double per = Math.sqrt(17)+Math.sqrt(8)+Math.sqrt(13);
      double delta = per / 2. - Math.sqrt(8);
      Point ans2 = new Point(z.getX()+delta/Math.sqrt(13)*-2, z.getY()+delta/Math.sqrt(13)*-3);
      assertEquals(ans2.getX(), np.getBisectedPerimeterPoint(y, z, x).getX(), 0.05);
      assertEquals(ans2.getY(), np.getBisectedPerimeterPoint(y, z, x).getY(), 0.05);

      Point x1 = new Point(1, -2);
      Point x2 = new Point(4, 7);
      Point y1 = new Point(-5, 0);
      Point y2 = new Point(7, 6);

      Point ans = new Point(3, 4);
      Point interPt =  np.getIntersection(x1, x2, y1, y2);
      assertEquals(ans.getX(), interPt.getX(), 0.05);
      assertEquals(ans.getY(), interPt.getY(), 0.05);
   }

   public void testNagelPoint04()    // intersection   
   {
      Point x1 = new Point(1, -2);
      Point x2 = new Point(4, 7);
      Point y1 = new Point(-5, 0);
      Point y2 = new Point(7, 6);
      NagelPoint np = new NagelPoint( x1, y1, y1);
      
      Point ans = new Point(3, 4);
      Point interPt =  np.getIntersection(x1, x2, y1, y2);
      assertEquals(ans.getX(), interPt.getX(), 0.05);
      assertEquals(ans.getY(), interPt.getY(), 0.05);

      ans = new Point(13, 41);
      x1 = new Point(13+23, 41+17);
      x2 = new Point(13-23, 41-17);
      y1 = new Point(13-33, 41+101);
      y2 = new Point(13+33, 41-101);
      interPt =  np.getIntersection(x1, x2, y1, y2);
      assertEquals(ans.getX(), interPt.getX(), 0.05);
      assertEquals(ans.getY(), interPt.getY(), 0.05);

      ans = new Point(-173, 141);
      x1 = new Point(-173+31, 141+75);
      x2 = new Point(-173-31, 141-75);
      y1 = new Point(-173-313, 141+11);
      y2 = new Point(-173+313, 141-11);
      interPt =  np.getIntersection(x1, x2, y1, y2);
      assertEquals(ans.getX(), interPt.getX(), 0.05);
      assertEquals(ans.getY(), interPt.getY(), 0.05);

      ans = new Point(-1073, -1941);
      x1 = new Point(-1073+731, -1941+715);
      x2 = new Point(-1073-731, -1941-715);
      y1 = new Point(-1073-31, -1941+191);
      y2 = new Point(-1073+31, -1941-191);
      interPt =  np.getIntersection(x1, x2, y1, y2);
      assertEquals(ans.getX(), interPt.getX(), 0.05);
      assertEquals(ans.getY(), interPt.getY(), 0.05);
   }

   public void testNagelPoint05()
   {
      testNagelPoint02();
      testNagelPoint04();
   }

   public void testNagelPoint06()
   {
      testNagelPoint05();
      testNagelPoint03();
   }

   public void testNagelPoint07()    // Nagel Point and Intersection
   {
      Point x = new Point(1, 1);
      Point y = new Point(5, 2);
      Point z = new Point(3, 4);
      NagelPoint np = new NagelPoint( x, y, z);

      Point nagelPoint = np.getNagelPoint();
      assertEquals(2.700, nagelPoint.getX(), 0.02);
      assertEquals(1.97362110347, nagelPoint.getY(), 0.02);

      Point x1 = new Point(1, -2);
      Point x2 = new Point(4, 7);
      Point y1 = new Point(-5, 0);
      Point y2 = new Point(7, 6);

      Point ans = new Point(3, 4);
      Point interPt =  np.getIntersection(x1, x2, y1, y2);
      assertEquals(ans.getX(), interPt.getX(), 0.05);
      assertEquals(ans.getY(), interPt.getY(), 0.05);
    }

   public void testNagelPoint08()  //  Nagel Point & perimeter & bisceted perimeter
   {
      Point x = new Point(-4, 0);
      Point y = new Point(4, 0);
      Point z = new Point(0, 4*Math.sqrt(3));
      NagelPoint np = new NagelPoint( x, y, z);
      Point ans = new Point(2, 2*Math.sqrt(3));
      assertEquals(ans.getX(), np.getBisectedPerimeterPoint(x, y, z).getX(), 0.05);
      assertEquals(ans.getY(), np.getBisectedPerimeterPoint(x, y, z).getY(), 0.05);
      ans = new Point(-2, 2*Math.sqrt(3));
      assertEquals(ans.getX(), np.getBisectedPerimeterPoint(y, z, x).getX(), 0.05);
      assertEquals(ans.getY(), np.getBisectedPerimeterPoint(y, z, x).getY(), 0.05);
      double per = np.getPerimeter();
      assertEquals(24, np.getPerimeter(), 0.02);

      Point nagelPoint = np.getNagelPoint();
      assertEquals(0, nagelPoint.getX(), 0.02);
      assertEquals(4*Math.sqrt(3)/3., nagelPoint.getY(), 0.02);
   }

   public void testNagelPoint09()
   {
      Point x = new Point(11, 17);
      Point y = new Point(23, 11);
      Point z = new Point(31, 23);
      NagelPoint np = new NagelPoint( x, y, z);
      double per = np.getPerimeter();
      assertEquals(6*Math.sqrt(5)+4*Math.sqrt(13)+2*Math.sqrt(109), np.getPerimeter(), 0.02);
      Point ans = new Point(23+6.07019803, 11+9.10529705);
      assertEquals(ans.getX(), np.getBisectedPerimeterPoint(x, y, z).getX(), 0.05);
      assertEquals(ans.getY(), np.getBisectedPerimeterPoint(x, y, z).getY(), 0.05);
      ans = new Point(14.11171217, 15.44414401);
      assertEquals(ans.getX(), np.getBisectedPerimeterPoint(z, x, y).getX(), 0.05);
      assertEquals(ans.getY(), np.getBisectedPerimeterPoint(z, x, y).getY(), 0.05);

      Point nagelPoint = np.getNagelPoint();
      assertEquals(21.69853174, nagelPoint.getX(), 0.02);
      assertEquals(18.83850332, nagelPoint.getY(), 0.02);
   }

   public void testNagelPoint10()  //  Nagel Point & perimeter & bisceted perimeter
   {
      int[] dx = {11, -13, 21, -6, 0, 71};
      int[] dy = {11, -13, 21, -6, 0, 71};
      for (int j = 0; j < dx.length; j++)
      {
         Point x = new Point(-4+dx[j], dy[j]);
         Point y = new Point(4+dx[j], dy[j]);
         Point z = new Point(dx[j], 4*Math.sqrt(3)+dy[j]);
         NagelPoint np = new NagelPoint( x, y, z);
         Point ans = new Point(2+dx[j], 2*Math.sqrt(3)+dx[j]);
         assertEquals(ans.getX(), np.getBisectedPerimeterPoint(x, y, z).getX(), 0.05);
         assertEquals(ans.getY(), np.getBisectedPerimeterPoint(x, y, z).getY(), 0.05);
         ans = new Point(-2+dx[j], dy[j]+2*Math.sqrt(3));
         assertEquals(ans.getX(), np.getBisectedPerimeterPoint(y, z, x).getX(), 0.05);
         assertEquals(ans.getY(), np.getBisectedPerimeterPoint(y, z, x).getY(), 0.05);
         double per = np.getPerimeter();
         assertEquals(24, np.getPerimeter(), 0.02);

         Point nagelPoint = np.getNagelPoint();
         assertEquals(dx[j], nagelPoint.getX(), 0.02);
         assertEquals(dy[j]+4*Math.sqrt(3)/3., nagelPoint.getY(), 0.02);
      }
   }
   
   public void testBadToTheBone01()
   {
      ArrayList<Domino> dom = new ArrayList<Domino>();
      dom.add(new Domino(4, 0));
      dom.add(new Domino(2, 3));
      dom.add(new Domino(1, 5));
      dom.add(new Domino(5, 2));
      dom.add(new Domino(3, 4));
      dom.add(new Domino(4, 1));
      BadToTheBone bb = new BadToTheBone(dom);
      ArrayList<Domino> sol = new ArrayList<Domino>();
      sol.add(new Domino(4, 0));
      sol.add(new Domino(4, 1));
      assertEquals(true, bb.containsMatchingEdges());
      assertEquals(sol.size(), bb.processDraw().length);

      Domino[] temp = bb.processDraw();
      int i = 0;
      for (Domino d : temp)
      {
         assertEquals(d, sol.get(i));
         i++;
      }
   }

   public void testBadToTheBone02()
   {
      ArrayList<Domino> dom = new ArrayList<Domino>();
      dom.add(new Domino(4, 6));
      dom.add(new Domino(2, 3));
      dom.add(new Domino(1, 5));
      dom.add(new Domino(6, 2));
      dom.add(new Domino(3, 4));
      dom.add(new Domino(2, 1));
      BadToTheBone bb = new BadToTheBone(dom);
      assertEquals(false, bb.containsMatchingEdges());

      dom = new ArrayList<Domino>();
      dom.add(new Domino(1, 4));
      dom.add(new Domino(0, 6));
      dom.add(new Domino(5, 3));
      dom.add(new Domino(3, 4));
      dom.add(new Domino(2, 5));
      dom.add(new Domino(5, 0));
      dom.add(new Domino(6, 6));
      dom.add(new Domino(4, 2));
      dom.add(new Domino(3, 6));
      bb = new BadToTheBone(dom);
      assertEquals(true, bb.containsMatchingEdges());
   }

   public void testBadToTheBone03()
   {
      ArrayList<Domino> dom = new ArrayList<Domino>();
      dom.add(new Domino(4, 6));
      dom.add(new Domino(2, 3));
      dom.add(new Domino(1, 5));
      dom.add(new Domino(6, 2));
      dom.add(new Domino(3, 4));
      dom.add(new Domino(2, 1));
      BadToTheBone bb = new BadToTheBone(dom);
      ArrayList<Domino> sol = new ArrayList<Domino>();
      sol.add(new Domino(4, 6));
      sol.add(new Domino(2, 3));
      sol.add(new Domino(1, 5));
      sol.add(new Domino(6, 2));
      sol.add(new Domino(3, 4));
      sol.add(new Domino(2, 1));

      Domino[] temp = bb.processDraw();
      assertEquals(sol.size(), temp.length);
      int i = 0;
      for (Domino d : temp)
      {
         assertEquals(d, sol.get(i));
         i++;
      }

      dom = new ArrayList<Domino>();
      dom.add(new Domino(1, 4));
      dom.add(new Domino(0, 6));
      dom.add(new Domino(5, 3));
      dom.add(new Domino(3, 4));
      dom.add(new Domino(2, 5));
      dom.add(new Domino(5, 0));
      dom.add(new Domino(6, 6));
      dom.add(new Domino(4, 2));
      dom.add(new Domino(3, 6));
      bb = new BadToTheBone(dom);
      sol = new ArrayList<Domino>();
      sol.add(new Domino(3, 6));

      temp = bb.processDraw();
      assertEquals(sol.size(), temp.length);
      i = 0;
      for (Domino d : temp)
      {
         assertEquals(d, sol.get(i));
         i++;
      }
   }

   public void testBadToTheBone04()
   {
      testBadToTheBone02();
      testBadToTheBone03();
   }

   public void testBadToTheBone05()
   {
      ArrayList<Domino> dom = new ArrayList<Domino>();
      dom.add(new Domino(4, 3));
      dom.add(new Domino(2, 3));
      dom.add(new Domino(1, 2));
      dom.add(new Domino(1, 6));
      dom.add(new Domino(3, 4));
      dom.add(new Domino(3, 0));
      BadToTheBone bb = new BadToTheBone(dom);
      assertEquals(false, bb.containsMatchingEdges());

      dom = new ArrayList<Domino>();
      dom.add(new Domino(0, 0));
      dom.add(new Domino(1, 1));
      dom.add(new Domino(5, 4));
      dom.add(new Domino(2, 3));
      dom.add(new Domino(5, 1));
      dom.add(new Domino(1, 5));
      dom.add(new Domino(3, 6));
      dom.add(new Domino(4, 0));
      dom.add(new Domino(1, 2));
      dom.add(new Domino(3, 3));
      bb = new BadToTheBone(dom);
      assertEquals(true, bb.containsMatchingEdges());
   }

   public void testBadToTheBone06()
   {
      ArrayList<Domino> dom = new ArrayList<Domino>();
      dom.add(new Domino(4, 3));
      dom.add(new Domino(2, 3));
      dom.add(new Domino(1, 2));
      dom.add(new Domino(1, 6));
      dom.add(new Domino(3, 4));
      dom.add(new Domino(3, 0));
      BadToTheBone bb = new BadToTheBone(dom);
      ArrayList<Domino> sol = new ArrayList<Domino>();
      sol.add(new Domino(4, 3));
      sol.add(new Domino(2, 3));
      sol.add(new Domino(1, 2));
      sol.add(new Domino(1, 6));
      sol.add(new Domino(3, 4));
      sol.add(new Domino(3, 0));

      Domino[] temp = bb.processDraw();
      assertEquals(sol.size(), temp.length);
      int i = 0;
      for (Domino d : temp)
      {
         assertEquals(d, sol.get(i));
         i++;
      }

      dom = new ArrayList<Domino>();
      dom.add(new Domino(0, 0));
      dom.add(new Domino(1, 1));
      dom.add(new Domino(5, 4));
      dom.add(new Domino(2, 3));
      dom.add(new Domino(5, 1));
      dom.add(new Domino(1, 5));
      dom.add(new Domino(3, 6));
      dom.add(new Domino(4, 0));
      dom.add(new Domino(1, 2));
      dom.add(new Domino(3, 3));
      bb = new BadToTheBone(dom);
      sol = new ArrayList<Domino>();
      sol.add(new Domino(0, 0));
      sol.add(new Domino(3, 3));

      temp = bb.processDraw();
      assertEquals(sol.size(), temp.length);
      i = 0;
      for (Domino d : temp)
      {
         assertEquals(d, sol.get(i));
         i++;
      }
   }

   public void testBadToTheBone07()
   {
      testBadToTheBone05();
      testBadToTheBone06();
   }

// need modification   
   public void testBadToTheBone08()
   {
      ArrayList<Domino> dom = new ArrayList<Domino>();
      dom.add(new Domino(0, 1));
      dom.add(new Domino(0, 2));
      dom.add(new Domino(1, 2));
      dom.add(new Domino(0, 0));
      dom.add(new Domino(2, 1));
      dom.add(new Domino(3, 2));
      dom.add(new Domino(3, 1));
      dom.add(new Domino(0, 3));
      dom.add(new Domino(1, 3));
      dom.add(new Domino(2, 2));
      dom.add(new Domino(4, 2));
      dom.add(new Domino(3, 4));
      BadToTheBone bb = new BadToTheBone(dom);
      assertEquals(false, bb.containsMatchingEdges());

      dom.add(1, new Domino(1, 0));
      bb = new BadToTheBone(dom);
      assertEquals(true, bb.containsMatchingEdges());

      dom.add(1, new Domino(4, 1));
      bb = new BadToTheBone(dom);
      assertEquals(true, bb.containsMatchingEdges());

      dom.add(3, new Domino(3, 5));
      bb = new BadToTheBone(dom);
      assertEquals(true, bb.containsMatchingEdges());

      dom.add(2, new Domino(5, 3));
      bb = new BadToTheBone(dom);
      assertEquals(false, bb.containsMatchingEdges());
   }

   public void testBadToTheBone09()
   {
      ArrayList<Domino> dom = new ArrayList<Domino>();
      dom.add(new Domino(0, 1));
      dom.add(new Domino(0, 2));
      dom.add(new Domino(1, 2));
      dom.add(new Domino(0, 0));
      dom.add(new Domino(2, 1));
      dom.add(new Domino(3, 2));
      dom.add(new Domino(3, 1));
      dom.add(new Domino(0, 3));
      dom.add(new Domino(1, 3));
      dom.add(new Domino(2, 2));
      dom.add(new Domino(4, 2));
      dom.add(new Domino(3, 4));
      BadToTheBone bb = new BadToTheBone(dom);
      ArrayList<Domino> sol = new ArrayList<Domino>();
      sol.add(new Domino(0, 1));
      sol.add(new Domino(0, 2));
      sol.add(new Domino(1, 2));
      sol.add(new Domino(0, 0));
      sol.add(new Domino(2, 1));
      sol.add(new Domino(3, 2));
      sol.add(new Domino(3, 1));
      sol.add(new Domino(0, 3));
      sol.add(new Domino(1, 3));
      sol.add(new Domino(2, 2));
      sol.add(new Domino(4, 2));
      sol.add(new Domino(3, 4));

      Domino[] temp = bb.processDraw();
      assertEquals(sol.size(), temp.length);
      int i = 0;
      for (Domino d : temp)
      {
         assertEquals(d, sol.get(i));
         i++;
      }

      dom.add(1, new Domino(1, 0));
      bb = new BadToTheBone(dom);
      sol = new ArrayList<Domino>();
      sol.add(new Domino(0, 2));
      sol.add(new Domino(1, 2));
      sol.add(new Domino(0, 0));
      sol.add(new Domino(2, 1));
      sol.add(new Domino(3, 2));
      sol.add(new Domino(3, 1));
      sol.add(new Domino(0, 3));
      sol.add(new Domino(1, 3));
      sol.add(new Domino(2, 2));
      sol.add(new Domino(4, 2));
      sol.add(new Domino(3, 4));

      Domino[] temp1 = bb.processDraw();
      assertEquals(sol.size(), temp1.length);
      i = 0;
      for (Domino d : temp1)
      {
         assertEquals(d, sol.get(i));
         i++;
      }

      dom.add(3, new Domino(4, 1));
      dom.add(5, new Domino(2, 6));
      dom.add(14, new Domino(2, 5));
      dom.add(15, new Domino(2, 6));
      bb = new BadToTheBone(dom);
      bb = new BadToTheBone(dom);
      sol = new ArrayList<Domino>();
      sol.add(new Domino(0, 0));
      sol.add(new Domino(2, 1));
      sol.add(new Domino(3, 2));
      sol.add(new Domino(3, 1));
      sol.add(new Domino(0, 3));

      Domino[] temp2 = bb.processDraw();
      assertEquals(sol.size(), temp2.length);
      i = 0;
      for (Domino d : temp2)
      {
         assertEquals(d, sol.get(i));
         i++;
      }

      dom.add(3, new Domino(3, 5));
      bb = new BadToTheBone(dom);
      assertEquals(true, bb.containsMatchingEdges());
   }

   public void testBadToTheBone10()
   {
      testBadToTheBone07();
      testBadToTheBone08();
      testBadToTheBone09();
   }

   public void testInterestingSequence01()
   {
      AnInterestingSequence seq = new AnInterestingSequence();

      assertEquals(4, seq.numberOfIterations(55));
      assertEquals(7, seq.minValueWithN_Iterations(4));
   }

   public void testInterestingSequence02()
   {
      AnInterestingSequence seq = new AnInterestingSequence();

      assertEquals(4, seq.numberOfIterations(7));
      assertEquals(3, seq.numberOfIterations(77));
      assertEquals(6, seq.numberOfIterations(777));
      assertEquals(4, seq.numberOfIterations(7777));
   }

   public void testInterestingSequence03()
   {
      AnInterestingSequence seq = new AnInterestingSequence();

      assertEquals(2, seq.numberOfIterations(8));
      assertEquals(5, seq.numberOfIterations(88));
      assertEquals(5, seq.numberOfIterations(888));
      assertEquals(5, seq.numberOfIterations(8888));
      assertEquals(5, seq.numberOfIterations(88888));
      assertEquals(4, seq.numberOfIterations(878787));
   }

   public void testInterestingSequence04()
   {
      AnInterestingSequence seq = new AnInterestingSequence();

      assertEquals(4, seq.numberOfIterations(12));
      assertEquals(3, seq.numberOfIterations(123));
      assertEquals(2, seq.numberOfIterations(1234));
      assertEquals(4, seq.numberOfIterations(12345));
      assertEquals(5, seq.numberOfIterations(123456));
      assertEquals(5, seq.numberOfIterations(1234567));
      assertEquals(4, seq.numberOfIterations(12345678));
      assertEquals(6, seq.numberOfIterations(123456789));
   }

   public void testInterestingSequence05()
   {
      AnInterestingSequence seq = new AnInterestingSequence();

      assertEquals(3, seq.numberOfIterations(11));
      assertEquals(4, seq.numberOfIterations(22));
      assertEquals(3, seq.numberOfIterations(33));
      assertEquals(3, seq.numberOfIterations(44));
      assertEquals(4, seq.numberOfIterations(55));
      assertEquals(3, seq.numberOfIterations(66));
      assertEquals(3, seq.numberOfIterations(77));
      assertEquals(5, seq.numberOfIterations(88));
      assertEquals(4, seq.numberOfIterations(99));
   }

   public void testInterestingSequence06()
   {
      AnInterestingSequence seq = new AnInterestingSequence();

      assertEquals(1, seq.numberOfIterations(1));
      assertEquals(1, seq.numberOfIterations(4));
      assertEquals(1, seq.numberOfIterations(9));
      assertEquals(1, seq.numberOfIterations(4*4));
      assertEquals(1, seq.numberOfIterations(5*5));
      assertEquals(1, seq.numberOfIterations(6*6));
      assertEquals(1, seq.numberOfIterations(7*7));
      assertEquals(1, seq.numberOfIterations(8*8));
      assertEquals(1, seq.numberOfIterations(99*99));
      assertEquals(1, seq.numberOfIterations(24*24));
      assertEquals(1, seq.numberOfIterations(53*53));
   }

   public void testInterestingSequence07()
   {
      AnInterestingSequence seq = new AnInterestingSequence();

      assertEquals(3, seq.minValueWithN_Iterations(3));
      assertEquals(23, seq.minValueWithN_Iterations(5));
   }

   public void testInterestingSequence08()
   {
      AnInterestingSequence seq = new AnInterestingSequence();

      assertEquals(7, seq.minValueWithN_Iterations(4));
      assertEquals(167, seq.minValueWithN_Iterations(6));
   }

   public void testInterestingSequence09()
   {
      AnInterestingSequence seq = new AnInterestingSequence();

      assertEquals(7223, seq.minValueWithN_Iterations(7));
      assertEquals(2, seq.minValueWithN_Iterations(2));
      assertEquals(1, seq.minValueWithN_Iterations(1));
   }

   public void testInterestingSequence10()
   {
      testInterestingSequence01();
      testInterestingSequence02();
      testInterestingSequence03();
      testInterestingSequence04();
      testInterestingSequence05();
      testInterestingSequence06();
      testInterestingSequence07();
      testInterestingSequence08();
      testInterestingSequence09();
   }
   
   public void testFaxMachine01()
   {
      assertEquals("011111001000001111111000000",  // 3 8 0 1 14 0 -> 3 7 1 0 1 7 7 0 0
                                      FaxMachine.convertToRLE("0001000000001101000000000000001"));
      assertEquals("111101000000000111110000000",  // 12 0 0 0 13 0 0 -> 7 5 0 0 0 7 6 0 0
                                      FaxMachine.convertToRLE("0000000000001111000000000000011"));
      assertEquals("111101000000000111111001",  // 12 0 0 0 15 -> 7 5 0 0 0 7 7 1
                                      FaxMachine.convertToRLE("0000000000001111000000000000000"));
      assertEquals("111111111111011",  // 31 -> 7 7 7 7 3
                                      FaxMachine.convertToRLE("0000000000000000000000000000000"));
      assertEquals("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                         /* 0 (x32) */      FaxMachine.convertToRLE("1111111111111111111111111111111"));

      assertEquals("0001000000001101000000000000001",  // 3 7 1 0 1 7 7 0 0 -> 3 8 0 1 14 0
                                      FaxMachine.RLEtoFax("011111001000001111111000000"));

      assertEquals("0000000000001111000000000000011",  // 7 5 0 0 0 7 6 0 0 -> 12 0 0 0 13 0 0
                                      FaxMachine.RLEtoFax("111101000000000111110000000"));

      assertEquals("0000000000001111000000000000000",  // 7 5 0 0 0 7 7 1 -> 2 0 0 0 15
                                      FaxMachine.RLEtoFax("111101000000000111111001"));

   }

   public void testFaxMachine02()
   {
      assertEquals("000001010011100101110000",           // 0 1 2 3 4 5 6 -> 
                                      FaxMachine.convertToRLE("1010010001000010000010000001"));
      assertEquals("111000111010111100111111000111000",           // 7 9 11 14 7 -> 7 0 7 2 7 4 7 7 0 7 0
                                      FaxMachine.convertToRLE("0000000100000000010000000000010000000000000010000000"));
      assertEquals("000111000111111000111111111000000",           // 0 7 14 21 0 -> 7 0 7 7 0 7 7 7 0 0
                                      FaxMachine.convertToRLE("1000000010000000000000010000000000000000000001"));
   }

   public void testFaxMachine03()
   {
      assertEquals("1010010001000010000010000001",           // 0 1 2 3 4 5 6 -> 
                                      FaxMachine.RLEtoFax("000001010011100101110000"));
      assertEquals("0000000100000000010000000000010000000000000010000000",           // 7 9 11 14 7 -> 7 0 7 2 7 4 7 7 0 7 0
                                      FaxMachine.RLEtoFax("111000111010111100111111000111000"));
      assertEquals("1000000010000000000000010000000000000000000001",           // 0 7 14 21 0 -> 7 0 7 7 0 7 7 7 0 0
                                      FaxMachine.RLEtoFax("000111000111111000111111111000000"));
      assertEquals("0000000000000000000000000000000",  // 7 7 7 7 3 -> 31
                                      FaxMachine.RLEtoFax("111111111111011"));

      assertEquals("1111111111111111111111111111111",  // 7 7 7 7 3 -> 31
       FaxMachine.RLEtoFax("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
   }

   public void testFaxMachine04()
   {
      testFaxMachine02();
      testFaxMachine03();
   }

   public void testFaxMachine05()
   {
      assertEquals("111000111111001111111111010011",           // 7 15 22 3 -> 7 0 7 7 1 7 7 7 2 3
                                      FaxMachine.convertToRLE("000000010000000000000001000000000000000000000001000"));
      assertEquals("000000000000000000",           // 0 0 0 0 0 0 -> 0 0 0 0 0 0
                                      FaxMachine.convertToRLE("11111"));
      assertEquals("111111111111111111101000",           // 47 0 -> 7 7 7 7 7 7 5 0
                                      FaxMachine.convertToRLE("000000000000000000000000000000000000000000000001"));
   }

   public void testFaxMachine06()
   {
      assertEquals("000000010000000000000001000000000000000000000001000",           // 0 1 2 3 4 5 6 -> 
                                      FaxMachine.RLEtoFax("111000111111001111111111010011"));
      assertEquals("11111",           // 7 9 11 14 7 -> 7 0 7 2 7 4 7 7 0 7 0
                                      FaxMachine.RLEtoFax("000000000000000000"));
      assertEquals("000000000000000000000000000000000000000000000001",           // 0 7 14 21 0 -> 7 0 7 7 0 7 7 7 0 0
                                      FaxMachine.RLEtoFax("111111111111111111101000"));
   }

   public void testFaxMachine07()
   {
      testFaxMachine05();
      testFaxMachine06();
   }

   public void testFaxMachine08()
   {
      assertEquals("001000001000000001000000000000",     // 1010010000
                                                    FaxMachine.convertToRLE("011011101111"));
      assertEquals("001000001000000001000000000010000000000000000",     // 10100100020000
                                                    FaxMachine.convertToRLE("0110111011110011111"));
//      System.out.println(FaxMachine.convertToRLE("0110111011110011111"));
      assertEquals("001000001000000001000000000001000000000000010000000000000000",     // 10100100010000200000
                                                    FaxMachine.convertToRLE("0110111011110111110011111"));
   }

   public void testFaxMachine09()
   {
//      System.out.println(FaxMachine.convertToRLE("1010010001000010000010000001"));
      assertEquals("011011101111",        
                                      FaxMachine.RLEtoFax("001000001000000001000000000000"));
      assertEquals("0110111011110011111",         
                                      FaxMachine.RLEtoFax("001000001000000001000000000010000000000000000"));
      assertEquals("0110111011110111110011111",     
                                      FaxMachine.RLEtoFax("001000001000000001000000000001000000000000010000000000000000"));
   }

   public void testFaxMachine10()
   {
      testFaxMachine04();
      testFaxMachine07();
      testFaxMachine08();
      testFaxMachine09();
   }
   public void testNumberChain01()
   {
      NumberChain nc = new NumberChain(987654321);
      assertEquals(123456789, nc.ascendingDigits());
      assertEquals(987654321, nc.descendingDigits());
      assertEquals(2, nc.getChainLength());

      nc = new NumberChain(123456789);
      assertEquals(123456789, nc.ascendingDigits());
      assertEquals(987654321, nc.descendingDigits());
      assertEquals(2, nc.getChainLength());

      nc = new NumberChain(1234);
      assertEquals(1234, nc.ascendingDigits());
      assertEquals(4321, nc.descendingDigits());
      assertEquals(4, nc.getChainLength());

      nc = new NumberChain(444);
      assertEquals(444, nc.ascendingDigits());
      assertEquals(444, nc.descendingDigits());
      assertEquals(2, nc.getChainLength());
   }

   public void testNumberChain02()
   {
      NumberChain nc = new NumberChain(10547531);
      assertEquals(1134557, nc.ascendingDigits());
      assertEquals(75543110, nc.descendingDigits());

      nc = new NumberChain(2468631);
      assertEquals(1234668, nc.ascendingDigits());
      assertEquals(8664321, nc.descendingDigits());
   }

   public void testNumberChain03()
   {
      NumberChain nc = new NumberChain(1134557);
      assertEquals(14, nc.getChainLength());

      nc = new NumberChain(41434);
      assertEquals(9, nc.getChainLength());

      nc = new NumberChain(123);
      assertEquals(6, nc.getChainLength());
   }

   public void testNumberChain04()
   {
      testNumberChain02();
      testNumberChain03();
   }

   public void testNumberChain05()
   {
      NumberChain nc = new NumberChain(10001);
      assertEquals(11, nc.ascendingDigits());
      assertEquals(11000, nc.descendingDigits());

      nc = new NumberChain(8017030);
      assertEquals(1378, nc.ascendingDigits());
      assertEquals(8731000, nc.descendingDigits());
   }

   public void testNumberChain06()
   {
      NumberChain nc = new NumberChain(1137);
      assertEquals(2, nc.getChainLength());

      nc = new NumberChain(414);
      assertEquals(5, nc.getChainLength());

      nc = new NumberChain(3210);
      assertEquals(4, nc.getChainLength());
   }

   public void testNumberChain07()
   {
      testNumberChain04();
      testNumberChain05();
      testNumberChain06();
   }

   public void testNumberChain08()
   {
      NumberChain nc = new NumberChain(222222);
      assertEquals(222222, nc.ascendingDigits());
      assertEquals(222222, nc.descendingDigits());

      nc = new NumberChain(999999);
      assertEquals(999999, nc.ascendingDigits());
      assertEquals(999999, nc.descendingDigits());

      nc = new NumberChain(540540);
      assertEquals(4455, nc.ascendingDigits());
      assertEquals(554400, nc.descendingDigits());

      nc = new NumberChain(1000000);
      assertEquals(1, nc.ascendingDigits());
      assertEquals(1000000, nc.descendingDigits());

      nc = new NumberChain(20002000);
      assertEquals(22, nc.ascendingDigits());
      assertEquals(22000000, nc.descendingDigits());
   }

   public void testNumberChain09()
   {
      NumberChain nc = new NumberChain(999999);
      assertEquals(2, nc.getChainLength());

      nc = new NumberChain(3333333);
      assertEquals(2, nc.getChainLength());

      nc = new NumberChain(2222222);
      assertEquals(2, nc.getChainLength());
   }

   public void testNumberChain10()
   {
      testNumberChain07();
      testNumberChain08();
      testNumberChain09();
   }
   public void testArrayEvaluator00()
   {
      int[] h01 = { 2, 2, 2, 4, 5 };
      ArrayEvaluator ae = new ArrayEvaluator(h01);
      assertEquals(false, ae.isFiveOfAKind());
      assertEquals(false, ae.isLargeStraight());
      assertEquals(false, ae.isFourOfAKind());
      assertEquals(false, ae.isFullHouse());
      assertEquals(false, ae.isSmallStraight());
      assertEquals(true, ae.isThreeOfAKind());
      assertEquals(false, ae.isTwoPair());
      assertEquals(true, ae.isPair());
   }

   public void testArrayEvaluator01()   //  Straights
   {
// Large Straight
      int[] h01 = { 1, 2, 3, 4, 5 };
      ArrayEvaluator ae = new ArrayEvaluator(h01);
      assertEquals(true, ae.isLargeStraight());
      assertEquals(true, ae.isSmallStraight());
      assertEquals(false, ae.isPair());
      assertEquals(false, ae.isTwoPair());
      assertEquals(false, ae.isThreeOfAKind());
      assertEquals(false, ae.isFullHouse());
      assertEquals(false, ae.isFourOfAKind());
      assertEquals(false, ae.isFiveOfAKind());

// Small Straight
      int[] h02 = { 3, 2, 3, 4, 5 };
      ae = new ArrayEvaluator(h02);
      assertEquals(true, ae.isSmallStraight( ));
      assertEquals(false, ae.isLargeStraight( ));
      assertEquals(true, ae.isPair( ));
      assertEquals(false, ae.isTwoPair( ));
      assertEquals(false, ae.isThreeOfAKind( ));
      assertEquals(false, ae.isFullHouse( ));
      assertEquals(false, ae.isFourOfAKind( ));
      assertEquals(false, ae.isFiveOfAKind( ));
// Small Straight
      int[] h021 = { 1, 6, 3, 4, 5 };
      ae = new ArrayEvaluator(h021);
      assertEquals(true, ae.isSmallStraight());
      assertEquals(false, ae.isLargeStraight());
      assertEquals(false, ae.isPair());
      assertEquals(false, ae.isTwoPair());
      assertEquals(false, ae.isThreeOfAKind());
      assertEquals(false, ae.isFullHouse());
      assertEquals(false, ae.isFourOfAKind());
      assertEquals(false, ae.isFiveOfAKind());
      int[] h022 = { 1, 2, 3, 4, 6 };
      ae = new ArrayEvaluator(h02);
      assertEquals(true, ae.isSmallStraight());
   }

   public void testArrayEvaluator02()   //  n of a kind
   {
// five of a kind
      int[] h03 = { 6, 6, 6, 6, 6 };
      ArrayEvaluator ae = new ArrayEvaluator(h03);
      assertEquals(false, ae.isLargeStraight());
      assertEquals(false, ae.isSmallStraight());
      assertEquals(true, ae.isPair());
      assertEquals(true, ae.isTwoPair());
      assertEquals(true, ae.isThreeOfAKind());
      assertEquals(false, ae.isFullHouse());
      assertEquals(true, ae.isFourOfAKind());
      assertEquals(true, ae.isFiveOfAKind());

// four of a kind
      int[] h04 = { 2, 5, 2, 2, 2 };
      ae = new ArrayEvaluator(h04);
      assertEquals(false, ae.isSmallStraight());
      assertEquals(false, ae.isLargeStraight());
      assertEquals(true, ae.isFourOfAKind());
      assertEquals(false, ae.isFiveOfAKind());
      assertEquals(true, ae.isPair());
      assertEquals(true, ae.isTwoPair());
      assertEquals(true, ae.isThreeOfAKind());
      assertEquals(false, ae.isFullHouse());

// three of a kind
      int[] h06 = { 2, 5, 2, 3, 2 };
      ae = new ArrayEvaluator(h06);
      assertEquals(false, ae.isSmallStraight());
      assertEquals(false, ae.isLargeStraight());
      assertEquals(true, ae.isThreeOfAKind());
      assertEquals(false, ae.isFullHouse());
      assertEquals(false, ae.isFourOfAKind());
      assertEquals(false, ae.isFiveOfAKind());
      assertEquals(true, ae.isPair());
      assertEquals(false, ae.isTwoPair());

// Pair
      int[] h09 = { 2, 5, 1, 3, 2 };
      ae = new ArrayEvaluator(h09);
      assertEquals(false, ae.isSmallStraight());
      assertEquals(false, ae.isLargeStraight());
      assertEquals(true, ae.isPair());
      assertEquals(false, ae.isTwoPair());
      assertEquals(false, ae.isThreeOfAKind());
      assertEquals(false, ae.isFullHouse());
      assertEquals(false, ae.isFourOfAKind());
      assertEquals(false, ae.isFiveOfAKind());
   }


   public void testArrayEvaluator03()   //  Full House & two pair
   {
 // full house
      int[] h05 = { 2, 5, 2, 5, 2 };
      ArrayEvaluator ae = new ArrayEvaluator(h05);
      assertEquals(false, ae.isSmallStraight());
      assertEquals(false, ae.isLargeStraight());
      assertEquals(true, ae.isFullHouse());
      assertEquals(true, ae.isThreeOfAKind());
      assertEquals(false, ae.isFourOfAKind());
      assertEquals(false, ae.isFiveOfAKind());
      assertEquals(true, ae.isPair());
      assertEquals(true, ae.isTwoPair());

// Two Pair
      int[] h07 = { 2, 5, 2, 3, 5 };
      ae = new ArrayEvaluator(h07);
      assertEquals(false, ae.isSmallStraight());
      assertEquals(false, ae.isLargeStraight());
      assertEquals(true, ae.isTwoPair());
      assertEquals(true, ae.isPair());
      assertEquals(false, ae.isThreeOfAKind());
      assertEquals(false, ae.isFullHouse());
      assertEquals(false, ae.isFourOfAKind());
      assertEquals(false, ae.isFiveOfAKind());
   }

   public void testArrayEvaluator04()     // misc incuding nothing
   {

      int[] h010 = {2, 2, 0, 2, 0};
      ArrayEvaluator ae = new ArrayEvaluator(h010);
      assertEquals(true, ae.isTwoPair());

      int[] h023 = {1, 3, 2, 6, 5};
      ae = new ArrayEvaluator(h023);
      assertEquals(false, ae.isSmallStraight());

      int[] h024 = {1, 3, 2, 1, 4};
      ae = new ArrayEvaluator(h024);
      assertEquals(true, ae.isSmallStraight());

      int[] h025 = {1, 3, 2, 4, 4};
      ae = new ArrayEvaluator(h025);
      assertEquals(true, ae.isSmallStraight());

      int[] h09 = { 2, 5, 1, 3, 6 };
      ae = new ArrayEvaluator(h09);
      assertEquals(false, ae.isLargeStraight());
      assertEquals(false, ae.isSmallStraight());
      assertEquals(false, ae.isFiveOfAKind());
      assertEquals(false, ae.isFourOfAKind());
      assertEquals(false, ae.isThreeOfAKind());
      assertEquals(false, ae.isFullHouse());
      assertEquals(false, ae.isTwoPair());
      assertEquals(false, ae.isPair());
   }
   
   public void testArrayEvaluator05()     // all f them
   {
       testArrayEvaluator04();
       testArrayEvaluator03();
       testArrayEvaluator02();
       testArrayEvaluator01();
   }
   private static int FIVE = 50;    // FOUR OF A KIND
   private static int LS = 40;      // LARGE STRAIGHT
   private static int SS = 30;      // SMALL STRAIGHT
   private static int FOUR = /* 2*sum */ 30;    // FOUR OF A KIND
   private static int FH = /* 4a + 3b */20;      // FULL HOUSE
   private static int THREE = /* sum */ 8;    // THREE
   private static int TWO_PAIR = /* max + min */ 5; //  TWO PAIR
   private static int PAIR = /* max  */ 3;     //  ONE PAIR
   private static int NOTHING = /* min */ 1;  //  NOTHING
   
   public void testNumberGame01()
   {
      int[][] deck1 = { {1, 2, 3, 4, 5},
                        {2, 2, 2, 2, 2},
                        {3, 3, 1, 2, 3},
                        {3, 4, 4, 5, 5},
                        {4, 4, 4, 4, 3}};
      NumberGame ng = new NumberGame(deck1);

      assertEquals(LS, ng.getRowScore(0));
      assertEquals(4*10, ng.getRowScore(1));
      assertEquals(3+3+1+2+3, ng.getRowScore(2));
      assertEquals(3+5, ng.getRowScore(3));
      assertEquals(3*(4+4+4+4+3), ng.getRowScore(4));
      assertEquals(SS, ng.getColScore(0));
      assertEquals(2+4, ng.getColScore(1));
      assertEquals(SS, ng.getColScore(2));
      assertEquals(2+5, ng.getColScore(3));
      assertEquals(2+5, ng.getColScore(4));

      assertEquals(LS+40+12+8+3*19+SS+6+SS+7+7, ng.getScore());
   }

   public void testNumberGame02()
   {
      int[][] deck1 = { {1, 3, 4, 5, 6},
                        {1, 2, 4, 3, 7},
                        {1, 3, 2, 6, 5},
                        {4, 4, 5, 2, 3},
                        {4, 5, 0, 7, 9}};
      NumberGame ng = new NumberGame(deck1);

      assertEquals(SS, ng.getRowScore(0));
      assertEquals(SS, ng.getRowScore(1));
      assertEquals(1, ng.getRowScore(2));
      assertEquals(SS, ng.getRowScore(3));
      assertEquals(0, ng.getRowScore(4));
      assertEquals(4*1+3*4, ng.getColScore(0));
      assertEquals(SS, ng.getColScore(1));
      assertEquals(5, ng.getColScore(2));
      assertEquals(2, ng.getColScore(3));
      assertEquals(3, ng.getColScore(4));

      assertEquals(4*SS+1+4+12+5+2+3, ng.getScore());
   }

   public void testNumberGame03()
   {
      int[][] deck1 = { {1, 2, 4, 3, 0},
                        {1, 2, 1, 3, 1},
                        {1, 1, 1, 1, 1},
                        {4, 0, 0, 2, 1},
                        {4, 0, 0, 4, 1}};
      NumberGame ng = new NumberGame(deck1);

      assertEquals(LS, ng.getRowScore(0));
      assertEquals(1+2+1+3+1, ng.getRowScore(1));
      assertEquals(20, ng.getRowScore(2));
      assertEquals(4, ng.getRowScore(3));
      assertEquals(4, ng.getRowScore(4));
      assertEquals(4*1+3*4, ng.getColScore(0));
      assertEquals(2, ng.getColScore(1));
      assertEquals(4, ng.getColScore(2));
      assertEquals(SS, ng.getColScore(3));
      assertEquals(3*4, ng.getColScore(4));

      assertEquals(LS+8+20+4+4+4+12+2+4+SS+12, ng.getScore());
   }

   public void testNumberGame04()
   {
      int[][] deck1 = { {1, 6, 4, 3, 8},
                        {1, 2, 3, 3, 3},
                        {2, 2, 0, 2, 0},
                        {2, 6, 6, 2, 2},
                        {1, 1, 5, 8, 8}};
      NumberGame ng = new NumberGame(deck1);

      assertEquals(1, ng.getRowScore(0));
      assertEquals(1+2+3+3+3, ng.getRowScore(1));
      assertEquals(4*2, ng.getRowScore(2));
      assertEquals(4*2+3*6, ng.getRowScore(3));
      assertEquals(1+8, ng.getRowScore(4));
      assertEquals(4+3*2, ng.getColScore(0));
      assertEquals(1+6, ng.getColScore(1));
      assertEquals(SS, ng.getColScore(2));
      assertEquals(8+2, ng.getColScore(3));
      assertEquals(8, ng.getColScore(4));

      assertEquals(1+12+8+8+18+9+4+6+7+SS+10+8, ng.getScore());
   }

   public void testNumberGame05()
   {
      int[][] deck1 = { {8, 8, 8, 8, 8},
                        {7, 7, 3, 7, 7},
                        {6, 2, 6, 9, 6},
                        {2, 6, 2, 2, 2},
                        {1, 8, 7, 8, 9}};
      NumberGame ng = new NumberGame(deck1);

      assertEquals(4*5*8, ng.getRowScore(0));
      assertEquals(3*(7+7+3+7+7), ng.getRowScore(1));
      assertEquals(6+2+6+9+6, ng.getRowScore(2));
      assertEquals(3*(2+6+2+2+2), ng.getRowScore(3));
      assertEquals(9, ng.getRowScore(4));
      assertEquals(1, ng.getColScore(0));
      assertEquals(8, ng.getColScore(1));
      assertEquals(2, ng.getColScore(2));
      assertEquals(9, ng.getColScore(3));
      assertEquals(SS, ng.getColScore(4));

      assertEquals(4*8*5+3*(7+7+3+7+7)+(6+2+6+9+6)+3*(2+6+2+2+2)+9+1+8+2+9+SS, ng.getScore());
   }

   public void testNumberGame06()
   {
      int[][] deck1 = { {5, 4, 9, 2, 3},
                        {5, 7, 3, 2, 7},
                        {6, 2, 6, 5, 9},
                        {8, 6, 2, 4, 1},
                        {1, 4, 3, 8, 9}};
      NumberGame ng = new NumberGame(deck1);

      assertEquals(SS, ng.getRowScore(0));
      assertEquals(7, ng.getRowScore(1));
      assertEquals(9, ng.getRowScore(2));
      assertEquals(1, ng.getRowScore(3));
      assertEquals(1, ng.getRowScore(4));
      assertEquals(8, ng.getColScore(0));
      assertEquals(7, ng.getColScore(1));
      assertEquals(9, ng.getColScore(2));
      assertEquals(8, ng.getColScore(3));
      assertEquals(9, ng.getColScore(4));

      assertEquals(SS+7+9+1+1+8+7+9+8+9, ng.getScore());
   }

   public void testNumberGame07()
   {
      int[][] deck1 = { {5, 4, 10, 2, 31},
                        {15, 7, 33, 12, 11},
                        {6, 2, 16, 5, 9},
                        {8, 6, 12, 9, 101},
                        {21, 14, 23, 28, 19}};
      NumberGame ng = new NumberGame(deck1);

      assertEquals(2, ng.getRowScore(0));
      assertEquals(7, ng.getRowScore(1));
      assertEquals(2, ng.getRowScore(2));
      assertEquals(6, ng.getRowScore(3));
      assertEquals(14, ng.getRowScore(4));
      assertEquals(5, ng.getColScore(0));
      assertEquals(2, ng.getColScore(1));
      assertEquals(10, ng.getColScore(2));
      assertEquals(2, ng.getColScore(3));
      assertEquals(9, ng.getColScore(4));

      assertEquals(2+7+2+6+14+5+2+10+2+9, ng.getScore());
   }

   public void testNumberGame08()
   {
      int[][] deck1 = { { 5, 14, 10, 14, 31},
                        {15,  7, 33, 12, 33},
                        {16, 22, 16,  5, 34},
                        {15, 36, 12, 12, 101},
                        {14, 36, 33, 14, 35}};
      NumberGame ng = new NumberGame(deck1);

      assertEquals(31, ng.getRowScore(0));
      assertEquals(33, ng.getRowScore(1));
      assertEquals(34, ng.getRowScore(2));
      assertEquals(101, ng.getRowScore(3));
      assertEquals(36, ng.getRowScore(4));
      assertEquals(16, ng.getColScore(0));
      assertEquals(36, ng.getColScore(1));
      assertEquals(33, ng.getColScore(2));
      assertEquals(5+14, ng.getColScore(3));
      assertEquals(31, ng.getColScore(4));

      assertEquals(31+33+34+101+36+16+36+33+19+31, ng.getScore());
   }

   public void testNumberGame09()
   {
      testNumberGame01();
      testNumberGame02();
      testNumberGame03();
      testNumberGame04();
      testNumberGame05();
      testNumberGame06();
      testNumberGame07();
      testNumberGame08();
   }

   public void testStamps01()
   {
      int[] arr = {1, 3};
      Stamps s = new Stamps(5, arr);
      assertEquals(13, s.getMaxRange());

      int[] arr1 = {1, 4, 12, 21};
      s = new Stamps(5, arr1);
      assertEquals(71, s.getMaxRange());

      int[] arr2 = {1, 7, 16, 31, 88};
      s = new Stamps(10, arr2);
      assertEquals(409, s.getMaxRange());

      int[] arr3 = {1, 5, 7, 8};
      s = new Stamps(6, arr3);
      assertEquals(48, s.getMaxRange());

      int[] arr4 = {2, 4, 8};
      s = new Stamps(5, arr4);
      assertEquals(0, s.getMaxRange());
   }

   public void testStamps02()
   {
      int[] arr = {1, 5};
      Stamps s = new Stamps(3, arr);
      assertEquals(3, s.getMaxRange());

      int[] arr1 = {1, 10, 20};
      s = new Stamps(8, arr1);
      assertEquals(8, s.getMaxRange());

      int[] arr2 = {1, 5, 10, 15, 20};
      s = new Stamps(4, arr2);
      assertEquals(8, s.getMaxRange());

      s = new Stamps(5, arr2);
      assertEquals(28, s.getMaxRange());

      s = new Stamps(6, arr2);
      assertEquals(48, s.getMaxRange());

      s = new Stamps(7, arr2);
      assertEquals(68, s.getMaxRange());
    }

   public void testStamps03()
   {
      int[] arr = {1, 2, 4, 8, 16};
      Stamps s = new Stamps(3, arr);
      assertEquals(14, s.getMaxRange());

      s = new Stamps(4, arr);
      assertEquals(30, s.getMaxRange());

      int[] arr1 = {1, 2, 4, 8, 16, 32, 64};
      s = new Stamps(5, arr1);
      assertEquals(62, s.getMaxRange());

      s = new Stamps(6, arr1);
      assertEquals(126, s.getMaxRange());
   }

   public void testStamps04()
   {
      int[] arr = {1, 6, 11};
      Stamps s = new Stamps(5, arr);
      assertEquals(15, s.getMaxRange());

      int[] arr1 = {1, 6, 11, 16};
      s = new Stamps(5, arr1);
      assertEquals(20, s.getMaxRange());

      int[] arr2 = {1, 6, 11, 16, 21};
      s = new Stamps(5, arr2);
      assertEquals(25, s.getMaxRange());

      int[] arr3 = {1, 6, 11, 16, 21, 26};
      s = new Stamps(5, arr3);
      assertEquals(30, s.getMaxRange());

      s = new Stamps(6, arr3);
      assertEquals(56, s.getMaxRange());
   }

   public void testStamps05()
   {
      int[] arr = {1, 3, 9, 28, 63};
      Stamps s = new Stamps(9, arr);
      assertEquals(305, s.getMaxRange());

      int[] arr1 = {2, 7, 11};
      s = new Stamps(5, arr1);
      assertEquals(0, s.getMaxRange());

      int[] arr2 = {1, 5, 25, 50, 100, 250};
      s = new Stamps(7, arr2);
      assertEquals(23, s.getMaxRange());

      s = new Stamps(8, arr2);
      assertEquals(48, s.getMaxRange());

      s = new Stamps(9, arr2);
      assertEquals(98, s.getMaxRange());

      s = new Stamps(10, arr2);
      assertEquals(198, s.getMaxRange());
    }

   public void testStamps06()
   {
      int[] arr = {1, 4, 10, 25, 50, 100};
      Stamps s = new Stamps(9, arr);
      assertEquals(391, s.getMaxRange());

      int[] arr1 = {1, 5, 10, 25, 50, 100};
      s = new Stamps(9, arr1);
      assertEquals(293, s.getMaxRange());

      int[] arr2 = {1, 5, 20, 40, 75, 100};
      s = new Stamps(7, arr2);
      assertEquals(38, s.getMaxRange());

      s = new Stamps(8, arr2);
      assertEquals(288, s.getMaxRange());

      s = new Stamps(9, arr2);
      assertEquals(388, s.getMaxRange());

      s = new Stamps(10, arr2);
      assertEquals(488, s.getMaxRange());
    }

   public void testStamps07()
   {
      int[] arr = {1, 2, 3, 5, 10};
      Stamps s = new Stamps(9, arr);
      assertEquals(78, s.getMaxRange());

      int[] arr1 = {1, 3, 5, 10};
      s = new Stamps(9, arr1);
      assertEquals(76, s.getMaxRange());

      int[] arr2 = {1, 2, 5, 10};
      s = new Stamps(9, arr2);
      assertEquals(77, s.getMaxRange());

      s = new Stamps(8, arr2);
      assertEquals(67, s.getMaxRange());

      s = new Stamps(10, arr2);
      assertEquals(87, s.getMaxRange());
   }

   public void testStamps08()
   {
      int[] arr = {1, 5, 10, 15};
      Stamps s = new Stamps(7, arr);
      assertEquals(53, s.getMaxRange());

      int[] arr1 = {1, 5, 10, 15};
      s = new Stamps(8, arr1);
      assertEquals(68, s.getMaxRange());

      int[] arr2 = {1, 5, 10, 15};
      s = new Stamps(9, arr2);
      assertEquals(83, s.getMaxRange());

      s = new Stamps(10, arr2);
      assertEquals(98, s.getMaxRange());

      s = new Stamps(11, arr2);
      assertEquals(113, s.getMaxRange());
   }

   public void testStamps09()
   {
      testStamps02();
      testStamps03();
      testStamps04();
      testStamps05();
      testStamps06();
   }

   public void testStamps10()
   {
      testStamps07();
      testStamps08();
      testStamps09();
   }

   public void testTheRace01()
   {
      String[] names1 = {"George", "John", "Thomas", "James"};
      TheRace tr = new TheRace(names1, 12);
      PlayerMove[] pm1 = { new PlayerMove("George", 4),
                           new PlayerMove("John", 2),
                           new PlayerMove("Thomas", 3),
                           new PlayerMove("James", 1)
                         };
      assertEquals(false, tr.playRound(pm1));
      assertEquals(4, tr.getPlayerLocation( "George" ) );
      assertEquals(2, tr.getPlayerLocation( "John" ) );
      assertEquals(3, tr.getPlayerLocation( "Thomas" ) );
      assertEquals(1, tr.getPlayerLocation( "James" ) );

      ArrayList<String> res = tr.getResults();
      assertEquals(0, res.size());
    }

   public void testTheRace02()  // 4 players - no tie in number choices
   {
      String[] names1 = {"A", "B", "C", "D"};
      TheRace tr = new TheRace(names1, 20);
      PlayerMove[] pm1 = { new PlayerMove("A", 4),
                           new PlayerMove("B", 3),
                           new PlayerMove("C", 2),
                           new PlayerMove("D", 1)
                         };
      assertEquals(false, tr.playRound(pm1));
      assertEquals(4, tr.getPlayerLocation( "A" ) );
      assertEquals(3, tr.getPlayerLocation( "B" ) );
      assertEquals(2, tr.getPlayerLocation( "C" ) );
      assertEquals(1, tr.getPlayerLocation( "D" ) );

      PlayerMove[] pm2 = { new PlayerMove("A", 3),
                           new PlayerMove("B", 2),
                           new PlayerMove("C", 1),
                           new PlayerMove("D", 4)
                         };
      assertEquals(false, tr.playRound(pm2));
      assertEquals(7, tr.getPlayerLocation( "A" ) );
      assertEquals(5, tr.getPlayerLocation( "B" ) );
      assertEquals(3, tr.getPlayerLocation( "C" ) );
      assertEquals(5, tr.getPlayerLocation( "D" ) );

      PlayerMove[] pm3 = { new PlayerMove("A", 2),
                           new PlayerMove("B", 1),
                           new PlayerMove("C", 4),
                           new PlayerMove("D", 3)
                         };
      assertEquals(false, tr.playRound(pm3));
      assertEquals(9, tr.getPlayerLocation( "A" ) );
      assertEquals(6, tr.getPlayerLocation( "B" ) );
      assertEquals(7, tr.getPlayerLocation( "C" ) );
      assertEquals(8, tr.getPlayerLocation( "D" ) );

      PlayerMove[] pm4 = { new PlayerMove("A", 1),
                           new PlayerMove("B", 4),
                           new PlayerMove("C", 3),
                           new PlayerMove("D", 2)
                         };
      assertEquals(false, tr.playRound(pm4));
      assertEquals(10, tr.getPlayerLocation( "A" ) );
      assertEquals(10, tr.getPlayerLocation( "B" ) );
      assertEquals(10, tr.getPlayerLocation( "C" ) );
      assertEquals(10, tr.getPlayerLocation( "D" ) );

      PlayerMove[] pm5 = { new PlayerMove("A", 3),
                           new PlayerMove("B", 5),
                           new PlayerMove("C", 1),
                           new PlayerMove("D", 4)
                         };
      assertEquals(false, tr.playRound(pm5));
      assertEquals(13, tr.getPlayerLocation( "A" ) );
      assertEquals(15, tr.getPlayerLocation( "B" ) );
      assertEquals(11, tr.getPlayerLocation( "C" ) );
      assertEquals(14, tr.getPlayerLocation( "D" ) );
    }

   public void testTheRace03()  // all players start at 0
   {
      String[] names1 = {"A", "B", "C", "D", "E"};
      TheRace tr = new TheRace(names1, 20);
      assertEquals(0, tr.getPlayerLocation( "A" ) );
      assertEquals(0, tr.getPlayerLocation( "B" ) );
      assertEquals(0, tr.getPlayerLocation( "C" ) );
      assertEquals(0, tr.getPlayerLocation( "D" ) );
      assertEquals(0, tr.getPlayerLocation( "E" ) );
   }

   public void testTheRace04()  // 5 players, one or two players choose same number
   {
      String[] names1 = {"A", "B", "C", "D", "E"};
      TheRace tr = new TheRace(names1, 20);
      PlayerMove[] pm1 = { new PlayerMove("A", 4),
                           new PlayerMove("B", 3),
                           new PlayerMove("C", 2),
                           new PlayerMove("D", 1),
                           new PlayerMove("E", 5)
                         };
      assertEquals(false, tr.playRound(pm1));
      assertEquals(4, tr.getPlayerLocation( "A" ) );
      assertEquals(3, tr.getPlayerLocation( "B" ) );
      assertEquals(2, tr.getPlayerLocation( "C" ) );
      assertEquals(1, tr.getPlayerLocation( "D" ) );
      assertEquals(5, tr.getPlayerLocation( "E" ) );

      PlayerMove[] pm2 = { new PlayerMove("A", 3),
                           new PlayerMove("B", 2),
                           new PlayerMove("C", 1),
                           new PlayerMove("D", 5),
                           new PlayerMove("E", 4)
                         };
      assertEquals(false, tr.playRound(pm2));
      assertEquals(7, tr.getPlayerLocation( "A" ) );
      assertEquals(5, tr.getPlayerLocation( "B" ) );
      assertEquals(3, tr.getPlayerLocation( "C" ) );
      assertEquals(6, tr.getPlayerLocation( "D" ) );
      assertEquals(9, tr.getPlayerLocation( "E" ) );

      PlayerMove[] pm3 = { new PlayerMove("A", 3),
                           new PlayerMove("B", 1),
                           new PlayerMove("C", 5),
                           new PlayerMove("D", 2),
                           new PlayerMove("E", 2)
                         };
      assertEquals(false, tr.playRound(pm3));
      assertEquals(10, tr.getPlayerLocation( "A" ) );
      assertEquals(6, tr.getPlayerLocation( "B" ) );
      assertEquals(8, tr.getPlayerLocation( "C" ) );
      assertEquals(6, tr.getPlayerLocation( "D" ) );
      assertEquals(9, tr.getPlayerLocation( "E" ) );

      PlayerMove[] pm4 = { new PlayerMove("A", 3),
                           new PlayerMove("B", 4),
                           new PlayerMove("C", 3),
                           new PlayerMove("D", 5),
                           new PlayerMove("E", 4)
                         };
      assertEquals(false, tr.playRound(pm4));
      assertEquals(10, tr.getPlayerLocation( "A" ) );
      assertEquals(6, tr.getPlayerLocation( "B" ) );
      assertEquals(8, tr.getPlayerLocation( "C" ) );
      assertEquals(11, tr.getPlayerLocation( "D" ) );
      assertEquals(9, tr.getPlayerLocation( "E" ) );

      PlayerMove[] pm5 = { new PlayerMove("A", 3),
                           new PlayerMove("B", 5),
                           new PlayerMove("C", 1),
                           new PlayerMove("D", 5),
                           new PlayerMove("E", 4)
                         };
      assertEquals(false, tr.playRound(pm5));
      assertEquals(13, tr.getPlayerLocation( "A" ) );
      assertEquals(6, tr.getPlayerLocation( "B" ) );
      assertEquals(9, tr.getPlayerLocation( "C" ) );
      assertEquals(11, tr.getPlayerLocation( "D" ) );
      assertEquals(13, tr.getPlayerLocation( "E" ) );
    }

   public void testTheRace05()   // test all
   {
      String[] names2 = {"Goofy", "Mickey", "Minnie", "Daisey", "Cinderalla", "Belle"};
      TheRace tr = new TheRace(names2, 10);
      PlayerMove[] pm2 = { new PlayerMove("Goofy", 4),
                           new PlayerMove("Mickey", 4),
                           new PlayerMove("Minnie", 3),
                           new PlayerMove("Daisey", 4),
                           new PlayerMove("Cinderalla", 3),
                           new PlayerMove("Belle", 5)
                         };
      assertEquals(false, tr.playRound(pm2));
      assertEquals(0, tr.getPlayerLocation( "Goofy" ) );
      assertEquals(0, tr.getPlayerLocation( "Mickey" ) );
      assertEquals(0, tr.getPlayerLocation( "Minnie" ) );
      assertEquals(0, tr.getPlayerLocation( "Daisey" ) );
      assertEquals(0, tr.getPlayerLocation( "Cinderalla" ) );
      assertEquals(5, tr.getPlayerLocation( "Belle" ) );

      PlayerMove[] pm3 = { new PlayerMove("Goofy", 2),
                           new PlayerMove("Mickey", 1),
                           new PlayerMove("Minnie", 3),
                           new PlayerMove("Daisey", 4),
                           new PlayerMove("Cinderalla", 5),
                           new PlayerMove("Belle", 5)
                         };
      assertEquals(false, tr.playRound(pm3));
      assertEquals(2, tr.getPlayerLocation( "Goofy" ) );
      assertEquals(1, tr.getPlayerLocation( "Mickey" ) );
      assertEquals(3, tr.getPlayerLocation( "Minnie" ) );
      assertEquals(4, tr.getPlayerLocation( "Daisey" ) );
      assertEquals(0, tr.getPlayerLocation( "Cinderalla" ) );
      assertEquals(5, tr.getPlayerLocation( "Belle" ) );

      PlayerMove[] pm4 = { new PlayerMove("Goofy", 1),
                           new PlayerMove("Mickey", 3),
                           new PlayerMove("Minnie", 3),
                           new PlayerMove("Daisey", 3),
                           new PlayerMove("Cinderalla", 4),
                           new PlayerMove("Belle", 5)
                         };

      assertEquals(true, tr.playRound(pm4));
      assertEquals(3, tr.getPlayerLocation( "Goofy" ) );
      assertEquals(0, tr.getPlayerLocation( "Mickey" ) );
      assertEquals(0, tr.getPlayerLocation( "Minnie" ) );
      assertEquals(1, tr.getPlayerLocation( "Daisey" ) );
      assertEquals(4, tr.getPlayerLocation( "Cinderalla" ) );
      assertEquals(10, tr.getPlayerLocation( "Belle" ) );

      ArrayList<String> res = tr.getResults();
      ArrayList<String> solution = new ArrayList<String>();
      solution.add("Belle");
      assertEquals(1, res.size() );
      assertEquals(solution.get(0), res.get(0) );
      
      PlayerMove[] pm5 = { new PlayerMove("Goofy", 1),
                           new PlayerMove("Mickey", 2),
                           new PlayerMove("Minnie", 6),
                           new PlayerMove("Daisey", 5),
                           new PlayerMove("Cinderalla", 4),
                           new PlayerMove("Belle", 3)
                         };

      assertEquals(true, tr.playRound(pm5));
      assertEquals(4, tr.getPlayerLocation( "Goofy" ) );
      assertEquals(2, tr.getPlayerLocation( "Mickey" ) );
      assertEquals(6, tr.getPlayerLocation( "Minnie" ) );
      assertEquals(6, tr.getPlayerLocation( "Daisey" ) );
      assertEquals(8, tr.getPlayerLocation( "Cinderalla" ) );
      assertEquals(13, tr.getPlayerLocation( "Belle" ) );

      res = tr.getResults();
      assertEquals(1, res.size() );
      assertEquals(solution.get(0), res.get(0));

      assertEquals(true, tr.playRound(pm5));
      assertEquals(5, tr.getPlayerLocation( "Goofy" ) );
      assertEquals(4, tr.getPlayerLocation( "Mickey" ) );
      assertEquals(12, tr.getPlayerLocation( "Minnie" ) );
      assertEquals(11, tr.getPlayerLocation( "Daisey" ) );
      assertEquals(12, tr.getPlayerLocation( "Cinderalla" ) );

      res = tr.getResults();
      solution.add("Cinderalla");
      solution.add("Minnie");
      solution.add("Daisey");
      assertEquals(4, res.size() );
      assertEquals(solution.get(0), res.get(0));
      ArrayList<String> xyz = new ArrayList<String>();
      for (String s : res) xyz.add(s);
      assertEquals(true, xyz.contains("Minnie"));
      assertEquals(true, xyz.contains("Cinderalla"));
      assertEquals(true, xyz.contains("Daisey"));
    }

   public void testTheRace06()  // 5 players, one or two or three players choose same number
   {
      String[] names1 = {"A", "B", "C", "D", "E"};
      TheRace tr = new TheRace(names1, 13);
      PlayerMove[] pm1 = { new PlayerMove("A", 4),
                           new PlayerMove("B", 3),
                           new PlayerMove("C", 2),
                           new PlayerMove("D", 1),
                           new PlayerMove("E", 5)
                         };
      assertEquals(false, tr.playRound(pm1));
      assertEquals(4, tr.getPlayerLocation( "A" ) );
      assertEquals(3, tr.getPlayerLocation( "B" ) );
      assertEquals(2, tr.getPlayerLocation( "C" ) );
      assertEquals(1, tr.getPlayerLocation( "D" ) );
      assertEquals(5, tr.getPlayerLocation( "E" ) );

      PlayerMove[] pm2 = { new PlayerMove("A", 3),
                           new PlayerMove("B", 2),
                           new PlayerMove("C", 2),
                           new PlayerMove("D", 2),
                           new PlayerMove("E", 4)
                         };
      assertEquals(false, tr.playRound(pm2));
      assertEquals(7, tr.getPlayerLocation( "A" ) );
      assertEquals(1, tr.getPlayerLocation( "B" ) );
      assertEquals(0, tr.getPlayerLocation( "C" ) );
      assertEquals(0, tr.getPlayerLocation( "D" ) );
      assertEquals(9, tr.getPlayerLocation( "E" ) );

      PlayerMove[] pm3 = { new PlayerMove("A", 3),
                           new PlayerMove("B", 3),
                           new PlayerMove("C", 5),
                           new PlayerMove("D", 2),
                           new PlayerMove("E", 2)
                         };
      assertEquals(false, tr.playRound(pm3));
      assertEquals(7, tr.getPlayerLocation( "A" ) );
      assertEquals(1, tr.getPlayerLocation( "B" ) );
      assertEquals(5, tr.getPlayerLocation( "C" ) );
      assertEquals(0, tr.getPlayerLocation( "D" ) );
      assertEquals(9, tr.getPlayerLocation( "E" ) );

      PlayerMove[] pm4 = { new PlayerMove("A", 3),
                           new PlayerMove("B", 6),
                           new PlayerMove("C", 3),
                           new PlayerMove("D", 4),
                           new PlayerMove("E", 3)
                         };
      assertEquals(false, tr.playRound(pm4));
      assertEquals(4, tr.getPlayerLocation( "A" ) );
      assertEquals(7, tr.getPlayerLocation( "B" ) );
      assertEquals(2, tr.getPlayerLocation( "C" ) );
      assertEquals(4, tr.getPlayerLocation( "D" ) );
      assertEquals(6, tr.getPlayerLocation( "E" ) );

      PlayerMove[] pm5 = { new PlayerMove("A", 3),
                           new PlayerMove("B", 2),
                           new PlayerMove("C", 1),
                           new PlayerMove("D", 5),
                           new PlayerMove("E", 4)
                         };
      assertEquals(false, tr.playRound(pm5));
      assertEquals(7, tr.getPlayerLocation( "A" ) );
      assertEquals(9, tr.getPlayerLocation( "B" ) );
      assertEquals(3, tr.getPlayerLocation( "C" ) );
      assertEquals(9, tr.getPlayerLocation( "D" ) );
      assertEquals(10, tr.getPlayerLocation( "E" ) );

      PlayerMove[] pm6 = { new PlayerMove("A", 3),
                           new PlayerMove("B", 2),
                           new PlayerMove("C", 1),
                           new PlayerMove("D", 1),
                           new PlayerMove("E", 4)
                         };
      assertEquals(true, tr.playRound(pm6));
      assertEquals(10, tr.getPlayerLocation( "A" ) );
      assertEquals(11, tr.getPlayerLocation( "B" ) );
      assertEquals(3, tr.getPlayerLocation( "C" ) );
      assertEquals(9, tr.getPlayerLocation( "D" ) );
      assertEquals(14, tr.getPlayerLocation( "E" ) );

      ArrayList<String> res = tr.getResults();
      ArrayList<String> solution = new ArrayList<String>();
      solution.add("E");
      assertEquals(1, res.size());
      assertEquals(solution.get(0), res.get(0));

      PlayerMove[] pm7 = { new PlayerMove("A", 3),
                           new PlayerMove("B", 2),
                           new PlayerMove("C", 1),
                           new PlayerMove("D", 2),
                           new PlayerMove("E", 0)
                         };
      assertEquals(true, tr.playRound(pm7));
      assertEquals(13, tr.getPlayerLocation( "A" ) );
      assertEquals(11, tr.getPlayerLocation( "B" ) );
      assertEquals(4, tr.getPlayerLocation( "C" ) );
      assertEquals(9, tr.getPlayerLocation( "D" ) );

      res = tr.getResults();
      solution.add("A");
      assertEquals(2, res.size());
      assertEquals(solution.get(0), res.get(0));
      assertEquals(solution.get(1), res.get(1));


      PlayerMove[] pm8 = { new PlayerMove("A", 0),
                           new PlayerMove("B", 2),
                           new PlayerMove("C", 1),
                           new PlayerMove("D", 3),
                           new PlayerMove("E", 0)
                         };
      assertEquals(true, tr.playRound(pm8));
      assertEquals(13, tr.getPlayerLocation( "B" ) );
      assertEquals(5, tr.getPlayerLocation( "C" ) );
      assertEquals(12, tr.getPlayerLocation( "D" ) );

      res = tr.getResults();
      solution.add("B");
      assertEquals(3, res.size());
      assertEquals(solution.get(0), res.get(0));
      assertEquals(solution.get(1), res.get(1));
      assertEquals(solution.get(2), res.get(2));
    }

   public void testTheRace07()
   {
      testTheRace02();
      testTheRace03();
   }

   public void testTheRace08()
   {
      testTheRace04();
      testTheRace05();
   }

   public void testTheRace09()
   {
      testTheRace06();
      testTheRace07();
      testTheRace08();
   }

   public void testTheRace10()
   {
      testTheRace03();
      testTheRace04();
   }
}