import by.student.trainDesign.domain.Address;
import by.student.trainDesign.domain.Dimensions;
import by.student.trainDesign.domain.FreightCarriage;
import by.student.trainDesign.storage.FreightCarriageStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FreightCarriageStorageTest {
    private by.student.trainDesign.storage.FreightCarriageStorage freightCarriageStorage;
    private final Address address = new Address("Belarus", "Brest", "Leninist", "Alaya", 5);
    private final Date expectedDeliveryDate = new Date(System.currentTimeMillis() + 172_800_000);

    @BeforeEach
    public void before() {
        freightCarriageStorage = new FreightCarriageStorage();
    }

    @Test
    void addFreightCarriageTest() {
        FreightCarriage freightCarriage = new FreightCarriage(10, 5000, new Date(5000), 0.9,
                2.8, 22, 9000, new Dimensions(15, 2.6, 5));
        assertThrows(UnsupportedOperationException.class, () -> freightCarriageStorage.addFreightCarriage(freightCarriage));
    }

    @Test
    void editFreightCarriageTest() {
        FreightCarriage freightCarriage = new FreightCarriage(10, 5000, new Date(5000), 0.9,
                2.8, 22, 9000, new Dimensions(15, 2.6, 5));
        assertThrows(UnsupportedOperationException.class, () -> freightCarriageStorage.addFreightCarriage(freightCarriage));
        FreightCarriage changedFreightCarriage = new FreightCarriage(11, 6000, new Date(5000), 0.9,
                2.8, 22, 9000, new Dimensions(15, 2.6, 5));
        assertThrows(UnsupportedOperationException.class, () -> freightCarriageStorage.editFreightCarriage(11, changedFreightCarriage));
    }

    @Test
    void deleteFreightCarriageTest() {
        FreightCarriage freightCarriage = new FreightCarriage(10, 5000, new Date(5000), 0.9,
                2.8, 22, 9000, new Dimensions(15, 2.6, 5));
        assertThrows(UnsupportedOperationException.class, () -> freightCarriageStorage.addFreightCarriage(freightCarriage));
        assertThrows(UnsupportedOperationException.class, () -> freightCarriageStorage.deleteFreightCarriage(1));
    }

    @Test
    void getFreightCarriageTest() {
        FreightCarriage freightCarriage = new FreightCarriage(10, 5000, new Date(5000), 0.9,
                2.8, 22, 9000, new Dimensions(15, 2.6, 5));
        assertThrows(UnsupportedOperationException.class, () -> freightCarriageStorage.addFreightCarriage(freightCarriage));
        assertThrows(UnsupportedOperationException.class, () -> freightCarriageStorage.getFreightCarriage(11));

    }

    @Test
    void getFreightCarriagesCountTest() {
        FreightCarriage freightCarriage_1 = new FreightCarriage(10, 5000, new Date(5000), 0.9,
                2.8, 22, 9000, new Dimensions(15, 2.6, 5));
        FreightCarriage freightCarriage_2 = new FreightCarriage(11, 5000, new Date(5000), 0.9,
                2.8, 22, 9000, new Dimensions(15, 2.6, 5));
        assertThrows(UnsupportedOperationException.class, () -> freightCarriageStorage.addFreightCarriage(freightCarriage_1));
        assertThrows(UnsupportedOperationException.class, () -> freightCarriageStorage.addFreightCarriage(freightCarriage_2));
        assertThrows(UnsupportedOperationException.class, () -> freightCarriageStorage.getFreightCarriagesCount());
    }
}
