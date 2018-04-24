package engine;

public class Value {

    private String name;

    public Value(Property property, String name) {
        this.name = name;
        property.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value = (Value) o;
        return this.name.equals(value.name);
    }

    @Override
    public String toString() {
        return "Value{" + "id=" + ", name='" + name + '\'' + '}';
    }
}
