public class ProducingPalindrome
{
   public static boolean isPalindrome(int num)
   {
      var word = "" + num;
      for(int i = 0; i < word.length() / 2; ++i)
         if (word.charAt(i) != word.charAt(word.length() - i - 1))
            return false;
      return true;
   }

   public static int reverseNumber(int num)
   {
      return Integer.parseInt(new StringBuilder("" + num).reverse().toString());
   }

   public static int[] getPalindrome(int num)
   {
      var counter = 0;
      var temp = num;
      while (!isPalindrome(temp)) {
         temp = temp + reverseNumber(temp);
         ++counter;
      }
      return new int[] {counter, temp};
   }
}