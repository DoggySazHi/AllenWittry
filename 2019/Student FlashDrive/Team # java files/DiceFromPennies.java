import java.util.*;
import java.lang.Math;
/**
 * The test class FunctionsGoneWild2015.
 *
 * @author  Don Allen
 * @version 2019 Wittry Programming contest
 */
public class DiceFromPennies
{
    private int mySides;
    /*
     *    1 < numSides <= 32
     */
    public DiceFromPennies(int numSides)
    {
        mySides = numSides;
    }

    /*
     *    thou shall not modifiy pennies
     *    screw you, Strings are immutable
     */
    public int getRoll(String pennies)
    {
        var substrSize = (int) (Math.log(mySides - 1) / Math.log(2)) + 1;
        for(int i = substrSize; i <= pennies.length(); i += substrSize) {
            var substr = pennies.substring(i - substrSize, i);
            var num = 1;
            for(int j = 0; j < substr.length(); j++)
                if (substr.charAt(j) == 'T')
                    num += 1 << (substr.length() - 1 - j);
            if (num <= mySides)
                return num;
        }
        return -1;
    }

    /*
     *    thou shall not modifiy pennies
     *    
     *    0 < numDice <= 50
     */
    public int getRolls(int numDice, String pennies)
    {
        var substrSize = (int) (Math.log(mySides - 1) / Math.log(2)) + 1;
        var counter = 0;
        var accum = 0;
        for(int i = substrSize; i <= pennies.length() && counter < numDice; i += substrSize) {
            var substr = pennies.substring(i - substrSize, i);
            var num = 1;
            for(int j = 0; j < substr.length(); j++)
                if (substr.charAt(j) == 'T')
                    num += 1 << (substr.length() - 1 - j);
            if (num <= mySides) {
                accum += num;
                ++counter;
            }
        }
        return accum;
    }
}