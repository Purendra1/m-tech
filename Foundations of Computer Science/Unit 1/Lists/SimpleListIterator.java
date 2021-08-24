import java.util.Iterator;

public class SimpleListIterator<T> implements Iterator<T> {

    private final SimpleList<T> list;
    private int cursor;

    public SimpleListIterator(SimpleList<T> list) {
        this.list = list;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return (cursor < list.size());
    }

    @Override
    public T next() {
        return list.get(cursor++);
    }

}
