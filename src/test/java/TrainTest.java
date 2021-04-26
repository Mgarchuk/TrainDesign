import by.student.trainDesign.domain.Carriage;
import by.student.trainDesign.domain.Station;
import by.student.trainDesign.domain.Train;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrainTest {

    private Carriage getRandomCarriage(int number) {
        return new Carriage(number, 1.0, null, 1.0, 1.0, 1);
    }

    /// тесты для добавления, удаления, и ГЛАВНОЕ ДЛЯ ДОБАВЛЕНИЯ + УДАЛЕНИЯ

    @Test
    public void addingTest() {

        Train train = new Train(5, Station.MINSK_NORTH, Station.GOMEL);

        assertThrows(IndexOutOfBoundsException.class, () -> train.addCarriageAt(getRandomCarriage(1), 1));

        for (int i = 0; i < 3; ++i) {
            train.addCarriageToBegin(getRandomCarriage(i + 1));
            assertEquals(train.getSize(), i + 1);
            assertEquals(train.getCarriageAt(0).getNumber(), i + 1);
        }

        train.addCarriageAt(getRandomCarriage(5), 0);
        assertEquals(train.getCarriageAt(0).getNumber(), 5);

        assertThrows(IndexOutOfBoundsException.class, () -> train.addCarriageAt(getRandomCarriage(6), 5));

        train.addCarriageAt(getRandomCarriage(6), 4);
        assertEquals(train.getCarriageAt(4).getNumber(), 6);
        assertThrows(IndexOutOfBoundsException.class, () -> train.getCarriageAt(5));

        train.addCarriageAt(getRandomCarriage(11), 2);

        assertEquals(train.getDepartureStation(), Station.MINSK_NORTH);
        assertEquals(train.getArrivalStation(), Station.GOMEL);
        assertEquals(train.getSize(), 6);
        assertEquals(train.getCarriageAt(0).getNumber(), 5);
        assertEquals(train.getCarriageAt(1).getNumber(), 3);
        assertEquals(train.getCarriageAt(2).getNumber(), 11);
        assertEquals(train.getCarriageAt(3).getNumber(), 2);
        assertEquals(train.getCarriageAt(4).getNumber(), 1);
        assertEquals(train.getCarriageAt(5).getNumber(), 6);

        train.addCarriageToEnd(getRandomCarriage(88));
        train.addCarriageToEnd(getRandomCarriage(99));

        assertEquals(train.getSize(), 8);
        assertEquals(train.getCarriageAt(0).getNumber(), 5);
        assertEquals(train.getCarriageAt(1).getNumber(), 3);
        assertEquals(train.getCarriageAt(2).getNumber(), 11);
        assertEquals(train.getCarriageAt(3).getNumber(), 2);
        assertEquals(train.getCarriageAt(4).getNumber(), 1);
        assertEquals(train.getCarriageAt(5).getNumber(), 6);
        assertEquals(train.getCarriageAt(6).getNumber(), 88);
        assertEquals(train.getCarriageAt(7).getNumber(), 99);

    }

    @Test
    public void addingAndRemovingTest() {

        Train train = new Train(5, Station.BREST_CENTRAL, Station.GOMEL);

        train.addCarriageToBegin(getRandomCarriage(1));
        train.removeFirstCarriage();

        assertEquals(train.getDepartureStation(), Station.BREST_CENTRAL);
        assertEquals(train.getArrivalStation(), Station.GOMEL);
        assertEquals(train.getSize(), 0);

        train.addCarriageToBegin(getRandomCarriage(1));
        train.removeLastCarriage();

        assertEquals(train.getSize(), 0);
        assertThrows(IndexOutOfBoundsException.class, () -> train.getCarriageAt(0));


        assertThrows(IndexOutOfBoundsException.class, () -> train.removeFirstCarriage());
        assertThrows(IndexOutOfBoundsException.class, () -> train.removeLastCarriage());
        assertThrows(IndexOutOfBoundsException.class, () -> train.removeCarriageAt(0));
        assertThrows(IndexOutOfBoundsException.class, () -> train.removeCarriageAt(3));
        assertThrows(IndexOutOfBoundsException.class, () -> train.removeCarriageAt(-1));

        for (int i = 0; i < 10; ++i) {
            train.addCarriageToEnd(getRandomCarriage(i + 1));
            assertEquals(train.getSize(), i + 1);
            assertEquals(train.getCarriageAt(i).getNumber(), i + 1);
        }

        assertThrows(IndexOutOfBoundsException.class, () -> train.removeCarriageAt(train.getSize()));

        train.removeCarriageAt(1);
        assertEquals(train.getCarriageAt(0).getNumber(), 1);
        assertEquals(train.getCarriageAt(1).getNumber(), 3);
        assertEquals(train.getSize(), 9);

        train.removeCarriageAt(0);
        assertEquals(train.getCarriageAt(0).getNumber(), 3);
        assertEquals(train.getCarriageAt(1).getNumber(), 4);
        assertEquals(train.getSize(), 8);

        train.removeCarriageAt(7);
        assertThrows(IndexOutOfBoundsException.class, () -> train.getCarriageAt(7));

        assertEquals(train.getCarriageAt(0).getNumber(), 3);
        assertEquals(train.getCarriageAt(1).getNumber(), 4);
        assertEquals(train.getCarriageAt(6).getNumber(), 9);
        assertEquals(train.getCarriageAt(5).getNumber(), 8);
        assertEquals(train.getSize(), 7);

        train.removeLastCarriage();
        assertThrows(IndexOutOfBoundsException.class, () -> train.getCarriageAt(6));

        assertEquals(train.getCarriageAt(0).getNumber(), 3);
        assertEquals(train.getCarriageAt(1).getNumber(), 4);
        assertEquals(train.getCarriageAt(5).getNumber(), 8);
        assertEquals(train.getCarriageAt(4).getNumber(), 7);
        assertEquals(train.getSize(), 6);

        train.removeFirstCarriage();
        assertThrows(IndexOutOfBoundsException.class, () -> train.getCarriageAt(5));

        assertEquals(train.getCarriageAt(0).getNumber(), 4);
        assertEquals(train.getCarriageAt(1).getNumber(), 5);
        assertEquals(train.getCarriageAt(4).getNumber(), 8);
        assertEquals(train.getCarriageAt(3).getNumber(), 7);
        assertEquals(train.getCarriageAt(2).getNumber(), 6);
        assertEquals(train.getSize(), 5);


        train.addCarriageAt(getRandomCarriage(55), 2);

        assertEquals(train.getCarriageAt(0).getNumber(), 4);
        assertEquals(train.getCarriageAt(1).getNumber(), 5);
        assertEquals(train.getCarriageAt(2).getNumber(), 55);
        assertEquals(train.getCarriageAt(3).getNumber(), 6);
        assertEquals(train.getCarriageAt(4).getNumber(), 7);
        assertEquals(train.getCarriageAt(5).getNumber(), 8);
        assertEquals(train.getSize(), 6);

        train.clear();
        assertEquals(train.getSize(), 0);

        train.addCarriageToBegin(getRandomCarriage(1));
        train.addCarriageToEnd(getRandomCarriage(2));
        assertEquals(train.getSize(), 2);
        assertEquals(train.getCarriageAt(0).getNumber(), 1);
        assertEquals(train.getCarriageAt(1).getNumber(), 2);

    }
}
