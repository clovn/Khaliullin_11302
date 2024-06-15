package hw7;

public class Purchase {
    private long goodId;
    private double cost;

    public Purchase(long goodId, double cost) {
        this.goodId = goodId;
        this.cost = cost;
    }

    public long getGoodId() {
        return goodId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
