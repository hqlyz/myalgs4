import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lyz on 15-2-4.
 * API:
 * 1. Cycle(Graph graph)
 * 2. boolean hasCycle()
 */
public class Cycle {
    private boolean[] marked;
    private boolean has_cycle;

    public Cycle(Graph graph) {
        marked = new boolean[graph.getV()];
        for(int i = 0; i < graph.getV(); ++i) {
            if(!marked[i])
                dfs(graph, i, i);
        }
    }

    private void dfs(Graph graph, int v, int u) {
        marked[v] = true;
        for(int w : graph.adj(v)) {
            if(!marked[w])
                dfs(graph, w, v);
            else if(w != u)
                has_cycle = true;
        }
    }

    public boolean hasCycle() {
        return has_cycle;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("cycle-test.txt"));
            Graph graph = new Graph(scanner);
            Cycle cycle = new Cycle(graph);
            StdOut.println(cycle.hasCycle());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
