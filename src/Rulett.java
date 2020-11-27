import java.util.*;

public class Rulett {

    private Map<String, ArrayList<Integer>> fields;
    private String winnerNum;

    public Rulett() {
        Integer[] red = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        Integer[] black = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};

        ArrayList<Integer> reds = new ArrayList<>(Arrays.asList(red));
        ArrayList<Integer> blacks = new ArrayList<>(Arrays.asList(black));
        ArrayList<Integer> theNull = new ArrayList<>();
        theNull.add(0);

        fields.put("red", reds);
        fields.put("black", blacks);
        fields.put("green", theNull);
    }

    public String getWinnerNum() {
        return winnerNum;
    }

    public void spin() {
        int num = (int)(Math.random() * 3);

        switch (num) {
            case 0:
                winnerNum = "0";
                break;
            case 1:
                int numForRed = (int)(Math.random() * fields.get("red").size());
                winnerNum = "red " + numForRed;
                break;
            case 2:
                int numForBlack = (int)(Math.random() * fields.get("black").size());
                winnerNum = "black " + numForBlack;
                break;
        }
    }

}
