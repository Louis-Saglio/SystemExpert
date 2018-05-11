package engine;

import java.util.ArrayList;

public class Engine {

    private ArrayList<Proposition> truth, error;
    private Rules rules;

    public void process() {
        for (Proposition proposition : this.rules.findNewTruePropositions(this.truth, this.error)) {
            if (!this.truth.contains(proposition)) {
                this.truth.add(proposition);
            }
        }
        for (Proposition proposition : this.rules.findNewFalsePropositions(this.truth, this.error)) {
            if (!this.error.contains(proposition)) {
                this.error.add(proposition);
            }
        }
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

    public ArrayList<Proposition> getTruth() {
        return truth;
    }

    public ArrayList<Proposition> getError() {
        return error;
    }
}
