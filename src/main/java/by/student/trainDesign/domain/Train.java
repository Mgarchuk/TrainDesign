package by.student.trainDesign.domain;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Train {

    private static final Logger logger = LoggerFactory.getLogger(Train.class.getName());

    private final int number;
    private CarriageNode root, end;
    private int size = 0;
    private final Station departureStation;
    private final Station arrivalStation;

    public Train(int number, Station departureStation, Station arrivalStation) {
        this.number = number;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;

        logger.info("Train created");
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public int getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        size = 0;
        root = end = null;
    }

    public void addCarriageToEnd(Carriage carriage) {
        size++;
        CarriageNode newNode = new CarriageNode(carriage, null, end);
        if (end == null) {
            root = newNode;
        } else {
            end.setNext(newNode);
        }
        end = newNode;

        logger.info("Carriage added to end");
    }

    public void addCarriageToBegin(Carriage carriage) {
        size++;
        CarriageNode newNode = new CarriageNode(carriage, root, null);
        if (root == null) {
            end = newNode;
        } else {
            root.setPrevious(newNode);
        }

        root = newNode;

        logger.info("Carriage added to start");
    }

    public Carriage getCarriageAt(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Position is out of range");
        }

        CarriageNode next = getNodeAt(position);

        return next.getValue();
    }

    public void removeLastCarriage() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Train is empty"); // тут мб другой эксепшн
        }

        size--;
        end = end.getPrevious();

        if (end != null) {
            end.setNext(null);
        } else {
            root = null;
        }

        logger.info("Last carriage removed");
    }

    public void removeFirstCarriage() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Train is empty");
        }

        size--;
        root = root.getNext();
        if (root != null) {
            root.setPrevious(null);
        } else {
            end = null;
        }

        logger.info("First carriage removed");
    }

    public void addCarriageAt(Carriage carriage, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Position is out of range");
        }

        if (position == 0) {
            addCarriageToBegin(carriage);
        } else if (position == size) {
            addCarriageToEnd(carriage);
        } else {
            size++;
            CarriageNode next = getNodeAt(position);

            CarriageNode newNode = new CarriageNode(carriage, next, next.getPrevious());
            next.getPrevious().setNext(newNode);
            next.setPrevious(newNode);
        }
        logger.info("Carriage added to position: {}", position);
    }

    public void removeCarriageAt(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Position is out of range");
        }

        if (position == 0) {
            removeFirstCarriage();
        } else if (position == size - 1) {
            removeLastCarriage();
        } else {
            size--;
            CarriageNode removingNode = getNodeAt(position);
            removingNode.getPrevious().setNext(removingNode.getNext());
            removingNode.getNext().setPrevious(removingNode.getPrevious());
        }

        logger.info("Carriage removed from position: {}", position);
    }

    private CarriageNode getNodeAt(int position) {
        CarriageNode next = root;
        for (int i = 0; i < position; ++i) {
            next = next.getNext();
        }
        return next;
    }
}
