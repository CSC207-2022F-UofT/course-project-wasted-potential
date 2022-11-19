package UserLogin;

import UserRegistration.UserRegisterDsRequestModel;

public interface UserLoginDsGateway {
    public void logUserIn(UserLoginDsRequestModel user);
}
