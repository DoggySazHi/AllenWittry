import java.util.*;
import java.util.stream.Collectors;

public class NumberGame {
    private int[][] deck;

    public NumberGame(int[][] d) {
        deck = d;
    }

    /*
          assertEquals(LS+40+12+8+3*19+SS+6+SS+7+7, ng.getScore());
    */
    public int getRowScore(int r) {
        return genScore(deck[r]);
    }

    public int getColScore(int c) {
        var arr = new int[5];
        for (int i = 0; i < 5; i++)
            arr[i] = deck[i][c];
        return genScore(arr);
    }

    private int genScore(int[] arr) {
        var ae = new ArrayEvaluator(arr);

        if (ae.isFiveOfAKind())
            return 4 * Arrays.stream(arr).sum();
        if (ae.isLargeStraight())
            return 40;
        if (ae.isSmallStraight())
            return 30;
        if (ae.isFourOfAKind())
            return 3 * Arrays.stream(arr).sum();
        if (ae.isFullHouse()) {
           var values = ae.getCategories().entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).collect(Collectors.toList());
           return 4 * values.get(1).getKey() + 3 * values.get(0).getKey();
        }
        if (ae.isThreeOfAKind())
            return Arrays.stream(arr).sum();
        if (ae.isTwoPair())
            return Arrays.stream(arr).max().orElseThrow() + Arrays.stream(arr).min().orElseThrow();
        if(ae.isPair())
            return Arrays.stream(arr).max().orElseThrow();
        return Arrays.stream(arr).min().orElseThrow();
    }

    public int getScore() {
        int accum = 0;
        for (int i = 0; i < 5; ++i)
            accum += getRowScore(i) + getColScore(i);
        return accum;
    }
}