//import java.util.*;

import java.util.Set;
import java.util.TreeSet;

/**
 * Sum of Primes.
 *
 * @author  Mr. Allen
 * @version (a version number or a date)
 */
public class SumOfPrimes
{
   private static Set<Integer> primes;
   private static int maxCalculatedPrimes;

   public SumOfPrimes()  {
      calculatePrimes(100); // Pre-generate because why not.
   }

   public int getNumberOfSums(int target, int num)
   {
      if (target == 0) // Handle edge case.
         return 0;
      calculatePrimes(target);
      return getNumberOfSums(target, num, primes, 0);
   }

   private int getNumberOfSums(int target, int num, Set<Integer> remainingPrimes, int min) {
      if (num == 0) {
         if (target == 0)
            return 1; // If it's a good sum, accumulate one.
         return 0; // Otherwise, it's useless.
      }

      var accum = 0;
      for (var c : remainingPrimes) {
         if (c > target || c <= min) // So the trick here is that in order to remove duplicates, we only count up.
            continue; // e.g. you can only have 2 + 3 + 5, not 3 + 2 + 5 or 5 + 3 + 2 etc. Setting a minimum forces that.
         var temp = new TreeSet<>(remainingPrimes);
         temp.remove(c);
         accum += getNumberOfSums(target - c, num - 1, temp, c);
      }

      return accum;
   }

   private void calculatePrimes(int target) {
      if (target <= maxCalculatedPrimes)
         return;

      if (primes == null)
         primes = new TreeSet<>();

      for (int i = Math.max(2, maxCalculatedPrimes + 1); i <= target; ++i)
         if (isPrime(i))
            primes.add(i);
      maxCalculatedPrimes = target;
   }

   private boolean isPrime(int num) {
      return primes.stream().allMatch(o -> num % o != 0);
   }
}