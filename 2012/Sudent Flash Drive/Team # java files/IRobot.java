import java.util.*;

public class IRobot
{
    private static class Block {
        private final String color;
        private Block above;

        public Block(String block) {
            this.color = block;
        }

        public String getColor() {
            return color;
        }

        public Block getAbove() {
            return above;
        }

        public void setAbove(Block below) {
            this.above = below;
        }
    }

    private static class Keywords {
        String color = null;
        String secondColor = null; // Won't use arrays because I doubt at most two will exist.
        String hand = null;

        public Keywords(String s) {
            Arrays.stream(s.split(" "))
                    .filter(o -> o.length() > 0 && Character.isUpperCase(o.charAt(0)))
                    .forEach(o -> {
                        if (o.equals("LEFT") || o.equals("RIGHT") || o.equals("MIDDLE"))
                            hand = o;
                        else if (color == null)
                            color = o;
                        else
                            secondColor = o;
                    });
        }
    }

    private final List<Block> table;
    private String leftHand;
    private String middleHand;
    private String rightHand;

    public IRobot(List<String> col)
    {
        table = new ArrayList<>();
        for (var b : col)
            table.add(new Block(b));
        leftHand = null;
        middleHand = null;
        rightHand = null;
    }

    public void command(String com)
    {
        var kw = new Keywords(com);
        if (com.contains("pick") && com.contains("place")) {
            var object = findBlock(kw.color, true);
            var target = findBlock(kw.secondColor, false);
            if (target != null && target.getAbove() == null) // Check if we can find the block to place, AND is not already stacked.
                target.setAbove(object);
        }
        else if (com.contains("pick")) {
            var block = findBlock(kw.color, true);
            if (block != null)
                switch (kw.hand) {
                    case "LEFT":
                        leftHand = kw.color;
                        break;
                    case "RIGHT":
                        rightHand = kw.color;
                        break;
                    case "MIDDLE":
                        middleHand = kw.color;
                        break;
                }
        } else if (com.contains("drop")) {
            // Now I flipping wish Java had true pointers.
            switch (kw.hand) {
                case "LEFT":
                    if (leftHand != null)
                        table.add(new Block(leftHand));
                    leftHand = null;
                    break;
                case "RIGHT":
                    if (rightHand != null)
                        table.add(new Block(rightHand));
                    rightHand = null;
                    break;
                case "MIDDLE":
                    if (middleHand != null)
                        table.add(new Block(middleHand));
                    middleHand = null;
                    break;
            }
        } else { // Assumed place.
            var target = findBlock(kw.color, false);
            if (target == null || target.getAbove() != null)
                return;
            switch (kw.hand) {
                case "LEFT":
                    target.setAbove(new Block(leftHand));
                    leftHand = null;
                    break;
                case "RIGHT":
                    target.setAbove(new Block(rightHand));
                    rightHand = null;
                    break;
                case "MIDDLE":
                    target.setAbove(new Block(middleHand));
                    middleHand = null;
                    break;
            }
        }
    }

    public String question(String question)
    {
        var kw = new Keywords(question);
        if (question.contains("empty")) {
            switch (kw.hand) {
                case "LEFT":
                    return leftHand == null ? "YES" : "NO";
                case "RIGHT":
                    return rightHand == null ? "YES" : "NO";
                case "MIDDLE":
                    return middleHand == null ? "YES" : "NO";
            }
        } else if (question.contains("is there")) {
            var block = findBlock(kw.color, false);
            if (block == null)
                return "NO";
            return block.getAbove() != null ? "YES" : "NO";
        } else if (question.contains("color") && question.contains("top")) {
            var block = findBlock(kw.color, false);
            if (block == null || block.getAbove() == null)
                return "dunno.";
            return block.getAbove().color;
        } else if (question.contains("color") && question.contains("hand")) {
            switch (kw.hand) {
                case "LEFT":
                    return leftHand;
                case "RIGHT":
                    return rightHand;
                case "MIDDLE":
                    return middleHand;
            }
        } else { // Assumed to ask if XXX is directly on the table.
            for (var b : table)
                if (b.getColor().equals(kw.color))
                    return "YES";
            return "NO";
        }
        // I'll be concerned if we get here.
        return "neko miko reimu ai shiteru (Command not found!)";
    }

    private Block findBlock(String color, boolean delete) {
        for (var b : table) {
            Block oldTemp = null;
            var temp = b;
            while (temp != null) {
                if (temp.getColor().equals(color)) {
                    if (delete) {
                        if (oldTemp == null)
                            table.remove(temp);
                        else
                            oldTemp.setAbove(null);
                    }
                    return temp;
                }
                oldTemp = temp;
                temp = temp.getAbove();
            }
        }
        if (
                leftHand != null && leftHand.equals(color) ||
                        rightHand != null && rightHand.equals(color) ||
                        middleHand != null && middleHand.equals(color)
        )
            return new Block(color);
        return null; // Not on table or hands, which is weird and shouldn't happen.
    }
}