package UserLogin;
import entities.User;

public class UserLoginInteractor implements ULoginInputBoundary{
    private String username;
    private String password;
    private User userType;

    public UserLoginInteractor(String username, String password, User userType){
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public boolean existsByName(String username){
        /* Check if user exists in database, returns boolean value */
    }

    public boolean checkValidPassword(String password){
        /* Check if password matches one in database */

    }

    @Override
    public void logUserIn() {
        if (existsByName(this.username)){
            if (checkValidPassword(this.password)){
                /* Log in if true */
            } else {
                /* Redirect to register page or say user does not exist? */
            }
        } else {
            /* Update presenter to show failure, no such user exists */
        }
    }

    /* What is presenter and gateway method? */
}
