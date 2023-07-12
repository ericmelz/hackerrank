package hackerrank.exceptions.secure;

import static org.junit.jupiter.api.Assertions.*;

import hackerrank.rest.discount.DiscountedPrice;
import org.junit.jupiter.api.Test;

class EncrypterTest {
    @Test
    public void testValidMessage1() {
        assertEquals("telsniw etak", Encrypter.getEncryptedName("Kate Winslet"));
    }

    @Test
    public void testInvalidMessage1() {
        assertThrows(IllegalArgumentException.class, () -> { Encrypter.getEncryptedName("Kate Wins?let"); });
    }

}