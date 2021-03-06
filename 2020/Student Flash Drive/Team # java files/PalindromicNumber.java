import java.lang.*;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author  Don Allen
 * @version 2020 Wittry Contest
 */
public class PalindromicNumber
{
    /*
     *   n >= 0
     */
    private static boolean isPalindrome(String word)
    {
        for(int i = 0; i < word.length() / 2; ++i)
            if (word.charAt(i) != word.charAt(word.length() - i - 1))
                return false;
        return true;
    }

    public static boolean isPalindromic( int n ) {
        String word = "" + n;
        return isPalindromic(word, "");
    }

    private static boolean isPalindromic(String word, String out) {
        if (word.length() == 0) {
            return isPalindrome(out);
        }

        for (int i = 0; i < word.length(); ++i)
        {
            var c = word.charAt(i);
            String temp = word.substring(0, i) + word.substring(i + 1);
            if (isPalindromic(temp, out + c))
                return true;
        }
        return false;
    }

    /*
     *     n >= 0
     *     
     *     you may assume the created palidrome will be a legal int value
     */
    /*
    public static int getSmallestPalindrome(int n) {
        var word = "" + n;
        var sb = new StringBuilder();
        var chars = word.chars().boxed().collect(Collectors.toList());
        for(var i = 0; i < chars.size(); i++) {
            var num = (Integer) chars.get(i);
            var c = inString(word, (char) (int) num);
            if ((c & 1) == 1)
                ++c;
            c /= 2;
            while (inString(chars, num) < c)
                chars.add(num);
            while (inString(chars, num) > c) {
                chars.remove(num);
                if (i > 0)
                  --i;
            }
        }
        var smallestNonZero = word.chars().filter(o -> o != '0').min().orElse('1') - '0';
        chars = chars.stream().map(o -> o - (int) '0').sorted((o1, o2) -> {
            if (o1 == 0)
                if (o2 == smallestNonZero)
                    return 1;
                else
                    return -o2;
            if (o2 == 0)
                if (o1 == smallestNonZero)
                    return -1;
                else
                    return o2;
            return o1 - o2;
        }).collect(Collectors.toList());
        for (Integer aChar : chars)
            sb.append(aChar);
        for (int i = chars.size() - 1; i >= 0; --i)
            sb.append(chars.get(i));
        var middleChar = sb.length() / 2;
        if (sb.length() > word.length() && inString(sb, sb.charAt(middleChar)) > inString(word, sb.charAt(middleChar)))
            sb.deleteCharAt(middleChar);
        return Integer.parseInt(sb.toString());
    }*/

    public static int getSmallestPalindrome(int n) {
        var word = n + "";
        var mapping = word.chars().boxed().collect(Collectors.toMap(
                k -> k - '0',
                v -> 1,
                Integer::sum
        ));
        var prefix = "";
        if (mapping.containsKey(0)) {
            var min = mapping.keySet().stream().filter(o -> o != 0).min(Comparator.comparingInt(a -> a)).orElse(1);
            if (mapping.get(min) <= 2)
                mapping.remove(min);
            else
                mapping.put(min, mapping.get(min) - 2);
            prefix += min;
        }
        isPalindrome(word);
        return Integer.parseInt(prefix + palindromize2(mapping) + prefix);
    }

    public static String palindromize2(Map<Integer, Integer> thing) {
        var eci = thing.entrySet().stream().filter(o -> (o.getValue() & 1) == 0).sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        var oci = thing.entrySet().stream().filter(o -> (o.getValue() & 1) == 1).sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        int size = oci.size();
        for(int i = 0; i < size - 1; ++i) {
            var temp = oci.remove(0);
            temp.setValue(temp.getValue() + 1);
            eci.add(temp);
        }
        var mid = "";
        if (oci.size() != 0) {
            var what = oci.get(0);
            if (what.getValue() > 1)
                eci.add(Map.entry(what.getKey(), what.getValue() - 1));
            mid = oci.get(0).getKey() + "";
        }
        eci.sort(Map.Entry.comparingByKey());

        var first = new StringBuilder();
        while (eci.size() != 0) {
            var t = eci.remove(0);
            first.append(("" + t.getKey()).repeat(t.getValue() / 2));
        }

        var second = new StringBuilder(first).reverse().toString();
        return first + mid + second;
    }

    // I call this thing garbage.
    private static String palindromize(Map<Integer, Integer> thing) {
        var oci = thing.entrySet().stream().filter(o -> (o.getValue() & 1) == 1).mapToInt(Map.Entry::getKey).distinct().toArray();
        var len = oci.length;
        int t = 0;

        for (int i = len - 1; i >= len / 2; i--) {
            thing.put(oci[i], thing.get(oci[i]) - 1);
            oci[i] = oci[t];
            thing.put(oci[t], thing.get(oci[t]) + 1);
            t++;
        }

        var first = "";
        var mid = "";

        for (int i = 0; i <= 9; i++) {
            if (!thing.containsKey(i))
                continue;
            var c = thing.get(i);
            t = 0;
            if ((c & 1) == 0) {
                while (t < c / 2) {
                    first += i;
                    ++t;
                }
            } else {
                while (t < (c - 1) / 2) {
                    first += i;
                    t++;
                }
                mid = "" + i;
            }
        }

        var second = new StringBuilder(first).reverse().toString();
        return first + mid + second;
    }

    private static long inString(CharSequence c, char cc) {
        return c.chars().filter(o -> o == cc).count();
    }

    private static long inString(List<Integer> c, int cc) {
        return c.stream().filter(o -> o == cc).count();
    }

    private static long inString(List<Character> c, char cc) {
        return c.stream().filter(o -> o == cc).count();
    }

    /*
    public static int getSmallestPalindrome(int n)
    {
        var chars = ("" + n).chars().mapToObj(o -> o - (int) '0').sorted().collect(Collectors.toList());
        int[] output = new int[Math.min(("" + n).length(), chars.size() * 2 - 1)];
        boolean skipZero = false;
        if (chars.contains(0)) {
            output[1] = 0;
            output[output.length - 2] = 0;
            chars.remove(Integer.valueOf(0));
            skipZero = true;
        }
        for (int i = 0; i < output.length / 2; ++i) {
            if (skipZero && i == 1)
                continue;
            output[i] = chars.get(0);
            output[output.length - 1 - i] = chars.get(0);
            chars.remove(0);
        }
        if (chars.size() != 0)
            output[output.length / 2] = chars.get(0);

        var accum = 0;
        for (int i = output.length - 1; i >= 0; --i) {
            var digit = 1;
            for (int j = 0; j < output.length - 1 - i; j++)
                digit *= 10; // int power
            accum += digit * output[i];
        }
        return accum;
    }
     */
}