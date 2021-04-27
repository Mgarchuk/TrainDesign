import by.student.trainDesign.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CargoTest {

    private final Address generalAddress = new Address("Belarus", "Minsk", "Sovetsky",
            "Leonida Bedy", 4);

    private Cargo getRandomAddress(int number) {
        return new Cargo(number, 10, TypeOfCargo.GENERAL, new Dimensions(10, 10, 10), Station.MINSK_NORTH,
                Station.BREST_EAST, generalAddress);
    }

    @Test
    public void createCargoTest() {
        List<Cargo> cargoList = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            cargoList.add(getRandomAddress(i));
            assertEquals(cargoList.get(i).getNumber(), i);
        }

        Cargo cargo_1 = new Cargo(10, 100, TypeOfCargo.BULK, new Dimensions(10, 30, 40),
                Station.BREST_CENTRAL, Station.MINSK_NORTH, generalAddress);
        assertEquals(cargo_1.getNumber(), 10);
        assertEquals(cargo_1.getTypeOfCargo(), TypeOfCargo.BULK);
        assertEquals(cargo_1.getDispatchStation(), Station.BREST_CENTRAL);
        assertEquals(cargo_1.getArrivalStation(), Station.MINSK_NORTH);
        assertEquals(cargo_1.getWeight(), 100);
        assertEquals(cargo_1.getDestination(), generalAddress);
        assertEquals(cargo_1.getDimensions().getLength(), 10);
        assertEquals(cargo_1.getDimensions().getWidth(), 30);
        assertEquals(cargo_1.getDimensions().getHeight(), 40);

        Cargo cargo_2 = new Cargo(11, 50, TypeOfCargo.DANGEROUS, new Dimensions(50, 10, 5),
                Station.MINSK_NORTH, Station.BREST_EAST, generalAddress);

        assertEquals(cargo_2.getNumber(), 11);
        assertEquals(cargo_2.getTypeOfCargo(), TypeOfCargo.DANGEROUS);
        assertEquals(cargo_2.getDispatchStation(), Station.MINSK_NORTH);
        assertEquals(cargo_2.getArrivalStation(), Station.BREST_EAST);
        assertEquals(cargo_2.getWeight(), 50);
        assertEquals(cargo_2.getDestination(), generalAddress);
        assertEquals(cargo_2.getDimensions().getLength(), 50);
        assertEquals(cargo_2.getDimensions().getWidth(), 10);
        assertEquals(cargo_2.getDimensions().getHeight(), 5);

        assertEquals(cargo_1.getDestination(), cargo_2.getDestination());

        cargo_2.setDispatchStation(Station.GRODNO);
        cargo_2.setArrivalStation(Station.GOMEL);
        cargo_2.setDestination(new Address("Belarus", "Gomel", "Sovetsky", "Sovetskaya",
                4, 23));

        assertEquals(cargo_2.getDestination().getCountry(), "Belarus");
        assertEquals(cargo_2.getDestination().getCountry(), generalAddress.getCountry());
        assertEquals(cargo_2.getDestination().getRegion(), "Gomel");
        assertEquals(cargo_2.getDestination().getDistrict(), "Sovetsky");
        assertEquals(cargo_2.getDestination().getStreet(), "Sovetskaya");
        assertEquals(cargo_2.getDestination().getNumberOfHouse(), "4");
        assertEquals(cargo_2.getDestination().getNumberOfFlat(), "23");
    }
}
