package by.student.trainDesign.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FreightCarriage extends Carriage {

    private static final Logger logger = LoggerFactory.getLogger(Carriage.class.getName());

    private final double liftingCapacity;
    private double currentLoad = 0;
    private final Dimensions holdingCapacity;
    private double currentCarriageOccupancy = 0;
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

    public double getCurrentLoad() {
        return currentLoad;
    }

    public Dimensions getHoldingCapacity() {
        return holdingCapacity;
    }

    public double getCurrentCarriageOccupancy() {
        return currentCarriageOccupancy;
    }

    public void addCargo(Cargo cargo) {
        if (currentLoad + cargo.getWeight() > liftingCapacity || currentCarriageOccupancy +
                cargo.getDimensions().getVolume() > holdingCapacity.getVolume()) {
            throw new IllegalArgumentException("load capacity exceeded");
        }
        if (cargo.getDimensions().getHeight() > holdingCapacity.getHeight() || cargo.getDimensions().getLength() >
                holdingCapacity.getLength() || cargo.getDimensions().getWidth() > holdingCapacity.getWidth()) {
            throw new IllegalArgumentException("load capacity exceeded");
        }
        currentLoad += cargo.getWeight();
        currentCarriageOccupancy += cargo.getDimensions().getVolume();
        cargos.add(cargo);

        logger.info("Cargo added");
    }

    public void deleteCargo(int cargoId) {
        for (int i = 0; i < cargos.size(); ++i) {
            if (cargoId == cargos.get(i).getNumber()) {
                cargos.remove(i);
                logger.info("Cargo deleted");
                break;
            }
        }
    }

    public void deleteCargo(Cargo cargo) {
        if(cargos.contains(cargo)){
            cargos.remove(cargo);
            logger.info("Cargo deleted");
        }
    }

    public void clearCarriage() {
        if(cargos.size() != 0){
            cargos.clear();
            logger.info("Cargo deleted");
        }
    }

    public List<Cargo> getCargos() {
        return cargos;
    }
}
