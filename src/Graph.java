import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by lyz on 15-2-3.
 * API:
 * 1. Graph(int V)
 * 2. Graph(In in)
 * 3. Graph(Scanner scanner)
 * 4. int getV()
 * 5. int getE()
 * 6. void addEdge(int V, int w)
 * 7. Iterable<Integer> adj(int V)
 * 8. String toString()
 */
public class Graph {
    private final int V;
    private int E;
    private MyBag<Integer>[] adj;

    public Graph(int v) {
        this.V = v;
        E = 0;
        adj = (MyBag<Integer>[])new MyBag[this.V];
        for(int i = 0; i < v; ++i) {
            adj[i] = new MyBag<Integer>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        E = in.readInt();
        for(int i = 0; i < E; ++i) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public Graph(Scanner scanner) {
        this(scanner.nextInt());
        E = scanner.nextInt();
        while(scanner.hasNext()) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            addEdge(v, w);
        }
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        ++E;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for(int i = 0; i < V; ++i) {
            s += i + ": ";
            for(int w : adj(i))
                s += w + " ";
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("tinyG.txt"));
            Graph graph = new Graph(scanner);
            StdOut.println(graph);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
