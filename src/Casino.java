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

    public Rulett getRulettWheel() {
        return rulettWheel;
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
        for (Player p : players) {
            p.play();
        }
        rulettWheel.spin();
        int winnerNum = rulettWheel.getWinnerNum();
        String winnerColor = rulettWheel.getWinnerNumColor();

        for (Player p : players) {
            if (p.getNumbersToBetOn().contains(winnerNum)) {
                int newBalance = p.getBalance() + countWinnerPrice(winnerNum, p.getActualBetSize());
                p.setBalance(newBalance);
            }
        }
    }

    public int countWinnerPrice(int winnerNum, int betSize) {
        // megkapja a győztes számot, illetve a játékos által feltett összeget
        // ebből számolja ki, hogy mennyit kap a játékos
        // itt szerintem érdemes HashMap-be berakni a különböző nyerőosztályokat

        return 0;
    }

}
