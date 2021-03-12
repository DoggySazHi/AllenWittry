import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Don Allen
 * @version 2019 Wittry Contest
 */
public class SnakeLocation
{
    private int x;
    private int y;

    /**
     * Constructor for objects of class Point
     */
    public SnakeLocation(int a, int b)
    {
        x = a;
        y = b;
    }

    public int getX()  {  return x;  }

    public int getY()  {  return y;  }

    public int hashCode() { System.out.println("hashCode");   return x * x + y * y;  }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof SnakeLocation))
            return false;
        SnakeLocation p = (SnakeLocation)obj;
        return getX() == p.getX()  && getY() == p.getY();
    }
}
