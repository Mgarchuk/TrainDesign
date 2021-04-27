package by.student.trainDesign.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class Carriage {

    private static final Logger logger = LoggerFactory.getLogger(Carriage.class.getName());

    private final int number;
    private double weight;
    private final Date dateOfManufacture;
    private double brakingEfficiency;
    private final double trackWidth;
    private final int numberOfAxles;

    public Carriage(int number, double weight, Date dateOfManufacture, double brakingEfficiency, double trackWidth,
                    int numberOfAxles) {
        if (brakingEfficiency > 1 || brakingEfficiency < 0) {
            throw new IllegalArgumentException("braking efficiency cannot matter outside of 0 to 1");
        }
        this.number = number;
        this.weight = weight;
        this.dateOfManufacture = dateOfManufacture;
        this.brakingEfficiency = brakingEfficiency;
        this.trackWidth = trackWidth;
        this.numberOfAxles = numberOfAxles;

        logger.info("Carriage created");
    }

    public int getNumber() {
        return number;
    }

    public double getWeight() {
        return weight;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public double getBrakingEfficiency() {
        return brakingEfficiency;
    }

    public double getTrackWidth() {
        return trackWidth;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBrakingEfficiency(double brakingEfficiency) {
        this.brakingEfficiency = brakingEfficiency;
    }
}
