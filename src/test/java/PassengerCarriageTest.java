import by.student.trainDesign.domain.Age;
import by.student.trainDesign.domain.PassengerCarriage;
import by.student.trainDesign.domain.TypeOfPassengerCarriage;
import by.student.trainDesign.domain.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerCarriageTest {

    private PassengerCarriage getRandomPassengerCarriage(int number) {
        return new PassengerCarriage(number, 4500, new Date(5000), 0.8, 2.8,
                20, 40, TypeOfPassengerCarriage.COMPARTMENT);
    }

    @Test
    public void createPassengerCarriageTest() {

        List<PassengerCarriage> passengerCarriagesList = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
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

    @Test
    public void addAndGetPassengerTest() {
        PassengerCarriage passengerCarriage = new PassengerCarriage(10, 5000, new Date(700999),
                0.9, 2.8, 24, 2, TypeOfPassengerCarriage.RESERVED_SEAT);
        assertEquals(passengerCarriage.getPassengers().size(), 0);

        User user_1 = new User("1", "Marina", "Garchuk", Age.of(20));
        passengerCarriage.addPassenger(user_1);
        assertEquals(passengerCarriage.getPassengers().size(), 1);
        assertEquals(passengerCarriage.getPassengers().get(0).getId(), "1");
        assertEquals(passengerCarriage.getPassengers().get(0).getFirstName(), "Marina");
        assertEquals(passengerCarriage.getPassengers().get(0).getLastName(), "Garchuk");
        assertEquals(passengerCarriage.getPassengers().get(0).getAge(), Age.of(20));

        User user_2 = new User("2", "Katya", "Garchuk", Age.of(21));
        passengerCarriage.addPassenger(user_2);
        assertEquals(passengerCarriage.getPassengers().size(), 2);
        assertEquals(passengerCarriage.getPassengers().get(1).getId(), "2");
        assertEquals(passengerCarriage.getPassengers().get(1).getFirstName(), "Katya");
        assertEquals(passengerCarriage.getPassengers().get(1).getLastName(), "Garchuk");
        assertEquals(passengerCarriage.getPassengers().get(1).getAge(), Age.of(21));

        User user_3 = new User("3", "Sonya", "Saharchuk", Age.of(24));
        assertThrows(IllegalArgumentException.class, () -> passengerCarriage.addPassenger(user_3));
    }

    @Test
    public void deletePassengersTest() {
        PassengerCarriage passengerCarriage = new PassengerCarriage(10, 5000, new Date(700999),
                0.9, 2.8, 24, 2, TypeOfPassengerCarriage.RESERVED_SEAT);
        assertEquals(passengerCarriage.getPassengers().size(), 0);

        User user_1 = new User("1", "Marina", "Garchuk", Age.of(20));
        User user_2 = new User("2", "Katya", "Garchuk", Age.of(21));
        passengerCarriage.addPassenger(user_1);
        passengerCarriage.addPassenger(user_2);

        assertEquals(passengerCarriage.getPassengers().size(), 2);

        passengerCarriage.deletePassenger("2");
        assertEquals(passengerCarriage.getPassengers().size(), 1);
        assertThrows(IndexOutOfBoundsException.class, () -> passengerCarriage.getPassengers().get(1));

        passengerCarriage.deletePassenger(user_1);
        assertEquals(passengerCarriage.getPassengers().size(), 0);
        assertThrows(IndexOutOfBoundsException.class, () -> passengerCarriage.getPassengers().get(0));

        passengerCarriage.addPassenger(user_1);
        passengerCarriage.addPassenger(user_2);
        assertEquals(passengerCarriage.getPassengers().size(), 2);

        passengerCarriage.clearCarriage();
        assertEquals(passengerCarriage.getPassengers().size(), 0);

        passengerCarriage.deletePassenger(user_1);
    }
}
