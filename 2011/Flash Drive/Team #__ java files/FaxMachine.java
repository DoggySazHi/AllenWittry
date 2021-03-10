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
      var counts = new ArrayList<Integer>();
      var chars = str.toCharArray();
      int accum = 0;
      for (var c : chars) {
          if (c == '0')
              ++accum;
          else {
              counts.add(accum);
              accum = 0;
          }
      }
      counts.add(accum);

       var sequence = new ArrayList<Integer>();
       for(var c : counts) {
           while (c >= 7) {
               sequence.add(7);
               c -= 7;
           }
           sequence.add(c);
       }

       return sequence.stream()
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

      var output = new ArrayList<Integer>();
      var accum = 0;
      for(var v : arr) {
          accum += v;
          if (v < 7) {
              output.add(accum);
              accum = 0;
          }
      }

      var sb = new StringBuilder();

      for(int i = 0; i < output.size() - 1; ++i) {
          sb.append("0".repeat(output.get(i)));
          sb.append("1");
      }
      sb.append("0".repeat(output.get(output.size() - 1)));

      return sb.toString();
   }
}