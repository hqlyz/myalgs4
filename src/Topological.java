import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lyz on 15-2-5.
 * 拓扑排序
 * API:
 * 1. Topological(Digraph digraph)
 * 2. Iterable<Integer> order;
 * 3. boolean isDAG()
 */
public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph digraph) {
        DirectedCycle directed_cycle = new DirectedCycle(digraph);
        if(!directed_cycle.hasCycle()) {
            DepthFirstOrder depth_first_order = new DepthFirstOrder(digraph);
            order = depth_first_order.reverserPost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    // 是否为有向无环图
    public boolean isDAG() {
        return order != null;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("mediumG.txt"));
            Digraph digraph = new Digraph(scanner);
            Topological topological = new Topological(digraph);
            StdOut.println(topological.isDAG());
            int count = 0;
            for(int i : topological.order()) {
                if(++count % 20 == 0)
                    StdOut.println();
                StdOut.print(i + "\t");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
