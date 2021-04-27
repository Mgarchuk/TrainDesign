import by.student.trainDesign.domain.Station;
import by.student.trainDesign.domain.Ticket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TicketTest {

    private Ticket getRandomTicket(String number) {
        return new Ticket(number, 12, 12, Station.BREST_CENTRAL, Station.MOGILEV_1,
                23.90, new Date(500), new Date(800));
    }

    @Test
    public void createTicketTest() {
        List<Ticket> ticketsList = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            ticketsList.add(getRandomTicket(String.valueOf(i)));
            assertEquals(ticketsList.get(i).getTicketId(), String.valueOf(i));
        }


        Ticket ticket_1 = new Ticket("10", 13, 11, Station.GOMEL_NORTH,
                Station.MOGILEV_1, 15.10, new Date(100), new Date(900));
        assertEquals(ticket_1.getTicketId(), "10");
        assertEquals(ticket_1.getPassengerCarriageId(), 13);
        assertEquals(ticket_1.getPlaceNumber(), 11);
        assertEquals(ticket_1.getArrivalStation(), Station.MOGILEV_1);
        assertEquals(ticket_1.getDepartureStation(), Station.GOMEL_NORTH);
        assertEquals(ticket_1.getPrice(), 15.10);
        assertEquals(ticket_1.getDepartureDate(), new Date(100));
        assertEquals(ticket_1.getArrivalDate(), new Date(900));
        assertFalse(ticket_1.isBedLinenIncluded());


        Ticket ticket_2 = new Ticket("11", 13, 45, Station.BREST_CENTRAL,
                Station.MINSK_PASSENGER, 14.10, new Date(100), new Date(900), true);
        assertEquals(ticket_2.getTicketId(), "11");
        assertEquals(ticket_2.getPassengerCarriageId(), 13);
        assertEquals(ticket_2.getPlaceNumber(), 45);
        assertEquals(ticket_2.getArrivalStation(), Station.MINSK_PASSENGER);
        assertEquals(ticket_2.getDepartureStation(), Station.BREST_CENTRAL);
        assertEquals(ticket_2.getPrice(), 14.10);
        assertEquals(ticket_2.getDepartureDate(), new Date(100));
        assertEquals(ticket_2.getArrivalDate(), new Date(900));
        assertTrue(ticket_2.isBedLinenIncluded());

        ticket_2.setUserId("12333");
        ticket_2.setPrice(16.90);
        ticket_2.setBedLinenIncluded(false);

        assertEquals(ticket_2.getUserId(), "12333");
        assertEquals(ticket_2.getPrice(), 16.90);
        assertFalse(ticket_2.isBedLinenIncluded());

        Ticket ticket_3 = new Ticket("12", "12", 15, 19, Station.GOMEL_NORTH,
                Station.MOGILEV_1, 11.10, new Date(100), new Date(900));
        assertEquals(ticket_3.getTicketId(), "12");
        assertEquals(ticket_3.getUserId(), "12");
        assertEquals(ticket_3.getPassengerCarriageId(), 15);
        assertEquals(ticket_3.getPlaceNumber(), 19);
        assertEquals(ticket_3.getArrivalStation(), Station.MOGILEV_1);
        assertEquals(ticket_3.getDepartureStation(), Station.GOMEL_NORTH);
        assertEquals(ticket_3.getPrice(), 11.10);
        assertEquals(ticket_3.getDepartureDate(), new Date(100));
        assertEquals(ticket_3.getArrivalDate(), new Date(900));
        assertFalse(ticket_3.isBedLinenIncluded());


        Ticket ticket_4 = new Ticket("13", "13", 14, 25, Station.BREST_EAST,
                Station.MINSK_PASSENGER, 13.0, new Date(100), new Date(900), true);
        assertEquals(ticket_4.getTicketId(), "13");
        assertEquals(ticket_4.getUserId(), "13");
        assertEquals(ticket_4.getPassengerCarriageId(), 14);
        assertEquals(ticket_4.getPlaceNumber(), 25);
        assertEquals(ticket_4.getArrivalStation(), Station.MINSK_PASSENGER);
        assertEquals(ticket_4.getDepartureStation(), Station.BREST_EAST);
        assertEquals(ticket_4.getPrice(), 13.00);
        assertEquals(ticket_4.getDepartureDate(), new Date(100));
        assertEquals(ticket_4.getArrivalDate(), new Date(900));
        assertTrue(ticket_4.isBedLinenIncluded());
    }
}
