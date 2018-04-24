package engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PropositionTest {

    @Test
    void testGetCorollaries() {

        Property property = new Property("size");

        Value v1 = new Value(property,"v1");
        Value v2 = new Value(property,"v2");
        Value v3 = new Value(property,"v3");

        Fact fact = new Fact(property, v1);

        Proposition proposition = new Proposition(fact, true);

        ArrayList<Proposition> expectedCorollaries = new ArrayList<>();
        expectedCorollaries.add(new Proposition(new Fact(property, v2), false));
        expectedCorollaries.add(new Proposition(new Fact(property, v3), false));

        ArrayList<Proposition> actualCorollaries = proposition.getCorollaries();

        Assertions.assertArrayEquals(expectedCorollaries.toArray(), actualCorollaries.toArray());
    }
}
