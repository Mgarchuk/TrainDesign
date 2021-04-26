import by.student.trainDesign.domain.Age;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AgeTest {

    //норм ли название
    @Test
    public void createAgeTest() {
        Age age = new Age((byte) 10);
        assertEquals(age.intValue(), 10);

        Age staticAge = Age.of(37);
        assertEquals(staticAge.intValue(), 37);

        assertThrows(IllegalArgumentException.class, () -> new Age((byte) -19));
        assertThrows(IllegalArgumentException.class, () -> new Age((byte) 199));
    }

}
