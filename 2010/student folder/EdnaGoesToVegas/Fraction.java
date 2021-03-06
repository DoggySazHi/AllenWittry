//  all values will be less than or equal to 1.

public class Fraction {
    private int top;
    private int bottom;

    public Fraction(int t, int b) {
        top = t;
        bottom = b;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    public void add(Fraction f) {
        top = top * f.bottom + f.top * bottom;
        bottom *= f.bottom;
        simplify();
    }

    public void multiply(Fraction f) {
        top *= f.top;
        bottom *= f.bottom;
        simplify();
    }

    private void simplify() {
        var gcd = gcd(top, bottom);
        top /= gcd;
        bottom /= gcd;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Fraction))
            return false;
        Fraction temp = (Fraction) obj;
        return top == temp.getTop() && bottom == temp.getBottom();
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}