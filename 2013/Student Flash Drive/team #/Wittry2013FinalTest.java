import java.util.*;

/**
 * The test class FinalTypeWriter.
 *
 * @author  (your name)
 * @version 2013 Wittry programming contest
 */
public class Wittry2013FinalTest extends junit.framework.TestCase
{
/*
 *    TypeWriter tester
 */
   private static final String topRow = "qwertyuiopQWERTYUIOP";
   private static final String midRow = "asdfghjklASDFGHJKL";
   private static final String botRow = "ZXCCVBNMzxcvbnm";

   public void testTypewriter01()
   {
      TypeWriter tw = new TypeWriter();
      assertEquals(true, tw.usesLeftHand("am"));
      assertEquals(true, tw.usesRightHand("am"));
      assertEquals(false, tw.usesLeftHand("m"));
      assertEquals(false, tw.usesRightHand("a"));

      assertEquals(true, tw.usesOnlyLeftHand("stewardesses"));
      assertEquals(false, tw.usesOnlyLeftHand("stewardessesy"));

      assertEquals(true, tw.usesOnlyRightHand("monimolimnion"));
      assertEquals(false, tw.usesOnlyRightHand("amonimolimnion"));
      assertEquals(true, tw.usesBothLeftAndRightHand("am"));

      assertEquals(true, tw.usesTopRow("1 fish"));
      assertEquals(true, tw.usesMiddleRow("amonimolimnion"));
      assertEquals(true, tw.usesBottomRow("amonimolimnion"));

      assertEquals(false, tw.usesTopRow("1 fsh"));
      assertEquals(false, tw.usesMiddleRow("monimoimnion"));
      assertEquals(false, tw.usesBottomRow("atoil"));

      assertEquals(true, tw.usesOnlyTopRow("iriueowqpqQWREIOPTIOW"));
      assertEquals(true, tw.usesOnlyMiddleRow("asdfjlfDFSLKHASLKF"));
      assertEquals(true, tw.usesOnlyBottomRow("MCBNVNMZncmxzmvbz,m"));

      assertEquals(false, tw.usesOnlyTopRow("iriueowqpqQaWREIOPTIOW"));
      assertEquals(false, tw.usesOnlyMiddleRow("asdfjlfDFiSLKHASLKF"));
      assertEquals(false, tw.usesOnlyBottomRow("MCBNVNMZnclmxzmvbz,m"));
    }

   public void testTypewriter02()   // usesLeftHand   &&    usesOnlyLeftHand  -  no spaces
   {
      TypeWriter tw = new TypeWriter();
      assertEquals(false, tw.usesLeftHand("yb"));
      assertEquals(false, tw.usesLeftHand(""));
      assertEquals(false, tw.usesLeftHand("7890"));

      assertEquals(true, tw.usesLeftHand("y1p"));
      assertEquals(true, tw.usesLeftHand("YUIOP2LKJHBNM"));
      assertEquals(true, tw.usesLeftHand("7890yuio3plkjhbnm"));
      assertEquals(true, tw.usesLeftHand("monimolimnion4"));

      assertEquals(true, tw.usesLeftHand("qwert"));
      assertEquals(true, tw.usesLeftHand("asdfgvcxz"));

      assertEquals(true, tw.usesLeftHand("QWERT"));
      assertEquals(true, tw.usesLeftHand("ASDFGVCXZ"));
      assertEquals(true, tw.usesLeftHand("123456"));

      assertEquals(true, tw.usesOnlyLeftHand("readdressed"));
      assertEquals(true, tw.usesOnlyLeftHand("aftereffects"));
      assertEquals(true, tw.usesOnlyLeftHand("stagecraft"));

      assertEquals(false, tw.usesOnlyLeftHand("readdressedy"));
      assertEquals(false, tw.usesOnlyLeftHand("afterefnfects"));
      assertEquals(false, tw.usesOnlyLeftHand("stage7craft"));
   }

   public void testTypewriter03()   // usesRightHand   &&    usesOnlyRightHand
   {
      TypeWriter tw = new TypeWriter();
      assertEquals(true, tw.usesRightHand("yp"));
      assertEquals(true, tw.usesRightHand("YUIOPLKJHBNM"));
      assertEquals(true, tw.usesRightHand("7890yuioplkjhbnm"));
      assertEquals(true, tw.usesRightHand("readdbressed"));
      assertEquals(true, tw.usesRightHand("aftereyffects"));
      assertEquals(true, tw.usesRightHand("stagecr0aft"));

      assertEquals(false, tw.usesRightHand("readdressed"));
      assertEquals(false, tw.usesRightHand("qwert"));
      assertEquals(false, tw.usesRightHand("asdfgvcxz"));
      assertEquals(false, tw.usesRightHand("QWERT"));
      assertEquals(false, tw.usesRightHand("ASDFGVCXZ"));
      assertEquals(false, tw.usesRightHand("123456"));
      assertEquals(false, tw.usesRightHand("a"));

      assertEquals(true, tw.usesOnlyRightHand("yp"));
      assertEquals(true, tw.usesOnlyRightHand("YUIOPLKJHBNM"));
      assertEquals(true, tw.usesOnlyRightHand("7890yuioplkjhbnm"));
      assertEquals(true, tw.usesOnlyRightHand("monimolimnion"));

      assertEquals(false, tw.usesOnlyRightHand("ytp"));
      assertEquals(false, tw.usesOnlyRightHand("YUIOP6LKJHBNM"));
      assertEquals(false, tw.usesOnlyRightHand("7890yuio1plkjhbnm"));
      assertEquals(false, tw.usesOnlyRightHand("mconimolimnion"));
   }

   public void testTypewriter04()   //    all hand methods with spaces
   {
      testTypewriter01();
      testTypewriter02();
      testTypewriter03();

      TypeWriter tw = new TypeWriter();
      assertEquals(false, tw.usesBothLeftAndRightHand(""));

      assertEquals(true, tw.usesBothLeftAndRightHand("am"));
      assertEquals(true, tw.usesBothLeftAndRightHand("q w"));
      assertEquals(true, tw.usesBothLeftAndRightHand("joypopd"));
      assertEquals(true, tw.usesBothLeftAndRightHand("qkoplik"));
      assertEquals(true, tw.usesBothLeftAndRightHand("10"));
      assertEquals(true, tw.usesBothLeftAndRightHand("vb"));

      assertEquals(false, tw.usesBothLeftAndRightHand("desegreated"));
      assertEquals(false, tw.usesBothLeftAndRightHand("homonym"));

      assertEquals(true, tw.usesLeftHand("illinium "));
      assertEquals(false, tw.usesLeftHand("illinium"));

      assertEquals(true, tw.usesRightHand("gaz attes"));
      assertEquals(false, tw.usesRightHand("gazattes"));

      assertEquals(true, tw.usesOnlyLeftHand("desegreated"));
      assertEquals(true, tw.usesOnlyLeftHand("steadfast"));
      assertEquals(false, tw.usesOnlyLeftHand("desegreatedb"));
      assertEquals(false, tw.usesOnlyLeftHand("steadfastY"));

      assertEquals(true, tw.usesOnlyRightHand("homonym"));
      assertEquals(false, tw.usesOnlyRightHand("6hypopyon"));
      assertEquals(true, tw.usesOnlyRightHand("inky"));
      assertEquals(false, tw.usesOnlyRightHand(" 1"));
   }

   public void testTypewriter05()   //    usesTopRow   &&  usesOnlyTopRow
   {
      TypeWriter tw = new TypeWriter();
      for (int k = 0; k < topRow.length(); k++)
      {
         assertEquals(true, tw.usesTopRow(midRow+botRow+topRow.substring(k, k+1)));
      }
      for (int k = 0; k < midRow.length(); k++)
      {
         assertEquals(false, tw.usesTopRow(midRow.substring(k, k+1)));
      }

      for (int k = 0; k < botRow.length(); k++)
      {
         assertEquals(false, tw.usesTopRow(botRow.substring(k, k+1)));
      }

      assertEquals(false, tw.usesTopRow(" "));

//  add usesTopRowOnly
      for (int k = 0; k < topRow.length(); k++)
      {
         assertEquals(false, tw.usesOnlyTopRow(midRow+botRow+topRow.substring(k, k+1)));
         assertEquals(true, tw.usesOnlyTopRow(topRow.substring(k, k+1)));
         assertEquals(false, tw.usesOnlyTopRow(" "+topRow.substring(k, k+1)));
      }
      for (int k = 0; k < midRow.length(); k++)
      {
         assertEquals(false, tw.usesOnlyTopRow(topRow+midRow.substring(k, k+1)));
      }

      for (int k = 0; k < botRow.length(); k++)
      {
         assertEquals(false, tw.usesOnlyTopRow(midRow+topRow+botRow.substring(k, k+1)));
      }
   }

   public void testTypewriter06()   //    usesMiddleRow    &&   usesOnlyMiddleRow
   {
      TypeWriter tw = new TypeWriter();

      for (int k = 0; k < topRow.length(); k++)
      {
         assertEquals(false, tw.usesMiddleRow(topRow.substring(k, k+1)));
      }
      for (int k = 0; k < midRow.length(); k++)
      {
         assertEquals(true, tw.usesMiddleRow(topRow+midRow.substring(k, k+1)+botRow));
      }

      for (int k = 0; k < botRow.length(); k++)
      {
         assertEquals(false, tw.usesMiddleRow(botRow.substring(k, k+1)));
      }

      assertEquals(false, tw.usesTopRow(" "));

//  add usesMiddleRowOnly
      for (int k = 0; k < topRow.length(); k++)
      {
         assertEquals(false, tw.usesOnlyMiddleRow(topRow.substring(k, k+1)));
      }
      for (int k = 0; k < midRow.length(); k++)
      {
         assertEquals(true, tw.usesOnlyMiddleRow(midRow.substring(k, k+1)));
         assertEquals(false, tw.usesOnlyMiddleRow(topRow+botRow+midRow.substring(k, k+1)));
         assertEquals(false, tw.usesOnlyMiddleRow(" "+midRow.substring(k, k+1)));
      }

      for (int k = 0; k < botRow.length(); k++)
      {
         assertEquals(false, tw.usesOnlyMiddleRow(botRow.substring(k, k+1)));
      }
   }

   public void testTypewriter07()   //    usesBottomRow   &&   usesOnlyBottomRow
   {
      TypeWriter tw = new TypeWriter();

      for (int k = 0; k < topRow.length(); k++)
      {
         assertEquals(false, tw.usesBottomRow(topRow.substring(k, k+1)));
      }
      for (int k = 0; k < midRow.length(); k++)
      {
         assertEquals(false, tw.usesBottomRow(midRow.substring(k, k+1)));
      }

      for (int k = 0; k < botRow.length(); k++)
      {
         assertEquals(true, tw.usesBottomRow(botRow.substring(k, k+1)+topRow+midRow));
      }

      assertEquals(false, tw.usesTopRow(" "));

//  add usesBottomRowOnly
      for (int k = 0; k < topRow.length(); k++)
      {
         assertEquals(false, tw.usesOnlyBottomRow(topRow.substring(k, k+1)));
      }
      for (int k = 0; k < midRow.length(); k++)
      {
         assertEquals(false, tw.usesOnlyBottomRow(midRow.substring(k, k+1)));
      }

      for (int k = 0; k < botRow.length(); k++)
      {
         assertEquals(true, tw.usesOnlyBottomRow(botRow.substring(k, k+1)));
         assertEquals(false, tw.usesOnlyBottomRow(" "+botRow.substring(k, k+1)));
         assertEquals(false, tw.usesOnlyBottomRow(midRow+topRow+botRow.substring(k, k+1)));
      }
   }

   public void testTypewriter08()   //    all rows
   {
      testTypewriter05();
      testTypewriter06();
      testTypewriter07();

      TypeWriter tw = new TypeWriter();

      assertEquals(true, tw.usesOnlyTopRow(topRow));
      assertEquals(false, tw.usesOnlyTopRow(topRow+0));
      for(int k = 7; k < 9; k++)
         assertEquals(false, tw.usesOnlyTopRow(topRow+k));

      assertEquals(true, tw.usesOnlyMiddleRow(midRow));
      assertEquals(false, tw.usesOnlyMiddleRow("0"+midRow));
      for(int k = 7; k < 9; k++)
         assertEquals(false, tw.usesOnlyMiddleRow(midRow+k));

      assertEquals(true, tw.usesOnlyBottomRow(botRow));
      assertEquals(false, tw.usesOnlyBottomRow(" "+botRow));
      for(int k = 7; k < 9; k++)
         assertEquals(false, tw.usesOnlyBottomRow(botRow+k));
   }

   public void testTypewriter09()   //    all test
   {
      testTypewriter01();
      testTypewriter02();
      testTypewriter03();
      testTypewriter04();
      testTypewriter05();
      testTypewriter06();
      testTypewriter07();
      testTypewriter08();

      TypeWriter tw = new TypeWriter();

      assertEquals(false, tw.usesTopRow(midRow + "1234567890" + botRow));
      for (int g= 0; g < topRow.length(); g++)
         assertEquals(true, tw.usesTopRow(midRow + "1234567890" + topRow.substring(g, g+1) + botRow));

      assertEquals(false, tw.usesMiddleRow(topRow +"1234567890" + botRow));
      for (int g= 0; g < midRow.length(); g++)
         assertEquals(true, tw.usesBottomRow(topRow +"1234567890" + midRow.substring(g, g+1) + botRow));

      assertEquals(false, tw.usesBottomRow(topRow +"1234567890" + midRow));
      for (int g= 0; g < botRow.length(); g++)
         assertEquals(true, tw.usesBottomRow(topRow +"1234567890" + botRow.substring(g, g+1) + midRow));

      assertEquals(true, tw.usesBothLeftAndRightHand("gh"));
      assertEquals(true, tw.usesBothLeftAndRightHand("qp"));
      assertEquals(true, tw.usesBothLeftAndRightHand("z12345789m0"));

      assertEquals(false, tw.usesBothLeftAndRightHand("1234desegreated"));
      assertEquals(false, tw.usesBothLeftAndRightHand("homony78m"));
      assertEquals(false, tw.usesBothLeftAndRightHand("homonym90"));

      assertEquals(true, tw.usesLeftHand(" "));
      assertEquals(false, tw.usesLeftHand("yuiophjlbnm"));

      assertEquals(true, tw.usesRightHand("qwerty12345l"));
      assertEquals(false, tw.usesRightHand("qwert12345"));

      assertEquals(true, tw.usesOnlyLeftHand(" "));
      assertEquals(true, tw.usesOnlyLeftHand("gtv"));
      assertEquals(false, tw.usesOnlyLeftHand("asdf p"));
      assertEquals(false, tw.usesOnlyLeftHand(" 0"));

      assertEquals(true, tw.usesOnlyRightHand("b"));
      assertEquals(false, tw.usesOnlyRightHand("lkjhyuiopmn 1"));
      assertEquals(true, tw.usesOnlyRightHand(" "));
   }

   public void testTypewriter10()   //    all test
   {
      testTypewriter09();

      TypeWriter tw = new TypeWriter();

      assertEquals(false, tw.usesTopRow("1"));
      assertEquals(true, tw.usesTopRow("Q"));

      assertEquals(false, tw.usesMiddleRow("2"));
      assertEquals(true, tw.usesMiddleRow("L"));

      assertEquals(false, tw.usesBottomRow("3"));
      assertEquals(true, tw.usesBottomRow("Z"));

      assertEquals(true, tw.usesBothLeftAndRightHand("WP"));
      assertEquals(true, tw.usesBothLeftAndRightHand("10"));
      assertEquals(true, tw.usesBothLeftAndRightHand("ZM"));

      assertEquals(false, tw.usesBothLeftAndRightHand("123456"));
      assertEquals(false, tw.usesBothLeftAndRightHand("7890"));
      assertEquals(false, tw.usesBothLeftAndRightHand("asdfgzxcvqwert123456"));

      assertEquals(true, tw.usesLeftHand("1"));
      assertEquals(false, tw.usesLeftHand("7890"));

      assertEquals(true, tw.usesRightHand("0"));
      assertEquals(false, tw.usesRightHand("123456"));

      assertEquals(true, tw.usesOnlyLeftHand("123456"));
      assertEquals(true, tw.usesOnlyLeftHand("gG"));
      assertEquals(false, tw.usesOnlyLeftHand("B"));
      assertEquals(false, tw.usesOnlyLeftHand(" Y"));

      assertEquals(true, tw.usesOnlyRightHand("7890"));
      assertEquals(false, tw.usesOnlyRightHand("l1"));
      assertEquals(true, tw.usesOnlyRightHand(" yuiop"));
   }

/*
 *     Rock Paper Scissor Spock Lizzard testers
 */
   public void testRPSSL01()
   {
      RPSSL game = new RPSSL();
      assertEquals("TIE", game.playRound(new Player("Sheldon", "rock"), new Player("Bernadette", "rock")));
      assertEquals("Sheldon", game.playRound(new Player("Sheldon", "paper"), new Player("Howard", "rock")));
      assertEquals("Penny", game.playRound(new Player("Raj", "spock"), new Player("Penny", "paper")));
      assertEquals("Leonard", game.playRound(new Player("Amy", "lizard"), new Player("Leonard", "scissors")));
   }

   public void testRPSSL02()   // player a chooses rock
   {
      RPSSL game = new RPSSL();
      assertEquals("TIE", game.playRound(new Player("a", "rock"), new Player("b", "rock")));
      assertEquals("b", game.playRound(new Player("a", "rock"), new Player("b", "paper")));
      assertEquals("a", game.playRound(new Player("a", "rock"), new Player("b", "scissors")));
      assertEquals("b", game.playRound(new Player("a", "rock"), new Player("b", "spock")));
      assertEquals("a", game.playRound(new Player("a", "rock"), new Player("b", "lizard")));
   }

   public void testRPSSL03()   // player a chooses paper
   {
      RPSSL game = new RPSSL();
      assertEquals("a", game.playRound(new Player("a", "paper"), new Player("b", "rock")));
      assertEquals("TIE", game.playRound(new Player("a", "paper"), new Player("b", "paper")));
      assertEquals("b", game.playRound(new Player("a", "paper"), new Player("b", "scissors")));
      assertEquals("a", game.playRound(new Player("a", "paper"), new Player("b", "spock")));
      assertEquals("b", game.playRound(new Player("a", "paper"), new Player("b", "lizard")));
   }

   public void testRPSSL04()   // player a chooses scissors
   {
      RPSSL game = new RPSSL();
      assertEquals("b", game.playRound(new Player("a", "scissors"), new Player("b", "rock")));
      assertEquals("a", game.playRound(new Player("a", "scissors"), new Player("b", "paper")));
      assertEquals("TIE", game.playRound(new Player("a", "scissors"), new Player("b", "scissors")));
      assertEquals("b", game.playRound(new Player("a", "scissors"), new Player("b", "spock")));
      assertEquals("a", game.playRound(new Player("a", "scissors"), new Player("b", "lizard")));
   }

   public void testRPSSL05()   // player a chooses spock
   {
      RPSSL game = new RPSSL();
      assertEquals("a", game.playRound(new Player("a", "spock"), new Player("b", "rock")));
      assertEquals("b", game.playRound(new Player("a", "spock"), new Player("b", "paper")));
      assertEquals("a", game.playRound(new Player("a", "spock"), new Player("b", "scissors")));
      assertEquals("TIE", game.playRound(new Player("a", "spock"), new Player("b", "spock")));
      assertEquals("b", game.playRound(new Player("a", "spock"), new Player("b", "lizard")));
   }

   public void testRPSSL06()   // player a chooses lizard
   {
      RPSSL game = new RPSSL();
      assertEquals("b", game.playRound(new Player("a", "lizard"), new Player("b", "rock")));
      assertEquals("a", game.playRound(new Player("a", "lizard"), new Player("b", "paper")));
      assertEquals("b", game.playRound(new Player("a", "lizard"), new Player("b", "scissors")));
      assertEquals("a", game.playRound(new Player("a", "lizard"), new Player("b", "spock")));
      assertEquals("TIE", game.playRound(new Player("a", "lizard"), new Player("b", "lizard")));
   }

   public void testRPSSL07()   // player a chooses lizard
   {
       testRPSSL01();
       testRPSSL02();
       testRPSSL03();
       testRPSSL04();
}

   public void testRPSSL08()   // player a chooses lizard
   {
       testRPSSL01();
       testRPSSL02();
       testRPSSL03();
       testRPSSL04();

       testRPSSL05();
   }

   public void testRPSSL09()   // player a chooses lizard
   {
       testRPSSL01();
       testRPSSL02();
       testRPSSL03();
       testRPSSL04();

       testRPSSL06();
   }

   public void testRPSSL10()   // player a chooses lizard
   {
       testRPSSL01();
       testRPSSL02();
       testRPSSL03();
       testRPSSL04();

       testRPSSL05();
       testRPSSL06();
   }

/*
 *     Line Interval Density Testers
 */
   public void testLineIntervalDensity01()
   {
      Interval[] itv1 = {new Interval(1, 4), new Interval(4, 8)};
      LineIntervalDensity lid1 = new LineIntervalDensity(itv1);
      assertEquals(1, lid1.lowerLimit(), 0.005);
      assertEquals(8, lid1.upperLimit(), 0.005);
      assertEquals(0, lid1.density(0));
      assertEquals(1, lid1.density(3.7));
      assertEquals(1, lid1.maxDensity());

      Interval[] itv2 = {new Interval(0, 3), new Interval(-4, 5), new Interval(5, 10), new Interval(-1, 7)};
      LineIntervalDensity lid2 = new LineIntervalDensity(itv2);
      assertEquals(-4, lid2.lowerLimit(), 0.005);
      assertEquals(10, lid2.upperLimit(), 0.005);
      assertEquals(2, lid2.density(-1));
      assertEquals(1, lid2.density(7.7));
      assertEquals(3, lid2.maxDensity());
   }

   public void testLineIntervalDensity02()
   {
      Interval[] itv = {new Interval(6, 8), new Interval(3, 7), new Interval(1, 5), new Interval(2, 4)};
      LineIntervalDensity lid = new LineIntervalDensity(itv);
      assertEquals(1, lid.lowerLimit(), 0.005);
      assertEquals(8, lid.upperLimit(), 0.005);
      assertEquals(0, lid.density(0));
      assertEquals(1, lid.density(1.7));
      assertEquals(3, lid.maxDensity());
   }

   public void testLineIntervalDensity03()
   {
      Interval[] itv = {new Interval(1, 10), new Interval(2, 11), new Interval(3, 12), new Interval(4, 10),
                         new Interval(5, 9), new Interval(6, 8), new Interval(7, 11), new Interval(8, 12),
                        new Interval(9, 10), new Interval(10, 13),};
      LineIntervalDensity lid = new LineIntervalDensity(itv);
      assertEquals(1, lid.lowerLimit(), 0.005);
      assertEquals(13, lid.upperLimit(), 0.005);
      assertEquals(0, lid.density(0));
      assertEquals(1, lid.density(1.7));
      assertEquals(7, lid.maxDensity());
   }

   public void testLineIntervalDensity04()
   {
      Interval[] itv = {new Interval(-10, -8), new Interval(-7, -4), new Interval(-2, 0), new Interval(1, 5)};
 
      LineIntervalDensity lid = new LineIntervalDensity(itv);
      assertEquals(-10, lid.lowerLimit(), 0.005);
      assertEquals(5, lid.upperLimit(), 0.005);
      assertEquals(0, lid.density(0));
      assertEquals(1, lid.density(1.7));
      assertEquals(1, lid.maxDensity());

      Interval[] itv1 = {new Interval(-10, -8), new Interval(-7, -4), new Interval(-2, 0), new Interval(1, 5),
                            new Interval(0, 1)};
 
      lid = new LineIntervalDensity(itv1);
      assertEquals(-10, lid.lowerLimit(), 0.005);
      assertEquals(5, lid.upperLimit(), 0.005);
      assertEquals(1, lid.density(0));
      assertEquals(1, lid.density(1.7));
      assertEquals(1, lid.maxDensity());

      Interval[] itv2 = {new Interval(-10, -8), new Interval(-7, -4), new Interval(-2, 0), new Interval(1, 5),
                            new Interval(0, 1), new Interval(8, -7), new Interval(-4, -2), new Interval(5, 11)};
 
      lid = new LineIntervalDensity(itv2);
      assertEquals(-10, lid.lowerLimit(), 0.005);
      assertEquals(11, lid.upperLimit(), 0.005);
      assertEquals(1, lid.density(0));
      assertEquals(1, lid.density(1.7));
      assertEquals(1, lid.maxDensity());
    }

   public void testLineIntervalDensity05()
   {
      Interval[] itv = {new Interval(-10, 10), new Interval(-7, 7), new Interval(-15, 15), new Interval(-6, 6)};
 
      LineIntervalDensity lid = new LineIntervalDensity(itv);
      assertEquals(-15, lid.lowerLimit(), 0.005);
      assertEquals(15, lid.upperLimit(), 0.005);
      assertEquals(4, lid.density(0));
      assertEquals(3, lid.density(6.5));
      assertEquals(2, lid.density(7.7));
      assertEquals(1, lid.density(-11.7));
      assertEquals(0, lid.density(-17.7));
      assertEquals(4, lid.maxDensity());

      Interval[] itv1 = {new Interval(-10, 10), new Interval(-7, 7)};
 
      lid = new LineIntervalDensity(itv1);
      assertEquals(-10, lid.lowerLimit(), 0.005);
      assertEquals(10, lid.upperLimit(), 0.005);
      assertEquals(2, lid.density(0));
      assertEquals(1, lid.density(7.7));
      assertEquals(1, lid.density(-7.7));
      assertEquals(0, lid.density(17.7));
      assertEquals(2, lid.maxDensity());

      Interval[] itv2 = {new Interval(-10, 10), new Interval(-7, 7), new Interval(-15, 15), new Interval(-6, 6),
                          new Interval(-4, 4), new Interval(-17, 19), new Interval(-12, 12), new Interval(-1, 1)};
 
      lid = new LineIntervalDensity(itv2);
      assertEquals(-17, lid.lowerLimit(), 0.005);
      assertEquals(19, lid.upperLimit(), 0.005);
      assertEquals(8, lid.density(0.5));
      assertEquals(7, lid.density(1.5));
      assertEquals(6, lid.density(-5));
      assertEquals(5, lid.density(6.5));
      assertEquals(4, lid.density(-7.5));
      assertEquals(3, lid.density(-11.7));
      assertEquals(2, lid.density(14.7));
      assertEquals(1, lid.density(15.01));
      assertEquals(0, lid.density(-17.01));
      assertEquals(8, lid.maxDensity());
   }

   public void testLineIntervalDensity06()
   {
      Interval[] itv = {new Interval(-1000, -510), new Interval(-333, -227), new Interval(-115, -15), new Interval(200, 6998),
                              new Interval(-1111, -200), new Interval(-133, 50), new Interval(-444, 111), new Interval(-750, 7777)};
 
      LineIntervalDensity lid = new LineIntervalDensity(itv);
      assertEquals(-1111, lid.lowerLimit(), 0.005);
      assertEquals(7777, lid.upperLimit(), 0.005);
      assertEquals(0, lid.density(-1111.5));
      assertEquals(0, lid.density(7779));

      assertEquals(1, lid.density(-1005));
      assertEquals(1, lid.density(7705));
      assertEquals(1, lid.density(155));

      assertEquals(2, lid.density(-888));
      assertEquals(2, lid.density(-155));
      assertEquals(2, lid.density(-445));
      assertEquals(2, lid.density(100));
      assertEquals(2, lid.density(200.01));

      assertEquals(3, lid.density(-557.7));
      assertEquals(3, lid.density(-400));
      assertEquals(3, lid.density(-201.7));
      assertEquals(3, lid.density(-125));
      assertEquals(3, lid.density(0));

      assertEquals(4, lid.density(-300));
      assertEquals(4, lid.density(-55));
      assertEquals(4, lid.maxDensity());

      Interval[] itv1 = {new Interval(-9, 7), new Interval(-7, 7), new Interval(-5, 7), new Interval(-3, 7), new Interval(0, 7), new Interval(6, 7)};
 
      lid = new LineIntervalDensity(itv1);
      assertEquals(-9, lid.lowerLimit(), 0.005);
      assertEquals(7, lid.upperLimit(), 0.005);
      assertEquals(0, lid.density(-10));
      assertEquals(1, lid.density(-7.7));
      assertEquals(2, lid.density(-5.7));
      assertEquals(3, lid.density(-3.177));
      assertEquals(4, lid.density(-0.177));
      assertEquals(5, lid.density(3.177));
      assertEquals(6, lid.density(6.177));

      assertEquals(6, lid.maxDensity());
   }

   public void testLineIntervalDensity07()
   {
      Interval[] itv = {new Interval(-1000, -510), new Interval(-333, -227), new Interval(-115, -15), new Interval(200, 6998),
                              new Interval(-1111, -200), new Interval(-133, 50), new Interval(-444, 111), new Interval(-750, 7777)};
 
      LineIntervalDensity lid = new LineIntervalDensity(itv);
      assertEquals(-1111, lid.lowerLimit(), 0.005);
      assertEquals(7777, lid.upperLimit(), 0.005);
      assertEquals(0, lid.density(-1111.5));
      assertEquals(0, lid.density(7779));

      assertEquals(1, lid.density(-1005));
      assertEquals(1, lid.density(7705));
      assertEquals(1, lid.density(155));

      Interval[] itv2 = {new Interval(-10, 10), new Interval(-7, 7), new Interval(-15, 15), new Interval(-6, 6),
                          new Interval(-4, 4), new Interval(-17, 19), new Interval(-12, 12), new Interval(-1, 1)};
 
      lid = new LineIntervalDensity(itv2);
      assertEquals(-17, lid.lowerLimit(), 0.005);
      assertEquals(19, lid.upperLimit(), 0.005);
      assertEquals(8, lid.density(0.5));
      assertEquals(7, lid.density(1.5));
      assertEquals(6, lid.density(-5));
      assertEquals(5, lid.density(6.5));
      assertEquals(4, lid.density(-7.5));
      assertEquals(3, lid.density(-11.7));
      assertEquals(2, lid.density(14.7));
      assertEquals(1, lid.density(15.01));
      assertEquals(0, lid.density(-17.01));
      assertEquals(8, lid.maxDensity());
   }

   public void testLineIntervalDensity08()
   {
      Interval[] itv = {new Interval(-1000, -510), new Interval(-333, -227), new Interval(-115, -15), new Interval(200, 6998),
                              new Interval(-1111, -200), new Interval(-133, 50), new Interval(-444, 111), new Interval(-750, 7777)};
 
      LineIntervalDensity lid = new LineIntervalDensity(itv);
      assertEquals(-1111, lid.lowerLimit(), 0.005);
      assertEquals(7777, lid.upperLimit(), 0.005);

      Interval[] itv1 = {new Interval(-1000, -510), new Interval(-8333, -227), new Interval(-115, -15), new Interval(200, 698),
                              new Interval(-1111, -200), new Interval(-133, 50), new Interval(-444, 1101), new Interval(-750, 127)};
 
      lid = new LineIntervalDensity(itv1);
      assertEquals(-8333, lid.lowerLimit(), 0.005);
      assertEquals(1101, lid.upperLimit(), 0.005);

      Interval[] itv2 = {new Interval(-1200, -510), new Interval(-115, -15), new Interval(200, 698),
                              new Interval(-1111, 821), new Interval(-133, -50), new Interval(-444, -1)};
 
      lid = new LineIntervalDensity(itv2);
      assertEquals(-1200, lid.lowerLimit(), 0.005);
      assertEquals(821, lid.upperLimit(), 0.005);
   }

   public void testLineIntervalDensity09()
   {
      testLineIntervalDensity08();
      testLineIntervalDensity07();
   }

   public void testLineIntervalDensity10()
   {
      testLineIntervalDensity01();
      testLineIntervalDensity02();
      testLineIntervalDensity03();
      testLineIntervalDensity04();
      testLineIntervalDensity05();
      testLineIntervalDensity06();
      testLineIntervalDensity09();
   }
/*
 *   Triangular Number Tester
 */
    public void testTwoTriangularNumbers01()
   {
      TwoTriangularNumbers tn = new TwoTriangularNumbers();
      assertEquals(true, tn.isTriangularNumber(1+2+3+4+5));
      assertEquals(false, tn.isTriangularNumber(1+2+3+4+5+5));
      assertEquals(2, tn.getTwoTriangularNumbers(63003).size());
      assertEquals(true,  tn.getTwoTriangularNumbers(63003).get(0).equals(new OrderedPair(3, 77))
                          || tn.getTwoTriangularNumbers(63003).get(0).equals(new OrderedPair(2, 35)));
      assertEquals(true,  tn.getTwoTriangularNumbers(63003).get(1).equals(new OrderedPair(3, 77))
                          || tn.getTwoTriangularNumbers(63003).get(1).equals(new OrderedPair(2, 35)));
      assertEquals(0, tn.getTwoTriangularNumbers(12).size());
   }

   public void testTwoTriangularNumbers02()    //     isTriangularNumber  only
   {
      TwoTriangularNumbers tn = new TwoTriangularNumbers();
      assertEquals(true, tn.isTriangularNumber(5050));
      assertEquals(true, tn.isTriangularNumber(2211));

      assertEquals(false, tn.isTriangularNumber(7));
      assertEquals(false, tn.isTriangularNumber(8));
      assertEquals(false, tn.isTriangularNumber(9));

      assertEquals(true, tn.isTriangularNumber(55278));   //  333
      assertEquals(false, tn.isTriangularNumber(56));
      assertEquals(false, tn.isTriangularNumber(57));
      assertEquals(false, tn.isTriangularNumber(58));
      assertEquals(false, tn.isTriangularNumber(59));
      assertEquals(false, tn.isTriangularNumber(60));
      assertEquals(false, tn.isTriangularNumber(61));
      assertEquals(false, tn.isTriangularNumber(63));
      assertEquals(false, tn.isTriangularNumber(65));
      assertEquals(true, tn.isTriangularNumber(21736));     //   209
      assertEquals(true, tn.isTriangularNumber(15400));     //   176
    }

   public void testTwoTriangularNumbers03()    //     isTriangularNumber  only
   {
      TwoTriangularNumbers tn = new TwoTriangularNumbers();
      assertEquals(true, tn.isTriangularNumber(946));
      assertEquals(true, tn.isTriangularNumber(31125));

      assertEquals(false, tn.isTriangularNumber(5050+2));
      assertEquals(false, tn.isTriangularNumber(2211+6));

      assertEquals(true, tn.isTriangularNumber(1176));
      assertEquals(false, tn.isTriangularNumber(2850+6));
    }

   public void testTwoTriangularNumbers04()    //     getTwoTriangularNumbers - exactly one solutions only
   {
      TwoTriangularNumbers tn = new TwoTriangularNumbers();
      assertEquals(new OrderedPair(21, 41), tn.getTwoTriangularNumbers(861231).get(0));       
      assertEquals(new OrderedPair(85, 112), tn.getTwoTriangularNumbers(36556328).get(0));
      assertEquals(new OrderedPair(30, 99), tn.getTwoTriangularNumbers(4654950).get(0));

      assertEquals(new OrderedPair(2, 122), tn.getTwoTriangularNumbers(37503).get(0));          //  122 = 7503
      assertEquals(new OrderedPair(2, 122), tn.getTwoTriangularNumbers(75033).get(0));          //  122 = 7503
      assertEquals(new OrderedPair(6, 212), tn.getTwoTriangularNumbers(2257821).get(0));        //  212 = 22578    6 = 21
      assertEquals(new OrderedPair(6, 212), tn.getTwoTriangularNumbers(2122578).get(0));        //  212 = 22578    6 = 21
      assertEquals(new OrderedPair(186, 186), tn.getTwoTriangularNumbers(1739117391).get(0));   //  186 = 17391

      assertEquals(1, tn.getTwoTriangularNumbers(861231).size());       
      assertEquals(1, tn.getTwoTriangularNumbers(36556328).size());
      assertEquals(1, tn.getTwoTriangularNumbers(4654950).size());

      assertEquals(1, tn.getTwoTriangularNumbers(37503).size());          //  122 = 7503
      assertEquals(1, tn.getTwoTriangularNumbers(75033).size());          //  122 = 7503
      assertEquals(1, tn.getTwoTriangularNumbers(2257821).size());        //  212 = 22578    6 = 21
      assertEquals(1, tn.getTwoTriangularNumbers(2122578).size());        //  212 = 22578    6 = 21
      assertEquals(1, tn.getTwoTriangularNumbers(1739117391).size());     //  186 = 17391
    }

   public void testTwoTriangularNumbers05()    //     getTwoTriangularNumbers - exactly one solutions only
   {
      TwoTriangularNumbers tn = new TwoTriangularNumbers();

      assertEquals(1, tn.getTwoTriangularNumbers(12720595).size());       //  159 = 12720    34 = 595
      assertEquals(1, tn.getTwoTriangularNumbers(59512720).size());       //  
      assertEquals(1, tn.getTwoTriangularNumbers(177663916).size());     //  188 = 17766    88 = 3916
      assertEquals(1, tn.getTwoTriangularNumbers(391617766).size());     //  
      assertEquals(1, tn.getTwoTriangularNumbers(49504950).size());       //  99 = 4950

      assertEquals(new OrderedPair(34, 159), tn.getTwoTriangularNumbers(12720595).get(0));       //  159 = 12720    34 = 595
      assertEquals(new OrderedPair(34, 159), tn.getTwoTriangularNumbers(59512720).get(0));       //  
      assertEquals(new OrderedPair(88, 188), tn.getTwoTriangularNumbers(177663916).get(0));     //  188 = 17766    88 = 3916
      assertEquals(new OrderedPair(88, 188), tn.getTwoTriangularNumbers(391617766).get(0));     //  
      assertEquals(new OrderedPair(99, 99), tn.getTwoTriangularNumbers(49504950).get(0));       //  99 = 4950
   }

   public void testTwoTriangularNumbers06()    //     getTwoTriangularNumbers - zero/one/multiple solutions only
   {
      TwoTriangularNumbers tn = new TwoTriangularNumbers();

      assertEquals(0, tn.getTwoTriangularNumbers(111).size());                //  
      assertEquals(1, tn.getTwoTriangularNumbers(11).size());                 //  1 = 1
      assertEquals(new OrderedPair(1, 1), tn.getTwoTriangularNumbers(11).get(0));    //  1 = 1

      assertEquals(1, tn.getTwoTriangularNumbers(1257511).size());        //  501 = 125751
      assertEquals(2, tn.getTwoTriangularNumbers(1125751).size());        //  501 = 125751
      assertEquals(true, tn.getTwoTriangularNumbers(1125751).get(0).equals(new OrderedPair(1, 501))
                         || tn.getTwoTriangularNumbers(1125751).get(1).equals(new OrderedPair(1, 501)));
      assertEquals(true, tn.getTwoTriangularNumbers(1125751).get(0).equals(new OrderedPair(1, 474))
                         || tn.getTwoTriangularNumbers(1125751).get(1).equals(new OrderedPair(1, 474)));

      assertEquals(1, tn.getTwoTriangularNumbers(11785510).size());       //  485 = 117855   4 = 10
      assertEquals(new OrderedPair(4, 485), tn.getTwoTriangularNumbers(11785510).get(0));     //  485 = 117855   4 = 10

      assertEquals(1, tn.getTwoTriangularNumbers(6303003).size());    //  35 = 630   77 = 3003
      assertEquals(2, tn.getTwoTriangularNumbers(63003).size());      //  2 = 3 3 = 6 35 = 630   77 = 3003
    }

   public void testTwoTriangularNumbers07()    //     getTwoTriangularNumbers - zero/one/multiple solutions only
   {
      TwoTriangularNumbers tn = new TwoTriangularNumbers();

      assertEquals(2, tn.getTwoTriangularNumbers(10117855).size());                //  

      assertEquals(0, tn.getTwoTriangularNumbers(3795).size());                //  
      assertEquals(1, tn.getTwoTriangularNumbers(36).size());                 //  1 = 1
      assertEquals(new OrderedPair(2, 3), tn.getTwoTriangularNumbers(36).get(0));    //  1 = 1

      assertEquals(1, tn.getTwoTriangularNumbers(12720595).size());        //  159 = 12720    34 = 595
      assertEquals(1, tn.getTwoTriangularNumbers(59512720).size());        //
      assertEquals(2, tn.getTwoTriangularNumbers(3003).size());                //  
      assertEquals(true, tn.getTwoTriangularNumbers(3003).get(0).equals(new OrderedPair(2, 2))
                         || tn.getTwoTriangularNumbers(3003).get(1).equals(new OrderedPair(2, 2)));
      assertEquals(true, tn.getTwoTriangularNumbers(3003).get(0).equals(new OrderedPair(2, 24))
                         || tn.getTwoTriangularNumbers(3003).get(1).equals(new OrderedPair(2, 24)));

      assertEquals(new OrderedPair(88, 188), tn.getTwoTriangularNumbers(177663916).get(0));     //  188 = 17766    88 = 3916
      assertEquals(new OrderedPair(88, 188), tn.getTwoTriangularNumbers(391617766).get(0));     //  

      assertEquals(new OrderedPair(99, 99), tn.getTwoTriangularNumbers(49504950).get(0));       //  99 = 4950

      assertEquals(3, tn.getTwoTriangularNumbers(10528).size());                //  
      assertEquals(true, tn.getTwoTriangularNumbers(10528).get(0).equals(new OrderedPair(7, 14))
                         || tn.getTwoTriangularNumbers(10528).get(1).equals(new OrderedPair(7, 14))
                         || tn.getTwoTriangularNumbers(10528).get(2).equals(new OrderedPair(7, 14)));
      assertEquals(true, tn.getTwoTriangularNumbers(10528).get(0).equals(new OrderedPair(4, 32))
                         || tn.getTwoTriangularNumbers(10528).get(1).equals(new OrderedPair(4, 32))
                         || tn.getTwoTriangularNumbers(10528).get(2).equals(new OrderedPair(4, 32)));
      assertEquals(true, tn.getTwoTriangularNumbers(10528).get(0).equals(new OrderedPair(1, 32))
                         || tn.getTwoTriangularNumbers(10528).get(1).equals(new OrderedPair(1, 32))
                         || tn.getTwoTriangularNumbers(10528).get(2).equals(new OrderedPair(1, 32)));

      assertEquals(3, tn.getTwoTriangularNumbers(10011325).size());                //  
      assertEquals(true, tn.getTwoTriangularNumbers(10011325).get(0).equals(new OrderedPair(1, 150))
                         || tn.getTwoTriangularNumbers(10011325).get(1).equals(new OrderedPair(1, 150))
                         || tn.getTwoTriangularNumbers(10011325).get(2).equals(new OrderedPair(1, 150)));
      assertEquals(true, tn.getTwoTriangularNumbers(10011325).get(0).equals(new OrderedPair(4, 150))
                         || tn.getTwoTriangularNumbers(10011325).get(1).equals(new OrderedPair(4, 150))
                         || tn.getTwoTriangularNumbers(10011325).get(2).equals(new OrderedPair(4, 150)));
      assertEquals(true, tn.getTwoTriangularNumbers(10011325).get(0).equals(new OrderedPair(25, 141))
                         || tn.getTwoTriangularNumbers(10011325).get(1).equals(new OrderedPair(25, 141))
                         || tn.getTwoTriangularNumbers(10011325).get(2).equals(new OrderedPair(25, 141)));
    }

   public void testTwoTriangularNumbers08()        //     isTriangularNumber  only
   {                                               //     getTwoTriangularNumbers - exactly one solutions only
       testTwoTriangularNumbers01();
       testTwoTriangularNumbers02();
       testTwoTriangularNumbers03();
       testTwoTriangularNumbers04();
       testTwoTriangularNumbers05();
   }

   public void testTwoTriangularNumbers09()        //     isTriangularNumber  only
   {
       testTwoTriangularNumbers08();
       testTwoTriangularNumbers06();
   }

   public void testTwoTriangularNumbers10()        //     isTriangularNumber  only
   {
       testTwoTriangularNumbers09();
       testTwoTriangularNumbers07();
   }

/*
 *     Mining Center Testers
 */
   public void testMiningCenter01()
   {
      ArrayList<Site> mines1 = new ArrayList<Site>();
      mines1.add(new Site(0, 0));
      mines1.add(new Site(0, 5));
      mines1.add(new Site(5, 0));
      MiningCenter mc1 = new MiningCenter(mines1);
      assertEquals(new Site(0,0), mc1.getCenter());

      ArrayList<Site> mines2 = new ArrayList<Site>();
      mines2.add(new Site(1, -5));
      mines2.add(new Site(-10, 5));
      mines2.add(new Site(-2, 5));
      mines2.add(new Site(10, 10));
      mines2.add(new Site(5, -5));
      MiningCenter mc2 = new MiningCenter(mines2);
      assertEquals(new Site(2,5), mc2.getCenter());
   }

   public void testMiningCenter02()
   {
      ArrayList<Site> mines = new ArrayList<Site>();
      mines.add(new Site(0, 0));
      mines.add(new Site(1, 0));
      mines.add(new Site(4, 0));
      mines.add(new Site(3, 0));
      mines.add(new Site(2, 0));
      MiningCenter ans = new MiningCenter(mines);
      assertEquals(new Site(2,0), ans.getCenter());

      mines = new ArrayList<Site>();
      mines.add(new Site(0, 0));
      mines.add(new Site(0, 1));
      mines.add(new Site(0, 4));
      mines.add(new Site(0, 3));
      mines.add(new Site(0, 2));
      ans = new MiningCenter(mines);
      assertEquals(new Site(0, 2), ans.getCenter());
    }

   public void testMiningCenter03()
   {
      ArrayList<Site> mines = new ArrayList<Site>();
      mines.add(new Site(-1, 0));
      mines.add(new Site(2, 0));
      mines.add(new Site(4, 0));
      MiningCenter ans = new MiningCenter(mines);
      assertEquals(new Site(1, 0), ans.getCenter());
      mines.add(new Site(10, 0));
      ans = new MiningCenter(mines);
      assertEquals(new Site(4, 0), ans.getCenter());

      mines = new ArrayList<Site>();
      mines.add(new Site(-10, 0));
      mines.add(new Site(20, 0));
      mines.add(new Site(40, 0));
      ans = new MiningCenter(mines);
      assertEquals(new Site(15, 0), ans.getCenter());
      mines.add(new Site(100, 0));
      ans = new MiningCenter(mines);
      assertEquals(new Site(45, 0), ans.getCenter());

      mines = new ArrayList<Site>();
      mines.add(new Site(0, -1));
      mines.add(new Site(0, 2));
      mines.add(new Site(0, 4));
      ans = new MiningCenter(mines);
      assertEquals(new Site(0, 1), ans.getCenter());
      mines.add(new Site(0, 10));
      ans = new MiningCenter(mines);
      assertEquals(new Site(0, 4), ans.getCenter());

      mines = new ArrayList<Site>();
      mines.add(new Site(0, -10));
      mines.add(new Site(0, 20));
      mines.add(new Site(0, 40));
      ans = new MiningCenter(mines);
      assertEquals(new Site(0, 15), ans.getCenter());
      mines.add(new Site(0, 100));
      ans = new MiningCenter(mines);
      assertEquals(new Site(0, 45), ans.getCenter());
    }

   public void testMiningCenter04()
   {
      ArrayList<Site> mines = new ArrayList<Site>();
      mines.add(new Site(2, 3));
      mines.add(new Site(16, 3));
      mines.add(new Site(16, 23));
      mines.add(new Site(2, 23));
      MiningCenter ans = new MiningCenter(mines);
      assertEquals(new Site(9, 13), ans.getCenter());

      mines = new ArrayList<Site>();
      mines.add(new Site(5, 7));
      mines.add(new Site(12, 12));
      mines.add(new Site(5, 17));
      mines.add(new Site(0, 10));
      ans = new MiningCenter(mines);
      assertEquals(new Site(5, 12), ans.getCenter());

      mines = new ArrayList<Site>();
      mines.add(new Site(5, 7));
      mines.add(new Site(5, -7));
      mines.add(new Site(-5, 7));
      mines.add(new Site(-5, -7));
      ans = new MiningCenter(mines);
      assertEquals(new Site(0, 0), ans.getCenter());
   }

   public void testMiningCenter05()
   {
      ArrayList<Site> mines = new ArrayList<Site>();
      mines.add(new Site(5, 0));
      mines.add(new Site(-2, 3));
      mines.add(new Site(-4, 1));
      mines.add(new Site(0, -5));
      mines.add(new Site(3,-2));
      MiningCenter ans = new MiningCenter(mines);
      assertEquals(new Site(0, 0), ans.getCenter());
      mines.add(new Site(0,5));
      ans = new MiningCenter(mines);
      assertEquals(new Site(0, 0), ans.getCenter());

      mines = new ArrayList<Site>();
      mines.add(new Site(12, 0+11));
      mines.add(new Site(5, 3+11));
      mines.add(new Site(3, 1+11));
      mines.add(new Site(7, -5+11));
      mines.add(new Site(10, -2+11));
      ans = new MiningCenter(mines);
      assertEquals(new Site(7, 0+11), ans.getCenter());
      mines.add(new Site(0+7,5+11));
      ans = new MiningCenter(mines);
      assertEquals(new Site(0+7, 0+11), ans.getCenter());
   }

   public void testMiningCenter06()   /* double check this test   */
   {
      ArrayList<Site> mines = new ArrayList<Site>();
      mines.add(new Site(245, 692));
      mines.add(new Site(-772, -647));
      mines.add(new Site(330, 526));
      MiningCenter ans = new MiningCenter(mines);
      assertEquals(new Site(0, -241), ans.getCenter());

      mines = new ArrayList<Site>();
      mines.add(new Site(45, 69));
      mines.add(new Site(-5, 51));
      mines.add(new Site(23, 32));
      ans = new MiningCenter(mines);
      assertEquals(new Site(19, 61), ans.getCenter());
   }

   public void testMiningCenter07()
   {
      int dx = 0;
      int dy = 0;
      ArrayList<Site> mines = new ArrayList<Site>();
      mines.add(new Site(-50+dx, 100+dy));
      mines.add(new Site(150+dx, -200+dy));
      MiningCenter ans = new MiningCenter(mines);
      assertEquals(new Site(0+dx, -100+dy), ans.getCenter());
      mines.add(new Site(-99+dx, -125+dy));
      ans = new MiningCenter(mines);
      assertEquals(new Site(0+dx, -100+dy), ans.getCenter());
      mines.add(new Site(-4+dx, -251+dy));
      mines.add(new Site(101+dx, -95+dy));
      mines.add(new Site(73+dx,-112+dy));
      ans = new MiningCenter(mines);
      assertEquals(new Site(0+dx, -100+dy), ans.getCenter());

      dx = 249;
      dy = 128;
      mines = new ArrayList<Site>();
      mines.add(new Site(-50+dx, 100+dy));
      mines.add(new Site(150+dx, -200+dy));
      ans = new MiningCenter(mines);
      assertEquals(new Site(199, -22), ans.getCenter());
      mines.add(new Site(-99+dx, -125+dy));
      ans = new MiningCenter(mines);
      assertEquals(new Site(199, -22), ans.getCenter());
      mines.add(new Site(-4+dx, -251+dy));
      mines.add(new Site(101+dx, -95+dy));
      mines.add(new Site(73+dx,-112+dy));
      ans = new MiningCenter(mines);
      assertEquals(new Site(199, -22), ans.getCenter());

      dx = -439;
      dy = -825;
      mines = new ArrayList<Site>();
      mines.add(new Site(-50+dx, 100+dy));
      mines.add(new Site(150+dx, -200+dy));
      ans = new MiningCenter(mines);
      assertEquals(new Site(-289, -775), ans.getCenter());
      mines.add(new Site(99+dx, 125+dy));
      ans = new MiningCenter(mines);
      assertEquals(new Site(-289, -775), ans.getCenter());
      mines.add(new Site(-204, -619));
      mines.add(new Site(-289-99, -775-85));
      mines.add(new Site(-289+123, -775+89));
      ans = new MiningCenter(mines);
      assertEquals(new Site(-289, -775), ans.getCenter());
   }

   public void testMiningCenter08()
   {
      testMiningCenter01();
      testMiningCenter02();
      testMiningCenter03();
      testMiningCenter04();
   }

   public void testMiningCenter09()
   {
      testMiningCenter05();
      testMiningCenter06();
      testMiningCenter07();
   }

   public void testMiningCenter10()
   {
      testMiningCenter08();
      testMiningCenter09();
   }

   /*
    *     TurkeyOr  testers
    */
   public void testTurkeyOr01()
   {
      ArrayList<Integer> al = new ArrayList<Integer>();
      al.add(new Integer(5));
      al.add(new Integer(2));
      al.add(new Integer(3));
      TurkeyOr tw = new TurkeyOr(al);

      assertEquals(false, tw.canTravel(-11));
      assertEquals(true, tw.canTravel(-10));
      assertEquals(false, tw.canTravel(-9));
      assertEquals(true, tw.canTravel(-8));
      assertEquals(true, tw.canTravel(-7));
      assertEquals(true, tw.canTravel(-6));
      assertEquals(true, tw.canTravel(-5));
      assertEquals(true, tw.canTravel(-4));
      assertEquals(true, tw.canTravel(-3));
      assertEquals(true, tw.canTravel(-2));
      assertEquals(true, tw.canTravel(-1));
      assertEquals(true, tw.canTravel(0));
      assertEquals(true, tw.canTravel(1));
      assertEquals(true, tw.canTravel(2));
      assertEquals(true, tw.canTravel(3));
      assertEquals(true, tw.canTravel(4));
      assertEquals(true, tw.canTravel(5));
      assertEquals(true, tw.canTravel(6));
      assertEquals(true, tw.canTravel(7));
      assertEquals(true, tw.canTravel(8));
      assertEquals(false, tw.canTravel(9));
      assertEquals(true, tw.canTravel(10));
      assertEquals(false, tw.canTravel(11));

      
      al.add(new Integer(1));
      tw = new TurkeyOr(al);

      assertEquals(true, tw.canTravel(0));
      assertEquals(true, tw.canTravel(1));
      assertEquals(true, tw.canTravel(2));
      assertEquals(true, tw.canTravel(3));
      assertEquals(true, tw.canTravel(4));
      assertEquals(true, tw.canTravel(5));
      assertEquals(true, tw.canTravel(6));
      assertEquals(true, tw.canTravel(7));
      assertEquals(true, tw.canTravel(8));
      assertEquals(true, tw.canTravel(9));
      assertEquals(true, tw.canTravel(10));
      assertEquals(true, tw.canTravel(11));
      assertEquals(false, tw.canTravel(12));
    }

   public void testTurkeyOr02()
   {
      ArrayList<Integer> al = new ArrayList<Integer>();
      al.add(new Integer(1));
      al.add(new Integer(2));
      al.add(new Integer(4));
      al.add(new Integer(8));
      al.add(new Integer(16));
      al.add(new Integer(32));
      al.add(new Integer(256));
      al.add(new Integer(128));
      al.add(new Integer(64));
      TurkeyOr tw = new TurkeyOr(al);

      assertEquals(false, tw.canTravel(-512));
      for (int num = - 511; num < 512; num++)
      {
         assertEquals(true, tw.canTravel(num));
      }
      assertEquals(false, tw.canTravel(512));


      al = new ArrayList<Integer>();
      al.add(new Integer(2));
      al.add(new Integer(4));
      al.add(new Integer(8));
      al.add(new Integer(16));
      al.add(new Integer(32));
      al.add(new Integer(256));
      al.add(new Integer(128));
      al.add(new Integer(64));
      tw = new TurkeyOr(al);

      for (int num = - 510; num < 512; num+=2)
      {
         assertEquals(true, tw.canTravel(num));
      }
      for (int num = - 511; num < 512; num+=2)
      {
         assertEquals(false, tw.canTravel(num));
      }
    }

   public void testTurkeyOr03()
   {
      ArrayList<Integer> al = new ArrayList<Integer>();
      al.add(new Integer(10));
      al.add(new Integer(20));
      al.add(new Integer(40));
      TurkeyOr tw = new TurkeyOr(al);

      assertEquals(false, tw.canTravel(-71));
      for (int num = -70; num < 71; num++)
      {
         if (num%10==0)
            assertEquals(true, tw.canTravel(num));
         else
            assertEquals(false, tw.canTravel(num));
      }
      assertEquals(false, tw.canTravel(71));

      
      al = new ArrayList<Integer>();
      al.add(new Integer(20));
      al.add(new Integer(40));
      al.add(new Integer(80));
      al.add(new Integer(160));
      al.add(new Integer(320));
      tw = new TurkeyOr(al);

      assertEquals(false, tw.canTravel(-71));
      for (int num = -70; num < 71; num++)
      {
         if (num % 20==0)
            assertEquals(true, tw.canTravel(num));
         else assertEquals(false, tw.canTravel(num));
      }
      assertEquals(false, tw.canTravel(71));
    }

   public void testTurkeyOr04()
   {
      ArrayList<Integer> al = new ArrayList<Integer>();
      al.add(new Integer(-1));
      al.add(new Integer(-2));
      al.add(new Integer(-4));
      al.add(new Integer(-8));
      al.add(new Integer(-16));
      al.add(new Integer(-32));
      al.add(new Integer(-256));
      al.add(new Integer(-128));
      al.add(new Integer(-64));
      TurkeyOr tw = new TurkeyOr(al);

      assertEquals(false, tw.canTravel(-512));
      for (int num = - 511; num < 512; num++)
      {
         assertEquals(true, tw.canTravel(num));
      }
      assertEquals(false, tw.canTravel(512));

      al = new ArrayList<Integer>();
      al.add(new Integer(-1));
      al.add(new Integer(2));
      al.add(new Integer(-4));
      al.add(new Integer(8));
      al.add(new Integer(-16));
      al.add(new Integer(32));
      al.add(new Integer(-256));
      al.add(new Integer(128));
      al.add(new Integer(-64));
      tw = new TurkeyOr(al);

      assertEquals(false, tw.canTravel(-512));
      for (int num = - 511; num < 512; num++)
      {
         assertEquals(true, tw.canTravel(num));
      }
      assertEquals(false, tw.canTravel(512));
   }

   public void testTurkeyOr05()
   {
      ArrayList<Integer> al = new ArrayList<Integer>();
      al.add(new Integer(3));
      al.add(new Integer(9));
      al.add(new Integer(-18));
      TurkeyOr tw = new TurkeyOr(al);

      assertEquals(true, tw.canTravel(0));
      assertEquals(false, tw.canTravel(1));
      assertEquals(false, tw.canTravel(2));
      assertEquals(true, tw.canTravel(3));     //  3
      assertEquals(false, tw.canTravel(4));
      assertEquals(false, tw.canTravel(5));
      assertEquals(true, tw.canTravel(6));     //  9-3
      assertEquals(false, tw.canTravel(7));
      assertEquals(false, tw.canTravel(8));
      assertEquals(true, tw.canTravel(9));     //  9
      assertEquals(false, tw.canTravel(10));
      assertEquals(false, tw.canTravel(11));
      assertEquals(true, tw.canTravel(12));    //  9+3
      assertEquals(false, tw.canTravel(13));    //  
      assertEquals(false, tw.canTravel(14));
      assertEquals(true, tw.canTravel(15));    //  18 - 3
      assertEquals(false, tw.canTravel(16));    //  
      assertEquals(false, tw.canTravel(17));
      assertEquals(true, tw.canTravel(18));    //  18
      assertEquals(false, tw.canTravel(19));    //  
      assertEquals(false, tw.canTravel(20));
      assertEquals(true, tw.canTravel(21));    //  18+21
      assertEquals(false, tw.canTravel(22));
      assertEquals(false, tw.canTravel(23));
      assertEquals(true, tw.canTravel(24));    //  18+9-3
      assertEquals(false, tw.canTravel(25));
      assertEquals(false, tw.canTravel(26));
      assertEquals(true, tw.canTravel(27));    //  18 + 9 
      assertEquals(false, tw.canTravel(28));
      assertEquals(false, tw.canTravel(29));
      assertEquals(true, tw.canTravel(30));    //  18+9+3
      assertEquals(false, tw.canTravel(31));
      assertEquals(false, tw.canTravel(32));

      assertEquals(false, tw.canTravel(-1));
      assertEquals(false, tw.canTravel(-2));
      assertEquals(true, tw.canTravel(-3));     //  3
      assertEquals(false, tw.canTravel(-4));
      assertEquals(false, tw.canTravel(-5));
      assertEquals(true, tw.canTravel(-6));     //  9-3
      assertEquals(false, tw.canTravel(-7));
      assertEquals(false, tw.canTravel(-8));
      assertEquals(true, tw.canTravel(-9));     //  9
      assertEquals(false, tw.canTravel(-10));
      assertEquals(false, tw.canTravel(-11));
      assertEquals(true, tw.canTravel(-12));    //  9+3
      assertEquals(false, tw.canTravel(-13));    //  
      assertEquals(false, tw.canTravel(-14));
      assertEquals(true, tw.canTravel(-15));    //  18 - 3
      assertEquals(false, tw.canTravel(-16));    //  
      assertEquals(false, tw.canTravel(-17));
      assertEquals(true, tw.canTravel(-18));    //  18
      assertEquals(false, tw.canTravel(-19));    //  
      assertEquals(false, tw.canTravel(-20));
      assertEquals(true, tw.canTravel(-21));    //  18+21
      assertEquals(false, tw.canTravel(-22));
      assertEquals(false, tw.canTravel(-23));
      assertEquals(true, tw.canTravel(-24));    //  18+9-3
      assertEquals(false, tw.canTravel(-25));
      assertEquals(false, tw.canTravel(-26));
      assertEquals(true, tw.canTravel(-27));    //  18 + 9 
      assertEquals(false, tw.canTravel(-28));
      assertEquals(false, tw.canTravel(-29));
      assertEquals(true, tw.canTravel(-30));    //  18+9+3
      assertEquals(false, tw.canTravel(-31));

      al = new ArrayList<Integer>();
      al.add(new Integer(8));
      al.add(new Integer(-12));
      al.add(new Integer(17));
      al.add(new Integer(-11));
      tw = new TurkeyOr(al);

      assertEquals(true, tw.canTravel(0));
      assertEquals(true, tw.canTravel(1));     //  12 - 11
      assertEquals(true, tw.canTravel(2));     //  -17 + 11  + 8
      assertEquals(true, tw.canTravel(3));     //  -17 + 12  + 8
      assertEquals(true, tw.canTravel(4));     //   12 - 8
      assertEquals(true, tw.canTravel(5));     //  17 - 12
      assertEquals(true, tw.canTravel(6));     //  17 - 11
      assertEquals(true, tw.canTravel(7));     //   8 - 12 + 11
      assertEquals(true, tw.canTravel(8));     //   8
      assertEquals(true, tw.canTravel(9));     //   8 - 11 + 12
      assertEquals(true, tw.canTravel(10));    // 17 - 8 - 11 + 12
      assertEquals(true, tw.canTravel(11));    //   11
      assertEquals(true, tw.canTravel(12));    //   12
      assertEquals(true, tw.canTravel(13));    //  8 + 17 - 12
      assertEquals(true, tw.canTravel(14));    //  8 + 17 - 11
      assertEquals(true, tw.canTravel(15));    //  11 + 12 - 8
      assertEquals(true, tw.canTravel(16));    //  17 - 12 + 11
      assertEquals(true, tw.canTravel(17));    //  17
      assertEquals(true, tw.canTravel(18));    //  17 - 11 + 12
      assertEquals(true, tw.canTravel(19));    //  8 + 11
      assertEquals(true, tw.canTravel(20));    //  8 + 12
      assertEquals(true, tw.canTravel(21));    //  17 + 12 - 8
      assertEquals(false, tw.canTravel(22));
      assertEquals(true, tw.canTravel(23));    //  11 + 12
      assertEquals(true, tw.canTravel(24));    //  11 + 17 + 8 - 12
      assertEquals(true, tw.canTravel(25));    //  8 + 17
      assertEquals(true, tw.canTravel(26));    //  17 + 8 + 12 - 11
      assertEquals(false, tw.canTravel(27));   // 
      assertEquals(true, tw.canTravel(28));    //  11 + 17
      assertEquals(true, tw.canTravel(29));    //  12 + 17
      assertEquals(false, tw.canTravel(30));    
      assertEquals(true, tw.canTravel(31));    //  12 + 11 + 8
      assertEquals(true, tw.canTravel(32));    //  17 + 12 + 11 - 8
      assertEquals(false, tw.canTravel(33));
      assertEquals(false, tw.canTravel(34));
      assertEquals(false, tw.canTravel(35));
      assertEquals(true, tw.canTravel(36));    //  17 + 11 + 8
      assertEquals(true, tw.canTravel(37));    //  17 + 12 + 8
      assertEquals(false, tw.canTravel(38));
      assertEquals(false, tw.canTravel(39));
      assertEquals(true, tw.canTravel(40));    //  17 + 11 + 12
      for (int num = 41; num < 8+11+12+17; num++)
      {
         assertEquals(false, tw.canTravel(num));    
      }
      assertEquals(true, tw.canTravel(8+11+17+12));
      assertEquals(false, tw.canTravel(8+11+17+12+1));

      assertEquals(true, tw.canTravel(-1));     //  12 - 11
      assertEquals(true, tw.canTravel(-2));     //  -17 + 11  + 8
      assertEquals(true, tw.canTravel(-3));     //  -17 + 12  + 8
      assertEquals(true, tw.canTravel(-4));     //   12 - 8
      assertEquals(true, tw.canTravel(-5));     //  17 - 12
      assertEquals(true, tw.canTravel(-6));     //  17 - 11
      assertEquals(true, tw.canTravel(-7));     //   8 - 12 + 11
      assertEquals(true, tw.canTravel(-8));     //   8
      assertEquals(true, tw.canTravel(-9));     //   8 - 11 + 12
      assertEquals(true, tw.canTravel(-10));    // 17 - 8 - 11 + 12
      assertEquals(true, tw.canTravel(-11));    //   11
      assertEquals(true, tw.canTravel(-12));    //   12
      assertEquals(true, tw.canTravel(-13));    //  8 + 17 - 12
      assertEquals(true, tw.canTravel(-14));    //  8 + 17 - 11
      assertEquals(true, tw.canTravel(-15));    //  11 + 12 - 8
      assertEquals(true, tw.canTravel(-16));    //  17 - 12 + 11
      assertEquals(true, tw.canTravel(-17));    //  17
      assertEquals(true, tw.canTravel(-18));    //  17 - 11 + 12
      assertEquals(true, tw.canTravel(-19));    //  8 + 11
      assertEquals(true, tw.canTravel(-20));    //  8 + 12
      assertEquals(true, tw.canTravel(-21));    //  17 + 12 - 8
      assertEquals(false, tw.canTravel(-22));
      assertEquals(true, tw.canTravel(-23));    //  11 + 12
      assertEquals(true, tw.canTravel(-24));    //  11 + 17 + 8 - 12
      assertEquals(true, tw.canTravel(-25));    //  8 + 17
      assertEquals(true, tw.canTravel(-26));    //  17 + 8 + 12 - 11
      assertEquals(false, tw.canTravel(-27));   // 
      assertEquals(true, tw.canTravel(-28));    //  11 + 17
      assertEquals(true, tw.canTravel(-29));    //  12 + 17
      assertEquals(false, tw.canTravel(-30));    
      assertEquals(true, tw.canTravel(-31));    //  12 + 11 + 8
      assertEquals(true, tw.canTravel(-32));    //  17 + 12 + 11 - 8
      assertEquals(false, tw.canTravel(-33));
      assertEquals(false, tw.canTravel(-34));
      assertEquals(false, tw.canTravel(-35));
      assertEquals(true, tw.canTravel(-36));    //  17 + 11 + 8
      assertEquals(true, tw.canTravel(-37));    //  17 + 12 + 8
      assertEquals(false, tw.canTravel(-38));
      assertEquals(false, tw.canTravel(-39));
      assertEquals(true, tw.canTravel(-40));    //  17 + 11 + 12
      for (int num = 41; num < 8+11+12+17; num++)
      {
//         System.out.println(" num = " + num);
         assertEquals(false, tw.canTravel(-num));    
      }
      assertEquals(true, tw.canTravel(-1*(8+11+17+12)));
      assertEquals(false, tw.canTravel(-1*(8+11+17+12+1)));
   }

   public void testTurkeyOr06()
   {
      ArrayList<Integer> al = new ArrayList<Integer>();
      al.add(new Integer(1));
      al.add(new Integer(10));
      al.add(new Integer(100));
      TurkeyOr tw = new TurkeyOr(al);

      assertEquals(false, tw.canTravel(-112));
      assertEquals(true, tw.canTravel(-111));    //  100 + 10 + 1
      assertEquals(true, tw.canTravel(-110));    //  100 + 10
      assertEquals(true, tw.canTravel(-109));    //  100 + 10 - 1
      assertEquals(false, tw.canTravel(-108));
      assertEquals(false, tw.canTravel(-105));
      assertEquals(false, tw.canTravel(-103));
      assertEquals(true, tw.canTravel(-101));    //  100      + 1
      assertEquals(true, tw.canTravel(-100));    //  100
      assertEquals(true, tw.canTravel(-99));     //  100      - 1
      assertEquals(false, tw.canTravel(-97));
      assertEquals(true, tw.canTravel(-91));     //  100 - 10 + 1
      assertEquals(true, tw.canTravel(-89));     //  100 - 10 - 1
      assertEquals(true, tw.canTravel(-90));     //  100 - 10
      assertEquals(false, tw.canTravel(-55));
      assertEquals(false, tw.canTravel(-45));
      assertEquals(false, tw.canTravel(-36));
      assertEquals(false, tw.canTravel(-22));
      assertEquals(false, tw.canTravel(-19));

      assertEquals(true, tw.canTravel(-11));    //  10 + 1 
      assertEquals(true, tw.canTravel(-10));    //  10 
      assertEquals(true, tw.canTravel(-9));     //  10 - 1
      assertEquals(false, tw.canTravel(-5));
      assertEquals(true, tw.canTravel(-1));     //  1

      assertEquals(false, tw.canTravel(112));
      assertEquals(true, tw.canTravel(111));    //  100 + 10 + 1
      assertEquals(true, tw.canTravel(110));    //  100 + 10
      assertEquals(true, tw.canTravel(109));    //  100 + 10 - 1
      assertEquals(false, tw.canTravel(108));
      assertEquals(false, tw.canTravel(105));
      assertEquals(false, tw.canTravel(103));
      assertEquals(true, tw.canTravel(101));    //  100      + 1
      assertEquals(true, tw.canTravel(100));    //  100
      assertEquals(true, tw.canTravel(99));     //  100      - 1
      assertEquals(false, tw.canTravel(97));
      assertEquals(true, tw.canTravel(91));     //  100 - 10 + 1
      assertEquals(true, tw.canTravel(89));     //  100 - 10 - 1
      assertEquals(true, tw.canTravel(90));     //  100 - 10
      assertEquals(false, tw.canTravel(55));
      assertEquals(false, tw.canTravel(45));
      assertEquals(false, tw.canTravel(36));
      assertEquals(false, tw.canTravel(22));
      assertEquals(false, tw.canTravel(19));

      assertEquals(true, tw.canTravel(11));    //  10 + 1 
      assertEquals(true, tw.canTravel(10));    //  10 
      assertEquals(true, tw.canTravel(9));     //  10 - 1
      assertEquals(false, tw.canTravel(5));
      assertEquals(true, tw.canTravel(1));     //  1
   }

   public void testTurkeyOr07()
   {
      ArrayList<Integer> al = new ArrayList<Integer>();
      al.add(new Integer(2));
      al.add(new Integer(13));
      al.add(new Integer(21));
      TurkeyOr tw = new TurkeyOr(al);

      assertEquals(false, tw.canTravel(-37));
      assertEquals(true, tw.canTravel(-36));     //  21 + 13 + 2
      assertEquals(false, tw.canTravel(-35));
      assertEquals(true, tw.canTravel(-34));     //  21 + 13
      assertEquals(true, tw.canTravel(-32));     //  21 + 13 - 2
      assertEquals(false, tw.canTravel(-27));
      assertEquals(false, tw.canTravel(-25));
      assertEquals(true, tw.canTravel(-23));     //  21      + 2
      assertEquals(true, tw.canTravel(-21));     //  21
      assertEquals(true, tw.canTravel(-19));     //  21      - 2
      assertEquals(true, tw.canTravel(-15));     //       13 + 2 
      assertEquals(true, tw.canTravel(-13));     //       13
      assertEquals(false, tw.canTravel(-12));
      assertEquals(true, tw.canTravel(-11));     //       13 - 2
      assertEquals(true, tw.canTravel(-10));     //  21 - 13 + 2
      assertEquals(true, tw.canTravel(-8));      //  21 - 13
      assertEquals(false, tw.canTravel(-7));
      assertEquals(true, tw.canTravel(-6));      //  21 - 13 - 2
      assertEquals(false, tw.canTravel(-3));
      assertEquals(true, tw.canTravel(-2));      //            2
      assertEquals(true, tw.canTravel(0));

      assertEquals(false, tw.canTravel(37));
      assertEquals(true, tw.canTravel(36));     //  21 + 13 + 2
      assertEquals(false, tw.canTravel(35));
      assertEquals(true, tw.canTravel(34));     //  21 + 13
      assertEquals(true, tw.canTravel(32));     //  21 + 13 - 2
      assertEquals(false, tw.canTravel(27));
      assertEquals(false, tw.canTravel(25));
      assertEquals(true, tw.canTravel(23));     //  21      + 2
      assertEquals(true, tw.canTravel(21));     //  21
      assertEquals(true, tw.canTravel(19));     //  21      - 2
      assertEquals(true, tw.canTravel(15));     //       13 + 2 
      assertEquals(true, tw.canTravel(13));     //       13
      assertEquals(false, tw.canTravel(12));
      assertEquals(true, tw.canTravel(11));     //       13 - 2
      assertEquals(true, tw.canTravel(10));     //  21 - 13 + 2
      assertEquals(true, tw.canTravel(8));      //  21 - 13
      assertEquals(false, tw.canTravel(7));
      assertEquals(true, tw.canTravel(6));      //  21 - 13 - 2
      assertEquals(false, tw.canTravel(3));
      assertEquals(true, tw.canTravel(2));      //            2
      assertEquals(true, tw.canTravel(0));

   }

   public void testTurkeyOr08()
   {
      testTurkeyOr01();
      testTurkeyOr02();
      testTurkeyOr03();
      testTurkeyOr04();
   }

   public void testTurkeyOr09()
   {
      testTurkeyOr05();
      testTurkeyOr06();
      testTurkeyOr07();
   }

   public void testTurkeyOr10()
   {
      testTurkeyOr08();
      testTurkeyOr09();

      ArrayList<Integer> al = new ArrayList<Integer>();
      al.add(new Integer(1));
      TurkeyOr tw = new TurkeyOr(al);

      assertEquals(false, tw.canTravel(-2));
      assertEquals(true, tw.canTravel(-1));
      assertEquals(true, tw.canTravel(0));
      assertEquals(true, tw.canTravel(1));
      assertEquals(false, tw.canTravel(2));
   }

/*
 *    Fun With Circles tester
 */   
   private final String ZERO = "zero";
   private final String ONE = "one";
   private final String TWO = "two";
   private final String INFINITE = "infinite";

   public void testIntersectingCircles01()
   {
      Circle c1 = new Circle(10, new Point(0,0));
      Circle c2 = new Circle(5, new Point(2,0));
      FunWithCircles ic = new FunWithCircles(c1);

      assertEquals(2.0, ic.getDistanceBetweenCenters(c2), 0.01);
      assertEquals(ZERO, ic.getNumberPointsOfIntersetion(c2));
      assertEquals(3.0, ic.getMinDistanceBetweenCircles(c2), 0.01);
      assertEquals(5.0, ic.getMinDistanceBetweenCircles(new Circle(5, new Point(20, 0))), 0.01);
      assertEquals(10*10*Math.PI, ic.getTotalAreaOfUnioinOfBothCircles(c2), 0.1);
    }

   public void testIntersectingCircles02()    //  getDistanceBetweenCenters
   {
      Circle c1 = new Circle(25, new Point(5, 5));
      Circle c2 = new Circle(15, new Point(3, -10));
      Circle c3 = new Circle(125, new Point(-13, 10));
      FunWithCircles ic = new FunWithCircles(c1);

      assertEquals(Math.sqrt((5 - 3)*(5 - 3) + (5 - -10)*(5 - -10)), ic.getDistanceBetweenCenters(c2), 0.01);
      assertEquals(Math.sqrt((5 - -13)*(5 - -13) + (5 - 10)*(5 - 10)), ic.getDistanceBetweenCenters(c3), 0.01);

      Circle c4 = new Circle(14.9, new Point(1.3, -5.1));
      FunWithCircles ic2 = new FunWithCircles(c4);
      Circle c5 = new Circle(24.79, new Point(-8.37, 35.41));
      assertEquals(Math.sqrt((1.3 - -8.37)*(1.3 - -8.37) + (-5.1 - 35.41)*(-5.1 - 35.41)), ic2.getDistanceBetweenCenters(c5), 0.01);
      assertEquals(Math.sqrt((5 - -8.37)*(5 - -8.37) + (5 - 35.41)*(5 - 35.41)), ic.getDistanceBetweenCenters(c5), 0.01);
      Circle c6 = new Circle(24.79, new Point(-18.37, -5.41));
      assertEquals(Math.sqrt((1.3 - -18.37)*(1.3 - -18.37) + (-5.1 - -5.41)*(-5.1 - -5.41)), ic2.getDistanceBetweenCenters(c6), 0.01);
      assertEquals(Math.sqrt((5 - -18.37)*(5 - -18.37) + (5 - -5.41)*(5 - -5.41)), ic.getDistanceBetweenCenters(c6), 0.01);
   }

   public void testIntersectingCircles03()    //    getNumberPointsOfIntersetion  still needs to test same circle / INFINITE
   {
      Circle c1 = new Circle(25, new Point(15, 75));
      Circle c2 = new Circle(15, new Point(3, -10));
      Circle c3 = new Circle(10, new Point(15, 90));
      FunWithCircles ic = new FunWithCircles(c1);

      assertEquals(ZERO, ic.getNumberPointsOfIntersetion(c2));
      assertEquals(ONE, ic.getNumberPointsOfIntersetion(c3));

      Circle c4 = new Circle(14.9, new Point(-21.3, 75.1));
      assertEquals(TWO, ic.getNumberPointsOfIntersetion(c4));
      assertEquals(INFINITE, ic.getNumberPointsOfIntersetion(c1));

      FunWithCircles ic2 = new FunWithCircles( new Circle(21, new Point(-5, -10)));
      Circle c5 = new Circle(4.09, new Point(21, 16));
      assertEquals(ZERO, ic2.getNumberPointsOfIntersetion(c5));

      Circle c6 = new Circle(2, new Point(-24, -10));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(c6));
      c6 = new Circle(4, new Point(-30, -10));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(c6));
      c6 = new Circle(100-16, new Point(100, -10));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(c6));
      c6 = new Circle(6, new Point(10, -10));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(c6));
      c6 = new Circle(4, new Point(-5, 15));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(c6));
      c6 = new Circle(10, new Point(-5, 1));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(c6));
      c6 = new Circle(19, new Point(-5, -50));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(c6));
      c6 = new Circle(1, new Point(-5, -30));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(c6));

      ic2 = new FunWithCircles( new Circle(22, new Point(-5, -10)));
      Circle c7 = new Circle(8, new Point(-24, -10));
      assertEquals(TWO, ic2.getNumberPointsOfIntersetion(c7));
      c7 = new Circle(4, new Point(-30, -10));
      assertEquals(TWO, ic2.getNumberPointsOfIntersetion(c7));
      c7 = new Circle(100-16, new Point(100, -10));
      assertEquals(TWO, ic2.getNumberPointsOfIntersetion(c7));
      c7 = new Circle(8, new Point(10, -10));
      assertEquals(TWO, ic2.getNumberPointsOfIntersetion(c7));
      c7 = new Circle(4, new Point(-5, 15));
      assertEquals(TWO, ic2.getNumberPointsOfIntersetion(c7));
      c7 = new Circle(15, new Point(-5, 1));
      assertEquals(TWO, ic2.getNumberPointsOfIntersetion(c7));
      c7 = new Circle(19, new Point(-5, -50));
      assertEquals(TWO, ic2.getNumberPointsOfIntersetion(c7));
      c7 = new Circle(3, new Point(-5, -30));
      assertEquals(TWO, ic2.getNumberPointsOfIntersetion(c7));
   }

   public void testIntersectingCircles04()    //    getNumberPointsOfIntersetion  including test same circle / INFINITE
   {
      Circle c1 = new Circle(5, new Point(5, 7));
      FunWithCircles ic = new FunWithCircles(c1);

      Circle c4 = new Circle(8.9, new Point(0, 0));
      assertEquals(TWO, ic.getNumberPointsOfIntersetion(c4));
      assertEquals(ONE, ic.getNumberPointsOfIntersetion(new Circle(10, new Point(20, 7))));

      Circle c2 = new Circle(1, new Point(3, 6));
      Circle c3 = new Circle(18, new Point(15, 9));
      assertEquals(ZERO, ic.getNumberPointsOfIntersetion(c2));
      assertEquals(ZERO, ic.getNumberPointsOfIntersetion(c3));
      assertEquals(INFINITE, ic.getNumberPointsOfIntersetion(c1));

      FunWithCircles ic2 = new FunWithCircles(c2);
      assertEquals(INFINITE, ic2.getNumberPointsOfIntersetion(c2));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(new Circle(1, new Point(3, 8))));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(new Circle(2, new Point(3, 9))));
      assertEquals(TWO, ic2.getNumberPointsOfIntersetion(new Circle(1.5, new Point(3, 8))));

      FunWithCircles ic3 = new FunWithCircles(c3);
      assertEquals(INFINITE, ic3.getNumberPointsOfIntersetion(c3));

/*

      Circle c6 = new Circle(2, new Point(-24, -10));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(c6));
      c6 = new Circle(4, new Point(-30, -10));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(c6));
      c6 = new Circle(100-16, new Point(100, -10));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(c6));
      c6 = new Circle(6, new Point(10, -10));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(c6));
      c6 = new Circle(4, new Point(-5, 15));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(c6));
      c6 = new Circle(10, new Point(-5, 1));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(c6));
      c6 = new Circle(19, new Point(-5, -50));
      assertEquals(ONE, ic2.getNumberPointsOfIntersetion(c6));
      c6 = new Circle(1, new Point(-5, -30));
      assertEquals(ZEROONE, ic2.getNumberPointsOfIntersetion(c6));
*/
   }

   public void testIntersectingCircles05()   // getMinDistanceBetweenCircles
   {
      Circle cI= new Circle(17.55, new Point(21, 43.7));
      Circle cII = new Circle(4.6, new Point(-5, 7.6));
      Circle cIII= new Circle(7.2, new Point(-21, -30.7));
      Circle cIV = new Circle(34.6, new Point(42.5, -57.6));
      FunWithCircles ic = new FunWithCircles(cI);

      assertEquals(Math.sqrt((21+5)*(21+5)+(43.7-7.6)*(43.7-7.6))-17.55-4.6, ic.getMinDistanceBetweenCircles(cII), 0.01);
      assertEquals(Math.sqrt((21+21)*(21+21)+(43.7+30.7)*(43.7+30.7))-17.55-7.2, ic.getMinDistanceBetweenCircles(cIII), 0.01);
      assertEquals(Math.sqrt((21-42.5)*(21-42.5)+(43.7+57.6)*(43.7+57.6))-17.55-34.6, ic.getMinDistanceBetweenCircles(cIV), 0.01);

      FunWithCircles ic2 = new FunWithCircles(cII);
      assertEquals(Math.sqrt((-5+21)*(-5+21)+(7.6+30.7)*(7.6+30.7))-4.6-7.2, ic2.getMinDistanceBetweenCircles(cIII), 0.01);
      assertEquals(Math.sqrt((-5-42.5)*(-5-42.5)+(7.6+57.6)*(7.6+57.6))-4.6-34.6, ic2.getMinDistanceBetweenCircles(cIV), 0.01);

      FunWithCircles ic3 = new FunWithCircles(cIII);
      assertEquals(Math.sqrt((-21-42.5)*(-21-42.5)+(-30.7+57.6)*(-30.7+57.6))-7.2-34.6, ic3.getMinDistanceBetweenCircles(cIV), 0.01);
   }

   public void testIntersectingCircles06()
   {
      Circle c1 = new Circle(10, new Point(-100, 300));
      Circle c2 = new Circle(50, new Point(1000, -10000));
      FunWithCircles ic = new FunWithCircles(c1);

      assertEquals(100*Math.PI + 50*50*Math.PI, ic.getTotalAreaOfUnioinOfBothCircles(c2), 0.1);
      Circle c3 = new Circle(22, new Point(-100+22+10, 300));
      assertEquals(100*Math.PI + 22*22*Math.PI, ic.getTotalAreaOfUnioinOfBothCircles(c3), 0.1);
      c3 = new Circle(22, new Point(-100-22-10, 300));
      assertEquals(100*Math.PI + 22*22*Math.PI, ic.getTotalAreaOfUnioinOfBothCircles(c3), 0.1);

      Circle c4 = new Circle(2, new Point(-100+4, 300));
      assertEquals(100*Math.PI, ic.getTotalAreaOfUnioinOfBothCircles(c4), 0.1);
      c4 = new Circle(2, new Point(-100+5, 300));
      assertEquals(100*Math.PI, ic.getTotalAreaOfUnioinOfBothCircles(c4), 0.1);
   }

   public void testIntersectingCircles07()
   {
      Circle c1 = new Circle(3, new Point(2, 3));
      Circle c2 = new Circle(4, new Point(2, 3));
      FunWithCircles ic = new FunWithCircles(c1);

      assertEquals(Math.PI*4*4, ic.getTotalAreaOfUnioinOfBothCircles(c2), 0.1);

      Circle c3 = new Circle(8, new Point(8, 8));
      Circle c4 = new Circle(8, new Point(-8, -8));
      ic = new FunWithCircles(c3);

      assertEquals(2*64*Math.PI, ic.getTotalAreaOfUnioinOfBothCircles(c4), 0.1);

      Circle c5 = new Circle(1, new Point(-50000, 5000));
      Circle c6 = new Circle(2, new Point(50000, -5000));
      ic = new FunWithCircles(c5);

      assertEquals(4*Math.PI + Math.PI, ic.getTotalAreaOfUnioinOfBothCircles(c6), 0.1);
   }

   public void testIntersectingCircles08()
   {
      Circle c1 = new Circle(3, new Point(2, 3));
      Circle c2 = new Circle(4, new Point(1, -1));
      FunWithCircles ic = new FunWithCircles(c1);

      assertEquals(67.35228679, ic.getTotalAreaOfUnioinOfBothCircles(c2), 0.1);

      Circle c3 = new Circle(8, new Point(0, 0));
      Circle c4 = new Circle(8, new Point(8, -8));
      ic = new FunWithCircles(c3);

      assertEquals(96*Math.PI+64., ic.getTotalAreaOfUnioinOfBothCircles(c4), 0.1);

      Circle c5 = new Circle(10, new Point(5, 5));
      Circle c6 = new Circle(10, new Point(15, 15));
      ic = new FunWithCircles(c5);

      assertEquals(1.5*Math.PI*100+100., ic.getTotalAreaOfUnioinOfBothCircles(c6), 0.1);

      Circle c7 = new Circle(4, new Point(5, 6));
      Circle c8 = new Circle(5, new Point(10, 1));
      ic = new FunWithCircles(c7);

      assertEquals((12.12897063+20.35443869)*Math.PI+11.49743304924+7.98974186, ic.getTotalAreaOfUnioinOfBothCircles(c8), 0.1);
   }

   public void testIntersectingCircles09()
   {
      testIntersectingCircles07();
      testIntersectingCircles08();

      Circle c1 = new Circle(11, new Point(2, 3));
      Circle c2 = new Circle(7, new Point(2, 3));
      FunWithCircles ic = new FunWithCircles(c1);

      assertEquals(0, ic.getDistanceBetweenCenters(c2), 0.1);
      assertEquals(ZERO, ic.getNumberPointsOfIntersetion(c2));
      assertEquals(Math.PI*11*11, ic.getTotalAreaOfUnioinOfBothCircles(c2), 0.1);

      Circle c3 = new Circle(81, new Point(8, -8));
      Circle c4 = new Circle(81, new Point(8, -8));
      ic = new FunWithCircles(c3);

      assertEquals(0, ic.getDistanceBetweenCenters(c4), 0.1);
      assertEquals(INFINITE, ic.getNumberPointsOfIntersetion(c4));
      assertEquals(81*81*Math.PI, ic.getTotalAreaOfUnioinOfBothCircles(c4), 0.1);
    }

   public void testIntersectingCircles10()    //  need distance between circles
   {
      Circle c5 = new Circle(4*Math.sqrt(2), new Point(1, 1));
      Circle c6 = new Circle(2, new Point(5, 6));
      FunWithCircles ic = new FunWithCircles(c5);

      assertEquals(Math.sqrt( Math.pow(5-1,2) + Math.pow(6-1,2)), ic.getDistanceBetweenCenters(c6), 0.1);
      assertEquals(TWO, ic.getNumberPointsOfIntersetion(c6));
      assertEquals((32+4)*Math.PI-(9.90547788+4.153761231)+9.284739498+1.749298747, ic.getTotalAreaOfUnioinOfBothCircles(c6), 0.1);

      Circle c7 = new Circle(10, new Point(-50, -60));
      Circle c8 = new Circle(25, new Point(100, 300));
      ic = new FunWithCircles(c7);

      assertEquals(Math.sqrt( Math.pow(-50-100,2) + Math.pow(-60-300,2)), ic.getDistanceBetweenCenters(c8), 0.1);
      assertEquals(ZERO, ic.getNumberPointsOfIntersetion(c8));
      assertEquals(Math.sqrt(Math.pow(-50-100,2) + Math.pow(-60-300,2))-35, ic.getMinDistanceBetweenCircles(c8), 0.01);
      assertEquals((100+25*25)*Math.PI, ic.getTotalAreaOfUnioinOfBothCircles(c8), 0.1);

      Circle c9 = new Circle(1, new Point(-5000, -6000));
      Circle c10 = new Circle(2, new Point(9999, 9999));
      ic = new FunWithCircles(c9);

      assertEquals(Math.sqrt( Math.pow(-5000-9999,2) + Math.pow(-6000-9999,2)), ic.getDistanceBetweenCenters(c10), 0.1);
      assertEquals(ZERO, ic.getNumberPointsOfIntersetion(c8));
      assertEquals(Math.sqrt(Math.pow(-5000-9999,2) + Math.pow(-6000-9999,2))-3, ic.getMinDistanceBetweenCircles(c10), 0.01);
      assertEquals(5*Math.PI, ic.getTotalAreaOfUnioinOfBothCircles(c10), 0.1);

      testIntersectingCircles02();
      testIntersectingCircles03();
      testIntersectingCircles04();
      testIntersectingCircles05();
      testIntersectingCircles06();
      testIntersectingCircles09();
   }
/*
 *     Functions Gone Wild 2013 testers
 */
   public void testFunctionsGoneWild2013_00()
   {
      assertEquals(35052, FunctionsGoneWild2013.f1(111));
      assertEquals(2.0, FunctionsGoneWild2013.f2(5, 3), 0.05);
      assertEquals( -1.5945, FunctionsGoneWild2013.f3(5., 6., 7.), 0.05);
      assertEquals(0.208558 , FunctionsGoneWild2013.f4(5., 11., 3.),  0.25);
      assertEquals( -12, FunctionsGoneWild2013.f5(2, 4, -1));
      assertEquals(241068, FunctionsGoneWild2013.f6(2, 2, 1, 3));
      assertEquals(false, FunctionsGoneWild2013.f7(false, false, true) );
      assertEquals(false, FunctionsGoneWild2013.f8(false, false, false, false) );
      assertEquals(4.84856, FunctionsGoneWild2013.f9(1, 1, 1.1, 4.4, 5.5), 0.5);
      assertEquals(true, FunctionsGoneWild2013.f10(false, false, false, false, false));
   }

   public void testFunctionsGoneWild2013_01()
   {
      assertEquals(6697, FunctionsGoneWild2013.f1(15));
      assertEquals(5, FunctionsGoneWild2013.f1(1));
      assertEquals(49, FunctionsGoneWild2013.f1(3));
      assertEquals(11594, FunctionsGoneWild2013.f1(207));
      assertEquals(5439, FunctionsGoneWild2013.f1(14));
      assertEquals(11599, FunctionsGoneWild2013.f1(18));
      assertEquals(6697, FunctionsGoneWild2013.f1(15));
      assertEquals(49, FunctionsGoneWild2013.f1(3));
      assertEquals(49, FunctionsGoneWild2013.f1(3));
      assertEquals(18445, FunctionsGoneWild2013.f1(21));
      assertEquals(665, FunctionsGoneWild2013.f1(7));
      assertEquals(4349, FunctionsGoneWild2013.f1(13));
      assertEquals(237, FunctionsGoneWild2013.f1(5));
      assertEquals(3415, FunctionsGoneWild2013.f1(12));
      assertEquals(9765, FunctionsGoneWild2013.f1(17));
   }

   public void testFunctionsGoneWild2013_02()
   {
      assertEquals(2.0, FunctionsGoneWild2013.f2(5, 3), 0.05);
      assertEquals(21.0, FunctionsGoneWild2013.f2(18.998358847110836, 1.5377832384069663), 0.05);
      assertEquals(-6.0, FunctionsGoneWild2013.f2(22.43972796044403, -7.089525035415747), 0.05);
      assertEquals(-1.0, FunctionsGoneWild2013.f2(1.0621896192526528, -17.177127426020597), 0.05);
      assertEquals(-8.0, FunctionsGoneWild2013.f2(14.087905762549077, -3.2323626556690215), 0.05);
      assertEquals(29.9097, FunctionsGoneWild2013.f2(0.7343861994763436, 0.05323649917201578), 0.05);
      assertEquals(-1.0, FunctionsGoneWild2013.f2(0.035631491022869, -7.975175327617343), 0.05);
      assertEquals(0.0, FunctionsGoneWild2013.f2(3.4496622143335713, 43.18696843692324), 0.05);
      assertEquals(1.0, FunctionsGoneWild2013.f2(13.210626713341625, 12.994811433869287), 0.05);
      assertEquals(0.0, FunctionsGoneWild2013.f2(9.588104628565056, 31.30398735326868), 0.05);
      assertEquals(0.0, FunctionsGoneWild2013.f2(9.515182214883886, 42.538119135989035), 0.05);
   }

   public void testFunctionsGoneWild2013_03()
   {
      assertEquals(1.4081921609583363, FunctionsGoneWild2013.f3(-16.89456581499537, 33.849974141272924, 11.288703639166492), 0.05);
      assertEquals(3.753974028102209, FunctionsGoneWild2013.f3(-24.251076276808476, -2.8179775195786263, 1.55329267814738), 0.05);
      assertEquals(2.3906279598946583, FunctionsGoneWild2013.f3(0.14435361078117737, -47.82978542899161, 12.947038595314577), 0.05);
      assertEquals(2.6492418989469337, FunctionsGoneWild2013.f3(-1.8384787788066745, -17.367974424607347, -2.683259685205932), 0.05);
      assertEquals(-83.62080127285336, FunctionsGoneWild2013.f3(-1.2640492287578695, -40.99733843871868, 1.811445581633306), 0.05);
      assertEquals(1104.1012975847616, FunctionsGoneWild2013.f3(20.567026333690272, -22.811522402510665, 6.601447837408255), 0.05);
      assertEquals(2.4804379754647563, FunctionsGoneWild2013.f3(22.599866625552686, 32.27685834089908, 8.590688277196037), 0.05);
      assertEquals(1.2394991727063456, FunctionsGoneWild2013.f3(-21.273005753492612, -19.332018363207194, -1.0472193475964398), 0.05);
      assertEquals(-0.2752965614159762, FunctionsGoneWild2013.f3(-11.469708332778595, 38.39553854062227, 12.77147521532929), 0.05);
      assertEquals(-1.291423460659772, FunctionsGoneWild2013.f3(5.7583749963519715, 28.141866362457066, 1.06597238960493), 0.05);
      assertEquals(1.31006563718498, FunctionsGoneWild2013.f3(6.769765582358424, 34.785997312967964, -2.94593675415026), 0.05);
      assertEquals(0.7546473198864886, FunctionsGoneWild2013.f3(-21.551885832194294, 20.68899992803982, 7.434615909092933), 0.05);
     }

   public void testFunctionsGoneWild2013_04()
   {
      assertEquals(0.07248139552227116, FunctionsGoneWild2013.f4(5.715888684913377, 2.548129359785456, 3.26881173145782), 0.05);
      assertEquals(1.1706515418295331, FunctionsGoneWild2013.f4(2.1014568135513083, 0.06297162620090724, 5.181704035866726), 0.05);
      assertEquals(-0.055162354444960225, FunctionsGoneWild2013.f4(1.6726794576226784, 5.488227717166598, 5.984622048717163), 0.05);
      assertEquals(0.17429336215902816, FunctionsGoneWild2013.f4(2.1311363719345717, 0.9670849359873246, 5.006870582224599), 0.05);
      assertEquals(4.996725185405198, FunctionsGoneWild2013.f4(0.7942899043112039, 4.381479086907225, 6.715028144190641), 0.05);
      assertEquals(-0.001447962469074428, FunctionsGoneWild2013.f4(2.945525004759157, 9.494372994777788, 5.363459580520123), 0.05);
      assertEquals(0.005502200837682108, FunctionsGoneWild2013.f4(3.71229391428955, 6.354970605861413, 5.155133461158584), 0.05);
      assertEquals(0.3783398972606132, FunctionsGoneWild2013.f4(3.167704499813438, 3.197721726562551, 6.507775726517598), 0.05);
      assertEquals(2.8329408497259, FunctionsGoneWild2013.f4(0.3317430661901788, 0.7160526342770146, 6.423590904207938), 0.05);
      assertEquals(1228.6276739775683, FunctionsGoneWild2013.f4(1.8059151073026598, 4.800057767378259, 5.522956962734924), 0.05);
      assertEquals(-0.05402218454027405, FunctionsGoneWild2013.f4(0.6060399685615603, 9.872310462829795, 6.235696096662576), 0.05);
      assertEquals(7749014.590298771, FunctionsGoneWild2013.f4(1.5536062765694996, 4.431064938401054, 6.287084144806516), 0.05);
      assertEquals(-0.29504456409486673, FunctionsGoneWild2013.f4(1.3307042386813324, 7.318412463977287, 6.803999633917952), 0.05);
      assertEquals(117.16941220651906, FunctionsGoneWild2013.f4(2.1288726137606044, 2.5805796487250343, 6.669470697904669), 0.05);
      assertEquals(115953.92375933328, FunctionsGoneWild2013.f4(2.725316458212419, 4.893608443202996, 5.122664493523829), 0.05);
   }

   public void testFunctionsGoneWild2013_05()
   {
      assertEquals(18555, FunctionsGoneWild2013.f5(18, 17, 3));
      assertEquals(0, FunctionsGoneWild2013.f5(2, 1, 0));
      assertEquals(23157, FunctionsGoneWild2013.f5(22, 18, 3));
      assertEquals(0, FunctionsGoneWild2013.f5(3, 5, -3));
      assertEquals(7517, FunctionsGoneWild2013.f5(12, 7, 7));
      assertEquals(2338, FunctionsGoneWild2013.f5(7, 10, 1));
      assertEquals(0, FunctionsGoneWild2013.f5(19, 0, -8));
      assertEquals(3231, FunctionsGoneWild2013.f5(2, 10, 4));
      assertEquals(0, FunctionsGoneWild2013.f5(20, 3, -4));
      assertEquals(-727, FunctionsGoneWild2013.f5(21, 17, -9));
      assertEquals(-2910, FunctionsGoneWild2013.f5(6, 16, -2));
      assertEquals(0, FunctionsGoneWild2013.f5(19, 0, -1));
      assertEquals(0, FunctionsGoneWild2013.f5(9, 5, -5));
      assertEquals(16918, FunctionsGoneWild2013.f5(24, 17, 0));
   }

   public void testFunctionsGoneWild2013_06()
   {
      assertEquals(362, FunctionsGoneWild2013.f6(0, 2, 2, 1));
      assertEquals(-65, FunctionsGoneWild2013.f6(1, 1, 2, 1));
      assertEquals(-11, FunctionsGoneWild2013.f6(1, 1, 2, 0));
      assertEquals(15, FunctionsGoneWild2013.f6(2, 2, 2, 0));
      assertEquals(128, FunctionsGoneWild2013.f5(4, 2, 2));
      assertEquals(-3, FunctionsGoneWild2013.f6(1, 1, 1, 0));
      assertEquals(-10, FunctionsGoneWild2013.f6(1, 3, 1, 0));
      assertEquals(368, FunctionsGoneWild2013.f6(2, 2, 2, 1));
      assertEquals(-11, FunctionsGoneWild2013.f6(1, 1, 2, 0));
      assertEquals(-2760, FunctionsGoneWild2013.f6(1, 3, 2, 1));
      assertEquals(-2748, FunctionsGoneWild2013.f6(2, 3, 2, 1));
      assertEquals(-24, FunctionsGoneWild2013.f6(1, 3, 2, 0));
      assertEquals(98, FunctionsGoneWild2013.f6(2, 2, 1, 1));
      assertEquals(6, FunctionsGoneWild2013.f6(2, 2, 1, 0));
      assertEquals(90, FunctionsGoneWild2013.f6(1, 2, 1, 1));
      assertEquals(-696, FunctionsGoneWild2013.f6(1, 3, 1, 1));
   }

   public void testFunctionsGoneWild2013_07()
   {
      assertEquals(false, FunctionsGoneWild2013.f7(true, true, true) );
      assertEquals(true, FunctionsGoneWild2013.f7(true, true, false) );
      assertEquals(false, FunctionsGoneWild2013.f7(true, false, true) );
      assertEquals(true, FunctionsGoneWild2013.f7(true, false, false) );

      assertEquals(true, FunctionsGoneWild2013.f7(false, true, true) );
      assertEquals(true, FunctionsGoneWild2013.f7(false, true, false) );
      assertEquals(false, FunctionsGoneWild2013.f7(false, false, true) );
      assertEquals(true, FunctionsGoneWild2013.f7(false, false, false) );
   }

   public void testFunctionsGoneWild2013_08()
   {
      assertEquals(false, FunctionsGoneWild2013.f8(false, false, false, false));
      assertEquals(false, FunctionsGoneWild2013.f8(false, false, false, true));
      assertEquals(false, FunctionsGoneWild2013.f8(false, false, true, false));
      assertEquals(true, FunctionsGoneWild2013.f8(false, false, true, true));
      assertEquals(true, FunctionsGoneWild2013.f8(false, true, false, false));
      assertEquals(false, FunctionsGoneWild2013.f8(false, true, false, true));
      assertEquals(true, FunctionsGoneWild2013.f8(false, true, true, false));
      assertEquals(false, FunctionsGoneWild2013.f8(false, true, true, true));
      
      assertEquals(true, FunctionsGoneWild2013.f8(true, false, false, false));
      assertEquals(true, FunctionsGoneWild2013.f8(true, false, false, true));
      assertEquals(false, FunctionsGoneWild2013.f8(true, false, true, false));
      assertEquals(true, FunctionsGoneWild2013.f8(true, false, true, true));
      assertEquals(false, FunctionsGoneWild2013.f8(true, true, false, false));
      assertEquals(true, FunctionsGoneWild2013.f8(true, true, false, true));
      assertEquals(false, FunctionsGoneWild2013.f8(true, true, true, false));
      assertEquals(true, FunctionsGoneWild2013.f8(true, true, true, true));
   }

   public void testFunctionsGoneWild2013_09()
   {
      assertEquals(-4809.4226, FunctionsGoneWild2013.f9(1, 1, 1.0161217355533148, 4.468885330102669, 5.150232256305315), 0.05);
      assertEquals(5.000151244, FunctionsGoneWild2013.f9(2, 1, 0.31335162598019883, 5.694862383238649, 6.165235071683243), 0.05);
      assertEquals(-139872.34583454885, FunctionsGoneWild2013.f9(1, 2, 2.4019159752387313, 2.5331027229353333, 5.429954177467567), 0.05);
      assertEquals(-362.935816, FunctionsGoneWild2013.f9(1, 1, 1.4757992951617833, 9.82273427807108, 5.893804934293599), 0.05);
      assertEquals(-315.94807889, FunctionsGoneWild2013.f9(2, 1, 1.7799608725253613, 7.849053066675465, 6.644980584398396), 0.05);
      assertEquals(6.09540, FunctionsGoneWild2013.f9(1, 3, 1.0466012012047483, 5.907726348707429, 5.719636545492205), 0.05);
      assertEquals(5.02008, FunctionsGoneWild2013.f9(1, 3, 3.081907451920149, 8.48070834461473, 5.73834502987835), 0.05);
      assertEquals(-2.5982, FunctionsGoneWild2013.f9(1, 1, 1.840602283644518, 7.24317748215876, 5.3071012838440765), 0.05);

      assertEquals(-93.464659, FunctionsGoneWild2013.f9(1, 3, 1.1016883566972724, 7.815675361642028, 6.36681706751818), 0.05);
      assertEquals(-79.75816, FunctionsGoneWild2013.f9(1, 3, 1.8680272122870933, 8.211251220588183, 6.304685714738913), 0.05);
      assertEquals(6.6757916, FunctionsGoneWild2013.f9(1, 2, 4.217984478797364, 0.05505086975929663, 6.710571245284325), 0.05);
      assertEquals(5.063842, FunctionsGoneWild2013.f9(1, 3, 1.127375275896822, 4.988249074923959, 5.606029240525713), 0.05);
   }

   public void testFunctionsGoneWild2013_10()
   {
      assertEquals(true, FunctionsGoneWild2013.f10(false, false, false, false, false));
      assertEquals(false, FunctionsGoneWild2013.f10(false, false, false, false, true));
      assertEquals(true, FunctionsGoneWild2013.f10(false, false, false, true, false));
      assertEquals(true, FunctionsGoneWild2013.f10(false, false, false, true, true) );
      assertEquals(true, FunctionsGoneWild2013.f10(false, false, true, false, false));
      assertEquals(false, FunctionsGoneWild2013.f10(false, false, true, false, true));
      assertEquals(true, FunctionsGoneWild2013.f10(false, false, true, true, false));
      assertEquals(true, FunctionsGoneWild2013.f10(false, false, true, true, true));

      assertEquals(true, FunctionsGoneWild2013.f10(false, true, false, false, false) );
      assertEquals(true, FunctionsGoneWild2013.f10(false, true, false, false, true) );
      assertEquals(false, FunctionsGoneWild2013.f10(false, true, false, true, false) );
      assertEquals(false, FunctionsGoneWild2013.f10(false, true, false, true, true) );

      assertEquals(true, FunctionsGoneWild2013.f10(false, true, true, false, false) );
      assertEquals(true, FunctionsGoneWild2013.f10(false, true, true, false, true) );
      assertEquals(true, FunctionsGoneWild2013.f10(false, true, true, true, false) );
      assertEquals(true, FunctionsGoneWild2013.f10(false, true, true, true, true) );

      assertEquals(true, FunctionsGoneWild2013.f10(true, false, false, false, false) );
      assertEquals(false, FunctionsGoneWild2013.f10(true, false, false, false, true) );
      assertEquals(true, FunctionsGoneWild2013.f10(true, false, false, true, false) );
      assertEquals(true, FunctionsGoneWild2013.f10(true, false, false, true, true) );

      assertEquals(true, FunctionsGoneWild2013.f10(true, false, true, false, false) );
      assertEquals(false, FunctionsGoneWild2013.f10(true, false, true, false, true) );
      assertEquals(true, FunctionsGoneWild2013.f10(true, false, true, true, false) );
      assertEquals(false, FunctionsGoneWild2013.f10(true, false, true, true, true) );

      assertEquals(false, FunctionsGoneWild2013.f10(true, true, false, false, false) );
      assertEquals(false, FunctionsGoneWild2013.f10(true, true, false, false, true) );
      assertEquals(true, FunctionsGoneWild2013.f10(true, true, false, true, false) );
      assertEquals(true, FunctionsGoneWild2013.f10(true, true, false, true, true) );

      assertEquals(true, FunctionsGoneWild2013.f10(true, true, true, false, false) );
      assertEquals(false, FunctionsGoneWild2013.f10(true, true, true, false, true) );
      assertEquals(true, FunctionsGoneWild2013.f10(true, true, true, true, false) );
      assertEquals(false, FunctionsGoneWild2013.f10(true, true, true, true, true) );
    }

   public void testFunctionsGoneWild2013_11()
   {
      testFunctionsGoneWild2013_01();
      testFunctionsGoneWild2013_02();
      testFunctionsGoneWild2013_03();
      testFunctionsGoneWild2013_04();
   }

   public void testFunctionsGoneWild2013_12()
   {
      testFunctionsGoneWild2013_05();
      testFunctionsGoneWild2013_06();
   }

   public void testFunctionsGoneWild2013_13()
   {
      testFunctionsGoneWild2013_07();
      testFunctionsGoneWild2013_08();
      testFunctionsGoneWild2013_09();
      testFunctionsGoneWild2013_10();
   }

   public void testFunctionsGoneWild2013_14()
   {
      testFunctionsGoneWild2013_11();
      testFunctionsGoneWild2013_12();
      testFunctionsGoneWild2013_13();
   }

/*
 *    Peters Peppers Testers
 */   
   
   public void testPetersPeppers01()
   {
      PetersPeppers pp = new PetersPeppers();
      assertEquals(new Triple(-1,-1,-1), pp.getTriple(1));

      assertEquals(new Triple(1, 0, 0), pp.getTriple(6));
      assertEquals(new Triple(0, 5, 0), pp.getTriple(55));
      assertEquals(new Triple(-1,-1,-1), pp.getTriple(27));
      assertEquals(new Triple(2, 1, 5), pp.getTriple(88));
      assertEquals(new Triple(3, 1, 1), pp.getTriple(42));
    }

   public void testPetersPeppers02()
   {
      PetersPeppers pp = new PetersPeppers();
      assertEquals(new Triple(-1,-1,-1), pp.getTriple(2));
      assertEquals(new Triple(-1,-1,-1), pp.getTriple(3));
      assertEquals(new Triple(-1,-1,-1), pp.getTriple(4));
      assertEquals(new Triple(-1,-1,-1), pp.getTriple(5));

      assertEquals(new Triple(0, 1, 0), pp.getTriple(11));
      assertEquals(new Triple(0, 0, 1), pp.getTriple(13));
      assertEquals(new Triple(1, 1, 0), pp.getTriple(6+11));
      assertEquals(new Triple(0, 1, 1), pp.getTriple(11+13));
      assertEquals(new Triple(1, 0, 1), pp.getTriple(6+13));
      assertEquals(new Triple(1, 1, 1), pp.getTriple(6+11+13));
    }

   public void testPetersPeppers03()
   {
      PetersPeppers pp = new PetersPeppers();
      assertEquals(new Triple(-1,-1,-1), pp.getTriple(7));
      assertEquals(new Triple(-1,-1,-1), pp.getTriple(8));
      assertEquals(new Triple(-1,-1,-1), pp.getTriple(9));
      assertEquals(new Triple(-1,-1,-1), pp.getTriple(10));

      assertEquals(new Triple(2, 0, 0), pp.getTriple(12));
      assertEquals(new Triple(0, 2, 0), pp.getTriple(22));
      assertEquals(new Triple(0, 0, 2), pp.getTriple(26));
      assertEquals(new Triple(2, 0, 2), pp.getTriple(12+26));
      assertEquals(new Triple(2, 2, 0), pp.getTriple(12+22));
      assertEquals(new Triple(0, 2, 2), pp.getTriple(22+26));
      assertEquals(new Triple(2, 2, 2), pp.getTriple(12+22+26));
    }

   public void testPetersPeppers04()
   {
      PetersPeppers pp = new PetersPeppers();
      assertEquals(new Triple(-1,-1,-1), pp.getTriple(14));
      assertEquals(new Triple(-1,-1,-1), pp.getTriple(15));
      assertEquals(new Triple(-1,-1,-1), pp.getTriple(16));
      assertEquals(new Triple(-1,-1,-1), pp.getTriple(20));
      assertEquals(new Triple(-1,-1,-1), pp.getTriple(21));

      assertEquals(new Triple(2, 1, 1), pp.getTriple(12+11+13));
      assertEquals(new Triple(2, 1, 0), pp.getTriple(12+11));
      assertEquals(new Triple(2, 0, 1), pp.getTriple(12+13));
      assertEquals(new Triple(1, 2, 1), pp.getTriple(6+22+13));
      assertEquals(new Triple(0, 2, 1), pp.getTriple(22+13));
      assertEquals(new Triple(1, 2, 0), pp.getTriple(6+22));
      assertEquals(new Triple(0, 0, 2), pp.getTriple(26));
      assertEquals(new Triple(1, 1, 2), pp.getTriple(6+11+26));
      assertEquals(new Triple(0, 1, 2), pp.getTriple(11+26));
      assertEquals(new Triple(1, 0, 2), pp.getTriple(6+26));
      assertEquals(new Triple(2, 1, 2), pp.getTriple(12+11+26));
      assertEquals(new Triple(2, 2, 1), pp.getTriple(12+22+13));
      assertEquals(new Triple(1, 2, 2), pp.getTriple(6+22+26));
   }

   public void testPetersPeppers05()
   {
      PetersPeppers pp = new PetersPeppers();
      assertEquals(new Triple(2, 2, 1), pp.getTriple(47));
      assertEquals(new Triple(0, 0, 4), pp.getTriple(52));
      assertEquals(new Triple(0, 4, 1), pp.getTriple(57));
      assertEquals(new Triple(0, 1, 4), pp.getTriple(63));
      assertEquals(new Triple(0, 0, 5), pp.getTriple(65));
      assertEquals(new Triple(0, 4, 2), pp.getTriple(70));
      assertEquals(new Triple(1, 0, 5), pp.getTriple(71));
      assertEquals(new Triple(2, 1, 4), pp.getTriple(75));
      assertEquals(new Triple(0, 1, 5), pp.getTriple(76));
      assertEquals(new Triple(1, 0, 6), pp.getTriple(84));
      assertEquals(new Triple(0, 2, 5), pp.getTriple(87));
      assertEquals(new Triple(1, 1, 6), pp.getTriple(95));
      assertEquals(new Triple(0, 6, 1), pp.getTriple(79));
   }

   public void testPetersPeppers06()
   {
      PetersPeppers pp = new PetersPeppers();
      assertEquals(new Triple(0, 2, 6), pp.getTriple(100));
      assertEquals(new Triple(1, 0, 8), pp.getTriple(110));
      assertEquals(new Triple(1, 1, 8), pp.getTriple(121));
      assertEquals(new Triple(0, 3, 7), pp.getTriple(124));
      assertEquals(new Triple(2, 1, 8), pp.getTriple(127));
      assertEquals(new Triple(1, 2, 8), pp.getTriple(132));
      assertEquals(new Triple(2, 0, 10), pp.getTriple(142));
      assertEquals(new Triple(0, 2, 10), pp.getTriple(152));
      assertEquals(new Triple(2, 0, 12), pp.getTriple(168));
      assertEquals(new Triple(0, 6, 8), pp.getTriple(170));
      assertEquals(new Triple(0, 3, 11), pp.getTriple(176));
      assertEquals(new Triple(0, 1, 13), pp.getTriple(180));
      assertEquals(new Triple(1, 1, 13), pp.getTriple(186));
      assertEquals(new Triple(0, 5, 11), pp.getTriple(198));
   }

   public void testPetersPeppers07()
   {
      PetersPeppers pp = new PetersPeppers();
      assertEquals(new Triple(1, 2, 14), pp.getTriple(210));
      assertEquals(new Triple(1, 1, 15), pp.getTriple(212));
      assertEquals(new Triple(1, 0, 16), pp.getTriple(214));
      assertEquals(new Triple(0, 3, 14), pp.getTriple(215));
      assertEquals(new Triple(2, 1, 15), pp.getTriple(218));
      assertEquals(new Triple(2, 0, 16), pp.getTriple(220));
      assertEquals(new Triple(1, 2, 15), pp.getTriple(223));
      assertEquals(new Triple(0, 3, 15), pp.getTriple(228));
      assertEquals(new Triple(2, 2, 15), pp.getTriple(229));
      assertEquals(new Triple(0, 0, 18), pp.getTriple(234));
      assertEquals(new Triple(2, 0, 18), pp.getTriple(246));
      assertEquals(new Triple(0, 6, 14), pp.getTriple(248));
   }

   public void testPetersPeppers08()
   {
      PetersPeppers pp = new PetersPeppers();
      assertEquals(new Triple(1, 1, 18), pp.getTriple(251));
      assertEquals(new Triple(0, 3, 17), pp.getTriple(254));
      assertEquals(new Triple(0, 4, 17), pp.getTriple(265));
      assertEquals(new Triple(0, 2, 19), pp.getTriple(269));
      assertEquals(new Triple(2, 0, 20), pp.getTriple(272));
      assertEquals(new Triple(0, 5, 17), pp.getTriple(276));
      assertEquals(new Triple(0, 4, 18), pp.getTriple(278));
      assertEquals(new Triple(2, 0, 21), pp.getTriple(285));
      assertEquals(new Triple(1, 2, 20), pp.getTriple(288));
      assertEquals(new Triple(0, 3, 20), pp.getTriple(293));
      assertEquals(new Triple(2, 2, 20), pp.getTriple(294));
   }

   public void testPetersPeppers09()
   {
      PetersPeppers pp = new PetersPeppers();
      assertEquals(new Triple(0, 6, 19), pp.getTriple(313));
      assertEquals(new Triple(1, 1, 23), pp.getTriple(316));
      assertEquals(new Triple(0, 4, 21), pp.getTriple(317));
      assertEquals(new Triple(0, 3, 22), pp.getTriple(319));
      assertEquals(new Triple(0, 6, 20), pp.getTriple(326));
      assertEquals(new Triple(0, 3, 23), pp.getTriple(332));
      assertEquals(new Triple(0, 1, 25), pp.getTriple(336));
      assertEquals(new Triple(1, 0, 26), pp.getTriple(344));
      assertEquals(new Triple(0, 2, 25), pp.getTriple(347));
      assertEquals(new Triple(0, 1, 27), pp.getTriple(362));
      assertEquals(new Triple(1, 2, 26), pp.getTriple(366));
      assertEquals(new Triple(1, 1, 27), pp.getTriple(368));
      assertEquals(new Triple(0, 2, 27), pp.getTriple(373));
      assertEquals(new Triple(2, 1, 27), pp.getTriple(374));
      assertEquals(new Triple(0, 1, 29), pp.getTriple(388));
      assertEquals(new Triple(0, 0, 30), pp.getTriple(390));
      assertEquals(new Triple(0, 6, 25), pp.getTriple(391));
      assertEquals(new Triple(1, 1, 29), pp.getTriple(394));
   }

   public void testPetersPeppers10()
   {
      PetersPeppers pp = new PetersPeppers();
      assertEquals(new Triple(2, 1, 29), pp.getTriple(400));
      assertEquals(new Triple(0, 6, 26), pp.getTriple(404));
      assertEquals(new Triple(2, 2, 29), pp.getTriple(411));
      assertEquals(new Triple(2, 0, 31), pp.getTriple(415));
      assertEquals(new Triple(0, 6, 27), pp.getTriple(417));
      assertEquals(new Triple(0, 1, 33), pp.getTriple(440));
      assertEquals(new Triple(2, 1, 33), pp.getTriple(452));
      assertEquals(new Triple(2, 0, 34), pp.getTriple(454));
      assertEquals(new Triple(0, 0, 35), pp.getTriple(455));
      assertEquals(new Triple(0, 6, 30), pp.getTriple(456));
      assertEquals(new Triple(0, 2, 34), pp.getTriple(464));
      assertEquals(new Triple(0, 1, 35), pp.getTriple(466));
      assertEquals(new Triple(2, 0, 35), pp.getTriple(467));
      assertEquals(new Triple(0, 0, 36), pp.getTriple(468));
      assertEquals(new Triple(0, 6, 31), pp.getTriple(469));
      assertEquals(new Triple(0, 4, 33), pp.getTriple(473));
      assertEquals(new Triple(0, 2, 35), pp.getTriple(477));
      assertEquals(new Triple(0, 0, 37), pp.getTriple(481));
      assertEquals(new Triple(1, 2, 35), pp.getTriple(483));
      assertEquals(new Triple(1, 0, 37), pp.getTriple(487));
      assertEquals(new Triple(0, 0, 38), pp.getTriple(494));
      assertEquals(new Triple(1, 1, 37), pp.getTriple(498));

      assertEquals(new Triple(1, 0, 38), pp.getTriple(500));
      assertEquals(new Triple(2, 2, 36), pp.getTriple(502));
      assertEquals(new Triple(2, 0, 38), pp.getTriple(506));
      assertEquals(new Triple(0, 6, 34), pp.getTriple(508));
      assertEquals(new Triple(2, 2, 38), pp.getTriple(528));
      assertEquals(new Triple(2, 0, 40), pp.getTriple(532));
      assertEquals(new Triple(0, 5, 37), pp.getTriple(536));
      assertEquals(new Triple(0, 4, 38), pp.getTriple(538));
      assertEquals(new Triple(0, 1, 41), pp.getTriple(544));
      assertEquals(new Triple(0, 3, 40), pp.getTriple(553));
      assertEquals(new Triple(2, 1, 43), pp.getTriple(582));
      assertEquals(new Triple(1, 2, 43), pp.getTriple(587));
      assertEquals(new Triple(2, 2, 43), pp.getTriple(593));
   }
/*
 *     HP Cipher Testers
 */
   public void testHPCipher01()
   {
      HPCipher hp = new HPCipher("P JVKL AOLYLMVYL P HT");
      assertEquals(4, hp.letterDifference("A", "E"));
      assertEquals(2, hp.letterDifference("Z", "B"));
      assertEquals("I CODE THEREFORE I AM", hp.decode("IA"));
      assertEquals("I CODE THEREFORE I AM", hp.decode("DETH"));

      hp = new HPCipher("HIGSHI QI");
      assertEquals("DECODE ME", hp.decode("EM"));
      assertEquals("DECODE ME", hp.decode("DE"));
    }

   public void testHPCipher02()
   {
      HPCipher hp = new HPCipher("XYVOIC ERH FSCWIRFIVVC SR VCI AMXL E WMHI SJ XYRE WEPEH");
      assertEquals(1, hp.letterDifference("A", "B"));
      assertEquals(2, hp.letterDifference("A", "C"));
      assertEquals(3, hp.letterDifference("A", "D"));
      assertEquals(4, hp.letterDifference("A", "E"));
      assertEquals(5, hp.letterDifference("A", "F"));
      assertEquals(6, hp.letterDifference("A", "G"));
      assertEquals(7, hp.letterDifference("A", "H"));
      assertEquals(8, hp.letterDifference("A", "I"));
      assertEquals(9, hp.letterDifference("A", "J"));
      assertEquals(10, hp.letterDifference("A", "K"));
      assertEquals(11, hp.letterDifference("A", "L"));
      assertEquals(12, hp.letterDifference("A", "M"));
      assertEquals(13, hp.letterDifference("A", "N"));
      assertEquals(14, hp.letterDifference("A", "O"));
      assertEquals(15, hp.letterDifference("A", "P"));
      assertEquals(16, hp.letterDifference("A", "Q"));
      assertEquals(17, hp.letterDifference("A", "R"));
      assertEquals(18, hp.letterDifference("A", "S"));
      assertEquals(19, hp.letterDifference("A", "T"));
      assertEquals(20, hp.letterDifference("A", "U"));
      assertEquals(21, hp.letterDifference("A", "V"));
      assertEquals(22, hp.letterDifference("A", "W"));
      assertEquals(23, hp.letterDifference("A", "X"));
      assertEquals(24, hp.letterDifference("A", "Y"));
      assertEquals(25, hp.letterDifference("A", "Z"));
    }

   public void testHPCipher03()
   {
      HPCipher hp = new HPCipher("XYVOIC ERH FSCWIRFIVVC SR VCI AMXL E WMHI SJ XYRE WEPEH");
      assertEquals(2, hp.letterDifference("Z", "B"));
      assertEquals(3, hp.letterDifference("Z", "C"));
      assertEquals(4, hp.letterDifference("Z", "D"));
      assertEquals(5, hp.letterDifference("Z", "E"));
      assertEquals(6, hp.letterDifference("Z", "F"));
      assertEquals(7, hp.letterDifference("Z", "G"));
      assertEquals(8, hp.letterDifference("Z", "H"));
      assertEquals(9, hp.letterDifference("Z", "I"));
      assertEquals(10, hp.letterDifference("Z", "J"));
      assertEquals(11, hp.letterDifference("Z", "K"));
      assertEquals(12, hp.letterDifference("Z", "L"));
      assertEquals(13, hp.letterDifference("Z", "M"));
      assertEquals(14, hp.letterDifference("Z", "N"));
      assertEquals(15, hp.letterDifference("Z", "O"));
      assertEquals(16, hp.letterDifference("Z", "P"));
      assertEquals(17, hp.letterDifference("Z", "Q"));
      assertEquals(18, hp.letterDifference("Z", "R"));
      assertEquals(19, hp.letterDifference("Z", "S"));
      assertEquals(20, hp.letterDifference("Z", "T"));
      assertEquals(21, hp.letterDifference("Z", "U"));
      assertEquals(22, hp.letterDifference("Z", "V"));
      assertEquals(23, hp.letterDifference("Z", "W"));
      assertEquals(24, hp.letterDifference("Z", "X"));
      assertEquals(25, hp.letterDifference("Z", "Y"));
      assertEquals(1, hp.letterDifference("Z", "A"));
    }

   public void testHPCipher04()
   {
      testHPCipher01();
      testHPCipher02();
      testHPCipher03();
      HPCipher hp = new HPCipher("XYVOIC ERH FSCWIRFIVVC SR VCI AMXL E WMHI SJ XYRE WEPEH");
      assertEquals(0, hp.letterDifference("Z", "Z"));
      assertEquals(0, hp.letterDifference("A", "A"));
      assertEquals(0, hp.letterDifference("D", "D"));
      assertEquals(5, hp.letterDifference("Q", "V"));
      assertEquals(6, hp.letterDifference("E", "K"));
      assertEquals(7, hp.letterDifference("C", "J"));
      assertEquals(8, hp.letterDifference("Y", "G"));
      assertEquals(9, hp.letterDifference("X", "G"));
      assertEquals(10, hp.letterDifference("V", "F"));
      assertEquals(11, hp.letterDifference("W", "H"));
      assertEquals(12, hp.letterDifference("I", "U"));
      assertEquals(7, hp.letterDifference("S", "Z"));
      assertEquals(4, hp.letterDifference("Q", "U"));
      assertEquals(24, hp.letterDifference("B", "Z"));
    }

   public void testHPCipher05()     //  NO SPACE - 
   {
       testHPCipher04();
       testHPCipher03();
       testHPCipher02();
   }

   public void testHPCipher06()  //  NO SPACES  -  NO END OF WORDS
   {
      HPCipher hp = new HPCipher("IUSVAZKX");
      assertEquals("COMPUTER", hp.decode("MP"));

      hp = new HPCipher("QSPHSBNNJOH");
      assertEquals("PROGRAMMING", hp.decode("RO"));

      hp = new HPCipher("YABEIJK");
      assertEquals("ACDGKLM", hp.decode("DG"));
      assertEquals("ACDGKLM", hp.decode("AC"));

      hp = new HPCipher("LLOSTWYZLOSTWYZ");
      assertEquals("AADHILNOADHILNO", hp.decode("OA"));

      hp = new HPCipher("ZABCFGKLPRSUVWRSUV");
      assertEquals("HIJKNOSTXZACDEZACD", hp.decode("XZ"));

      hp = new HPCipher("ONJHMEDTYXQI");
      assertEquals("WVRPUMLBGFYQ", hp.decode("RP"));
      assertEquals("WVRPUMLBGFYQ", hp.decode("VRP"));
      assertEquals("WVRPUMLBGFYQ", hp.decode("VRP"));
      assertEquals("WVRPUMLBGFYQ", hp.decode("VRPU"));
      assertEquals("WVRPUMLBGFYQ", hp.decode("LBGFY"));
    }

   public void testHPCipher07()     //  SPACE - no end of words
   {
      HPCipher hp = new HPCipher("QSPHSBNNJO H");
      assertEquals("PROGRAMMIN G", hp.decode("IN"));

      hp = new HPCipher("IU SVA ZKX");
      assertEquals("CO MPU TER", hp.decode("MP"));

      hp = new HPCipher("Q SPHSBNNJO H");
      assertEquals("P ROGRAMMIN G", hp.decode("RO"));

      hp = new HPCipher("YABE IJK");
      assertEquals("ACDG KLM", hp.decode("DG"));
      assertEquals("ACDG KLM", hp.decode("AC"));

      hp = new HPCipher("LLO STWY ZLOST WY Z");
      assertEquals("AAD HILN OADHI LN O", hp.decode("OA"));

      hp = new HPCipher("Z A B C F G K L P R S U V W R S U V");
      assertEquals("H I J K N O S T X Z A C D E Z A C D", hp.decode("XZ"));

      hp = new HPCipher("ON J HME D TYXQ I");
      assertEquals("WV R PUM L BGFY Q", hp.decode("RP"));
      assertEquals("WV R PUM L BGFY Q", hp.decode("VRP"));
      assertEquals("WV R PUM L BGFY Q", hp.decode("VRP"));
      assertEquals("WV R PUM L BGFY Q", hp.decode("VRPU"));
      assertEquals("WV R PUM L BGFY Q", hp.decode("LBGFY"));
    }


   public void testHPCipher08()     //  SPACE - end of words
   {
      HPCipher hp = new HPCipher("QSPHSBNNJOH");
      assertEquals("PROGRAMMING", hp.decode("NG"));

      hp = new HPCipher("IU SVA ZKX");
      assertEquals("CO MPU TER", hp.decode("UT"));
      assertEquals("CO MPU TER", hp.decode("ER"));

      hp = new HPCipher("Q SPHSBNNJO H");
      assertEquals("P ROGRAMMIN G", hp.decode("PR"));

      hp = new HPCipher("YABE IJK");
      assertEquals("ACDG KLM", hp.decode("GK"));
      assertEquals("ACDG KLM", hp.decode("GKLM"));

      hp = new HPCipher("LLO STWY ZLOST WY Z");
      assertEquals("AAD HILN OADHI LN O", hp.decode("ILNO"));

      hp = new HPCipher("Z A B C F G K L P R S U V W R S U V");
      assertEquals("H I J K N O S T X Z A C D E Z A C D", hp.decode("EZACD"));
      assertEquals("H I J K N O S T X Z A C D E Z A C D", hp.decode("HIJKN"));

      hp = new HPCipher("ON J HME D TYXQ I");
      assertEquals("WV R PUM L BGFY Q", hp.decode("RP"));
      assertEquals("WV R PUM L BGFY Q", hp.decode("VRP"));
      assertEquals("WV R PUM L BGFY Q", hp.decode("VRP"));
      assertEquals("WV R PUM L BGFY Q", hp.decode("VRPU"));
      assertEquals("WV R PUM L BGFY Q", hp.decode("LBGFY"));
    }

   public void testHPCipher09()
   {
       testHPCipher07();
       testHPCipher06();
       testHPCipher08();
   }

   public void testHPCipher10()
   {
      HPCipher hp = new HPCipher("XYVOIC ERH FSCWIRFIVVC SR VCI AMXL E WMHI SJ XYRE WEPEH");
      assertEquals(4, hp.letterDifference("A", "E"));
      assertEquals(2, hp.letterDifference("Z", "B"));
      assertEquals("TURKEY AND BOYSENBERRY ON RYE WITH A SIDE OF TUNA SALAD", hp.decode("YONR"));

      testHPCipher05();
      testHPCipher09();
   }

}