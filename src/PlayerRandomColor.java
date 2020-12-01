public class PlayerRandomColor extends Player {

    public PlayerRandomColor() {
        setName("Random Rebeka");
    }

    @Override
    public void play() {

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

        if (getBalance() < 0 || looses > wins + 10) {
            setActualBetSize(0);
            setWantToPlay(false);
        }
    }
}
