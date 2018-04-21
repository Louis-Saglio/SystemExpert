package engine;

import helpers.Helper;

import java.util.ArrayList;

public class Fact {

    private int id;
    private Property property;
    private Value value;

    public Fact(Property property, Value value) {
        this.id = Helper.generateId();
        this.value = value;
        this.property = property;
    }

    public ArrayList<Fact> getContraries() {
        ArrayList<Fact> contraries = new ArrayList<>();
        for (Value value : property.filter(this.value)) {
            contraries.add(new Fact(this.property, value));
        }
        return contraries;
    }

}
