package engine;

import java.util.ArrayList;

public class Engine {

    private ArrayList<Proposition> truth, error;
    private Rules rules;

    public void process() {
        this.truth.addAll(this.rules.findNewTruePropositions(this.truth, this.error));
        this.error.addAll(this.rules.findNewFalsePropositions(this.truth, this.error));
    }

    public void setTruth(ArrayList<Proposition> truth) {
        this.truth = truth;
    }

    public void setError(ArrayList<Proposition> error) {
        this.error = error;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }
}
