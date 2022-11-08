package entities;
import java.util.HashMap;
import java.util.Map;

public abstract class Maze {
    private int num_rows;
    private int num_col;
    private char[][] state;
    final static Map<String, Character> MAZE_ENCODING = new HashMap<String, Character>() {{
        put("empty", '.');
        put("wall", 'w');
    }};

    public static void main(String[] args) {
        System.out.println(MAZE_ENCODING);
    }

}
