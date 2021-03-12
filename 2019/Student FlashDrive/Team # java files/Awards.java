import java.util.*;

// NOTE: I wrote this two years ago (someone sent me a message during this thing).
// So, I won't be using my normal streaming to solve this.
// https://cdn.discordapp.com/attachments/601998175301140480/819362557437149194/unknown.png

public class Awards {
    private final List<Player> myTeam;

    private Player MVP;
    private Player offensivePlayer;
    private Player defensivePlayer;
    private Player mostEffective;

    public Awards(List<Player> temp) {
        myTeam = new ArrayList<>(temp);

        MVP = null;
        offensivePlayer = null;
        defensivePlayer = null;
        mostEffective = null;
    }

    /*
     *   This methods determines and returns the Player selected as MVP
     */
    public Player getMVP() {
        MVP = myTeam.stream()
                .min(Comparator.comparingInt(Player::getMVPrating)
                        .reversed()
                        .thenComparingDouble(Player::getSalary))
                .orElse(null);
        return MVP;
    }

    /*
     *   This methods determines and returns the Player selected as Offensive Player
     *
     *   remember, the Player winning MVP SHALL be selected for this award
     */
    public Player getOffensivePlayer() {
        getMVP();

        offensivePlayer = myTeam.stream().filter(o -> o != MVP)
                .sorted(Comparator.comparingInt(Player::getPointsScored)
                        .thenComparingInt(Player::getAssistToTurnoverMargin))
                .reduce((a, b) -> b) // Get last item in the stream. Because I can't figure out how .reverse() works.
                .orElse(null);
        return offensivePlayer;
    }

    /*
     *   This methods determines and returns the Player selected as Defensive Player
     *
     *   remember, the Player winning MVP or Offensive Player SHALL be selected for this award
     */
    public Player getDefensivePlayer() {
        getMVP();
        getOffensivePlayer();

        defensivePlayer = myTeam.stream().filter(o -> o != MVP && o != offensivePlayer)
                .min(Comparator.comparingInt(Player::getSteals).reversed().thenComparingInt(Player::getFouls))
                .orElse(null);
        return defensivePlayer;
    }

    /*
     *   This methods determines and returns the Player selected as Most Effective Player
     *
     *   remember, the Player winning MVP, Offensive Player or Defensive Player SHALL be selected for this award
     */
    public Player getMostEffective() {
        getMVP();
        getOffensivePlayer();
        getDefensivePlayer();

        mostEffective = myTeam.stream().filter(o -> o != MVP && o != offensivePlayer && o != defensivePlayer)
                .sorted(Comparator.comparingInt(Player::getValueRatio).thenComparingInt(Player::getFreeThrowsMade))
                .reduce((a, b) -> b)
                .orElse(null);
        return mostEffective;
    }
}