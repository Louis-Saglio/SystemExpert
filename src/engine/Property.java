package engine;

import java.util.ArrayList;

public class Property extends ArrayList<Value> {
    private String name;

    public Property(String name) {
        this.name = name;
    }

    public ArrayList<Value> filter(Value filteredValue) {
        ArrayList<Value> filteredList = new ArrayList<>();
        for (Value value : this) {
            if (!value.equals(filteredValue)) {
                filteredList.add(value);
            }
        }
        return filteredList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Property property = (Property) o;
        if (!this.name.equals(property.name) || this.size() != property.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (!this.get(i).equals(property.get(i))) {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' + super.toString() +
                '}';
    }
}
