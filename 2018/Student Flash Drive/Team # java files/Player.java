import java.util.Objects;

/**
 * Write a description of class Player here.
 * 
 * @author Don Allen
 * @version 2018 Wittry contest
 */
public class Player
{
    private String myName;
    private int myABs;
    private int myHits;
    private int my2Bs;
    private int my3Bs;
    private int myHRs;
    private int myBBS;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name, int ab, int hits, int doubles, int triples, int hrs, int bbs)
    {
        myName = name;
        myABs= ab;
        myHits = hits;
        my2Bs = doubles;
        my3Bs = triples;
        myHRs = hrs;
        myBBS = bbs;
    }

    public String getName()  {  return myName;  }

    public int getNumAtBats()   {  return myABs;  }

    public int getNumHits()  {  return myHits;  }

    public int getNumDoubles()   {  return my2Bs;  }

    public int getNumTriples()  {  return my3Bs;  }

    public int getNumHomeRuns()   {  return myHRs;  }

    public int getNumWalks()  {  return myBBS;  }

    public int getNumSingles()
    {
        return myHits - my2Bs - my3Bs - myHRs;
    }

    /*
     *   returns (singles + 2*doubles + 3triple + 4*hr) / at Bats
     */
    public double getSluggingPercent()
    {
        return (double) (getNumSingles() + 2 * my2Bs  + 3 * my3Bs + 4 * myHRs) / (double) myABs;
    }

    /*
     *   returns  hits / at Bats
     */
    public double getBattingAverage()
    {
        return (double) myHits / (double) myABs;
    }

    /*
     *   returns (hits + base on Balls) / (at Bats + Base on Balls)
     */
    public double getOnBasePercentage()
    {
        return (double) (myHits + myBBS) / (double) (myABs + myBBS);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return myABs == player.myABs && myHits == player.myHits && my2Bs == player.my2Bs && my3Bs == player.my3Bs && myHRs == player.myHRs && myBBS == player.myBBS && myName.equals(player.myName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myName, myABs, myHits, my2Bs, my3Bs, myHRs, myBBS);
    }
}