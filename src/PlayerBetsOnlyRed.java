import java.util.ArrayList;

public class PlayerBetsOnlyRed extends Player{

    public PlayerBetsOnlyRed () {
        setName("Martingél Béla");
    }

    @Override
    public void play() {

        ArrayList<Integer> betNums = getCasino().getRulettWheel().getFields().get("red");
        setNumbersToBetOn(betNums);

        if (getWinsNloss().size() == 0) {
            int bet = getCasino().getMinBet();
            setActualBetSize(bet);
        }
        else if (getWinsNloss().get(getWinsNloss().size() - 1) < 0) {
            setActualBetSize(getActualBetSize() * 2);
            if (getActualBetSize() > getCasino().getMaxBet()){
                setActualBetSize(getCasino().getMaxBet());
            }
        }

    }

    @Override
    public void wantToPlayMore() {
        if (getWinsNloss().get(getWinsNloss().size() - 1) > 0) {
            setActualBetSize(0);
            setWantToPlay(false);
        }
    }

}
