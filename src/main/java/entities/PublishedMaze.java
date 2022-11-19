package entities;

import java.util.Date;

public class PublishedMaze extends Maze{
    private String author;
    private String name;
    private Boolean published;
    private Date publishDate;
    private String id;

    public PublishedMaze() {}

    public PublishedMaze(String author,
                         String name,
                         Boolean published,
                         Date date,
                         char[][] state) {
        this.author = author;
        this.name = name;
        this.published = published;
        this.publishDate = date;
        this.id = this.publishDate.toString() + this.author;
        this.state = state;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public Boolean getPublished() {
        return published;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public String getId() {
        return id;
    }
}