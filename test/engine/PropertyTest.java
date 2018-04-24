package engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PropertyTest {

    @Test
    public void testFilter() {
        Property property = new Property("test");
        ArrayList<Value> toRemain = new ArrayList<>();

        Value toBeFiltered = new Value(property,"value1");

        new Value(property,"value2");
        new Value(property,"value3");

        toRemain.add(property.get(1));
        toRemain.add(property.get(2));
        ArrayList<Value> filtered = property.filter(toBeFiltered);

        for (int i = 0; i < toRemain.size(); i++) {
            // Relies on the fact that toRemain an filtered are ordered
            Assertions.assertEquals(toRemain.size(), filtered.size());
            Assertions.assertEquals(toRemain.get(i), filtered.get(i));
        }
    }

}
