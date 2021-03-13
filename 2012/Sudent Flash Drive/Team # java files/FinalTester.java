import java.util.*;

/**
 * The test class FinalTester.
 *
 * @author  Don Allen
 * @version 2012 Wittry Programming contest
 */
public class FinalTester extends junit.framework.TestCase
{
   public void testBalloono01()
   {
      String[][] w1 = { {"#", "#", " ", "#", " ", "#"},
                        {"#", " ", " ", " ", " ", " "},
                        {"#", " ", "#", "#", "#", " "},
                        {"#", " ", "#", " ", " ", "#"},
                        {"#", " ", "#", " ", " ", " "},
                        {" ", "#", " ", "#", " ", "#"} };
      Balloono bal = new Balloono(w1);
      ArrayList<Location> locs = new ArrayList<Location>();
      locs.add(new Location(3, 3));
      bal.setOpponents(locs);
      bal.setCurrentLocation(new Location(1, 1));
      assertEquals(true, bal.isSafe(2));
      assertEquals(true, bal.isSafe(3));
      assertEquals(true, bal.isSafe(4));
      assertEquals(true, bal.isSafe(5));
      assertEquals(false, bal.isSafe(6));

      bal.setCurrentLocation(new Location(0, 2));
      assertEquals(true, bal.isSafe(2));
      assertEquals(true, bal.isSafe(3));
      assertEquals(true, bal.isSafe(4));
      assertEquals(false, bal.isSafe(5));

      bal.setCurrentLocation(new Location(5, 0));
      assertEquals(true, bal.isSafe(2));
      assertEquals(true, bal.isSafe(3));
      assertEquals(false, bal.isSafe(4));

      bal.setCurrentLocation(new Location(4, 1));
      assertEquals(true, bal.isSafe(2));
      assertEquals(false, bal.isSafe(3));

      bal.setCurrentLocation(new Location(2, 5));
      assertEquals(false, bal.isSafe(2));

      locs.set(0, new Location(5, 2));
      locs.add(new Location(1, 4));
      bal.setCurrentLocation(new Location(1, 3));
      assertEquals(false, bal.isSafe(1));
      bal.setCurrentLocation(new Location(1, 2));
      assertEquals(true, bal.isSafe(1));

      bal.setCurrentLocation(new Location(4, 5));
      assertEquals(true, bal.isSafe(2));

      bal.setCurrentLocation(new Location(2, 1));
      assertEquals(false, bal.isSafe(3));
   }


   public void testBalloono02()
   {
      String[][] w = { {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
                       {"#", " ", " ", " ", " ", " ", " ", " ", " ", "#"},
                       {"#", " ", " ", " ", " ", " ", " ", " ", " ", "#"},
                       {"#", " ", " ", " ", " ", " ", " ", " ", " ", "#"},
                       {"#", " ", " ", " ", " ", " ", " ", " ", " ", "#"},
                       {"#", " ", " ", " ", " ", " ", " ", " ", " ", "#"},
                       {"#", " ", " ", " ", " ", " ", " ", " ", " ", "#"},
                       {"#", " ", " ", " ", " ", " ", " ", " ", " ", "#"},
                       {"#", " ", " ", " ", " ", " ", " ", " ", " ", "#"},
                       {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#"} };
      Balloono bal = new Balloono(w);
      ArrayList<Location> locs = new ArrayList<Location>();
      locs.add(new Location(8, 8));
      bal.setOpponents(locs);
      bal.setCurrentLocation(new Location(1, 1));
      assertEquals(true, bal.isSafe(2));
      assertEquals(true, bal.isSafe(3));
      assertEquals(true, bal.isSafe(4));
      assertEquals(true, bal.isSafe(5));
      assertEquals(true, bal.isSafe(6));
      assertEquals(false, bal.isSafe(7));
      locs.add(new Location(7, 3));
      bal.setCurrentLocation(new Location(5, 1));
      assertEquals(false, bal.isSafe(2));
      bal.setCurrentLocation(new Location(5, 6));
      assertEquals(true, bal.isSafe(2));

      bal.setCurrentLocation(new Location(4, 6));
      assertEquals(false, bal.isSafe(3));
      bal.setCurrentLocation(new Location(3, 3));
      assertEquals(true, bal.isSafe(3));

      bal.setCurrentLocation(new Location(4, 6));
      assertEquals(false, bal.isSafe(4));
      bal.setCurrentLocation(new Location(3, 8));
      assertEquals(true, bal.isSafe(4));

      bal.setCurrentLocation(new Location(2, 8));
      assertEquals(false, bal.isSafe(5));
      bal.setCurrentLocation(new Location(1, 9));
      assertEquals(true, bal.isSafe(5));
    }

   public void testBalloono03()
   {
      String[][] w = { {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
                       {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
                       {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
                       {"#", "#", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
                       {"#", "#", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#", "#", "#"},
                       {"#", "#", " ", " ", " ", " ", "#", " ", " ", " ", "#", "#", "#", " ", "#"},
                       {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"},
                       {"#", " ", " ", " ", "#", "#", "#", " ", " ", " ", "#", "#", "#", "#", "#"},
                       {"#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#"},
                       {"#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#"},
                       {"#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#"},
                       {"#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#"},
                       {"#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#"},
                       {"#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#"},
                       {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"} };
      Balloono bal = new Balloono(w);
      ArrayList<Location> locs = new ArrayList<Location>();
      locs.add(new Location(6, 5));
      bal.setOpponents(locs);
      bal.setCurrentLocation(new Location(4, 5));
      assertEquals(false, bal.isSafe(2));
      bal.setCurrentLocation(new Location(3, 2));
      assertEquals(true, bal.isSafe(2));
      assertEquals(false, bal.isSafe(3));
      assertEquals(false, bal.isSafe(4));
      assertEquals(false, bal.isSafe(5));
      assertEquals(false, bal.isSafe(7));
    }

   public void testBalloono04()
   {      String[][] w2 = { {"#", "#", "#", " ", "#", " ", "#", " ", " ", " "},
                            {" ", " ", "#", " ", "#", " ", "#", " ", "#", "#"},
                            {"#", " ", "#", " ", "#", " ", "#", " ", "#", "#"},
                            {" ", " ", "#", " ", "#", " ", "#", " ", " ", " "},
                            {"#", " ", "#", " ", "#", " ", "#", "#", "#", " "},
                            {" ", " ", " ", "#", " ", "#", " ", " ", " ", " "},
                            {"#", "#", " ", "#", " ", "#", " ", "#", "#", "#"},
                            {" ", " ", "#", "#", " ", "#", " ", "#", " ", " "},
                            {"#", "#", " ", "#", " ", "#", "#", " ", " ", "#"},
                            {"#", " ", "#", " ", "#", "#", " ", " ", "#", " "} };

      Balloono bal = new Balloono(w2);
      ArrayList<Location> locs = new ArrayList<Location>();

      locs.add(new Location(8, 7));
      locs.add(new Location(1, 5));
      locs.add(new Location(9, 1));
      locs.add(new Location(1, 0));
      locs.add(new Location(9, 9));
      bal.setOpponents(locs);

      bal.setCurrentLocation(new Location(9, 6));
      assertEquals(false, bal.isSafe(1));
      bal.setCurrentLocation(new Location(4, 5));
      assertEquals(true, bal.isSafe(1));

      bal.setCurrentLocation(new Location(6, 6));
      assertEquals(false, bal.isSafe(2));
      bal.setCurrentLocation(new Location(7, 0));
      assertEquals(true, bal.isSafe(2));
      bal.setCurrentLocation(new Location(1, 7));
      assertEquals(true, bal.isSafe(2));

      bal.setCurrentLocation(new Location(5, 7));
      assertEquals(false, bal.isSafe(3));
      bal.setCurrentLocation(new Location(5, 4));
      assertEquals(true, bal.isSafe(3));

      bal.setCurrentLocation(new Location(6, 6));
      assertEquals(false, bal.isSafe(4));
      bal.setCurrentLocation(new Location(4, 3));
      assertEquals(true, bal.isSafe(4));

      bal.setCurrentLocation(new Location(4, 9));
      assertEquals(false, bal.isSafe(5));
      bal.setCurrentLocation(new Location(0, 3));
      assertEquals(true, bal.isSafe(5));

      bal.setCurrentLocation(new Location(3, 3));
      assertEquals(false, bal.isSafe(6));
      bal.setCurrentLocation(new Location(3, 7));
      assertEquals(true, bal.isSafe(6));

      bal.setCurrentLocation(new Location(2, 3));
      assertEquals(false, bal.isSafe(7));
      bal.setCurrentLocation(new Location(0, 9));
      assertEquals(true, bal.isSafe(7));

      bal.setCurrentLocation(new Location(1, 7));
      assertEquals(false, bal.isSafe(8));
      bal.setCurrentLocation(new Location(0, 3));
      assertEquals(true, bal.isSafe(8));

      bal.setCurrentLocation(new Location(0, 8));
      assertEquals(false, bal.isSafe(9));
      bal.setCurrentLocation(new Location(0, 9));
      assertEquals(true, bal.isSafe(9));

      bal.setCurrentLocation(new Location(0, 8));
      assertEquals(false, bal.isSafe(10));
      bal.setCurrentLocation(new Location(0, 9));
      assertEquals(false, bal.isSafe(10));
    }

   public void testBalloono05()
   {      String[][] w2 = { {"#", "#", "#", " ", "#", " "},
                            {" ", " ", "#", " ", "#", " "},
                            {"#", " ", "#", " ", "#", " "},
                            {" ", " ", "#", " ", "#", " "},
                            {"#", " ", "#", " ", "#", " "},
                            {"#", "#", " ", "#", " ", "#"},
                            {" ", " ", "#", "#", " ", "#"},
                            {"#", "#", " ", "#", " ", "#"},
                            {" ", " ", " ", "#", " ", "#"},
                            {"#", " ", "#", " ", "#", " "},
                            {" ", " ", "#", " ", "#", " "},
                            {"#", "#", " ", "#", " ", "#"},
                            {" ", " ", "#", "#", " ", "#"},
                            {"#", "#", " ", "#", " ", "#"},
                            {"#", " ", "#", " ", "#", "#"} };

      Balloono bal = new Balloono(w2);
      ArrayList<Location> locs = new ArrayList<Location>();

      locs.add(new Location(5, 2));
      locs.add(new Location(0, 5));
      locs.add(new Location(10, 3));
      bal.setOpponents(locs);

      bal.setCurrentLocation(new Location(4, 3));
      assertEquals(false, bal.isSafe(1));
      bal.setCurrentLocation(new Location(1, 0));
      assertEquals(true, bal.isSafe(1));

      bal.setCurrentLocation(new Location(3, 0));
      assertEquals(false, bal.isSafe(2));
      bal.setCurrentLocation(new Location(0, 3));
      assertEquals(true, bal.isSafe(2));
      bal.setCurrentLocation(new Location(8, 0));
      assertEquals(true, bal.isSafe(2));

      bal.setCurrentLocation(new Location(6, 4));
      assertEquals(false, bal.isSafe(3));
      bal.setCurrentLocation(new Location(14, 3));
      assertEquals(true, bal.isSafe(3));

      bal.setCurrentLocation(new Location(6, 1));
      assertEquals(false, bal.isSafe(4));
      bal.setCurrentLocation(new Location(1, 0));
      assertEquals(false, bal.isSafe(4));
      bal.setCurrentLocation(new Location(8, 0));
      assertEquals(false, bal.isSafe(4));
      bal.setCurrentLocation(new Location(14, 3));
      assertEquals(false, bal.isSafe(4));
      bal.setCurrentLocation(new Location(0, 3));
      assertEquals(true, bal.isSafe(4));

      bal.setCurrentLocation(new Location(4, 5));
      assertEquals(false, bal.isSafe(5));
      bal.setCurrentLocation(new Location(0, 3));
      assertEquals(false, bal.isSafe(5));
    }

   public void testBalloono06()
   {      String[][] w2 = { {"#", "#", " ", "#", "#", " ", "#", " ", " ", "#", " ", "#", " "},
                            {" ", "#", "#", "#", " ", " ", "#", "#", "#", "#", " ", " ", " "},
                            {" ", " ", "#", " ", " ", "#", " ", "#", "#", " ", " ", "#", " "},
                            {"#", "#", "#", "#", " ", "#", " ", "#", " ", "#", "#", " ", " "},
                            {"#", " ", "#", "#", " ", " ", "#", "#", " ", "#", " ", "#", " "},
                            {" ", " ", "#", "#", " ", " ", "#", " ", "#", " ", "#", "#", " "},
                            {" ", "#", " ", "#", "#", " ", "#", " ", "#", " ", "#", " ", "#"} };

      Balloono bal = new Balloono(w2);
      ArrayList<Location> locs = new ArrayList<Location>();

      locs.add(new Location(5, 1));
      bal.setOpponents(locs);

      bal.setCurrentLocation(new Location(6, 2));
      assertEquals(false, bal.isSafe(1));
      bal.setCurrentLocation(new Location(5, 4));
      assertEquals(true, bal.isSafe(1));
      bal.setCurrentLocation(new Location(4, 4));
      assertEquals(true, bal.isSafe(13));
      bal.setCurrentLocation(new Location(1, 0));
      assertEquals(true, bal.isSafe(13));

      bal = new Balloono(w2);
      locs = new ArrayList<Location>();

      locs.add(new Location(5, 1));
      locs.add(new Location(2, 6));
      locs.add(new Location(4, 10));
      bal.setOpponents(locs);

      bal.setCurrentLocation(new Location(6, 0));
      assertEquals(false, bal.isSafe(1));
      bal.setCurrentLocation(new Location(5, 4));
      assertEquals(true, bal.isSafe(1));
      bal.setCurrentLocation(new Location(4, 4));

      bal.setCurrentLocation(new Location(2, 10));
      assertEquals(false, bal.isSafe(2));
      bal.setCurrentLocation(new Location(0, 2));
      assertEquals(true, bal.isSafe(2));
      bal.setCurrentLocation(new Location(2, 9));
      assertEquals(true, bal.isSafe(2));

      bal.setCurrentLocation(new Location(5, 12));
      assertEquals(false, bal.isSafe(3));
      bal.setCurrentLocation(new Location(0, 12));
      assertEquals(true, bal.isSafe(3));

      bal.setCurrentLocation(new Location(6, 11));
      assertEquals(false, bal.isSafe(4));
      bal.setCurrentLocation(new Location(0, 10));
      assertEquals(false, bal.isSafe(4));
      bal.setCurrentLocation(new Location(3, 6));
      assertEquals(false, bal.isSafe(4));
      bal.setCurrentLocation(new Location(1, 5));
      assertEquals(false, bal.isSafe(4));
      bal.setCurrentLocation(new Location(0, 2));
      assertEquals(true, bal.isSafe(4));

      bal.setCurrentLocation(new Location(1, 0));
      assertEquals(true, bal.isSafe(5));
      bal.setCurrentLocation(new Location(2, 0));
      assertEquals(true, bal.isSafe(6));
      bal.setCurrentLocation(new Location(2, 1));
      assertEquals(true, bal.isSafe(7));
      bal.setCurrentLocation(new Location(0, 2));
      assertEquals(true, bal.isSafe(8));
      bal.setCurrentLocation(new Location(0, 7));
      assertEquals(true, bal.isSafe(9));
      bal.setCurrentLocation(new Location(0, 8));
      assertEquals(true, bal.isSafe(19));
    }

   public void testBalloono07()
   {
      String[][] w2 = { {"#", "#", "#", "#", " ", " "},
                            {" ", "#", " ", " ", "#", "#"},
                            {" ", "#", "#", " ", "#", " "},
                            {"#", " ", " ", "#", " ", "#"},
                            {" ", " ", "#", "#", " ", "#"},
                            {"#", "#", " ", "#", " ", " "},
                            {"#", " ", "#", " ", "#", "#"} };

      Balloono bal = new Balloono(w2);
      bal.setCurrentLocation(new Location(4, 4));
      assertEquals(true, bal.isSafe(1));

      ArrayList<Location> locs = new ArrayList<Location>();
      locs.add(new Location(5, 2));
      locs.add(new Location(0, 5));
      locs.add(new Location(6, 3));
      locs.add(new Location(2, 5));
      bal.setOpponents(locs);

      bal.setCurrentLocation(new Location(4, 1));
      assertEquals(false, bal.isSafe(1));
      bal.setCurrentLocation(new Location(1, 0));
      assertEquals(true, bal.isSafe(1));
      bal.setCurrentLocation(new Location(4, 4));
      assertEquals(true, bal.isSafe(1));

      bal.setCurrentLocation(new Location(4, 0));
      assertEquals(false, bal.isSafe(2));
      bal.setCurrentLocation(new Location(2, 0));
      assertEquals(true, bal.isSafe(2));
      bal.setCurrentLocation(new Location(1, 2));
      assertEquals(true, bal.isSafe(2));

      bal.setCurrentLocation(new Location(1, 2));
      assertEquals(false, bal.isSafe(3));
      bal.setCurrentLocation(new Location(1, 0));
      assertEquals(true, bal.isSafe(3));

      bal.setCurrentLocation(new Location(1, 0));
      assertEquals(false, bal.isSafe(4));
    }

   public void testBalloono08()
   {
      testBalloono01();
      testBalloono02();
      testBalloono03();
      testBalloono04();
   }

   public void testBalloono09()
   {
      testBalloono05();
      testBalloono06();
      testBalloono07();
   }

   public void testBalloono10()
   {
      testBalloono08();
      testBalloono09();
   }
   public void testFunctionsGoneWild2012_00()
   {
      assertEquals(3938, FunctionsGoneWild2012.f1(11));
      assertEquals(166.000775, FunctionsGoneWild2012.f2(2, 3, 5), 0.05);
      assertEquals( -24.500, FunctionsGoneWild2012.f3(3.5, 1.5), 0.05);
      assertEquals( 6.83567, FunctionsGoneWild2012.f4(-5, 0, 11),  0.25);
      assertEquals( 1734, FunctionsGoneWild2012.f5(5, 13, 7));
      assertEquals(512486, FunctionsGoneWild2012.f6(1, 1, 2, 2));
      assertEquals(false, FunctionsGoneWild2012.f7(true, true, true) );
      assertEquals(true, FunctionsGoneWild2012.f8(false, false, false, false) );
      assertEquals(-19.6234472, FunctionsGoneWild2012.f9(6, 7, 5, 2), 0.5);
      assertEquals(true, FunctionsGoneWild2012.f10(false, false, false, false, false));
   }

   public void testFunctionsGoneWild2012_01()
   {
      assertEquals(-11, FunctionsGoneWild2012.f1(0));

      assertEquals(20490, FunctionsGoneWild2012.f1(19));
      assertEquals(36398, FunctionsGoneWild2012.f1(23));
      assertEquals(990, FunctionsGoneWild2012.f1(26));
      assertEquals(-11, FunctionsGoneWild2012.f1(28));
      assertEquals(990, FunctionsGoneWild2012.f1(40));
      assertEquals(613, FunctionsGoneWild2012.f1(66));
      assertEquals(-11, FunctionsGoneWild2012.f1(68));
      assertEquals(-11, FunctionsGoneWild2012.f1(74));
      assertEquals(6528, FunctionsGoneWild2012.f1(75));
      assertEquals(5, FunctionsGoneWild2012.f1(142));
      assertEquals(613, FunctionsGoneWild2012.f1(147));
      assertEquals(-11, FunctionsGoneWild2012.f1(178));
      assertEquals(-12, FunctionsGoneWild2012.f1(185));
      assertEquals(-12, FunctionsGoneWild2012.f1(207));
   }

   public void testFunctionsGoneWild2012_02()
   {
      assertEquals(1.0990627, FunctionsGoneWild2012.f2(6.879943654480043, 0.9795253860283353, 15.98209997973349), 0.05);
      assertEquals(0.37747028, FunctionsGoneWild2012.f2(8.918580638177945, 0.6541336249929923, 2.3973756245684896), 0.05);
      assertEquals(3993.0, FunctionsGoneWild2012.f2(20.391969755552385, 5.823933730575062, 22.402372160680734), 0.05);
      assertEquals(5058.0, FunctionsGoneWild2012.f2(6.104773734438675, 4.8318026896304165, 8.778136300955005), 0.05);
      assertEquals(76.0, FunctionsGoneWild2012.f2(14.063019996875445, 4.89701554346656, 8.84877281361069), 0.05);

      assertEquals(11.0, FunctionsGoneWild2012.f2(16.748181195128893, 3.6917671795191502, 16.244473381088543), 0.05);
      assertEquals(1.00, FunctionsGoneWild2012.f2(18.155728249147543, 5.9659658828765405, 4.67748229817289), 0.05);
      assertEquals(408.0, FunctionsGoneWild2012.f2(8.144556967848898, 4.519076898033136, 7.48894756412686), 0.05);
      assertEquals(4.00, FunctionsGoneWild2012.f2(13.262090012095609, 3.844533064346706, 7.021788393825489), 0.05);
      assertEquals(90.0, FunctionsGoneWild2012.f2(6.626457891771538, 6.964405368919202, 2.6399319447684633), 0.05);
      assertEquals(5845.0, FunctionsGoneWild2012.f2(19.38823769543353, 5.944975038442058, 20.434334677246923), 0.05);
   }

   public void testFunctionsGoneWild2012_03()
   {
      assertEquals(-1.082056, FunctionsGoneWild2012.f3(20.952211380429958, 0.5749910180881628), 0.05);
      assertEquals(-2.357380, FunctionsGoneWild2012.f3(5.458746465474832, 40.83606337414902), 0.05);
      assertEquals(11.97210, FunctionsGoneWild2012.f3(-8.833670746603781, 45.29770649889595), 0.05);
      assertEquals(0.781984, FunctionsGoneWild2012.f3(8.452596859053926, -1.3872238482937007), 0.05);
      assertEquals(12.874855, FunctionsGoneWild2012.f3(-0.9300675275319072, 29.85780218550636), 0.05);
      assertEquals(-1.5625440, FunctionsGoneWild2012.f3(12.157268658223742, 18.212828632180447), 0.05);
      assertEquals(0.5379850, FunctionsGoneWild2012.f3(18.654315885813887, 16.20163504264619), 0.05);
      assertEquals(0.6469315, FunctionsGoneWild2012.f3(10.46524153019099, 12.93342299188663), 0.05);

      assertEquals(0.124496, FunctionsGoneWild2012.f3(8.762740506643297, -6.720557514021419), 0.05);
      assertEquals(176.92744, FunctionsGoneWild2012.f3(23.718412301565756, 41.759265017639976), 0.05);
      assertEquals(-8.39787, FunctionsGoneWild2012.f3(-8.010365972582631, 38.130013785550105), 0.05);
      assertEquals(5.832069, FunctionsGoneWild2012.f3(-0.8697684489871058, 33.843401492317234), 0.05);      assertEquals(1.946647779658317, FunctionsGoneWild2012.f3(19.922316236375714, 2.0327465170798256), 0.05);
      assertEquals(-0.592385, FunctionsGoneWild2012.f3(2.1506947334200035, 40.239737511070025), 0.05);
      assertEquals(2.3410065, FunctionsGoneWild2012.f3(19.46294131012293, 21.653965546635135), 0.05);
      assertEquals(-3.28196, FunctionsGoneWild2012.f3(-12.96541653183203, 17.563815623461885), 0.05);
      assertEquals(1.67475, FunctionsGoneWild2012.f3(-8.225415344969615, 46.99875398341412), 0.05);
    }

   public void testFunctionsGoneWild2012_04()
   {
      assertEquals(6.8844846, FunctionsGoneWild2012.f4(-6.024154213908606, -12.708555801400852, 17.156283145746002), 0.05);
      assertEquals(8.14743158, FunctionsGoneWild2012.f4(8.276306373918171, 24.33788502747577, -6.582787570743582), 0.05);
      assertEquals(0.4786, FunctionsGoneWild2012.f4(23.810866697218692, 21.169455859761705, -17.15104639956163), 0.05);
      assertEquals(1.698128, FunctionsGoneWild2012.f4(-0.9247879714180129, 20.207665608144993, -17.839741531090045), 0.05);
      assertEquals(5.3895719, FunctionsGoneWild2012.f4(-1.3038482440240386, 25.3890452634078, -9.541473085996762), 0.05);
      assertEquals(1.780477, FunctionsGoneWild2012.f4(9.211099314935012, 8.627648205784407, 16.441869399059883), 0.05);
      assertEquals(6.382255, FunctionsGoneWild2012.f4(14.758463655984752, 30.48206084099246, 1.1727101286952895), 0.05);
      assertEquals(11.1521, FunctionsGoneWild2012.f4(70.55107842503057, 93.57917463691224, 55.0548486582028), 0.05);
   }

   public void testFunctionsGoneWild2012_05()
   {
      assertEquals(185137, FunctionsGoneWild2012.f5(40, 43, 20));
      assertEquals(34000, FunctionsGoneWild2012.f5(13, 9, 41));
      assertEquals(18352, FunctionsGoneWild2012.f5(7, 32, 29));
      assertEquals(96601, FunctionsGoneWild2012.f5(34, 15, 31));
      assertEquals(177519, FunctionsGoneWild2012.f5(31, 37, 41));
   }

   public void testFunctionsGoneWild2012_06()
   {
      assertEquals(0, FunctionsGoneWild2012.f6(4, 5, 3, 1));
//      assertEquals(-32, FunctionsGoneWild2012.f6(2, 3, 4, 2));
      assertEquals(-19682, FunctionsGoneWild2012.f6(1, 2, 2, 1));
//      assertEquals(1620, FunctionsGoneWild2012.f6(1, 3, 4, 3));
      assertEquals(61684, FunctionsGoneWild2012.f6(1, 1, 3, 1));
//      assertEquals(33215, FunctionsGoneWild2012.f6(0, 4, 5, 2));
      assertEquals(-1, FunctionsGoneWild2012.f6(2, 5, 5, 3));
//      assertEquals(-29956, FunctionsGoneWild2012.f6(1, 6, 5, 3));
      assertEquals(-2104961808, FunctionsGoneWild2012.f6(1, 1, 2, 3));
//      assertEquals(-486, FunctionsGoneWild2012.f6(1, 4, 4, 2));
      assertEquals(0, FunctionsGoneWild2012.f6(1, 7, 3, 3));
      assertEquals(5844, FunctionsGoneWild2012.f6(0, 1, 3, 1));
    }

   public void testFunctionsGoneWild2012_07()
   {
      assertEquals(false, FunctionsGoneWild2012.f7(true, true, true) );
      assertEquals(true, FunctionsGoneWild2012.f7(true, true, false) );
      assertEquals(true, FunctionsGoneWild2012.f7(true, false, true) );
      assertEquals(false, FunctionsGoneWild2012.f7(true, false, false) );

      assertEquals(false, FunctionsGoneWild2012.f7(false, true, true) );
      assertEquals(true, FunctionsGoneWild2012.f7(false, true, false) );
      assertEquals(false, FunctionsGoneWild2012.f7(false, false, true) );
      assertEquals(true, FunctionsGoneWild2012.f7(false, false, false) );
   }

   public void testFunctionsGoneWild2012_08()
   {
      assertEquals(true, FunctionsGoneWild2012.f8(false, false, false, false));
      assertEquals(false, FunctionsGoneWild2012.f8(false, false, false, true));
      assertEquals(true, FunctionsGoneWild2012.f8(false, false, true, false));
      assertEquals(false, FunctionsGoneWild2012.f8(false, false, true, true));
      assertEquals(false, FunctionsGoneWild2012.f8(false, true, false, false));
      assertEquals(false, FunctionsGoneWild2012.f8(false, true, false, true));
      assertEquals(true, FunctionsGoneWild2012.f8(false, true, true, false));
      assertEquals(true, FunctionsGoneWild2012.f8(false, true, true, true));
      
      assertEquals(false, FunctionsGoneWild2012.f8(true, false, false, false));
      assertEquals(true, FunctionsGoneWild2012.f8(true, false, false, true));
      assertEquals(true, FunctionsGoneWild2012.f8(true, false, true, false));
      assertEquals(false, FunctionsGoneWild2012.f8(true, false, true, true));
      assertEquals(true, FunctionsGoneWild2012.f8(true, true, false, false));
      assertEquals(true, FunctionsGoneWild2012.f8(true, true, false, true));
      assertEquals(false, FunctionsGoneWild2012.f8(true, true, true, false));
      assertEquals(true, FunctionsGoneWild2012.f8(true, true, true, true));
   }

   public void testFunctionsGoneWild2012_09()
   {
      assertEquals(-0.11995, FunctionsGoneWild2012.f9(3, 7, 0, 3), 0.5);
      assertEquals(-10.084, FunctionsGoneWild2012.f9(2, 7, 4, 3), 0.5);
      assertEquals(6.74813, FunctionsGoneWild2012.f9(5, 7, 5, 2), 0.5);
      assertEquals(1.3966, FunctionsGoneWild2012.f9(0, 7, 2, 1), 0.5);
      assertEquals(6.250, FunctionsGoneWild2012.f9(7, 4, 5, 2), 0.5);
      assertEquals(4.0390, FunctionsGoneWild2012.f9(1, 4, 1, 2), 0.5);
      assertEquals(8.42090, FunctionsGoneWild2012.f9(5, 3, 2, 2), 0.5);
      assertEquals(-0.5720, FunctionsGoneWild2012.f9(0, 4, 2, 1), 0.5);
      assertEquals(10.924777, FunctionsGoneWild2012.f9(37.607567145734265, 42.172029421387116, 116.40979427562999, 127.18331332550972), 0.5);
 
      assertEquals(-0.9152966, FunctionsGoneWild2012.f9(5, 6, 2, 3), 0.5);
      assertEquals(0.5233600, FunctionsGoneWild2012.f9(4, 1, 5, 3), 0.5);
      assertEquals(1.345060, FunctionsGoneWild2012.f9(2, 6, 0, 1), 0.5);
      assertEquals(6.59682, FunctionsGoneWild2012.f9(1, 7, 1, 3), 0.5);
      assertEquals(-1.13005, FunctionsGoneWild2012.f9(44.16974605713263, 44.97025886112936, 105.87006691005234, 84.40506759369359), 0.5);
      assertEquals(-0.329381, FunctionsGoneWild2012.f9(4, 3, 0, 2), 0.5);
      assertEquals(-1.54745, FunctionsGoneWild2012.f9(2, 2, 5, 2), 0.5);
      assertEquals(-19.6234472, FunctionsGoneWild2012.f9(6, 7, 5, 2), 0.5);
   }

   public void testFunctionsGoneWild2012_10()
   {
      assertEquals(true, FunctionsGoneWild2012.f10(false, false, false, false, false));
      assertEquals(true, FunctionsGoneWild2012.f10(false, false, false, false, true));
      assertEquals(true, FunctionsGoneWild2012.f10(false, false, false, true, false));
      assertEquals(true, FunctionsGoneWild2012.f10(false, false, false, true, true) );
      assertEquals(false, FunctionsGoneWild2012.f10(false, false, true, false, false));
      assertEquals(false, FunctionsGoneWild2012.f10(false, false, true, false, true));
      assertEquals(true, FunctionsGoneWild2012.f10(false, false, true, true, false));
      assertEquals(true, FunctionsGoneWild2012.f10(false, false, true, true, true));

      assertEquals(true, FunctionsGoneWild2012.f10(false, true, false, false, false) );
      assertEquals(false, FunctionsGoneWild2012.f10(false, true, false, false, true) );
      assertEquals(true, FunctionsGoneWild2012.f10(false, true, false, true, false) );
      assertEquals(true, FunctionsGoneWild2012.f10(false, true, false, true, true) );

      assertEquals(true, FunctionsGoneWild2012.f10(false, true, true, false, false) );
      assertEquals(false, FunctionsGoneWild2012.f10(false, true, true, false, true) );
      assertEquals(false, FunctionsGoneWild2012.f10(false, true, true, true, false) );
      assertEquals(false, FunctionsGoneWild2012.f10(false, true, true, true, true) );

      assertEquals(true, FunctionsGoneWild2012.f10(true, false, false, false, false) );
      assertEquals(true, FunctionsGoneWild2012.f10(true, false, false, false, true) );
      assertEquals(true, FunctionsGoneWild2012.f10(true, false, false, true, false) );
      assertEquals(false, FunctionsGoneWild2012.f10(true, false, false, true, true) );

      assertEquals(false, FunctionsGoneWild2012.f10(true, false, true, false, false) );
      assertEquals(false, FunctionsGoneWild2012.f10(true, false, true, false, true) );
      assertEquals(false, FunctionsGoneWild2012.f10(true, false, true, true, false) );
      assertEquals(false, FunctionsGoneWild2012.f10(true, false, true, true, true) );

      assertEquals(true, FunctionsGoneWild2012.f10(true, true, false, false, false) );
      assertEquals(true, FunctionsGoneWild2012.f10(true, true, false, false, true) );
      assertEquals(true, FunctionsGoneWild2012.f10(true, true, false, true, false) );
      assertEquals(true, FunctionsGoneWild2012.f10(true, true, false, true, true) );

      assertEquals(true, FunctionsGoneWild2012.f10(true, true, true, false, false) );
      assertEquals(true, FunctionsGoneWild2012.f10(true, true, true, false, true) );
      assertEquals(true, FunctionsGoneWild2012.f10(true, true, true, true, false) );
      assertEquals(true, FunctionsGoneWild2012.f10(true, true, true, true, true) );
    }

   public void testFunctionsGoneWild2012_11()
   {
      testFunctionsGoneWild2012_01();
      testFunctionsGoneWild2012_02();
      testFunctionsGoneWild2012_03();
      testFunctionsGoneWild2012_04();
   }

   public void testFunctionsGoneWild2012_12()
   {
      testFunctionsGoneWild2012_05();
      testFunctionsGoneWild2012_06();
   }

   public void testFunctionsGoneWild2012_13()
   {
      testFunctionsGoneWild2012_07();
      testFunctionsGoneWild2012_08();
      testFunctionsGoneWild2012_09();
      testFunctionsGoneWild2012_10();
   }

   public void testFunctionsGoneWild2012_14()
   {
      testFunctionsGoneWild2012_11();
      testFunctionsGoneWild2012_12();
      testFunctionsGoneWild2012_13();
   }
   public void testIRobot01()
   {
      List<String> colors = new ArrayList<String>();
      colors.add("RED");
      colors.add("BLUE");
      colors.add("ORANGE");
      colors.add("YELLOW");
      colors.add("GREEN");
      colors.add("VIOLET");
      colors.add("INDIGO");

      IRobot ir = new IRobot(colors);
      ir.command("pick up RED block with MIDDLE hand");
      ir.command("pick up BLUE block with LEFT hand");
      ir.command("pick up GREEN block with RIGHT hand");
      ir.command("place block in LEFT hand on VIOLET block");
      ir.command("place block in MIDDLE hand on BLUE block");
      ir.command("pick up INDIGO block with MIDDLE hand");
      ir.command("place block in MIDDLE hand on ORANGE block");

      assertEquals("YES", ir.question("is the VIOLET directly on the table"));
      assertEquals("YES", ir.question("is your MIDDLE hand empty"));
      assertEquals("NO", ir.question("is your RIGHT hand empty"));
      assertEquals("YES", ir.question("is the YELLOW directly on the table"));
      assertEquals("RED", ir.question("what is the color of the block directly on top of the BLUE block"));
      assertEquals("YES", ir.question("is there anything directly on top of the VIOLET block"));
      assertEquals("YES", ir.question("is there anything directly on top of the BLUE block"));
      assertEquals("YES", ir.question("is there anything directly on top of the ORANGE block"));

      assertEquals("GREEN", ir.question("what is the color of the block in your RIGHT hand"));
      assertEquals("NO", ir.question("is the GREEN directly on the table"));
      ir.command("drop block in RIGHT hand on table");

      assertEquals("YES", ir.question("is the YELLOW directly on the table"));
      ir.command("pick up YELLOW block and place on GREEN block");
      assertEquals("YES", ir.question("is there anything directly on top of the GREEN block"));
   }

   public void testIRobot02()   // is the hand empty test - pick up -- with -- hand
   {                            //                        - drop block in --- hand
      List<String> colors = new ArrayList<String>();
      colors.add("RED");
      colors.add("BLUE");
      colors.add("ORANGE");
      colors.add("YELLOW");
      colors.add("GREEN");
      colors.add("VIOLET");
      colors.add("INDIGO");
      IRobot ir = new IRobot(colors);

      assertEquals("YES", ir.question("is your LEFT hand empty"));
      assertEquals("YES", ir.question("is your RIGHT hand empty"));
      assertEquals("YES", ir.question("is your MIDDLE hand empty"));
      ir.command("pick up RED block with MIDDLE hand");
      ir.command("pick up INDIGO block with RIGHT hand");
      ir.command("pick up YELLOW block with LEFT hand");
      assertEquals("NO", ir.question("is your LEFT hand empty"));
      assertEquals("NO", ir.question("is your RIGHT hand empty"));
      assertEquals("NO", ir.question("is your MIDDLE hand empty"));
      ir.command("drop block in MIDDLE hand on table");
      ir.command("drop block in LEFT hand on table");
      ir.command("drop block in RIGHT hand on table");
      assertEquals("YES", ir.question("is your LEFT hand empty"));
      assertEquals("YES", ir.question("is your RIGHT hand empty"));
      assertEquals("YES", ir.question("is your MIDDLE hand empty"));
   }

   public void testIRobot03()   // is on directly on table test - pick up -- with -- hand
   {                            //                              - drop block in --- hand
      List<String> colors = new ArrayList<String>();    //      - place ---- block on --- block
      colors.add("RED");
      colors.add("BLUE");
      colors.add("ORANGE");
      colors.add("YELLOW");
      colors.add("GREEN");
      colors.add("VIOLET");
      colors.add("INDIGO");
      IRobot ir = new IRobot(colors);

      assertEquals("YES", ir.question("is the RED directly on the table"));
      assertEquals("YES", ir.question("is the BLUE directly on the table"));
      assertEquals("YES", ir.question("is the ORANGE directly on the table"));
      assertEquals("YES", ir.question("is the YELLOW directly on the table"));
      assertEquals("YES", ir.question("is the GREEN directly on the table"));
      assertEquals("YES", ir.question("is the VIOLET directly on the table"));
      assertEquals("YES", ir.question("is the INDIGO directly on the table"));

      ir.command("pick up RED block with MIDDLE hand");
      ir.command("pick up INDIGO block with RIGHT hand");
      ir.command("pick up YELLOW block with LEFT hand");
      assertEquals("NO", ir.question("is the RED directly on the table"));
      assertEquals("NO", ir.question("is the INDIGO directly on the table"));
      assertEquals("NO", ir.question("is the YELLOW directly on the table"));

      ir.command("drop block in LEFT hand on table");
      ir.command("pick up BLUE block and place on GREEN block");
      ir.command("pick up ORANGE block with LEFT hand");
      ir.command("place block in MIDDLE hand on BLUE block");

      assertEquals("NO", ir.question("is the RED directly on the table"));
      assertEquals("NO", ir.question("is the BLUE directly on the table"));
      assertEquals("NO", ir.question("is the ORANGE directly on the table"));
      assertEquals("YES", ir.question("is the YELLOW directly on the table"));
      assertEquals("YES", ir.question("is the GREEN directly on the table"));
      assertEquals("YES", ir.question("is the VIOLET directly on the table"));
      assertEquals("NO", ir.question("is the INDIGO directly on the table"));
   }

   public void testIRobot04()   // is there anything directly on top of the ----- block test - pick up -- with -- hand
   {                            //                                                           - drop block in --- hand
      List<String> colors = new ArrayList<String>();
      colors.add("RED");
      colors.add("BLUE");
      colors.add("ORANGE");
      colors.add("YELLOW");
      colors.add("GREEN");
      colors.add("VIOLET");
      colors.add("INDIGO");
      IRobot ir = new IRobot(colors);

      assertEquals("NO", ir.question("is there anything directly on top of the RED block"));
      assertEquals("NO", ir.question("is there anything directly on top of the BLUE block"));
      assertEquals("NO", ir.question("is there anything directly on top of the ORANGE block"));
      assertEquals("NO", ir.question("is there anything directly on top of the YELLOW block"));
      assertEquals("NO", ir.question("is there anything directly on top of the GREEN block"));
      assertEquals("NO", ir.question("is there anything directly on top of the VIOLET block"));
      assertEquals("NO", ir.question("is there anything directly on top of the INDIGO block"));

      ir.command("pick up BLUE block with MIDDLE hand");
      ir.command("pick up ORANGE block with RIGHT hand");
      ir.command("pick up GREEN block with LEFT hand");
      ir.command("place block in MIDDLE hand on RED block");
      ir.command("place block in RIGHT hand on YELLOW block");
      ir.command("place block in LEFT hand on INDIGO block");

      assertEquals("YES", ir.question("is there anything directly on top of the RED block"));
      assertEquals("NO", ir.question("is there anything directly on top of the BLUE block"));
      assertEquals("NO", ir.question("is there anything directly on top of the ORANGE block"));
      assertEquals("YES", ir.question("is there anything directly on top of the YELLOW block"));
      assertEquals("NO", ir.question("is there anything directly on top of the GREEN block"));
      assertEquals("NO", ir.question("is there anything directly on top of the VIOLET block"));
      assertEquals("YES", ir.question("is there anything directly on top of the INDIGO block"));
   }

   public void testIRobot05()   // is there anything directly on top of the ----- block test - pick up -- with -- hand
   {                            //                                                           - drop block in --- hand
      List<String> colors = new ArrayList<String>();    //                                   - place ---- block on --- block
      colors.add("RED");
      colors.add("BLUE");
      colors.add("ORANGE");
      colors.add("YELLOW");
      colors.add("GREEN");
      colors.add("VIOLET");
      colors.add("INDIGO");
      IRobot ir = new IRobot(colors);

      assertEquals("NO", ir.question("is there anything directly on top of the RED block"));
      assertEquals("NO", ir.question("is there anything directly on top of the BLUE block"));
      assertEquals("NO", ir.question("is there anything directly on top of the ORANGE block"));
      assertEquals("NO", ir.question("is there anything directly on top of the YELLOW block"));
      assertEquals("NO", ir.question("is there anything directly on top of the GREEN block"));
      assertEquals("NO", ir.question("is there anything directly on top of the VIOLET block"));
      assertEquals("NO", ir.question("is there anything directly on top of the INDIGO block"));

      ir.command("pick up BLUE block with MIDDLE hand");
      ir.command("pick up ORANGE block with RIGHT hand");
      ir.command("pick up GREEN block with LEFT hand");
      ir.command("place block in MIDDLE hand on RED block");
      ir.command("place block in RIGHT hand on YELLOW block");
      ir.command("place block in LEFT hand on INDIGO block");

      assertEquals("YES", ir.question("is there anything directly on top of the RED block"));
      assertEquals("NO", ir.question("is there anything directly on top of the BLUE block"));
      assertEquals("NO", ir.question("is there anything directly on top of the ORANGE block"));
      assertEquals("YES", ir.question("is there anything directly on top of the YELLOW block"));
      assertEquals("NO", ir.question("is there anything directly on top of the GREEN block"));
      assertEquals("NO", ir.question("is there anything directly on top of the VIOLET block"));
      assertEquals("YES", ir.question("is there anything directly on top of the INDIGO block"));

      ir.command("pick up ORANGE block and place on GREEN block");
      ir.command("pick up YELLOW block and place on BLUE block");

      assertEquals("YES", ir.question("is there anything directly on top of the RED block"));
      assertEquals("YES", ir.question("is there anything directly on top of the BLUE block"));
      assertEquals("NO", ir.question("is there anything directly on top of the ORANGE block"));
      assertEquals("NO", ir.question("is there anything directly on top of the YELLOW block"));
      assertEquals("YES", ir.question("is there anything directly on top of the GREEN block"));
      assertEquals("NO", ir.question("is there anything directly on top of the VIOLET block"));
      assertEquals("YES", ir.question("is there anything directly on top of the INDIGO block"));

      assertEquals("YES", ir.question("is the RED directly on the table"));
      assertEquals("NO", ir.question("is the BLUE directand placely on the table"));
      assertEquals("NO", ir.question("is the ORANGE directly on the table"));
      assertEquals("NO", ir.question("is the YELLOW directly on the table"));
      assertEquals("NO", ir.question("is the GREEN directly on the table"));
      assertEquals("YES", ir.question("is the VIOLET directly on the table"));
      assertEquals("YES", ir.question("is the INDIGO directly on the table"));
   }

   public void testIRobot06()   // is there anything directly on top of the ----- block test - pick up -- with -- hand
   {                            //                                                           - drop block in --- hand
      List<String> colors = new ArrayList<String>();
      colors.add("RED");
      colors.add("BLUE");
      colors.add("ORANGE");
      colors.add("YELLOW");
      colors.add("GREEN");
      colors.add("VIOLET");
      colors.add("INDIGO");
      IRobot ir = new IRobot(colors);

      ir.command("pick up YELLOW block with MIDDLE hand");
      ir.command("pick up VIOLET block with RIGHT hand");
      ir.command("pick up INDIGO block with LEFT hand");
      ir.command("place block in MIDDLE hand on RED block");
      ir.command("place block in RIGHT hand on YELLOW block");
      ir.command("place block in LEFT hand on BLUE block");

      assertEquals("YELLOW", ir.question("what is the color of the block directly on top of the RED block"));
      assertEquals("VIOLET", ir.question("what is the color of the block directly on top of the YELLOW block"));
      assertEquals("INDIGO", ir.question("what is the color of the block directly on top of the BLUE block"));

      ir.command("pick up INDIGO block with LEFT hand");
      ir.command("place block in LEFT hand on ORANGE block");
      ir.command("pick up GREEN block with RIGHT hand");
      ir.command("place block in RIGHT hand on VIOLET block");

      assertEquals("YELLOW", ir.question("what is the color of the block directly on top of the RED block"));
      assertEquals("VIOLET", ir.question("what is the color of the block directly on top of the YELLOW block"));
      assertEquals("INDIGO", ir.question("what is the color of the block directly on top of the ORANGE block"));
      assertEquals("GREEN", ir.question("what is the color of the block directly on top of the VIOLET block"));
    }

   public void testIRobot07()   // color of the block directly on top of the ---- block test - pick up -- with -- hand
   {                            //                                                           - drop block in --- hand
      List<String> colors = new ArrayList<String>();    //                                   - place ---- block on --- block
      colors.add("RED");
      colors.add("BLUE");
      colors.add("ORANGE");
      colors.add("YELLOW");
      colors.add("GREEN");
      colors.add("VIOLET");
      colors.add("INDIGO");
      IRobot ir = new IRobot(colors);

      ir.command("pick up ORANGE block and place on GREEN block");
      ir.command("pick up YELLOW block and place on BLUE block");
      ir.command("pick up RED block and place on YELLOW block");
      ir.command("pick up VIOLET block and place on RED block");
      ir.command("pick up INDIGO block and place on ORANGE block");

      assertEquals("YELLOW", ir.question("what is the color of the block directly on top of the BLUE block"));
      assertEquals("RED", ir.question("what is the color of the block directly on top of the YELLOW block"));
      assertEquals("VIOLET", ir.question("what is the color of the block directly on top of the RED block"));
      assertEquals("ORANGE", ir.question("what is the color of the block directly on top of the GREEN block"));
   }

   public void testIRobot08()   // what is the color of the block in your ---- hand test    - pick up -- with -- hand
   {                            //                                                          - drop block in --- hand
      List<String> colors = new ArrayList<String>();
      colors.add("RED");
      colors.add("BLUE");
      colors.add("ORANGE");
      colors.add("YELLOW");
      colors.add("GREEN");
      colors.add("VIOLET");
      colors.add("INDIGO");
      IRobot ir = new IRobot(colors);

      ir.command("pick up INDIGO block with LEFT hand");
      ir.command("pick up YELLOW block with MIDDLE hand");
      ir.command("pick up VIOLET block with RIGHT hand");

      assertEquals("INDIGO", ir.question("what is the color of the block in your LEFT hand"));
      assertEquals("YELLOW", ir.question("what is the color of the block in your MIDDLE hand"));
      assertEquals("VIOLET", ir.question("what is the color of the block in your RIGHT hand"));

      ir.command("drop block in LEFT hand on table");
      ir.command("drop block in MIDDLE hand on table");
      ir.command("drop block in RIGHT hand on table");

      ir.command("pick up RED block with LEFT hand");
      ir.command("pick up BLUE block with MIDDLE hand");
      ir.command("pick up ORANGE block with RIGHT hand");

      assertEquals("RED", ir.question("what is the color of the block in your LEFT hand"));
      assertEquals("BLUE", ir.question("what is the color of the block in your MIDDLE hand"));
      assertEquals("ORANGE", ir.question("what is the color of the block in your RIGHT hand"));

      ir.command("drop block in LEFT hand on table");
      ir.command("drop block in MIDDLE hand on table");
      ir.command("drop block in RIGHT hand on table");

      ir.command("pick up GREEN block with LEFT hand");
      ir.command("pick up RED block with MIDDLE hand");
      ir.command("pick up INDIGO block with RIGHT hand");

      assertEquals("GREEN", ir.question("what is the color of the block in your LEFT hand"));
      assertEquals("RED", ir.question("what is the color of the block in your MIDDLE hand"));
      assertEquals("INDIGO", ir.question("what is the color of the block in your RIGHT hand"));
    }

   public void testIRobot09()
   {
      testIRobot02();
      testIRobot03();
      testIRobot04();
      testIRobot05();
   }

   public void testIRobot10()
   {
      testIRobot05();
      testIRobot06();
      testIRobot07();
      testIRobot08();
   }
   public void testJumble01()
   {
      Jumble j = new Jumble( "SPAM" );
      assertEquals(0, j.numLettersInCorrectLocation( "MAPS" ));
      assertEquals("good", j.getRating( "MASP" ));
      assertEquals("fair", j.getRating( "MAPS" ));
      assertEquals("poor", j.getRating( "SaPM" ));
      assertEquals("not", j.getRating( "SPAM" ));

      j = new Jumble( "STOP" );
      assertEquals(0, j.numLettersInCorrectLocation( "PSTO" ));
      assertEquals(2, j.numLettersInCorrectLocation( "SOTP" ));

      j = new Jumble( "KITE" );
      assertEquals(true, j.looksReal( "KITE" ));
      assertEquals(true, j.looksReal( "IKET" ));
      assertEquals(false, j.looksReal( "KTEI" ));
      assertEquals(false, j.looksReal( "ETKI" ));
   }

   public void testJumble02()   //    numLettersInCorrectLocation
   {
      Jumble j = new Jumble( "IRONY" );        //  IO  YO   OY
      assertEquals(1, j.numLettersInCorrectLocation( "IORYN" ));
      assertEquals(2, j.numLettersInCorrectLocation( "YROIN" ));
      assertEquals(3, j.numLettersInCorrectLocation( "RIONY" ));
      assertEquals(5, j.numLettersInCorrectLocation( "IRONY" ));

      j = new Jumble( "COMPUTER" );
      assertEquals(0, j.numLettersInCorrectLocation( "OMPUTERC" ));
      assertEquals(1, j.numLettersInCorrectLocation( "OMPUTECR" ));
      assertEquals(2, j.numLettersInCorrectLocation( "OMCPURTE" ));
      assertEquals(3, j.numLettersInCorrectLocation( "OMPUCTER" ));
      assertEquals(4, j.numLettersInCorrectLocation( "COMPRUTE" ));
      assertEquals(5, j.numLettersInCorrectLocation( "ROMPUTCE" ));
      assertEquals(6, j.numLettersInCorrectLocation( "ROMPUTEC" ));
      assertEquals(8, j.numLettersInCorrectLocation( "COMPUTER" ));
   }

   public void testJumble03()   //    looksReal
   {
      Jumble j = new Jumble( "HOSE" );
      assertEquals("not", j.getRating( "HOSE" ));
      assertEquals("good", j.getRating( "OHES" ));
      assertEquals("poor", j.getRating( "HOES" ));
      assertEquals("fair", j.getRating( "SOHE" ));

      j = new Jumble( "WATER" );
      assertEquals("not", j.getRating( "WATER" ));
      assertEquals("good", j.getRating( "TERAW" ));
      assertEquals("poor", j.getRating( "ARTEW" ));
      assertEquals("fair", j.getRating( "RWARE" ));
   }

   public void testJumble04()   //     getRating
   {
      Jumble j = new Jumble( "SCIENCE" );         //   SC
      assertEquals("not", j.getRating( "SCIENCE" ));
      assertEquals("poor", j.getRating( "ECIENSCE" ));
      assertEquals("fair", j.getRating( "CIENCES" ));
      assertEquals("good", j.getRating( "INESCEC" ));

      j = new Jumble( "CONTEST" );                //  TT   SC
      assertEquals("not", j.getRating( "CONTEST" ));
      assertEquals("poor", j.getRating( "TOSTECN" ));
      assertEquals("fair", j.getRating( "ONTESTC" ));
      assertEquals("good", j.getRating( "TTESCON" ));
   }

   public void testJumble05()   //     numLettersInCorrectLocation && looksReal
   {

      testJumble02();           //    numLettersInCorrectLocation
      Jumble j = new Jumble( "BOOKKEEPER" );
      assertEquals(0, j.numLettersInCorrectLocation( "OBKOEKPERE" ));
      assertEquals(1, j.numLettersInCorrectLocation( "BKKEEPROOE" ));
      assertEquals(2, j.numLettersInCorrectLocation( "OERKKBOEPE" ));
      assertEquals(3, j.numLettersInCorrectLocation( "PERKKEBOOE" ));
      assertEquals(5, j.numLettersInCorrectLocation( "BEOKEKEPRO" ));
      assertEquals(6, j.numLettersInCorrectLocation( "ROOKKBEEEP" ));

      j = new Jumble( "WAISTBAND" );
      assertEquals(0, j.numLettersInCorrectLocation( "AISTBANDW" ));
      assertEquals(1, j.numLettersInCorrectLocation( "TWAITDBAN" ));
      assertEquals(2, j.numLettersInCorrectLocation( "SAWIBANTD" ));
      assertEquals(3, j.numLettersInCorrectLocation( "WIASBTNAD" ));
      assertEquals(4, j.numLettersInCorrectLocation( "WIASBTNND" ));
      assertEquals(5, j.numLettersInCorrectLocation( "DAITSBANW" ));
      assertEquals(6, j.numLettersInCorrectLocation( "TAISBWAND" ));
      assertEquals(7, j.numLettersInCorrectLocation( "DAISTBANW" ));

      testJumble03();           //    looksReal
      j = new Jumble( "IRONY" );                 //     IO  YO  OY
      assertEquals(true, j.looksReal( "RIONY" ));
      assertEquals(true, j.looksReal( "ORINY" ));
      assertEquals(true, j.looksReal( "RINOY" ));
      assertEquals(true, j.looksReal( "YORIN" ));
      assertEquals(false, j.looksReal( "ROINY" ));
      assertEquals(false, j.looksReal( "IYRON" ));
      assertEquals(false, j.looksReal( "YINRO" ));

      j = new Jumble( "JUMBLE" );               //     BL
      assertEquals(true, j.looksReal( "BLUMEJ" ));
      assertEquals(true, j.looksReal( "JUMEBL" ));
      assertEquals(true, j.looksReal( "MUBLEJ" ));
      assertEquals(false, j.looksReal( "BUMLEJ" ));
      assertEquals(false, j.looksReal( "JUMBLE" ));
      assertEquals(false, j.looksReal( "MJUEBL" ));
   }

   public void testJumble06()   //     numLettersInCorrectLocation && getRating
   {
      testJumble02();           //    numLettersInCorrectLocation

      Jumble j = new Jumble( "SLATHER" );
      assertEquals(0, j.numLettersInCorrectLocation( "RSLATHE" ));
      assertEquals(1, j.numLettersInCorrectLocation( "RLTHERA" ));
      assertEquals(2, j.numLettersInCorrectLocation( "LSATRHE" ));
      assertEquals(3, j.numLettersInCorrectLocation( "SLAERTH" ));
      assertEquals(4, j.numLettersInCorrectLocation( "ASLTHER" ));
      assertEquals(5, j.numLettersInCorrectLocation( "RLATHES" ));
      assertEquals(7, j.numLettersInCorrectLocation( "SLATHER" ));

      j = new Jumble( "DACTYLIC" );
      assertEquals(0, j.numLettersInCorrectLocation( "ADTCLYCI" ));
      assertEquals(1, j.numLettersInCorrectLocation( "IDACTYLC" ));
      assertEquals(2, j.numLettersInCorrectLocation( "CADTCYLI" ));
      assertEquals(3, j.numLettersInCorrectLocation( "CIDTYLCA" ));
      assertEquals(4, j.numLettersInCorrectLocation( "DACTCYLI" ));
      assertEquals(5, j.numLettersInCorrectLocation( "ACDTYLIC" ));
      assertEquals(6, j.numLettersInCorrectLocation( "DACTYLCI" ));

      testJumble04();           //     getRating

      j = new Jumble( "SHRUB" );    //   SHR    SH   BR
      assertEquals("not", j.getRating( "SHRUB" ));
      assertEquals("good", j.getRating( "BUSHR" ));
      assertEquals("fair", j.getRating( "SHUBR" )); // TODO why is this fair?
      assertEquals("good", j.getRating( "BRUSH" ));
      assertEquals("poor", j.getRating( "SUBRH" ));
      assertEquals("poor", j.getRating( "SHURB" ));

      j = new Jumble( "SCHOOL" );    //  SCH   SH   CH   OO
      assertEquals("not", j.getRating(  "SCHOOL" ));
      assertEquals("fair", j.getRating( "HLOSC0" ));
      assertEquals("good", j.getRating( "LOOSCH" ));    //  SCH  OO
      assertEquals("fair", j.getRating( "SLOOCH" ));    //  CH   SL TODO Same here, starts with same letter
      assertEquals("fair", j.getRating( "HOL0SC" ));    //   SC
      assertEquals("fair", j.getRating( "LOSOCH" ));    //   
      assertEquals("poor", j.getRating( "HCOSOL" ));    //   
    }

   public void testJumble07()   //     looksReal && getRating
   {
      testJumble03();           //    looksReal
      Jumble j = new Jumble( "IRRITATE" );     //  RR TT AI  TR
      assertEquals(true, j.looksReal( "IRRITATE" ));    //  RR
      assertEquals(true, j.looksReal( "ERRITTAI" ));    //  TT  AI
      assertEquals(true, j.looksReal( "TETIRARI" ));
      assertEquals(false, j.looksReal( "IRRIATTE" ));
      assertEquals(false, j.looksReal( "RITITRAE" ));
      assertEquals(false, j.looksReal( "IRTAIRTE" ));
      assertEquals(true, j.looksReal( "ETRITRAI" ));    //  TR

      j = new Jumble( "ATTENTION" );     //  TT NN IO
      assertEquals(true, j.looksReal( "ONNATTETI" ));     //  NN  TT
      assertEquals(true, j.looksReal( "NATTETION" ));     //  IO
      assertEquals(true, j.looksReal( "TITENATON" ));
      assertEquals(false, j.looksReal( "ATTENTION" ));
      assertEquals(false, j.looksReal( "ATTETNION" ));
      assertEquals(false, j.looksReal( "ATTTENION" ));

      testJumble04();           //     getRating

      j = new Jumble( "SCREAM" );                 //  SCR  SR  EA 
      assertEquals("not", j.getRating( "SCREAM" ));
      assertEquals("fair", j.getRating( "SECRAM" ));    //  CR
      assertEquals("good", j.getRating( "CEMASC" ));    //  SC
      assertEquals("good", j.getRating( "MEASCR" ));    //  SCR  EA

      j = new Jumble( "CROUPY" );             //  CR OY YO YU
      assertEquals("not", j.getRating( "CROUPY" ));
      assertEquals("good", j.getRating( "YOCRUP" ));   //  YO  CR
      assertEquals("good", j.getRating( "YUCROP" ));   //  YU  CR
      assertEquals("good", j.getRating( "OYCRUP" ));   //  OY  CR

      j = new Jumble( "STOP" );
//      assertEquals(2, j.numLettersInCorrectLocation( "SOTP" ));
      assertEquals(false, j.looksReal( "SOTP" ));
      assertEquals("poor", j.getRating( "SOTP" ));
   }

   public void testJumble08()      //  test all
   {
      Jumble j = new Jumble( "DAGLOCKS" );
      assertEquals(0, j.numLettersInCorrectLocation( "ADLGCOSK" ));
      assertEquals(1, j.numLettersInCorrectLocation( "GDALCOSK" ));
      assertEquals(2, j.numLettersInCorrectLocation( "LDAGOCSK" ));
      assertEquals(3, j.numLettersInCorrectLocation( "DLAGOCSK" ));
      assertEquals(4, j.numLettersInCorrectLocation( "DAGOLCSK" ));
      assertEquals(5, j.numLettersInCorrectLocation( "DAGCLOKS" ));
      assertEquals(6, j.numLettersInCorrectLocation( "DAGOLCKS" ));
      assertEquals(8, j.numLettersInCorrectLocation( "DAGLOCKS" ));

      j = new Jumble( "DAIMONES" );      //  AI  EO  SN  SM  OA
      assertEquals(true, j.looksReal( "DAIMONES" ));     //   AI
      assertEquals(true, j.looksReal( "EOSMADIN" ));     //   SM  EO
      assertEquals(true, j.looksReal( "EOSNADIM" ));     //   SN  EO
      assertEquals(true, j.looksReal( "OASNEDIM" ));     //   OA
      assertEquals(false, j.looksReal( "DMAIONES" ));
      assertEquals(false, j.looksReal( "IASMONED" ));
      assertEquals(false, j.looksReal( "IDAMOESN" ));

      j = new Jumble( "UCKWALKS" );      //   CK  CL  KK  KL  KW  SK  SL  SW
      assertEquals(true, j.looksReal( "CKASLUKW" ));     //  CK  SL  KW
      assertEquals(true, j.looksReal( "KKASWUCL" ));     //  KK  CL  SW
      assertEquals(true, j.looksReal( "KLACKUSW" ));     //  CK  KL  SW
      assertEquals(true, j.looksReal( "SLAKWUCK" ));     //  CK  KW  SL
      assertEquals(false, j.looksReal( "UCKWALKS" ));
      assertEquals(false, j.looksReal( "WKUCLAKS" ));
 
      j = new Jumble( "SOMEWHEN" );              //   WH  SM  SN  EE  EO
      assertEquals("not", j.getRating( "SOMEWHEN" ));    
      assertEquals("fair", j.getRating( "WHOSMEEN" ));   //  WH  SM  EE
      assertEquals("good", j.getRating( "WHEONESM" ));   //  WH  EO  SM
      assertEquals("good", j.getRating( "WHESNEOM" ));   //  WH  SN  EO
      assertEquals("poor", j.getRating( "HWOSMEEN" ));
      assertEquals("fair", j.getRating( "WHOSMEEN" ));

      j = new Jumble( "ANTHROPOIDS" );              //   DR  THR  TH  TR  SP  OO  AI  ST  OA  SN
      assertEquals("good", j.getRating( "THRANISPOOD" ));    //  THR  SP  OO
      assertEquals("good", j.getRating( "THANISODROP" ));    //  DR  TH  SP
      assertEquals("good", j.getRating( "NASPIROTHOD" ));    //  TR  SP  TH
      assertEquals("good", j.getRating( "NOSPADITROH" ));    //  TR  SP
      assertEquals("good", j.getRating( "NOSPAIDROTH" ));    //  SP  AI  DR  TH
      assertEquals("good", j.getRating( "NOSTAPIDROH" ));    //  ST
      assertEquals("fair", j.getRating( "THROASPIDON" ));    //  THR  OA  SP
      assertEquals("good", j.getRating( "THROASNIPOD" ));    //  THR  OA  SP   SN
      assertEquals("not", j.getRating(  "ANTHROPOIDS" ));
   }

   public void testJumble09()      //  test all
   {
      Jumble j = new Jumble( "FALCONET" );
      assertEquals(0, j.numLettersInCorrectLocation( "LFANCOTE" ));
      assertEquals(1, j.numLettersInCorrectLocation( "AFLTCONE" ));
      assertEquals(2, j.numLettersInCorrectLocation( "LAFNCTEO" ));
      assertEquals(3, j.numLettersInCorrectLocation( "CALFOTNE" ));
      assertEquals(4, j.numLettersInCorrectLocation( "FALCTONE" ));
      assertEquals(5, j.numLettersInCorrectLocation( "LFACONET" ));
      assertEquals(6, j.numLettersInCorrectLocation( "FALOCNET" ));
      assertEquals(8, j.numLettersInCorrectLocation( "FALCONET" ));

      j = new Jumble( "FIGURATE" );               //   GR  FR
      assertEquals(true, j.looksReal( "FIGRUTEA" ));   //   GR  EA
      assertEquals(true, j.looksReal( "AGIFRUTE" ));   //   FR  
      assertEquals(true, j.looksReal( "ATEFIGUR" ));
      assertEquals(false, j.looksReal( "FGIURATE" ));
      assertEquals(false, j.looksReal( "UFGRIATE" ));

      j = new Jumble( "CHILDPROOF" );              //   PR  CH  FL  PL  FR  IO  OO
      assertEquals("not", j.getRating( "CHILDPROOF" ));
      assertEquals("good", j.getRating( "PROCHODIFL" ));   //  PR  CH  FL
      assertEquals("good", j.getRating( "PLOCHODIFR" ));   //  PL  CH  FR
      assertEquals("fair", j.getRating( "PFOCHODIRL" ));   //
      assertEquals("poor", j.getRating( "PFOLDORICH" ));

      j = new Jumble( "PROOF" );              //   PF
      assertEquals("good", j.getRating( "ROPFO" ));    //  PF
   }

   public void testJumble10()      //  test all
   {
      testJumble05();
      testJumble06();
      testJumble07();
      testJumble08();
      testJumble09();

      Jumble j = new Jumble( "PABLUMS" );
      assertEquals(0, j.numLettersInCorrectLocation( "SPABLUM" ));
      assertEquals(1, j.numLettersInCorrectLocation( "PSABLUM" ));
      assertEquals(2, j.numLettersInCorrectLocation( "PASBLUM" ));
      assertEquals(3, j.numLettersInCorrectLocation( "PABSLUM" ));
      assertEquals(4, j.numLettersInCorrectLocation( "PABLSUM" ));
      assertEquals(5, j.numLettersInCorrectLocation( "PABLUSM" ));
      assertEquals(7, j.numLettersInCorrectLocation( "PABLUMS" ));

      j = new Jumble( "GLUE" );        //   GL 
      assertEquals(true, j.looksReal( "EGLU" ));
      assertEquals(true, j.looksReal( "UGLE" ));
      assertEquals(true, j.looksReal( "GULE" ));
      assertEquals(true, j.looksReal( "UGLE" ));
      assertEquals(false, j.looksReal( "ULGE" ));
      assertEquals(false, j.looksReal( "UEGL" ));

      j = new Jumble( "HAPPY" );        //   PP  YA   
      assertEquals(true, j.looksReal( "HAPPY" ));
      assertEquals(true, j.looksReal( "PPYAH" ));
      assertEquals(true, j.looksReal( "HYAPP" ));
      assertEquals(false, j.looksReal( "HPAPY" ));
      assertEquals(false, j.looksReal( "AHPYP" ));
      assertEquals(false, j.looksReal( "APYPH" ));

      j = new Jumble( "YOUTH" );          //   YU  
      assertEquals("not", j.getRating( "YOUTH" ));
      assertEquals("fair", j.getRating( "YUTHO" ));
      assertEquals("good", j.getRating( "OTHYU" ));   //  YU
      assertEquals("poor", j.getRating( "UYOTH" ));

      j = new Jumble( "GIFTWARE" );      //   TW WR  
      assertEquals("good", j.getRating( "TWAGERIF" ));   //   TW
      assertEquals("not", j.getRating(  "GIFTWARE" ));
      assertEquals("good", j.getRating( "WRIGETAF" ));   //   WR

      j = new Jumble( "KRAALED" );      //   KR DR 
      assertEquals("not", j.getRating( "KRAALED" ));
      assertEquals("good", j.getRating( "AKREDAL" ));         //   KR
      assertEquals("good", j.getRating( "ADREKAL" ));         //   DR

      j = new Jumble( "PROGRAMMER" );             //  GR  MM  RR PR
      assertEquals("not", j.getRating(  "PROGRAMMER" ));
      assertEquals("good", j.getRating( "RAGREPROMM" ));      //   GR  PR  MM
      assertEquals("fair", j.getRating( "RAMMEPROGR" ));

      j = new Jumble( "AARGH" );             //  GH 
      assertEquals("good", j.getRating( "GHARA" ));
      assertEquals("not", j.getRating( "AARGH" ));
   }
   public void testLetterRecognition01()
   {
      LetterRecognition lr = new LetterRecognition();

      assertEquals("A", lr.getLetter(let_A));
      assertEquals("IA", lr.getWord(let_IA));
   }

   public void testLetterRecognition02()    // thin  letters
   {
      LetterRecognition lr = new LetterRecognition();

      assertEquals("A", lr.getLetter(let_A));
      assertEquals("B", lr.getLetter(let_B));
      assertEquals("C", lr.getLetter(let_C));
      assertEquals("D", lr.getLetter(let_D));
      assertEquals("E", lr.getLetter(let_E));
      assertEquals("F", lr.getLetter(let_F));
      assertEquals("H", lr.getLetter(let_H));
      assertEquals("J", lr.getLetter(let_J));
      assertEquals("K", lr.getLetter(let_K));
      assertEquals("L", lr.getLetter(let_L));
      assertEquals("O", lr.getLetter(let_O));
      assertEquals("P", lr.getLetter(let_P));
      assertEquals("R", lr.getLetter(let_R));
      assertEquals("S", lr.getLetter(let_S));
      assertEquals("T", lr.getLetter(let_T));
      assertEquals("X", lr.getLetter(let_X));
      assertEquals("Y", lr.getLetter(let_Y));
   }

   public void testLetterRecognition03()    // wide letters
   {
      LetterRecognition lr = new LetterRecognition();

      assertEquals("G", lr.getLetter(let_G));
      assertEquals("I", lr.getLetter(let_I));
      assertEquals("M", lr.getLetter(let_M));
      assertEquals("N", lr.getLetter(let_N));
      assertEquals("Q", lr.getLetter(let_Q));
      assertEquals("U", lr.getLetter(let_U));
      assertEquals("V", lr.getLetter(let_V));
      assertEquals("W", lr.getLetter(let_W));
      assertEquals("Z", lr.getLetter(let_Z));
   }

   public void testLetterRecognition04()    // two (thin) letter words
   {
      LetterRecognition lr = new LetterRecognition();
      String[][] word1 = buildNewWord(let_A, let_D);
      assertEquals("AD", lr.getWord(word1));

      word1 = buildNewWord(let_B, let_E);
      assertEquals("BE", lr.getWord(word1));

      word1 = buildNewWord(let_C, let_L);
      assertEquals("CL", lr.getWord(word1));

      word1 = buildNewWord(let_O, let_P);
      assertEquals("OP", lr.getWord(word1));
   }

   public void testLetterRecognition05()    // two (wide) letter words
   {
      LetterRecognition lr = new LetterRecognition();
      String[][] word1 = buildNewWord(let_I, let_T);
      assertEquals("IT", lr.getWord(word1));

      word1 = buildNewWord(let_M, let_V);
      assertEquals("MV", lr.getWord(word1));

      word1 = buildNewWord(let_G, let_N);
      assertEquals("GN", lr.getWord(word1));
   }

   public void testLetterRecognition06()    // two letter words
   {
      LetterRecognition lr = new LetterRecognition();
      String[][] word1 = buildNewWord(let_A, let_I);
      assertEquals("AI", lr.getWord(word1));

      word1 = buildNewWord(let_I, let_S);
      assertEquals("IS", lr.getWord(word1));

      word1 = buildNewWord(let_U, let_P);
      assertEquals("UP", lr.getWord(word1));

      word1 = buildNewWord(let_N, let_O);
      assertEquals("NO", lr.getWord(word1));
   }

   public void testLetterRecognition07()    // Three letter words
   {
      LetterRecognition lr = new LetterRecognition();
      String[][] word1 = buildNewWord(let_A, let_D);
      word1 = buildNewWord(let_S, word1);
      assertEquals("SAD", lr.getWord(word1));

      word1 = buildNewWord(let_I, let_D);
      word1 = buildNewWord(word1, let_E);
      assertEquals("IDE", lr.getWord(word1));
 
      word1 = buildNewWord(let_M, let_E);
      word1 = buildNewWord(word1, let_X);
      assertEquals("MEX", lr.getWord(word1));
      word1 = buildNewWord(word1, let_R);
   }

   public void testLetterRecognition08()    //   four letter words
   {
      LetterRecognition lr = new LetterRecognition();
      String[][] word1 = buildNewWord(let_I, let_D);
      word1 = buildNewWord(word1, let_E);
      word1 = buildNewWord(let_W, word1);
      assertEquals("WIDE", lr.getWord(word1));

      word1 = buildNewWord(let_M, let_E);
      word1 = buildNewWord(word1, let_X);
      word1 = buildNewWord(word1, let_R);
      assertEquals("MEXR", lr.getWord(word1));

      word1 = buildNewWord(let_I, let_T);
      word1 = buildNewWord(word1, word1);
      assertEquals("ITIT", lr.getWord(word1));

      word1 = buildNewWord(let_T, let_R);
      word1 = buildNewWord(word1, let_O);
      word1 = buildNewWord(word1, let_Y);
      assertEquals("TROY", lr.getWord(word1));
   }

   public void testLetterRecognition09()    //   many letter words
   {
      LetterRecognition lr = new LetterRecognition();

      String[][] word1 = buildNewWord(let_Q, let_U);
      word1 = buildNewWord(word1, let_I);
      word1 = buildNewWord(word1, let_C);
      word1 = buildNewWord(word1, let_K);
      assertEquals("QUICK", lr.getWord(word1));

      word1 = buildNewWord(let_B, let_R);
      word1 = buildNewWord(word1, let_O);
      word1 = buildNewWord(word1, let_W);
      word1 = buildNewWord(word1, let_N);
      assertEquals("BROWN", lr.getWord(word1));

      word1 = buildNewWord(let_F, let_O);
      word1 = buildNewWord(word1, let_X);
      assertEquals("FOX", lr.getWord(word1));

      word1 = buildNewWord(let_J, let_U);
      word1 = buildNewWord(word1, let_M);
      word1 = buildNewWord(word1, let_P);
      word1 = buildNewWord(word1, let_S);
      assertEquals("JUMPS", lr.getWord(word1));

      word1 = buildNewWord(let_T, let_H);
      word1 = buildNewWord(word1, let_E);
      assertEquals("THE", lr.getWord(word1));

      word1 = buildNewWord(let_O, let_V);
      word1 = buildNewWord(word1, let_E);
      word1 = buildNewWord(word1, let_R);
      assertEquals("OVER", lr.getWord(word1));

      word1 = buildNewWord(let_L, let_A);
      word1 = buildNewWord(word1, let_Z);
      word1 = buildNewWord(word1, let_Y);
      assertEquals("LAZY", lr.getWord(word1));

      word1 = buildNewWord(let_D, let_O);
      word1 = buildNewWord(word1, let_G);
      assertEquals("DOG", lr.getWord(word1));
    }

   public void testLetterRecognition10()    //   many letter words
   {
      LetterRecognition lr = new LetterRecognition();

      String[][] word1 = buildNewWord(let_C, let_O);
      word1 = buildNewWord(word1, let_N);
      word1 = buildNewWord(word1, let_G);
      word1 = buildNewWord(word1, let_R);
      word1 = buildNewWord(word1, let_A);
      word1 = buildNewWord(word1, let_T);
      word1 = buildNewWord(word1, let_U);
      word1 = buildNewWord(word1, let_L);
      word1 = buildNewWord(word1, let_A);
      word1 = buildNewWord(word1, let_T);
      word1 = buildNewWord(word1, let_I);
      word1 = buildNewWord(word1, let_O);
      word1 = buildNewWord(word1, let_N);
      assertEquals("CONGRATULATION", lr.getWord(word1));

      word1 = buildNewWord(let_L, let_A);
      word1 = buildNewWord(word1, let_I);
      word1 = buildNewWord(word1, let_S);
      word1 = buildNewWord(word1, let_S);
      word1 = buildNewWord(word1, let_E);
      word1 = buildNewWord(word1, let_Z);
      assertEquals("LAISSEZ", lr.getWord(word1));

      word1 = buildNewWord(let_L, let_A);
      word1 = buildNewWord(word1, let_C);
      word1 = buildNewWord(word1, let_K);
      word1 = buildNewWord(word1, let_A);
      word1 = buildNewWord(word1, let_D);
      word1 = buildNewWord(word1, let_A);
      word1 = buildNewWord(word1, let_I);
      word1 = buildNewWord(word1, let_S);
      word1 = buildNewWord(word1, let_I);
      word1 = buildNewWord(word1, let_C);
      word1 = buildNewWord(word1, let_A);
      word1 = buildNewWord(word1, let_L);
      assertEquals("LACKADAISICAL", lr.getWord(word1));

      word1 = buildNewWord(let_W, let_A);
      word1 = buildNewWord(word1, let_Y);
      word1 = buildNewWord(word1, let_W);
      word1 = buildNewWord(word1, let_A);
      word1 = buildNewWord(word1, let_R);
      word1 = buildNewWord(word1, let_D);
      assertEquals("WAYWARD", lr.getWord(word1));

      word1 = buildNewWord(let_B, let_A);
      word1 = buildNewWord(word1, let_Y);
      word1 = buildNewWord(word1, let_O);
      word1 = buildNewWord(word1, let_N);
      word1 = buildNewWord(word1, let_E);
      word1 = buildNewWord(word1, let_T);
      assertEquals("BAYONET", lr.getWord(word1));

      word1 = buildNewWord(let_H, let_A);
      word1 = buildNewWord(word1, let_L);
      word1 = buildNewWord(word1, let_F);
      word1 = buildNewWord(word1, let_W);
      word1 = buildNewWord(word1, let_A);
      word1 = buildNewWord(word1, let_Y);
      assertEquals("HALFWAY", lr.getWord(word1));

      word1 = buildNewWord(let_M, let_I);
      word1 = buildNewWord(word1, let_X);
      word1 = buildNewWord(word1, let_E);
      word1 = buildNewWord(word1, let_R);
      assertEquals("MIXER", lr.getWord(word1));

      word1 = buildNewWord(let_J, let_U);
      word1 = buildNewWord(word1, let_M);
      word1 = buildNewWord(word1, let_P);
      assertEquals("JUMP", lr.getWord(word1));

      word1 = buildNewWord(let_Q, let_V);
      word1 = buildNewWord(word1, word1);
      word1 = buildNewWord(word1, word1);
      assertEquals("QVQVQVQV", lr.getWord(word1));
    }

   public void testDisplayLetters()    //   many letter words
   {
      LetterRecognition lr = new LetterRecognition();

      String[][] word1 = buildNewWord(let_A, let_B);
      word1 = buildNewWord(word1, let_C);
      word1 = buildNewWord(word1, let_D);
      word1 = buildNewWord(word1, let_E);
      word1 = buildNewWord(word1, let_F);
      word1 = buildNewWord(word1, let_G);
      word1 = buildNewWord(word1, let_H);
      word1 = buildNewWord(word1, let_I);
      word1 = buildNewWord(word1, let_J);
      word1 = buildNewWord(word1, let_K);
      word1 = buildNewWord(word1, let_L);
//      display(word1);
   }

   public void testDisplayLetters1()
   {
      LetterRecognition lr = new LetterRecognition();

      String[][] word1 = buildNewWord(let_M, let_N);
      word1 = buildNewWord(word1, let_O);
      word1 = buildNewWord(word1, let_P);
      word1 = buildNewWord(word1, let_Q);
      word1 = buildNewWord(word1, let_R);
      word1 = buildNewWord(word1, let_S);
      word1 = buildNewWord(word1, let_T);
      word1 = buildNewWord(word1, let_U);
      word1 = buildNewWord(word1, let_V);
//      display(word1);
   }

   public void testDisplayLetters2()
   {
      LetterRecognition lr = new LetterRecognition();

      String[][] word1 = buildNewWord(let_W, let_X);
      word1 = buildNewWord(word1, let_Y);
      word1 = buildNewWord(word1, let_Z);
//      display(word1);
   }

   private void display(String[][] a)
   {
/*       for (int m = 0; m < a.length; m++)
       {
          for(int n = 0; n < a[m].length; n++)
             System.out.print(a[m][n]);
          System.out.println();
        }
*/
    }

    private String[][] buildNewWord(String[][] a, String[][] b)
   {
      String[][] ans = new String[7][1 + a[0].length + b[0].length];
      for (int r = 0; r < a.length; r++)
      {
         for (int c = 0; c < a[r].length; c++)
            ans[r][c] = a[r][c];
         for (int c = 0; c < b[r].length; c++)
            ans[r][1 + a[r].length + c] = b[r][c];
      }
      for (int r = 0; r < 7; r++)
         ans[r][a[0].length] = " ";
/*
      for (int c = 0; c < 7; c++)
      {
         for (String str : ans[c])
            System.out.print(str + " ");
         System.out.println();
      }
*/
      return ans;
   }

   String[][] let_IA = { {"X", "X", "X", "X", "X", " ", " ", "X", "X", " "},
                        {" ", " ", "X", " ", " ", " ", "X", " ", " ", "X"},
                        {" ", " ", "X", " ", " ", " ", "X", " ", " ", "X"},
                        {" ", " ", "X", " ", " ", " ", "X", "X", "X", "X"},
                        {" ", " ", "X", " ", " ", " ", "X", " ", " ", "X"},
                        {" ", " ", "X", " ", " ", " ", "X", " ", " ", "X"},
                        {"X", "X", "X", "X", "X", " ", "X", " ", " ", "X"} };

   String[][] let_A = { {" ", "X", "X", " "},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", "X", "X", "X"},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"} };

   String[][] let_B = { {"X", "X", "X", " "},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", "X", "X", "X"},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", "X", "X", " "} };

   String[][] let_C = { {" ", "X", "X", " "},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", " "},
                        {"X", " ", " ", " "},
                        {"X", " ", " ", " "},
                        {"X", " ", " ", "X"},
                        {"X", "X", "X", " "} };

   String[][] let_D = { {"X", "X", "X", " "},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", "X", "X", " "} };

   String[][] let_E = { {"X", "X", "X", "X"},
                        {"X", " ", " ", " "},
                        {"X", " ", " ", " "},
                        {"X", "X", "X", "X"},
                        {"X", " ", " ", " "},
                        {"X", " ", " ", " "},
                        {"X", "X", "X", "X"} };

   String[][] let_F = { {"X", "X", "X", "X"},
                        {"X", " ", " ", " "},
                        {"X", " ", " ", " "},
                        {"X", "X", "X", "X"},
                        {"X", " ", " ", " "},
                        {"X", " ", " ", " "},
                        {"X", " ", " ", " "} };

   String[][] let_G = { {" ", "X", "X", " ", " "},
                        {"X", " ", " ", "X", " "},
                        {"X", " ", " ", " ", " "},
                        {"X", " ", " ", " ", " "},
                        {"X", " ", "X", "X", " "},
                        {"X", " ", " ", "X", "X"},
                        {" ", "X", "X", " ", "X"} };

   String[][] let_H = { {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", "X", "X", "X"},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"} };

   String[][] let_I = { {"X", "X", "X", "X", "X"},
                        {" ", " ", "X", " ", " "},
                        {" ", " ", "X", " ", " "},
                        {" ", " ", "X", " ", " "},
                        {" ", " ", "X", " ", " "},
                        {" ", " ", "X", " ", " "},
                        {"X", "X", "X", "X", "X"} };

   String[][] let_J = { {" ", " ", " ", "X"},
                        {" ", " ", " ", "X"},
                        {" ", " ", " ", "X"},
                        {" ", " ", " ", "X"},
                        {" ", " ", " ", "X"},
                        {" ", " ", " ", "X"},
                        {"X", "X", "X", "X"} };

   String[][] let_K = { {"X", " ", " ", "X"},
                        {"X", " ", "X", " "},
                        {"X", "X", " ", " "},
                        {"X", "X", " ", " "},
                        {"X", " ", "X", " "},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"} };

   String[][] let_L = { {"X", " ", " ", " "},
                        {"X", " ", " ", " "},
                        {"X", " ", " ", " "},
                        {"X", " ", " ", " "},
                        {"X", " ", " ", " "},
                        {"X", " ", " ", " "},
                        {"X", "X", "X", "X"} };

   String[][] let_M = { {"X", " ", " ", " ", "X"},
                        {"X", "X", " ", "X", "X"},
                        {"X", " ", "X", " ", "X"},
                        {"X", " ", "X", " ", "X"},
                        {"X", " ", " ", " ", "X"},
                        {"X", " ", " ", " ", "X"},
                        {"X", " ", " ", " ", "X"} };

   String[][] let_N = { {"X", " ", " ", " ", "X"},
                        {"X", "X", " ", " ", "X"},
                        {"X", "X", " ", " ", "X"},
                        {"X", " ", "X", " ", "X"},
                        {"X", " ", "X", " ", "X"},
                        {"X", " ", " ", "X", "X"},
                        {"X", " ", " ", " ", "X"} };

   String[][] let_O = { {" ", "X", "X", " "},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {" ", "X", "X", " "} };

   String[][] let_P = { {"X", "X", "X", " "},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", "X", "X", " "},
                        {"X", " ", " ", " "},
                        {"X", " ", " ", " "},
                        {"X", " ", " ", " "} };

   String[][] let_Q = { {" ", "X", "X", " ", " "},
                        {"X", " ", " ", "X", " "},
                        {"X", " ", " ", "X", " "},
                        {"X", " ", " ", "X", " "},
                        {"X", " ", " ", "X", " "},
                        {"X", " ", " ", "X", " "},
                        {" ", "X", "X", " ", "X"} };

   String[][] let_R = { {"X", "X", "X", " "},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", "X", "X", " "},
                        {"X", " ", "X", " "},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"} };

   String[][] let_S = { {" ", "X", "X", "X"},
                        {"X", " ", " ", " "},
                        {"X", " ", " ", " "},
                        {" ", "X", "X", " "},
                        {" ", " ", " ", "X"},
                        {" ", " ", " ", "X"},
                        {"X", "X", "X", " "} };

   String[][] let_T = { {"X", "X", "X", "X", "X"},
                        {" ", " ", "X", " ", " "},
                        {" ", " ", "X", " ", " "},
                        {" ", " ", "X", " ", " "},
                        {" ", " ", "X", " ", " "},
                        {" ", " ", "X", " ", " "},
                        {" ", " ", "X", " ", " "} };

   String[][] let_U = { {"X", " ", " ", "X", " "},
                        {"X", " ", " ", "X", " "},
                        {"X", " ", " ", "X", " "},
                        {"X", " ", " ", "X", " "},
                        {"X", " ", " ", "X", " "},
                        {"X", " ", " ", "X", "X"},
                        {" ", "X", "X", " ", "X"} };

   String[][] let_V = { {"X", " ", " ", " ", "X"},
                        {"X", " ", " ", " ", "X"},
                        {"X", " ", " ", " ", "X"},
                        {" ", "X", " ", "X", " "},
                        {" ", "X", " ", "X", " "},
                        {" ", "X", " ", "X", " "},
                        {" ", " ", "X", " ", " "} };

   String[][] let_W = { {"X", " ", " ", " ", "X"},
                        {"X", " ", " ", " ", "X"},
                        {"X", " ", "X", " ", "X"},
                        {"X", " ", "X", " ", "X"},
                        {"X", " ", "X", " ", "X"},
                        {" ", "X", " ", "X", " "},
                        {" ", "X", " ", "X", " "} };

   String[][] let_X = { {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {" ", "X", "X", " "},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"} };

   String[][] let_Y = { {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {"X", " ", " ", "X"},
                        {" ", "X", "X", " "},
                        {" ", "X", "X", " "},
                        {" ", "X", "X", " "},
                        {" ", "X", "X", " "} };

   String[][] let_Z = { {"X", "X", "X", "X", "X"},
                        {" ", " ", " ", " ", "X"},
                        {" ", " ", " ", "X", " "},
                        {" ", " ", "X", " ", " "},
                        {" ", "X", " ", " ", " "},
                        {"X", " ", " ", " ", " "},
                        {"X", "X", "X", "X", "X"} };

   public void testPedalTriangle01()
   {
      ArrayList<OrderedPair> op = new ArrayList<OrderedPair>();
      op.add(new OrderedPair(5., 5.));
      op.add(new OrderedPair(30., 25.));
      op.add(new OrderedPair(15., 70.));
      
      PedalTriangle pd = new PedalTriangle(op);
      OrderedPair p = new OrderedPair(20., 40.);
      List<OrderedPair> ans = pd.getPedalTriangle(p);
//      System.out.println("ans = " + ans);
      assertEquals(true, ans.contains(new OrderedPair(1280./41., 1065./41.)));       /*  31.2195, 25.97561  */
      assertEquals(true, ans.contains(new OrderedPair(49./2, 83./2)));               /*  10.6069, 41.44509  */
      assertEquals(true, ans.contains(new OrderedPair(1835./173, 7170./173)));       /*  24.50000, 41.5      */
    }

   public void testPedalTriangle02()
   {
      ArrayList<OrderedPair> op = new ArrayList<OrderedPair>();
      op.add(new OrderedPair(-57., -21.));
      op.add(new OrderedPair(-5., -43.));
      op.add(new OrderedPair(-13., -17.));
      
      PedalTriangle pd = new PedalTriangle(op);
      OrderedPair p = new OrderedPair(-8., -24.);
      List<OrderedPair> ans = pd.getPedalTriangle(p);
//      System.out.println("ans = " + ans);
      assertEquals(true, ans.contains(new OrderedPair(-11447./797, -31114./797.)));    /*  -14.36261, -39.0389  */
      assertEquals(true, ans.contains(new OrderedPair(-529./61., -1013./61)));        /*  -8.672131, -16.6066  */
      assertEquals(true, ans.contains(new OrderedPair(-53./5, -124./5)));             /*  -10.6, -24.8         */
    }

   public void testPedalTriangle03()
   {
      ArrayList<OrderedPair> op = new ArrayList<OrderedPair>();
      op.add(new OrderedPair(-9., 41.));
      op.add(new OrderedPair(5., -2.));
      op.add(new OrderedPair(23., 17.));
      
      PedalTriangle pd = new PedalTriangle(op);
      OrderedPair p = new OrderedPair(0., 20.);
      List<OrderedPair> ans = pd.getPedalTriangle(p);
//      System.out.println("ans = " + ans);
      assertEquals(true, ans.contains(new OrderedPair(-3999./2045., 39598./2045.)));      /*  -1.955501, 19.36333  */
      assertEquals(true, ans.contains(new OrderedPair(9329./685., 4862./685)));           /*  13.618978, 7.097810  */
      assertEquals(true, ans.contains(new OrderedPair(171./25, 728./25)));                /*  6.8400000, 29.12000  */
    }

   public void testPedalTriangle04()
   {
      ArrayList<OrderedPair> op = new ArrayList<OrderedPair>();
      op.add(new OrderedPair(0, 0));
      op.add(new OrderedPair(30, 0));
      op.add(new OrderedPair(30, 40));
      
      PedalTriangle pd = new PedalTriangle(op);
      OrderedPair p = new OrderedPair(10., 5.);
      List<OrderedPair> ans = pd.getPedalTriangle(p);
      assertEquals(true, ans.contains(new OrderedPair(6., 8.)));
      assertEquals(true, ans.contains(new OrderedPair(30., 5.)));
      assertEquals(true, ans.contains(new OrderedPair(10., 0.)));
    }

   public void testPedalTriangle05()
   {
      ArrayList<OrderedPair> op = new ArrayList<OrderedPair>();
      op.add(new OrderedPair(0, 0));
      op.add(new OrderedPair(660./13, 275./13));
      op.add(new OrderedPair(0, 143));
      
      PedalTriangle pd = new PedalTriangle(op);
      OrderedPair p = new OrderedPair(17., 275./13);
      List<OrderedPair> ans = pd.getPedalTriangle(p);
//      System.out.println("ans = " + ans);
      assertEquals(true, ans.contains(new OrderedPair(0., 275./13.)));
      assertEquals(true, ans.contains(new OrderedPair(100565./2197., 72815./2197)));
      assertEquals(true, ans.contains(new OrderedPair(48324./2197., 20135./2197)));
    }

   public void testPedalTriangle06()
   {
      ArrayList<OrderedPair> op = new ArrayList<OrderedPair>();
      op.add(new OrderedPair(-2., 11.0));
      op.add(new OrderedPair(8.0, 100.));
      op.add(new OrderedPair(13., 36.));
      
      PedalTriangle pd = new PedalTriangle(op);
      OrderedPair p = new OrderedPair(21., 47.);
      List<OrderedPair> ans = pd.getPedalTriangle(p);
//      System.out.println("ans = " + ans);
      assertEquals(true, ans.contains(new OrderedPair(679./34., 1619./34.)));
      assertEquals(true, ans.contains(new OrderedPair(50253./4121., 190852./4121)));
      assertEquals(true, ans.contains(new OrderedPair(18298./8021., 393857./8021)));
    }

   public void testPedalTriangle07()
   {
      ArrayList<OrderedPair> op = new ArrayList<OrderedPair>();
      op.add(new OrderedPair(11, 7));
      op.add(new OrderedPair(65, 28));
      op.add(new OrderedPair(0, 143));
      
      PedalTriangle pd = new PedalTriangle(op);
      OrderedPair p = new OrderedPair(17., 31.);
      List<OrderedPair> ans = pd.getPedalTriangle(p);
//      System.out.println("ans = " + ans);
      assertEquals(true, ans.contains(new OrderedPair(36361./698, 35483./698.)));
      assertEquals(true, ans.contains(new OrderedPair(9071.0/373., 4543./373.)));
      assertEquals(true, ans.contains(new OrderedPair(169609./18617., 30.36187)));
    }

   public void testPedalTriangle08()
   {
      ArrayList<OrderedPair> op = new ArrayList<OrderedPair>();
      op.add(new OrderedPair(-7., 5.));
      op.add(new OrderedPair(35., 0.));
      op.add(new OrderedPair(0., -14.));
      
      PedalTriangle pd = new PedalTriangle(op);
      OrderedPair p = new OrderedPair(0., 0.);
      List<OrderedPair> ans = pd.getPedalTriangle(p);
//      System.out.println("ans = " + ans);
      assertEquals(true, ans.contains(new OrderedPair(875./1789., 7350./1789.)));
      assertEquals(true, ans.contains(new OrderedPair(140.0/29., -350./29.)));
      assertEquals(true, ans.contains(new OrderedPair(-931./205., -343./205)));
    }

   public void testPedalTriangle09()
   {
      ArrayList<OrderedPair> op = new ArrayList<OrderedPair>();
      op.add(new OrderedPair(5., 10.));
      op.add(new OrderedPair(0., 0.));
      op.add(new OrderedPair(10., 5.));
      
      PedalTriangle pd = new PedalTriangle(op);
      OrderedPair p = new OrderedPair(5., 5.);
      List<OrderedPair> ans = pd.getPedalTriangle(p);
//      System.out.println("ans = " + ans);
      assertEquals(true, ans.contains(new OrderedPair(6., 3.)));
      assertEquals(true, ans.contains(new OrderedPair(3., 6.)));
      assertEquals(true, ans.contains(new OrderedPair(7.5, 7.5)));
    }

   public void testPedalTriangle10()
   {
      testPedalTriangle01();
      testPedalTriangle02();
      testPedalTriangle03();
      testPedalTriangle04();
      testPedalTriangle05();
      testPedalTriangle06();
      testPedalTriangle07();
      testPedalTriangle08();
      testPedalTriangle09();
   }
   public void testUnitProducingPalindrome01()
   {
      assertEquals(true, ProducingPalindrome.isPalindrome(3773));
      assertEquals(false, ProducingPalindrome.isPalindrome(31443));
      assertEquals(true, ProducingPalindrome.isPalindrome(303));
      assertEquals(false, ProducingPalindrome.isPalindrome(14));

      assertEquals(424, ProducingPalindrome.reverseNumber(4240));
      assertEquals(32856, ProducingPalindrome.reverseNumber(65823));
      assertEquals(13538, ProducingPalindrome.reverseNumber(83531));

      assertEquals(1, ProducingPalindrome.getPalindrome(124)[0]);
      assertEquals(545, ProducingPalindrome.getPalindrome(124)[1]);
  }

   public void testUnitProducingPalindrome02()
   {
      assertEquals(true, ProducingPalindrome.isPalindrome(969));
      assertEquals(true, ProducingPalindrome.isPalindrome(5));
      assertEquals(true, ProducingPalindrome.isPalindrome(616));
      assertEquals(true, ProducingPalindrome.isPalindrome(757));
      assertEquals(true, ProducingPalindrome.isPalindrome(191));

      assertEquals(false, ProducingPalindrome.isPalindrome(32230));
      assertEquals(false, ProducingPalindrome.isPalindrome(1011));
      assertEquals(false, ProducingPalindrome.isPalindrome(424414));
      assertEquals(false, ProducingPalindrome.isPalindrome(15995));
      assertEquals(false, ProducingPalindrome.isPalindrome(13630));
   }

   public void testUnitProducingPalindrome03()
   {
      assertEquals(true, ProducingPalindrome.isPalindrome(71017));
      assertEquals(true, ProducingPalindrome.isPalindrome(50605));
      assertEquals(true, ProducingPalindrome.isPalindrome(906609));
      assertEquals(true, ProducingPalindrome.isPalindrome(6556));
      assertEquals(true, ProducingPalindrome.isPalindrome(585));
      assertEquals(true, ProducingPalindrome.isPalindrome(535));
      assertEquals(true, ProducingPalindrome.isPalindrome(989));
      assertEquals(true, ProducingPalindrome.isPalindrome(1221));
      assertEquals(true, ProducingPalindrome.isPalindrome(1111));
      assertEquals(true, ProducingPalindrome.isPalindrome(525));
      assertEquals(true, ProducingPalindrome.isPalindrome(121));
      assertEquals(true, ProducingPalindrome.isPalindrome(121));
      assertEquals(true, ProducingPalindrome.isPalindrome(262));

      assertEquals(false, ProducingPalindrome.isPalindrome(3730));
      assertEquals(false, ProducingPalindrome.isPalindrome(8408));
      assertEquals(false, ProducingPalindrome.isPalindrome(50));
   }

   public void testUnitProducingPalindrome04()
   {
      assertEquals(32529, ProducingPalindrome.reverseNumber(92523));
      assertEquals(58539, ProducingPalindrome.reverseNumber(93585));
      assertEquals(54934, ProducingPalindrome.reverseNumber(43945));
      assertEquals(45466, ProducingPalindrome.reverseNumber(66454));
      assertEquals(27626, ProducingPalindrome.reverseNumber(62672));
      assertEquals(49872, ProducingPalindrome.reverseNumber(27894));
      assertEquals(53701, ProducingPalindrome.reverseNumber(10735));
      assertEquals(40024, ProducingPalindrome.reverseNumber(42004));
      assertEquals(70514, ProducingPalindrome.reverseNumber(41507));
      assertEquals(43785, ProducingPalindrome.reverseNumber(58734));
      assertEquals(58052, ProducingPalindrome.reverseNumber(25085));
   }


   public void testUnitProducingPalindrome05()
   {
      assertEquals(99972, ProducingPalindrome.reverseNumber(27999));
      assertEquals(46042, ProducingPalindrome.reverseNumber(24064));
      assertEquals(20001, ProducingPalindrome.reverseNumber(10002));
      assertEquals(96524, ProducingPalindrome.reverseNumber(42569));
      assertEquals(97323, ProducingPalindrome.reverseNumber(32379));
      assertEquals(86893, ProducingPalindrome.reverseNumber(39868));
      assertEquals(53083, ProducingPalindrome.reverseNumber(38035));
      assertEquals(31258, ProducingPalindrome.reverseNumber(85213));
      assertEquals(63222, ProducingPalindrome.reverseNumber(22236));
      assertEquals(28545, ProducingPalindrome.reverseNumber(54582));
      assertEquals(926, ProducingPalindrome.reverseNumber(629));
      assertEquals(37035, ProducingPalindrome.reverseNumber(53073));
      assertEquals(45785, ProducingPalindrome.reverseNumber(58754));
      assertEquals(76219, ProducingPalindrome.reverseNumber(91267));
   }

   public void testUnitProducingPalindrome06()
   {
      assertEquals(0, ProducingPalindrome.getPalindrome(424)[0]);
      assertEquals(424, ProducingPalindrome.getPalindrome(424)[1]);

      assertEquals(4, ProducingPalindrome.getPalindrome(87)[0]);
      assertEquals(4884, ProducingPalindrome.getPalindrome(87)[1]);

      assertEquals(4, ProducingPalindrome.getPalindrome(897)[0]);
      assertEquals(46464, ProducingPalindrome.getPalindrome(897)[1]);

      assertEquals(1, ProducingPalindrome.getPalindrome(2521)[0]);
      assertEquals(3773, ProducingPalindrome.getPalindrome(2521)[1]);
      assertEquals(4, ProducingPalindrome.getPalindrome(5584)[0]);
      assertEquals(293392, ProducingPalindrome.getPalindrome(5584)[1]);
      assertEquals(2, ProducingPalindrome.getPalindrome(7658)[0]);
      assertEquals(68486, ProducingPalindrome.getPalindrome(7658)[1]);
      assertEquals(2, ProducingPalindrome.getPalindrome(7477)[0]);
      assertEquals(57475, ProducingPalindrome.getPalindrome(7477)[1]);
      assertEquals(1, ProducingPalindrome.getPalindrome(2122)[0]);
      assertEquals(4334, ProducingPalindrome.getPalindrome(2122)[1]);
      assertEquals(2, ProducingPalindrome.getPalindrome(9491)[0]);
      assertEquals(15851, ProducingPalindrome.getPalindrome(9491)[1]);
      assertEquals(1, ProducingPalindrome.getPalindrome(1315)[0]);
      assertEquals(6446, ProducingPalindrome.getPalindrome(1315)[1]);
   }

   public void testUnitProducingPalindrome07()
   {
      assertEquals(2, ProducingPalindrome.getPalindrome(8846)[0]);
      assertEquals(58685, ProducingPalindrome.getPalindrome(8846)[1]);
      assertEquals(0, ProducingPalindrome.getPalindrome(393)[0]);
      assertEquals(393, ProducingPalindrome.getPalindrome(393)[1]);
      assertEquals(1, ProducingPalindrome.getPalindrome(5476)[0]);
      assertEquals(12221, ProducingPalindrome.getPalindrome(5476)[1]);
      assertEquals(2, ProducingPalindrome.getPalindrome(347)[0]);
      assertEquals(1991, ProducingPalindrome.getPalindrome(347)[1]);
      assertEquals(8, ProducingPalindrome.getPalindrome(8509)[0]);
      assertEquals(88555588, ProducingPalindrome.getPalindrome(8509)[1]);
      assertEquals(1, ProducingPalindrome.getPalindrome(1448)[0]);
      assertEquals(9889, ProducingPalindrome.getPalindrome(1448)[1]);
      assertEquals(2, ProducingPalindrome.getPalindrome(1672)[0]);
      assertEquals(7777, ProducingPalindrome.getPalindrome(1672)[1]);
      assertEquals(2, ProducingPalindrome.getPalindrome(9007)[0]);
      assertEquals(77077, ProducingPalindrome.getPalindrome(9007)[1]);
      assertEquals(2, ProducingPalindrome.getPalindrome(1742)[0]);
      assertEquals(7337, ProducingPalindrome.getPalindrome(1742)[1]);
      assertEquals(4, ProducingPalindrome.getPalindrome(3627)[0]);
      assertEquals(79497, ProducingPalindrome.getPalindrome(3627)[1]);
      assertEquals(2, ProducingPalindrome.getPalindrome(9453)[0]);
      assertEquals(33033, ProducingPalindrome.getPalindrome(9453)[1]);
      assertEquals(6, ProducingPalindrome.getPalindrome(4177)[0]);
      assertEquals(293392, ProducingPalindrome.getPalindrome(4177)[1]);
      assertEquals(1, ProducingPalindrome.getPalindrome(1815)[0]);
      assertEquals(6996, ProducingPalindrome.getPalindrome(1815)[1]);
      assertEquals(1, ProducingPalindrome.getPalindrome(7312)[0]);
      assertEquals(9449, ProducingPalindrome.getPalindrome(7312)[1]);
   }

   public void testUnitProducingPalindrome08()
   {
      assertEquals(true, ProducingPalindrome.isPalindrome(9889));
      assertEquals(true, ProducingPalindrome.isPalindrome(4334));
      assertEquals(true, ProducingPalindrome.isPalindrome(464));
      assertEquals(true, ProducingPalindrome.isPalindrome(1111));

      assertEquals(false, ProducingPalindrome.isPalindrome(6460));
      assertEquals(false, ProducingPalindrome.isPalindrome(60816));
      assertEquals(false, ProducingPalindrome.isPalindrome(7312237));

      assertEquals(27418, ProducingPalindrome.reverseNumber(81472));
      assertEquals(14896, ProducingPalindrome.reverseNumber(69841));
      assertEquals(74809, ProducingPalindrome.reverseNumber(90847));
      assertEquals(57783, ProducingPalindrome.reverseNumber(38775));
      assertEquals(75694, ProducingPalindrome.reverseNumber(49657));
      assertEquals(88966, ProducingPalindrome.reverseNumber(66988));
      assertEquals(55929, ProducingPalindrome.reverseNumber(92955));
   }

   public void testUnitProducingPalindrome09()
   {
      assertEquals(true, ProducingPalindrome.isPalindrome(9449));
      assertEquals(true, ProducingPalindrome.isPalindrome(4224));
      assertEquals(true, ProducingPalindrome.isPalindrome(232));
      assertEquals(true, ProducingPalindrome.isPalindrome(2));

      assertEquals(false, ProducingPalindrome.isPalindrome(94490));
      assertEquals(false, ProducingPalindrome.isPalindrome(42204));
      assertEquals(false, ProducingPalindrome.isPalindrome(2132));
      assertEquals(false, ProducingPalindrome.isPalindrome(10));

      assertEquals(62132, ProducingPalindrome.reverseNumber(23126));
      assertEquals(66146, ProducingPalindrome.reverseNumber(64166));
      assertEquals(59425, ProducingPalindrome.reverseNumber(52495));
      assertEquals(2261, ProducingPalindrome.reverseNumber(1622));
      assertEquals(734, ProducingPalindrome.reverseNumber(437));
      assertEquals(6309, ProducingPalindrome.reverseNumber(90360));

      assertEquals(1, ProducingPalindrome.getPalindrome(3344)[0]);
      assertEquals(7777, ProducingPalindrome.getPalindrome(3344)[1]);
      assertEquals(2, ProducingPalindrome.getPalindrome(7554)[0]);
      assertEquals(23232, ProducingPalindrome.getPalindrome(7554)[1]);
      assertEquals(1, ProducingPalindrome.getPalindrome(1366)[0]);
      assertEquals(7997, ProducingPalindrome.getPalindrome(1366)[1]);
      assertEquals(10, ProducingPalindrome.getPalindrome(9329)[0]);
      assertEquals(52788725, ProducingPalindrome.getPalindrome(9329)[1]);
      assertEquals(4, ProducingPalindrome.getPalindrome(9490)[0]);
      assertEquals(293392, ProducingPalindrome.getPalindrome(9490)[1]);
      assertEquals(2, ProducingPalindrome.getPalindrome(4190)[0]);
      assertEquals(9119, ProducingPalindrome.getPalindrome(4190)[1]);
   }

   public void testUnitProducingPalindrome10()
   {
      testUnitProducingPalindrome01();
      testUnitProducingPalindrome02();
      testUnitProducingPalindrome03();
      testUnitProducingPalindrome04();
      testUnitProducingPalindrome05();
      testUnitProducingPalindrome06();
      testUnitProducingPalindrome07();
      testUnitProducingPalindrome08();
      testUnitProducingPalindrome09();
   }
   public void testRadioContact01()
   {
      ArrayList<Location> locs = new ArrayList<Location>();
      locs.add(new Location(10, 10));
      locs.add(new Location(40, 10));
      locs.add(new Location(60, 10));
      locs.add(new Location(61, 10));
      RadioContact rc  = new RadioContact(locs);
      assertEquals(true, rc.withinRange(locs.get(0), locs.get(1)));
      assertEquals(true, rc.withinRange(locs.get(0), locs.get(2)));
      assertEquals(false, rc.withinRange(locs.get(0), locs.get(3)));

      locs = new ArrayList<Location>();
      locs.add(new Location(118, 136));
      locs.add(new Location(200, 386));
      locs.add(new Location(338, 486));
      locs.add(new Location(412, 266));
      locs.add(new Location(410, 484));
      locs.add(new Location(54, 54));
      locs.add(new Location(194, 80));
      locs.add(new Location(408, 226));
      locs.add(new Location(476, 180));
      locs.add(new Location(116, 98));
      locs.add(new Location(76, 94));
      locs.add(new Location(160, 96));
      locs.add(new Location(434, 202));

      rc  = new RadioContact(locs);
      assertEquals(5, rc.getNumberSquads());
   }

   public void testRadioContact02()
   {
      RadioContact rc  = new RadioContact();

      assertEquals(false, rc.withinRange(new Location(151, 201), new Location(198, 280)));
      assertEquals(false, rc.withinRange(new Location(189, 193), new Location(272, 152)));
      assertEquals(false, rc.withinRange(new Location(86, 46), new Location(388, 26)));
      assertEquals(false, rc.withinRange(new Location(350, 227), new Location(294, 228)));
      assertEquals(false, rc.withinRange(new Location(253, 202), new Location(337, 206)));
      assertEquals(false, rc.withinRange(new Location(246, 63), new Location(303, 218)));
      assertEquals(false, rc.withinRange(new Location(37, 306), new Location(378, 245)));
      assertEquals(false, rc.withinRange(new Location(276, 398), new Location(49, 323)));
      assertEquals(false, rc.withinRange(new Location(7, 123), new Location(372, 377)));
      assertEquals(false, rc.withinRange(new Location(343, 128), new Location(114, 245)));
      assertEquals(false, rc.withinRange(new Location(40, 287), new Location(152, 83)));
      assertEquals(false, rc.withinRange(new Location(394, 103), new Location(202, 395)));
      assertEquals(false, rc.withinRange(new Location(288, 46), new Location(24, 37)));
      assertEquals(false, rc.withinRange(new Location(236, 330), new Location(22, 52)));
      assertEquals(false, rc.withinRange(new Location(266, 318), new Location(5, 286)));
      assertEquals(false, rc.withinRange(new Location(335, 204), new Location(291, 90)));
      assertEquals(false, rc.withinRange(new Location(216, 111), new Location(213, 337)));
      assertEquals(false, rc.withinRange(new Location(213, 239), new Location(317, 350)));
      assertEquals(false, rc.withinRange(new Location(214, 10), new Location(66, 84)));
      assertEquals(false, rc.withinRange(new Location(355, 273), new Location(275, 296)));

      assertEquals(true, rc.withinRange(new Location(47, 42), new Location(26, 60)));
      assertEquals(true, rc.withinRange(new Location(11, 7), new Location(10, 2)));
      assertEquals(true, rc.withinRange(new Location(16, 89), new Location(35, 95)));
      assertEquals(true, rc.withinRange(new Location(39, 80), new Location(49, 77)));
      assertEquals(true, rc.withinRange(new Location(70, 34), new Location(64, 57)));
      assertEquals(true, rc.withinRange(new Location(74, 38), new Location(51, 57)));
      assertEquals(true, rc.withinRange(new Location(59, 8), new Location(85, 41)));
      assertEquals(true, rc.withinRange(new Location(83, 52), new Location(94, 10)));
      assertEquals(true, rc.withinRange(new Location(39, 99), new Location(84, 80)));
      assertEquals(true, rc.withinRange(new Location(38, 83), new Location(40, 58)));
      assertEquals(true, rc.withinRange(new Location(91, 38), new Location(80, 82)));
      assertEquals(true, rc.withinRange(new Location(61, 99), new Location(73, 54)));
      assertEquals(true, rc.withinRange(new Location(36, 69), new Location(14, 38)));
      assertEquals(true, rc.withinRange(new Location(31, 37), new Location(5, 67)));
      assertEquals(true, rc.withinRange(new Location(37, 58), new Location(24, 68)));
      assertEquals(true, rc.withinRange(new Location(45, 94), new Location(43, 96)));
    }

   public void testRadioContact03()
   {
      RadioContact rc  = new RadioContact();

      assertEquals(false, rc.withinRange(new Location(99, 35), new Location(42, 33)));
      assertEquals(false, rc.withinRange(new Location(1, 37), new Location(43, 99)));
      assertEquals(false, rc.withinRange(new Location(86, 51), new Location(29, 96)));
      assertEquals(false, rc.withinRange(new Location(47, 12), new Location(40, 86)));
      assertEquals(false, rc.withinRange(new Location(42, 96), new Location(36, 38)));
      assertEquals(false, rc.withinRange(new Location(3, 12), new Location(89, 57)));
      assertEquals(false, rc.withinRange(new Location(62, 59), new Location(99, 98)));
      assertEquals(true, rc.withinRange(new Location(22, 62), new Location(15, 36)));
      assertEquals(false, rc.withinRange(new Location(58, 5), new Location(19, 86)));
      assertEquals(false, rc.withinRange(new Location(90, 90), new Location(6, 99)));
      assertEquals(false, rc.withinRange(new Location(87, 5), new Location(54, 56)));

      assertEquals(true, rc.withinRange(new Location(57, 81), new Location(69, 54)));
      assertEquals(true, rc.withinRange(new Location(69, 11), new Location(20, 14)));
      assertEquals(true, rc.withinRange(new Location(18, 92), new Location(50, 79)));
      assertEquals(true, rc.withinRange(new Location(67, 83), new Location(65, 85)));
      assertEquals(true, rc.withinRange(new Location(30, 73), new Location(60, 39)));
      assertEquals(true, rc.withinRange(new Location(38, 29), new Location(36, 10)));
      assertEquals(true, rc.withinRange(new Location(21, 36), new Location(66, 27)));
      assertEquals(true, rc.withinRange(new Location(66, 30), new Location(83, 48)));
    }

   public void testRadioContact04()
   {
      RadioContact rc  = new RadioContact();

      assertEquals(false, rc.withinRange(new Location(0, 37), new Location(95, 54)));
      assertEquals(false, rc.withinRange(new Location(94, 48), new Location(12, 81)));
      assertEquals(false, rc.withinRange(new Location(90, 3), new Location(42, 74)));
      assertEquals(false, rc.withinRange(new Location(37, 60), new Location(95, 35)));
      assertEquals(false, rc.withinRange(new Location(30, 99), new Location(44, 23)));
      assertEquals(false, rc.withinRange(new Location(3, 89), new Location(93, 94)));
      assertEquals(true, rc.withinRange(new Location(29, 78), new Location(15, 63)));
      assertEquals(false, rc.withinRange(new Location(84, 65), new Location(0, 4)));
      assertEquals(false, rc.withinRange(new Location(30, 98), new Location(37, 32)));
      assertEquals(false, rc.withinRange(new Location(94, 27), new Location(42, 62)));
      assertEquals(false, rc.withinRange(new Location(96, 88), new Location(40, 52)));
      assertEquals(false, rc.withinRange(new Location(94, 21), new Location(5, 94)));

      assertEquals(true, rc.withinRange(new Location(44, 24), new Location(81, 30)));
      assertEquals(true, rc.withinRange(new Location(78, 24), new Location(61, 65)));
      assertEquals(true, rc.withinRange(new Location(99, 52), new Location(53, 63)));
      assertEquals(true, rc.withinRange(new Location(35, 88), new Location(54, 90)));
      assertEquals(true, rc.withinRange(new Location(82, 94), new Location(92, 51)));
      assertEquals(true, rc.withinRange(new Location(9, 91), new Location(35, 72)));
      assertEquals(true, rc.withinRange(new Location(63, 30), new Location(93, 63)));
      assertEquals(true, rc.withinRange(new Location(11, 86), new Location(11, 82)));
   }

   public void testRadioContact05()
   {
      ArrayList<Location> locs = new ArrayList<Location>();

      locs = new ArrayList<Location>();
      locs.add(new Location(0, 0));
      locs.add(new Location(0, 100));
      locs.add(new Location(0, 200));
      locs.add(new Location(0, 300));
      locs.add(new Location(100, 0));
      locs.add(new Location(100, 100));
      locs.add(new Location(100, 200));

      RadioContact rc  = new RadioContact(locs);
      assertEquals(7, rc.getNumberSquads());

      locs.add(new Location(100, 300));
      locs.add(new Location(200, 0));
      locs.add(new Location(200, 100));

      rc  = new RadioContact(locs);
      assertEquals(10, rc.getNumberSquads());

      locs.add(new Location(200, 200));
      locs.add(new Location(200, 300));

      rc  = new RadioContact(locs);
      assertEquals(12, rc.getNumberSquads());
   }

   public void testRadioContact06()
   {
      ArrayList<Location> locs = new ArrayList<Location>();

      locs = new ArrayList<Location>();
      locs.add(new Location(0, 0));
      locs.add(new Location(0, 45));
      locs.add(new Location(0, 90));
      locs.add(new Location(0, 130));
      locs.add(new Location(35, 10));
      locs.add(new Location(75, 25));
      locs.add(new Location(100, 50));

      RadioContact rc  = new RadioContact(locs);
      assertEquals(1, rc.getNumberSquads());

      locs.add(new Location(149, 50));
      locs.add(new Location(155, 80));
      locs.add(new Location(200, 90));

      rc  = new RadioContact(locs);
      assertEquals(1, rc.getNumberSquads());

      locs.add(new Location(210, 130));
      locs.add(new Location(210, 175));

      rc  = new RadioContact(locs);
      assertEquals(1, rc.getNumberSquads());
   }

   public void testRadioContact07()
   {
      ArrayList<Location> locs = new ArrayList<Location>();

      locs = new ArrayList<Location>();
      locs.add(new Location(0, 0));
      locs.add(new Location(0, 100));
      locs.add(new Location(0, 200));
      locs.add(new Location(0, 300));
      locs.add(new Location(100, 0));
      locs.add(new Location(100, 100));
      locs.add(new Location(100, 200));

      RadioContact rc  = new RadioContact(locs);
      assertEquals(7, rc.getNumberSquads());

      locs.add(new Location(100, 300));
      locs.add(new Location(200, 0));
      locs.add(new Location(200, 100));

      rc  = new RadioContact(locs);
      assertEquals(10, rc.getNumberSquads());

      locs.add(new Location(200, 200));
      locs.add(new Location(200, 300));

      rc  = new RadioContact(locs);
      assertEquals(12, rc.getNumberSquads());

      locs.add(new Location(25, 25));
      locs.add(new Location(25, 60));

      rc  = new RadioContact(locs);
      assertEquals(11, rc.getNumberSquads());

      locs.add(new Location(74, 25));
      locs.add(new Location(75, 60));

      rc  = new RadioContact(locs);
      assertEquals(9, rc.getNumberSquads());

      locs.add(new Location(27, 125));
      locs.add(new Location(25, 160));
      locs.add(new Location(74, 125));
      locs.add(new Location(75, 160));

      rc  = new RadioContact(locs);
      assertEquals(7, rc.getNumberSquads());

      locs.add(new Location(27, 225));
      locs.add(new Location(25, 260));
      locs.add(new Location(74, 225));
      locs.add(new Location(75, 260));

      rc  = new RadioContact(locs);
      assertEquals(5, rc.getNumberSquads());

      locs.add(new Location(227, 25));
      locs.add(new Location(225, 60));
      locs.add(new Location(224, 225));
      locs.add(new Location(225, 260));

      rc  = new RadioContact(locs);
      assertEquals(3, rc.getNumberSquads());

      locs.add(new Location(127, 125));
      locs.add(new Location(125, 160));
      locs.add(new Location(174, 125));
      locs.add(new Location(175, 160));

      rc  = new RadioContact(locs);
      assertEquals(1, rc.getNumberSquads());
   }

   public void testRadioContact08()
   {
      RadioContact rc  = new RadioContact();
      assertEquals(false, rc.withinRange(new Location(40, 76), new Location(87, 40)));
      assertEquals(false, rc.withinRange(new Location(88, 3), new Location(32, 0)));
      assertEquals(false, rc.withinRange(new Location(33, 54), new Location(97, 92)));
      assertEquals(false, rc.withinRange(new Location(27, 13), new Location(83, 51)));
      assertEquals(false, rc.withinRange(new Location(61, 14), new Location(57, 81)));
      assertEquals(false, rc.withinRange(new Location(59, 20), new Location(17, 70)));
      assertEquals(false, rc.withinRange(new Location(88, 0), new Location(34, 69)));
      assertEquals(false, rc.withinRange(new Location(8, 60), new Location(65, 16)));

      assertEquals(true, rc.withinRange(new Location(31, 85), new Location(31, 75)));
      assertEquals(true, rc.withinRange(new Location(70, 6), new Location(96, 30)));
      assertEquals(true, rc.withinRange(new Location(12, 51), new Location(13, 32)));
      assertEquals(true, rc.withinRange(new Location(85, 89), new Location(85, 86)));
      assertEquals(true, rc.withinRange(new Location(76, 83), new Location(95, 75)));
      assertEquals(true, rc.withinRange(new Location(78, 88), new Location(88, 43)));
      assertEquals(true, rc.withinRange(new Location(58, 74), new Location(72, 70)));
      assertEquals(true, rc.withinRange(new Location(86, 52), new Location(69, 17)));
      assertEquals(true, rc.withinRange(new Location(89, 21), new Location(46, 15)));
      assertEquals(true, rc.withinRange(new Location(35, 28), new Location(52, 57)));
      assertEquals(true, rc.withinRange(new Location(58, 71), new Location(58, 50)));
      assertEquals(true, rc.withinRange(new Location(11, 45), new Location(7, 67)));

      ArrayList<Location> locs = new ArrayList<Location>();
      locs.add(new Location(10, 96));
      locs.add(new Location(32, 266));
      locs.add(new Location(48, 136));
      locs.add(new Location(64, 202));
      locs.add(new Location(94, 54));
      locs.add(new Location(111, 80));
      locs.add(new Location(123, 226));
      locs.add(new Location(138, 86));
      locs.add(new Location(176, 94));
      locs.add(new Location(200, 186));
      locs.add(new Location(210, 84));
      locs.add(new Location(216, 98));
      locs.add(new Location(256, 160));

      rc  = new RadioContact(locs);
      assertEquals(8, rc.getNumberSquads());

      locs.add(new Location(236, 158));

      rc  = new RadioContact(locs);
      assertEquals(7, rc.getNumberSquads());

      locs.add(new Location(206, 146));

      rc  = new RadioContact(locs);
      assertEquals(6, rc.getNumberSquads());

      locs.add(new Location(56, 176));
      locs.add(new Location(99, 211));

      rc  = new RadioContact(locs);
      assertEquals(4, rc.getNumberSquads());
   }

   public void testRadioContact09()
   {
      RadioContact rc  = new RadioContact();

      assertEquals(false, rc.withinRange(new Location(89, 12), new Location(32, 63)));
      assertEquals(false, rc.withinRange(new Location(18, 86), new Location(11, 29)));
      assertEquals(true, rc.withinRange(new Location(12, 34), new Location(17, 37)));
      assertEquals(true, rc.withinRange(new Location(17, 27), new Location(47, 37)));
      assertEquals(false, rc.withinRange(new Location(28, 97), new Location(79, 59)));
      assertEquals(false, rc.withinRange(new Location(53, 53), new Location(5, 6)));
      assertEquals(false, rc.withinRange(new Location(84, 99), new Location(2, 66)));
      assertEquals(false, rc.withinRange(new Location(79, 66), new Location(29, 47)));
      assertEquals(false, rc.withinRange(new Location(88, 54), new Location(5, 62)));
      assertEquals(false, rc.withinRange(new Location(40, 21), new Location(63, 85)));
       
      assertEquals(true, rc.withinRange(new Location(27, 28), new Location(55, 22)));
      assertEquals(true, rc.withinRange(new Location(38, 19), new Location(5, 5)));
      assertEquals(true, rc.withinRange(new Location(24, 26), new Location(15, 68)));
      assertEquals(true, rc.withinRange(new Location(75, 9), new Location(65, 6)));
      assertEquals(true, rc.withinRange(new Location(83, 53), new Location(45, 57)));
      assertEquals(true, rc.withinRange(new Location(62, 70), new Location(59, 94)));
      assertEquals(true, rc.withinRange(new Location(51, 8), new Location(82, 47)));
      assertEquals(true, rc.withinRange(new Location(65, 91), new Location(54, 56)));
      assertEquals(true, rc.withinRange(new Location(79, 84), new Location(51, 67)));
      assertEquals(true, rc.withinRange(new Location(45, 55), new Location(51, 67)));

      ArrayList<Location> locs = new ArrayList<Location>();
      locs.add(new Location(-10, -96));
      locs.add(new Location(-32, -266));
      locs.add(new Location(-48, -136));
      locs.add(new Location(-64, -202));
      locs.add(new Location(-94, -4));

      locs.add(new Location(111, -80));
      locs.add(new Location(123, -226));
      locs.add(new Location(138, -156));
      locs.add(new Location(176, -4));

      locs.add(new Location(-200, 186));
      locs.add(new Location(-210, 84));
      locs.add(new Location(-266, 98));
      locs.add(new Location(-256, 160));

      rc  = new RadioContact(locs);
      assertEquals(locs.size(), rc.getNumberSquads());

      locs.add(1, new Location(-15, -136));
      locs.add(new Location(-25, -216));
      locs.add(6, new Location(-20, -176));
      locs.add(8, new Location(-30, -236));
      locs.add(new Location(-42, -189));
      locs.add(3, new Location(-52, -70));
      locs.add(13, new Location(-82, -35));

      locs.add(new Location(130, -70));
      locs.add(1, new Location(123, -120));
      locs.add(9, new Location(123, -165));
      locs.add(new Location(130, -120));
      locs.add(7, new Location(140, -200));
      locs.add(2, new Location(176, 0));
      locs.add(11, new Location(123, -215));
      locs.add(9, new Location(123, -164));
      locs.add(new Location(150, -40));

      locs.add(1, new Location(-205, 124));
      locs.add(new Location(-190, 164));
      locs.add(6, new Location(-238, 124));
      locs.add(8, new Location(-230, 136));
      locs.add(16, new Location(-238, 90));
      locs.add(21, new Location(-260, 135));

      rc  = new RadioContact(locs);
      assertEquals(3, rc.getNumberSquads());
   }

   public void testRadioContact10()
   {
      RadioContact rc  = new RadioContact();

      assertEquals(true, rc.withinRange(new Location(86, 40), new Location(93, 57)));
      assertEquals(false, rc.withinRange(new Location(37, 16), new Location(24, 85)));
      assertEquals(true, rc.withinRange(new Location(34, 85), new Location(28, 37)));
      assertEquals(false, rc.withinRange(new Location(91, 42), new Location(21, 27)));
      assertEquals(true, rc.withinRange(new Location(55, 12), new Location(65, 56)));
      assertEquals(false, rc.withinRange(new Location(9, 12), new Location(28, 98)));
      assertEquals(false, rc.withinRange(new Location(70, 97), new Location(70, 25)));
      assertEquals(true, rc.withinRange(new Location(35, 77), new Location(1, 74)));
      assertEquals(false, rc.withinRange(new Location(88, 61), new Location(28, 94)));
      assertEquals(false, rc.withinRange(new Location(65, 8), new Location(35, 77)));
      assertEquals(false, rc.withinRange(new Location(18, 77), new Location(7, 24)));
      assertEquals(false, rc.withinRange(new Location(77, 7), new Location(14, 0)));
      assertEquals(true, rc.withinRange(new Location(48, 12), new Location(19, 5)));
      assertEquals(false, rc.withinRange(new Location(13, 43), new Location(73, 32)));
      assertEquals(false, rc.withinRange(new Location(10, 53), new Location(57, 84)));
      assertEquals(false, rc.withinRange(new Location(9, 6), new Location(45, 96)));
      assertEquals(false, rc.withinRange(new Location(66, 79), new Location(36, 23)));
      assertEquals(false, rc.withinRange(new Location(63, 31), new Location(67, 99)));
      assertEquals(false, rc.withinRange(new Location(98, 92), new Location(4, 95)));
      assertEquals(true, rc.withinRange(new Location(85, 30), new Location(68, 53)));
       
      testRadioContact06();
      testRadioContact07();
      testRadioContact08();
      testRadioContact09();
   }
   public void testUnitSummation01()
   {
      UnitSummation us = new UnitSummation();
      assertEquals(true, us.isUnitSummation(145));
      assertEquals(false, us.isUnitSummation(146));
      assertEquals(false, us.isUnitSummation(503));
      assertEquals(false, us.isUnitSummation(504));
      assertEquals(true, us.isUnitSummation(516));
      assertEquals(false, us.isUnitSummation(1448));
      assertEquals(true, us.isUnitSummation(1449));

      int[] sol1 = us.getUnitSummationBetween(100, 200);
      int[] a1 = {101, 112, 123, 134, 145, 156, 167, 178, 189};
      ArrayList<Integer> ans = new ArrayList<Integer>();
      for(int t : a1)
         ans.add(new Integer(t));
      assertEquals(sol1.length, ans.size());
      for(int j : sol1)
         assertEquals(true, ans.contains(new Integer(j)));
   }

   public void testUnitSummation02()
   {
      UnitSummation us = new UnitSummation();
      assertEquals(true, us.isUnitSummation(11));
      assertEquals(true, us.isUnitSummation(10001));
      assertEquals(true, us.isUnitSummation(2002));
      assertEquals(true, us.isUnitSummation(10012));
      assertEquals(true, us.isUnitSummation(110103));
      assertEquals(true, us.isUnitSummation(123));
      assertEquals(true, us.isUnitSummation(303));
      assertEquals(true, us.isUnitSummation(120014));
      assertEquals(true, us.isUnitSummation(40004));
      assertEquals(true, us.isUnitSummation(11114));
      assertEquals(true, us.isUnitSummation(1210004));

      assertEquals(false, us.isUnitSummation(1000011));
      assertEquals(false, us.isUnitSummation(11003));
      assertEquals(false, us.isUnitSummation(10002));
      assertEquals(false, us.isUnitSummation(2002014));
      assertEquals(false, us.isUnitSummation(1110004));
      assertEquals(false, us.isUnitSummation(11012));
   }

   public void testUnitSummation03()
   {
      UnitSummation us = new UnitSummation();
      assertEquals(true, us.isUnitSummation(1135));
      assertEquals(true, us.isUnitSummation(1021015));
      assertEquals(true, us.isUnitSummation(5005));
      assertEquals(true, us.isUnitSummation(14016));
      assertEquals(true, us.isUnitSummation(1101036));
      assertEquals(true, us.isUnitSummation(1236));
      assertEquals(true, us.isUnitSummation(101136));
      assertEquals(true, us.isUnitSummation(30036));
      assertEquals(true, us.isUnitSummation(3137));
      assertEquals(true, us.isUnitSummation(3137));
      assertEquals(true, us.isUnitSummation(31037));
      assertEquals(true, us.isUnitSummation(1200148));
      assertEquals(true, us.isUnitSummation(400048));
      assertEquals(true, us.isUnitSummation(111148));
      assertEquals(true, us.isUnitSummation(12101049));

      assertEquals(false, us.isUnitSummation(4000014));
      assertEquals(false, us.isUnitSummation(32006));
      assertEquals(false, us.isUnitSummation(312007));
      assertEquals(false, us.isUnitSummation(110124));
      assertEquals(false, us.isUnitSummation(40016));
      assertEquals(false, us.isUnitSummation(30046));
      assertEquals(false, us.isUnitSummation(112125));
      assertEquals(false, us.isUnitSummation(43017));
      assertEquals(false, us.isUnitSummation(30048));
      assertEquals(false, us.isUnitSummation(1259));
      assertEquals(false, us.isUnitSummation(20519));
      assertEquals(false, us.isUnitSummation(23138));
   }

   public void testUnitSummation04()
   {
      UnitSummation us = new UnitSummation();
      assertEquals(true, us.isUnitSummation(156));
      assertEquals(true, us.isUnitSummation(10258));
      assertEquals(true, us.isUnitSummation(1111015));
      assertEquals(true, us.isUnitSummation(14117));
      assertEquals(true, us.isUnitSummation(110103));
      assertEquals(true, us.isUnitSummation(120238));
      assertEquals(true, us.isUnitSummation(101169));
      assertEquals(true, us.isUnitSummation(3110319));
      assertEquals(true, us.isUnitSummation(313029));
      assertEquals(true, us.isUnitSummation(31004));
      assertEquals(true, us.isUnitSummation(2000002));
      assertEquals(true, us.isUnitSummation(1001002));
      assertEquals(true, us.isUnitSummation(40004));
      assertEquals(true, us.isUnitSummation(10001));
      assertEquals(true, us.isUnitSummation(101));

      assertEquals(false, us.isUnitSummation(102));
      assertEquals(false, us.isUnitSummation(2001));
      assertEquals(false, us.isUnitSummation(3002));
      assertEquals(false, us.isUnitSummation(1103));
      assertEquals(false, us.isUnitSummation(20014));
      assertEquals(false, us.isUnitSummation(30013));
      assertEquals(false, us.isUnitSummation(112005));
      assertEquals(false, us.isUnitSummation(23017));
      assertEquals(false, us.isUnitSummation(30035));
      assertEquals(false, us.isUnitSummation(1005108));
      assertEquals(false, us.isUnitSummation(20419));
      assertEquals(false, us.isUnitSummation(13137));
      assertEquals(false, us.isUnitSummation(31319));
      assertEquals(false, us.isUnitSummation(131318));
   }

   public void testUnitSummation05()
   {
      UnitSummation us = new UnitSummation();

      int[] sol = us.getUnitSummationBetween(111119, 115231);
      int[] a = {111126, 111137, 111148, 111159, 111205, 111216, 111227,
                 111238, 111249, 111306, 111317, 111328, 111339, 111407,
                 111418, 111429, 111508, 111519, 111609, 112004, 112015,
                 112026, 112037, 112048, 112059, 112105, 112116, 112127,
                 112138, 112149, 112206, 112217, 112228, 112239, 112307,
                 112318, 112329, 112408, 112419, 112509, 113005, 113016,
                 113027, 113038, 113049, 113106, 113117, 113128, 113139,
                 113207, 113218, 113229, 113308, 113319, 113409, 114006,
                 114017, 114028, 114039, 114107, 114118, 114129, 114208,
                 114219, 114309, 115007, 115018, 115029, 115108, 115119,
                 115209};
      ArrayList<Integer> ans = new ArrayList<Integer>();
      for(int t : a)
         ans.add(new Integer(t));
      assertEquals(sol.length, ans.size());
      for(int j : sol)
         assertEquals(true, ans.contains(new Integer(j)));
   }

   public void testUnitSummation06()
   {
      UnitSummation us = new UnitSummation();

      int[] sol = us.getUnitSummationBetween(506789, 518789);
      int[] a = {510006, 510017, 510028, 510039, 510107, 510118, 510129,
                 510208, 510219, 510309, 511007, 511018, 511029, 511108,
                 511119, 511209, 512008, 512019, 512109, 513009};
      ArrayList<Integer> ans = new ArrayList<Integer>();
      for(int t : a)
         ans.add(new Integer(t));
      assertEquals(sol.length, ans.size());
      for(int j : sol)
         assertEquals(true, ans.contains(new Integer(j)));
   }

   public void testUnitSummation07()
   {
      UnitSummation us = new UnitSummation();

      int[] sol = us.getUnitSummationBetween(90000, 100349);
      int[] a = {90009, 100001, 100012, 100023, 100034, 100045, 100056, 100067,
                 100078, 100089, 100102, 100113, 100124, 100135, 100146, 100157,
                 100168, 100179, 100203, 100214, 100225, 100236, 100247, 100258,
                 100269, 100304, 100315, 100326, 100337, 100348};
      ArrayList<Integer> ans = new ArrayList<Integer>();
      for(int t : a)
         ans.add(new Integer(t));
      assertEquals(sol.length, ans.size());
      for(int j : sol)
         assertEquals(true, ans.contains(new Integer(j)));
   }

   public void testUnitSummation08()
   {
      UnitSummation us = new UnitSummation();
      assertEquals(true, us.isUnitSummation(1416));
      assertEquals(false, us.isUnitSummation(1417));
      assertEquals(false, us.isUnitSummation(1418));
      assertEquals(false, us.isUnitSummation(1358));
      assertEquals(true, us.isUnitSummation(1359));
      assertEquals(false, us.isUnitSummation(1360));

      int[] sol = us.getUnitSummationBetween(2314, 2709);
      int[] a = {2316, 2327, 2338, 2349, 2406, 2417, 2428, 2439, 2507, 2518, 2529, 2608, 2619, 2709};
      ArrayList<Integer> ans = new ArrayList<Integer>();
      for(int t : a)
         ans.add(new Integer(t));
      assertEquals(sol.length, ans.size());
      for(int j : sol)
         assertEquals(true, ans.contains(new Integer(j)));
   }

   public void testUnitSummation09()
   {
      UnitSummation us = new UnitSummation();
      assertEquals(true, us.isUnitSummation(1326));
      assertEquals(true, us.isUnitSummation(1236));
      assertEquals(true, us.isUnitSummation(3216));
      assertEquals(true, us.isUnitSummation(3227));
      assertEquals(true, us.isUnitSummation(1618));
      assertEquals(true, us.isUnitSummation(2035));
      assertEquals(true, us.isUnitSummation(2439));
      assertEquals(false, us.isUnitSummation(13216));
      assertEquals(false, us.isUnitSummation(1226));
      assertEquals(false, us.isUnitSummation(3226));
      assertEquals(false, us.isUnitSummation(3237));
      assertEquals(false, us.isUnitSummation(1696));
      assertEquals(false, us.isUnitSummation(135));
      assertEquals(false, us.isUnitSummation(2339));

      int[] sol = us.getUnitSummationBetween(555, 709);
      int[] a = {606, 617, 628, 639, 707};
      ArrayList<Integer> ans = new ArrayList<Integer>();
      for(int t : a)
         ans.add(new Integer(t));
      assertEquals(sol.length, ans.size());
      for(int j : sol)
         assertEquals(true, ans.contains(new Integer(j)));

      int[] sol1 = us.getUnitSummationBetween(120, 200);
      int[] a1 = {123, 134, 145, 156, 167, 178, 189};
      ans = new ArrayList<Integer>();
      for(int t : a1)
         ans.add(new Integer(t));
      assertEquals(sol1.length, ans.size());
      for(int j : sol1)
         assertEquals(true, ans.contains(new Integer(j)));
   }

   public void testUnitSummation10()
   {
      UnitSummation us = new UnitSummation();
      assertEquals(true, us.isUnitSummation(1719));
      assertEquals(false, us.isUnitSummation(1720));
      assertEquals(false, us.isUnitSummation(1721));
      assertEquals(false, us.isUnitSummation(1722));
      assertEquals(false, us.isUnitSummation(1627));
      assertEquals(false, us.isUnitSummation(1628));
      assertEquals(true, us.isUnitSummation(1629));
      assertEquals(true, us.isUnitSummation(1607));

      int[] sol = us.getUnitSummationBetween(5039, 6117);
      int[] a = {5049, 5106, 5117, 5128, 5139, 5207, 5218, 5229, 5308, 5319, 5409, 6006, 6017, 6028, 6039, 6107};
      ArrayList<Integer> ans = new ArrayList<Integer>();
      for(int t : a)
         ans.add(new Integer(t));
      assertEquals(sol.length, ans.size());
      for(int j : sol)
         assertEquals(true, ans.contains(new Integer(j)));
   }
   public void testSumOfPrimes01()
   {
      SumOfPrimes sp = new SumOfPrimes();
      assertEquals(1, sp.getNumberOfSums(2+3+5, 3));

      assertEquals(2, sp.getNumberOfSums(24, 3));

      assertEquals(3, sp.getNumberOfSums(24, 2));
      assertEquals(1, sp.getNumberOfSums(2, 1));
      assertEquals(0, sp.getNumberOfSums(1, 1));
      assertEquals(0, sp.getNumberOfSums(4, 2));
      assertEquals(2, sp.getNumberOfSums(18, 3));
      assertEquals(1, sp.getNumberOfSums(17, 1));
      assertEquals(0, sp.getNumberOfSums(17, 3));
      assertEquals(1, sp.getNumberOfSums(17, 4));
      assertEquals(0, sp.getNumberOfSums(0, 0));
   }

   public void testSumOfPrimes02()
   {
      SumOfPrimes sp = new SumOfPrimes();
      assertEquals(5, sp.getNumberOfSums(19+11+7+2, 4));
      assertEquals(4, sp.getNumberOfSums(19+11+7+2+3, 4));
      assertEquals(3, sp.getNumberOfSums(100, 3));
      assertEquals(28, sp.getNumberOfSums(1000, 2));
   }

   public void testSumOfPrimes03()
   {
      SumOfPrimes sp = new SumOfPrimes();
      assertEquals(1, sp.getNumberOfSums(17+11+13+7+3+5, 6));
      assertEquals(4, sp.getNumberOfSums(23+11+7+3, 5));
      assertEquals(6, sp.getNumberOfSums(55 + 13, 3));
      assertEquals(15, sp.getNumberOfSums(42 + 27, 4));
      assertEquals(6, sp.getNumberOfSums(23+11+7+3, 4));
      assertEquals(5, sp.getNumberOfSums(23+13+17+2, 5));
   }

   public void testSumOfPrimes04()
   {
      SumOfPrimes sp = new SumOfPrimes();
      assertEquals(2, sp.getNumberOfSums(55 + 13 + 2, 3));
      assertEquals(32, sp.getNumberOfSums(42 + 27 + 11, 4));
      assertEquals(32, sp.getNumberOfSums(23+11 + 67, 3));
      assertEquals(0, sp.getNumberOfSums(23+13+179+2 + 41, 1));
   }

   public void testSumOfPrimes05()
   {
      SumOfPrimes sp = new SumOfPrimes();
      assertEquals(14, sp.getNumberOfSums(127 + 131, 2));
      assertEquals(82, sp.getNumberOfSums(187, 3));
      assertEquals(11, sp.getNumberOfSums(7+11+13+17+19, 5));
      assertEquals(14, sp.getNumberOfSums(23+13+179+2 + 41, 2));
   }

   public void testSumOfPrimes06()
   {
      SumOfPrimes sp = new SumOfPrimes();
      assertEquals(1, sp.getNumberOfSums(1009, 1));
      assertEquals(0, sp.getNumberOfSums(1009, 2));
      assertEquals(1, sp.getNumberOfSums(1031, 1));
      assertEquals(0, sp.getNumberOfSums(1031, 2));
   }

   public void testSumOfPrimes07()
   {
      SumOfPrimes sp = new SumOfPrimes();
      assertEquals(6, sp.getNumberOfSums(60, 2));
      assertEquals(5, sp.getNumberOfSums(50, 3));
      assertEquals(4, sp.getNumberOfSums(40, 4));
      assertEquals(1, sp.getNumberOfSums(30, 5));
   }

   public void testSumOfPrimes08()
   {
      SumOfPrimes sp = new SumOfPrimes();
      assertEquals(1, sp.getNumberOfSums(75, 2));
      assertEquals(14, sp.getNumberOfSums(65, 3));
      assertEquals(4, sp.getNumberOfSums(35, 4));
      assertEquals(1, sp.getNumberOfSums(47, 5));
      assertEquals(1, sp.getNumberOfSums(58, 6));
   }

   public void testSumOfPrimes09()
   {
      SumOfPrimes sp = new SumOfPrimes();
      assertEquals(0, sp.getNumberOfSums(99, 1));
      assertEquals(4, sp.getNumberOfSums(82, 2));
      assertEquals(18, sp.getNumberOfSums(71, 3));
      assertEquals(21, sp.getNumberOfSums(68, 4));
      assertEquals(22, sp.getNumberOfSums(72, 5));
   }

   public void testSumOfPrimes10()
   {
      SumOfPrimes sp = new SumOfPrimes();
      assertEquals(1, sp.getNumberOfSums(99, 2));
      assertEquals(4, sp.getNumberOfSums(82, 3));
      assertEquals(13, sp.getNumberOfSums(71, 4));
      assertEquals(6, sp.getNumberOfSums(68, 3));
      assertEquals(5, sp.getNumberOfSums(70, 2));
   }
}