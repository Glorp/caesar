package cx.caesar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestCaesar {

    private final static String alphabet = "abcdefghijklmnopqrstuvwxyz\u00E6\u00F8\u00E5 ";

    private void check(int shift, String decrypted, String encrypted) {
        assertEquals(new Crypto(alphabet, shift).cryptString(decrypted), encrypted);
        assertEquals(decrypted, new Crypto(alphabet, -shift).cryptString(encrypted));
    }

    @Test
    public void testStuff() {
        check(7, "i came", "pgjhtl");
        check(7,"i saw", "pgzh ");
        check(7,"i conquered", "pgjvuxølylk");
    }
}
