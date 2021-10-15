import java.util.NoSuchElementException;

public class SimpleStack<T> implements IStack<T> {

    private Node<T> head;
    private Integer size;

    public SimpleStack() {
        this.size = 0;
        this.head = null;
    }

    @Override
    public void push(T element) {

        final Node<T> node = new Node<T>(element);

        if (head == null) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }

        this.size++;
    }

    @Override
    public T peek() {

        if (this.size <= 0) {
            throw new NoSuchElementException("The stack is empty");
        }

        Node<T> element = this.head;

        return element.getData();
    }

    @Override
    public T pop() {

        if (this.size <= 0) {
            throw new NoSuchElementException(String.format("No elements in stack"));
        }

        T element = head.getData();

        head = head.getNext();

        this.size--;

        return element;
    }

    @Override
    public Integer size() {
        return this.size;
    }
}
