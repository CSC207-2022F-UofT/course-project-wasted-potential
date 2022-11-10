package UserRegistration;

public class UserRepo implements UserRegisterDsGateway{
    /* Code once figure out how to store users */
    /* How to store user info? instance variables? */
    private UserRegisterDsRequestModel newUser;

    public UserRepo(UserRegisterDsRequestModel newUser){
        this.newUser = newUser;
    }
    @Override
    public void existsByName() {

    }

    @Override
    public void storeUser() {
        /* Different for Designer and Player? */

    }
}
