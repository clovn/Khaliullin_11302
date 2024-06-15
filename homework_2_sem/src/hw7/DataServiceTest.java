package hw7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataServiceTest {
    private DiscountRepository discountRepository;
    private LoyaltySystem loyaltySystem;
    private Bucket bucket;

    @BeforeEach
    void setUp() {
        discountRepository = Mockito.mock(DataService.class);
        loyaltySystem = new LoyaltySystem(discountRepository);
        bucket = new Bucket();
        bucket.addPurchase(new Purchase(101,  100.0));
        bucket.addPurchase(new Purchase(102, 200.0));
    }

    @Test
    void applyDiscount_userWith10PercentDiscount() {
        when(discountRepository.getDiscountForUser(1L)).thenReturn(10);
        Bucket updatedCart = loyaltySystem.applyDiscount(1, bucket);

        List<Purchase> purchases = updatedCart.getPurchases();
        assertEquals(90.0, purchases.get(0).getCost());
        assertEquals(180.0, purchases.get(1).getCost());
    }

    @Test
    void applyDiscount_userWith20PercentDiscount() {
        when(discountRepository.getDiscountForUser(2L)).thenReturn(20);

        Bucket updatedCart = loyaltySystem.applyDiscount(2, bucket);

        List<Purchase> purchases = updatedCart.getPurchases();
        assertEquals(80.0, purchases.get(0).getCost());
        assertEquals(160.0, purchases.get(1).getCost());
    }

    @Test
    void applyDiscount_userWithNoDiscount() {
        when(discountRepository.getDiscountForUser(3L)).thenReturn(0);

        Bucket updatedCart = loyaltySystem.applyDiscount(3, bucket);

        List<Purchase> purchases = updatedCart.getPurchases();
        assertEquals(100.0, purchases.get(0).getCost());
        assertEquals(200.0, purchases.get(1).getCost());
    }
}
