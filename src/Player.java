import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Player {

    private int balance;
    private int actualBetSize;
    private ArrayList<Integer> allBets = new ArrayList<>();
    private ArrayList<Integer> profitNloss = new ArrayList<>();
    private ArrayList<Integer> numbersToBetOn = new ArrayList<>();
    private Casino casino;

    public Player () {

    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int value) {
        balance += value;
    }

    public int getActualBetSize() {
        return actualBetSize;
    }

    public void setActualBetSize(int actualBetSize) {
        this.actualBetSize = actualBetSize;
    }

    public ArrayList<Integer> getAllBets() {
        return allBets;
    }

    public void setAllBets(ArrayList<Integer> allBets) {
        this.allBets = allBets;
    }

    public ArrayList<Integer> getProfitNloss() {
        return profitNloss;
    }

    public void setProfitNloss(int value) {
        profitNloss.add(value);
    }

    public ArrayList<Integer> getNumbersToBetOn() {
        return numbersToBetOn;
    }

    public void setNumbersToBetOn(ArrayList<Integer> numbersToBetOn) {
        this.numbersToBetOn = numbersToBetOn;
    }

    public Casino getCasino() {
        return casino;
    }

    public void setCasino(Casino casino) {
        this.casino = casino;
    }

    @Override
    public String toString() {
        return "Player{" +
                "allBets=" + allBets +
                ", profitNloss=" + profitNloss +
                ", numbersToBetOn=" + numbersToBetOn +
                '}';
    }

    public abstract void play ();
}
