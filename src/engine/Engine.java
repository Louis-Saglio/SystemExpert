package engine;

import java.util.ArrayList;

public class Engine {

    private ArrayList<Proposition> truth, error;
    private Rules rules;

    public void process() {
        for (Proposition proposition : this.rules.manageConclusions(this.truth, this.error)) {
            if (!this.truth.contains(proposition)) {
                this.truth.add(proposition);
            }
        }

        ArrayList<Proposition> news = new ArrayList<>();
        for (Proposition proposition : this.truth) {
            for (Proposition corollary : proposition.getCorollaries()) {
                if (!this.truth.contains(corollary) && !news.contains(corollary)) {
                    news.add(corollary);
                }
            }
        }
        this.truth.addAll(news);

        ArrayList<Proposition> errors = new ArrayList<>();
        for (Proposition proposition : this.truth) {
            for (Proposition contrary : proposition.getContraries()) {
                if (!this.error.contains(contrary) && !errors.contains(contrary)) {
                    errors.add(contrary);
                }
            }
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
