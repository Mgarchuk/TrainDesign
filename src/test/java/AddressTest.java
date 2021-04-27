import by.student.trainDesign.domain.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {

    @Test
    public void createAddressTest() {
        Address address_1 = new Address("Belarus", "Minsk", "Leninsky", "Panaetova", 4);
        assertEquals(address_1.getCountry(), "Belarus");
        assertEquals(address_1.getRegion(), "Minsk");
        assertEquals(address_1.getDistrict(), "Leninsky");
        assertEquals(address_1.getStreet(), "Panaetova");
        assertEquals(address_1.getNumberOfHouse(), "4");

        address_1.setNumberOfFlat("10");
        assertEquals(address_1.getNumberOfFlat(), "10");

        Address address_2 = new Address("Belarus", "Brest", "Sovetsky", "Panaetova", 9, 10);
        assertEquals(address_2.getCountry(), "Belarus");
        assertEquals(address_2.getRegion(), "Brest");
        assertEquals(address_2.getDistrict(), "Sovetsky");
        assertEquals(address_2.getStreet(), "Panaetova");
        assertEquals(address_2.getNumberOfHouse(), "9");
        assertEquals(address_2.getNumberOfFlat(), "10");

        Address address_3 = new Address("Belarus", "Brest", "Leninsky", "Alaya", "5");
        assertEquals(address_3.getCountry(), "Belarus");
        assertEquals(address_3.getRegion(), "Brest");
        assertEquals(address_3.getDistrict(), "Leninsky");
        assertEquals(address_3.getStreet(), "Alaya");
        assertEquals(address_3.getNumberOfHouse(), "5");

        address_3.setNumberOfFlat(4);
        assertEquals(address_3.getNumberOfFlat(), "4");

        Address address_4 = new Address("Belarus", "Gomel", "Sovetsky", "Orda", "8/1", "10a");
        assertEquals(address_4.getCountry(), "Belarus");
        assertEquals(address_4.getRegion(), "Gomel");
        assertEquals(address_4.getDistrict(), "Sovetsky");
        assertEquals(address_4.getStreet(), "Orda");
        assertEquals(address_4.getNumberOfHouse(), "8/1");
        assertEquals(address_4.getNumberOfFlat(), "10a");
    }
}
