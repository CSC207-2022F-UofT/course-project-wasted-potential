package publish;

import java.util.Date;

public class MazePublishedResponseModel {
    private String id;
    private String name;
    private Date publishDate;



    public MazePublishedResponseModel(String id, String name, Date publishDate) {
        this.id = id;
        this.name = name;
        this.publishDate = publishDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getPublishDate() {
        return publishDate;
    }
}
