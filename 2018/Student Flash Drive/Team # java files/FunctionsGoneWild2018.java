import java.util.*;
import java.lang.Math;
import java.util.stream.Collectors;

/**
 * The test class FunctionsGoneWild2015.
 *
 * @author  Don Allen
 * @version 2018 Wittry Programming contest
 */
public class FunctionsGoneWild2018
{
    /*
     *   borrowed from March 2017 issue of NCTM  monthly magizine
     *   
     *   
     *     return the smallest positive value of d such that n + d is a perfect square
     *     
     *     you may assume n + d is not too big
     */
    public static int f1(int n)
    {
        return (int) Math.round(Math.pow(Math.ceil(Math.sqrt(n)), 2) - n);
    }

    
    /*
     *    Implement the following function which returns the number of ints that satisfies the inequality:
     *    
     *    low < 5y + 7 <= high
     */   
    public static int f2(int low, int high)
    {
        var minorg = (low - 7.0) / 5.0;
        var min = Math.ceil((low - 7.0) / 5.0);
        if (min == minorg) // Handle exclusive lower bound.
            ++min;
        var max = Math.floor((high - 7.0) / 5.0);

        return (int) (max - min) + 1; // Magic number 1. Don't ask. (Probably because inclusive upper bound)
    }

    public static int f3(int n)
    {
        if (n >= 100)
            if ((n & 1) == 0)
                return f3(3 * n / 5 - 1) - 2;
            else
                return f3((2 * n - 13) / 21) - n / 3;
        else if (n > 50)
            return f3(2 * n / 5) - f3((n - 5) / 3) / 2;
        return n * n + 3 * n - 19;
    }
    

    public static int f4(int a, int b, int c)
    {
        var accum = 0;
        for(int i = Math.min(b * a - c, b * c - a); i <= Math.max(a + b * c, c + a * b); ++i)
            accum += i * (c + 2 * b * i) / (1 + Math.abs(a - i)) + (b + (c + 3) * a * i) / (1 + i / c) + (i + 3 * a * b) * i;
        return accum;
    }

    public static double f5(double x, double y)
    {
        return Math.pow(Math.abs(Math.tan(Math.E - 3.0 * y) / Math.sin(y)), Math.PI * Math.cos(x));
    }

    public static double f6(double x, double y, double z)
    {
        if (Math.log(Math.abs(x)) > y + z)
            return Math.pow(Math.PI, x / Math.E) + Math.pow(Math.log10(Math.abs(y + z)), Math.log10(Math.abs(x + y)));
        return Math.log10(Math.abs(x - y)) + Math.log(Math.abs(z -y));
    }

    /*
    precondition phrase.length > 0 
                 num > 0
    
    F7("Sample", 2)
       returns {"SML", "APE"}
    F7("HELP ME FIGURE THIS OUT :(", 3)
       returns {"HPEIRTSU", "E  GEH T(", "LMFU IO "}
    F7("COMPUTER SCIENCE", 4)
       returns {"CU E", "OTSN", "MECC", "PRIE"}
    F7("TO ITERATE IS HUMAN, TO RECURSE DIVINE", 5)
       returns {"TE U EEI", "ORIMTC N", " ASAOUDE", "IT N RI", "TEH,RSV"}
    F7("1234567890", 5)
       returns {"16", "27", "38", "49", "50"}
    F7("@ABC!", 7)
       returns {"@", "A", "B", "C", "!", "", ""}
     */
    public static String[] f7(String phrase, int num)
    {
        // 夢見てる? なにも見てない?
        var out = new String[num];
        for(int i = 0; i < num; ++i)
            out[i] = "";
        for (int i = 0; i < phrase.length(); ++i)
            out[i % num] += phrase.charAt(i);
        return out;
    }

    /*
     *     precondtion:  phrase and String will only contain:
     *                      Upper case letters
     *                      spaces
     *
     *                   phrase.length() >= 0
     */
    public static String f8(String phrase)
    {
        // I thought this was FunctionsGoneWild, not "actually think about programming"!
        // How to be lazy: reuse the test data.
        final var keyMap = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        final var valMap = "YFI PREBS CUWOX HWN DRZQK WVIU YFI ALMT JWG";
        return phrase.chars().map(o -> valMap.charAt(keyMap.indexOf(o))).mapToObj(o -> "" + (char) o).collect(Collectors.joining());
    }

    public static boolean f9(boolean x, boolean y, boolean z)
    {
        return !x && !y || x && z;
    }

    public static boolean f10(boolean j, boolean k, boolean m, boolean n)
    {
        return !j && !k && !m || !m && n || !j && k && m && !n || j && n || j && k && !m;
    }
}