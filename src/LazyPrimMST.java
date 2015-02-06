import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lyz on 15-2-6.
 * Prim算法的延时实现
 * API:
 * 1. LazyPrimMST(EdgeWeightedGraph ewg_graph)
 * 2. Iterable<Edge> edges()
 * 3. double weight()
 */
public class LazyPrimMST {
    private boolean[] marked;           // 最小生成树的顶点
    private MyQueue<Edge> mst;          // 最小生成树的边
    private MinPQ<Edge> pq;             // 横切边(包括失效的边)

    public LazyPrimMST(EdgeWeightedGraph ewg_graph) {
        marked = new boolean[ewg_graph.getV()];
        mst = new MyQueue<Edge>();
        pq = new MinPQ<Edge>();

        visit(ewg_graph, 0);
        while(!pq.isEmpty()) {
            // 从PQ中得到权重最小的边
            Edge edge = pq.delMin();

            int v = edge.either();
            int w= edge.other(v);
            // 跳过失效的边
            if(marked[v] && marked[w])
                continue;
            mst.enqueue(edge);
            if(!marked[v])
                visit(ewg_graph, v);
            if(!marked[w])
                visit(ewg_graph, w);
        }
    }

    private void visit(EdgeWeightedGraph ewg_graph, int v) {
        marked[v] = true;
        for(Edge edge : ewg_graph.adj(v)) {
            if(!marked[edge.other(v)])
                pq.insert(edge);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double weight = 0;
        for(Edge edge : mst) {
            weight += edge.getWeight();
        }
        return weight;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("mediumEWG.txt"));
            EdgeWeightedGraph ewg_graph = new EdgeWeightedGraph(scanner);
            LazyPrimMST lazy_prim_mst = new LazyPrimMST(ewg_graph);
            for(Edge edge : lazy_prim_mst.edges())
                StdOut.println(edge);
            StdOut.printf("all weights: %.2f", lazy_prim_mst.weight());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
