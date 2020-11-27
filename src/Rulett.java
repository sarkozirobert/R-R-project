import java.util.*;

public class Rulett {

    private Map<String, ArrayList<Integer>> fields;
    private int winnerNum;
    private String winnerNumColor;

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

    public int getWinnerNum() {
        return winnerNum;
    }

    public String getWinnerNumColor() {
        return winnerNumColor;
    }

    public void spin() {
        winnerNum = (int)(Math.random() * 37);

        for (Map.Entry<String, ArrayList<Integer>> entry : fields.entrySet()) {
            if (entry.getValue().contains(winnerNum)) {
                winnerNumColor = entry.getKey();
                break;
            }
        }
    }

}
