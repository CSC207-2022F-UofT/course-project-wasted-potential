package UserRegistration;
import entities.User;

public class UserRegisterInteractor implements URegInputBoundary{

    private String user;
    private String password;
    private String repeatPassword;
    private User userType;

    public UserRegisterInteractor(String user, String password, String repeatPassword, User userType){
        this.user = user;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.userType = userType;
    }

    /* Assuming since relevant info will be sent to the interactor, it should be stored and used over and over. */
    public boolean checkValidPassword(){
        return this.password.equals(this.repeatPassword);
    }


    @Override
    public void createUser() {
        if (checkValidPassword()){
            /* "UserRegisterDsRequestModel is created and sent to the UserRepo via the UserRegisterDsGateway */
            /* Idk how to get creation time */
            Object creationTime = null;
            UserRegisterDsRequestModel newUser = new UserRegisterDsRequestModel(this.user, this.userType,
                                                                                this.password, creationTime);
            /* Do sth with UserRepo that implements the gateway */
        }
    }
}
