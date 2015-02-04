import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lyz on 15-2-4.
 * API:
 * 1. Paths(Graph graph, int s)
 * 2. boolean hasPathTo(int v)
 * 3. Iterable<Integer> pathTo(int v)
 */
public class Paths {
    public Paths(Graph graph, int s) {

    }

    public boolean hasPathTo(int v) {
        return false;
    }

    public Iterable<Integer> pathTo(int v) {
        return null;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("tinyCG.txt"));
            Graph graph = new Graph(scanner);
            int s = 0;
            Paths paths = new Paths(graph, s);
            for(int i = 0; i < graph.getV(); ++i) {
                StdOut.print(s + " to " + i + ": ");
                if(paths.hasPathTo(i)) {
                    for(int x : paths.pathTo(i)) {
                        if(x == s)
                            StdOut.print(x);
                        else
                            StdOut.print("-" + x);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
