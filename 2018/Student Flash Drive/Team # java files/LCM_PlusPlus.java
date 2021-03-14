import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Don Allen
 * @version 2018 Wittry Contest
 */
public class LCM_PlusPlus
{
    /*
     *   returns the LCM of x and y
     */
    public static int LCMof2Numbers(int x, int y)
    {
        var m = (long) x * (long) y;
        while (y != 0) {
            var a = y;
            y = x % y;
            x = a;
        }
        return (int) (m / x);
    }

    /*
     *   returns the LCM of all ints in the parameter nums
     *   
     *   precondition:  nums.length >= 2
     */
    public static int LCMofMultipleNumbers(int[] nums)
    {
        return Arrays.stream(nums).reduce(LCM_PlusPlus::LCMof2Numbers).orElseThrow(() -> new RuntimeException(":reimuthink:"));
    }

    /*
     *    Implement the following function which returns
     *        the smallest positive integer values y that satisfiy:
     *
     *        Given x and the least common multiple of x and y ( lcm(x, y) ), find y.
     */
    public static int minLCMValue(int lcm, int x)
    {
        int y = lcm / x;
        while (LCMof2Numbers(x, y) != lcm) {
            ++y;
        }
        return y;
    }
}