import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Casino casino = new Casino(1000,100000);

    public static void main(String[] args) {

        Main m = new Main();

        Scanner input = new Scanner(System.in);
        System.out.println("Mit szeretne csinálni? Adja meg a számot!");
        System.out.println("1 - szimuláció");
        System.out.println("2 - játék");

        String answer = input.nextLine();

        switch (answer) {
            case "1":
                System.out.println("Milyen stratégiát szeretne szimulálni? Adja meg a számát!");
                System.out.println("0 - minden elérhető stratégia");
                System.out.println("1 - Martingél Béla: mindig a pirosra fogad, a kezdőtéte a minimális tét, azután duplázza a tétet, amíg nem nyer");
                System.out.println("2 - Konzervatív Károly: mindig a pirosra fogad, a tétje mindig a minimális tét");
                String simAnswer = input.nextLine();
                m.simulation(simAnswer);
                break;
            case "2":
                m.userPlay(input);
                break;
            default:
                System.out.println("Eee, rossz válasz! Program vége.");
        }

        input.close();

    }

    public void simulation (String answer) {
        int nrOfSpins = (int) (Math.random() * 21 + 1);

        switch (answer) {
            case "0":
                PlayerBetsOnlyRed pOnlyRed = new PlayerBetsOnlyRed();
                PlayerConservative pCons = new PlayerConservative();
                casino.playerStepInto(pOnlyRed);
                casino.playerStepInto(pCons);
                playIt(nrOfSpins);
                break;
            case "1":
                PlayerBetsOnlyRed player1 = new PlayerBetsOnlyRed();
                casino.playerStepInto(player1);
                playIt(nrOfSpins);
                break;
            case "2":
                PlayerConservative player2 = new PlayerConservative();
                casino.playerStepInto(player2);
                playIt(nrOfSpins);
                break;
        }

    }

    public void userPlay(Scanner input) {
        Casino casino = new Casino(1000,100000);
        System.out.println("Milyen stratégiát szeretne követni?");

    }

    public void playIt(int round) {
        for (int i = 0; i < round; i++) {
            if (casino.getPlayers().size() > 0){
                System.out.println((i + 1) + ". kör...");
                casino.oneRound();
            } else {
                System.out.println("A szimuláció véget ért.");
                break;
            }
        }
    }

    public void drawRouletteTable () {
        System.out.println("   3 6 9 12 15 18 21 24 27 30 33 36");
        System.out.println("0  2 5 8 11 14 17 20 23 26 29 32 35");
        System.out.println("   1 4 7 10 13 16 19 22 25 28 31 34");
    }

}
