package cx.caesar;

public class CommandLine {

    private static void ohno() {
        throw new RuntimeException("needs command line args for: file then shift then possibly -d if want to decrypt");
    }

    public static CommandLineOptions parse(String[] args) {
        boolean decrypt = false;

        if (args.length == 2 || args.length == 3) {
            ohno();
        }

        String filename = args[0];

        int shift = Integer.parseInt(args[1]);

        if (args.length == 3) {
            if (args[2].equals("-d") || args[2].equals("--decrypt")) {
                decrypt = true;
            } else {
                ohno();
            }
        }
        return new CommandLineOptions(filename, shift, decrypt);
    }
}
