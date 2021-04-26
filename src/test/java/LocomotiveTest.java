import by.student.trainDesign.domain.Age;
import by.student.trainDesign.domain.Locomotive;
import by.student.trainDesign.domain.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LocomotiveTest {

    private Locomotive getRandomLocomotive(int number) {
        return new Locomotive(number, 3000, new Date(1000), 0.8, 2.8, 20,
                new User("1", "Alexander", "Kondak", Age.of(35), true));
    }

    @Test
    public void createLocomotiveTest() {
        ArrayList<Locomotive> locomotivesList = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            locomotivesList.add(getRandomLocomotive(i));
            assertEquals(locomotivesList.get(i).getNumber(), i);
        }

        assertThrows(IllegalArgumentException.class, () -> new Locomotive(10, 3010, new Date(5000), 0.5, 2.8,
                10, new User("2", "Nikita", "Garchuk", Age.of(60), false)));
        assertThrows(IllegalArgumentException.class, () -> new Locomotive(10, 3010, new Date(5000), 0.5, 2.8,
                10, new User("3", "Nikita", "Garchuk", Age.of(17), true)));

        Locomotive locomotive = new Locomotive(10, 3010, new Date(5000), 0.5, 2.8,
                10, new User("4", "Nikita", "Garchuk", Age.of(60), true));

        assertEquals(locomotive.getNumber(), 10);
        assertEquals(locomotive.getWeight(), 3010);
        assertEquals(locomotive.getDateOfManufacture(), new Date(5000));
        assertEquals(locomotive.getBrakingEfficiency(), 0.5);
        assertEquals(locomotive.getTrackWidth(), 2.8);
        assertEquals(locomotive.getNumberOfAxles(), 10);
        assertEquals(locomotive.getDriver().getId(), "4");
        assertEquals(locomotive.getDriver().getFirstName(), "Nikita");
        assertEquals(locomotive.getDriver().getLastName(), "Garchuk");
        assertEquals(locomotive.getDriver().getAge().intValue(), 60);
        assertTrue(locomotive.getDriver().isTrainDrivenLicense());

        locomotive.setDriver(new User("12", "Katya", "Loshko", "Alexandrovna", Age.of(30),
                true));
        locomotive.setBrakingEfficiency(0.6);
        locomotive.setWeight(2900);

        assertEquals(locomotive.getDriver().getId(), "12");
        assertEquals(locomotive.getDriver().getFirstName(), "Katya");
        assertEquals(locomotive.getDriver().getLastName(), "Loshko");
        assertEquals(locomotive.getDriver().getPatronymic(), "Alexandrovna");
        assertEquals(locomotive.getDriver().getAge().intValue(), 30);
        assertTrue(locomotive.getDriver().isTrainDrivenLicense());

        assertThrows(IllegalArgumentException.class, () -> locomotive.getDriver().setAge(Age.of(7)));
    }

}
