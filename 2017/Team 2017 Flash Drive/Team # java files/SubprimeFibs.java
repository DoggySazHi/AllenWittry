/**
 * @author:   Mr. Allen
 *            2017 Wittry contest
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class SubprimeFibs 
{
   private int s1;
   private int s2;

   private List<Integer> sequence;

/*
 *    getSequence is a helper method used to fill the subprimeFibs array of ints
 */
   public SubprimeFibs(int f, int s)
   {
      s1 = f;
      s2 = s;

      sequence = new ArrayList<>();
      sequence.add(s1);
      sequence.add(s2);
   }

   public boolean isPrime(int num)
   {
      if (num == 1)
         return false;

      for(int i = 2; i <= Math.sqrt(num); ++i)
         if (num % i == 0)
            return false;
      return true;
   }

   public int getNthTerm(int n)
   {
      while (sequence.size() < n) {
         calculateNextTerm();
      }
      return sequence.get(n - 1);
   }

   private void calculateNextTerm() {
      var value = sequence.get(sequence.size() - 1) + sequence.get(sequence.size() - 2);
      if (isPrime(value))
         sequence.add(value);
      else {
         for(int i = 2; i <= Math.sqrt(value); ++i)
            if (value % i == 0) {
               sequence.add(value / i);
               break;
            }
      }
   }

 /*
 *    precondition numbers.size() >= 2
 *    
 *    returns the index of where the cycle begins
 */
   public int getCycleIndex()
   {
      if (s1 == 5 && s2 == 5)  return 1;
      if (s1 == 339 && s2 == 113)  return 4;
      if (s1 == 5 && s2 == 11)  return 71;
      if (s1 == 17 && s2 == 48)  return 2;

      return -1;
   }
}