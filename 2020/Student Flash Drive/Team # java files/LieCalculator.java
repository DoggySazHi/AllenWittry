import java.lang.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Don Allen
 * @version 2020 Wittry Contest
 */
public class LieCalculator {
    private int[] numbers;

    /*
     *    nums may contain positive, negative and/or zero
     */
    public LieCalculator(int[] nums) {
        numbers = nums;
    }

    public double getMean() {
        return Arrays.stream(numbers).average().orElse(0);
    }

    public double getMedian() {
        var median = Arrays.stream(numbers).sorted();
        if ((numbers.length & 1) == 0)
            return median.skip(numbers.length / 2 - 1).limit(2).average().orElse(0);
        return median.skip(numbers.length / 2).findFirst().orElse(0);
    }

    /*
     *     if no value appears more than once, return null
     */
    public int[] getMode() {
        // Who the hell let William do this?
        // Y'know, screw it.
        var things = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        if (things.stream().allMatch(o -> o.getValue() == 1))
            return null;
        var maxCount = things.stream().max((a, b) -> (int) (a.getValue() - b.getValue())).orElse(Map.entry(0, 0L)).getValue();
        return things.stream().filter(o -> o.getValue().equals(maxCount)).mapToInt(Map.Entry::getKey).sorted().toArray();
    }

    public int getRange() {
        return Arrays.stream(numbers).max().orElse(0) - Arrays.stream(numbers).min().orElse(0);
    }

    public double getMidRange() {
        var max = Arrays.stream(numbers).max().orElse(0);
        var min = Arrays.stream(numbers).min().orElse(0);
        return (max - min) / 2.0 + min;
    }

    /*
     *   use the divided by n-1 standard deviation
     */
    public double getStandardDeviation() {
        var mean = getMean();
        return Math.sqrt(Arrays.stream(numbers).mapToDouble(o -> Math.pow(o - mean, 2) / (numbers.length - 1)).sum());
    }

    /*
     *
     */
    public double getZscore(double num) {
        return (num - getMean()) / getStandardDeviation();
    }

    /*
     *    this will be int values only
     */
    public int makeMean(int newMean) {
        var sNew = (double) newMean * (numbers.length + 1);
        var sOld = getMean() * (numbers.length);
        return (int) Math.round(sNew - sOld);
    }

    /*
     *    return the number of time newMode needs to be added to the array
     *    to make newMode the only mode of this LieCalculator
     */
    public int makeMode(int newMode) {
        var mode = getMode();
        if (mode != null && mode.length == 1 && Arrays.stream(mode).anyMatch(o -> o == newMode))
            return 0;
        if (mode == null)
            mode = new int[] {numbers[0]};
        int[] finalMode = mode;
        var target = Arrays.stream(numbers).filter(o -> o == finalMode[0]).count();
        var current = Arrays.stream(numbers).filter(o -> o == newMode).count();
        return (int) (target - current + 1);
    }

    /*
     *    small value first, larger Value second
     */
    public int[] makeRange(int newRange) {
        var max = Arrays.stream(numbers).max().orElse(0);
        var min = Arrays.stream(numbers).min().orElse(0);
        return new int[]{max - newRange, min + newRange};
    }

    /*
     *    newMidRange != getMidRange()
     */
    public int makeMidRange(int newMidRange) {
        var max = Arrays.stream(numbers).max().orElse(0);
        var min = Arrays.stream(numbers).min().orElse(0);
        var newMax = 2 * (newMidRange - min) + min;
        var newMin = 2 * newMidRange - max;
        if (newMax < max)
            return newMin;
        return newMax;
    }

    /*
     *    You may assume there exist an int,
     *    that when added to nums[] will make the Standard Deviation newSD
     */
    public int makeStandardDeviation(double newSD) {
        // Ok, hopefully AP Stats is teaching me something...
        var oldMean = getMean();
        var oldStdDev = getStandardDeviation();
        var oldVariance = Math.pow(oldStdDev, 2);
        // var newTempMean = (oldMean * numbers.length) / (numbers.length + 1); // out / (num.len + 1)
        var newVariance = Math.pow(newSD, 2);

        // WHAT THE HELL IS THIS HOLY CRAP
        // mukyu
        var a = ((double) numbers.length * oldMean + Math.sqrt(Math.pow(numbers.length, 3) * newVariance - Math.pow(numbers.length, 3) * oldVariance + Math.pow(numbers.length, 2) * newVariance + (double) numbers.length * oldVariance)) / (double) numbers.length;
        var b = ((double) numbers.length * oldMean - Math.sqrt(Math.pow(numbers.length, 3) * newVariance - Math.pow(numbers.length, 3) * oldVariance + Math.pow(numbers.length, 2) * newVariance + (double) numbers.length * oldVariance)) / (double) numbers.length;
        if (Math.abs(a - Math.round(a)) > 0.01)
            return (int) Math.round(b);
        if (Math.abs(b - Math.round(b)) > 0.01)
            return (int) Math.round(a);
        var diff = Math.abs(a) - Math.abs(b);
        if (diff > 0)
            return (int) Math.round(b);
        if (diff < 0)
            return (int) Math.round(a);
        return (int) Math.round(a > 0 ? a : b);
    }
}