/**
 * Created by lyz on 15-2-6.
 * 带权重的边的数据类型
 * API:
 * 1. Edge(int v, int w, double weight)
 * 2. double weight()
 * 3. int either()
 * 4. int other()
 * 5. int compareTo(Edge edge)
 * 6. String toString()
 */
public class Edge implements Comparable<Edge> {
    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if(vertex == v)
            return w;
        else if(vertex == w)
            return v;
        else
            throw new RuntimeException("Inconsistent edge");
    }

    @Override
    public int compareTo(Edge edge) {
        if(this.weight > edge.weight)
            return 1;
        else if(this.weight < edge.weight)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return String.format("%d--%d %.2f", v, w, weight);
    }

    public static void main(String[] args) {

    }
}
