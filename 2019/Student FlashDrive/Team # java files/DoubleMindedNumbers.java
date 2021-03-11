import java.lang.*;
import java.util.*;
import java.lang.Math;
import java.util.stream.IntStream;

/**
 * @author  Don Allen
 * @version 2019 Wittry Contest
 */
public class DoubleMindedNumbers
{
    public static boolean isDoubleMindedNumber(int num)
    {
        // I want to try avoiding strings for a "challenge."
        // It's probably less efficient, but eh!
        var freq = new HashMap<Integer, Integer>();
        var length = (int) (Math.log10(num) + 1);
        for(int i = 0; i < length; ++i) {
            var digit = (int) ((num / Math.pow(10, i)) % 10);
            var item = freq.getOrDefault(digit, 0);
            freq.put(digit, item + 1);
        }

        return freq.keySet().size() == length - 1;
    }

    public static int distanceToNextDoubleMindedNumber(int num)
    {
        var dist = 0;
        while (!isDoubleMindedNumber(num + dist))
            ++dist;
        return dist;
    }

    /*   
     *    include min and max
     */
    public static int[] getDoubleMindedBetween(int min, int max)
    {
        return IntStream.rangeClosed(min, max).filter(DoubleMindedNumbers::isDoubleMindedNumber).toArray();
    }
}