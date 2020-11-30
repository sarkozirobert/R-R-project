import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();

        Scanner input = new Scanner(System.in);
        System.out.println("Mit szeretne csinálni? Adja meg a számot!");
        System.out.println("1 - szimuláció");
        System.out.println("2 - játék");

        String answer = input.nextLine();

        switch (answer) {
            case "1":
                m.simulation();
                break;
            case "2":
                m.userPlay(input);
                break;
            default:
                System.out.println("Eee, rossz válasz! Program vége.");
        }

        input.close();

    }

    public void simulation () {
        // things happen here

        PlayerBetsOnlyRed player1 = new PlayerBetsOnlyRed();
        Casino casino = new Casino(1000,100000);
        casino.playerStepInto(player1);
        int nrOfSpins = (int) (Math.random() * 21 + 1);
        for (int i = 0; i <nrOfSpins; i++) {
            casino.checkingPlayer();
            if (casino.getPlayers().size() > 0){
                casino.oneRound();
            }
            else {
                System.out.println("Nincs több játékos, a szimuláció leáll.");
                break;
            }
        }
    }

    public void userPlay(Scanner input) {
        System.out.println("Válasszon stratégiát! Adja meg a stratégia számát!");
        System.out.println("1 - egyéni (a tét és a megjátszott számok egyénileg adhatóak meg)");
        System.out.println("2 - Martingél Béla (csak a pirosra fogad, a tét első körben a minimális tét, utána mindig az előző duplája, amíg nem nyer");
        System.out.println("3 - konzervatív (csak a pirosra fogad, mindig a minimum téttel)");
        String answer = input.nextLine();

        switch (answer) {
            case "1":
                // ez még nincs kész
                break;
            case "2":
                PlayerBetsOnlyRed pOnlyRed = new PlayerBetsOnlyRed();
                break;
            case "3":
                PlayerConservative pCons = new PlayerConservative();
                break;
            default:
                System.out.println("Nincs ilyen stratégia, a program leáll.");
        }
    }

}
