package UserRegistration;
import register_and_login_shared_classes.UserRegisterAndLoginDsGateway;
import entities.UserFactory;
import entities.User;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The interactor which implements the input boundary and creates the user,
 * stores them in the database, and logs them in automatically after creation is complete.
 */
public class UserRegisterInteractor implements URegInputBoundary{

    final UserRegisterAndLoginDsGateway dsGateway;
    final URegPresenter presenter;
    final UserFactory userFactory;

    /**
     * Instantiates a new interactor.
     *
     * @param dsGateway   the gateway
     * @param presenter   the presenter
     * @param userFactory the user factory
     */
    public UserRegisterInteractor(UserRegisterAndLoginDsGateway dsGateway, URegPresenter presenter, UserFactory userFactory){
        this.dsGateway = dsGateway;
        this.presenter = presenter;
        this.userFactory = userFactory;
    }

    @Override
    public UserRegisterResponseModel createUser(UserRegisterRequestModel userRequestModel) {
        boolean validPassword = userRequestModel.getPassword().equals(userRequestModel.getRepeatPassword());
        if (validPassword) {
            if (dsGateway.existsByName(userRequestModel.getUsername())) {
                return presenter.failView("This username is already in use.");

            } else {
                User user;

                LocalDateTime creationTime = LocalDateTime.now();
                DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String dateTimeString = creationTime.format(formatDateTime);

                if (userRequestModel.getUserType().equals("Player")) {
                    user = userFactory.createPlayer(userRequestModel.getUsername(), userRequestModel.getPassword(),
                            dateTimeString);
                } else {
                    user = userFactory.createDesigner(userRequestModel.getUsername(), userRequestModel.getPassword(),
                            dateTimeString);
                }
                dsGateway.save(user);

                UserRegisterResponseModel userResponseModel = new UserRegisterResponseModel(user.getUsername(),
                        user.getUserType(), user.getCreationTime());
                return presenter.successView(userResponseModel);

            }
        } else {
            return presenter.failView("Passwords do not match.");
        }
    }
}
