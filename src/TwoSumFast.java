import java.util.Arrays;

/**
 * Created by lyz on 15-1-28.
 *
 */
public class TwoSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int size = a.length;
        int count = 0;
        for(int i = 0; i < size; ++i)
            if(BinarySearch.rank(-a[i], a) > i)
                ++count;

        return count;
    }

    public static void main(String[] args) {
        int[] a = Utils.genericRandomInts(10000000);
        StdOut.println(count(a));
    }
}
