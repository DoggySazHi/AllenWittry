import java.util.stream.IntStream;

public class UnitSummation
{
   public boolean isUnitSummation(int n)
   {
      var str = "" + n;
      str = str.substring(0, str.length() - 1);
      return str.chars().map(o -> o - '0').sum() == n % 10;
   }
   
   public int[] getUnitSummationBetween(int first, int last)
   {
      return IntStream.rangeClosed(first, last).filter(this::isUnitSummation).toArray();
   }
}