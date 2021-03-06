import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  Don Allen
 * @version 2010 programming contest
 */
public class EdnaGoesToVegasFinalTest extends junit.framework.TestCase
{
   public void testEdnaGoesToVegas01()
   {
       ArrayList<Fraction> die1 = new ArrayList<Fraction>();
       die1.add(new Fraction(1, 2));
       die1.add(new Fraction(1, 5));
       die1.add(new Fraction(3, 10));

       ArrayList<Fraction> die2 = new ArrayList<Fraction>();
       die2.add(new Fraction(1, 5));
       die2.add(new Fraction(1, 10));
       die2.add(new Fraction(3, 10));
       die2.add(new Fraction(2, 5));

       ArrayList<Fraction> die3 = new ArrayList<Fraction>();
       die3.add(new Fraction(1, 10));
       die3.add(new Fraction(9, 10));

       ArrayList< ArrayList<Fraction> > d = new ArrayList< ArrayList<Fraction> >();
       d.add(die1);
       d.add(die2);
       d.add(die3);
       Dice di = new Dice(d);
       EdnaGoesToVegas edna = new EdnaGoesToVegas(di);

       assertEquals(new Fraction(13, 125), edna.getProbability(5));

       Fraction f = new Fraction(1, 3);
       Fraction g = new Fraction(2, 3);
       f.add(g);
       assertEquals(new Fraction(2, 3), g);
       assertEquals(new Fraction(1, 1), f);

       Fraction j = new Fraction(1, 3);
       Fraction k = new Fraction(2, 3);
       j.multiply(k);
       assertEquals(new Fraction(2, 9), j);
       assertEquals(new Fraction(2, 3), k);
   }

   public void testEdnaGoesToVegas02()
   {
       Fraction f = new Fraction(1, 3);
       Fraction g = new Fraction(2, 3);
       f.add(g);
       assertEquals(new Fraction(2, 3), g);
       assertEquals(new Fraction(1, 1), f);

       f = new Fraction(0, 6);
       g = new Fraction(1, 8);
       f.add(g);
       assertEquals(new Fraction(1, 8), f);
       assertEquals(new Fraction(1, 8), g);

       f = new Fraction(0, 6);
       g = new Fraction(1, 8);
       g.add(f);
       assertEquals(new Fraction(0, 6), f);
       assertEquals(new Fraction(1, 8), g);

       f = new Fraction(1, 6);
       g = new Fraction(1, 8);
       f.add(g);
       assertEquals(new Fraction(7, 24), f);
       assertEquals(new Fraction(1, 8), g);

       f = new Fraction(1, 2);
       g = new Fraction(1, 6);
       f.add(g);
       assertEquals(new Fraction(2, 3), f);
       assertEquals(new Fraction(1, 6), g);

       f = new Fraction(11, 34);
       f.add(new Fraction(5, 17));
       assertEquals(new Fraction(21, 34), f);

       f = new Fraction(1, 6);
       g = new Fraction(1, 4);
       f.add(g);
       assertEquals(new Fraction(5, 12), f);
       assertEquals(new Fraction(1, 4), g);

       f = new Fraction(129, 512);
       f.add(new Fraction(127, 512));
       assertEquals(new Fraction(1, 2), f);

       f = new Fraction(63, 512);
       f.add(new Fraction(65, 512));
       f.add(new Fraction(1, 8));
       f.add(new Fraction(1, 8));
       f.add(new Fraction(1, 3));
       f.add(new Fraction(1, 12));
       f.add(new Fraction(1, 12));
       assertEquals(new Fraction(1, 1), f);
   }

   public void testEdnaGoesToVegas03()
   {
       Fraction f = new Fraction(1, 3);
       Fraction g = new Fraction(1, 3);
       f.multiply(g);
       assertEquals(new Fraction(1, 9), f);
       assertEquals(new Fraction(1, 3), g);

       f = new Fraction(1, 6);
       g = new Fraction(1, 8);
       f.multiply(g);
       assertEquals(new Fraction(1, 48), f);
       assertEquals(new Fraction(1, 8), g);

       f = new Fraction(1, 2);
       g = new Fraction(1, 6);
       f.multiply(g);
       assertEquals(new Fraction(1, 12), f);
       assertEquals(new Fraction(1, 6), g);

       f = new Fraction(11, 34);
       f.multiply(new Fraction(5, 17));
       assertEquals(new Fraction(55, 17*34), f);

       f = new Fraction(1, 6);
       f.multiply(new Fraction(1, 4));
       assertEquals(new Fraction(1, 24), f);

       f = new Fraction(11, 51);
       f.multiply(new Fraction(17, 33));
       assertEquals(new Fraction(1, 9), f);

       f = new Fraction(3, 13);
       f.multiply(new Fraction(5, 17));
       f.multiply(new Fraction(6, 13));
       f.multiply(new Fraction(13, 51));
       f.multiply(new Fraction(17, 21));
       assertEquals(new Fraction(10, 1547), f);
    }


   public void testEdnaGoesToVegas04()
   {
       ArrayList<Fraction> die1 = new ArrayList<Fraction>();
       die1.add(new Fraction(1, 2));
       die1.add(new Fraction(1, 5));
       die1.add(new Fraction(3, 20));
       die1.add(new Fraction(3, 20));

       ArrayList<Fraction> die2 = new ArrayList<Fraction>();
       die2.add(new Fraction(1, 5));
       die2.add(new Fraction(1, 10));
       die2.add(new Fraction(7, 10));

       ArrayList<Fraction> die3 = new ArrayList<Fraction>();
       die3.add(new Fraction(1, 10));
       die3.add(new Fraction(1, 3));
       die3.add(new Fraction(1, 6));
       die3.add(new Fraction(2, 5));

       ArrayList<Fraction> die4 = new ArrayList<Fraction>();
       die4.add(new Fraction(2, 3));
       die4.add(new Fraction(1, 3));

       ArrayList< ArrayList<Fraction> > d = new ArrayList< ArrayList<Fraction> >();
       d.add(die1);
       d.add(die2);
       d.add(die3);
       d.add(die4);
       Dice di = new Dice(d);
       EdnaGoesToVegas edna = new EdnaGoesToVegas(di);

       assertEquals(new Fraction(1, 150), edna.getProbability(4));
       assertEquals(new Fraction(373, 2000), edna.getProbability(8));
   }

   public void testEdnaGoesToVegas05()
   {
       ArrayList<Fraction> die1 = new ArrayList<Fraction>();
       die1.add(new Fraction(1, 19));
       die1.add(new Fraction(7, 19));
       die1.add(new Fraction(3, 19));
       die1.add(new Fraction(2, 19));
       die1.add(new Fraction(5, 19));
       die1.add(new Fraction(1, 19));

       ArrayList<Fraction> die2 = new ArrayList<Fraction>();
       die2.add(new Fraction(1, 6));
       die2.add(new Fraction(1, 6));
       die2.add(new Fraction(2, 11));
       die2.add(new Fraction(7, 33));
       die2.add(new Fraction(3, 11));

       ArrayList< ArrayList<Fraction> > d = new ArrayList< ArrayList<Fraction> >();
       d.add(die1);
       d.add(die2);
       Dice di = new Dice(d);
       EdnaGoesToVegas edna = new EdnaGoesToVegas(di);

       assertEquals(new Fraction(61, 627), edna.getProbability(4));
       assertEquals(new Fraction(1, 19*6), edna.getProbability(2));
       assertEquals(new Fraction(3, 19*11), edna.getProbability(11));
       assertEquals(new Fraction(229, 1254), edna.getProbability(6));
    }

   public void testEdnaGoesToVegas06()
   {
       ArrayList<Fraction> die1 = new ArrayList<Fraction>();
       die1.add(new Fraction(1, 9));
       die1.add(new Fraction(2, 9));
       die1.add(new Fraction(1, 3));
       die1.add(new Fraction(1, 9));
       die1.add(new Fraction(1, 9));
       die1.add(new Fraction(1, 9));

       ArrayList<Fraction> die2 = new ArrayList<Fraction>();
       die2.add(new Fraction(1, 6));
       die2.add(new Fraction(1, 6));
       die2.add(new Fraction(1, 3));
       die2.add(new Fraction(1, 12));
       die2.add(new Fraction(1, 12));

       ArrayList<Fraction> die3 = new ArrayList<Fraction>();
       die3.add(new Fraction(11, 25));
       die3.add(new Fraction(7, 25));
       die3.add(new Fraction(2, 25));
       die3.add(new Fraction(1, 5));

       ArrayList< ArrayList<Fraction> > d = new ArrayList< ArrayList<Fraction> >();
       d.add(die1);
       d.add(die2);
       d.add(die3);
       Dice di = new Dice(d);
       EdnaGoesToVegas edna = new EdnaGoesToVegas(di);

       assertEquals(new Fraction(11, 1350), edna.getProbability(3));
       assertEquals(new Fraction(4, 135), edna.getProbability(4));
       assertEquals(new Fraction(1, 540), edna.getProbability(15));
       assertEquals(new Fraction(193, 1350), edna.getProbability(7));
   }

   public void testEdnaGoesToVegas07()
   {
       testEdnaGoesToVegas03();
       testEdnaGoesToVegas02();
   }

   public void testEdnaGoesToVegas08()
   {
       testEdnaGoesToVegas07();
       testEdnaGoesToVegas04();
   }

   public void testEdnaGoesToVegas09()
   {
       testEdnaGoesToVegas08();
       testEdnaGoesToVegas05();
   }

   public void testEdnaGoesToVegas10()
   {
       testEdnaGoesToVegas09();
       testEdnaGoesToVegas06();
   }
}