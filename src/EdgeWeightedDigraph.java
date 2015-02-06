import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lyz on 15-2-6.
 * 加权有向图的数据结构
 * API:
 * 1. EdgeWeightedDigraph(int V)
 * 2. EdgeWeightedDigraph(Scanner scanner)
 * 3. int getV()
 * 4. int getE()
 * 5. void addEdge(DirectedEdge di_edge)
 * 6. Iterable<DirectedEdge> adj(int v)
 * 7. Iterable<DirectedEdge> edges()
 * 8. String toString()
 */
public class EdgeWeightedDigraph {
    private int V;
    private int E;
    private MyBag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (MyBag<DirectedEdge>[])new MyBag[V];
        for(int i = 0; i < V; ++i) {
            adj[i] = new MyBag<DirectedEdge>();
        }
    }

    public EdgeWeightedDigraph(Scanner scanner) {
        this(scanner.nextInt());
        this.E = scanner.nextInt();
        while(scanner.hasNext()) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            double weight = scanner.nextDouble();
            DirectedEdge di_edge = new DirectedEdge(v, w, weight);
            addEdge(di_edge);
        }
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public void addEdge(DirectedEdge di_edge) {
        int v = di_edge.from();
        int w = di_edge.to();
        adj[v].add(di_edge);
        ++E;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        MyBag<DirectedEdge> edges = new MyBag<DirectedEdge>();
        for(int i = 0; i < V; ++i) {
            for(DirectedEdge di_edge : adj[i])
                edges.add(di_edge);
        }
        return edges;
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for(int i = 0; i < V; ++i) {
            s += i + ": ";
            for(DirectedEdge di_edge : adj[i])
                s += di_edge + "\t";
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("mediumEWG.txt"));
            EdgeWeightedDigraph ewg_digraph = new EdgeWeightedDigraph(scanner);
            StdOut.print(ewg_digraph);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
