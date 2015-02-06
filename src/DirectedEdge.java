/**
 * Created by lyz on 15-2-6.
 * 加权有向边的数据结构
 * API:
 * 1. DirectedEdge(int v, int w, double weight)
 * 2. double getWeight()
 * 3. int from()
 * 4. int to()
 * 5. String toString()
 */
public class DirectedEdge {
    private int v;
    private int w;
    private double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }
}
