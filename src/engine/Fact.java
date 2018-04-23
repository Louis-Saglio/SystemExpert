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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fact fact = (Fact) o;
        return this.property.equals(fact.property) && this.value.equals(fact.value);
    }
}
