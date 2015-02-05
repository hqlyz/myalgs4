/**
 * Created by lyz on 15-2-5.
 * API:
 * 1. DirectedCycle(Digraph digraph)
 * 2. boolean hasCycle()
 * 3. Iterable<Integer> cycle()
 */
public class DirectedCycle {
    private boolean[] marked;
    private boolean[] on_stack;
    private MyStack<Integer> cycle;
    private int[] edge_to;

    public DirectedCycle(Digraph digraph) {
        marked = new boolean[digraph.getV()];
        on_stack = new boolean[digraph.getV()];
        edge_to = new int[digraph.getV()];
        for(int i = 0; i < digraph.getV(); ++i) {
            if(!marked[i])
                dfs(digraph, i);
        }
    }

    private void dfs(Digraph digraph, int s) {
        marked[s] = true;
        on_stack[s] = true;
        for(int w : digraph.adj(s)) {
            if(hasCycle()) {
                return;
            } else if(!marked[w]) {
                edge_to[w] = s;
                dfs(digraph, w);
            } else if(on_stack[w]) {
                cycle = new MyStack<Integer>();
                for(int x = s; x != w; x = edge_to[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(s);
            }
        }
        on_stack[s] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
