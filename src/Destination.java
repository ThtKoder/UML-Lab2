import java.util.ArrayList;

public class Destination {
    private String name;
    private ArrayList<Activity> activities = new ArrayList<>();

    public Destination(String name) {
        this.name = name;
    }

    public Destination(String name, ArrayList<Activity> activities){
        this.name = name;
        this.activities = activities;
    }

    //getters
    public void addActivities(Activity activity) {
        activities.add(activity);
    }
    public void removeActivities(Activity activity) {
        activities.remove(activity);
    }
    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    //getters
    public ArrayList<Activity> getActivities() {
        return activities;
    }

    @Override
    public String toString() {
        return "Destination: " +
                "name = " + name +
                "activities = " + activities;
    }

    public String toStringWithoutActivities(){
        return "Destination: " +
                "name = " + name;
    }
}
