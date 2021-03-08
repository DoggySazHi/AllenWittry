import java.util.*;
import java.lang.Math;
import java.lang.Number;
import java.math.BigInteger;
import java.util.stream.Collectors;

/**
 * Fax Machine.
 *
 * @author  Mr. Allen
 * @version (a version number or a date)
 */
public class FaxMachine
{
   public static String convertToRLE(String str)
   {
      var arr = Arrays.stream(str.split("1")).collect(Collectors.toList());
      int index = str.length() - 1;
      while (index >= 0 && str.charAt(index--) == '1')
         arr.add("");
      return arr.stream()
              .map(String::length)
              .map(o -> {
                 boolean addZero = o % 7 == 0;
                 var out = new ArrayList<Integer>();
                 while (o > 0) {
                    var val = Math.min(o, 7);
                    o -= val;
                    out.add(val);
                 }
                 if (addZero)
                    out.add(0);
                 return out;
              })
              .flatMap(List::stream)
              .map(o ->
                   ((o & 0b100) == 4 ? "1" : "0") +
                   ((o & 0b010) == 2 ? "1" : "0") +
                   ((o & 0b001) == 1 ? "1" : "0"))
              .collect(Collectors.joining());
   }

   public static String RLEtoFax(String str)
   {
      var arr = new ArrayList<Integer>();
      for (var i = 0; i < str.length(); i += 3) {
         var bin = str.substring(i, i + 3);
         var num =
                 (bin.charAt(0) == '1' ? 4 : 0) +
                 (bin.charAt(1) == '1' ? 2 : 0) +
                 (bin.charAt(2) == '1' ? 1 : 0);
         arr.add(num);
      }
      /*
      for(var i = 0; i < arr.size() - 1; ++i) {
         if (arr.get(i + 1) != 0) {
            arr.set(i, arr.get(i) + arr.get(i + 1));
            arr.remove(i + 1);
            --i;
         } else if (arr.get(i) % 7 == 0){
            arr.remove(i + 1);
         }
      }*/
      var sb = new StringBuilder();
      for(var i = 0; i < arr.size() - 1; ++i) {
         sb.append("0".repeat(arr.get(i)));
         sb.append("1");
      }
      sb.append("0".repeat(arr.get(arr.size() - 1)));
      return sb.toString();
   }
}