package engine;

public class Value {

    private String name;

    public Value(String name) {
        this.name = name;
    }

    public boolean equals(Value value) {
        return this.name.equals(value.name);
    }

    @Override
    public String toString() {
        return "Value{" + "id=" + ", name='" + name + '\'' + '}';
    }
}
