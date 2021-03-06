import java.util.*;
import java.lang.Math;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The test class FunctionsGoneWild2020.
 *
 * @author  Don Allen
 * @version 2020 Wittry Programming contest
 */
public class FunctionsGoneWild2020
{
    /*
     *   n > 1
     */
    public static int f1(int n)
    {
        return 3 * n * n - 3 * n + 1;
    }

    /*
     *    String str looks like #...#a#...#b#...#,
     *    where #...# represents a 0 or more consecutive digits [0, 9}
     *    you may assume when a and are replaced ith a 9, the value is still a valid int
     *    you may assume a will be to the left of b
     *    a may be the leading digit, and a may be replaced by 0
     *    
     *    all values should be positive
     *    
     *    div != 0
     */   
    public static int f2(String str ,int div)
    {
        int counter = 0;
        for(int a = 0; a <= 9; a++)
            for(int b = 0; b <= 9; b++)
                if (Integer.parseInt(str.replace("a", "" + a).replace("b", "" + b)) % div == 0)
                    counter++;

        return counter;
    }

    /*
     *    n > 0
     */    
    public static int f3(int n)
    {
        if (n >= 200)
            if ((n & 1) == 0)
                return f3((2 * n * n + 21)/(5*(n-25))) + n / 3;
            else
                return f3((12 * n + 27)/(11 * n)+n/5)+25;
        else if (n > 50)
            return f3(n % 20) + n;
        else
            return (n - 2) * (n - 2);
    }

    /*
     *    if min(ab + c, bc + a) < max(a-b, 1 - |b-c|), return 0
     */
    public static int f4(int a, int b, int c)
    {
        var accum = 0;
        var start = Math.max(a - b, 1 + Math.abs(b - c));
        var end = Math.min(a * b + c, b * c + a);
        for(var i = start; i <= end; i++)
            // que?
            accum += ((3 * a * (a + b))/(1 + a * Math.abs(b - c))) * i * i + ((Math.max(b, c) * Math.min(a * b, Math.abs(a - c)))/Math.max(1, Math.max(a, b) - Math.min(b, c)) * i);
        return accum;
    }

    /*
     *    num > 0
     *    div > 0
     */
    public static int f5(int num, int div)
    {
        int i = 0;
        int newNum = num * 10 + i;
        while (newNum % div != 0) {
            ++i;
            newNum = Integer.parseInt(num + "" + i);
        }
        return i;
    }

    public static double f6(double x, double y, double z)
    {
        if (Math.sin(x) > Math.cos(z / y))
            return 10 * Math.log10(Math.pow(Math.PI, x + z));
        return 25 * Math.log(Math.pow(y, Math.E + z));
    }

    /*
     *   phr1 will contain only spaces, Upper case letters, Lower case letters, numbers, periods and question marks
     *   
     *   since only lower ase letters are return, ignore all other characters (spaces, Upper case letters, Lower case letters, numbers, periods and question marks)
     */
    public static String f7(String phr1)
    {
        return phr1.chars().mapToObj(o -> {
            var set = new TreeSet<Character>();
            for(int i = 'a'; i <= 'z'; ++i)
                if (i != o)
                    set.add((char) i);
            return set;
        }).reduce((a, b) -> {
            a.retainAll(b);
            return a;
        }).orElse(new TreeSet<>()).stream().sorted().map(o -> "" + (char) o).collect(Collectors.joining());
    }

    /*
     *     precondtion:  phrase will only contain:
     *                      Upper case letters
     *                      spaces
     *                      
     *                   phrase.length() >= 0
     */
    public static String f8(String phrase)
    {
        var editor = phrase.toCharArray();
        for(int i = 0; i < editor.length; i++) {
            var c = (int) editor[i];
            if (c >= 'A' && c <= 'J')
                editor[i] = (char) (c + 5);
            else if (c >= 'K' && c <= 'O')
                editor[i] = (char) ((int) 'A' + (int) 'O' - c);
            else if (c >= 'P' && c <= 'Z')
                editor[i] = (char) ((int) 'Z' + (int) 'P' - c);
        }

        return new String(editor);
    }

    public static boolean f9(boolean x, boolean y, boolean z)
    {
        return !y && !z || !x && y && z || x && !z;
    }

    public static boolean f10(boolean j, boolean k, boolean m, boolean n)
    {
        return !j && !m && n || !j && m && !n || !j && k && m || j && !m && !n || j && k && !m;
    }
}