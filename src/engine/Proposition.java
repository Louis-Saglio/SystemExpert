package engine;

import java.util.ArrayList;

public class Proposition {

    private Fact fact;
    private Boolean state;

    public Proposition(Fact fact, Boolean state) {
        this.fact = fact;
        this.state = state;
    }

    public ArrayList<Proposition> getCorollaries() {
        ArrayList<Proposition> opposites = new ArrayList<>();
        for (Fact fact : this.fact.getContraries()) {
            opposites.add(new Proposition(fact, !this.state));
        }
        return opposites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proposition proposition = (Proposition) o;
        return this.fact.equals(proposition.fact) && this.state.equals(proposition.state);
    }
}
