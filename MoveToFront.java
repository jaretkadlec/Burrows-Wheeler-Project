import java.util.ArrayList;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
public class MoveToFront {

    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode() {
        ArrayList<Character> charArr = new ArrayList<Character>();
        for (int i = 0; i < 256; i++) {
            char adjustedI = (char) i;
            charArr.add(adjustedI);
        }
        while (!BinaryStdIn.isEmpty()) {
            char ch = BinaryStdIn.readChar();
            int charIdx = charArr.indexOf(ch);
            BinaryStdOut.write(charIdx, 8);
            charArr.remove(charIdx);
            charArr.add(0,ch);
        }
        BinaryStdOut.flush();
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        ArrayList<Character> charArr = new ArrayList<Character>();
        for (int i = 0; i < 256; i++) {
            char adjustedI = (char) i;
            charArr.add(adjustedI);
        }
        while (!BinaryStdIn.isEmpty()) {
            char charIdx = BinaryStdIn.readChar();
            char ch = charArr.get(charIdx);         
            BinaryStdOut.write(ch);
            charArr.remove(charIdx);
            charArr.add(0,ch);
        }
        BinaryStdOut.flush();
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if ((args[0]).equals("+")) {
            decode();
        } 
        if (args[0].equals("-")) {
            encode();
        }
    }

}