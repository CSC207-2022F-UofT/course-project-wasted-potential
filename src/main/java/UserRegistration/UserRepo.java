package UserRegistration;
import UserLogin.UserLoginRepo;
import entities.UserFactory;
import screens.UserDatabase;
import entities.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class UserRepo implements UserRegisterDsGateway{
    private UserRegisterDsRequestModel newUser;
    final UserFactory userFactory;
    final UserDatabase userdatabase;
    final URegPresenter presenter;

    public UserRepo(UserRegisterDsRequestModel newUser, UserFactory userFactory,
                    UserDatabase userdatabase, URegPresenter presenter, UserLoginRepo loginRepo){
        this.newUser = newUser;
        this.userFactory = userFactory;
        this.userdatabase = userdatabase;
        this.presenter = presenter;
    }

    @Override
    public void storeUser(UserRegisterRequestModel userRequestModel) {
        boolean checkExistence = userdatabase.existsByName(userRequestModel.getUsername());;
        if (checkExistence){
            presenter.failView("This username is already in use.");
        } else {
            LocalDateTime creationTime = LocalDateTime.now();
            DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String dateTimeString = creationTime.format(formatDateTime);

            User user;

            if (userRequestModel.getUserType().equals("Player")){
                user = userFactory.createPlayer(userRequestModel.getUsername(), userRequestModel.getPassword(),
                        dateTimeString);
            } else {
                user = userFactory.createDesigner(userRequestModel.getUserType(), userRequestModel.getPassword(),
                        dateTimeString);
            }
            userdatabase.save(user);

            UserRegisterResponseModel userResponseModel = new UserRegisterResponseModel(user.getUsername(),
                    user.getUserType(), user.getCreationTime());
            presenter.successView(userResponseModel);
        }
    }
}
