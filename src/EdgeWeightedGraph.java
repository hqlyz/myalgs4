import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lyz on 15-2-6.
 * 加权无向图的数据类型
 * API:
 * 1. EdgeWeightedGraph(int V)
 * 2. EdgeWeightedGraph(Scanner scanner)
 * 3. int getV()
 * 4. int getE()
 * 5. void addEdge(Edge edge)
 * 6. Iterable<Edge> adj(int v)
 * 7. Iterable<Edge> edges()
 */
public class EdgeWeightedGraph {
    private int V;
    private int E;
    private MyBag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (MyBag<Edge>[])new MyBag[V];
        for(int i = 0; i < V; ++i) {
            adj[i] = new MyBag<Edge>();
        }
    }

    public EdgeWeightedGraph(Scanner scanner) {
        this(scanner.nextInt());
        this.E = scanner.nextInt();
        while (scanner.hasNext()) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            double weight = scanner.nextDouble();
            Edge edge = new Edge(v, w, weight);
            addEdge(edge);
        }
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        ++E;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        MyBag<Edge> edges = new MyBag<Edge>();
        for(int i = 0; i < V; ++i) {
            for(Edge v : adj[i]) {
                if(v.other(i) > i)
                    edges.add(v);
            }
        }
        return edges;
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for(int i = 0; i < V; ++i) {
            s += i + ": ";
            for(Edge e : adj[i]) {
                s += e + "\t";
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("tinyEWG.txt"));
            EdgeWeightedGraph edge_weighted_graph = new EdgeWeightedGraph(scanner);
            StdOut.print(edge_weighted_graph);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
