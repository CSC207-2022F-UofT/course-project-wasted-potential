package UserRegistration;
import entities.UserFactory;
import entities.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserRegisterInteractor implements URegInputBoundary{

    final UserRegisterAndLoginDsGateway dsGateway;
    final URegPresenter presenter;
    final UserFactory userFactory;

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
                presenter.failView("This username is already in use.");
            } else {
                User user;

                LocalDateTime creationTime = LocalDateTime.now();
                DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String dateTimeString = creationTime.format(formatDateTime);

                if (userRequestModel.getUserType().equals("Player")) {
                    user = userFactory.createPlayer(userRequestModel.getUsername(), userRequestModel.getPassword(),
                            dateTimeString);
                } else {
                    user = userFactory.createDesigner(userRequestModel.getUserType(), userRequestModel.getPassword(),
                            dateTimeString);
                }
                dsGateway.save(user);

                UserRegisterResponseModel userResponseModel = new UserRegisterResponseModel(user.getUsername(),
                        user.getUserType(), user.getCreationTime());
                presenter.successView(userResponseModel);
            }
        } else {
            presenter.failView("Passwords do not match.");
        }
        return new UserRegisterResponseModel(null, null, null);
    }
}
