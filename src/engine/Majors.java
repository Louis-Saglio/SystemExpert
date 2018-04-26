package engine;

import java.util.ArrayList;

public class Majors extends ArrayList<Proposition> {

    public boolean isTrue(ArrayList<Proposition> truth, ArrayList<Proposition> error) {
        for (Proposition proposition : this) {
            if (!truth.contains(proposition) || error.contains(proposition)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Proposition> getCorollaries() {
        // todo test
        ArrayList<Proposition> corollaries = new ArrayList<>();
        for (Proposition proposition : this) {
            corollaries.addAll(proposition.getCorollaries());
        }
        return corollaries;
    }

    public ArrayList<Proposition> getContraries() {
        // todo test
        ArrayList<Proposition> contraries = new ArrayList<>();
        for (Proposition proposition : this) {
            contraries.addAll(proposition.getContraries());
        }
        return contraries;
    }
}
