package engine;

import helpers.Helper;

import java.util.ArrayList;

public class Property extends ArrayList<Value> {

    private int id;
    private String name;

    public Property(String name) {
        this.id = Helper.getInstance().generateId();
        this.name = name;
    }

    public ArrayList<Value> filter(Value filteredValue) {
        ArrayList<Value> filteredList = new ArrayList<>();
        for (Value value : this) {
            if (value.getId() != filteredValue.getId()) {
                filteredList.add(filteredValue);
            }
        }
        return filteredList;
    }

}
