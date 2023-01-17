import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;

public class CircularSuffixArray {
    private int len;
    private int[] idxArr;
    private class Suffix implements Comparable<Suffix> {
        private String string;
        private int shift;
        public Suffix(String s, int shf) {
            this.string = s;
            this.shift = shf;
        }
        private char charAt(int pos) {
            return string.charAt((shift + pos) % string.length());
        }
        public int compareTo(Suffix that) {
            for (int i = 0; i < string.length(); i++) {
                char thisChar = this.charAt(i);
                char thatChar = that.charAt(i);
                if (thisChar > thatChar) {
                    return 1;
                }
                if (thisChar < thatChar) {
                    return -1;
                }
            }
            return 0;
        }
    }
    public CircularSuffixArray(String s) {
        len = s.length();
        Suffix[] suffixArr = new Suffix[len];
        for (int i = 0; i < len; i++) {
            suffixArr[i] = new Suffix(s, i);
        }
        Arrays.sort(suffixArr);
        idxArr = new int[len];
        for (int i = 0; i < len; i++) {
            idxArr[i] = suffixArr[i].shift;
        }
    }
    public int length() {
        return len;
    }
    public int index(int i) {
        return idxArr[i];
    }
    public static void main(String[] args) {
    // unit testing of the methods (optional)
        CircularSuffixArray circSuffArray = new CircularSuffixArray("ABRACADABRA!");
        StdOut.println(circSuffArray.index(0));
    }
}