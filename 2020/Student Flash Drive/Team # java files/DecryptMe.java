import java.lang.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Don Allen
 * @version 2020 Wittry Contest
 */
public class DecryptMe {
    /*
     *   Treturns the maximum number of times a specific letter (let) may appear in an encoded message, mess.
     */

    public static int countLetter(String mess, int let) {
        var counter = 0;
        var len = ("" + let).length();
        for (int i = 0; i < mess.length() - len + 1; i++) {
            var out = tryParse(mess.substring(i, i + len));
            if (out.success && out.num == let && (i > mess.length() - len - 1 || mess.charAt(i + len) != '0')) {
                counter++;
                i += len - 1;
            }
        }
        return counter;
    }

    /*
     *    counts the maximum number of times the letter in lets appears in mess
     *    that is, the max sum of the number of times each letter in the int[] lets could be in mess.
     *
     *    precondition lets sorted in ascending order
     */

    public static int groupCounter(String mess, int[] lets) {
        var sb = new StringBuilder(mess);
        var list = Arrays.stream(lets).boxed().collect(Collectors.toList());
        var counterMax = 0;
        for (int k = 0; k < list.size(); k++) {
            var temp = groupCounter(sb, list, k);
            if (temp > counterMax)
                counterMax = temp;
        }
        return counterMax;
    }

    private static int groupCounter(StringBuilder curr, List<Integer> left, int startAt) {
        var sb = new StringBuilder(curr.toString());
        var list = new ArrayList<>(left);
        var counter = 0;
        var o = left.get(startAt);
        var remove = "" + o;

        var regex = Pattern.compile("(" + o + "(?!0))").matcher(sb); // william, why did you
        while (regex.find()) { // but it works!
            var i = regex.start();
            sb.replace(i, i + remove.length(), " ".repeat(remove.length()));
            counter++;
        }
        list.remove(startAt);
        var counterMax = 0;
        for (int k = 0; k < list.size(); k++) {
            var temp = groupCounter(sb, list, k);
            if (temp > counterMax)
                counterMax = temp;
        }
        return counterMax + counter;
    }

    /*
     *    precondition: lets is sorted in ascending order
     *                  messages.size() > 0
     *
     *   returns the message or messages in messages with the maximum sum of possible occurrences
     *   of the letters contained in lets.
     *   All messages with the maximum sum must be returned in List of Strings.
     */
    public static List<String> getBestMessage(String[] messages, int[] lets) {
        var v = Arrays.stream(messages).map(o -> Map.entry(o, groupCounter(o, lets))).sorted(Comparator.comparingInt(Map.Entry::getValue)).collect(Collectors.toList());
        var max = v.get(v.size() - 1).getValue();
        return v.stream().filter(o -> o.getValue().equals(max)).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    private static class NumberParse {
        int num;
        boolean success;

        NumberParse(int num, boolean success) {
            this.num = num;
            this.success = success;
        }
    }

    private static NumberParse tryParse(String s) {
        int num;
        try {
            num = Integer.parseInt(s);
        } catch (Exception e) {
            return new NumberParse(0, false);
        }
        return new NumberParse(num, true);
    }

    public static int numDecryption(String mess) {
        // What if we didn't do this with recursion?
        // counters[0]: current, counters[1]: "recursive" case (aka, when we have a 11-26)

        int[] counters = {1, 0};
        for (int i = 0; i < mess.length(); ++i) {
            int k = 0;
            if ((i > 0) && ((mess.charAt(i - 1) == '1') || (mess.charAt(i - 1) == '2' && mess.charAt(i) < '7')))
                k += counters[1];
            if (mess.charAt(i) > '0')
                k += counters[0];
            counters[1] = counters[0];
            counters[0] = k;
        }
        return counters[0];
    }
}