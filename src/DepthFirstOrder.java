/**
 * Created by lyz on 15-2-5.
 * 有向图中基于深度优先搜索的顶点排序
 * API:
 * 1. DepthFirstOrder(Digraph digraph)
 * 2. Iterable<Integer> pre()
 * 3. Iterable<Integer> post()
 * 4. Iterable<Integer> reversePost()
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private MyQueue<Integer> pre;
    private MyQueue<Integer> post;
    private MyStack<Integer> reverse_post;

    public DepthFirstOrder(Digraph digraph) {
        marked = new boolean[digraph.getV()];
        pre = new MyQueue<Integer>();
        post = new MyQueue<Integer>();
        reverse_post = new MyStack<Integer>();
        for(int i = 0; i < digraph.getV(); ++i) {
            if(!marked[i])
                dfs(digraph, i);
        }
    }

    private void dfs(Digraph digraph, int s) {
        marked[s] = true;
        pre.enqueue(s);
        for(int w : digraph.adj(s)) {
            if(!marked[w])
                dfs(digraph, w);
        }
        post.enqueue(s);
        reverse_post.push(s);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reverserPost() {
        return reverse_post;
    }
}
