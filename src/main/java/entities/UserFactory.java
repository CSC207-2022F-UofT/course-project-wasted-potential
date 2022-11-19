package entities;

public class UserFactory {
    public Player createPlayer(String name, String password, String creationTime) {
        return new Player(name, password, creationTime);
    }

    public Designer createDesigner(String name, String password, String creationTime) {
        return new Designer(name, password, creationTime);
    }
}