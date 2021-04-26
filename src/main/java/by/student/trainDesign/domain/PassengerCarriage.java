package by.student.trainDesign.domain;

import java.util.Date;

public class PassengerCarriage extends Carriage {

    private final int numberOfSeats;
    private final TypeOfPassengerCarriage typeOfPassengerCarriage;

    public PassengerCarriage(int number, double weight, Date dateOfManufacture, double brakingEfficiency, double trackWidth, int numberOfAxles, int numberOfSeats, TypeOfPassengerCarriage typeOfPassengerCarriage) {
        super(number, weight, dateOfManufacture, brakingEfficiency, trackWidth, numberOfAxles);
        this.numberOfSeats = numberOfSeats;
        this.typeOfPassengerCarriage = typeOfPassengerCarriage;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public TypeOfPassengerCarriage getTypeOfPassengerCarriage() {
        return typeOfPassengerCarriage;
    }
}
