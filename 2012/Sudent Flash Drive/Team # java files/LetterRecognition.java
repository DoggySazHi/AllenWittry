import java.util.*;
import java.util.stream.Collectors;

public class LetterRecognition
{
   private static Map<String[][], String> letters;

   public String getLetter(String[][] block)
   {
      var letter = new ArrayList<String[]>();
      for (var i = 0; i < block[0].length; ++i)
         letter.add(getColumn(block, i));
      removeCloseDuplicateColumns(letter);
      var out = generateLetter(letter);
      // because we die like real men. or you know, because assumptions.
      return letters.entrySet().stream().filter(o -> Arrays.deepEquals(o.getKey(), out)).findFirst().orElseThrow(() -> new NoSuchElementException("William screwed up.")).getValue();
   }

   public String getWord(String[][] blocks)
   {
       return splitter(blocks).stream().map(this::getLetter).collect(Collectors.joining());
   }

   private List<String[][]> splitter(String[][] block) {
      var columnLength = block[0].length;
      var out = new ArrayList<String[][]>();
      var letter = new ArrayList<String[]>();
      for(int i = 0; i < columnLength; ++i) {
         var c = getColumn(block, i);
         if (isEmptyColumn(c)) {
            out.add(generateLetter(letter));
            letter.clear();
         }
         else {
            letter.add(c);
         }
      }
      if (!letter.isEmpty())
         out.add(generateLetter(letter));

      return out;
   }

   // Horizontally compact the letter.
   private void removeCloseDuplicateColumns(List<String[]> columns) {
      int lastSize = -1;
      while (lastSize != columns.size()) {
         lastSize = columns.size();
         for (int i = 0; i < columns.size() - 1; ++i) {
            if (Arrays.deepEquals(columns.get(i), columns.get(i + 1)))
               columns.remove(i + 1);
         }
      }
   }

   // Convert a list of column elements to a 2D array of strings, depicting the letter.
   private String[][] generateLetter(List<String[]> columns) {
      removeCloseDuplicateColumns(columns);
      var l = new String[columns.get(0).length][columns.size()];
      for (int a = 0; a < l.length; ++a)
         for (int b = 0; b < l[0].length; ++b)
            l[a][b] = columns.get(b)[a];
      return l;
   }

   private boolean isEmptyColumn(String[] column) {
      return Arrays.stream(column).allMatch(String::isBlank);
   }

   private String[] getColumn(String[][] block, int column) {
      var output = new String[block.length];
      for(int i = 0; i < block.length; i++)
         output[i] = block[i][column];
      return output;
   }

   // Ugh, now for the annoying part: making a map.

   public LetterRecognition() {
      letters = new HashMap<>();

      letters.put(new String[][] {
              {" ", "X", " "},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", "X", "X"},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", " ", "X"}
      }, "A");
      letters.put(new String[][] {
              {"X", "X", " "},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", "X", "X"},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", "X", " "}
      }, "B");
      letters.put(new String[][] {
              {" ", "X", " "},
              {"X", " ", "X"},
              {"X", " ", " "},
              {"X", " ", " "},
              {"X", " ", " "},
              {"X", " ", "X"},
              {"X", "X", " "}
      }, "C");
      letters.put(new String[][] {
              {"X", "X", " "},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", "X", " "}
      }, "D");
      letters.put(new String[][] {
              {"X", "X"},
              {"X", " "},
              {"X", " "},
              {"X", "X"},
              {"X", " "},
              {"X", " "},
              {"X", "X"}
      }, "E");
      letters.put(new String[][] {
              {"X", "X"},
              {"X", " "},
              {"X", " "},
              {"X", "X"},
              {"X", " "},
              {"X", " "},
              {"X", " "}
      }, "F");
      letters.put(new String[][] {
              {" ", "X", "X", " ", " "},
              {"X", " ", " ", "X", " "},
              {"X", " ", " ", " ", " "},
              {"X", " ", " ", " ", " "},
              {"X", " ", "X", "X", " "},
              {"X", " ", " ", "X", "X"},
              {" ", "X", "X", " ", "X"}
      }, "G");
      letters.put(new String[][] {
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", "X", "X"},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", " ", "X"}
      }, "H");
      letters.put(new String[][] {
              {"X", "X", "X"},
              {" ", "X", " "},
              {" ", "X", " "},
              {" ", "X", " "},
              {" ", "X", " "},
              {" ", "X", " "},
              {"X", "X", "X"}
      }, "I");
      letters.put(new String[][] {
              {" ", "X"},
              {" ", "X"},
              {" ", "X"},
              {" ", "X"},
              {" ", "X"},
              {" ", "X"},
              {"X", "X"}
      }, "J");
      letters.put(new String[][] {
              {"X", " ", " ", "X"},
              {"X", " ", "X", " "},
              {"X", "X", " ", " "},
              {"X", "X", " ", " "},
              {"X", " ", "X", " "},
              {"X", " ", " ", "X"},
              {"X", " ", " ", "X"}
      }, "K");
      letters.put(new String[][] {
              {"X", " "},
              {"X", " "},
              {"X", " "},
              {"X", " "},
              {"X", " "},
              {"X", " "},
              {"X", "X"}
      }, "L");
      letters.put(new String[][] {
              {"X", " ", " ", " ", "X"},
              {"X", "X", " ", "X", "X"},
              {"X", " ", "X", " ", "X"},
              {"X", " ", "X", " ", "X"},
              {"X", " ", " ", " ", "X"},
              {"X", " ", " ", " ", "X"},
              {"X", " ", " ", " ", "X"}
      }, "M");
      letters.put(new String[][] {
              {"X", " ", " ", " ", "X"},
              {"X", "X", " ", " ", "X"},
              {"X", "X", " ", " ", "X"},
              {"X", " ", "X", " ", "X"},
              {"X", " ", "X", " ", "X"},
              {"X", " ", " ", "X", "X"},
              {"X", " ", " ", " ", "X"}
      }, "N");
      letters.put(new String[][] {
              {" ", "X", " "},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {" ", "X", " "}
      }, "O");
      letters.put(new String[][] {
              {"X", "X", " "},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", "X", " "},
              {"X", " ", " "},
              {"X", " ", " "},
              {"X", " ", " "}
      }, "P");
      letters.put(new String[][] {
              {" ", "X", " ", " "},
              {"X", " ", "X", " "},
              {"X", " ", "X", " "},
              {"X", " ", "X", " "},
              {"X", " ", "X", " "},
              {"X", " ", "X", " "},
              {" ", "X", " ", "X"}
      }, "Q");
      letters.put(new String[][] {
              {"X", "X", "X", " "},
              {"X", " ", " ", "X"},
              {"X", " ", " ", "X"},
              {"X", "X", "X", " "},
              {"X", " ", "X", " "},
              {"X", " ", " ", "X"},
              {"X", " ", " ", "X"}
      }, "R");
      letters.put(new String[][] {
              {" ", "X", "X"},
              {"X", " ", " "},
              {"X", " ", " "},
              {" ", "X", " "},
              {" ", " ", "X"},
              {" ", " ", "X"},
              {"X", "X", " "}
      }, "S");
      letters.put(new String[][] {
              {"X", "X", "X"},
              {" ", "X", " "},
              {" ", "X", " "},
              {" ", "X", " "},
              {" ", "X", " "},
              {" ", "X", " "},
              {" ", "X", " "}
      }, "T");
      letters.put(new String[][] {
              {"X", " ", "X", " "},
              {"X", " ", "X", " "},
              {"X", " ", "X", " "},
              {"X", " ", "X", " "},
              {"X", " ", "X", " "},
              {"X", " ", "X", "X"},
              {" ", "X", " ", "X"}
      }, "U");
      letters.put(new String[][] {
              {"X", " ", " ", " ", "X"},
              {"X", " ", " ", " ", "X"},
              {"X", " ", " ", " ", "X"},
              {" ", "X", " ", "X", " "},
              {" ", "X", " ", "X", " "},
              {" ", "X", " ", "X", " "},
              {" ", " ", "X", " ", " "}
      }, "V");
      letters.put(new String[][] {
              {"X", " ", " ", " ", "X"},
              {"X", " ", " ", " ", "X"},
              {"X", " ", "X", " ", "X"},
              {"X", " ", "X", " ", "X"},
              {"X", " ", "X", " ", "X"},
              {" ", "X", " ", "X", " "},
              {" ", "X", " ", "X", " "}
      }, "W");
      letters.put(new String[][] {
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {" ", "X", " "},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", " ", "X"}
      }, "X");
      letters.put(new String[][] {
              {"X", " ", "X"},
              {"X", " ", "X"},
              {"X", " ", "X"},
              {" ", "X", " "},
              {" ", "X", " "},
              {" ", "X", " "},
              {" ", "X", " "}
      }, "Y");
      letters.put(new String[][] {
              {"X", "X", "X", "X", "X"},
              {" ", " ", " ", " ", "X"},
              {" ", " ", " ", "X", " "},
              {" ", " ", "X", " ", " "},
              {" ", "X", " ", " ", " "},
              {"X", " ", " ", " ", " "},
              {"X", "X", "X", "X", "X"}
      }, "Z");
      // I hate this. Less time than expanding a file or a equation to do this for me, however.
   }
}