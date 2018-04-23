package engine;

import java.util.ArrayList;

public class Fact {
    private Property property;
    private Value value;

    public Fact(Property property, Value value) {
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
