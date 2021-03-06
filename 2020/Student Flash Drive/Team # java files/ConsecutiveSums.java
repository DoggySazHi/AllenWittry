import java.lang.*;
import java.util.*;
/**
 * @author  Don Allen
 * @version 2020 Wittry Contest
 */
public class ConsecutiveSums
{
/*
 *    return an int[] containing n consecutive Positive int values (in ascending order) which sum to num.
 *
 *    if no int[] exist, return null
 */    
    public static int[] theseIntsSumTo(int num, int n)
    {
        var first = (float) num / (float) n - (float) n / 2 + 1.0f/2.0f;
        if (Math.abs(first - (int) first) > 0.01)
            return null;
        var out = new int[n];
        var f = (int) first;
        for(int i = f; i < f + n; i++)
            out[i - f] = i;
        return out;
    }

/*
 *     return in int[] (with the smallest length) containing consecutive Positive int values (in ascending order)
 *            which sum to num.
 *
 *     if no int[] exist, return null
*/
    public static int[] fewestConsecutiveIntegersSumTo(int num)
    {
        int n = 2;
        while (n * (n + 1) / 2 < num) {
            var out = theseIntsSumTo(num, n++);
            if (out != null)
                return out;
        }
        return null;
    }

/*
 *     return   int[] (with the largest length) containing consecutive Positive int values (in ascending order)
 *              which sum to num.
 *
 *     if no int[] exist, return null
*/
    public static int[] longestConsecutiveIntegersSumTo(int num)
    {
        int n = (int) Math.floor(Math.sqrt(1 + 8 * num) / 2 - 1.0/2.0);
        while (n >= 2) {
            var out = theseIntsSumTo(num, n--);
            if (out != null)
                return out;
        }
        return null;
    }

/*
 *    return the smallest number Greater than (not equal to) num
 *           that cannot be expressed as a sum of n consectuive int
 */    
    public static int smallestNumberGreaterThan(int num)
    {
        for(int i = num + 1; true; i++) {
            if (longestConsecutiveIntegersSumTo(i) == null)
                return i;
        }
    }
}