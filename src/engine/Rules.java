package engine;

import java.util.ArrayList;
import java.util.HashSet;

public class Rules extends ArrayList<Rule> {

    public ArrayList<Proposition> manageConclusions(HashSet<Proposition> truth, HashSet<Proposition> error) {
        ArrayList<Proposition> newPropositions = new ArrayList<>();
        for (Rule rule : this) {
            newPropositions.addAll(rule.manageConclusion(truth, error));
        }
        return newPropositions;
    }


    @Override
    public String toString() {
        return "Rules{" + super.toString() + "}";
    }
}
