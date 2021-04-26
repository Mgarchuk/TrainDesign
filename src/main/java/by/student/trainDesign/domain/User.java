package by.student.trainDesign.domain;

import by.student.trainDesign.storage.CargoStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class User {
    private final String id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Age age;
    private boolean isTrainDrivenLicense;
    private ArrayList<Ticket> tickets = new ArrayList<>();

    private static final Logger logger = LoggerFactory.getLogger(User.class.getName());

    public User(String id, String firstName, String lastName, String patronymic, Age age, boolean isTrainDrivenLicense,
                ArrayList<Ticket> tickets) {
        this(id, firstName, lastName, age, isTrainDrivenLicense);
        this.patronymic = patronymic;
        this.tickets = tickets;
    }

    public User(String id, String firstName, String lastName, String patronymic, Age age, boolean isTrainDrivenLicense) {
        this(id, firstName, lastName, age, isTrainDrivenLicense);
        this.patronymic = patronymic;
    }

    public User(String id, String firstName, String lastName, Age age, boolean isTrainDrivenLicense) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isTrainDrivenLicense = isTrainDrivenLicense;
    }

    public User(String id, String firstName, String lastName, String patronymic, Age age) {
        this(id, firstName, lastName, age, false);
        this.patronymic = patronymic;
    }

    public User(String id, String firstName, String lastName, String patronymic, Age age, ArrayList<Ticket> tickets) {
        this(id, firstName, lastName, patronymic, age);
        this.tickets = tickets;
    }

    public User(String id, String firstName, String lastName, Age age) {
        this(id, firstName, lastName, age, false);
    }

    public User(String id, String firstName, String lastName, Age age, ArrayList<Ticket> tickets) {
        this(id, firstName, lastName, age);
        this.tickets = tickets;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Age getAge() {
        return age;
    }

    public boolean isTrainDrivenLicense() {
        return isTrainDrivenLicense;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAge(Age age) {
        if (this.isTrainDrivenLicense && age.intValue() < 18 || age.intValue() < 0 || age.intValue() > 125) {
            throw new IllegalArgumentException();
        }
        this.age = age;
    }

    public void setAge(int age) {
        if (this.isTrainDrivenLicense && age < 18 || age < 0 || age > 125) {
            throw new IllegalArgumentException();
        }
        this.age = Age.of(age);
        logger.info("Age set");
    }

    public void setTrainDrivenLicense(boolean trainDrivenLicense) {
        this.isTrainDrivenLicense = trainDrivenLicense;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public void addTicket(Ticket ticket, String userId) {
        ticket.setUserId(userId);
        this.tickets.add(ticket);
        logger.info("Ticket with userId: {} was added", userId);
    }

    public void cancelTicket(String ticketId) {
        for (int i = 0; i < tickets.size(); ++i) {
            if (tickets.get(i).getTicketId().equals(ticketId)) {
                tickets.remove(i);
                break;
            }
        }
        logger.info("Ticket with id: {} was canceled", ticketId);
    }

}
