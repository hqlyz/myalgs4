/**
 * Created by lyz on 15-1-30.
 * API:
 * 1. void sort(Comparable[] a)
 * 2. boolean less(Comparable a, Comparable b)
 * 3. void exch(Comparable[] a, int i, int j)
 * 4. boolean isSorted(Comparable[] a)
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        int size = a.length;
        for(int i = 1; i < size; ++i) {
            for(int j = i; j > 0 && less(a[j], a[j - 1]); --j) {
                exch(a, j, j - 1);
            }
        }
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i , int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean isSorted(Comparable[] a) {
        int size = a.length;
        for(int i = 1; i < size; ++i) {
            if(less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    private static void printArray(Comparable[] a) {
        int size = a.length;
        for(Comparable com : a)
            StdOut.print(com + "\t");
    }

    public static void main(String[] args) {
        String[] string_array = new String[] {"s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};
        printArray(string_array);
        sort(string_array);
        assert isSorted(string_array);
        StdOut.println();
        printArray(string_array);
    }
}
