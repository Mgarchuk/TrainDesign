package by.student.trainDesign.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarriageNode {
    private Carriage value;
    private CarriageNode next, previous;

    private static final Logger logger = LoggerFactory.getLogger(Carriage.class.getName());


    public CarriageNode(Carriage value, CarriageNode next, CarriageNode previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;

        logger.info("Carriage node created");
    }

    public CarriageNode(Carriage value) {
        this.value = value;
    }

    public CarriageNode() {
    }

    public CarriageNode getNext() {
        return next;
    }

    public CarriageNode getPrevious() {
        return previous;
    }

    public void setNext(CarriageNode next) {
        this.next = next;
    }

    public void setPrevious(CarriageNode previous) {
        this.previous = previous;
    }

    public Carriage getValue() {
        return value;
    }

    public void setValue(Carriage value) {
        this.value = value;
    }
}
