import java.util.ArrayList;
import java.util.Scanner;

public class User extends Player {

    @Override
    public void play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Milyen stratégiát szeretne játszani? (egy tétet tud felrakni pörgetésenként)");
        System.out.println("1. - Egy szám");
        System.out.println("2. - Két szám közé");
        System.out.println("3. - 4 szám együtt");
        System.out.println("4. - Csak fekete számok");
        System.out.println("5. - Csak piros számok");
        String  answer = sc.nextLine();

        switch (answer) {
            case "1":
                System.out.println("Melyik számra tesz tétet?");
                String line0 = sc.nextLine();
                int nrTobetOn = Integer.parseInt(line0);
                getNumbersToBetOn().add(nrTobetOn);
                break;
            case "2":
                System.out.println("Melyik két szám közé tesz tétet? (A két számot szóközzel elválasztva adja meg)");
                String line1 = sc.nextLine();
                String[] parts = line1.split(" ");
                int nr1 = Integer.parseInt(parts[0]);
                int nr2 = Integer.parseInt(parts[1]);
                getNumbersToBetOn().add(nr1);
                getNumbersToBetOn().add(nr2);
                break;
            case "3":
                System.out.println("Melyik 4 szám közé tesz tétet? (A 4 számot szóközzel elválasztva adja meg)");
                String line2 = sc.nextLine();
                String[] parts2 = line2.split(" ");
                int number1 = Integer.parseInt(parts2[0]);
                int number2 = Integer.parseInt(parts2[1]);
                int number3 = Integer.parseInt(parts2[2]);
                int number4 = Integer.parseInt(parts2[3]);
                getNumbersToBetOn().add(number1);
                getNumbersToBetOn().add(number2);
                getNumbersToBetOn().add(number3);
                getNumbersToBetOn().add(number4);
                break;
            case "4":
                ArrayList<Integer> betNums1 = getCasino().getRulettWheel().getFields().get("black");
                setNumbersToBetOn(betNums1);
                break;
            case "5":
                ArrayList<Integer> betNums2 = getCasino().getRulettWheel().getFields().get("red");
                setNumbersToBetOn(betNums2);
        }
        System.out.println("Mekkora összeggel szeretne fogadni? (Minimum tét: 1000, maximum tét: 100.000)");
        int betSize = sc.nextInt();
        setActualBetSize(betSize);
    }

    @Override
    public void wantToPlayMore() {
        setNumbersToBetOn(new ArrayList<>());
        System.out.println("Kíván tovább játszani? (igen / nem)");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine().toLowerCase();

        if (answer.equals("nem")) {
            setActualBetSize(0);
            setWantToPlay(false);
        }
    }
}
