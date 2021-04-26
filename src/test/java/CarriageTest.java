import by.student.trainDesign.domain.Carriage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CarriageTest {

    private Carriage getRandomCarriage(int number){
        return new Carriage(number, 3000, new Date(10000), 0.78, 2.8, 10);
    }

    @Test
    public void createCarriageTest() {
        ArrayList<Carriage> carriagesList = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            carriagesList.add(getRandomCarriage(i));
            assertEquals(carriagesList.get(i).getNumber(), i);
        }

        Carriage carriage = new Carriage(10, 5000, new Date(19000), 0.9, 2.8, 20);
        assertEquals(carriage.getNumber(), 10);
        assertEquals(carriage.getWeight(), 5000);
        assertNotEquals(carriage.getDateOfManufacture(), new Date(10));
        assertEquals(carriage.getDateOfManufacture(), new Date(19000));
        assertEquals(carriage.getBrakingEfficiency(), 0.9);
        assertEquals(carriage.getTrackWidth(), 2.8);
        assertEquals(carriage.getTrackWidth(), getRandomCarriage(11).getTrackWidth());
        assertEquals(carriage.getNumberOfAxles(), 20);

        carriage.setWeight(5010);
        carriage.setBrakingEfficiency(0.88);

        assertEquals(carriage.getWeight(), 5010);
        assertEquals(carriage.getBrakingEfficiency(), 0.88);

        assertThrows(IllegalArgumentException.class, () -> new Carriage(10, 5000, new Date(19000),
                -1,2.8, 20));
        assertThrows(IllegalArgumentException.class, () -> new Carriage(10, 5000, new Date(19000),
                1.01,2.8, 20));

    }
}
