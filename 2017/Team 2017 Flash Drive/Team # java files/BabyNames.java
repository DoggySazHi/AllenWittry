/**
 * @author:   Mr. Allen
 *            2017 Wittry contest
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class BabyNames 
{
/*
 *  precondition
 *    firstName and secondName will contain only UPPERRCASE letters
 *    2 <= firstName.length()  <= 20
 *    2 <= secondName.length() <= 20
 *
 * post condition
 *    returns a List of potential new names using firstName for the begininng 
 *            and second name for the ending of the new name
 */
   public List<String> getBabyNames( String firstName, String secondName)
   {
      final var VOWELS = "AEIOU";
      var ans = new TreeSet<String>();
      for (var i = firstName.length() - 1; i >= 1; --i) {
         for(var j = 1; j < secondName.length(); ++j) {
            var a = firstName.substring(0, i);
            var b = secondName.substring(j);
            if ((VOWELS.indexOf(a.charAt(a.length() - 1)) >= 0) != (VOWELS.indexOf(b.charAt(0)) >= 0))
               ans.add(a + b);
         }
      }
      return new ArrayList<>(ans);
   }
}