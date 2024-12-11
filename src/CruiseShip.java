import java.lang.reflect.Array;
import java.util.ArrayList;

public class CruiseShip {
    private String name = "";
    private int capacity = 0;
    private Itinerary itinerary = new Itinerary();
    private ArrayList<Passenger> passengers = new ArrayList<>();

    public CruiseShip(String name, int capacity, Itinerary itinerary) {
        this.name = name;
        this.capacity = capacity;
        this.itinerary = itinerary;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void addPassenger(Passenger passenger) {
        if(!passengers.contains(passenger)&&1+passengers.size()<capacity) {
            passengers.add(passenger);
        }
        else{
            System.out.println("The cruiseShip is already at max occupancy");
        }
    }

    public void removePassenger(Passenger passenger) {
        if(passengers.contains(passenger)) {
            passengers.remove(passenger);
        }
        else{
            System.out.println("\nThe passenger is not on this ship");
        }
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public String toStringWithoutPassenger() {
        return "\nCruiseShip: " +
                "name = " + name + '\'' +
                ", capacity = " + capacity +
                ", itinerary = " + itinerary.toStringWithoutActivities();
    }

    public String toString() {
        return "\nCruiseShip: " +
                "name='" + name + '\'' +
                ", capacity = " + capacity +
                ", itinerary = " + itinerary +
                ", passengers = " + passengers;
    }
}
