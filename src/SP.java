import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by lyz on 15-2-6.
 * 最短路径
 * API:
 * 1. SP(EdgeWeightedDigraph ewg_digraph, int s)
 * 2. double distTo(int v)
 * 3. boolean hasPathTo(int v)
 * 4. Iterable<DirectedEdge> pathTo(int v)
 */
public class SP {
    public SP(EdgeWeightedDigraph ewg_digraph, int s) {

    }

    public double distTo(int v) {
        return 0.0;
    }

    public boolean hasPathTo(int v) {
        return false;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        return null;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("tinyEWG.txt"));
            EdgeWeightedDigraph ewg_digraph = new EdgeWeightedDigraph(scanner);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
