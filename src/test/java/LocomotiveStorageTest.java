import by.student.trainDesign.domain.Address;
import by.student.trainDesign.domain.Age;
import by.student.trainDesign.domain.Locomotive;
import by.student.trainDesign.domain.User;
import by.student.trainDesign.storage.LocomotiveStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocomotiveStorageTest {
    private by.student.trainDesign.storage.LocomotiveStorage locomotiveStorage;

    @BeforeEach
    public void before() {
        locomotiveStorage = new LocomotiveStorage();
    }

    @Test
    void addLocomotiveTest() {
        Locomotive locomotive = new Locomotive(10, 3010, new Date(5000), 0.5, 2.8,
                10, new User("4", "Nikita", "Garchuk", Age.of(60), true));
        assertThrows(UnsupportedOperationException.class, () -> locomotiveStorage.addLocomotive(locomotive));
    }

    @Test
    void editLocomotiveTest() {
        Locomotive locomotive = new Locomotive(10, 3010, new Date(5000), 0.5, 2.8,
                10, new User("4", "Nikita", "Garchuk", Age.of(60), true));
        assertThrows(UnsupportedOperationException.class, () -> locomotiveStorage.addLocomotive(locomotive));
        Locomotive changedLocomotive = new Locomotive(11, 3000, new Date(5000), 0.5, 2.8,
                10, new User("4", "Nikita", "Garchuk", Age.of(60), true));
        assertThrows(UnsupportedOperationException.class, () -> locomotiveStorage.editLocomotive(10, changedLocomotive));
    }

    @Test
    void deleteLocomotiveTest() {
        Locomotive locomotive = new Locomotive(10, 3010, new Date(5000), 0.5, 2.8,
                10, new User("4", "Nikita", "Garchuk", Age.of(60), true));
        assertThrows(UnsupportedOperationException.class, () -> locomotiveStorage.addLocomotive(locomotive));
        assertThrows(UnsupportedOperationException.class, () -> locomotiveStorage.deleteLocomotive(10));
    }

    @Test
    void getLocomotiveTest() {
        Locomotive locomotive = new Locomotive(10, 3010, new Date(5000), 0.5, 2.8,
                10, new User("4", "Nikita", "Garchuk", Age.of(60), true));
        assertThrows(UnsupportedOperationException.class, () -> locomotiveStorage.addLocomotive(locomotive));
        assertThrows(UnsupportedOperationException.class, () -> locomotiveStorage.getLocomotive(10));

    }

    @Test
    void getLocomotivesCountTest() {
        Locomotive locomotive_1 = new Locomotive(10, 3010, new Date(5000), 0.5, 2.8,
                10, new User("4", "Nikita", "Garchuk", Age.of(60), true));
        Locomotive locomotive_2 = new Locomotive(11, 3010, new Date(5000), 0.5, 2.8,
                10, new User("4", "Nikita", "Garchuk", Age.of(60), true));
        assertThrows(UnsupportedOperationException.class, () -> locomotiveStorage.addLocomotive(locomotive_1));
        assertThrows(UnsupportedOperationException.class, () -> locomotiveStorage.addLocomotive(locomotive_2));
        assertThrows(UnsupportedOperationException.class, () -> locomotiveStorage.getLocomotivesCount());
    }
}
