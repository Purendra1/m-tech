import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleList<T> implements IList<T> {

    private Node<T> head;
    private Node<T> tail;
    private Integer size;

    public SimpleList() {
        this.size = 0;
        this.head = this.tail = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleListIterator<>(this);
    }

    @Override
    public void add(T element) {

        final Node<T> node = new Node<T>(element);

        if (this.head == null) {
            this.head = this.tail = node;
        } else if (this.head.getNext() == null) {
            this.head.setNext(node);
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }

        this.size++;
    }

    @Override
    public T get(Integer index) {

        if (index >= this.size) {
            throw new NoSuchElementException(String.format(
                    "Lists has lesser elements than expected. Expected [%d] index, Size = [%d]", index, this.size));
        }

        Node<T> element = this.head;

        for (int loopIdx = 0; loopIdx < index; loopIdx++) {
            element = element.getNext();
        }

        return element.getData();
    }

    @Override
    public T delete(Integer index) {

        if (index >= this.size) {
            throw new NoSuchElementException(String.format(
                    "Lists has lesser elements than expected. Expected [%d] index, Size = [%d]", index, this.size));
        }

        T element;

        if (index == 0) {

            element = this.head.getData();

            if (this.head == this.tail) {
                this.head = this.tail = null;
            } else {
                this.head = this.head.getNext();
            }
        } else {

            Node<T> node = this.head;

            for (int loopIdx = 1; loopIdx < index; loopIdx++) {
                node = node.getNext();
            }

            element = node.getNext().getData();

            if (node.getNext() == this.tail) {
                node.setNext(null);
                tail = node;
            } else {
                node.setNext(node.getNext().getNext());
            }
        }

        this.size--;

        return element;
    }

    @Override
    public Integer size() {
        return this.size;
    }

}
