import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TextMessagingTest extends junit.framework.TestCase
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
}