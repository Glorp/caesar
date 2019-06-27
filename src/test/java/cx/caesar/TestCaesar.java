package cx.caesar;

import static org.assertj.core.api.Assertions.*;

import net.jqwik.api.*;

public class TestCaesar {

    private final static String alphabet = "abcdefghijklmnopqrstuvwxyz\u00E6\u00F8\u00E5 ";

    private void check(int shift, String decrypted, String encrypted) {
        assertThat(new Crypto(alphabet, shift).cryptString(decrypted)).matches(encrypted);
        assertThat(decrypted).matches(new Crypto(alphabet, -shift).cryptString(encrypted));
    }

    @Example
    public void caesample() {
        check(7, "i came", "pgjhtl");
        check(7,"i saw", "pgzh ");
        check(7,"i conquered", "pgjvuxølylk");
    }

    @Property
    public void inverse(@ForAll String alphabet, @ForAll int shift, @ForAll String plainText) {
        Crypto en = new Crypto(alphabet, shift);
        Crypto de = new Crypto(alphabet, -shift);
        String cipherText = en.cryptString(plainText);
        assertThat(plainText).isEqualTo(de.cryptString(cipherText));
    }
}
