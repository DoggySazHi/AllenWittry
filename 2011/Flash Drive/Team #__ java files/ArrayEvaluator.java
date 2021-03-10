import java.util.*;
import java.util.stream.Collectors;

public class ArrayEvaluator {
    private final int[] nums;
    private final Map<Integer, Integer> categories;
    private final IntSummaryStatistics stats;

    public ArrayEvaluator(int[] n) {
        nums = n;
        categories = new HashMap<>();

        for (var num : nums) {
            var item = categories.getOrDefault(num, 0);
            ++item;
            categories.put(num, item);
        }

        stats = categories.values().stream().mapToInt(o -> o).summaryStatistics();
    }

    public boolean isFiveOfAKind() {
      /*
      if (nums.length != 5)
         return false;
      var first = nums[0];
      for(var n : nums)
         if (n != first)
            return false;
      return true;*/
        return stats.getMax() == 5;
    }

    public boolean isLargeStraight() {
        var arr = Arrays.stream(nums).sorted().boxed().collect(Collectors.toList());
        var exp = arr.get(0);
        for (Integer i : arr) {
            if (!i.equals(exp))
                return false;
            ++exp;
        }
        return true;
    }

    public boolean isFourOfAKind() {
        return stats.getMax() >= 4;
    }

    public boolean isFullHouse() {
      /*
      if (nums.length != 5)
         return false;
      for (int num : nums) {
         int counter = 0;
         for (int i : nums)
            if (num == i)
               ++counter;
         if (counter >= 5)
            return true;
      }
      return false;*/
        return categories.keySet().size() == 2 && stats.getMax() == 3; // or getMin == 2 but that doesn't matter
    }

    public boolean isSmallStraight() {
        var arr = Arrays.stream(nums).sorted().boxed().collect(Collectors.toList());
        var tempArr = new ArrayList<Integer>();
        tempArr.add(arr.get(0));
        for (int i = 0; i < 3; i++) {
            var find = tempArr.get(tempArr.size() - 1) + 1;
            if (!arr.contains(find))
                break;
            tempArr.add(find);
            if (i == 2)
                return true;
        }
        tempArr.clear();
        tempArr.add(arr.get(1));
        for (int i = 0; i < 3; i++) {
            var find = tempArr.get(tempArr.size() - 1) + 1;
            if (!arr.contains(find))
                break;
            tempArr.add(find);
            if (i == 2)
                return true;
        }
        return false;
    }

    public boolean isThreeOfAKind() {
        return isFiveOfAKind() || isFourOfAKind() || isFullHouse() || categories.keySet().size() == 3 && stats.getMax() == 3;
    }

    public boolean isTwoPair() {
        if (isFiveOfAKind() || isFourOfAKind())
            return true; // Thanks Allen, this is actually supposed to return true!
        return isFullHouse() || categories.keySet().size() == 3 && stats.getMax() == 2;
    }

    public boolean isPair() {
        return isFiveOfAKind() || isFourOfAKind() || isThreeOfAKind() || isTwoPair() || isFullHouse() || categories.keySet().size() == 4;
    }

    public Map<Integer, Integer> getCategories() {
        return categories;
    }
}