import java.util.Arrays;

/**
 * Created by lyz on 15-1-26.
 * Classic, efficient binary search
 */
public class BinarySearch {
    public static int rank(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while(low <= high) {
            int middle = low + (high - low) / 2;
            if(key < a[middle])
                high = middle - 1;
            else if(key > a[middle])
                low = middle + 1;
            else
                return middle;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] white_list = Utils.readInts("largeW.txt");
        Arrays.sort(white_list);
        int[] check_list = Utils.readInts("largeT.txt");
        StdOut.println("Let's start...");
        int count = 0;
        for(int i = 0; i < check_list.length; ++i) {
            if(rank(check_list[i], white_list) == -1) {
                ++count;
                if(count % 20 == 0)
                    StdOut.println();
                StdOut.print(check_list[i] + "\t");
            }
        }
    }
}
