import by.student.trainDesign.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreightCarriageTest {

    private final Address generalAddress = new Address("Belarus", "Minsk", "Sovetsky",
            "Leonida Bedy", 4);

    private FreightCarriage getRandomFreightCarriage(int number) {
        return new FreightCarriage(number, 4500, new Date(5000), 0.8, 2.8, 20,
                10000, new Dimensions(15, 2.5, 10));
    }

    @Test
    public void createFreightCarriageTest() {

        List<FreightCarriage> freightCarriagesList = new ArrayList<>();
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

    @Test
    public void addAndDeleteCargoTest() {
        FreightCarriage freightCarriage = new FreightCarriage(10, 5000, new Date(5000), 0.9,
                2.8, 22, 9000, new Dimensions(15, 2.6, 5));
        assertEquals(freightCarriage.getCargos().size(), 0);

        Cargo cargo_1 = new Cargo(10, 100, TypeOfCargo.BULK, new Dimensions(10, 30, 40),
                Station.BREST_CENTRAL, Station.MINSK_NORTH, generalAddress);
        freightCarriage.addCargo(cargo_1);
        assertEquals(freightCarriage.getCargos().size(), 1);
        assertEquals(freightCarriage.getCargos().get(0).getNumber(), 10);
        assertEquals(freightCarriage.getCargos().get(0).getWeight(), 100);
        assertEquals(freightCarriage.getCargos().get(0).getTypeOfCargo(), TypeOfCargo.BULK);
        assertEquals(freightCarriage.getCargos().get(0).getDimensions().getHeight(), 40);
        assertEquals(freightCarriage.getCargos().get(0).getDimensions().getWidth(), 30);
        assertEquals(freightCarriage.getCargos().get(0).getDimensions().getLength(), 10);
        assertEquals(freightCarriage.getCargos().get(0).getDispatchStation(), Station.BREST_CENTRAL);
        assertEquals(freightCarriage.getCargos().get(0).getArrivalStation(), Station.MINSK_NORTH);
        assertEquals(freightCarriage.getCargos().get(0).getDestination(), generalAddress);

        Cargo cargo_2 = new Cargo(11, 50, TypeOfCargo.DANGEROUS, new Dimensions(50, 10, 5),
                Station.MINSK_NORTH, Station.BREST_EAST, generalAddress);
        freightCarriage.addCargo(cargo_2);
        assertEquals(freightCarriage.getCargos().size(), 2);
        assertEquals(freightCarriage.getCargos().get(1).getNumber(), 11);
        assertEquals(freightCarriage.getCargos().get(1).getWeight(), 50);
        assertEquals(freightCarriage.getCargos().get(1).getTypeOfCargo(), TypeOfCargo.DANGEROUS);
        assertEquals(freightCarriage.getCargos().get(1).getDimensions().getHeight(), 5);
        assertEquals(freightCarriage.getCargos().get(1).getDimensions().getWidth(), 10);
        assertEquals(freightCarriage.getCargos().get(1).getDimensions().getLength(), 50);
        assertEquals(freightCarriage.getCargos().get(1).getDispatchStation(), Station.MINSK_NORTH);
        assertEquals(freightCarriage.getCargos().get(1).getArrivalStation(), Station.BREST_EAST);
        assertEquals(freightCarriage.getCargos().get(1).getDestination(), generalAddress);
    }
}

