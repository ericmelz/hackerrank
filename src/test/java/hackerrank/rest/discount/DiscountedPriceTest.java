package hackerrank.rest.discount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountedPriceTest {
    @Test
    public void testValidBarcode() {
        assertEquals(DiscountedPrice.getDiscountedPrice(74002314), 2964);
    }

    @Test
    public void testInvalidBarcode() {
        assertEquals(DiscountedPrice.getDiscountedPrice(74005364), -1);
    }

}