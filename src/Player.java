import java.util.ArrayList;

public abstract class Player {

    private int balance;
    private int actualBetSize;
    private ArrayList<Integer> allBets = new ArrayList<>();
    private ArrayList<Integer> winsNloss = new ArrayList<>();
    private ArrayList<Integer> numbersToBetOn = new ArrayList<>();
    private Casino casino;
    private boolean wantToPlay = true;

    public Player () {
        balance = (int) Math.random() * 480000 + 20001;
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

    public ArrayList<Integer> getWinsNloss() {
        return winsNloss;
    }

    public void setWinsNloss(int value) {
        winsNloss.add(value);
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

    public boolean isWantToPlay() {
        return wantToPlay;
    }

    public void setWantToPlay(boolean wantToPlay) {
        this.wantToPlay = wantToPlay;
    }

    @Override
    public String toString() {
        return "Player{" +
                "allBets=" + allBets +
                ", profitNloss=" + winsNloss +
                ", numbersToBetOn=" + numbersToBetOn +
                '}';
    }

    public abstract void play ();
}
