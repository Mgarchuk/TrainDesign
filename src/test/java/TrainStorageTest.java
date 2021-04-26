import by.student.trainDesign.domain.Address;
import by.student.trainDesign.domain.Station;
import by.student.trainDesign.domain.Train;
import by.student.trainDesign.storage.TrainStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrainStorageTest {
    private by.student.trainDesign.storage.TrainStorage trainStorage;
    private final Address address = new Address("Belarus", "Brest", "Leninist", "Alaya", 5);
    private final Date expectedDeliveryDate = new Date(System.currentTimeMillis() + 172_800_000);

    @BeforeEach
    public void before() {
        trainStorage = new TrainStorage();
    }

    @Test
    void addTrainTest() {
        Train train = new Train(5, Station.BREST_CENTRAL, Station.GOMEL);
        assertThrows(UnsupportedOperationException.class, () -> trainStorage.addTrain(train));
    }

    @Test
    void editTrainTest() {
        Train train = new Train(5, Station.BREST_CENTRAL, Station.GOMEL);
        assertThrows(UnsupportedOperationException.class, () -> trainStorage.addTrain(train));
        Train changedTrain = new Train(6, Station.BREST_EAST, Station.GOMEL);
        assertThrows(UnsupportedOperationException.class, () -> trainStorage.editTrain(5, changedTrain));
    }

    @Test
    void deleteTrainTest() {
        Train train = new Train(5, Station.BREST_CENTRAL, Station.GOMEL);
        assertThrows(UnsupportedOperationException.class, () -> trainStorage.addTrain(train));
        assertThrows(UnsupportedOperationException.class, () -> trainStorage.deleteTrain(5));
    }

    @Test
    void getTrainTest() {
        Train train = new Train(5, Station.BREST_CENTRAL, Station.GOMEL);
        assertThrows(UnsupportedOperationException.class, () -> trainStorage.addTrain(train));
        assertThrows(UnsupportedOperationException.class, () -> trainStorage.getTrain(5));

    }

    @Test
    void getTrainsCountTest() {
        Train train_1 = new Train(5, Station.BREST_CENTRAL, Station.GOMEL);
        Train train_2 = new Train(6, Station.BREST_CENTRAL, Station.GOMEL);
        assertThrows(UnsupportedOperationException.class, () -> trainStorage.addTrain(train_1));
        assertThrows(UnsupportedOperationException.class, () -> trainStorage.addTrain(train_2));
        assertThrows(UnsupportedOperationException.class, () -> trainStorage.getTrainsCount());
    }
}
