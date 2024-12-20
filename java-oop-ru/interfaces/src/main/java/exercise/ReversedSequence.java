package exercise;

//import java.lang.StringBuilder;
// BEGIN
public class ReversedSequence implements CharSequence {
    public String line;

    public ReversedSequence(String line) {
        this.line = new StringBuilder(line).reverse().toString();
    }

    @Override
    public String toString() {
        return line;
    }

    @Override
    public int length() {
        return line.length();
    }

    @Override
    public char charAt(int index) {
        return line.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return line.subSequence(start, end);
    }


}
// END
