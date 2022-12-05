package screens;

import display.MazeDsGateway;
import entities.PublishedMaze;
import entities.SavedMaze;
import publish.PublishMazeGateway;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The gateway to write mazes into the database.
 */
public class MazeDatabase implements PublishMazeGateway, MazeDsGateway {
    private File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final PublishedMazeSingleton mazes = new PublishedMazeSingleton();

    /**
     * Instantiates a new Maze database.
     *
     * @param csvPath the csv path
     * @throws IOException    the io exception
     * @throws ParseException the parse exception
     */
    public MazeDatabase(String csvPath) throws IOException, ParseException {
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
            // The code smell when initializing a BufferedReader is left alone, as putting it in a try-catch affects
            // code readability according to Professor Jonathan.
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            // This line needs to be skipped, so the code smell will remain, as putting the skipping line into a
            // variable results in an unused variable code smell.
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
                char[] flatMaze = state.replace(":", "").replace(" ", "").toCharArray();
                char[][] mazeState = new char[11][17];
                for (int i = 0; i < 11; i++) {
                    System.arraycopy(flatMaze, (i * 17), mazeState[i], 0, 17);
                }
                int[] position = new int[2];
                String positionString = startPosition.replace("[", "")
                                                      .replace("]", "");
                position[0] = Integer.parseInt(String.valueOf(positionString.charAt(1)));
                position[1] = Integer.parseInt(String.valueOf(positionString.charAt(3)));

                mazes.addMaze(Integer.parseInt(id), new MazeInformation(name,
                        author,
                        LocalDate.parse(creationTime),
                        mazeState,
                        position));
            }

            reader.close();

        }
    }
    /**
     * Store the maze in the database.
     *
     * @param maze a SavedMaze representing the maze that is to be published.
     */
    @Override
    public void storeMaze(SavedMaze maze){
        mazes.addMaze(new MazeInformation(maze.getName(),
                      maze.getAuthor(),
                      maze.getPublishDate(),
                      maze.getState(),
                      maze.getStartPosition()));
        this.storeMaze();
    }
    /**
     * Writes the maze into the database.
     *
     */
    private void storeMaze(){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for(PublishedMaze maze: mazes.getPublishedMazes().values()){
                String info = String.format("%1$s,%2$s,%3$s,%4$s, %5$s, %6$s", maze.getId(),
                        maze.getName(), maze.getAuthor(),maze.getPublishDate(),
                        maze, Arrays.toString(maze.getStartPosition()).replace(",", ""));
                writer.write(info);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

    }

    /**
     * Gets a map containing integer ids to mazes.
     *
     * @return the mazes map.
     */
    public Map<Integer, PublishedMaze> getMazes() {
        return mazes.getPublishedMazes();
    }

    /**
     * Gets the maze corresponding to the given maze ID.
     *
     * @param mazeId the unique identifier for the maze to be retrieved
     * @return
     */
    @Override
    public PublishedMaze retrieveMaze(int mazeId) {
        return mazes.getPublishedMaze(mazeId);
    }
}
