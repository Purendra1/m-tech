public interface IStack<T> {
    public void push(T element);

    public T pop();

    public T peek();

    public Integer size();
}