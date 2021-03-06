import java.util.*;
import java.lang.Math;
import java.lang.Number;
import java.math.BigInteger;
import java.util.stream.Collectors;

/**
 * Happy Numbers
 *
 * @author  Mr. Allen
 * @version (a version number or a date)
 */
public class AutomorphicNumber
{
   public static boolean isAutomorphicNumber(int num)
   {
      return ((long) num * num + "").endsWith(num + "");
   }

   public static ArrayList<Integer> getAutomorphicNumberFromArray(int[] numbers)
   {
      return (ArrayList<Integer>) Arrays.stream(numbers).filter(AutomorphicNumber::isAutomorphicNumber).sorted().boxed().collect(Collectors.toList());
   }
}