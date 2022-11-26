package stackstructure.stackinterface;

public interface IStack<T> {

    void push(T object);
    abstract T pop();
    T top();
    int size();
    boolean isEmpty();
    boolean isFull();
    void clear();
}
