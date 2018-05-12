package engine;

import java.util.ArrayList;
import java.util.HashSet;

public class Rule {

    private Majors majors = new Majors();
    private ArrayList<Proposition> conclusions = new ArrayList<>();

    public ArrayList<Proposition> manageConclusion(HashSet<Proposition> truth, HashSet<Proposition> error) {
        ArrayList<Proposition> newPropositions = new ArrayList<>();
        if (this.majors.isTrue(truth, error)) {
            newPropositions.addAll(this.conclusions);
        }
        return newPropositions;
    }

    public Majors getMajors() {
        return majors;
    }

    public ArrayList<Proposition> getConclusions() {
        return conclusions;
    }
}
