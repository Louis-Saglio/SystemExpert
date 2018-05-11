package engine;

import java.util.ArrayList;

public class Rules extends ArrayList<Rule> {

    public ArrayList<Proposition> findNewTruePropositions(ArrayList<Proposition> truth, ArrayList<Proposition> error) {
        ArrayList<Proposition> newPropositions = new ArrayList<>();
        for (Rule rule : this) {
            newPropositions.addAll(rule.findNewTruePropositions(truth, error));
        }
        return newPropositions;
    }

    public ArrayList<Proposition> findNewFalsePropositions(ArrayList<Proposition> truth, ArrayList<Proposition> error) {
        ArrayList<Proposition> newErrors = new ArrayList<>();
        for (Rule rule : this) {
            newErrors.addAll(rule.findNewFalsePropositions(truth, error));
        }
        return newErrors;
    }

    @Override
    public String toString() {
        return "Rules{" + super.toString() + "}";
    }
}
