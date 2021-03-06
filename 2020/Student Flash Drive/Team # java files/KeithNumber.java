import java.util.*;
import java.lang.Math;
import java.lang.Number;
import java.math.BigInteger;
import java.util.stream.Collectors;

/**
 * BinaryStrings
 *
 * @author  Mr. Allen
 * @version (a version number or a date)
 */
public class KeithNumber
{
    private final int kNum;
    private final int length;
    private final List<Integer> numbers;
    
    public KeithNumber(int num)
    {
        kNum = num;
        numbers = new ArrayList<>();
        var s = "" + num;
        length = s.length();
        var number = s.toCharArray();
        for(var c : number)
            numbers.add(c - '0');
    }

    /*
     *     n > 0
     */
    public int[] getNterms(int n)
    {
        var out = new int[n];
        while (numbers.size() < n) {
            var accum = 0;
            for (int i = numbers.size() - length; i < numbers.size(); i++)
                accum += numbers.get(i);
            numbers.add(accum);
        }
        for(int i = 0; i < n; i++)
            out[i] = numbers.get(i);
        return out;
    }

    public boolean isKeithNumber()
    {
        while (numbers.get(numbers.size() - 1) < kNum) {
            var accum = 0;
            for (int i = numbers.size() - length; i < numbers.size(); i++)
                accum += numbers.get(i);
            numbers.add(accum);
        }

        return numbers.contains(kNum);
    }
}