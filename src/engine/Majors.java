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
}
