import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lyz on 15-2-5.
 * API:
 * 1. DiGraph(int V)
 * 2. DiGraph(In in)
 * 3. DiGraph(Scanner scanner)
 * 4. int getV()
 * 5. int getE()
 * 6. void addEdge(int V, int w)
 * 7. Iterable<Integer> adj(int V)
 * 8. String toString()
 */
public class Digraph {
    private int V;
    private int E;
    private MyBag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (MyBag<Integer>[])new MyBag[V];
        for(int i = 0; i < V; ++i) {
            adj[i] = new MyBag<Integer>();
        }
    }

    public Digraph(In in) {
        this(in.readInt());
        this.E = in.readInt();
        while(!in.isEmpty()) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public Digraph(Scanner scanner) {
        this(scanner.nextInt());
        this.E = scanner.nextInt();
        while(scanner.hasNext()) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            addEdge(v, w);
        }
    }

    public int getV() {
        return this.V;
    }

    public int getE() {
        return this.E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        ++E;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for(int i = 0; i < V; ++i) {
            s += i + ": ";
            for(int w : adj(i)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("tinyG.txt"));
            Digraph digraph = new Digraph(scanner);
            StdOut.print(digraph);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
