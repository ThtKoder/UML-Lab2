import java.util.ArrayList;

public class TheatreShow {
    private ArrayList<Star> stars;

    public TheatreShow(ArrayList<Star> stars) {
        this.stars = stars;
    }


    public ArrayList<Star> getStars() {
        return stars;
    }

    @Override
    public String toString() {
        return "\nTheatreShow{" +
                "stars=" + stars +
                "}";
    }
}
