import java.util.NoSuchElementException;

public class TryStack {
    public static void main(String args[]) {
        IStack<String> stack = new SimpleStack<String>();
        stack.push("element1");
        stack.push("element2");

        printStackTop(stack);

        stack.pop();

        printStackTop(stack);

        stack.pop();

        try {
            stack.peek();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        try {
            stack.pop();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        System.out.println(stack.size());

    }

    private static void printStackTop(IStack<String> stack) {

        System.out.println(stack.peek());

    }
}
