import java.util.ArrayList;

public class PlayerConservative extends Player {

    public PlayerConservative() {
        setName("Konzervatív Károly");
    }

    @Override
    public void play() {
        // megszámolja, hányszor veszített már
        int looses = 0;
        for (Integer i : getWinsNloss()) {
            if (i < 0) {
                looses++;
            }
        }

        // megszámolja, hányszor nyert már
        int wins = getWinsNloss().size() - looses;

        // akkor játszik, ha van pénze ÉS ha az eddigi veszített körök száma kevesebb/egyenlő, mint a nyert köröké
        if (getBalance() > 0 && looses <= wins) {
            // mindig a minimum téttel fogad
            int bet = getCasino().getMinBet();
            setActualBetSize(bet);

            // mindig a pirosra fogad
            ArrayList<Integer> betNums = getCasino().getRulettWheel().getFields().get("red");
            setNumbersToBetOn(betNums);
        } else {
            setActualBetSize(0);
            setWantToPlay(false);
        }

    }

}
