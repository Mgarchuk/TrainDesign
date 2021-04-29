package by.student.trainDesign.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PassengerCarriage extends Carriage {

    private static final Logger logger = LoggerFactory.getLogger(PassengerCarriage.class.getName());

    private final int numberOfSeats;
    private final TypeOfPassengerCarriage typeOfPassengerCarriage;
    private final List<User> passengers = new ArrayList<>();

    public PassengerCarriage(int number, double weight, Date dateOfManufacture, double brakingEfficiency,
                             double trackWidth, int numberOfAxles, int numberOfSeats, TypeOfPassengerCarriage typeOfPassengerCarriage) {
        super(number, weight, dateOfManufacture, brakingEfficiency, trackWidth, numberOfAxles);
        this.numberOfSeats = numberOfSeats;
        this.typeOfPassengerCarriage = typeOfPassengerCarriage;

        logger.info("Passenger carriage created");
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public TypeOfPassengerCarriage getTypeOfPassengerCarriage() {
        return typeOfPassengerCarriage;
    }

    public void addPassenger(User user) {
        if (numberOfSeats == passengers.size()) {
            throw new IllegalArgumentException("No free places in carriage");
        }
        passengers.add(user);
    }

    public void deletePassenger(String userId) {
        for (int i = 0; i < passengers.size(); ++i) {
            if (userId.equals(passengers.get(i).getId())) {
                passengers.remove(passengers.get(i));
                break;
            }
        }
    }

    public void deletePassenger(User user) {
        passengers.remove(user);
    }

    public void clearCarriage() {
        passengers.clear();
    }

    public List<User> getPassengers() {
        return passengers;
    }
}
