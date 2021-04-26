import by.student.trainDesign.domain.PassengerCarriage;
import by.student.trainDesign.domain.TypeOfPassengerCarriage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PassengerCarriageTest {

    //мб сделать trackWidth по умолчанию
    private PassengerCarriage getRandomPassengerCarriage(int number) {
        return new PassengerCarriage(number, 4500, new Date(5000), 0.8, 2.8,
                20, 40, TypeOfPassengerCarriage.COMPARTMENT);
    }

    @Test
    public void createPassengerCarriageTest() {

        ArrayList<PassengerCarriage> passengerCarriagesList = new ArrayList<>();
        for( int i = 0; i < 10; ++i){
            passengerCarriagesList.add(getRandomPassengerCarriage(i));
            assertEquals(passengerCarriagesList.get(i).getNumber(), i);
        }

        PassengerCarriage passengerCarriage = new PassengerCarriage(10, 5000, new Date(700999),
                0.9, 2.8, 24, 96, TypeOfPassengerCarriage.RESERVED_SEAT);

        assertEquals(passengerCarriage.getNumber(), 10);
        assertEquals(passengerCarriage.getWeight(), 5000);
        assertNotEquals(passengerCarriage.getDateOfManufacture(), new Date(70000));
        assertEquals(passengerCarriage.getBrakingEfficiency(), 0.9);
        assertEquals(passengerCarriage.getTrackWidth(), 2.8);
        assertEquals(passengerCarriage.getNumberOfAxles(), 24);
        assertEquals(passengerCarriage.getNumberOfSeats(), 96);
        assertEquals(passengerCarriage.getTypeOfPassengerCarriage(), TypeOfPassengerCarriage.RESERVED_SEAT);

        passengerCarriage.setWeight(5019);
        passengerCarriage.setBrakingEfficiency(0.89);

        assertEquals(passengerCarriage.getWeight(), 5019);
        assertEquals(passengerCarriage.getBrakingEfficiency(), 0.89);
    }
}
