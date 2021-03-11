import java.lang.*;
import java.util.*;
import java.lang.Math;

/**
 * @author Don Allen
 * @version 2019 Wittry Contest
 */
public class FareySequence {
    /*
     *     0 < num < 1
     *
     *     0 <= f1 <= 1,  0 <= f2 <= 1
     *
     *     returns a Fraction with in 0.001 of num
     */
    public static Fraction getApproximation(double num, Fraction leftBound, Fraction rightBound) {
        while (true) {
            var newBound = new Fraction(rightBound.getNumerator() + leftBound.getNumerator(),
                    rightBound.getDenominator() + leftBound.getDenominator());
            var nb = newBound.getDecimal();
            if (Math.abs(num - nb) < 0.001)
                return newBound;
            if (num < nb)
                rightBound = newBound;
            else
                leftBound = newBound;
        }
    }

    /*
     *   n >= 1
     *
     *   n < 25
     *
     *   return List must be sorted in ascending order
     */
    public static List<Fraction> generateOrder(int n) {
        var output = new TreeSet<Fraction>();
        generateOrder(n, output);
        return new ArrayList<>(output);
    }

    private static void generateOrder(int n, Set<Fraction> fracs) {
        if (n == 0)
            return;
        for(int i = 0; i <= n; i++)
            fracs.add(new Fraction(i, n));
        generateOrder(n - 1, fracs);
    }
}