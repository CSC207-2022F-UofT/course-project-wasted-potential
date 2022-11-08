package entities;
import java.util.HashMap;
import java.util.Map;

public abstract class Maze {
    private int numRows;
    private int numCol;
    private char[][] state;
    final static Map<String, Character> ENCODING = new HashMap<String, Character>() {{
        put("empty", '.');
        put("wall", '#');
    }};

//    public static void main(String[] args) {
//        System.out.println(ENCODING);
//    }

}
