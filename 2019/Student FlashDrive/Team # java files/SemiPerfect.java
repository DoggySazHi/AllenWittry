import java.util.*;
import java.lang.Math;
import java.util.stream.Collectors;

/**
 * The test class FunctionsGoneWild2015.
 *
 * @author Don Allen
 * @version 2019 Wittry Programming contest
 */
public class SemiPerfect {
    /*
     *   precondition:  num > 1
     *
     *   returns a sorted array (smallest to largest) containing all divisor of the the parameter num
     *
     *          returns all values n, 1 <= n < num, such that num % n == 0
     *
     *          getDivisors(num)[k] < getDivisors(num)[k+1],  0 < k < getDivisors(num).length - 1
     *
     */
    public static int[] getDivisors(int num) {
        var divisors = new ArrayList<Integer>();
        for (int i = 1; i <= Math.sqrt(num); ++i)
            if (num % i == 0)
                divisors.add(i);
        return divisors.stream().map(o -> {
            if (o == 1)
                return new int[] {o};
            return new int[] {o, num / o};
        }).flatMapToInt(Arrays::stream).distinct().sorted().toArray();
    }

    /*
     *   precondition:  num > 1
     *
     *   returns true if a subset of all divisors num less than num, sum to the value num
     *
     */
    public static boolean isSemiPerfect(int num) {
        return isSemiPerfect(num, Arrays.stream(getDivisors(num)).boxed().collect(Collectors.toList()));
    }

    // Hey, it takes forever, but it works!
    private static boolean isSemiPerfect(int target, List<Integer> remaining) {
        if (target < 0)
            return false;
        if (target == 0)
            return true;
        for(int k = remaining.size() - 1; k >= 0; k--) {
            var i = remaining.get(k);
            var temp = new ArrayList<>(remaining);
            temp.remove(i);
            if (isSemiPerfect(target - i, temp))
                return true;
        }
        return false;
    }
}