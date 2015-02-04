import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lyz on 15-2-3.
 *
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    private int[] edge_to;
    private int s;

    public DepthFirstSearch(Graph graph, int s) {
        marked = new boolean[graph.getV()];
        edge_to = new int[graph.getV()];
        this.s = s;
        dfs(graph, s);
    }

    private void dfs(Graph graph, int s) {
        marked[s] = true;
        ++count;
        for(int w : graph.adj(s))
            if(!marked[w]) {
                edge_to[w] = s;
                dfs(graph, w);
            }
    }

    public boolean markded(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v))
            return null;
        MyStack<Integer> my_stack = new MyStack<Integer>();
        for(int i = v; i != s; i = edge_to[i])
            my_stack.push(i);
        my_stack.push(s);
        return my_stack;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("tinyCG.txt"));
            Graph graph = new Graph(scanner);
            int s = 0;
            DepthFirstSearch paths = new DepthFirstSearch(graph, s);
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
                StdOut.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
