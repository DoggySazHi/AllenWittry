import java.lang.*;
import java.util.*;
/**
 * @author  Don Allen
 * @version 2020 Wittry Contest
 */
public class FunWithNaturalNumbers
{
    /*
     *   returns the largest value m such that 1+2+3+…+m <= n
     */
    public static int summation( int n )
    {
        // ai shiteru :)
        return (int) (-1.0 / 2.0 + Math.sqrt(1 + 8 * n) / 2.0);
    }

    /*
     *   returns the largest value m such that 1*2*3*4*m <= n(n+1)
     */
    public static int prod(int n)
    {
        // Yeah uh, gamma function kinda hard to implement here.
        var c = 1;
        var target = n * (n + 1);
        int i = 0;
        while (c <= target)
            c *= ++i;
        return i - 1;
    }

    /*
     *   return a List containing the corresponding group of numbers
     *   
     *   See problem prompt for more details
     */
    public static List<Integer> groupEm(int n)
    {
        List<Integer> ans = new ArrayList<Integer>();
        var startAt = 2 * n * n - 3 * n + 2;
        var count = 2 * n - 1;
        for (int i = startAt; i < startAt + count; ++i)
            ans.add(i);
        return ans;
    }

    /*
     *  returns the sum all the ints from group 1 up to and including group n 
     *          as defined by the groupEm method
     */
    public static int sumThoseGroups(int n)
    {
        return n * n * n * n;
    }
}