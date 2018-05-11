package engine;

import java.util.ArrayList;

public class Rules extends ArrayList<Rule> {

    public ArrayList<Proposition> manageConclusions(ArrayList<Proposition> truth, ArrayList<Proposition> error) {
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
