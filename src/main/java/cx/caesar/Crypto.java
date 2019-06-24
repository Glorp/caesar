package cx.caesar;

import java.io.*;

public final class Crypto {

    private final String alphabet;
    private final int offset;

    public Crypto(String alphabet, int offset) {
        this.alphabet = alphabet;
        this.offset = offset;
    }


    private static int modulo(int a, int b) {
        return (Math.abs(a * b) + a) % b;
    }

    public char shift(char c) {

        int original = alphabet.indexOf(c);
        return  original == -1
                ? c
                : alphabet.charAt(modulo(original + offset, alphabet.length()));
    }

    public String cryptString(String str) {
        StringBuilder sb = new StringBuilder();
        str.chars().forEach(i -> sb.append(shift((char)i)));
        return sb.toString();
    }

    public void crypt(Reader in, Writer out) {
        int ch = 0;
        try {
            ch = in.read();
            while (ch != -1) {
                out.write(shift((char)ch));
                ch = in.read();
                out.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
