/**
 * Created by lyz on 15-2-6.
 * Prim算法的即时实现
 * API:
 * 1. PrimMST(EdgeWeightedGraph ewg_graph)
 * 2. Iterable<Edge> edges()
 * 3. double weight()
 */
public class PrimMST {
    private Edge[] edge_to;
    private double[] dist_to;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph ewg_graph) {
        edge_to = new Edge[ewg_graph.getV()];
        marked = new boolean[ewg_graph.getV()];
        dist_to = new double[ewg_graph.getV()];
        for(int i = 0; i < ewg_graph.getV(); ++i)
            dist_to[i] = Double.POSITIVE_INFINITY;
        pq = new IndexMinPQ<Double>(ewg_graph.getV());

        dist_to[0] = 0.0;
        pq.insert(0, 0.0);
        while(!pq.isEmpty()) {
            visit(ewg_graph, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph ewg_graph, int v) {
        // 将顶点v添加到树中，并更新数据
        marked[v] = true;
        for(Edge edge : ewg_graph.adj(v)) {
            int w = edge.other(v);
            if(marked[w])
                continue;

            if(edge.getWeight() < dist_to[w]) {
                // 连接w和树的最佳边变为edge
                edge_to[w] = edge;
                dist_to[w] = edge.getWeight();
                if(pq.contains(w))
                    pq.changeKey(w, dist_to[w]);
                else
                    pq.insert(w, dist_to[w]);
            }
        }
    }
}
