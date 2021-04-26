import by.student.trainDesign.domain.Station;
import by.student.trainDesign.domain.Ticket;
import by.student.trainDesign.storage.TicketStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicketStorageTest {
    private by.student.trainDesign.storage.TicketStorage ticketStorage;

    @BeforeEach
    public void before() {
        ticketStorage = new TicketStorage();
    }

    @Test
    void addTicketTest() {
        Ticket ticket = new Ticket("10", 13, 11, Station.GOMEL_NORTH,
                Station.MOGILEV_1, 15.10, new Date(100), new Date(900));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.addTicket(ticket));
    }

    @Test
    void editTicketTest() {
        Ticket ticket = new Ticket("10", 13, 11, Station.GOMEL_NORTH,
                Station.MOGILEV_1, 15.10, new Date(100), new Date(900));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.addTicket(ticket));
        Ticket changedTicket = new Ticket("11", 13, 11, Station.GOMEL_NORTH,
                Station.MOGILEV_2, 15.10, new Date(100), new Date(900));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.editTicket("10", changedTicket));
    }

    @Test
    void deleteTicketTest() {
        Ticket ticket = new Ticket("10", 13, 11, Station.GOMEL_NORTH,
                Station.MOGILEV_1, 15.10, new Date(100), new Date(900));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.addTicket(ticket));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.deleteTicket("10"));
    }

    @Test
    void getTicketTest() {
        Ticket ticket = new Ticket("10", 13, 11, Station.GOMEL_NORTH,
                Station.MOGILEV_1, 15.10, new Date(100), new Date(900));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.addTicket(ticket));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.getTicket("10"));

    }

    @Test
    void getTicketsCountTest() {
        Ticket ticket_1 = new Ticket("10", 13, 11, Station.GOMEL_NORTH,
                Station.MOGILEV_1, 15.10, new Date(100), new Date(900));
        Ticket ticket_2 = new Ticket("11", 13, 11, Station.GOMEL_NORTH,
                Station.MOGILEV_1, 15.10, new Date(100), new Date(900));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.addTicket(ticket_1));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.addTicket(ticket_2));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.getTicketsCount());
    }

    @Test
    void getTicketsByUserIdTest() {
        Ticket ticket_1 = new Ticket("10", "10", 13, 11, Station.GOMEL_NORTH,
                Station.MOGILEV_1, 15.10, new Date(100), new Date(900));
        Ticket ticket_2 = new Ticket("11", "10", 13, 11, Station.GOMEL_NORTH,
                Station.MOGILEV_1, 15.10, new Date(100), new Date(900));
        Ticket ticket_3 = new Ticket("12", "11", 13, 11, Station.GOMEL_NORTH,
                Station.MOGILEV_1, 15.10, new Date(100), new Date(900));
        Ticket ticket_4 = new Ticket("13", "10", 13, 11, Station.GOMEL_NORTH,
                Station.MOGILEV_1, 15.10, new Date(100), new Date(900));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.addTicket(ticket_1));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.addTicket(ticket_2));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.addTicket(ticket_3));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.addTicket(ticket_4));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.getTicketsByUserId("u1"));
    }

    @Test
    void deleteAllByUserIdTest() {
        Ticket ticket_1 = new Ticket("10", "10", 13, 11, Station.GOMEL_NORTH,
                Station.MOGILEV_1, 15.10, new Date(100), new Date(900));
        Ticket ticket_2 = new Ticket("11", "10", 13, 11, Station.GOMEL_NORTH,
                Station.MOGILEV_1, 15.10, new Date(100), new Date(900));
        Ticket ticket_3 = new Ticket("12", "11", 13, 11, Station.GOMEL_NORTH,
                Station.MOGILEV_1, 15.10, new Date(100), new Date(900));
        Ticket ticket_4 = new Ticket("13", "10", 13, 11, Station.GOMEL_NORTH,
                Station.MOGILEV_1, 15.10, new Date(100), new Date(900));

        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.addTicket(ticket_1));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.addTicket(ticket_2));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.addTicket(ticket_3));
        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.addTicket(ticket_4));

        assertThrows(UnsupportedOperationException.class, () -> ticketStorage.deleteAllTicketsByUserId("10"));
    }
}
