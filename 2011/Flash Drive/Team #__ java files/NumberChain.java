import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Number Chain.
 *
 * @author  
 * @version (a version number or a date)
 */
public class NumberChain
{
   private int num;
   public NumberChain(int y)
   {
      num = y;
   }

   public int ascendingDigits()
   {
      return Integer.parseInt(ascendingDigitsStr("" + num));
   }

   private String ascendingDigitsStr(String s)
   {
      return s.chars()
              .map(o -> o - '0')
              .sorted()
              .mapToObj(o -> "" + o)
              .collect(Collectors.joining());
   }

   public int descendingDigits()
   {
      return Integer.parseInt(descendingDigitsStr("" + num));
   }

   private String descendingDigitsStr(String s)
   {
      // I could combine mapping operations, but I would like to read it later.
      return s.chars()
              .map(o -> o - '0')
              .map(o -> ~o) // Cheat our way to sorting in reverse.
              .sorted()
              .map(o -> ~o)
              .mapToObj(o -> "" + o)
              .collect(Collectors.joining());
   }

   public int getChainLength()
   {
      var chain = new HashSet<Integer>();
      // We handle in strings to compensate for zeros (though IDK if that's actually necessary)
      var a = descendingDigitsStr("" + num);
      var b = ascendingDigitsStr("" + num);
      var oldNum = num;
      while (chain.add(oldNum)) {
         var diff = Integer.parseInt(a) - Integer.parseInt(b);
         oldNum = diff;
         a = descendingDigitsStr("" + diff);
         b = ascendingDigitsStr("" + diff);
      }
      return chain.size();
   }
}