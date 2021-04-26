import by.student.trainDesign.domain.Dimensions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DimensionTest {
    @Test
    public void createDimensionTest() {
        Dimensions dimensions = new Dimensions(10, 20, 30);
        assertEquals(dimensions.getLength(), 10);
        assertEquals(dimensions.getWidth(), 20);
        assertEquals(dimensions.getHeight(), 30);

        dimensions.setHeight(20);
        assertEquals(dimensions.getHeight(), dimensions.getWidth());
        assertEquals(dimensions.getHeight(), 20);

        dimensions.setWidth(40);
        dimensions.setLength(100);

        assertEquals(dimensions.getWidth(), 40);
        assertEquals(dimensions.getLength(), 100);
    }
}
