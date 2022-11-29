package screens;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import register_and_login_shared_classes.UserRegisterAndLoginDsGateway;
import entities.User;
import entities.Player;

public class UserDatabase implements UserRegisterAndLoginDsGateway {

    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, User> userAccounts = new HashMap<>();

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

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));

            String userInfo;
            reader.lines().skip(1);

            while ((userInfo = reader.readLine()) != null){
                String[] col = userInfo.split(",");
                String username = String.valueOf(col[headers.get("username")]);
                String userType = String.valueOf(col[headers.get("user_type")]);
                String password = String.valueOf(col[headers.get("password")]);
                String creationTime = String.valueOf(col[headers.get("creation_time")]);

                if (userType.equals("Player")){
                    User user = new Player(username, password, creationTime);
                    userAccounts.put(username, user);
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
                String info = String.format("%1$s,%2$s,%3$s,%4$s", user.getUsername(),
                        user.getUserType(), user.getPassword(),user.getCreationTime());
                writer.write(info);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e){
            throw new RuntimeException(e);
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
}
