import java.io.FileInputStream;

/**
 * Created by lyz on 15-1-26.
 *
 */
public class HelloWorld {

    public static void main(String[] args) {
        for(int N = 250; N <= 64000; N += N) {
            int[] a = new int[N];
            for(int i = 0; i < a.length; ++i) {
                a[i] = StdRandom.uniform(-1000000, 1000000);
            }
            StopWatch watch_time = new StopWatch();
            int count = TwoSum.count(a);
            double elapsed_time = watch_time.elapsedTime();
            StdOut.printf("%7d   %5.3f\n", N, elapsed_time);
        }

//        StdOut.println("Elapsed time: " + elapsed_time);
//        StdOut.println("count: " + count);
    }
}
