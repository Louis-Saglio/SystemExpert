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

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
