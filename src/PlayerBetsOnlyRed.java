import java.util.ArrayList;
import java.util.Scanner;

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

        Casino casino = new Casino(200, 20000);
        Scanner sc = new Scanner(System.in);
        System.out.println("Adja meg a stratégiát!");
        String strategy = sc.nextLine();
        if (strategy == "csak piros, tét mindig duplázva"){
            this.setActualBetSize(casino.getMinBet());
        }
    }
}
