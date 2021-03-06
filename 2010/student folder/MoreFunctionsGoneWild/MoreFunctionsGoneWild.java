import java.util.*;
import java.lang.Math;

/**
 * The test class studentTest.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MoreFunctionsGoneWild {
    public static int f1(int n) {
        if (n >= 75)
            if (n % 2 == 0)
                return 11 * f1(n - n / 2 - 1) - f1(n / 2 - 2);
            else
                // who tf made this order of operations
                return f1((2 * n - 1) / 2) + 2 * f1(2 + (3 * n) % 5);
        else if (n >= 25)
            return 4 * f1(n - 13) - f1(n - 17) + 2 * n;
        return n * n * n - 2 * n * n + 4 * n + 11;
    }

    public static double f2(double x) {
        return ((2.0 * x * x * x - 15.0 * x - 3) * (x * x + 7 * x)) / (2 - 7.3 / 2.0 * x - 3 * x * x) - 121.9 / 169.36;
    }

    public static double f3(double x, double y, double z) {
        return 3 * Math.sqrt(2.0 / x) + Math.pow(z, x) / (3.0 * x * y * y + 11) + Math.sqrt(7.0 * x - 3.0 * y + z) / Math.pow(z, x + 2.0 * y);
    }

    public static double f4(double a, double b) {
        return Math.log(4.0 * a - b) - Math.pow(Math.sqrt(8.0 * b + a), Math.log(b));
    }

    public static double f5(double a, double b) {
        if (a * b > 0)
            return Math.pow(Math.PI, Math.log10(b)) + Math.pow(Math.log10(a), Math.sqrt(5.0 * a + 3.0 * b));
        return Math.pow(Math.E, Math.log10(99 + Math.pow(b, 1.0 / a))) + (Math.PI + b) / (Math.PI - Math.E);
    }

    public static double f6(double x, double y, double z) {
        return Math.pow(x, Math.tan(x + y)) + Math.pow(Math.abs(Math.cos(y)), Math.sqrt(Math.tan(z))) / (3.0 * Math.pow(x, 5.0 * y) + y * Math.pow(z, Math.sqrt(1.0 / x))) + (2 * Math.pow(x, x) - 2 * Math.pow(z, z)) / (x - Math.pow((z - y) / (y - x), z));
    }

    public static boolean f7(boolean x, boolean y, boolean z) {
        int num = 0;
        if (x) num |= 0b0100;
        if (y) num |= 0b0010;
        if (z) num |= 0b0001;
        switch (num) {
            case 0:
                return true;
            case 1:
                return false;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return false;
            case 5:
                return true;
            case 6:
                return false;
            case 7:
                return true;
        }
        return false; // no
    }

    public static boolean f8(boolean j, boolean k, boolean m, boolean n) {
        int num = 0;
        if (j) num |= 0b1000;
        if (k) num |= 0b0100;
        if (m) num |= 0b0010;
        if (n) num |= 0b0001;
        switch (num) {
            case 0:
                return true;
            case 1:
                return false;
            case 2:
                return true;
            case 3:
                return false;
            case 4:
                return false;
            case 5:
                return true;
            case 6:
                return false;
            case 7:
                return true;
            case 8:
                return true;
            case 9:
                return false;
            case 10:
                return false;
            case 11:
                return true;
            case 12:
                return true;
            case 13:
                return true;
            case 14:
                return false;
            case 15:
                return true;
        }
        return false; // no
    }

    public static double f9(double a, double b, double x, double y, double z) {
        return Math.pow(f3(x, 4.0 * y, a), Math.PI) + Math.sqrt(f5(b, f4(z * Math.PI, Math.E / 2.0))) / f6(Math.cos(x), y, z);
    }


    public static boolean f10(boolean a, boolean b, boolean c, boolean d) {
        return f8(f7(a, b, c), f7(a && d, a || b, d), f7(c, d, a), a && b || !(c && !d));
    }
}