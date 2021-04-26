import by.student.trainDesign.domain.Address;
import by.student.trainDesign.domain.Carriage;
import by.student.trainDesign.storage.CarriageStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarriageStorageTest {
    private CarriageStorage carriageStorage;
    private final Address address = new Address("Belarus", "Brest", "Leninist", "Alaya", 5);
    private final Date expectedDeliveryDate = new Date(System.currentTimeMillis() + 172_800_000);

    @BeforeEach
    public void before() {
        carriageStorage = new CarriageStorage();
    }

    @Test
    void addCarriageTest() {
        Carriage carriage = new Carriage(10, 5000, new Date(19000), 0.9, 2.8, 20);
        assertThrows(UnsupportedOperationException.class, () -> carriageStorage.addCarriage(carriage));
    }

    @Test
    void editCarriageTest() {
        Carriage carriage = new Carriage(10, 5000, new Date(19000), 0.9, 2.8, 20);
        assertThrows(UnsupportedOperationException.class, () -> carriageStorage.addCarriage(carriage));
        Carriage changedCarriage = new Carriage(11, 6000, new Date(19000), 0.9, 2.8, 20);
        assertThrows(UnsupportedOperationException.class, () -> carriageStorage.editCarriage(11, changedCarriage));
    }

    @Test
    void deleteCarriageTest() {
        Carriage carriage = new Carriage(10, 5000, new Date(19000), 0.9, 2.8,
                20);
        assertThrows(UnsupportedOperationException.class, () -> carriageStorage.addCarriage(carriage));
        assertThrows(UnsupportedOperationException.class, () -> carriageStorage.deleteCarriage(1));
    }

    @Test
    void getCarriageTest() {
        Carriage carriage = new Carriage(10, 5000, new Date(19000), 0.9, 2.8,
                20);
        assertThrows(UnsupportedOperationException.class, () -> carriageStorage.addCarriage(carriage));
        assertThrows(UnsupportedOperationException.class, () -> carriageStorage.getCarriage(11));

    }

    @Test
    void getCarriagesCountTest() {
        Carriage carriage_1 = new Carriage(10, 5000, new Date(19000), 0.9, 2.8, 20);
        Carriage carriage_2 = new Carriage(11, 5000, new Date(19000), 0.9, 2.8, 20);
        assertThrows(UnsupportedOperationException.class, () -> carriageStorage.addCarriage(carriage_1));
        assertThrows(UnsupportedOperationException.class, () -> carriageStorage.addCarriage(carriage_2));
        assertThrows(UnsupportedOperationException.class, () -> carriageStorage.getCarriagesCount());
    }
}
