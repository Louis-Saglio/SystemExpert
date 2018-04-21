package engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PropertyTest {

    @Test
    public void testFilter() {
        Property property = new Property("test");
        ArrayList<Value> toRemain = new ArrayList<>();

        Value toBeFiltered = new Value("value1");
        property.add(toBeFiltered);

        toRemain.add(new Value("value2"));
        toRemain.add(new Value("value3"));

        property.add(toRemain.get(0));
        property.add(toRemain.get(1));

        ArrayList<Value> filtered = property.filter(toBeFiltered);

        for (int i = 0; i < toRemain.size(); i++) {
            Assertions.assertEquals(toRemain.size(), filtered.size());
            Assertions.assertEquals(toRemain.get(i).getId(), filtered.get(i).getId());
        }
    }

}
