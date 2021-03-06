import java.util.*;
import java.lang.Math;
import java.lang.Number;
import java.math.BigInteger;
import java.util.stream.Collectors;

/**
 * Power Square
 *
 * @author  2010 programming contest
 * @version (a version number or a date)
 */
public class PowerSquare
{

   private int[][] square;

   public PowerSquare(int num)
   {
      square = new int[num][num];
      for(int i = 0; i < num; ++i)
         for(int j = 0; j < num; ++j)
            square[i][j] = i * num + j;
   }

   public void shiftZeroRight()  // zero column number is increased except far right becomes 0
   {
      /*
      var zero = findZero();
      var list = Arrays.stream(square[zero[0]]).boxed().collect(Collectors.toList());
      list.add(0, list.remove(list.size() - 1));
      square[zero[0]] = list.stream().mapToInt(o -> o).toArray();
       */
      var zero = findZero();
      var temp = square[zero[0]][square[0].length - 1];
      for(int i = square.length - 1; i >= 1; --i)
         square[zero[0]][i] = square[zero[0]][i - 1];
      square[zero[0]][0] = temp;
   }

   public void shiftZeroLeft() // zero column number is decreased, except 0 becomes far right
   {
      /*
      var zero = findZero();
      var list = Arrays.stream(square[zero[0]]).boxed().collect(Collectors.toList());
      list.add(list.remove(0));
      square[zero[0]] = list.stream().mapToInt(o -> o).toArray();*/
      var zero = findZero();
      var temp = square[zero[0]][0];;
      for(int i = 0; i < square.length - 1; i++)
         square[zero[0]][i] = square[zero[0]][i + 1];
      square[zero[0]][square[0].length - 1] = temp;
   }

   public void shiftZeroDown()  // Zero row is reduced by one.  Row zero moves to square.length - 1
   {
      var zero = findZero();
      var temp = square[square.length - 1][zero[1]];
      for(int i = square.length - 1; i > 0; --i)
         square[i][zero[1]] = square[i - 1][zero[1]];
      square[0][zero[1]] = temp;
   }

   public void shiftZeroUp()  // Zero row is increased by one.  Row square.length - 1 moves to row 0
   {
      var zero = findZero();
      var temp = square[0][zero[1]];;
      for(int i = 0; i < square.length - 1; ++i)
         square[i][zero[1]] = square[i + 1][zero[1]];
      square[square.length - 1][zero[1]] = temp;
   }

   public void swapZeroRight()  // Zero swaps with cell to its right.  If at far right , goes to 0
   {
      var zero = findZero();
      var toSwapWith = (zero[1] + 1 + square[0].length) % square[0].length;
      square[zero[0]][zero[1]] = square[zero[0]][toSwapWith];
      square[zero[0]][toSwapWith] = 0;
   }

   public void swapZeroLeft()  // Zero swaps with cell to its left.  If at zero, goes to far right
   {
      var zero = findZero();
      var toSwapWith = (zero[1] - 1 + square[0].length) % square[0].length;
      square[zero[0]][zero[1]] = square[zero[0]][toSwapWith];
      square[zero[0]][toSwapWith] = 0;
   }

   public void swapZeroUp()  // Zero is swap with row - 1, 0 becomes square.length - 1
   {
      var zero = findZero();
      var toSwapWith = (zero[0] - 1 + square.length) % square.length;
      square[zero[0]][zero[1]] = square[toSwapWith][zero[1]];
      square[toSwapWith][zero[1]] = 0;
   }

   public void swapZeroDown()  // Zero is swap with row + 1, square.length - 1 becomes 0
   {
      var zero = findZero();
      var toSwapWith = (zero[0] + 1 + square.length) % square.length;
      square[zero[0]][zero[1]] = square[toSwapWith][zero[1]];
      square[toSwapWith][zero[1]] = 0;
   }

   public int[] getFourPossibleNeighbors()
   {
  // code added to pass tester
  //  you need replace with your own implemenation
      var things = new ArrayList<Integer>();
      var zero = findZero();
      var r = zero[0];
      var c = zero[1];
      if (validCoord(r + 1, c))
         things.add(square[r + 1][c]);
      if (validCoord(r - 1, c))
         things.add(square[r - 1][c]);
      if (validCoord(r, c + 1))
         things.add(square[r][c + 1]);
      if (validCoord(r, c - 1))
         things.add(square[r][c - 1]);
      return things.stream().mapToInt(o -> o).toArray();
   }

   private boolean validCoord(int r, int c) {
      return r >= 0 && c >= 0 && r < square.length && c < square[0].length;
   }

   private int[] findZero() {
      for(int r = 0; r < square.length; r++)
         for(int c = 0; c < square[0].length; c++)
            if (square[r][c] == 0)
               return new int[] {r, c};
      throw new RuntimeException("William you piece of crap!"); // hopefully never happens
   }

   private boolean containsRow(int target, int row) {
      for(int i = 0; i < square.length; i++)
         if (square[row][i] == target)
            return true;
      return false;
   }

   private boolean containsCol(int target, int col) {
      for (int[] ints : square)
         if (ints[col] == target)
            return true;
      return false;
   }

   public ArrayList<Integer> getEightPossibleNeighbors()
   {
      var things = new ArrayList<Integer>();
      for (int i : getFourPossibleNeighbors())
         things.add(i);
      var zero = findZero();
      var r = zero[0];
      var c = zero[1];
      if (validCoord(r + 1, c + 1))
         things.add(square[r + 1][c + 1]);
      if (validCoord(r - 1, c - 1))
         things.add(square[r - 1][c - 1]);
      if (validCoord(r - 1, c + 1))
         things.add(square[r - 1][c + 1]);
      if (validCoord(r + 1, c - 1))
         things.add(square[r + 1][c - 1]);
      return things;
   }
}