package design;

import java.util.HashSet;
import java.util.Set;

public class Vertex {
    int row;
    int col;

    public Vertex(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Vertex)) {
            return false;
        }

        Vertex v = (Vertex) o;

        return v.row == this.row && v.col == this.col;
    }


    // can prolly delete this later
    @Override
    public int hashCode() {
        return this.col + this.row;
    }

//    public static void main(String[] args) {
//        Vertex a = new Vertex(2,1);
//        Vertex b = new Vertex(1,2);
//        Set<Vertex> set = new HashSet<Vertex>();
//        set.add(a);
//
//        System.out.println(set.contains(b));
//    }
}
