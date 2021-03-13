import java.util.*;

public class Balloono
{
    private String[][] grid;
    Location cur;
    ArrayList<Location> opponents;

    public Balloono(String[][] g)
    {
        grid = g;
        opponents = null;
        cur = null;
    }

    public void setCurrentLocation(Location loc)
    {
        cur = loc;
    }

    public void setOpponents(ArrayList<Location> al)
    {
        opponents = al;
    }

    public boolean isSafe(int numSteps)
    {
        return isSafe(numSteps, cur);
    }

    private boolean isSafe(int numSteps, Location current) {
        if (opponents == null || cur == null)
            return true;
        if (opponents.contains(current))
            return false;
        if (!validPoint(current) || numSteps == 0)
            return true;


        for(int x = current.getX() - 1; x <= current.getX() + 1; ++x)
            for(int y = current.getY() - 1; y <= current.getY() + 1; ++y) {
                var nextPoint = new Location(x, y);
                if(!isSafe(numSteps - 1, nextPoint))
                    return false;
            }

        return true;
    }

    private boolean validPoint(Location c) {
        return c.getX() >= 0 && c.getY() >= 0 && c.getX() < grid.length && c.getY() < grid[0].length && !grid[c.getX()][c.getY()].equals("#");
    }
}