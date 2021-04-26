package by.student.trainDesign.domain;

import java.util.Date;

public class FreightCarriage extends Carriage {

    private final double liftingCapacity;
    private final Dimensions holdingCapacity;

    public FreightCarriage(int number, double weight, Date dateOfManufacture, double brakingEfficiency, double trackWidth, int numberOfAxles, double liftingCapacity, Dimensions holdingCapacity) {
        super(number, weight, dateOfManufacture, brakingEfficiency, trackWidth, numberOfAxles);
        this.liftingCapacity = liftingCapacity;
        this.holdingCapacity = holdingCapacity;
    }

    public double getLiftingCapacity() {
        return liftingCapacity;
    }

    public Dimensions getHoldingCapacity() {
        return holdingCapacity;
    }

}
