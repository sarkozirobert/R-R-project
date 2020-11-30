import java.util.ArrayList;

public class PlayerBetsOnlyRed extends Player{

    public PlayerBetsOnlyRed () {
    }

    @Override
    public void play() {
        //Main-be még jó lehet!

        /*Scanner sc1 = new Scanner(System.in);
        System.out.println("Adja meg a számokat, amikre tétet szeretne tenni! (Szóközzel elválasztva adja meg a számokat)");
        String line = sc1.nextLine();
        String[] parts = line.split(" ");


        for (int i = 0; i < parts.length; i++) {
            int actualNr = Integer.parseInt(parts[i]);
            this.getNumbersToBetOn().add(actualNr);
        }
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Adja meg a tét összegét! (Számot írjon be!)");
        this.setActualBetSize(sc2.nextInt());*/

        int bet = getCasino().getMinBet();
        setActualBetSize(bet);

        ArrayList<Integer> betNums = getCasino().getRulettWheel().getFields().get("red");
        setNumbersToBetOn(betNums);

        if (getWinsNloss().size() == 0) {
            setActualBetSize(bet);
        }
        else if (getWinsNloss().get(getWinsNloss().size() - 1) < 0) {
            setActualBetSize(getActualBetSize() * 2);
            if (getActualBetSize() > getCasino().getMaxBet()){
                setActualBetSize(getCasino().getMaxBet());
            }
        }
        else {
            setActualBetSize(0);
        }
    }
}
