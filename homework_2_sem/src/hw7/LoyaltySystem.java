package hw7;

public class LoyaltySystem {

    DiscountRepository discountRepository;

    public LoyaltySystem(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public Bucket applyDiscount(long userId, Bucket bucket) {
        double discountFactor = 1 - (discountRepository.getDiscountForUser(userId) / 100.0);

        for (Purchase purchase : bucket.getPurchases()) {
            double discountedPrice = purchase.getCost() * discountFactor;
            purchase.setCost(discountedPrice);
        }

        return bucket;
    }

}
