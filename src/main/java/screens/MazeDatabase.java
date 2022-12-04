package screens;

import entities.PublishedMaze;
import entities.SavedMaze;
import publish.MazePublisherGateway;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The type Maze database.
 */
public class MazeDatabase implements MazePublisherGateway {
    private File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final PublishedMazeSingleton mazes = new PublishedMazeSingleton();

    /**
     * Instantiates a new Maze database.
     *
     * @param csvPath the csv path
     * @throws IOException the io exception
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

                // use singleton with map and put info into mazeinformation class and pass into singleton to create published maze and put the maze back into the map
            }

            reader.close();

        }
    }
    @Override
    public void storeMaze(SavedMaze maze){
        mazes.addMaze(new MazeInformation(maze.getName(),
                      maze.getAuthor(),
                      maze.getPublishDate(),
                      maze.getState(),
                      maze.getStartPosition()));
        this.storeMaze();
    }

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
            throw new RuntimeException(e);
        }

    }

    /**
     * Gets mazes.
     *
     * @return the mazes
     */
    public Map<Integer, PublishedMaze> getMazes() {
        return mazes.getPublishedMazes();
    }
}
