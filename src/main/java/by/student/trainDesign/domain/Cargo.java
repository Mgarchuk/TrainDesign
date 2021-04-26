package by.student.trainDesign.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cargo {
    private final int number;
    private final double weight;
    private final Dimensions dimensions;
    private Station dispatchStation;
    private Station arrivalStation;
    private Address destination;
    private final TypeOfCargo typeOfCargo;

    private static final Logger logger = LoggerFactory.getLogger(Cargo.class.getName());

    public Cargo(int number, double weight, TypeOfCargo typeOfCargo, Dimensions dimensions, Station dispatchStation, Station arrivalStation, Address destination) {
        this.number = number;
        this.weight = weight;
        this.typeOfCargo = typeOfCargo;
        this.dimensions = dimensions;
        this.dispatchStation = dispatchStation;
        this.arrivalStation = arrivalStation;
        this.destination = destination;

        logger.info("Carriage node created");
    }

    public int getNumber() {
        return number;
    }

    public double getWeight() {
        return weight;
    }

    public TypeOfCargo getTypeOfCargo() {
        return typeOfCargo;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Station getDispatchStation() {
        return dispatchStation;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDispatchStation(Station dispatchStation) {
        this.dispatchStation = dispatchStation;
    }

    public void setArrivalStation(Station arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }
}
