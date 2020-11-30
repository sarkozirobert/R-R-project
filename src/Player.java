import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Player {

    private int balance;
    private int actualBetSize;
    private ArrayList<Integer> allBets = new ArrayList<>();
    private ArrayList<Integer> profitNloss = new ArrayList<>();
    private ArrayList<Integer> numbersToBetOn = new ArrayList<>();

    public Player () {
        balance = (int) Math.random() * 480000 + 20001;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
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

    public void setProfitNloss(ArrayList<Integer> profitNloss) {
        this.profitNloss = profitNloss;
    }

    public ArrayList<Integer> getNumbersToBetOn() {
        return numbersToBetOn;
    }

    public void setNumbersToBetOn(ArrayList<Integer> numbersToBetOn) {
        this.numbersToBetOn = numbersToBetOn;
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
