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

    public PassengerCarriage(int number, double weight, Date dateOfManufacture, double brakingEfficiency, double trackWidth, int numberOfAxles, int numberOfSeats, TypeOfPassengerCarriage typeOfPassengerCarriage) {
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
        passengers.add(user);
    }

    public List<User> getPassengers() {
        return passengers;
    }
}
