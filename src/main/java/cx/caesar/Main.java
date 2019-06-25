package cx.caesar;

import java.io.*;
import java.util.List;

public final class Main {

    private final static String alphabet = "abcdefghijklmnopqrstuvwxyz\u00E6\u00F8\u00E5 ";

    public static void main(String[] args) {

        CommandLineOptions options = CommandLine.parse(args);

        File file = new File(options.getFilename());
        if (!file.exists() || file.isDirectory()) {
            throw new RuntimeException("Can't find file: " + options.getFilename());
        }
        int shift = options.isDecrypt() ? -options.getShift() : options.getShift();
        Crypto crypto = new Crypto(alphabet, shift);

        try (InputStream inputStream = new FileInputStream(file)) {
            Reader in = new InputStreamReader(inputStream, "UTF-8");
            Writer out= new OutputStreamWriter(System.out);
            crypto.crypt(in, out);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
