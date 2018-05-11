package engine;

import java.util.ArrayList;

public class Rule {

    private Majors majors = new Majors();
    private ArrayList<Proposition> conclusions = new ArrayList<>();

    public ArrayList<Proposition> findNewTruePropositions(ArrayList<Proposition> truth, ArrayList<Proposition> error) {
        ArrayList<Proposition> newPropositions = new ArrayList<>();
        if (this.majors.isTrue(truth, error)) {
            newPropositions.addAll(this.conclusions);
            newPropositions.addAll(this.majors.getCorollaries());
        }
        return newPropositions;
    }

    public ArrayList<Proposition> findNewFalsePropositions(ArrayList<Proposition> truth, ArrayList<Proposition> error) {
        ArrayList<Proposition> newErrors = new ArrayList<>();
        if (this.majors.isTrue(truth, error)) {
            newErrors.addAll(this.majors.getContraries());
        }
        return newErrors;
    }

    public Majors getMajors() {
        return majors;
    }

    public ArrayList<Proposition> getConclusions() {
        return conclusions;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "majors=" + majors +
                ", conclusions=" + conclusions +
                '}';
    }
}
