import by.student.trainDesign.domain.*;
import by.student.trainDesign.storage.CargoStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CargoStorageTest {
    private CargoStorage cargoStorage;
    private final Address address = new Address("Belarus", "Brest", "Leninist", "Alaya", 5);

    @BeforeEach
    public void before() {
        cargoStorage = new CargoStorage();
    }

    @Test
    void addCargoTest() {
        Cargo cargo = new Cargo(11, 50, TypeOfCargo.DANGEROUS, new Dimensions(50, 10, 5),
                Station.MINSK_NORTH, Station.BREST_EAST, address);
        assertThrows(UnsupportedOperationException.class, () -> cargoStorage.addCargo(cargo));
    }

    @Test
    void editCargoTest() {
        Cargo cargo = new Cargo(11, 50, TypeOfCargo.DANGEROUS, new Dimensions(50, 10, 5),
                Station.MINSK_NORTH, Station.BREST_EAST, address);
        assertThrows(UnsupportedOperationException.class, () -> cargoStorage.addCargo(cargo));
        Cargo changedCargo = new Cargo(12, 55, TypeOfCargo.DANGEROUS, new Dimensions(50, 10, 5),
                Station.MINSK_NORTH, Station.BREST_EAST, address);
        assertThrows(UnsupportedOperationException.class, () -> cargoStorage.editCargo(11, changedCargo));
    }

    @Test
    void deleteCargoTest() {
        Cargo cargo = new Cargo(11, 50, TypeOfCargo.DANGEROUS, new Dimensions(50, 10, 5),
                Station.MINSK_NORTH, Station.BREST_EAST, address);
        assertThrows(UnsupportedOperationException.class, () -> cargoStorage.addCargo(cargo));
        assertThrows(UnsupportedOperationException.class, () -> cargoStorage.deleteCargo(1));
    }

    @Test
    void getCargoTest() {
        Cargo cargo = new Cargo(11, 50, TypeOfCargo.DANGEROUS, new Dimensions(50, 10, 5),
                Station.MINSK_NORTH, Station.BREST_EAST, address);
        assertThrows(UnsupportedOperationException.class, () -> cargoStorage.addCargo(cargo));
        assertThrows(UnsupportedOperationException.class, () -> cargoStorage.getCargo(11));

    }

    @Test
    void getCargosCountTest() {
        Cargo cargo_1 = new Cargo(11, 50, TypeOfCargo.DANGEROUS, new Dimensions(50, 10, 5),
                Station.MINSK_NORTH, Station.BREST_EAST, address);
        Cargo cargo_2 = new Cargo(12, 40, TypeOfCargo.BULK, new Dimensions(5, 10, 5),
                Station.MINSK_NORTH, Station.BREST_EAST, address);
        assertThrows(UnsupportedOperationException.class, () -> cargoStorage.addCargo(cargo_1));
        assertThrows(UnsupportedOperationException.class, () -> cargoStorage.addCargo(cargo_2));
        assertThrows(UnsupportedOperationException.class, () -> cargoStorage.getCargosCount());
    }

}

