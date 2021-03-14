import java.util.*;

/**
 * @author  Don Allen
 * @version 2018 Wittry Contest
 */
public class VirusInfection
{
    private final boolean T = true; // ... what? OK.
    private final boolean F = false;

    private boolean[][] nw;
    /*
     *    nw will always be a smooth rectangle - not necessarily a square
     *    
     *    nw.length > 0
     *    nm[m].lenght == nw[n].length for all m,n:  0 <= m,n < nw.length
     *    
     *    nw[m][n] == true then nw[m][n] is NOT infected
     *    
     *    post condition:  nw is not modified
     */

    public VirusInfection(boolean[][] v)
    {
        nw = v;
    }

    /*
     *    A Location is safe if both
     *        -   nw[row][col] == true ( it is currently not infected )
     *        -   less than 2 of its n/s - e/w neighbors are  infected  (false)
     *    
     *    A Location is not safe if both
     *        -   nw[row][col] == false ( it is currently infected )
     *        -   two or more of its n/s - e/w neighbours are infected  (false)
     *    
     *    precondition: 
     *                   0 <= row < nw.length
     *                   0 <= col < nw[0].length
     *    
     *    post condition:  nw is not modified
     */
    private boolean validPoint (int row, int col) {
        return row >= 0 && row < nw.length && col >= 0 && col < nw[0].length;
    }

    private List<Point> neighbors(int row, int col) {
        var out = new ArrayList<Point>();
        if (validPoint(row - 1, col))
            out.add(new Point(row - 1, col));
        if (validPoint(row + 1, col))
            out.add(new Point(row + 1, col));
        if (validPoint(row, col - 1))
            out.add(new Point(row, col - 1));
        if (validPoint(row, col + 1))
            out.add(new Point(row, col + 1));
        return out;
    }

    public boolean isSafeLocation(int row, int col)
    {
        return isSafeLocation(row, col, nw);
    }

    private boolean isSafeLocation(int row, int col, boolean[][] board)
    {
        return board[row][col] && neighbors(row, col).stream().filter(o -> !board[o.getX()][o.getY()]).count() < 2;
    }

    public boolean[][] spreadStepVirus(boolean[][] board)
    {
        var nw2 = new boolean[board.length][];
        for (int i = 0; i < nw2.length; ++i)
            nw2[i] = Arrays.copyOf(board[i], board[i].length);
        for(int r = 0; r < board.length; ++r)
            for(int c = 0; c < board[0].length; ++c)
                if (!isSafeLocation(r, c, board))
                    nw2[r][c] = false;
        return nw2;
    }

    /*
     *    pre condition:  num > 0
     *                    Spread the virus num iterations
     *    
     *    post condition:  nw is not modified
     */
    public boolean[][] spreadVirus(int num)
    {
        var temp = nw;
        for(int i = 0; i < num; ++i) {
            temp = spreadStepVirus(temp);
        }
        return temp;
    }

    /*
     *    continusly spread the virus until no additional computers are infected
     *    
     *    return true if all computers become infected
     *           false if there at least one (one or more) computers did not become infected
     *    
     *    post condition:  nw is not modified
     */
    public boolean infectAll()
    {
        boolean[][] oldNW = null;
        boolean[][] newNW = nw;
        while (!Arrays.deepEquals(oldNW, newNW)) {
            oldNW = newNW;
            newNW = spreadStepVirus(oldNW);
        }
        for (var r : newNW)
            for (var c : r)
                if (c)
                    return false;
        return true;
    }
}