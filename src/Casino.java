import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Casino {

    private Rulett rulettWheel;
    private int minBet;
    private int maxBet;
    private List<Player> players = new ArrayList<>();

    public Casino(int minBet, int maxBet) {
        this.minBet = minBet;
        this.maxBet = maxBet;
        rulettWheel = new Rulett();
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
        player.setCasino(this);
    }

    public void oneRound() {
        for (Player p : players) {
            p.play();
        }

        rulettWheel.spin();

        int winnerNum = rulettWheel.getWinnerNum();
        String winnerColor = rulettWheel.getWinnerNumColor();
        System.out.println("*** a nyerőszám: " + winnerNum);

        for (Player p : players) {
            if (p.getActualBetSize() > 0) {
                System.out.println(p.getName() + " játszott. Vagyona a játék elején: " + p.getBalance());
                System.out.println("\t" + "tétje: " + p.getActualBetSize() + " zseton");
                System.out.println("\t" + "számok, amikre fogadott: " + p.getNumbersToBetOn());

                p.setBalance(-p.getActualBetSize());
                if (p.getNumbersToBetOn().contains(winnerNum)) {
                    int winPrice = countWinPrice(p);
                    p.setWinsNloss(winPrice);
                    p.setBalance(winPrice);

                    System.out.println(p.getName() + " nyert " + winPrice + " zsetont.");
                } else {
                    p.setWinsNloss(-p.getActualBetSize());
                    System.out.println(p.getName() + " veszített.");
                }
            }
        }

        for (Player p : players) {
            p.wantToPlayMore();
        }

        checkingPlayer();

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

    public void checkingPlayer (){
        List<Player> toRemove = new ArrayList<>();
        for (Player p : players) {
            if (!p.isWantToPlay()) {
                toRemove.add(p);
            }
        }
        players.removeAll(toRemove);
    }

}
