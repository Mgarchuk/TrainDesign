package by.student.trainDesign.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class Locomotive extends Carriage {

    private static final Logger logger = LoggerFactory.getLogger(Locomotive.class.getName());

    private User driver;

    public Locomotive(int number, double weight, Date dateOfManufacture, double brakingEfficiency, double trackWidth,
                      int numberOfAxles, User driver) {
        super(number, weight, dateOfManufacture, brakingEfficiency, trackWidth, numberOfAxles);
        if (driver.getAge().intValue() < 18 || !driver.isTrainDrivenLicense()) {
            throw new IllegalArgumentException("The driver's age must be over 18 years old and he should has license");
        }
        this.driver = driver;

        logger.info("Locomotive created");
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        if (driver.getAge().intValue() < 18 || !driver.isTrainDrivenLicense()) {
            throw new IllegalArgumentException();
        }
        this.driver = driver;

        logger.info("Driver set");
    }
}
