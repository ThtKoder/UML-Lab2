import java.util.ArrayList;

public class Itinerary {
    private ArrayList<Destination> destinations = new ArrayList<>();

    //setters
    public void setDestinations(ArrayList<Destination> destinations) {
        this.destinations = destinations;
    }
    public void addDestination(Destination destination) {
        destinations.add(destination);
    }
    public void removeDestination(Destination destination) {
        destinations.remove(destination);
    }

    //getters
    ArrayList<Destination> getDestinations() {
        return destinations;
    }

    @Override
    public String toString() {
        return "\nItinerary {" +
                "destinations=" + destinations +
                '}';
    }

    public String toStringWithoutActivities(){
        String toReturn = "Itinerary {";
        for(Destination destination : destinations){
            toReturn += "\n" + destination.toStringWithoutActivities();
        }
        return toReturn + "}";
    }
}
