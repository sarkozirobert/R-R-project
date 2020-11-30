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
            p.setBalance(-p.getActualBetSize());
            if (p.getNumbersToBetOn().contains(winnerNum)) {
                int winPrice = countWinPrice(p);
                p.setProfitNloss(winPrice);
                p.setBalance(winPrice);
            } else {
                p.setProfitNloss(p.getActualBetSize());
            }
        }
    }

    public int countWinPrice(Player p) {
        // megkapja a játékos által feltett összeget
        // ebből számolja ki, hogy mennyit kap a játékos

        switch (p.getNumbersToBetOn().size()) {
            // ha egy számra rakott a játékos
            case 1:
                return p.getActualBetSize() * 36;
            // ha két számra rakott
            case 2:
                return p.getActualBetSize() * 18;
            // ha négy számra rakott
            case 4:
                return p.getActualBetSize() * 8;
            // ha hat számra rakott
            case 6:
                return p.getActualBetSize() * 6;
            // ha "tucatra" rakott
            case 12:
                return p.getActualBetSize() * 4;
            // ha színre, páros-páratlanra vagy 1-18/19-36-ra rakott
            case 18:
                return p.getActualBetSize() * 2;

        }

        return 0;
    }

}
