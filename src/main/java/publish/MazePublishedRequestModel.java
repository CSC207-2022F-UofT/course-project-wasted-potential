package publish;

import entities.DesignableMaze;

public class MazePublishedRequestModel {
    private String author;
    private String name;

    private DesignableMaze dm;

    public MazePublishedRequestModel(String author, String name, DesignableMaze dm) {
        this.author = author;
        this.name = name;
        this.dm = dm;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public DesignableMaze getDm() {
        return dm;
    }
}
