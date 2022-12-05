package screens;
import java.io.*;
import java.util.*;

import register_and_login_shared_classes.UserRegisterAndLoginDsGateway;
import entities.User;
import entities.Player;
import entities.Designer;

/**
 * The User Database
 */
public class UserDatabase implements UserRegisterAndLoginDsGateway {

    private File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, User> userAccounts = new HashMap<>();

    /**
     * Instantiates a new User database.
     *
     * @param csvPath the CSV file path
     * @throws IOException the io exception
     */
    public UserDatabase(String csvPath) throws IOException{
        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("user_type", 1);
        headers.put("password", 2);
        headers.put("creation_time", 3);
        headers.put("mazes_played", 4);

        if(csvFile.length() == 0){
            save();
        } else {

            // Code Smell left alone because it makes the code harder to read through.
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));

            String userInfo;
            //Code smell left alone because this code skips the first line of the csv file.
            reader.readLine();

            while ((userInfo = reader.readLine()) != null){
                String[] col = userInfo.split(",");
                String username = String.valueOf(col[headers.get("username")]);
                String userType = String.valueOf(col[headers.get("user_type")]);
                String password = String.valueOf(col[headers.get("password")]);
                String creationTime = String.valueOf(col[headers.get("creation_time")]);
                String mazesPlayed = String.valueOf(col[headers.get("mazes_played")]);
                List<Integer> playedMazes = getMazes(mazesPlayed);



                if (userType.equals("Player")){
                    User user = new Player(username, password, creationTime,playedMazes);
                    userAccounts.put(username, user);
                } else if (userType.equals("Designer")){
                    User user = new Designer(username, password, creationTime);
                    userAccounts.put(username, user);
                } else {
                    throw new InputMismatchException();
                }

            }

            reader.close();

        }
    }
    @Override
    public void save (User user){
        userAccounts.put(user.getUsername(), user);
        this.save();
    }

    private void save(){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for(User user: userAccounts.values()){
                String info = String.format("%1$s,%2$s,%3$s,%4$s,%5$s", user.getUsername(),
                        user.getUserType(), user.getPassword(),user.getCreationTime(),
                        user.getMazesPlayed().mazeListToString());
                writer.write(info);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e){
            throw new IndexOutOfBoundsException(e.getMessage());
        }

    }

    @Override
    public boolean checkValidPassword(String username, String password){
        User userInfo = userAccounts.get(username);
        return password.equals(userInfo.getPassword());
    }

    @Override
    public String getUserType(String username){
        User userInfo = userAccounts.get(username);
        return userInfo.getUserType();
    }

    @Override
    public boolean existsByName(String username) {
        return userAccounts.containsKey(username);
    }

    /**
     * Gets mazes.
     *
     * @param mazesPlayed the mazes played
     * @return the mazes
     */
    public List<Integer> getMazes(String mazesPlayed) {
        List<Integer> playedMazes = new ArrayList<Integer>();
        String[] mazeList = mazesPlayed.split(":");
        for (String maze : mazeList) {
            playedMazes.add(Integer.parseInt(maze));
        }
        return playedMazes;
    }

    /**
     * Maze list to string string.
     *
     * @param playedMazes the played mazes
     * @return the string
     */
    public String MazeListToString (List<Integer> playedMazes) {
        String mazeList = "";
        for (Integer mazeId : playedMazes) {
            mazeList += mazeId.toString();
            mazeList += ":";
        }
        return mazeList;
    }

    /**
     * Add to played.
     *
     * @param mazeId   the maze id
     * @param username the username
     */
    void addToPlayed(int mazeId, String username) {
        userAccounts.get(username).getMazesPlayed().put(username, mazeId);
        this.save();
    }

    /**
     * Retrieve played array list.
     *
     * @param username the username
     * @return the array list
     */
    ArrayList<Integer> retrievePlayed(String username) {
        return userAccounts.get(username).getMazesPlayed();
    }

    /**
     * Retrieve not played array list.
     *
     * @param username the username
     * @return the array list
     */
    ArrayList<Integer> retrieveNotPlayed(String username) {
        PublishedMazeSingleton singleton;
        ArrayList<Integer> played = retrievePlayed(username);
        ArrayList<Integer> allMazes = (ArrayList<Integer>)singleton.getPublishedMazes().values();
        allMazes.removeAll(played); // Check this works
        return allMazes;

    }
}

