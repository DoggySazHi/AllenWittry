/**
 * @author:   Mr. Allen
 *            2017 Wittry contest
 */
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class PizzaHutPiDayProblem1
{
   public static List<String> pizzaHut2016EasyPiDayProblem(int max){
      return LongStream.range((long) Math.pow(10 , max - 1), (long) Math.pow(10, max))
              .parallel() // Holy crap it takes forever.
              .filter(o -> {
                  for (long j = 1; j <= max; ++j)
                     if ((o / (long) Math.pow(10, max - j)) % j != 0)
                        return false;
                  var str = "" + o;
                  return str.chars().distinct().count() == str.length();
               })
              .mapToObj(Long::toString)
              .collect(Collectors.toList());
   }
}