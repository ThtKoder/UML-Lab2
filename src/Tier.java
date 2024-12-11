public class Tier {
    private String tierName;
    private double discount;

    public Tier(String tierName, double discount) {
        this.tierName = tierName;
        this.discount = discount;
    }

    public String getTierName() {
        return tierName;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "\nTier: " +
                "tierName = " + tierName + '\'' +
                ", discount = " + discount;
    }
}
