import java.util.Iterator;

/**
 * Created by lyz on 15-1-28.
 * My stack built by linked list.
 */
public class MyStack<T> implements Iterable<T> {
    private Node first;
    private int count;

    private class Node {
        T item;
        Node next;
    }

    public void push(T t_item) {
        Node old_first = first;
        first = new Node();
        first.item = t_item;
        first.next = old_first;
        ++count;
    }

    public T pop() {
        T t_item = first.item;
        first = first.next;
        --count;
        return t_item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public String toString() {
        Iterator<T> my_iterator = iterator();
        String ret_string = "";
        while (my_iterator.hasNext()) {
            ret_string += my_iterator.next() + "\t";
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
        MyStack<String> my_stack = new MyStack<String>();
        my_stack.push("be");
        my_stack.push("or");
        my_stack.push("not");
        my_stack.push("to");
        my_stack.push("be");
        StdOut.println(my_stack);
        my_stack.pop();
        StdOut.println(my_stack);
    }
}
