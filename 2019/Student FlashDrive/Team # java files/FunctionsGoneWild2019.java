import java.text.DecimalFormat;
import java.util.*;
import java.lang.Math;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * The test class FunctionsGoneWild2015.
 *
 * @author Don Allen
 * @version 2019 Wittry Programming contest
 */
public class FunctionsGoneWild2019 {
    /*
     *
     */
    public static int f1(int a, int n) {
        if (n == 0)
            return 0;
        int b = a;
        for (int i = 0; i < n - 1; i++)
            b = a + a * b + b;
        return b;
    }

    /*
     *    a1 < a2  && b1 < b2
     */
    public static int f2(double a1, double a2, double b1, double b2) {
        a1 = Math.ceil(a1);
        a2 = Math.floor(a2);
        b1 = Math.ceil(b1);
        b2 = Math.floor(b2);
        return (int) ((Math.floor(a2 - a1) + 1) * (Math.floor(b2 - b1) + 1));
    }

    /*
     *
     */
    public static int f3(int n) {
        if (n >= 100)
            if ((n & 1) == 0)
                return f3((3 * n + 2) / 7 - 1) - n / 10;
            else
                return f3((2 * n + 11) / (n + 1)) + 3 * n - 7;
        else if (n > 25)
            return f3(3 * n / 11) / 2 - 2 * f3((n + 18) / 3);
        return (n + 3) * (n + 3) - 1;
    }

    public static int f4(int a, int b, int c) {
        var accum = 0;
        var min = Math.min(b * a - c, b * c - a);
        var max = Math.max(a + b * c, c + a * b);
        for (int i = min; i <= max; ++i)
            accum += i * (c + 2 * b * i) / Math.abs(a + i) + b * (c + 3 * i) / (1 + a) + a * b * i / c;
        return accum;
    }

    public static String f5(String c, double lev) {
        lev = -Math.log10(lev);
        if (c.equals("OH"))
            lev = 14 - lev;
        var db = new DecimalFormat("0.00");
        return db.format(lev);
    }

    public static double f6(double x, double y, double z) {
        if (Math.log(Math.abs(x + z)) < y)
            return Math.log10(Math.abs(Math.pow(Math.PI, 3.0 * y - 2.0 * Math.E))) + Math.log(Math.abs(Math.pow(z * Math.E, x + Math.E)));
        return Math.log10(Math.E * Math.abs(x - y)) + Math.pow(Math.abs(Math.log(Math.abs(z - y))), Math.abs(x * z));
    }

    /*
     *  If the corresponding letters are matching Upper case letter, increase score by 5.
     *  If the corresponding letters are matching Lower case letter, increase score by 4.
     *  If the corresponding letters match but are different case (Lower/Upper), increase score by 3
     *  If the corresponding letters are matching non letters ( only need to check for @, #, & or *) increase score by 2
     *  All others do not increase or decrease score.
     *
     *  precondition phr1.length() ==  phr2.length()
     */
    public static int f7(String phr1, String phr2) {
        int score = 0;
        for(var i = 0; i < phr1.length(); ++i) {
            var a = phr1.charAt(i);
            var b = phr2.charAt(i);
            if (a == b) {
                if (Character.isUpperCase(a))
                    score += 5;
                else if (Character.isLowerCase(a))
                    score += 4;
                else
                    score += 2;
            }
            else if (Character.toLowerCase(a) == Character.toLowerCase(b))
                score += 3;
        }

        return score;
    }

    /*
     *     precondtion:  phrase and String will only contain:
     *                      lower case letters
     *                      spaces
     *
     *                   phrase.length() >= 0
     */
    public static String f8(String phrase) {
        final var consonants = "bkxznhdcwgpvjqtsrlmf";
        final var vowels = "aeiouy";
        return phrase.chars().mapToObj(o -> {
            var index = consonants.indexOf(o);
            if (index >= 0)
                return consonants.charAt((index + 10) % consonants.length());
            index = vowels.indexOf(o);
            if (index >= 0)
                return vowels.charAt((index + 3) % vowels.length());
            return (char) o;
        }).collect(Collector.of(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString));
    }

    public static boolean f9(boolean x, boolean y, boolean z) {
        return !y && z || x && !y;
    }

    public static boolean f10(boolean j, boolean k, boolean m, boolean n) {
        return !j && !m && n || !j && k && !m || k && n || j && m && n;
    }
}