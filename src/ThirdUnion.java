import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lyz on 15-1-29.
 * API:
 * 1. ThirdUnion(int N)
 * 2. boolean connected(int p, int q)
 * 3. int find(int p)
 * 4. void union(int p, int q)
 * 5. int count()
 */
public class ThirdUnion {
    private int[] a;
    private int[] sz;
    private int count;

    public ThirdUnion(int N) {
        a = new int[N];
        for (int i = 0; i < N; ++i) {
            a[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; ++i) {
            sz[i]  = 1;
        }
        count = N;
    }

    public boolean connected(int p , int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != a[p])
            p = a[p];
        return p;
    }

    public void union(int p, int q) {
        int root_p = find(p);
        int root_q = find(q);
        if(root_p == root_q)
            return;
        int sz_p = sz[root_p];
        int sz_q = sz[root_q];
        if(sz_p < sz_q) {
            a[root_p] = root_q;
            sz[root_q] = sz_p + sz_q;
        } else {
            a[root_q] = root_p;
            sz[root_p] = sz_p + sz_q;
        }
        --count;
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        try {
            StopWatch stop_watch = new StopWatch();
            Scanner scanner = new Scanner(Utils.getFile("largeUF.txt"));
            int count = scanner.nextInt();
            ThirdUnion third_union = new ThirdUnion(count);
            while(scanner.hasNext()) {
                int p = scanner.nextInt();
                int q = scanner.nextInt();
                if(third_union.connected(p, q))
                    continue;
                third_union.union(p, q);
                StdOut.println(p + " " + q);
            }
            StdOut.println(third_union.count() + " components of " + count);
            StdOut.printf("elapsed time: %.3f", stop_watch.elapsedTime());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
