package UserRegistration;

public final class Singleton {
    private static Singleton instance;
    public String username;

    private Singleton(String username) {
        this.username = username;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}