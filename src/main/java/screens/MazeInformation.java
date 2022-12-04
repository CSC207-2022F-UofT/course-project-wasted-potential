package screens;


import java.time.LocalDate;

public class MazeInformation {
    String name;
    String author;
    LocalDate creationTime;
    char[][] state;
    int[] startPosition;

    public MazeInformation(String name, String author, LocalDate creationTime, char[][] state, int[] startPosition) {
        this.name = name;
        this.author = author;
        this.creationTime = creationTime;
        this.state = state;
        this.startPosition = startPosition;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getCreationTime() {
        return this.creationTime;
    }

    public char[][] getState() {
        return this.state;
    }

    public int[] getStartPosition() {
        return this.startPosition;
    }

}
