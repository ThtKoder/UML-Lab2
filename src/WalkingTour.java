public class WalkingTour {
    private int distance = 0;

    public WalkingTour(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "\nWalkingTour: " +
                "distance=" + distance +
                '}';
    }
}
