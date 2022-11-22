package publish;

import entities.PublishedMaze;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The type Maze database.
 */
public class MazeDatabase implements MazePublisherGateway{
    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, PublishedMaze> mazes = new HashMap<>();

    /**
     * Instantiates a new Maze database.
     *
     * @param csvPath the csv path
     * @throws IOException the io exception
     */
    public MazeDatabase(String csvPath) throws IOException{
        csvFile = new File(csvPath);
        headers.put("id", 0);
        headers.put("name", 1);
        headers.put("author", 2);
        headers.put("creation_time", 3);
        headers.put("state", 4);
        headers.put("startPosition", 5);

        if(csvFile.length() == 0){
            storeMaze();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine();

            String mazeInfo;
            while ((mazeInfo = reader.readLine()) != null){
                String[] col = mazeInfo.split(",");
                String id = String.valueOf(col[headers.get("id")]);
                String name = String.valueOf(col[headers.get("name")]);
                String author = String.valueOf(col[headers.get("author")]);
                String creationTime = String.valueOf(col[headers.get("creation_time")]);
                String state = String.valueOf(col[headers.get("state")]);
                String startPosition = String.valueOf(col[headers.get("startPosition")]);
            }

            reader.close();

        }
    }
    @Override
    public void storeMaze (PublishedMaze maze){
        mazes.put(maze.getId(), maze);
        this.storeMaze();
    }

    private void storeMaze(){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for(PublishedMaze maze: mazes.values()){
                String info = String.format("%1$s,%2$s,%3$s,%4$s, %5$s, %6$s", maze.getId(),
                        maze.getName(), maze.getAuthor(),maze.getPublishDate(),
                        maze, Arrays.toString(maze.getStartPosition()));
                writer.write(info);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    /**
     * Gets mazes.
     *
     * @return the mazes
     */
    public Map<String, PublishedMaze> getMazes() {
        return mazes;
    }
}
