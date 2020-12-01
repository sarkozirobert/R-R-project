public class PlayerRandomColor extends Player {

    public PlayerRandomColor() {
        setName("Random Rebeka");
    }

    @Override
    public void play() {
        int min = getCasino().getMinBet();
        int max = getCasino().getMaxBet() - min;
        int bet = (int)(Math.random() * max + min);
        setActualBetSize(bet);

        boolean forRed = Math.random() < 0.5d;

        if (forRed) {
            setNumbersToBetOn(getCasino().getRulettWheel().getFields().get("red"));
        } else {
            setNumbersToBetOn(getCasino().getRulettWheel().getFields().get("black"));
        }
    }

    @Override
    public void wantToPlayMore() {
        int looses = 0;
        int wins = 0;

        if (getWinsNloss().size() > 0) {
            for (Integer i : getWinsNloss()) {
                if (i < 0) {
                    looses++;
                }
            }
            wins = getWinsNloss().size() - looses;
        }

        if (getBalance() < 0 || looses > wins + 3) {
            setActualBetSize(0);
            setWantToPlay(false);
        }
    }
}
