/**
 * Created by lyz on 15-1-29.
 * API:
 * 1. void sort(Comparable[] a)
 * 2. boolean less(Comparable a, Comparable b)
 * 3. void exch(Comparabled[] a, int i, int j)
 * 4. boolean isSorted(Comparabled[] a)
 */
public class Selection {
    public static void sort(Comparable[] a) {
        int size = a.length;
        for(int i = 0; i < size; ++i) {
            int min = i;
            for(int j = i + 1; j < size; ++i) {
                if(!less(a[min], a[j]))
                    min = j;
            }
            exch(a, i, min);
        }
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean isSorted(Comparable[]a ) {
        int size = a.length;
        for(int i = 0; i < size - 1; ++i) {
            if(!less(a[i], a[i + 1]))
                return false;
        }
        return true;
    }
}
