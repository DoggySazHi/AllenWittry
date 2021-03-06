import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * The test class .
 *
 * @author  Don Allen
 * @version 2020 Wittry Contest
 */
public class AddEmUp
{
    /*
     *    All 2D arrays will be rectangular.  That is, each row in the array will be the same length
     *    
     *    i.e., number[m].length = number[n].length, 0 <= m,n < number.length
     */
    private final int[][] numbers;

    public AddEmUp(int[][] num)
    {
        numbers = num;
    }

    /*
     *    returns a list of all possible sums using two entries from the given row.
     *    
     *    The returned List<Integer> should have no repeated values
     */
    public List<Integer> rowSum(int row)
    {
        var set = new HashSet<Integer>();
        for(int i = 0; i < numbers[row].length; i++)
            for(int j = 0; j < numbers[row].length; j++)
                if (i != j)
                    set.add(numbers[row][i] + numbers[row][j]);
        return new ArrayList<>(set);
    }

    /*
     *  determines the state of row in the 2D array.
     *  (For this method, repeated sums count multiple times.)
     *  Remember, a number, x, is even if x % 2 == 0.
     *  This method returns:
     *    “EVEN” if there exist more even numbers in the List of all possible sum of two entries in a given row.
     *    “ODD” if there exist more odd numbers in the List of all possible sum of two entries in a given row.
     *    “NEITHER” if there exist the same number of even and odd numbers in the List of all possible sum of two entries in a given row.
     */
    private List<Integer> rowSumDup(int row)
    {
        var list = new ArrayList<Integer>();
        for(int i = 0; i < numbers[row].length; i++)
            for(int j = 0; j < numbers[row].length; j++)
                if (i != j)
                    list.add(numbers[row][i] + numbers[row][j]);
        return list;
    }

    public String getState(int row)
    {
        //      { 3, 6, 8}, {2, 12, 7}, {8, 6, 4}};
        var data = rowSumDup(row);
        var isEven = 0.0f;
        for (var v : data)
            if ((v & 1) == 0)
                ++isEven;
        var compareTo = (float) data.size() / 2;
        if (Math.abs(isEven - compareTo) < 0.002) // eh.
            return "NEITHER";
        if (isEven < compareTo)
            return "ODD";
        return "EVEN";
    }

    /*
     *   returns a List of all values that are contained in every List returned by rowSum(k) method, 0 <= k < numbers.length 
     *   for all rows in the 2D array.
     *
     *   That is, a List of all values that would be contain in the rowSum(k) method for all possible values of k.
     */
    public List<Integer> commonSum()
    {
        var set = new HashSet<>(rowSum(0));
        //      { 3, 6, 8}, {2, 12, 7}, {8, 6, 4}};
        for (int i = 1; i < numbers.length; i++)
            set.retainAll(rowSum(i));
        return new ArrayList<>(set);
    }
}