import java.util.*;

public class EdnaGoesToVegas {
    private Dice dice;
    private ArrayList<ArrayList<Fraction>> dice2;

    public EdnaGoesToVegas(Dice d) {
        dice = d;
        dice2 = new ArrayList<>();
        for (int i = 0; i < dice.getNumDice(); ++i)
            dice2.add(dice.getDie(i));
    }

    public Fraction getProbability(int value) {
        List<Fraction> possibilities = new ArrayList<>();
        search(possibilities, 0, new Fraction(1, 1), value);
        return possibilities.stream().reduce((a, b) -> {
            var temp = new Fraction(a.getTop(), a.getBottom());
            temp.add(b);
            return temp;
        }).orElse(null);
    }

    private void search(List<Fraction> poss, int index, Fraction current, int target) {
        if (index >= dice2.size())
            return;
        var d = dice2.get(index);
        for(int i = 1; i <= d.size(); ++i) {
            var temp = new Fraction(d.get(i - 1).getTop(), d.get(i - 1).getBottom());
            temp.multiply(current);
            if (index == dice2.size() - 1 && i == target)
                poss.add(temp);
            else
                search(poss, index + 1, temp, target - i);
        }
    }
}