package entities;
import java.util.HashMap;
import java.util.Map;

public abstract class Maze {
    private int numRow;
    private int numCol;
    protected char[][] state;
    final static Map<String, Character> ENCODING = new HashMap<String, Character>() {{
        put("empty", '.');
        put("wall", '#');
        put("start", 'S');
        put("end", 'E');
    }};

    public int getNumRow() {
        return numRow;
    }

    public int getNumCol() {
        return numCol;
    }

//    public static void main(String[] args) {
//        System.out.println(ENCODING);
//    }

}
