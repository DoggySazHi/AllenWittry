import java.util.*;
import java.lang.Math;
import java.lang.Number;
import java.math.BigInteger;
/**
 * An Interesting Sequence
 *
 * @author  Mr. Allen
 * @version (a version number or a date)
 */
public class AnInterestingSequence
{

   public int numberOfIterations(int num)
   {
      int counter = 0;
      while (num > 0) {
         var smallestInt = (int) Math.floor(Math.sqrt(num));
         num -= smallestInt * smallestInt; // What's a pow?
         ++counter;
      }
      return counter;
   }
      
   public int minValueWithN_Iterations(int n)
   {
      int counter = 0;
      while (numberOfIterations(counter) != n)
         ++counter;
      return counter;
   }
}