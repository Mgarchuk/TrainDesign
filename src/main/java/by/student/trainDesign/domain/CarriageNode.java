package by.student.trainDesign.domain;

public class CarriageNode {
    private Carriage value;
    private CarriageNode next, previous;

    public CarriageNode(Carriage value, CarriageNode next, CarriageNode previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
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
