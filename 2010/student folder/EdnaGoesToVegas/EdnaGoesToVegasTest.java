import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EdnaGoesToVegasTest extends junit.framework.TestCase
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
}