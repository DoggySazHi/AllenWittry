import java.util.Locale;

public class Jumble
{
   private final String word;

   public Jumble(String str)
   {
      word = str.toUpperCase(Locale.ROOT);
   }

   private String fixString(String scramble) {
      // Simple RegEx fix. At least to me.
      var vowelFix = scramble.replaceAll("A[IY]|E[AEO]|IO|O[AOY]|Y[AOU]", "A");
      var consonantFix = vowelFix.replaceAll("B[LR]|C[HKLR]|DR|F[LR]|G[HLR]|K[LRW]|P[FLR]|S[CHKLMNPQTW][HR]?|T[HRW]R?|W[HR]", "Z");
      return consonantFix.replaceAll("([BCDFGHJKLMNPQRSTVWXZ])\\1", "W");
   }

   public boolean looksReal(String scramble)
   {
      if (scramble.length() == 0)
         return false;
      scramble = scramble.toUpperCase(Locale.ROOT);

      var doubleFix = fixString(scramble);
      var lastCharStat = isVowel(doubleFix.charAt(0));
      for (int i = 1; i < doubleFix.length(); i++)
         if(lastCharStat == isVowel(doubleFix.charAt(i)))
            return false;
         else
            lastCharStat = !lastCharStat;
      return true;
   }

   public int numLettersInCorrectLocation(String scramble)
   {
      scramble = scramble.toUpperCase(Locale.ROOT);
      int accum = 0;
      for(int i = 0; i < Math.min(scramble.length(), word.length()); ++i)
         if (scramble.charAt(i) == word.charAt(i))
            ++accum;
      return accum;
   }

   public String getRating(String scramble)
   {
      scramble = scramble.toUpperCase(Locale.ROOT);
      if (scramble.equals(word))
         return "not";
      if (numLettersInCorrectLocation(scramble) == 0 && looksReal(scramble))
         return "good";

      int maxStreak = 1;
      int curStreak = 0;
      for(int i = 0; i < Math.min(scramble.length(), word.length()); ++i) {
         if (scramble.charAt(i) == word.charAt(i))
            ++curStreak;
         else {
            if (curStreak > maxStreak)
               maxStreak = curStreak;
            curStreak = 0;
         }
      }
      if (curStreak > maxStreak)
         maxStreak = curStreak;

      if (scramble.charAt(0) == word.charAt(0) || maxStreak >= 2)
         return "poor";
      return "fair";
   }

   private boolean isVowel(char c) {
      return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'Y';
   }
}