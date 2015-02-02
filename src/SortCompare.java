/**
 * Created by lyz on 15-1-30.
 * Compare every sort method
 */
public class SortCompare {
    public static final String SORT_ALG_INSERTION = "Insertion";
    public static final String SORT_ALG_SELECTION = "Selection";
    public static final String SORT_ALG_QUICK_INSERTION = "QuickInsertion";
    public static final String SORT_ALG_SHELL = "Shell";
    public static final String SORT_ALG_QUICK = "Quick";

    public static double time(String alg, Comparable[] a) {
        StopWatch stop_watch = new StopWatch();
        if(alg.equals(SORT_ALG_INSERTION))
            Insertion.sort(a);
        else if(alg.equals(SORT_ALG_SELECTION))
            Selection.sort(a);
        else if(alg.equals(SORT_ALG_QUICK_INSERTION))
            QuickInsertion.sort(a);
        else if(alg.equals(SORT_ALG_SHELL))
            Shell.sort(a);
        else if(alg.equals(SORT_ALG_QUICK))
            Quick.sort(a);
        return stop_watch.elapsedTime();
    }

    public static double timeRandomInput(String alg, int T, int N) {
        double total_time = 0.0;
        Double[] a = new Double[N];
        for(int i = 0; i < T; ++i) {
            for(int j = 0; j < N; ++j) {
                a[j] = StdRandom.uniform();
            }
            total_time += time(alg, a);
        }
        return total_time;
    }

    public static void main(String[] args) {
        int T = 100;
        int N = 10000;
        String t1_method = SORT_ALG_QUICK;
        String t2_method = SORT_ALG_SHELL;
        double t1 = timeRandomInput(t1_method, T, N);
        double t2 = timeRandomInput(t2_method, T, N);
        StdOut.println("t1: " + t1);
        StdOut.println("t2: " + t2);
        StdOut.printf("%s is %.2f times faster than %s", t2_method, t1 / t2, t1_method);
    }
}
