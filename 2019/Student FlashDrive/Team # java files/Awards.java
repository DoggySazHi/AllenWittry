import java.util.*;

// NOTE: I wrote this two years ago (someone sent me a message during this thing).
// So, I won't be using my normal streaming to solve this.
// https://cdn.discordapp.com/attachments/601998175301140480/819362557437149194/unknown.png

public class Awards
{
    private List<Player> myTeam;

    private Player MVP;
    private Player offensivePlayer;
    private Player defensivePlayer;
    private Player mostEffective;

    public Awards(List<Player> temp)
    {
        myTeam = new ArrayList<Player>();
        for(Player p : temp)
            myTeam.add(p);

        MVP = null;
        offensivePlayer = null;
        defensivePlayer = null;
        mostEffective = null;
    }

    /*
     *   This methods determines and returns the Player selected as MVP
     */
    public Player getMVP()
    {
        if(myTeam.size() == 0)
            return null;
        Player mvp = myTeam.get(0);
        for(Player p : myTeam) {
            if (p.getMVPrating() == mvp.getMVPrating() && p.salary < mvp.salary || p.getMVPrating() > mvp.getMVPrating())
                mvp = p;
        }
        MVP = mvp;
        return mvp;
    }

    /*
     *   This methods determines and returns the Player selected as Offensive Player
     *
     *   remember, the Player winning MVP SHALL be selected for this award
     */
    public Player getOffensivePlayer()
    {
        getMVP();
        if(myTeam.size() == 0)
            return null;
        Player mvp = myTeam.get(0);
        for(Player p : myTeam) {
            if (p != MVP && ((p.getPointsScored() == mvp.getPointsScored() && p.getAssistToTurnoverMargin() > mvp.getAssistToTurnoverMargin()) || p.getPointsScored() > mvp.getPointsScored()))
                mvp = p;
        }
        offensivePlayer = mvp;
        return mvp;
    }

    /*
     *   This methods determines and returns the Player selected as Defensive Player
     *
     *   remember, the Player winning MVP or Offensive Player SHALL be selected for this award
     */
    public Player getDefensivePlayer()
    {
        getMVP();
        getOffensivePlayer();
        if(myTeam.size() == 0)
            return null;
        Player mvp = myTeam.get(0);
        for(Player p : myTeam) {
            if ((p != MVP && p != offensivePlayer) && p.steals > mvp.steals)
                mvp = p;
        }
        defensivePlayer = mvp;
        return mvp;

    }

    /*
     *   This methods determines and returns the Player selected as Most Effective Player
     *
     *   remember, the Player winning MVP, Offensive Player or Defensive Player SHALL be selected for this award
     */
    public Player getMostEffective()
    {
        getMVP();
        getOffensivePlayer();
        getDefensivePlayer();
        if(myTeam.size() == 0)
            return null;
        Player mvp = myTeam.get(0);
        for(Player p : myTeam) {
            if ((p != MVP && p != offensivePlayer && p != defensivePlayer) && ((p.getValueRatio() == mvp.getValueRatio() && p.ftMade > mvp.ftMade) || (p.getValueRatio() > mvp.getValueRatio())))
                mvp = p;
        }
        mostEffective = mvp;
        return mvp;
    }
}