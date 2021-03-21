/**
 * @author:   Mr. Allen
 *            2017 Wittry contest
 */
import java.io.*;
import java.util.*;
import java.math.*;
import java.util.stream.Collectors;

public class DevilNumbers
{
/*
 *    precondition num > 0
 *    
 *       returns true if num is a Devil Number
 *       returns false otherwise
 */
   public static boolean isDevilNumber(int num)
   {
      var digits = ("" + num).chars().mapToObj(o -> o - '0').collect(Collectors.toList());
      return searchForSix(6, digits);
   }

   private static boolean searchForSix(int target, List<Integer> digits) {
      if (target == 0)
         return true;
      if (target < 0 || digits.isEmpty())
         return false;

      for (var num : digits) {
         var temp = new ArrayList<>(digits);
         temp.remove(num);
         if (searchForSix(target - num, temp))
            return true;
      }

      return false;
   }

/*
*    precondition num > 0
*    
*       returns true if num is a True Devil Number
*       returns false otherwise
*/
   public static boolean isTrueDevilNumber(int num)
   {
      var digits = ("" + num).chars().mapToObj(o -> o - '0').collect(Collectors.toList());
      return !digits.contains(7) && searchForSix(6, digits);
   }

/*
 *    precondition num > 0
 *    
 *       returns the largest Devil Number <= num
 *       returns -1 if no Devil Number exist
 */
   public static int getLargestDevilNumber(int num)
   {
      for(int i = num; i > 5; i--)
         if (isDevilNumber(i))
            return i;
      return -1;
   }

/*
 *    precondition num > 0
 *    
 *       returns the largest positive True Devil Number <= num
 *       returns -1 if no Devil Number exist
 */
   public static int getLargestTrueDevilNumber(int num)
   {
      for(int i = num; i > 5; i--)
         if (isTrueDevilNumber(i))
            return i;
      return -1;
   }
}