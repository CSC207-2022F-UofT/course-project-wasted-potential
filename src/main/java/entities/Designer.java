package entities;

public class Designer extends User{
    private String username;
    private String password;
    private String creationTime;

    public Designer(String username, String password, String creationTime){
        super(username, password, "Designer", creationTime);
    }


}
