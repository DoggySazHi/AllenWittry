import java.util.*;

public class ClimbThis {

   public static boolean isLadder(ArrayList<String> words)
   {
      for(int i = 0; i < words.size() - 1; i++)
         if (!validChange(words.get(i), words.get(i + 1)))
            return false;
      return true;
   }

   private static boolean validChange(String a, String b) {
      if (a.length() != b.length())
         return false;
      int counter = 0;
      for(int i = 0; i < a.length(); ++i)
         if (a.charAt(i) != b.charAt(i))
            ++counter;
      return counter == 1;
   }
}