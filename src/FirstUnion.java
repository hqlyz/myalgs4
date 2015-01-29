import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lyz on 15-1-29.
 * API:
 * 1. FirstUnion(int N)
 * 2. boolean connected(int p, int q)
 * 3. int find(int p)
 * 4. void union(int p, int q)
 * 5. int count()
 */
public class FirstUnion {
    private int[] a;
    private int count;

    public FirstUnion(int N) {
        a = new int[N];
        count = N;
        for(int i = 0; i < N; ++i) {
            a[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return a[p];
    }

    public void union(int p, int q) {
        if(find(p) == find(q))
            return;

        int val = a[p];
        for(int i = 0; i < a.length; ++i) {
            if(a[i] == val)
                a[i] = a[q];
        }
        --count;
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        try {
            StopWatch stop_watch = new StopWatch();
            Scanner scanner = new Scanner(Utils.getFile("mediumUF.txt"));
            int count = scanner.nextInt();
            FirstUnion first_union = new FirstUnion(count);
            while (scanner.hasNext()) {
                int p = scanner.nextInt();
                int q = scanner.nextInt();
                if(first_union.connected(p, q))
                   continue;
                first_union.union(p, q);
                StdOut.println(p + " " + q);
            }
            StdOut.println(first_union.count() + " components of " + count);
            StdOut.printf("elapsed time: %.3f", stop_watch.elapsedTime());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
