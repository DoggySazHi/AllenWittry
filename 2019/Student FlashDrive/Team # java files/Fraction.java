import java.lang.*;
/**
 * @author  Don Allen
 * @version 2019 Wittry Contest
 */
public class Fraction implements Comparable<Fraction>
{
    // instance variables - replace the example below with your own
    private int num;
    private int denom;

    /**
     * Constructor for objects of class Fraction
     */
    public Fraction(int n, int d)
    {
        num = n;
        denom = d;
        reduce();
    }

    public int getNumerator()
    {
        return num;
    }

    public int getDenominator()
    {
        return denom;
    }

    public void reduce()
    {
        var gcd = gcd(num, denom);
        num /= gcd;
        denom /= gcd;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            var t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public int hashCode()
    {
        return Integer.valueOf(num).hashCode() + Integer.valueOf(num).hashCode();
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Fraction))
            return false;
        Fraction f = (Fraction)obj;
        return num == f.getNumerator() && denom == f.getDenominator();
    }

    @Override
    public int compareTo(Fraction f) {
        return (int) Math.signum((double) num / (double) denom - (double) f.num / (double) f.denom);
    }

    public double getDecimal() {
        return (double) num / (double) denom;
    }
}
