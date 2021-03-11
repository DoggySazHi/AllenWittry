public class Player {
    String name;
    int ftMade;
    int twoShotsMade;
    int threeShotsMade;
    int assist;
    int dRebs;
    int oRebs;
    int blocks;
    int to;
    int fouls;
    int steals;
    double salary;

    public Player(String name,
                  int ftMade,
                  int twoShotsMade,
                  int threeShotsMade,
                  int assist,
                  int dRebs,
                  int oRebs,
                  int blocks,
                  int to,
                  int fouls,
                  int steals,
                  double salary)
    {
        this.name = name;
        this.ftMade = ftMade;
        this.twoShotsMade = twoShotsMade;
        this.threeShotsMade = threeShotsMade;
        this.assist = assist;
        this.dRebs = dRebs;
        this.oRebs = oRebs;
        this.blocks = blocks;
        this.to = to;
        this.fouls = fouls;
        this.steals = steals;
        this.salary = salary;
    }

    public int getPointsScored()
    {
        return ftMade + 2 * twoShotsMade + 3 * threeShotsMade;
    }

    public int getReboundEfficiency()
    {
        return 3 * dRebs + 5 * oRebs;
    }

    public int getBallControlEfficiency()
    {
        return assist + blocks + steals - to - fouls;
    }

    public int getMVPrating()
    {
        return 2 * (getPointsScored() +  getReboundEfficiency() + getBallControlEfficiency()) -
                Math.max(getPointsScored(), Math.max(getReboundEfficiency(), getBallControlEfficiency())) -
                Math.min(getPointsScored(), Math.min(getReboundEfficiency(), getBallControlEfficiency()));
    }

    public int getAssistToTurnoverMargin()
    {
        return 2 * assist - to;
    }

    public int getValueRatio()
    {
        return (int) (getPointsScored() + getReboundEfficiency() - salary * to);
    }
}