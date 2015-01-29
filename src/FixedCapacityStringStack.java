/**
 * Created by lyz on 15-1-27.
 * Abstract Data Type for 'FixedCapacityStringStack'
 */
public class FixedCapacityStringStack {
    private String[] a;
    private int count;

    public FixedCapacityStringStack(int capacity) {
        a = new String[capacity];
        count = 0;
    }

    public void push(String str) {
        if(size() < a.length)
            a[count++] = str;
    }

    public String pop() {
        if(count >= 1)
            return a[--count];
        return null;
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

    public static void main(String[] args) {
        FixedCapacityStringStack fixed_string_stack = new FixedCapacityStringStack(5);
        for(int i = 0; i < 10; ++i) {
            fixed_string_stack.push("" + i);
        }
        fixed_string_stack.pop();
//        fixed_string_stack.pop();
        StdOut.println(fixed_string_stack);
    }
}
