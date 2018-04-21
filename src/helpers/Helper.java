package helpers;

public class Helper {
    private static Helper ourInstance = new Helper();
    private static int idMax;

    public static Helper getInstance() {
        return ourInstance;
    }

    private Helper() {
    }

    public static int generateId() {
        Helper.idMax += 1;
        return Helper.idMax;
    }
}
