package engine;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MajorsTest {

    @Test
    void testIsTrue() {
        Property property = new Property("p1");
        Proposition p1 = new Proposition(new Fact(property, new Value(property, "v1")), true);
        Proposition p2 = new Proposition(new Fact(property, new Value(property, "v2")), false);
        Proposition p3 = new Proposition(new Fact(property, new Value(property, "v3 ")), false);

        Majors majors = new Majors();
        majors.add(p1);

        assertFalse(majors.isTrue(new HashSet<>(), new HashSet<>()));

        HashSet<Proposition> truth = new HashSet<>();
        truth.add(p1);
        assertTrue(majors.isTrue(truth, new HashSet<>()));

        HashSet<Proposition> error = new HashSet<>();
        error.add(p2);
        majors.add(p2);
        assertFalse(majors.isTrue(truth, error));
    }
}