public interface IList<T> extends Iterable<T> {
    public void add(T element);

    public T get(Integer index);

    public T delete(Integer index);

    public Integer size();
}
