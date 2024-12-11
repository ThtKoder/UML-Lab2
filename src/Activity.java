import java.util.ArrayList;

public class Activity {
    private String name = "";
    private int price = 0;
    private ArrayList<Passenger> signups = new ArrayList<>();
    private int capacity = 0;
    private WalkingTour walkingTour = null;
    private TheatreShow theatreShow = null;
    private Destination location;

    Activity(String name, int price, int capacity, Destination location, WalkingTour walkingTour) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.location = location;
        this.walkingTour = walkingTour;
    }

    Activity(String name, int price, int capacity, Destination location, TheatreShow theatreShow) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.location = location;
        this.theatreShow = theatreShow;
    }

    public String getName() {
        return name;
    }
    public String getActivityType() {
        if(walkingTour != null) {
            return walkingTour.toString();
        }else if(theatreShow != null) {
            return theatreShow.toString();
        }
        return null;
    }
    public int getPrice() {
        return price;
    }

    public ArrayList<Passenger> getSignups() {
        return signups;
    }

    public boolean isFull() {
        return signups.size() >= capacity;
    }

    public void addPassenger(Passenger passenger) {
        int discountPercentage = (int) (100-(100*passenger.tier.getDiscount()));

        if (passenger.getCruiseShip().getItinerary().getDestinations().contains(location)) {
            if (passenger.balance > price * passenger.tier.getDiscount()) {
                if (!isFull() && !signups.contains(passenger)) {
                    signups.add(passenger);
                    passenger.balance -= (int) (price * passenger.tier.getDiscount());
                    System.out.println("\nDiscount received: " + discountPercentage + "%" + ", Final price of activity: " + (int) (price * passenger.tier.getDiscount()));
                    System.out.println(passenger.getName() + " has been added to: " + this.name + "\nCurrent balance is now: " + passenger.balance);
                } else {
                    System.out.println("\nThe signups are already full");
                }
            } else {
                System.out.println("\nBalance is too low!" + "\nCurrent balance is now: " + passenger.balance + "\nPrice of activity: " + (int) (price * passenger.tier.getDiscount()));
            }
        }
    }

    public void removePassenger(Passenger passenger) {
        if(signups.contains(passenger)) {
            signups.remove(passenger);
            System.out.println("Passenger has been removed, however, no refund has been given as per company policy.");
        }
        else{
            System.out.println("\nThe passenger is not partaking in this activity");
        }
    }

    @Override
    public String toString() {
        if(walkingTour != null) {
            return
            "\nActivity: " +
                    "name = " + name + '\'' +
                    ", price = " + price +
                    ", signups = " + signups +
                    ", capacity = " + capacity +
                    ", activityType = " + walkingTour +
                    ", location = " + location.toStringWithoutActivities() +
                    ", distance = " + walkingTour.getDistance() + '\'';
        } if(theatreShow != null) {
            return
            "\nActivity: " +
                    "name = " + name + '\'' +
                    ", price = " + price +
                    ", signups = " + signups +
                    ", capacity = " + capacity +
                    ", activityType = " + theatreShow +
                    ", location = " + location.toStringWithoutActivities()  +
                    "performers = " + theatreShow.getStars();
        }
        return null;
    }
}
