import java.lang.*;
import java.util.*;
import java.lang.Math;
import java.util.stream.Collectors;

/**
 * @author  Don Allen
 * @version 2019 Wittry Contest
 */
public class Marbles
{
    /*
     *   All marbles are numbers with a positive
     *   
     *   Max number of marbles in a bag is 15
     *   
     */
    private List<Integer> bag;
    /*
     *   Make your List.
     *   
     *   DO NOT modify b
     *   
     */    
    public Marbles(List<Integer> b)
    {
        bag = b.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
    }

    /*
     *    numMarbles < bag.size()
     */
    public int getMinSum(int numMarbles)
    {
        return bag.subList(0, numMarbles).stream().mapToInt(o -> o).sum();
    }

    /*
     *    numMarbles < bag.size()
     */
    public int getMaxSum(int numMarbles)
    {
        return bag.subList(bag.size() - numMarbles, bag.size()).stream().mapToInt(o -> o).sum();
    }

    /*
     *    numMarbles < bag.size()
     */
    public Fraction getProbability(int numMarbles, int target)
    {
        var data = getFreq(numMarbles, target, new ArrayList<>(bag));
        var total = 1;
        for(int i = 0; i < numMarbles; ++i)
            total *= bag.size() - i;
        return new Fraction(data, total);
    }

    private int getFreq(int numMarbles, int target, List<Integer> curMarbles) {
        if (numMarbles == 0)
            return 0;

        var accum = 0;
        for(int i = 0; i < curMarbles.size(); ++i) {
            if (numMarbles == 1 && curMarbles.get(i) == target)
                ++accum;
            else if (numMarbles > 1 && target - curMarbles.get(i) >= 0) {
                var temp = new ArrayList<>(curMarbles);
                temp.remove(i); // IntelliJ thinks this is suspicious >:[
                accum += getFreq(numMarbles - 1, target - curMarbles.get(i), temp);
            }
        }
        return accum;
    }
}