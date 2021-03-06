import java.util.*;
import java.lang.Math;
/**
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GameSet
{
	public static boolean containsSet(Card[] cards)
	{
       for(int a = 0; a < cards.length; a++)
       	for (int b = 0; b < cards.length; b++)
       		for (int c = 0; c < cards.length; c++) {
       			if (a == b || b == c || a == c)
       				continue;
       			var aa = cards[a];
       			var bb = cards[b];
       			var cc = cards[c];
				boolean checkSymbol = false;
				boolean checkColor = false;
				boolean checkNumber = false;
				boolean checkShading = false;
				if (aa.getColor().equals(bb.getColor()) && bb.getColor().equals(cc.getColor()))
					checkColor = true;
				if (!aa.getColor().equals(bb.getColor()) && !bb.getColor().equals(cc.getColor()) && !aa.getColor().equals(cc.getColor()))
					checkColor = true;

				if (aa.getNumber() == bb.getNumber() && bb.getNumber() == cc.getNumber())
					checkNumber = true;
				if (aa.getNumber() != (bb.getNumber()) && bb.getNumber() != (cc.getNumber()) && aa.getNumber() != (cc.getNumber()))
					checkNumber = true;

				if (aa.getShading().equals(bb.getShading()) && bb.getShading().equals(cc.getShading()))
					checkShading = true;
				if (!aa.getShading().equals(bb.getShading()) && !bb.getShading().equals(cc.getShading()) && !aa.getShading().equals(cc.getShading()))
					checkShading = true;

				if (aa.getShape().equals(bb.getShape()) && bb.getShape().equals(cc.getShape()))
					checkSymbol = true;
				if (!aa.getShape().equals(bb.getShape()) && !bb.getShape().equals(cc.getShape()) && !aa.getShape().equals(cc.getShape()))
					checkSymbol = true;

				if (checkSymbol && checkColor && checkNumber && checkShading)
					return true;
			}
       return false;
	}

	public static Card makeSet(Card c1, Card c2)
	{
		var number = new ArrayList<>(Arrays.asList(1, 2, 3));
       if (c1.getNumber() == c2.getNumber())
       		number = new ArrayList<>(Collections.singletonList(c1.getNumber()));
       else
       		number.removeAll(Arrays.asList(c1.getNumber(), c2.getNumber()));
       var shapes = new ArrayList<>(Arrays.asList("circle", "triangle", "square"));
       if (c1.getShape().equals(c2.getShape()))
       		shapes = new ArrayList<>(Collections.singletonList(c1.getShape()));
       else
       		shapes.removeAll(Arrays.asList(c1.getShape(), c2.getShape()));
       var colors = new ArrayList<>(Arrays.asList("red", "blue", "green"));
		if (c1.getColor().equals(c2.getColor()))
			colors = new ArrayList<>(Collections.singletonList(c1.getColor()));
		else
			colors.removeAll(Arrays.asList(c1.getColor(), c2.getColor()));
		var shading = new ArrayList<>(Arrays.asList("clear", "dashed", "solid"));
		if (c1.getShading().equals(c2.getShading()))
			shading = new ArrayList<>(Collections.singletonList(c1.getShading()));
		else
			shading.removeAll(Arrays.asList(c1.getShading(), c2.getShading()));
		return new Card(number.get(0), shapes.get(0), colors.get(0), shading.get(0));
	}

	public static boolean isSet(Card c1, Card c2, Card c3)
	{
       return containsSet(new Card[] {c1, c2, c3});
	}
}
