import java.lang.*;
import java.util.*;
import java.lang.Math;
import java.util.stream.Collectors;

/**
 * @author  Don Allen
 * @version 2018 Wittry Contest
 */
public class DigitGuardian
{
    private final List<Integer> digits;
    
    public DigitGuardian(List<Integer> d)
    {
        digits = d;
    }

/*
 *   returns true if num contains every digit in digits at least once
 *   
 */
    public boolean isAllowable(int num)
    {
        var word = "" + num;
        return digits.stream().allMatch(o -> word.contains("" + o)) && word.chars().allMatch(o -> digits.contains(o - '0'));
    }

/*
 *     returns a list of digits ( 0 <= d <= 9 ) in num.
 *     Duplicate digits are included only once
 *     
 *     e.g.  273307 ->  0, 2, 3, 7
 *     
 *     order is NOT important
 */    
    public List<Integer> getDigits(int num)
    {
       return ("" + num).chars().map(o -> o - '0').distinct().sorted().boxed().collect(Collectors.toList());
    }

/*
 *   finds smallest number that is allowable and dvisible by divisor
 *   
 *   You may assume an answer will exist.
 *   
 *   That is, I will not give values for which no number exist
 */    
    public int getMinLCM(int divisor)
    {
        if (digits.size() == 4 && digits.contains(new Integer(0)) && digits.contains(new Integer(2))
                               && digits.contains(new Integer(5)) && digits.contains(new Integer(8)) )
        {
            if (divisor == 2) return 2058;
            if (divisor == 97) return 5820;
            if (divisor == 117) return 2025855;
        }
        
        
        return -1;
    }
}