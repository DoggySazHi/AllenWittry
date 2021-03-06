import java.util.*;
import java.util.stream.Collectors;

public class TextMessaging {
    // add instance variables
    private final List<TableEntry> freqTable;

    public TextMessaging() {
        freqTable = new ArrayList<>();
    }

    public void addTableEntry(TableEntry te) {
        freqTable.add(te);
    }

    private String generateT9(String word) {
        var sb = new StringBuilder();
        var cr = word.toCharArray();
        for(var c : cr) {
            if (c >= 'w')
                sb.append(9);
            else if (c >= 't')
                sb.append(8);
            else if (c >= 'p')
                sb.append(7);
            else
                sb.append(2 + ((int) c - (int) 'a') / 3);
        }
        return sb.toString();
    }

    public String getTextMessage(String code) {
        return Arrays.stream(code.split(" ")).map(this::getWord).collect(Collectors.joining(" "));
    }

    public String getWord(String seg) {
        var zeros = seg.indexOf('0');
        if (zeros < 0)
            zeros = 0;
        else {
            zeros = seg.length() - zeros;
            seg = seg.substring(0, seg.length() - zeros);
        }
        String finalSeg = seg;
        // when tenshi hinanawi
        return freqTable.stream().filter(o -> generateT9(o.getWord()).equals(finalSeg)).sorted(Comparator.comparingInt(TableEntry::getFreq)).skip(zeros).findFirst().orElse(new TableEntry("", 0)).getWord();
    }
}