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
    }

    @Test
    public void getVolumeTest() {
        Dimensions dimensions = new Dimensions(10, 20, 30);
        assertEquals(dimensions.getVolume(), 6000);
    }
}
