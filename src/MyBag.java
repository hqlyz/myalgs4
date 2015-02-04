import java.util.Iterator;

/**
 * Created by lyz on 15-2-3.
 * API:
 * 1. MyBag()
 * 2. void add(T item)
 * 3. boolean isEmpty()
 * 4. int size()
 */
public class MyBag<T> implements Iterable<T> {
    private int N;
    private Node first;

    private class Node {
        T item;
        Node next;
    }
    public MyBag() {
        N = 0;
        first = null;
    }

    public void add(T item) {
        Node old_first = first;
        first = new Node();
        first.item = item;
        first.next = old_first;
        ++N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;

        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        MyBag<Integer> my_bag = new MyBag<Integer>();
        my_bag.add(2);
        my_bag.add(5);
        my_bag.add(8);
        for (Integer aMy_bag : my_bag) {
            StdOut.print(aMy_bag + "\t");
        }
    }
}
