package engine;

import java.util.ArrayList;
import java.util.HashSet;

public class Majors extends ArrayList<Proposition> {

    public boolean isTrue(HashSet<Proposition> truth, HashSet<Proposition> error) {
        for (Proposition proposition : this) {
            if (!truth.contains(proposition) || error.contains(proposition)) {
                return false;
            }
        }
        return true;
    }
}
