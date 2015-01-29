/**
 * Created by lyz on 15-1-27.
 *
 */
public class FixedCapacityGenericStack<T> {

    private T[] a;
    private int count;

    public FixedCapacityGenericStack(int capacity) {
        a = (T[])new Object[capacity];
        count = 0;
    }

    public void push(T str) {
        if(count == a.length)
            resize(2 * a.length);
        a[count++] = str;
    }

    public T pop() {
        T ret_value = a[--count];

        a[count] = null;
        if (count > 0 && count <= a.length / 4)
            resize(a.length / 2);

        return ret_value;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public String toString() {
        String result = "";
        for(int i = 0; i < count; ++i)
            result += a[i] + "\t";
        return result;
    }

    private void resize(int max) {
        T[] temp = (T[])new Object[max];
        for(int i = 0; i < count; ++i) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public static void main(String[] args) {
        FixedCapacityGenericStack<String> fixed_string_stack = new FixedCapacityGenericStack<String>(5);
        for(int i = 0; i < 10; ++i) {
            fixed_string_stack.push("" + i);
        }
        fixed_string_stack.pop();
        fixed_string_stack.pop();
        StdOut.println(fixed_string_stack.size());
        StdOut.println(fixed_string_stack);
        fixed_string_stack.pop();
        fixed_string_stack.pop();
        StdOut.println(fixed_string_stack.size());
        StdOut.println(fixed_string_stack);
        fixed_string_stack.pop();
        fixed_string_stack.pop();
        StdOut.println(fixed_string_stack.size());
        StdOut.println(fixed_string_stack);
    }
}
