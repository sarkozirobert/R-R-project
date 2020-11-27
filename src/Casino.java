import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Casino {

    private Rulett rulettWheel;
    private int minBet;
    private int maxBet;
    private List<Player> players = new ArrayList<>();

    public Casino(int minBet, int maxBet) {
        this.minBet = minBet;
        this.maxBet = maxBet;
    }

    public int getMinBet() {
        return minBet;
    }

    public int getMaxBet() {
        return maxBet;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void playerStepInto(Player player) {
        players.add(player);
    }

    public void oneRound() {
        rulettWheel.spin();
        int winnerNum = rulettWheel.getWinnerNum();
        String winnerColor = rulettWheel.getWinnerNumColor();

        for (Player p : players) {
            if (p.getNumbersToBetOn().contains(winnerNum)) {
                int newBalance = p.getBalance() + winnerPrice();
                p.setBalance(newBalance);
            }
        }
    }

    public int winnerPrice() {
        return 0;
    }

}
