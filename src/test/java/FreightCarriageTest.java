import by.student.trainDesign.domain.Dimensions;
import by.student.trainDesign.domain.FreightCarriage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreightCarriageTest {

    private FreightCarriage getRandomFreightCarriage(int number) {
        return new FreightCarriage(number, 4500, new Date(5000), 0.8, 2.8, 20,
                10000, new Dimensions(15, 2.5, 10));
    }

    @Test
    public void createFreightCarriageTest() {

        ArrayList<FreightCarriage> freightCarriagesList = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            freightCarriagesList.add(getRandomFreightCarriage(i));
            assertEquals(freightCarriagesList.get(i).getNumber(), i);
        }

        FreightCarriage freightCarriage = new FreightCarriage(10, 5000, new Date(5000), 0.9,
                2.8, 22, 9000, new Dimensions(15, 2.6, 5));
        assertEquals(freightCarriage.getNumber(), 10);
        assertEquals(freightCarriage.getWeight(), 5000);
        assertEquals(freightCarriage.getDateOfManufacture(), new Date(5000));
        assertEquals(freightCarriage.getDateOfManufacture(), getRandomFreightCarriage(11).getDateOfManufacture());
        assertEquals(freightCarriage.getBrakingEfficiency(), 0.9);
        assertEquals(freightCarriage.getTrackWidth(), 2.8);
        assertEquals(freightCarriage.getNumberOfAxles(), 22);
        assertEquals(freightCarriage.getLiftingCapacity(), 9000);
        assertEquals(freightCarriage.getHoldingCapacity().getLength(), 15);
        assertEquals(freightCarriage.getHoldingCapacity().getWidth(), 2.6);
        assertEquals(freightCarriage.getHoldingCapacity().getHeight(), 5);

        freightCarriage.setWeight(5500);
        freightCarriage.setBrakingEfficiency(0.89);

        assertEquals(freightCarriage.getWeight(), 5500);
        assertEquals(freightCarriage.getBrakingEfficiency(), 0.89);


    }
}

