import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
public class BurrowsWheeler {

    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output 
    public static void transform() {
        String string = BinaryStdIn.readString();
        CircularSuffixArray circSuffArray = new CircularSuffixArray(string);
        int len = circSuffArray.length();
        int n = 0;
        while (n < len && circSuffArray.index(n) != 0) {
            n += 1;
        }
        BinaryStdOut.write(n);
        for (int i = 0; i < len; i++) {
            int charIdx = (circSuffArray.index(i) + len - 1) % len;
            char ch = string.charAt(charIdx);
            BinaryStdOut.write(ch);
        }
        BinaryStdOut.flush();
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
        int startingIdx = BinaryStdIn.readInt();
        String string = BinaryStdIn.readString();
        int len = string.length();
        char[] tArr = new char[len];
        int[] idxArr = new int[len];
        int[] countArr = new int[256];
        for (int i = 0; i < len; i++) {
            char ch = string.charAt(i);
            tArr[i] = ch;
            idxArr[i] = countArr[ch];
            countArr[ch] += 1;
        }
        int[] shiftArr = new int[256];
        int cumulative = 0;
        for (int i = 0; i < 255; i++) {
            cumulative += countArr[i];
            shiftArr[i+1] = cumulative;
        }
        int[] right = new int[len];
        int left = startingIdx;
        int counter = left-1;
        while (counter >= 0) {
            right[counter] = left;
            char ch = tArr[left];
            left = shiftArr[ch] + idxArr[left];
            counter--;
        }
        for (int i = 0; i < len; i++) {
            BinaryStdOut.write(tArr[right[i]]);
        }
        BinaryStdOut.flush();
    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if (args[0].equals("+")) {
            inverseTransform();
        }
        if (args[0].equals("-")) {
            transform();
        }
    }

}