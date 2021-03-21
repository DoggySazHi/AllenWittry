/**
 * @author:   Mr. Allen
 *            2017 Wittry contest
 */
import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;
public class EgyptianMultiplication 
{
/*
*	| for one (careful, it's a vertical line, not 1) 
*	n for ten 
*	9 for hundred 
*	8 for thousand 
*	r for ten-thousand 
*	
*	For the purpose of this problem, we will not consider numbers greater than 99,999
*	
*	You may assume the Egyptian number will be properly formed
*/
   public static int toDecimal(String eNum)
   {
      var accum = 0;
      accum += countChar('|', eNum);
      accum += 10 * countChar('n', eNum);
      accum += 100 * countChar('9', eNum);
      accum += 1000 * countChar('8', eNum);
      accum += 10000 * countChar('r', eNum);
      return accum;
   }

   private static int countChar(char c, String word) {
      int accum = 0;
      for (var i = 0; i < word.length(); ++i)
         if (word.charAt(i) == c)
            ++accum;
      return accum;
   }

   public static String[] multiply(String n1, String n2)
   {
      var table = new ArrayList<Integer>();
      var target = toDecimal(n1);
      var right = toDecimal(n2);
      var iterations = (int) (Math.log(target) / Math.log(2));
      for(int i = 0; i <= iterations; ++i) {
         table.add(right);
         right *= 2;
      }
      var binary = Long.toBinaryString(target);
      var tempOutput = new ArrayList<String>();
      var result = 0;
      for(int i = binary.length() - 1; i >= 0; --i) {
         var bit = (binary.length() - 1) - i;
         if (binary.charAt(i) == '1') {
            result += table.get(bit);
            tempOutput.add(toEgyptianNumber(1 << bit) + " ".repeat(5) + toEgyptianNumber(table.get(bit)));
         }
      }

      var out = new String[tempOutput.size() + 1];
      for (int i = 0; i < tempOutput.size(); ++i)
         out[i] = tempOutput.get(i);
      out[out.length - 1] = toEgyptianNumber(result);
      return out;
   }

   public static String toEgyptianNumber(int value)
   {
      var ones = value % 10;
      var tens = (value / 10) % 10;
      var hundreds = (value / 100) % 10;
      var thousands = (value / 1000) % 10;
      var tenThousands = (value / 10000) % 10;

      return "|".repeat(ones) + "n".repeat(tens) + "9".repeat(hundreds) + "8".repeat(thousands) + "r".repeat(tenThousands);
   }
}