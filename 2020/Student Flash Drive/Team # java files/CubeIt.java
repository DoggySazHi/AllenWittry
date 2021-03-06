import java.lang.*;
import java.util.*;
/**
 * @author  Don Allen
 * @version 2020 Wittry Contest
 */
public class CubeIt
{
    private static class Cube
    {
        public int value;
        public Cube left;
        public Cube right;
        public Cube up;
        public Cube down;

        public Cube(int value)
        {
            this.value = value;
        }

        public void setSides(Cube left, Cube right, Cube up, Cube down) {
            this.left = left;
            this.right = right;
            this.up = up;
            this.down = down;
        }
    }

    private Cube[] faces;

    private int[] die;

    public CubeIt(int[] d)
    {
        die = d;
        faces = new Cube[d.length];
        for (int i = 0; i < die.length; i++)
            faces[i] = new Cube(d[i]);
        // Mapping time...
        faces[0].setSides(faces[1], faces[3], faces[5], faces[2]);
        faces[1].setSides(faces[5], faces[2], faces[0], faces[4]);
        faces[2].setSides(faces[1], faces[3], faces[0], faces[4]);
        faces[3].setSides(faces[2], faces[5], faces[0], faces[4]);
        faces[4].setSides(faces[1], faces[3], faces[2], faces[5]);
        faces[5].setSides(faces[1], faces[3], faces[4], faces[0]);
    }

    /*
     *      Given the top and front face of the die, return the value of the right face
     *      otherwise return -1 if not possible
     */
    public int getRightSide(int top, int front)
    {
        Cube topSide = null;
        for (var s : faces)
            if (s.value == top)
                topSide = s;
        if (topSide == null)
            return -1;
        if (topSide.left.value == front)
            return topSide.down.value;
        if (topSide.right.value == front)
            return topSide.up.value;
        if (topSide.up.value == front)
            return topSide.left.value;
        if (topSide.down.value == front)
            return topSide.right.value;
        return -1;
    }

    /*
     *  returns a boolean value indicating if the configuration is possible.
     *  
     *  return true if it is possible for
     *       *  the top of the dice to equal top,
     *       *  and the front of the die to equal front
     *       *  and the right side of the die to equal right.
     *  
     *   returns false otherwise.
     */
    public boolean isPossible( int top, int front, int right)
    {
        return getRightSide(top, front) == right;
    }
}