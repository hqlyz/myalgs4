/**
 * Created by lyz on 15-2-2.
 * API:
 * 1. void sort(Comparable[] a)
 * 2. boolean less(Comparable a, Comparable b)
 * 3. void exch(Comparable[] a, int i, int j)
 * 4. boolean isSorted(Comparable[] a)
 */
public class Quick {

    public static void sort(Comparable[] a) {
        int low = 0;
        int high = a.length - 1;
        sort(a, low, high);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if(low >= high)
            return;
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable value = a[low];
        while(true) {
            while(less(a[++i], value))
                if(i == high)
                    break;
            while(less(value, a[--j]))
                if(j == low)
                    break;
            if(i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    public static void exch(Comparable[] a, int i, int j) {
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
        for(Comparable com : a) {
            StdOut.print(com + "\t");
        }
    }

    public static void main(String[] args) {
        String[] string_array = new String[] {"s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};
        StdRandom.shuffle(string_array);
        printArray(string_array);
        sort(string_array);
        assert isSorted(string_array);
        StdOut.println();
        printArray(string_array);
    }
}
