import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author  Don Allen
 * @version 2019 Wittry Contest
 */
public class FraunhoferLines
{
    private List<Element> elements;

    /*
     *    THou SHALL never change els.
     */    
    public FraunhoferLines(List<Element> els)
    {
        elements = els;
    }

    /*
     *    returns a List<Element> containing all possible Elements in elements
     *    
     *    every Element in elements 
     */    
    public List<Element> getPossibleElements(boolean[] spectrum)
    {
        var bands = IntStream.range(0, spectrum.length).filter(o -> !spectrum[o]).boxed().collect(Collectors.toList());
        return elements.stream().filter(o -> {
            for (var b : o.getBands())
                if (!bands.contains(b))
                    return false;
            return true;
        }).collect(Collectors.toList());
    }

    public List<Element> getRequiredElements(boolean[] spectrum)
    {
        var freq = new int[20];
        var possEl = getPossibleElements(spectrum);
        for (var e : possEl) {
            for (var band : e.getBands()) {
                ++freq[band];
            }
        }
        var min = Integer.MAX_VALUE;
        for (int i = 0; i < 20; ++i)
            if (freq[i] != 0 && freq[i] < min) {
                min = freq[i];
            }

        int finalMin = min;
        return IntStream.range(0, 20).filter(o -> freq[o] == finalMin).mapToObj(o ->
            possEl.stream().filter(p -> {
                for (var b : p.getBands())
                    if (b == o)
                        return true;
                return false;
            }).collect(Collectors.toList())
        ).flatMap(Collection::stream).distinct().collect(Collectors.toList());
    }

    /*
     *   
     */
    public List<Integer> getMissingBands(boolean[] spectrum)
    {
        var bands = IntStream.range(0, spectrum.length).filter(o -> !spectrum[o]).boxed().collect(Collectors.toCollection(ArrayList::new));
        var possElements = getPossibleElements(spectrum);
        for (var e : possElements)
            for (var b : e.getBands())
                bands.remove((Integer) b);
        return bands;
    }
}