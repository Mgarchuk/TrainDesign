import by.student.trainDesign.domain.Address;
import by.student.trainDesign.domain.PassengerCarriage;
import by.student.trainDesign.domain.TypeOfPassengerCarriage;
import by.student.trainDesign.storage.PassengerCarriageStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PassengerCarriageStorageTest {
    private by.student.trainDesign.storage.PassengerCarriageStorage passengerCarriageStorage;
    private final Address address = new Address("Belarus", "Brest", "Leninist", "Alaya", 5);
    private final Date expectedDeliveryDate = new Date(System.currentTimeMillis() + 172_800_000);

    @BeforeEach
    public void before() {
        passengerCarriageStorage = new PassengerCarriageStorage();
    }

    @Test
    void addPassengerCarriageTest() {
        PassengerCarriage passengerCarriage = new PassengerCarriage(10, 5000, new Date(700999),
                0.9, 2.8, 24, 96, TypeOfPassengerCarriage.RESERVED_SEAT);
        assertThrows(UnsupportedOperationException.class, () -> passengerCarriageStorage.addPassengerCarriage(passengerCarriage));
    }

    @Test
    void editPassengerCarriageTest() {
        PassengerCarriage passengerCarriage = new PassengerCarriage(10, 5000, new Date(700999),
                0.9, 2.8, 24, 96, TypeOfPassengerCarriage.RESERVED_SEAT);
        assertThrows(UnsupportedOperationException.class, () -> passengerCarriageStorage.addPassengerCarriage(passengerCarriage));
        PassengerCarriage changedPassengerCarriage = new PassengerCarriage(11, 4500, new Date(700999),
                0.9, 2.8, 24, 96, TypeOfPassengerCarriage.RESERVED_SEAT);
        assertThrows(UnsupportedOperationException.class, () -> passengerCarriageStorage.editPassengerCarriage(10, changedPassengerCarriage));
    }

    @Test
    void deletePassengerCarriageTest() {
        PassengerCarriage passengerCarriage = new PassengerCarriage(10, 5000, new Date(700999),
                0.9, 2.8, 24, 96, TypeOfPassengerCarriage.RESERVED_SEAT);
        assertThrows(UnsupportedOperationException.class, () -> passengerCarriageStorage.addPassengerCarriage(passengerCarriage));
        assertThrows(UnsupportedOperationException.class, () -> passengerCarriageStorage.deletePassengerCarriage(10));
    }

    @Test
    void getPassengerCarriageTest() {
        PassengerCarriage passengerCarriage = new PassengerCarriage(10, 5000, new Date(700999),
                0.9, 2.8, 24, 96, TypeOfPassengerCarriage.RESERVED_SEAT);
        assertThrows(UnsupportedOperationException.class, () -> passengerCarriageStorage.addPassengerCarriage(passengerCarriage));
        assertThrows(UnsupportedOperationException.class, () -> passengerCarriageStorage.getPassengerCarriage(10));

    }

    @Test
    void getPassengerCarriagesCountTest() {
        PassengerCarriage passengerCarriage_1 = new PassengerCarriage(10, 5000, new Date(700999),
                0.9, 2.8, 24, 96, TypeOfPassengerCarriage.RESERVED_SEAT);
        PassengerCarriage passengerCarriage_2 = new PassengerCarriage(11, 5000, new Date(700999),
                0.9, 2.8, 24, 96, TypeOfPassengerCarriage.RESERVED_SEAT);
        assertThrows(UnsupportedOperationException.class, () -> passengerCarriageStorage.addPassengerCarriage(passengerCarriage_1));
        assertThrows(UnsupportedOperationException.class, () -> passengerCarriageStorage.addPassengerCarriage(passengerCarriage_2));
        assertThrows(UnsupportedOperationException.class, () -> passengerCarriageStorage.getPassengerCarriagesCount());
    }
}
