/**
 * Created by lyz on 15-1-28.
 */
public class TwoSum {
    public static int count(int[] a) {
        int size = a.length;
        int count = 0;
        for(int i = 0; i < size; ++i)
            for(int j = i + 1; j < size; ++j)
                if(a[i] + a[j] == 0)
                    ++count;
        return count;
    }
}
