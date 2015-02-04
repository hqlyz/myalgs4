import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lyz on 15-2-3.
 * API:
 * 1. BreadthFirstSearch(Graph graph, int s)
 * 2. boolean marked(int v)
 * 3. boolean hasPathTo(int v)
 * 4. Iterable<Integer> pathTo(int v)
 */
public class BreadthFirstSearch {
    private boolean[] marked;
    private int[] edge_to;
    private int s;

    public BreadthFirstSearch(Graph graph, int s) {
        marked = new boolean[graph.getV()];
        this.s = s;
        edge_to = new int[graph.getV()];
        bfs(graph, s);
    }

    private void bfs(Graph graph, int s) {
        MyQueue<Integer> my_queue = new MyQueue<Integer>();
        marked[s] = true;
        my_queue.enqueue(s);
        while(!my_queue.isEmpty()) {
            int v= my_queue.dequeue();
            for(int w : graph.adj(v)) {
                if(!marked[w]) {
                    my_queue.enqueue(w);
                    marked[w] = true;
                    edge_to[w] = v;
                }
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v))
            return null;
        MyStack<Integer> my_stack = new MyStack<Integer>();
        for(int x = v; x != s; x = edge_to[x])
            my_stack.push(x);
        my_stack.push(s);
        return my_stack;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("mediumG.txt"));
            Graph graph = new Graph(scanner);
            int s   = 0;
            BreadthFirstSearch breadth_first_search = new BreadthFirstSearch(graph, s);
            for(int i = 0; i < graph.getV(); ++i) {
                StdOut.print(s + " to " + i + ": ");
                for(int x : breadth_first_search.pathTo(i)) {
                    if(x == s)
                        StdOut.print(x);
                    else
                        StdOut.print("-" + x);
                }
                StdOut.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
