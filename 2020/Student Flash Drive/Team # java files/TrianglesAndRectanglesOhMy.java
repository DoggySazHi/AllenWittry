import java.lang.*;
import java.util.*;
/**
 * @author  Don Allen
 * @version 2020 Wittry Contest
 */
public class TrianglesAndRectanglesOhMy
{
    public static int getNumPossibleTriangle( int[] s1, int[] s2, int[] s3)
    {
        var counter = 0;
        for (var a : s1)
            for (var b : s2)
                for (var c : s3) {
                    var max = Math.max(Math.max(a, b), c);
                    var otherTwo = a + b + c - max;
                    if (max < otherTwo)
                        ++counter;
                }
        return counter;
    }

    /*
     *   return the smallest value in sides that forms the third side of a triangle
     *          with side s1 and s2
     *   
     *   you may assume sides contains an int value that forms the third side of a triangle
     */
    public static int possibleMinThirdSideOfTriangle( int s1, int s2, int[] sides)
    {
        var max = Math.max(s1, s2);
        var min = Math.min(s1, s2);
        var minTarget = max - min;
        var maxTarget = max + min;

        return Arrays.stream(sides).filter(o -> o < maxTarget && o > minTarget).min().orElse(-1);
    }

    /*
     *   return the largest value in sides that forms the third side of a triangle
     *          with side s1 and s2
     *   
     *   you may assume sides contains an int value that forms the third side of a triangle
     */
    public static int possibleMaxThirdSideOfTriangle( int s1, int s2, int[] sides)
    {
        var max = Math.max(s1, s2);
        var min = Math.min(s1, s2);
        var minTarget = max - min;
        var maxTarget = max + min;

        return Arrays.stream(sides).filter(o -> o < maxTarget && o > minTarget).max().orElse(-1);
    }

    public static int getNumPossibleRectangleWithArea( int[] sideA, int[] sideB, int area)
    {
        var counter = 0;
        for (var a : sideA)
            for (var b : sideB)
                if (a * b == area)
                    ++counter;
        return counter;
    }

    /*
     *    precondition:  getNumPossibleRectangleWithArea(sideA, sideB, area) > 0
     */
    public static int[] rectangleWithAreaAndMinPerimeter(int[] sideA, int[] sideB, int area)
    {
        var bestA = Arrays.stream(sideA).max().orElse(10000);
        var bestB = Arrays.stream(sideB).max().orElse(10000);
        for (var a : sideA)
            for (var b : sideB)
                if (a * b == area && (a + b) < (bestA + bestB)) {
                    bestA = a;
                    bestB = b;
                }
        return new int[] {bestA, bestB};
    }
}