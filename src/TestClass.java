import org.junit.jupiter.api.Test;

import javax.management.ConstructorParameters;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

class TestClass {

    public String boldOn = "\u001B[1m";
    public String boldOff = "\u001B[0m";

    @Test
    void WholeTest1() {
        //establishes destinations, activities + subclasses, then goes into creating a coherent itinerary
        //followed by the cruise ship itself, and then lastly, passengers

        Destination Lisbon = new Destination("Lisbon");
        Destination Vigo = new Destination("Vigo");
        Destination Bordeaux = new Destination("Bordeaux");
        Destination Nantes = new Destination("Nantes");
        //creates destinations

        Star Jamie = new Star("Jamie Schorr", "Hamilton");
        Star Holden = new Star("Holden Springer", "Aaron Burr");
        Star Lin = new Star("Lin Manuel Miranda", "Theodosia Burr");
        //creates stars for the Hamilton Play

        ArrayList<Star> HamiltonStars = new ArrayList<>();
        HamiltonStars.add(Jamie);
        HamiltonStars.add(Holden);
        HamiltonStars.add(Lin);
        //adds the stars into one arrayList

        TheatreShow HamiltonReprise2024 = new TheatreShow(new ArrayList<Star>(HamiltonStars));
        Activity LisbonHamiltonShow = new Activity("Hamilton Show", 8,3, Lisbon, HamiltonReprise2024);
        Lisbon.addActivities(LisbonHamiltonShow);
        //creates the Lisbon Hamilton Show (using the before made stars + arrayList)

        WalkingTour Vigo5KHIKE = new WalkingTour(5);
        Activity VigoWalkingTour = new Activity("Vigo 5K Hike", 5, 2, Vigo, Vigo5KHIKE);
        Vigo.addActivities(VigoWalkingTour);
        //creates the Vigo Walking Tour

        Star William = new Star("William James", "Glinda");
        Star James = new Star("James Yeoh", "Elphaba");
        Star Ethan = new Star("Ethan Goldblum", "Fiyero Tigelaar");
        //creates stars for the Wicked Musical

        ArrayList<Star> WickedStars = new ArrayList<>();
        WickedStars.add(William);
        WickedStars.add(James);
        WickedStars.add(Ethan);
        //adds the stars into one arrayList

        TheatreShow Wicked = new TheatreShow(WickedStars);
        Activity BordeauxWickedMusical = new Activity("Wicked Musical Bordeaux", 10, 5, Bordeaux, Wicked);
        Bordeaux.addActivities(BordeauxWickedMusical);
        //creates the Bordeaux Musical (using the before made stars + arrayList)

        WalkingTour NantesHike10K = new WalkingTour(10);
        Activity Nantes10K = new Activity("Nantes10K", 2, 3, Nantes, NantesHike10K);
        Nantes.addActivities(Nantes10K);
        //creates the Nantes 10K Walking Tour

        Itinerary atlanticCoast = new Itinerary();
        atlanticCoast.addDestination(Lisbon);
        atlanticCoast.addDestination(Vigo);
        atlanticCoast.addDestination(Bordeaux);
        atlanticCoast.addDestination(Nantes);
        //adds all the destinations made to the atlanticCoast itinerary

        CruiseShip theLostCause = new CruiseShip("The Lost Cause", 100,atlanticCoast);
        //creates cruiseShip, using atlanticCoast, and with a

        //discounts are done the chinese way, meaning that '80' means you pay 80% of the original price
        Tier Standard = new Tier("Standard", 1);
        Tier Senior = new Tier("Senior", .9);
        Tier Premium = new Tier("Premium", .8);

        Passenger hughSmith = new Passenger("Hugh Smith", 1, Premium, theLostCause);
        Passenger jamesJackson = new Passenger("James Jackson", 2, Standard, theLostCause);
        Passenger sheilaWilliams = new Passenger("Sheila Williams", 3, Senior, theLostCause);
        Passenger jacquelineJames = new Passenger("Jacqueline James", 4, Premium, theLostCause);
        //creates passengers

        hughSmith.addBalance(14);
        jamesJackson.addBalance(17);
        sheilaWilliams.addBalance(19);
        jacquelineJames.addBalance(7);
        //gives passengers random credit values

        theLostCause.addPassenger(hughSmith);
        theLostCause.addPassenger(jamesJackson);
        theLostCause.addPassenger(sheilaWilliams);
        theLostCause.addPassenger(jacquelineJames);
        if(theLostCause.getPassengers().contains(hughSmith) &&
                theLostCause.getPassengers().contains(jamesJackson) &&
                theLostCause.getPassengers().contains(sheilaWilliams) &&
                theLostCause.getPassengers().contains(jacquelineJames)){
            System.out.println("All passengers accounted for on: The Lost Cause");
        }


        //adds passengers to the cruiseShip

        /*
        everything above sets up the cruiseship, all passengers, activities and destinations
        all 'official tests' below
         */

        //Hugh wants to go to the Lisbon show and Nantes Hike
        System.out.println(boldOn + "\nAdding Hugh to activities" + boldOff);
        LisbonHamiltonShow.addPassenger(hughSmith);
        Nantes10K.addPassenger(hughSmith);

        //James wants to go to the Lisbon show and Bordeaux show
        System.out.println(boldOn + "\nAdding James to activities" + boldOff);
        LisbonHamiltonShow.addPassenger(jamesJackson);
        BordeauxWickedMusical.addPassenger(jamesJackson);

        // Sheila wants to learn more about the Lisbon Show before she decides,
        // however, she is definite about going to Vigo Walking Tour
        VigoWalkingTour.addPassenger(sheilaWilliams);
        System.out.println(boldOn + "\nTesting to see details of Lisbon Hamilton Show" + boldOff);
        System.out.println(LisbonHamiltonShow);
        //After a little convincing, she obliges!
        System.out.println(boldOn+"\nAdding Sheila Williams to Lisbon Hamilton Show"+boldOff);
        LisbonHamiltonShow.addPassenger(sheilaWilliams);

        // Jaqueline wants to do everything, but will let random choice
        // decide which activities she can do given her limited balance
        //
        // numbers will be associated with their respective locations in order of the itinerary
        int[] jaquelinesChoice = new int[4];

        Random random = new Random();

        for(int i = 0; i < 4; i++){
            boolean existsInArray = false;
            int randInt = random.nextInt(4);

            for(int j : jaquelinesChoice){
                if(j == randInt){
                    existsInArray = true;
                    break;
                }
            }

            if(!existsInArray){
                jaquelinesChoice[i] = randInt;
            }
        }

        System.out.println(boldOn + "\nJaqueline Testing" + boldOff);
        System.out.println("\nOrder of 'random' choices:");

        for(int i = 0; i < 4; i++){
            System.out.println(boldOn + jaquelinesChoice[i] + boldOff);
        }

        System.out.println();

        /*
        Jaqueline's 'random choices' in order
        Lisbon Hamilton Show (1)
        Vigo 5K (2)
        Bordeaux Wicked Musical (3)
        Nantes 10K (4)
        */

        for(int i = 0; i < 4; i++){
            switch (jaquelinesChoice[i]){
                case 0:
                    if(jacquelineJames.balance < LisbonHamiltonShow.getPrice()*jacquelineJames.tier.getDiscount()){
                        System.out.println("Balance is insufficient for Hamilton Show. " +
                                "\nBalance: " + jacquelineJames.balance +
                                "\nPrice of Activity: " + LisbonHamiltonShow.getPrice());
                        break;
                    }
                    System.out.println(boldOn+"\nJaqueline was added to Lisbon Hamilton Show"+boldOff);
                    LisbonHamiltonShow.addPassenger(jacquelineJames);
                    break;
                case 1:
                    if(jacquelineJames.balance < VigoWalkingTour.getPrice()*jacquelineJames.tier.getDiscount()){
                        System.out.println("Balance is insufficient for Vigo Walking Tour. " +
                                "\nBalance: " + jacquelineJames.balance +
                                "\nPrice of Activity: " + LisbonHamiltonShow.getPrice());
                        break;
                    }
                    System.out.println(boldOn+"\nJaqueline was added to Vigo Walking Tour"+boldOff);
                    VigoWalkingTour.addPassenger(jacquelineJames);
                    break;
                case 2:
                    if(jacquelineJames.balance < BordeauxWickedMusical.getPrice()*jacquelineJames.tier.getDiscount()){
                        System.out.println("Balance is insufficient for Bordeaux Wicked Musical. " +
                                "\nBalance: " + jacquelineJames.balance +
                                "\nPrice of Activity: " + LisbonHamiltonShow.getPrice());
                        break;
                    }
                    System.out.println(boldOn+"\nJaqueline was added to Bordeaux Wicked Musical"+boldOff);
                    BordeauxWickedMusical.addPassenger(jacquelineJames);
                    break;
                case 3:
                    if(jacquelineJames.balance < Nantes10K.getPrice()*jacquelineJames.tier.getDiscount()){
                        System.out.println("Balance is insufficient for Nantes Walking Tour. " +
                                "\nBalance: " + jacquelineJames.balance +
                                "\nPrice of Activity: " + LisbonHamiltonShow.getPrice());
                        break;
                    }
                    System.out.println("Jaqueline was added to Nantes 10K");
                    Nantes10K.addPassenger(jacquelineJames);
                    break;
            }
        }

        //removes Jaqueline from The Lost Cause, as she realizes she gets sea sick
        theLostCause.removePassenger(jacquelineJames);

        //checks to see if she was properly removed from the cruise ship
        if(!theLostCause.getPassengers().contains(jacquelineJames)){
            System.out.println(boldOn+"\nThe passenger (Jaquleine James) has been properly removed from the CruisShip"+boldOff);
        }

        //removes Sheila from Lisbon Show, as in the end she changed her mind once more
        LisbonHamiltonShow.removePassenger(sheilaWilliams);

        //checks to see if she was properly removed from the activity
        if(!LisbonHamiltonShow.getSignups().contains(sheilaWilliams)){
            System.out.println(boldOn+"\nThe passenger (Sheila Williams) has been properly removed from the CruisShip"+boldOff);
        }

        //checks all the toString calls for the passengers
        System.out.println(boldOn + "\nTesting to see details of Hugh Smith" + boldOff);
        System.out.println(hughSmith);
        System.out.println(boldOn + "\nTesting to see details of James Jackson" + boldOff);
        System.out.println(jamesJackson);
        System.out.println(boldOn + "\nTesting to see details of Sheila Williams" + boldOff);
        System.out.println(sheilaWilliams);
        System.out.println(boldOn + "\nTesting to see details of Jaqueline James" + boldOff);
        System.out.println(jacquelineJames);

        //check all the activities toString
        System.out.println(boldOn + "\nTesting to see details of all activities' details" + boldOff);
        System.out.println(LisbonHamiltonShow);
        System.out.println(VigoWalkingTour);
        System.out.println(BordeauxWickedMusical);
        System.out.println(Nantes10K);

        //lastly checks the cruiseship's details as a whole
        System.out.println(boldOn+"\nTesting to see details of CruiseShip itself"+boldOff);
        System.out.println(theLostCause);

    }


}
