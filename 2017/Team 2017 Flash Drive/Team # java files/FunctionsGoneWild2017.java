import java.util.*;
import java.lang.Math;
import java.util.stream.Collectors;

/**
 * The test class FunctionsGoneWild2015.
 *
 * @author Don Allen
 * @version 2017 Wittry Programming contest
 */
public class FunctionsGoneWild2017 {
    public static int f1(int n) {
        if (n >= 150)
            if ((n & 1) == 0)
                return f1(2 * n / 3 - 3) - 2 * n;
            else
                return f1((n - 3) / 11) - n;
        else if (n >= 25)
            return f1(n / 13) + f1((n - 11) / 7);
        return n * n - 7 * n - 9;
    }

    public static double f2(double x) {
        return 10.0 * Math.PI * Math.pow(Math.abs(Math.cos(2.0 * x)), -1.0 * Math.E) * Math.sin(x - Math.PI / 3.0);
    }

    public static double f3(double x, double y) {
        return x * Math.E * Math.tan(Math.PI * y) / (2.0 * x - 3.0 * y);
    }

    public static double f4(double x, double y) {
        return Math.max(Math.cos(Math.abs(x) / 3.0), Math.tan(Math.min(y, x))) * Math.min(x * Math.sin(y) / 2.0, y * Math.sin(x));
    }

    public static double f5(double x, double y, double z) {
        if (z > 2.0 * y - x)
            return Math.log10(Math.abs(z)) * Math.pow(Math.log(Math.abs(4.0 * y)), Math.log10(Math.abs(x + Math.log(Math.abs(y)))));
        return Math.pow((Math.pow(Math.E, x) + Math.pow(Math.PI, z)) / (x - y * z / Math.PI), Math.abs(x + y + z));
    }

    public static int f6(int a, int b, int c) {
        var accum = 0;
        for(int i = Math.min(a, c - a); i <= Math.min(c, a + b); ++i)
            accum += (a * i / 3 + (3 * b - i) / c + c * c / 5 / b) / ((a + i) * c) + b * i;
        return accum;
    }

    /*
     *     precondtion:  phrase will only contain:
     *                      Capital Letters
     *                      spaces
     *
     *                   phrase.length() >= 0
     */
    public static String f7(String phrase) {
        final var in = "QWERTYUIOPASDFGHJKLZXCVBNM ";
        final var out = "WERTYUIOPQSDFGHJKLAXCVBNMZ ";
        return phrase.chars()
                .map(o -> out.charAt(in.indexOf(o)))
                .mapToObj(o -> "" + (char) o)
                .collect(Collectors.joining());
    }

    /*
     *     precondtion:  phrase and String will only contain:
     *                      Upper case letters
     *                      spaces
     *
     *                   phrase.length() >= 0, str.length() >= 0
     */
    public static String f8(String phrase, String s) {
        for (var i = 0; i < s.length(); ++i)
            phrase = phrase.replace("" + s.charAt(i), "");
        return phrase;
    }

    public static boolean f9(boolean x, boolean y, boolean z) {
        return !x && !z || !y && !z || x && y && z;
    }

    public static boolean f10(boolean j, boolean k, boolean m, boolean n) {
        return !j && !k && !n || !k && !m && !n || k && n || j && m && n;
    }
}