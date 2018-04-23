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
}
