import java.util.Iterator;

/**
 * Created by lyz on 15-1-28.
 * My queue built by linked list.
 */
public class MyQueue<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int count;

    private class Node {
        T item;
        Node next;
    }

    public void enqueue(T t_item) {
        Node old_last = last;
        last = new Node();
        last.item = t_item;
        last.next = null;
        if(isEmpty())
            first = last;
        else
            old_last.next = last;
        ++count;
    }

    public T dequeue() {
        T t_item = first.item;
        first = first.next;
        --count;
        if(isEmpty())
            last = null;
        return t_item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public String toString() {
        Iterator<T> queue_iterator = iterator();
        String ret_string = "";
        while (queue_iterator.hasNext()) {
            ret_string += queue_iterator.next() + "\t";
        }
        return ret_string;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T t_item = current.item;
            current = current.next;
            return t_item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        MyQueue<String> my_queue = new MyQueue<String>();
        my_queue.enqueue("be");
        my_queue.enqueue("or");
        my_queue.enqueue("not");
        my_queue.enqueue("to");
        my_queue.enqueue("be");
        StdOut.println(my_queue);
        StdOut.println(my_queue);
        my_queue.dequeue();
        my_queue.dequeue();
        my_queue.dequeue();
        StdOut.println(my_queue);
    }
}
