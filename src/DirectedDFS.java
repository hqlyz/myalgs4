import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lyz on 15-2-5.
 * 有向图的深度优先搜索
 * API:
 * 1. public DirectedDFS(Digraph digraph, int s)
 * 2. publis DirectedDFS(Digraph digraph, Iterable<Integer> sources
 * 3. boolean marked(int v)
 */
public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph digraph, int s) {
        marked = new boolean[digraph.getV()];
        diDfs(digraph, s);
    }

    public DirectedDFS(Digraph digraph, Iterable<Integer> sources) {
        marked = new boolean[digraph.getV()];
        for(int s : sources) {
            if(!marked[s]) {
                diDfs(digraph, s);
            }
        }
    }

    private void diDfs(Digraph digraph, int v) {
        marked[v] = true;
        for(int w : digraph.adj(v)) {
            if(!marked[w]) {
                diDfs(digraph, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("tinyDG.txt"));
            Digraph digraph = new Digraph(scanner);
            DirectedDFS directed_dfs = new DirectedDFS(digraph, 2);
            for(int i = 0; i < digraph.getV(); ++i) {
                StdOut.print(i + ": ");
                StdOut.println(directed_dfs.marked(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
