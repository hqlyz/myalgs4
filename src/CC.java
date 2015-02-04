import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lyz on 15-2-4.
 * API:
 * 1. CC(Graph)
 * 2. boolean connected(int v, int w)
 * 3. int count()
 * 4. int id(int v)
 */
public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph graph) {
        marked = new boolean[graph.getV()];
        id = new int[graph.getV()];
        count = 0;
        for(int i = 0; i < graph.getV(); ++i) {
            if(!marked[i]) {
                dfs(graph, i);
                ++count;
            }
        }
    }

    private void dfs(Graph graph, int i) {
        marked[i] = true;
        id[i] = count;
        for(int j : graph.adj(i)) {
            if(!marked[j])
                dfs(graph, j);
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("tinyG.txt"));
            Graph graph = new Graph(scanner);
            CC cc = new CC(graph);
            for(int i = 0; i < cc.count(); ++i) {
                for(int j = 0; j < graph.getV(); ++j) {
                    if(cc.id(j) == i)
                        StdOut.print(j + " ");
                }
                StdOut.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
