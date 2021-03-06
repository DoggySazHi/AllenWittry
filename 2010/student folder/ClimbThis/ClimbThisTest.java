import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  (your name)
 * @version 2010 Programming Contest
 */
public class ClimbThisTest extends junit.framework.TestCase
{
   public void testClimbThis01()
   {
      ClimbThis ladder = new ClimbThis( );
      ArrayList<String> words = new ArrayList<String>();
      words.add("BOY");
      words.add("TOY");
      words.add("TOE");
      assertEquals(true, ladder.isLadder(words));

      ladder = new ClimbThis( );
      words = new ArrayList<String>();
      words.add("HEAD");
      words.add("HEAL");
      words.add("VEAL");
      words.add("VEIL");
      words.add("VAIL");
      words.add("TAIL");
      assertEquals(true, ladder.isLadder(words));

      ladder = new ClimbThis( );
      words = new ArrayList<String>();
      words.add("CAME");
      words.add("CARE");
      words.add("CANT");
      words.add("WENT");
      assertEquals(false, ladder.isLadder(words));
   }
}