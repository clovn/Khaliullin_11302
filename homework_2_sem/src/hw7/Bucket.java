package hw7;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private List<Purchase> purchases;

    public Bucket() {
        this.purchases = new ArrayList<>();
    }

    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "purchases=" + purchases +
                '}';
    }
}
