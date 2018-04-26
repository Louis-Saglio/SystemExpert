package engine;

import java.util.ArrayList;

public class Rules extends ArrayList<Rules> {

    public ArrayList<Proposition> findNewTruePropositions(ArrayList<Proposition> truth, ArrayList<Proposition> error) {
        ArrayList<Proposition> newPropositions = new ArrayList<>();
        for (Rules rule : this) {
            newPropositions.addAll(rule.findNewTruePropositions(truth, error));
        }
        return newPropositions;
    }

    public ArrayList<Proposition> findNewFalsePropositions(ArrayList<Proposition> truth, ArrayList<Proposition> error) {
        ArrayList<Proposition> newErrors = new ArrayList<>();
        for (Rules rule : this) {
            newErrors.addAll(rule.findNewFalsePropositions(truth, error));
        }
        return newErrors;
    }

}
