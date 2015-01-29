import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lyz on 15-1-29.
 * API:
 * 1. SecondUnion(int N)
 * 2. boolean connected(int p, int q)
 * 3. int find(int p)
 * 4. void union(int p, int q)
 * 5. int count()
 */
public class SecondUnion {
    private int[] a;
    private int count;

    public SecondUnion(int N) {
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
        while (p != a[p])
            p = a[p];
        return p;
    }

    public void union(int p, int q) {
        int root_p = find(p);
        int root_q = find(q);
        if(root_p == root_q)
            return;
        a[root_p] = root_q;
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
            SecondUnion second_union = new SecondUnion(count);
            while(scanner.hasNext()) {
                int p = scanner.nextInt();
                int q = scanner.nextInt();
                if(second_union.connected(p, q))
                    continue;
                second_union.union(p, q);
                StdOut.println(p + " " + q);
            }
            StdOut.println(second_union.count() + " components of " + count);
            StdOut.printf("elapsed time: %.3f", stop_watch.elapsedTime());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
