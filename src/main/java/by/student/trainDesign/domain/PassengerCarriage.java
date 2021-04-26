package by.student.trainDesign.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class PassengerCarriage extends Carriage {

    private final int numberOfSeats;
    private final TypeOfPassengerCarriage typeOfPassengerCarriage;

    private static final Logger logger = LoggerFactory.getLogger(PassengerCarriage.class.getName());

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
}
