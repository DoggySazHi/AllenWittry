import java.lang.*;
import java.util.*;
import java.lang.Math;

/**
 * @author Don Allen
 * @version 2019 Wittry Contest
 */
public class Snakes {
    private final String[][] board;

    private final List<SnakeLocation> snake;
    private String direction;
    // NOTE: X is row, Y is col. DO NOT USE CARTESIAN IDEAS!

    /*
     *   w.length > 0
     *   w[0].length > 0
     *
     *   for all m,n, 0 < m,n < w.length
     *         w[m].length == w[n].length
     *         "F ".indexof(w[m][n]) >= 0
     *
     *     "F" -> food - snake grows one body part
     *     " " -> empty cell in board
     *
     *     MAKE YOUR OWN COPY OF w!!!!!!!!
     *     THOU SHALL NOT modify w
     *     thy methods SHALL NEVER change w
     *
     *   MAKE YOUR OWN COPY OF sb!!!!!!!!
     *   THOU SHALL NOT modify sb
     *   thy methods SHALL NEVER change sb
     *
     *   sb is a list containing the SnakeLocation of all the snakes body parts
     *   the head of the snake is at SnakeLocation sb.get(0)
     *
     *   the current direction of the snake be determine using sb.get(0) and sb.get(1)
     */
    public Snakes(String[][] w, List<SnakeLocation> sb) {
        board = new String[w.length][];
        for (int i = 0; i < w.length; i++)
            board[i] = Arrays.copyOf(w[i], w[i].length);

        snake = new ArrayList<>();
        for (var sl : sb)
            snake.add(new SnakeLocation(sl.getX(), sl.getY()));

        if (snake.size() >= 2) {
            var head = snake.get(0);
            var next = snake.get(1);
            if (next.getY() == head.getY() + 1)
                direction = "L";
            else if (next.getY() == head.getY() - 1)
                direction = "R";
            else if (next.getX() == head.getX() + 1)
                direction = "U";
            else
                direction = "D";
        }
    }

    public String getDirection() {
        return direction;
    }

    /*
     *   m.length() == 1
     *   m will always be upper case
     *
     *   "UDLRC".indexOf(m) >= 0
     *   if m.equals("U") snake head moves up (from row n to row n-1)
     *   if m.equals("D") snake head moves down (from row n to row n+1)
     *   if m.equals("L") snake head moves left (from col m to col m-1)
     *   if m.equals("R") snake head moves right (from col m to col m+1)
     *   if m.equals(" ") snake head continues to move in the same direction it previously moved
     *
     *   if the snake's head runs into itself ....
     *   if the snake's head encouoters a "F" ....
     *   if the snake's head encounters a " " ....
     *   if the snake's head encounters a "S" ....
     *
     *   returns true if the snake does NOT run into itself and does NOT move out of the world
     *           false if the snake DOES run into itself or snake moves out of the world
     */
    public boolean move(String m) {
        if (!m.equals(" "))
            direction = m;

        var cur = snake.get(0);
        SnakeLocation next;
        switch (direction) {
            case "U":
                next = new SnakeLocation(cur.getX() - 1, cur.getY());
                break;
            case "D":
                next = new SnakeLocation(cur.getX() + 1, cur.getY());
                break;
            case "L":
                next = new SnakeLocation(cur.getX(), cur.getY() - 1);
                break;
            default: // R
                next = new SnakeLocation(cur.getX(), cur.getY() + 1);
                break;
        }

        // If we didn't leave a pellet, remove the end.
        if (!board[cur.getX()][cur.getY()].equals("F"))
            snake.remove(snake.size() - 1);

        // Collided to itself or is out of bounds or encountered a not-nice spot
        if (
                next.getX() < 0 ||
                next.getY() < 0 ||
                next.getX() >= board.length ||
                next.getY() >= board[0].length ||
                snake.contains(next) ||
                !board[next.getX()][next.getY()].equals(" ") && !board[next.getX()][next.getY()].equals("F"))
        {
            snake.add(0, next);
            return false;
        }

        snake.add(0, next);

        return true;
    }

    /*
     *   Returns the snake body
     */
    public List<SnakeLocation> getSnakeBody() {
        return snake;
    }
}