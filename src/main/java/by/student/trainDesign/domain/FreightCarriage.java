package by.student.trainDesign.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FreightCarriage extends Carriage {

    private static final Logger logger = LoggerFactory.getLogger(Carriage.class.getName());

    private final double liftingCapacity;
    private final Dimensions holdingCapacity;
    private final List<Cargo> cargos = new ArrayList<>();

    public FreightCarriage(int number, double weight, Date dateOfManufacture, double brakingEfficiency,
                           double trackWidth, int numberOfAxles, double liftingCapacity, Dimensions holdingCapacity) {
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

    public void addCargo(Cargo cargo) {
        cargos.add(cargo);
    }

    public List<Cargo> getCargos() {
        return cargos;
    }
}
