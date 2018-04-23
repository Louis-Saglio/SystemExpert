package engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FactTest {

    @Test
    void testGetContraries() {
        Property size = new Property("size");
        size.add(new Value("big"));
        size.add(new Value("medium"));
        size.add(new Value("small"));

        Fact fact = new Fact(size, size.get(0));

        ArrayList<Fact> expectedContraries = new ArrayList<>();
        expectedContraries.add(new Fact(size, size.get(1)));
        expectedContraries.add(new Fact(size, size.get(2)));

        ArrayList<Fact> actualContraries = fact.getContraries();

        Assertions.assertEquals(expectedContraries.size(), actualContraries.size());

        for (int i = 0; i < expectedContraries.size(); i++) {
            Assertions.assertEquals(expectedContraries.get(i), actualContraries.get(i));
        }
    }
}
