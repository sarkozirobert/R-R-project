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

    public void simulation() {
        // things happen here
    }

    public void userPlay(Scanner input) {
        // other things happen here
    }

}
