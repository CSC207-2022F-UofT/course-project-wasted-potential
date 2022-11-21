package screens;

public class InvalidMove extends RuntimeException {

    public InvalidMove(String message) {
        super(message);
    }
}
