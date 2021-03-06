import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  Don Allen
 * @version 2010 programming contest
 */
public class FinalSetTest extends junit.framework.TestCase
{
   public void testGameSet01()
   {
      Card c1 = new Card (1, "square" , "red", "clear");
      Card c2 = new Card (2, "square" , "red", "clear");
      Card c3 = new Card (3, "square" , "red", "clear");
      Card c4 = new Card (1, "square" , "blue", "clear");

      assertEquals(true, GameSet.isSet(c1, c2, c3));
      assertEquals(false, GameSet.isSet(c1, c2, c4));

      assertEquals(c3, GameSet.makeSet(c1, c2));

      Card[] temp = {  new Card(2, "square", "red", "dashed"),
                        new Card(2, "circle", "green", "dashed"),
                        new Card(3, "square", "red", "dashed"),
                        new Card(2, "triangle", "blue", "solid"),
                        new Card(2, "triangle", "green", "clear"),
                        new Card(3, "square", "blue", "dashed"),
                        new Card(1, "square", "blue", "dashed"),
                        new Card(3, "circle", "red", "clear"),
                        new Card(1, "triangle", "blue", "solid"),
                        new Card(1, "square", "green", "clear"),
                        new Card(3, "triangle", "green", "clear"),
                        new Card(3, "circle", "blue", "dashed"),
                        new Card(3, "circle", "blue", "dashed"),
                        new Card(3, "square", "green", "clear"),
                        new Card(1, "square", "green", "clear") };
      assertEquals(false, GameSet.containsSet(temp));

      Card[] temp1 = {  new Card(2, "square", "red", "dashed"),
                        new Card(2, "circle", "green", "dashed"),
                        new Card(3, "square", "red", "dashed"),
                        new Card(2, "triangle", "blue", "solid"),
                        new Card(2, "triangle", "green", "clear"),
                        new Card(3, "square", "blue", "dashed"),
                        new Card(1, "square", "blue", "dashed"),
                        new Card(3, "square", "red", "clear"),
                        new Card(1, "triangle", "blue", "solid"),
                        new Card(1, "square", "green", "clear"),
                        new Card(3, "triangle", "green", "clear"),
                        new Card(3, "circle", "blue", "dashed"),
                        new Card(3, "circle", "blue", "dashed"),
                        new Card(3, "square", "green", "clear"),
                        new Card(1, "square", "green", "clear") };
      assertEquals(true, GameSet.containsSet(temp1));
   }

   public void testGameSet02()   //  isSet tester only
   {
      Card c1 = new Card (1, "square" , "red", "clear");
      Card c2 = new Card (2, "circle" , "blue", "solid");
      Card c3 = new Card (3, "triangle" , "green", "dashed");

      Card c4 = new Card (1, "square" , "blue", "clear");

      Card c5 = new Card (2, "circle" , "blue", "clear");
      Card c6 = new Card (3, "triangle" , "green", "clear");

      Card c7 = new Card (2, "circle" , "red", "solid");
      Card c8 = new Card (3, "triangle" , "red", "dashed");

      Card c9 = new Card (2, "circle" , "red", "clear");
      Card c10 = new Card (3, "triangle" , "red", "clear");

      Card c11 = new Card (2, "square" , "blue", "solid");
      Card c12 = new Card (3, "square" , "green", "dashed");

      Card c13 = new Card (2, "square" , "blue", "clear");
      Card c14 = new Card (3, "square" , "green", "clear");

      Card c15 = new Card (2, "square" , "red", "solid");
      Card c16 = new Card (3, "square" , "red", "dashed");

      Card c17 = new Card (2, "square" , "red", "clear");
      Card c18 = new Card (3, "square" , "red", "clear");

      Card c22 = new Card (1, "circle" , "blue", "solid");
      Card c23 = new Card (1, "triangle" , "green", "dashed");

      Card c25 = new Card (1, "circle" , "blue", "clear");
      Card c26 = new Card (1, "triangle" , "green", "clear");

      Card c27 = new Card (1, "circle" , "red", "solid");
      Card c28 = new Card (1, "triangle" , "red", "dashed");

      Card c29 = new Card (1, "circle" , "red", "clear");
      Card c30 = new Card (1, "triangle" , "red", "clear");

      Card c31 = new Card (1, "square" , "blue", "solid");
      Card c32 = new Card (1, "square" , "green", "dashed");

      Card c33 = new Card (1, "square" , "blue", "clear");
      Card c34 = new Card (1, "square" , "green", "clear");

      Card c35 = new Card (1, "square" , "red", "solid");
      Card c36 = new Card (1, "square" , "red", "dashed");

      assertEquals(true, GameSet.isSet(c1, c2, c3));  //  diff - diff - diff - diff
      assertEquals(true, GameSet.isSet(c1, c5, c6));  //  diff - diff - diff - same
      assertEquals(true, GameSet.isSet(c1, c7, c8));  //  diff - diff - same - diff
      assertEquals(true, GameSet.isSet(c1, c9, c10));  // diff - diff - same - same
      assertEquals(true, GameSet.isSet(c1, c11, c12));  // diff - same - diff - diff
      assertEquals(true, GameSet.isSet(c1, c13, c14));  // diff - same - diff - same
      assertEquals(true, GameSet.isSet(c1, c15, c16));  // diff - same - same - diff
      assertEquals(true, GameSet.isSet(c1, c17, c18));  // diff - same - same - same

      assertEquals(true, GameSet.isSet(c1, c22, c23));  //  same - diff - diff - diff
      assertEquals(true, GameSet.isSet(c1, c25, c26));  //  same - diff - diff - same
      assertEquals(true, GameSet.isSet(c1, c27, c28));  //  same - diff - same - diff
      assertEquals(true, GameSet.isSet(c1, c29, c30));  // same - diff - same - same
      assertEquals(true, GameSet.isSet(c1, c31, c32));  // same - same - diff - diff
      assertEquals(true, GameSet.isSet(c1, c33, c34));  // same - same - diff - same
      assertEquals(true, GameSet.isSet(c1, c35, c36));  // same - same - same - diff

      assertEquals(false, GameSet.isSet(c1, c2, c4));
      assertEquals(false, GameSet.isSet(c3, c2, c4));
      assertEquals(false, GameSet.isSet(c1, c3, c4));
   }

   public void testGameSet03()   //  more isSet tester only
   {
      Card c1 = new Card (2, "square" , "red", "clear");
      Card c2 = new Card (2, "circle" , "blue", "solid");
      Card c3 = new Card (2, "triangle" , "green", "dashed");

      Card c4 = new Card (3, "square" , "red", "dashed");
      Card c5 = new Card (3, "circle" , "blue", "dashed");
      Card c6 = new Card (3, "triangle" , "green", "dashed");

      Card c7 = new Card (1, "circle" , "red", "solid");
      Card c8 = new Card (2, "circle" , "red", "dashed");
      Card c9 = new Card (3, "circle" , "red", "clear");

      Card c10 = new Card (3, "square" , "green", "solid");
      Card c11 = new Card (2, "square" , "green", "solid");
      Card c12 = new Card (1, "square" , "green", "solid");

      Card c13 = new Card (2, "square" , "blue", "dashed");
      Card c14 = new Card (3, "square" , "green", "clear");
      Card c15 = new Card (2, "square" , "red", "solid");

      Card c16 = new Card (3, "square" , "blue", "dashed");
      Card c17 = new Card (2, "circle" , "red", "clear");
      Card c18 = new Card (1, "square" , "green", "solid");

      Card c19 = new Card (1, "circle" , "blue", "solid");
      Card c20 = new Card (1, "triangle" , "green", "dashed");
      Card c21 = new Card (1, "circle" , "blue", "clear");

      Card c22 = new Card (2, "triangle" , "blue", "solid");
      Card c23 = new Card (1, "triangle" , "blue", "dashed");
      Card c24 = new Card (3, "triangle" , "blue", "solid");

      Card c25 = new Card (1, "triangle" , "green", "clear");
      Card c26 = new Card (1, "circle" , "red", "solid");
      Card c27 = new Card (2, "triangle" , "blue", "dashed");

      Card c28 = new Card (1, "square" , "red", "dashed");
      Card c29 = new Card (1, "circle" , "red", "clear");
      Card c30 = new Card (1, "triangle" , "red", "clear");

      Card c31 = new Card (2, "square" , "blue", "solid");
      Card c32 = new Card (2, "square" , "green", "dashed");
      Card c33 = new Card (2, "square" , "blue", "clear");

      Card c34 = new Card (3, "square" , "green", "clear");
      Card c35 = new Card (3, "square" , "red", "solid");
      Card c36 = new Card (3, "square" , "red", "dashed");

      assertEquals(true, GameSet.isSet(c1, c2, c3));     //  same(2) - diff - diff - diff
      assertEquals(true, GameSet.isSet(c4, c5, c6));     //  same(3) - diff - diff - same(dahsed)
      assertEquals(true, GameSet.isSet(c9, c7, c8));     //  diff - same(circle) - same(red) - diff
      assertEquals(true, GameSet.isSet(c11, c12, c10));  // diff - same(square) - same(green) - same(solid)

      assertEquals(false, GameSet.isSet(c13, c14, c15));  // BAD - same - diff - diff
      assertEquals(false, GameSet.isSet(c18, c17, c16));  // diff - BAD - diff - same
      assertEquals(false, GameSet.isSet(c21, c20, c19));  // same - diff - BAD - diff
      assertEquals(false, GameSet.isSet(c22, c23, c24));  // diff - same - same - BAD

      assertEquals(false, GameSet.isSet(c25, c26, c27));
      assertEquals(false, GameSet.isSet(c30, c29, c28));
      assertEquals(false, GameSet.isSet(c31, c32, c33));

      assertEquals(false, GameSet.isSet(c34, c35, c36));
   }

   public void testGameSet04()   //  makeSet tester only
   {
      Card c1 = new Card (1, "square" , "red", "clear");
      Card c2 = new Card (2, "circle" , "blue", "solid");
      Card c3 = new Card (3, "triangle" , "green", "dashed");
      assertEquals(c3, GameSet.makeSet(c1, c2));   // diff - diff - diff - diff

      c1 = new Card (3, "square" , "red", "clear");
      c2 = new Card (1, "circle" , "blue", "clear");
      c3 = new Card (2, "triangle" , "green", "clear");
      assertEquals(c3, GameSet.makeSet(c1, c2));   // diff - diff - diff - same

      c1 = new Card (3, "square" , "green", "solid");
      c2 = new Card (1, "circle" , "green", "dashed");
      c3 = new Card (2, "triangle" , "green", "clear");
      assertEquals(c3, GameSet.makeSet(c1, c2));   // diff - diff - same - diff

      c1 = new Card (3, "square" , "green", "dashed");
      c2 = new Card (1, "circle" , "green", "dashed");
      c3 = new Card (2, "triangle" , "green", "dashed");
      assertEquals(c3, GameSet.makeSet(c1, c2));   // diff - diff - same - same

      c1 = new Card (3, "triangle" , "green", "dashed");
      c2 = new Card (1, "triangle" , "blue", "clear");
      c3 = new Card (2, "triangle" , "red", "solid");
      assertEquals(c3, GameSet.makeSet(c1, c2));   // diff - same - diff - diff

      c1 = new Card (3, "circle" , "green", "solid");
      c2 = new Card (1, "circle" , "blue", "solid");
      c3 = new Card (2, "circle" , "red", "solid");
      assertEquals(c3, GameSet.makeSet(c1, c2));   // diff - same - diff - same

      c1 = new Card (2, "circle" , "red", "solid");
      c2 = new Card (3, "circle" , "red", "dashed");
      c3 = new Card (1, "circle" , "red", "clear");
      assertEquals(c3, GameSet.makeSet(c1, c2));   // diff - same - same - diff

      c1 = new Card (2, "circle" , "red", "clear");
      c2 = new Card (3, "circle" , "red", "clear");
      c3 = new Card (1, "circle" , "red", "clear");
      assertEquals(c3, GameSet.makeSet(c1, c2));   // diff - same - same - same
    }

   public void testGameSet05()   //  more makeSet tester only
   {
      Card c1 = new Card (3, "square" , "red", "clear");
      Card c2 = new Card (3, "circle" , "blue", "solid");
      Card c3 = new Card (3, "triangle" , "green", "dashed");
      assertEquals(c3, GameSet.makeSet(c1, c2));   // same - diff - diff - diff

      c1 = new Card (2, "square" , "red", "clear");
      c2 = new Card (2, "circle" , "blue", "clear");
      c3 = new Card (2, "triangle" , "green", "clear");
      assertEquals(c3, GameSet.makeSet(c1, c2));   // same - diff - diff - same

      c1 = new Card (1, "square" , "green", "solid");
      c2 = new Card (1, "circle" , "green", "dashed");
      c3 = new Card (1, "triangle" , "green", "clear");
      assertEquals(c3, GameSet.makeSet(c1, c2));   // same - diff - same - diff

      c1 = new Card (1, "square" , "green", "dashed");
      c2 = new Card (1, "circle" , "green", "dashed");
      c3 = new Card (1, "triangle" , "green", "dashed");
      assertEquals(c3, GameSet.makeSet(c1, c2));   // same - diff - same - same

      c1 = new Card (2, "triangle" , "green", "dashed");
      c2 = new Card (2, "triangle" , "blue", "clear");
      c3 = new Card (2, "triangle" , "red", "solid");
      assertEquals(c3, GameSet.makeSet(c1, c2));   // same - same - diff - diff

      c1 = new Card (3, "circle" , "green", "solid");
      c2 = new Card (3, "circle" , "blue", "solid");
      c3 = new Card (3, "circle" , "red", "solid");
      assertEquals(c3, GameSet.makeSet(c1, c2));   // same - same - diff - same

      c1 = new Card (1, "circle" , "red", "solid");
      c2 = new Card (1, "circle" , "red", "dashed");
      c3 = new Card (1, "circle" , "red", "clear");
      assertEquals(c3, GameSet.makeSet(c1, c2));   // same - same - same - diff

      c1 = new Card (2, "circle" , "red", "clear");
      c2 = new Card (2, "circle" , "red", "clear");
      c3 = new Card (2, "circle" , "red", "clear");
      assertEquals(c3, GameSet.makeSet(c1, c2));   // same - same - same - same
    }

   public void testGameSet06()   //  containsSet tester only
   {
      Card[] temp = {   new Card(1, "triangle", "red", "solid"),
                        new Card(3, "circle", "green", "dashed"),
                        new Card(2, "square", "blue", "clear"),
                        new Card(2, "triangle", "red", "clear"),
                        new Card(1, "circle", "green", "dashed"),
                        new Card(2, "triangle", "blue", "solid"),
                        new Card(3, "circle", "green", "dashed"),
                        new Card(1, "square", "red", "clear"),
                        new Card(3, "triangle", "blue", "solid"),
                        new Card(1, "square", "green", "dashed"),
                        new Card(2, "circle", "red", "clear"),
                        new Card(3, "square", "red", "solid"),
                        new Card(1, "triangle", "blue", "dashed"),
                        new Card(2, "square", "green", "clear"),
                        new Card(3, "triangle", "blue", "solid") };
      assertEquals(true, GameSet.containsSet(temp));

      Card[] temp1 = {   new Card(2, "cirlce", "red", "solid"),
                        new Card(2, "circle", "green", "dashed"),
                        new Card(2, "circle", "red", "dashed"),
                        new Card(1, "circle", "blue", "clear"),

                        new Card(3, "square", "blue", "solid"),
                        new Card(1, "square", "red", "clear"),
                        new Card(3, "circle", "green", "clear"),
                        new Card(2, "circle", "red", "dashed"),

                        new Card(3, "square", "red", "dashed"),
                        new Card(1, "square", "green", "solid"),
                        new Card(2, "square", "green", "solid"),
                        new Card(2, "circle", "green", "dashed"),
                        
                        new Card(3, "circle", "green", "clear"),
                        new Card(2, "circle", "green", "clear"),
                        new Card(2, "square", "red", "dashed") };
      assertEquals(false, GameSet.containsSet(temp1));

      
      Card[] temp2 = {   new Card(2, "circle", "red", " solid"),
                         new Card(2, "circle", "green", " dashed"),
                         new Card(2, "circle", "red", " dashed"),
                         new Card(1, "circle", "blue", " clear"),

                         new Card(3, "square", "blue", " solid"),
                         new Card(1, "square", "red", " clear"),
                         new Card(3, "circle", "green", " clear"),
                         new Card(2, "circle", "red", " dashed"),

                         new Card(3, "square", "red", " dashed"),
                         new Card(1, "square", "green", " solid"),
                         new Card(2, "square", "green", " solid"),
                         new Card(2, "circle", "green", " dashed"),

                         new Card(3, "circle", "green", " clear"),
                         new Card(2, "circle", "green", " clear"),
                         new Card(2, "square", "red", " dashed") };
      assertEquals(false, GameSet.containsSet(temp2));

      Card[] temp3 = {   new Card(3, "square", "red", "solid"),
                         new Card(2, "square", "blue", "dashed"),
                         new Card(2, "circle", "blue", "solid"),
                         new Card(2, "circle", "blue", "clear"),
                         new Card(2, "triangle", "blue", "dashed"),
                         new Card(2, "circle", "blue", "solid"),
                         new Card(2, "triangle", "blue", "dashed"),
                         new Card(3, "triangle", "red", "dashed"),
                         new Card(3, "square", "red", "clear"),
                         new Card(3, "circle", "red", "dashed"),
                         new Card(3, "circle", "blue", "clear"),
                         new Card(3, "circle", "blue", "solid"),
                         new Card(1, "square", "blue", "dashed"),
                         new Card(1, "circle", "red", "dashed"),
                         new Card(3, "square", "red", "solid") };

      assertEquals(false, GameSet.containsSet(temp3));
   }

   public void testGameSet07()   //  isSet and makeSet
   {
       testGameSet02();
       testGameSet03();
       testGameSet04();
       testGameSet05();
   }

   public void testGameSet08()   //  isSet and containsSet
   {
       testGameSet02();
       testGameSet03();
       testGameSet06();
   }

   public void testGameSet09()   //  makeSet and containsSet
   {
       testGameSet04();
       testGameSet05();
       testGameSet06();
   }

   public void testGameSet10()   //  isSet and makeSet and containsSet
   {
       testGameSet02();
       testGameSet03();
       testGameSet04();
       testGameSet05();
       testGameSet06();

      Card[] temp = {   new Card(1, "circle", "green", "clear"),
                         new Card(2, "triangle", "green", "solid"),
                         new Card(1, "circle", "red", "solid"),
                         new Card(3, "square", "green", "solid"),
                         new Card(3, "triangle", "green", "clear"),
                         new Card(2, "circle", "green", "solid"),
                         new Card(1, "square", "red", "solid"),
                         new Card(1, "circle", "red", "solid"),
                         new Card(3, "circle", "green", "clear"),
                         new Card(1, "square", "red", "solid"),
                         new Card(1, "triangle", "red", "dashed"),
                         new Card(3, "circle", "green", "clear"),
                         new Card(3, "triangle", "red", "dashed"),
                         new Card(2, "triangle", "red", "clear"),
                         new Card(1, "square", "green", "solid") };

      assertEquals(false, GameSet.containsSet(temp));


      Card[] temp1 = {   new Card(1, "circle", "green", "clear"),
                         new Card(2, "triangle", "green", "solid"),
                         new Card(1, "circle", "red", "solid"),
                         new Card(3, "square", "green", "solid"),
                         new Card(3, "triangle", "green", "clear"),
                         new Card(2, "circle", "green", "solid"),
                         new Card(1, "square", "red", "solid"),
                         new Card(1, "triangle", "red", "dashed"),
                         new Card(3, "circle", "green", "clear"),
                         new Card(3, "triangle", "red", "dashed"),
                         new Card(2, "triangle", "red", "clear"),
                         new Card(1, "square", "green", "solid") };

      assertEquals(false, GameSet.containsSet(temp1));

      Card[] temp2 = {   new Card(1, "circle", "green", "clear"),
                         new Card(2, "triangle", "green", "solid"),
                         new Card(1, "circle", "red", "solid"),
                         new Card(3, "square", "green", "solid"),
                         new Card(1, "triangle", "red", "dashed"),
                         new Card(3, "circle", "green", "clear"),
                         new Card(3, "triangle", "red", "dashed"),
                         new Card(2, "triangle", "red", "clear"),
                         new Card(1, "square", "green", "solid") };

      assertEquals(false, GameSet.containsSet(temp2));

      Card[] temp3 = {   new Card(1, "circle", "green", "clear"),
                         new Card(2, "triangle", "green", "solid"),
                         new Card(1, "circle", "red", "solid"),
                         new Card(3, "square", "green", "solid"),
                         new Card(1, "triangle", "red", "dashed"),
                         new Card(3, "circle", "green", "clear"),
                         new Card(3, "triangle", "red", "dashed"),
                         new Card(3, "square", "green", "dashed"),
                         new Card(2, "triangle", "red", "clear"),
                         new Card(1, "square", "green", "solid") };

      assertEquals(true, GameSet.containsSet(temp3));
    }
}