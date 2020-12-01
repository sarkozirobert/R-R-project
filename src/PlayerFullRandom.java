import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlayerFullRandom extends Player {

    public PlayerFullRandom() {
        setName("Totál Random Töhötöm");
    }
    @Override
    public void play() {
        int min = getCasino().getMinBet();
        int max = getCasino().getMaxBet() - min;
        int bet = (int)(Math.random() * max + min);
        setActualBetSize(bet);

        boolean forColor = Math.random() < 0.5d;

        if (forColor) {
            ArrayList<Integer> reds = getCasino().getRulettWheel().getFields().get("red");
            ArrayList<Integer> blacks = getCasino().getRulettWheel().getFields().get("black");
            ArrayList<Integer> numbers = (Math.random() < 0.5d ? reds : blacks );
        } else {
            int num = (int)(Math.random() * 37);
            ArrayList<Integer> betNums = new ArrayList<>();
            betNums.add(num);
            setNumbersToBetOn(betNums);
        }
    }

    @Override
    public void wantToPlayMore() {
        if (getBalance() < 0) {
            setActualBetSize(0);
            setWantToPlay(false);
        }
    }
}
