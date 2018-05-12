package engine;

import java.util.ArrayList;
import java.util.HashSet;

public class Engine {

    private HashSet<Proposition> truth, error;
    private Rules rules;

    public void process() {
        this.truth.addAll(this.rules.manageConclusions(this.truth, this.error));

        HashSet<Proposition> news = new HashSet<>();
        for (Proposition proposition : this.truth) {
            news.addAll(proposition.getCorollaries());
        }
        this.truth.addAll(news);

        HashSet<Proposition> errors = new HashSet<>();
        for (Proposition proposition : this.truth) {
            errors.addAll(proposition.getContraries());
        }
        this.error.addAll(errors);
    }

    public Proposition choosePropositionToAsk() {
        for (Rule rule : rules) {
            if (!rule.getMajors().isTrue(this.truth, this.error)) {
                for (Proposition major : rule.getMajors()) {
                    if (!truth.contains(major)) {
                        return major;
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<Proposition> getFinals() {
        ArrayList<Proposition> finals = new ArrayList<>();
        for (Proposition proposition : truth) {
            if (proposition.isFinal()) {
                finals.add(proposition);
            }
        }
        return finals;
    }

    public void setTruth(HashSet<Proposition> truth) {
        this.truth = truth;
    }

    public void setError(HashSet<Proposition> error) {
        this.error = error;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }

    public HashSet<Proposition> getTruth() {
        return truth;
    }

    public HashSet<Proposition> getError() {
        return error;
    }
}
