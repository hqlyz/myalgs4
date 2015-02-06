import javax.swing.*;

/**
 * Created by lyz on 15-2-6.
 * 最小生成树的Kruskal算法
 */
public class KruskalMST {
    private MyQueue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph ewg_graph) {
        mst = new MyQueue<Edge>();
        Edge[] edges = new Edge[ewg_graph.getV()];
        int count = 0;
        for(Edge e : ewg_graph.edges()) {
            edges[count++] = e;
        }
        MinPQ<Edge> pq = new MinPQ<Edge>(edges);
        ThirdUnion third_union = new ThirdUnion(ewg_graph.getV());
        while(!pq.isEmpty() && mst.size() < ewg_graph.getV() - 1) {
            Edge edge = pq.delMin();
            int v = edge.either();
            int w = edge.other(v);
            if(third_union.connected(v, w))
                continue;
            third_union.union(v, w);
            mst.enqueue(edge);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}
