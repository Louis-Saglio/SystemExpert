package helpers;

public class Helper {
    private static Helper ourInstance = new Helper();
    private int idMax;

    public static Helper getInstance() {
        return ourInstance;
    }

    private Helper() {
    }

    public int generateId() {
        this.idMax += 1;
        return this.idMax;
    }
}
