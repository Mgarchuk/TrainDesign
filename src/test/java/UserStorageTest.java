import by.student.trainDesign.domain.Age;
import by.student.trainDesign.domain.User;
import by.student.trainDesign.storage.UserStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserStorageTest {
    private by.student.trainDesign.storage.UserStorage userStorage;

    @BeforeEach
    public void before() {
        userStorage = new UserStorage();
    }

    @Test
    void addUserTest() {
        User user = new User("1", "Marina", "Garchuk", Age.of(20));
        assertThrows(UnsupportedOperationException.class, () -> userStorage.addUser(user));
    }

    @Test
    void editUserTest() {
        User user = new User("1", "Marina", "Garchuk", Age.of(20));
        assertThrows(UnsupportedOperationException.class, () -> userStorage.addUser(user));
        User changedUser = new User("2", "Marina", "Garchuk", Age.of(21));
        assertThrows(UnsupportedOperationException.class, () -> userStorage.editUser("1", changedUser));
    }

    @Test
    void deleteUserTest() {
        User user = new User("1", "Marina", "Garchuk", Age.of(20));
        assertThrows(UnsupportedOperationException.class, () -> userStorage.addUser(user));
        assertThrows(UnsupportedOperationException.class, () -> userStorage.deleteUser("1"));
    }

    @Test
    void getUserTest() {
        User user = new User("1", "Marina", "Garchuk", Age.of(20));
        assertThrows(UnsupportedOperationException.class, () -> userStorage.addUser(user));
        assertThrows(UnsupportedOperationException.class, () -> userStorage.getUser("1"));

    }

    @Test
    void getUsersCountTest() {
        User user_1 = new User("1", "Marina", "Garchuk", Age.of(20));
        User user_2 = new User("2", "Marina", "Garchuk", Age.of(20));
        assertThrows(UnsupportedOperationException.class, () -> userStorage.addUser(user_1));
        assertThrows(UnsupportedOperationException.class, () -> userStorage.addUser(user_2));
        assertThrows(UnsupportedOperationException.class, () -> userStorage.getUsersCount());
    }
}
