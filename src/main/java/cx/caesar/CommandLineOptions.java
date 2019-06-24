package cx.caesar;

import java.util.Objects;

public final class CommandLineOptions {

    private final String filename;
    private final int shift;
    private final boolean decrypt;

    public CommandLineOptions(String filename, int shift, boolean decrypt) {
        this.filename = filename;
        this.shift = shift;
        this.decrypt = decrypt;
    }

    public String getFilename() {
        return filename;
    }

    public int getShift() {
        return shift;
    }

    public boolean isDecrypt() {
        return decrypt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandLineOptions that = (CommandLineOptions) o;
        return shift == that.shift &&
                decrypt == that.decrypt &&
                filename.equals(that.filename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, shift, decrypt);
    }
}
