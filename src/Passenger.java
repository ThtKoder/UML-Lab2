public class Passenger {
    public Tier tier;
    public int balance;

    private String name;
    private int Number;
    private CruiseShip cruiseShip;

    public Passenger(String name, int number, Tier tier, CruiseShip cruiseShip) {
        this.name = name;
        this.Number = number;
        this.tier = tier;
        this.cruiseShip = cruiseShip;
    }

    public String getName() {
        return name;
    }
    public Tier getTier() {
        return tier;
    }
    public CruiseShip getCruiseShip() {
        return cruiseShip;
    }

    public void addBalance(int amount){
        balance += amount;
    }

    @Override
    public String toString() {
        return "\nPassenger: " +
                "name = " + name + '\'' +
                ", tier = " + tier + '\'' +
                ", balance = " + balance +
                ", Number = " + Number +
                ", cruiseShip = " + cruiseShip.toStringWithoutPassenger() + '\'' +
                '}';
    }
}