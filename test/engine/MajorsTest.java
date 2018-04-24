package engine;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MajorsTest {

    @Test
    void testIsTrue() {
        Property property = new Property("p1");
        Proposition p1 = new Proposition(new Fact(property, new Value(property, "v1")), true);
        Proposition p2 = new Proposition(new Fact(property, new Value(property, "v2")), false);
        Proposition p3 = new Proposition(new Fact(property, new Value(property, "v3 ")), false);

        Majors majors = new Majors();
        majors.add(p1);

        assertFalse(majors.isTrue(new ArrayList<>(), new ArrayList<>()));

        ArrayList<Proposition> truth = new ArrayList<>();
        truth.add(p1);
        assertTrue(majors.isTrue(truth, new ArrayList<>()));

        ArrayList<Proposition> error = new ArrayList<>();
        error.add(p2);
        majors.add(p2);
        assertFalse(majors.isTrue(truth, error));
    }
}