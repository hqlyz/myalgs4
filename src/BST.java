import java.util.HashSet;
import java.util.Queue;

/**
 * Created by lyz on 15-2-2.
 * 1. Value get(Key key)
 * 2. void put(Key key, Value value)
 * 3. int size()
 * 4. int size(Node x)
 * 5. Key max()
 * 6. Key min()
 * 7. Key floor()
 * 8. Key ceiling()
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if(x == null)
            return 0;
        return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            return get(x.left, key);
        else if(cmp > 0)
            return get(x.right, key);
        else
            return x.value;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if(x == null)
            return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            x.left = put(x.left, key, value);
        else if(cmp > 0)
            x.right = put(x.right, key, value);
        else
            x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if(x == null)
            return null;
        if(x.left == null)
            return x;
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if(x == null)
            return null;
        if(x.right == null)
            return x;
        return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if(x == null)
            return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)
            return x;
        if(cmp < 0)
            return floor(x.left, key);
        Node t = floor(x.right, key);
        if(t != null)
            return t;
        else
            return x;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if(x == null)
            return null;
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)
            return x;
        if(cmp > 0)
            return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if(t != null)
            return t;
        else
            return x;
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if(x == null)
            return null;
        int t = size(x.left);
        if(t > k)
            return select(x.left, k);
        else if(t < k)
            return select(x.right, k - t -1);
        else
            return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if(x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            return rank(key, x.left);
        else if(cmp > 0)
            return 1 + size(x.left) + rank(key, x.right);
        else
            return size(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if(x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp > 0)
            x.right = delete(x.right, key);
        else if(cmp < 0)
            x.left = delete(x.left, key);
        else {
            if(x.right == null)
                return x.left;
            if(x.left == null)
                return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private void print(Node x) {
        if(x == null)
            return;
        if(x.left != null)
            print(x.left);
        StdOut.print(x.key + " ");
        print(x.right);
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key low, Key high) {
        MyQueue<Key> my_queue = new MyQueue<Key>();
        keys(root, my_queue, min(), max());
        return my_queue;
    }

    private void keys(Node x, MyQueue<Key> queue, Key low, Key high) {
        if(x == null)
            return;
        int cmp_low = low.compareTo(x.key);
        int cmp_high = high.compareTo(x.key);
        if(cmp_low < 0)
            keys(x.left, queue, low, high);
        if(cmp_low <= 0 && cmp_high >= 0)
            queue.enqueue(x.key);
        if(cmp_high > 0)
            keys(x.right, queue, low, high);
    }

    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<String, Integer>();
        bst.put("J", 1);
        bst.put("B", 2);
        bst.put("A", 3);
        bst.put("H", 4);
        bst.put("T", 5);
        bst.put("V", 6);
        bst.put("C", 7);
        StdOut.println(bst.size() + "");
        StdOut.println(bst.get("A") + "");
        StdOut.println(bst.get("B") + "");
        StdOut.println(bst.max() + "");
        bst.print(bst.root);
        StdOut.println();
        Iterable<String> keys_array = bst.keys();
        for(String str : keys_array)
            StdOut.print(str + " ");
    }
}
