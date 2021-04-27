import by.student.trainDesign.domain.Age;
import by.student.trainDesign.domain.Station;
import by.student.trainDesign.domain.Ticket;
import by.student.trainDesign.domain.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private Ticket getRandomTicket(String ticketId) {
        return new Ticket(ticketId, 12, 11, Station.BREST_CENTRAL, Station.MOGILEV_1,
                12.04, new Date(10), new Date(1000));
    }

    @Test
    public void createUserTest() {
        User user_1 = new User("1", "Marina", "Garchuk", Age.of(20));
        assertEquals(user_1.getId(), "1");
        assertEquals(user_1.getAge().intValue(), 20);
        assertEquals(user_1.getFirstName(), "Marina");
        assertEquals(user_1.getLastName(), "Garchuk");
        assertEquals(user_1.getTickets().size(), 0);
        assertFalse(user_1.isTrainDrivenLicense());

        User user_2 = new User("2", "Katya", "Soroka", "Alexandrovna", Age.of(11));
        assertEquals(user_2.getId(), "2");
        assertEquals(user_2.getAge().intValue(), 11);
        assertEquals(user_2.getFirstName(), "Katya");
        assertEquals(user_2.getLastName(), "Soroka");
        assertEquals(user_2.getPatronymic(), "Alexandrovna");
        assertEquals(user_2.getTickets().size(), 0);
        assertFalse(user_2.isTrainDrivenLicense());

        user_2.setFirstName("Nadya");
        user_2.setLastName("Vorona");
        user_2.setPatronymic("Nikolaevna");

        assertEquals(user_2.getAge().intValue(), 12);
        assertEquals(user_2.getFirstName(), "Nadya");
        assertEquals(user_2.getLastName(), "Vorona");
        assertEquals(user_2.getPatronymic(), "Nikolaevna");

        user_2.addTicket(getRandomTicket("1"));
        assertEquals(user_2.getTickets().size(), 1);
        assertEquals(user_1.getTickets().size(), 0);
        assertEquals(user_2.getTickets().get(0), getRandomTicket("1"));

        User user_3 = new User("3", "Sasha", "Kroha", "Alexandrovich", Age.of(34), true);
        assertEquals(user_3.getId(), "3");
        assertEquals(user_3.getAge().intValue(), 34);
        assertEquals(user_3.getFirstName(), "Sasha");
        assertEquals(user_3.getLastName(), "Kroha");
        assertEquals(user_3.getPatronymic(), "Alexandrovich");
        assertEquals(user_3.getTickets().size(), 0);
        assertTrue(user_3.isTrainDrivenLicense());

        user_3.setTrainDrivenLicense(false);
        assertFalse(user_3.isTrainDrivenLicense());

        ArrayList<Ticket> ticketsList = new ArrayList<>();
        ticketsList.add(getRandomTicket("2"));
        ticketsList.add(getRandomTicket("3"));

        User user_4 = new User("4", "Tolik", "Kirak", "Konstantinovich", Age.of(33),
                false, ticketsList);
        assertEquals(user_4.getId(), "4");
        assertEquals(user_4.getAge().intValue(), 33);
        assertEquals(user_4.getFirstName(), "Tolik");
        assertEquals(user_4.getLastName(), "Kirak");
        assertEquals(user_4.getPatronymic(), "Konstantinovich");
        assertEquals(user_4.getTickets().size(), 2);
        assertEquals(user_4.getTickets().get(0).getTicketId(), "2");
        assertEquals(user_4.getTickets().get(1).getTicketId(), "3");
        assertFalse(user_4.getTickets().get(0).isBedLinenIncluded());

        List<Ticket> newTicketsList = new ArrayList<>();
        newTicketsList.add(getRandomTicket("4"));
        newTicketsList.add(getRandomTicket("5"));

        User user_5 = new User("5", "Tolik", "Foma", "Konstantinovich", Age.of(27), newTicketsList);
        assertEquals(user_5.getId(), "5");
        assertEquals(user_5.getAge().intValue(), 27);
        assertEquals(user_5.getFirstName(), "Tolik");
        assertEquals(user_5.getLastName(), "Foma");
        assertEquals(user_5.getPatronymic(), "Konstantinovich");
        assertEquals(user_5.getTickets().size(), 2);
        assertEquals(user_5.getTickets().get(0).getTicketId(), "4");
        assertEquals(user_5.getTickets().get(1).getTicketId(), "5");
        assertFalse(user_5.getTickets().get(0).isBedLinenIncluded());

        List<Ticket> lastTicketsList = new ArrayList<>();
        lastTicketsList.add(getRandomTicket("6"));

        User user_6 = new User("6", "Masha", "Goga", Age.of(78), lastTicketsList);
        assertEquals(user_6.getId(), "6");
        assertEquals(user_6.getAge().intValue(), 78);
        assertEquals(user_6.getFirstName(), "Masha");
        assertEquals(user_6.getLastName(), "Goga");
        assertEquals(user_6.getTickets().size(), 1);
        assertEquals(user_6.getTickets().get(0).getTicketId(), "6");
    }

    @Test
    public void setAndGetAgeTest() {
        User user_1 = new User("1", "Marina", "Garchuk", Age.of(20));
        assertEquals(user_1.getAge().intValue(), 20);

        user_1.setAge(Age.of(12));
        assertEquals(user_1.getAge().intValue(), 12);

        user_1.setAge(91);
        assertEquals(user_1.getAge().intValue(), 91);

        assertThrows(IllegalArgumentException.class, () -> user_1.setAge(-1));
        assertThrows(IllegalArgumentException.class, () -> user_1.setAge(988));
        assertThrows(IllegalArgumentException.class, () -> user_1.setAge(Age.of(1999)));
        assertThrows(IllegalArgumentException.class, () -> user_1.setAge(Age.of(-344)));
    }

    @Test
    public void addAndGetTicketTest() {
        Ticket firstTicket = new Ticket("10", 7, 14, Station.BREST_CENTRAL,
                Station.MINSK_PASSENGER,10.99, new Date(1000), new Date(10000));
        User user = new User("12", "Masha", "Goga", Age.of(78));
        user.addTicket(firstTicket);
        assertEquals(user.getId(), "12");
        assertEquals(user.getTickets().size(), 1);
        assertEquals(user.getTickets().get(0).getTicketId(), "10");
        assertEquals(user.getTickets().get(0).getPassengerCarriageId(), 7);
        assertEquals(user.getTickets().get(0).getPlaceNumber(), 14);
        assertFalse(user.getTickets().get(0).isBedLinenIncluded());
        assertEquals(user.getTickets().get(0).getPrice(), 10.99);
        assertEquals(user.getTickets().get(0).getDepartureDate(), new Date(1000));
        assertEquals(user.getTickets().get(0).getArrivalDate(), new Date(10000));
        assertEquals(user.getTickets().get(0).getDepartureStation(), Station.BREST_CENTRAL);
        assertEquals(user.getTickets().get(0).getArrivalStation(), Station.MINSK_PASSENGER);

        List<Ticket> ticketsList = new ArrayList<>();
        for (int i = 0; i <= 5; ++i) {
            ticketsList.add(getRandomTicket(String.valueOf(i)));
            assertEquals(ticketsList.size(), i + 1);
            assertEquals(ticketsList.get(i).getTicketId(), String.valueOf(i));
            assertFalse(ticketsList.get(i).isBedLinenIncluded());
        }

        User newUser = new User("112", "Katya", "Norka", Age.of(30));

        List<Ticket> newTicketsList = new ArrayList<>();
        newTicketsList.add(getRandomTicket("15"));

        newUser.setTickets(newTicketsList);

        assertEquals(newUser.getId(), "112");
        assertEquals(newUser.getTickets().size(), 1);
        assertEquals(newUser.getTickets().get(0).getTicketId(), "15");
    }

    @Test
    public void cancelTicketTest() {
        Ticket firstTicket = new Ticket("11", 6, 35, Station.VITEBSK,
                Station.MINSK_PASSENGER,10.99, new Date(1000), new Date(10000));

        Ticket secondTicket = new Ticket("12", 6, 33, Station.VITEBSK,
                Station.MINSK_PASSENGER,10.99, new Date(1000), new Date(10000));

        User user = new User("111", "Masha", "Goncharuck", Age.of(18));
        user.addTicket(firstTicket);
        user.addTicket(secondTicket);

        assertEquals(user.getId(), "111");
        assertEquals(user.getTickets().size(), 2);
        assertEquals(user.getTickets().get(0).getTicketId(), "11");
        assertEquals(user.getTickets().get(1).getTicketId(), "12");
        assertEquals(user.getTickets().get(0).getPassengerCarriageId(), 6);
        assertEquals(user.getTickets().get(1).getPassengerCarriageId(), 6);
        assertEquals(user.getTickets().get(0).getPlaceNumber(), 35);
        assertEquals(user.getTickets().get(1).getPlaceNumber(), 33);
        assertEquals(user.getTickets().get(0).getDepartureStation(), Station.VITEBSK);
        assertEquals(user.getTickets().get(1).getDepartureStation(), Station.VITEBSK);
        assertEquals(user.getTickets().get(0).getArrivalStation(), Station.MINSK_PASSENGER);
        assertEquals(user.getTickets().get(1).getArrivalStation(), Station.MINSK_PASSENGER);
        assertEquals(user.getTickets().get(0).getPrice(), 10.99);
        assertEquals(user.getTickets().get(1).getPrice(), 10.99);
        assertEquals(user.getTickets().get(0).getDepartureDate(), new Date(1000));
        assertEquals(user.getTickets().get(1).getDepartureDate(), new Date(1000));
        assertEquals(user.getTickets().get(0).getArrivalDate(), new Date(10000));
        assertEquals(user.getTickets().get(1).getArrivalDate(), new Date(10000));

        user.cancelTicket("11");
        assertEquals(user.getTickets().size(), 1);
    }
}
