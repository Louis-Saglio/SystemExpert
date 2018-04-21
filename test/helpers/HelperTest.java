package helpers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class HelperTest {

    @Test
    void testGenerateId() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (int i = 0; i < 42; i++) {
            ids.add(Helper.getInstance().generateId());
        }
        for (Integer id : ids) {
            int occurrenceNumber = 0;
            for (Integer id2 : ids) {
                if (id.equals(id2)) {
                    occurrenceNumber++;
                }
            }
            Assertions.assertEquals(1, occurrenceNumber, "Id " + id + " generated more than once : " + occurrenceNumber);
        }
    }
}
