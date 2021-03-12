import java.lang.*;
import java.util.*;

/**
 * @author Don Allen
 * @version 2019 Wittry Contest
 */
public class MIU_System {
    private final String seed;

    /*
     *   s.indexOf("M") == 0
     *
     *   s.substring(1).indexOf("M") == -1
     *
     *   Make a copy of s
     */
    public MIU_System(String s) {
        seed = s;
    }

    /*
     *   double entire String following M
     *
     *   Do not modify seed
     */
    public String doubleAfterM() {
        return doubleAfterM(seed);
    }

    private String doubleAfterM(String s) {
        return "M" + s.substring(1).repeat(2);
    }

    /*
     *   ends with I, add U
     *
     *   Do not modify seed
     */
    public String endsWithI() {
        return endsWithI(seed);
    }

    private String endsWithI(String s) {
        if (s.endsWith("I"))
            return s + "U";
        return s;
    }

    /*
     *   3 consecutive I's can be replaced by a single U
     *
     *   if more than one string of 3 consecutive I's exist,
     *      replace the first (lowest index) group of 3 consecutive I's
     *
     *   Do not modify seed
     */
    public String trade3IsForSingleU() {
        return trade3IsForSingleU(seed);
    }

    private String trade3IsForSingleU(String s) {
        var firstTriple = s.indexOf("III");
        if (firstTriple >= 0)
            return s.substring(0, firstTriple) + "U" + s.substring(firstTriple + 3);
        return s;
    }

    /*
     *   All occurences of UU are removed
     *
     *   Do not modify seed
     */
    public String remove2Us() {
        return remove2Us(seed);
    }

    private String remove2Us(String s) {
        return s.replace("UU", "");
    }

    /*
     *   return true if applying any of the MIU_System modifications will create the String target
     *        endsWithI
     *        doubleAfterM
     *        trade3IsForSingleU
     *        remove2Us
     *
     *   Do not modify seed
     */
    public boolean isPossible(String target) {
        return endsWithI().equals(target) || doubleAfterM().equals(target) || trade3IsForSingleU().equals(target) || remove2Us().equals(target);
    }

    /*
     *   return minimum number of MIU_System modifications methods required to change seed such that it is equals to target
     *
     *   It is possible to modify (a copy of) seed such that it is equal to target using 9 or fewer of the modifing methods in this class
     *
     *   Do not modify seed
     *
     *   max returned value < 10
     */

    // Did I first-try recursion? Cool!
    public int minNumModifications(String target) {
        if (seed.equals(target))
            return 0;
        return minNumModifications(seed, target, 1);
    }

    private int minNumModifications(String s, String target, int iterations) {
        if (iterations == 10)
            return 100; // Arbitrarily large number, bigger than 10.
        var a = endsWithI(s);
        var b = doubleAfterM(s);
        var c = trade3IsForSingleU(s);
        var d = remove2Us(s);
        if (a.equals(target) || b.equals(target) || c.equals(target) || d.equals(target))
            return iterations;
        var aa = minNumModifications(a, target, iterations + 1);
        var bb = minNumModifications(b, target, iterations + 1);
        var cc = minNumModifications(c, target, iterations + 1);
        var dd = minNumModifications(d, target, iterations + 1);
        return Math.min(aa, Math.min(bb, Math.min(cc, dd)));
    }
}