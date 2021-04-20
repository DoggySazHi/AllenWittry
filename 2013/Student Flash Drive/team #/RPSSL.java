import java.util.*;

public class RPSSL {
   private static class Pair {
      String source;
      String beats;

      Pair(String source, String beats) {
         this.source = source;
         this.beats = beats;
      }

      boolean equals(String source, String beats) {
         return this.source.equals(source) && this.beats.equals(beats);
      }
   }

   private static final List<Pair> beatMap;

   static {
      beatMap = new ArrayList<>();
      beatMap.add(new Pair("rock", "lizard"));
      beatMap.add(new Pair("rock", "scissors"));
      beatMap.add(new Pair("scissors", "lizard"));
      beatMap.add(new Pair("scissors", "paper"));
      beatMap.add(new Pair("lizard", "paper"));
      beatMap.add(new Pair("lizard", "spock"));
      beatMap.add(new Pair("spock", "rock"));
      beatMap.add(new Pair("spock", "scissors"));
      beatMap.add(new Pair("paper", "spock"));
      beatMap.add(new Pair("paper", "rock"));
   }

   public String playRound(Player p1, Player p2) {
      if (beatMap.stream().anyMatch(o -> o.equals(p1.getChoice(), p2.getChoice())))
         return p1.getName();
      if (beatMap.stream().anyMatch(o -> o.equals(p2.getChoice(), p1.getChoice())))
         return p2.getName();
      return "TIE";
   }
}