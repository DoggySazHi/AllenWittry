import java.util.*;
import java.lang.Math;
import java.lang.Number;
import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Monster Year.
 *
 * @author  
 * @version (a version number or a date)
 */
public class MonsterYear
{
/*
 * 1000 < y < 10000
 */
   public static boolean isMonsterYear(int y)
   {
       return (y / 100 + y % 100) == ((y / 10) % 100);
   }

/*
 * if s (or f) is a MonsterYear, it should be included in the array that is returned
 */
   public static int[] getMonsterYearBetween(int s, int f)
   {
       return IntStream.rangeClosed(s, f).filter(MonsterYear::isMonsterYear).toArray();
   }
}