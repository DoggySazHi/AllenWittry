import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TextMessagingFinalTest extends junit.framework.TestCase
{
   public void testTextMessaging01()
   {
      TextMessaging tx = new TextMessaging();

      tx.addTableEntry( new TableEntry("i", 8));
      tx.addTableEntry( new TableEntry("am", 2));
      tx.addTableEntry( new TableEntry("art", 1));

      assertEquals("i", tx.getWord("4"));
      assertEquals("am", tx.getWord("26"));
      assertEquals("i am art", tx.getTextMessage("4 26 278"));

      tx = new TextMessaging();

      tx.addTableEntry( new TableEntry("i", 8));
      tx.addTableEntry( new TableEntry("that", 7));
      tx.addTableEntry( new TableEntry("is", 6));
      tx.addTableEntry( new TableEntry("an", 4));
      tx.addTableEntry( new TableEntry("am", 2));
      tx.addTableEntry( new TableEntry("artist", 1));

      assertEquals("i", tx.getWord("4"));
      assertEquals("am", tx.getWord("26"));
      assertEquals("an", tx.getWord("260"));
      assertEquals("artist", tx.getWord("278478"));
      assertEquals("i am an artist", tx.getTextMessage("4 26 260 278478"));
   }

   public void testTextMessaging02()
   {
      TextMessaging tx = new TextMessaging();

      tx.addTableEntry( new TableEntry("are", 3));
      tx.addTableEntry( new TableEntry("cre", 13));
      tx.addTableEntry( new TableEntry("ase", 8));
      tx.addTableEntry( new TableEntry("you", 2));
      tx.addTableEntry( new TableEntry("your", 2));

      tx.addTableEntry( new TableEntry("what", 3));
      tx.addTableEntry( new TableEntry("why", 15));
      tx.addTableEntry( new TableEntry("when", 8));
      tx.addTableEntry( new TableEntry("thin", 22));
      tx.addTableEntry( new TableEntry("were", 1));

      assertEquals("are", tx.getWord("273"));
      assertEquals("ase", tx.getWord("2730"));
      assertEquals("cre", tx.getWord("27300"));
      assertEquals("you", tx.getWord("968"));
      assertEquals("why", tx.getWord("949"));
    }

   public void testTextMessaging03()
   {
      TextMessaging tx = new TextMessaging();

      tx.addTableEntry( new TableEntry("are", 3));
      tx.addTableEntry( new TableEntry("cre", 13));
      tx.addTableEntry( new TableEntry("ase", 8));
      tx.addTableEntry( new TableEntry("you", 2));
      tx.addTableEntry( new TableEntry("your", 2));

      tx.addTableEntry( new TableEntry("what", 3));
      tx.addTableEntry( new TableEntry("why", 15));
      tx.addTableEntry( new TableEntry("when", 8));
      tx.addTableEntry( new TableEntry("thin", 22));
      tx.addTableEntry( new TableEntry("were", 1));

      assertEquals("were", tx.getWord("9373"));
      assertEquals("your", tx.getWord("9687"));
      assertEquals("what", tx.getWord("9428"));
      assertEquals("when", tx.getWord("9436"));
      assertEquals("thin", tx.getWord("8446"));
    }

   public void testTextMessaging04()
   {
      TextMessaging tx = new TextMessaging();

      tx.addTableEntry( new TableEntry("are", 3));
      tx.addTableEntry( new TableEntry("cre", 13));
      tx.addTableEntry( new TableEntry("ase", 8));
      tx.addTableEntry( new TableEntry("you", 2));
      tx.addTableEntry( new TableEntry("cab", 12));

      tx.addTableEntry( new TableEntry("your", 32));
      tx.addTableEntry( new TableEntry("zotr", 22));
      tx.addTableEntry( new TableEntry("whqt", 3));
      tx.addTableEntry( new TableEntry("why", 15));
      tx.addTableEntry( new TableEntry("when", 8));
      tx.addTableEntry( new TableEntry("thin", 22));
      tx.addTableEntry( new TableEntry("were", 1));
      tx.addTableEntry( new TableEntry("wotr", 17));
      tx.addTableEntry( new TableEntry("xmvs", 7));
      tx.addTableEntry( new TableEntry("wnvp", 11));

      assertEquals("xmvs", tx.getWord("9687"));
      assertEquals("wnvp", tx.getWord("96870"));
      assertEquals("wotr", tx.getWord("968700"));
      assertEquals("zotr", tx.getWord("9687000"));
      assertEquals("your", tx.getWord("96870000"));

      tx.addTableEntry( new TableEntry("zmuq", 4));
      assertEquals("zmuq", tx.getWord("9687"));
      assertEquals("xmvs", tx.getWord("96870"));
      assertEquals("wnvp", tx.getWord("968700"));
      assertEquals("wotr", tx.getWord("9687000"));
      assertEquals("zotr", tx.getWord("96870000"));
      assertEquals("your", tx.getWord("968700000"));
    }

   public void testTextMessaging05()
   {
      TextMessaging tx = new TextMessaging();

      tx.addTableEntry( new TableEntry("are", 3));
      tx.addTableEntry( new TableEntry("you", 2));
      tx.addTableEntry( new TableEntry("cab", 12));
      tx.addTableEntry( new TableEntry("why", 15));

      tx.addTableEntry( new TableEntry("your", 32));
      tx.addTableEntry( new TableEntry("when", 8));
      tx.addTableEntry( new TableEntry("thin", 22));
      tx.addTableEntry( new TableEntry("were", 1));

      tx.addTableEntry( new TableEntry("the", 31));
      tx.addTableEntry( new TableEntry("quick", 13));
      tx.addTableEntry( new TableEntry("brown", 17));
      tx.addTableEntry( new TableEntry("fox", 23));
      tx.addTableEntry( new TableEntry("is", 23));
      tx.addTableEntry( new TableEntry("also", 32));
      tx.addTableEntry( new TableEntry("incredibily", 23));
      tx.addTableEntry( new TableEntry("fast", 1));

      assertEquals("the quick brown fox is also incredibily fast",
              tx.getTextMessage("843 78425 27696 369 47 2576 46273342459 3278"));
    }

   public void testTextMessaging06()
   {
      TextMessaging tx = new TextMessaging();

      tx.addTableEntry( new TableEntry("are", 3));
      tx.addTableEntry( new TableEntry("you", 2));
      tx.addTableEntry( new TableEntry("cab", 12));
      tx.addTableEntry( new TableEntry("why", 15));

      tx.addTableEntry( new TableEntry("your", 32));
      tx.addTableEntry( new TableEntry("when", 8));
      tx.addTableEntry( new TableEntry("thin", 22));
      tx.addTableEntry( new TableEntry("were", 1));

      tx.addTableEntry( new TableEntry("the", 31));
      tx.addTableEntry( new TableEntry("quick", 13));
      tx.addTableEntry( new TableEntry("brown", 17));
      tx.addTableEntry( new TableEntry("fox", 23));
      tx.addTableEntry( new TableEntry("is", 23));
      tx.addTableEntry( new TableEntry("also", 32));
      tx.addTableEntry( new TableEntry("incredibily", 23));
      tx.addTableEntry( new TableEntry("fast", 1));

      assertEquals("the quick brown fox is also incredibily fast",
              tx.getTextMessage("843 78425 27696 369 47 2576 46273342459 3278"));

      tx.addTableEntry( new TableEntry("usc", 100));
      tx.addTableEntry( new TableEntry("i", 2));
      tx.addTableEntry( new TableEntry("a", 1));
      tx.addTableEntry( new TableEntry("better", 15));
      tx.addTableEntry( new TableEntry("school", 11));
      tx.addTableEntry( new TableEntry("than", 22));
      tx.addTableEntry( new TableEntry("ucla", 22));
      assertEquals("usc is a better school than ucla",
              tx.getTextMessage("872 47 2 238837 724665 8426 8252"));

      tx.addTableEntry( new TableEntry("qwerty", 13));
      tx.addTableEntry( new TableEntry("keyboards", 13));
      tx.addTableEntry( new TableEntry("union", 41));
      tx.addTableEntry( new TableEntry("programs", 8));
      tx.addTableEntry( new TableEntry("before", 19));
      tx.addTableEntry( new TableEntry("hicups", 24));
      tx.addTableEntry( new TableEntry("jumps", 4));
      tx.addTableEntry( new TableEntry("belong", 14));
      tx.addTableEntry( new TableEntry("to", 3));
      tx.addTableEntry( new TableEntry("zoo", 3));
      tx.addTableEntry( new TableEntry("know", 3));
      assertEquals("qwerty keyboards union programs before hicups jumps belong to a zoo i know",
              tx.getTextMessage("793789 539262737 86466 77647267 233673 442877 58677 235664 86 2 966 4 5669"));

      tx.addTableEntry( new TableEntry("ghoti", 75));
      tx.addTableEntry( new TableEntry("another", 53));
      tx.addTableEntry( new TableEntry("way", 37));
      tx.addTableEntry( new TableEntry("spell", 34));
      tx.addTableEntry( new TableEntry("fish", 26));
      assertEquals("ghoti is another way to spell fish",
              tx.getTextMessage("44684 47 2668437 929 86 77355 3474"));
   }

   public void testTextMessaging07()
   {
      TextMessaging tx = new TextMessaging();

      tx.addTableEntry( new TableEntry("are", 3));
      tx.addTableEntry( new TableEntry("you", 2));
      tx.addTableEntry( new TableEntry("cab", 12));
      tx.addTableEntry( new TableEntry("why", 15));

      tx.addTableEntry( new TableEntry("your", 32));
      tx.addTableEntry( new TableEntry("when", 8));
      tx.addTableEntry( new TableEntry("thin", 22));
      tx.addTableEntry( new TableEntry("were", 1));

      tx.addTableEntry( new TableEntry("the", 31));
      tx.addTableEntry( new TableEntry("quick", 13));
      tx.addTableEntry( new TableEntry("brown", 17));
      tx.addTableEntry( new TableEntry("fox", 23));
      tx.addTableEntry( new TableEntry("is", 23));
      tx.addTableEntry( new TableEntry("also", 32));
      tx.addTableEntry( new TableEntry("incredibily", 23));
      tx.addTableEntry( new TableEntry("fast", 1));

      assertEquals("the quick brown fox is also incredibily fast",
              tx.getTextMessage("843 78425 27696 369 47 2576 46273342459 3278"));

      tx.addTableEntry( new TableEntry("usc", 100));
      tx.addTableEntry( new TableEntry("i", 3));
      tx.addTableEntry( new TableEntry("a", 2));
      tx.addTableEntry( new TableEntry("b", 1));
      tx.addTableEntry( new TableEntry("better", 15));
      tx.addTableEntry( new TableEntry("school", 11));
      tx.addTableEntry( new TableEntry("than", 22));
      tx.addTableEntry( new TableEntry("ucla", 22));
      tx.addTableEntry( new TableEntry("this", 12));
      tx.addTableEntry( new TableEntry("really", 27));
      tx.addTableEntry( new TableEntry("cool", 41));
      tx.addTableEntry( new TableEntry("contest", 41));
      assertEquals("this is a really cool contest",
              tx.getTextMessage("8447 47 20 732559 2665 2668378"));

      tx.addTableEntry( new TableEntry("dodgers", 13));
      tx.addTableEntry( new TableEntry("angels", 13));
      tx.addTableEntry( new TableEntry("union", 41));
      tx.addTableEntry( new TableEntry("lakers", 8));
      tx.addTableEntry( new TableEntry("clippers", 19));
      tx.addTableEntry( new TableEntry("trojans", 24));
      tx.addTableEntry( new TableEntry("jumps", 4));
      tx.addTableEntry( new TableEntry("belong", 14));
      tx.addTableEntry( new TableEntry("to", 3));
      tx.addTableEntry( new TableEntry("zoo", 3));
      tx.addTableEntry( new TableEntry("know", 3));
      assertEquals("dodgers angels lakers clippers trojans",
              tx.getTextMessage("3634377 264357 525377 25477377 8765267"));

      tx.addTableEntry( new TableEntry("your", 32));
      tx.addTableEntry( new TableEntry("zotr", 22));
      tx.addTableEntry( new TableEntry("wotr", 17));
      tx.addTableEntry( new TableEntry("xmvs", 7));
      tx.addTableEntry( new TableEntry("wnvp", 11));
      tx.addTableEntry( new TableEntry("zmuq", 4));
      tx.addTableEntry( new TableEntry("iq", 40));

      assertEquals("zmuq", tx.getWord("9687"));
      assertEquals("xmvs", tx.getWord("96870"));
      assertEquals("wnvp", tx.getWord("968700"));
      assertEquals("wotr", tx.getWord("9687000"));
      assertEquals("zotr", tx.getWord("96870000"));
      assertEquals("your", tx.getWord("968700000"));

      assertEquals("your zmuq a wotr b dodgers your zotr is zmuq iq",
            tx.getTextMessage("968700000 9687 20 9687000 2 3634377 968700000 96870000 47 9687 470"));
   }

   public void testTextMessaging08()
   {
      testTextMessaging02();
      testTextMessaging04();
      testTextMessaging06();
   }

   public void testTextMessaging09()
   {
      testTextMessaging03();
      testTextMessaging05();
   }

   public void testTextMessaging10()
   {
      testTextMessaging08();
      testTextMessaging09();
   }
}