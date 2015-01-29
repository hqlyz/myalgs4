/**
 * Created by lyz on 15-1-28.
 */
public class ThreeSum {
    public static int count(int[] a) {
        int size = a.length;
        int count = 0;
        for(int i = 0; i < size; ++i)
            for(int j = i + 1; j < size; ++j)
                for(int k = j + 1; k < size; ++k)
                    if(a[i] + a[j] + a[k] == 0)
                        ++count;
        return count;
    }

    public static void main(String[] args) {
        int[] a = Utils.readInts("8Kints.txt");
        StdOut.println("size: " + a.length);
        StdOut.println("counts: " + count(a));
    }
}
