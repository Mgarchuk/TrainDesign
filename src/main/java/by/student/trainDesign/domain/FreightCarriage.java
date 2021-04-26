package by.student.trainDesign.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class FreightCarriage extends Carriage {

    private final double liftingCapacity;
    private final Dimensions holdingCapacity;

    private static final Logger logger = LoggerFactory.getLogger(Carriage.class.getName());

    public FreightCarriage(int number, double weight, Date dateOfManufacture, double brakingEfficiency, double trackWidth, int numberOfAxles, double liftingCapacity, Dimensions holdingCapacity) {
        super(number, weight, dateOfManufacture, brakingEfficiency, trackWidth, numberOfAxles);
        this.liftingCapacity = liftingCapacity;
        this.holdingCapacity = holdingCapacity;

        logger.info("Freight Carriage created");
    }

    public double getLiftingCapacity() {
        return liftingCapacity;
    }

    public Dimensions getHoldingCapacity() {
        return holdingCapacity;
    }

}
