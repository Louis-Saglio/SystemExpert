package engine;

import helpers.Helper;

public class Value {

    private int id;
    private String name;

    public Value(String name) {
        this.id = Helper.getInstance().generateId();
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
