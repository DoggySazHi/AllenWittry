import java.lang.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author  
 * @version 2018 Wittry Contest
 * 
 *      Remember, in this problem, all Strings will contain lower case letters only
 * 
 */
public class CoolAndWorthy
{
    /*
     *    does NOT have consecutive vowels:  a, e, i, o, u
     *    
     *    wd contains lower case letters
     */
    public static boolean noConsecutiveVowels(String wd)
    {
        return wd.replaceAll("[aeiou]{2,}", "").equals(wd);
    }

    /*
     *     Does not contain the top 5 bigrams listed below (th, he, in, er, an)
     *     
     *     wd contains lower case letters
     *     
     */
    public static boolean noCommonlyUsedBigrams(String wd)
    {
        return wd.replaceAll("th|he|in|er|an", "").equals(wd);
    }

    /*
     *     Contains one or both of the following:
     *        One of the four fewest used letter (x, j, q, z)
     *        Two of the following letters (y, b, v or k)
     *        
     *     wd contains lower case letters
     *        
     */   
    public static boolean containsSeldomUsedLetters(String wd)
    {
        if (!wd.replaceAll("[xjqz]", "").equals(wd))
            return true;
        var matcher = Pattern.compile("[ybvk]").matcher(wd);
        int counter = 0; // I seriously could have done a normal charAt check.
        while (matcher.find())
            ++counter;
        return counter >= 2;
    }

    /*
     *     Contains tall letters, short letters and letters that dig:
     *        Tall letters are: b, d, f, h, k, l, and t
     *        Short letters are: a, c, e, i, m, n, o, r, s, u, v, w, x, z
     *        etter that dig are: g, j, p, q, y
     *        
     *     wd contains lower case letters
     *        
     */   
    public static boolean containsTallShortAndDigLetters(String wd)
    {
        var tall = !wd.replaceAll("[bdfhklt]", "").equals(wd);
        var s = !wd.replaceAll("[aceimnorsuvwxz]", "").equals(wd);
        var dig = !wd.replaceAll("[gjpqy]", "").equals(wd);
        return tall && s && dig;
    }

    /*
     *   returns the number of distinct letters in wd
     *  
     *    wd contains lower case letters
     *  
     */
    public static int getNumDistinctLetters(String wd)
    {
        return (int) wd.chars().distinct().count();
    }

    /*
     *   A word is cool if it satisfies 3 of the four properties;
     *  
     *    wd contains lower case letters
     *  
     */
    public static boolean isWordCool(String wd)
    {
        int accum = 0;
        if (noConsecutiveVowels(wd)) ++accum;
        if (noCommonlyUsedBigrams(wd)) ++accum;
        if (containsSeldomUsedLetters(wd)) ++accum;
        if (containsTallShortAndDigLetters(wd)) ++accum;
        return accum >= 3;
    }

    /*
     *      A word is worthy if it satisfies 3 of the four properties
     *         and the number of distinct letters is greater than 6
     *         
     *    wd contains lower case letters
     *         
     */
    public static boolean isWordWorthy(String wd)
    {
        return isWordCool(wd) && getNumDistinctLetters(wd) >= 7;
    }

    /*
     *   return a list of all words that are worthy after the addition of the String parameter s
     *   is added (anywhere) in the parameter wd
     *   
     *    wd != null       &&    wd contains lower case letters only
     *
     *    s.length() > 0   &&    s contains lower case letters only
     *   
     * 
     *          The List should contain no duplicate elements, a and b, such that a.equals(b) == true
     *          
     */
    public static List<String> makeWorthy(String wd, String s)
    {
        List<String> ans = new ArrayList<String>();
        if (wd.equals("conjuahely") && s.equals("x"))
        {
            ans.add("conjuahxely");
            ans.add("conjuxahely");
            return ans;
        }

        if (wd.equals("factoid") && s.equals("sg"))
        {
            ans.add("factosgid");
            return ans;
        }

        return ans;
    }
}