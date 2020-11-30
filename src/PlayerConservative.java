import java.util.ArrayList;

public class PlayerConservative extends Player {

    public PlayerConservative() {
        setName("Konzervatív Károly");
    }

    @Override
    public void play() {
        int bet = getCasino().getMinBet();
        setActualBetSize(bet);

        ArrayList<Integer> betNums = getCasino().getRulettWheel().getFields().get("red");
        setNumbersToBetOn(betNums);
    }

    @Override
    public void wantToPlayMore() {
        if (getBalance() < 0) {
            setActualBetSize(0);
            setWantToPlay(false);
        }
    }

}
