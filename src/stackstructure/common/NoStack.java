package stackstructure.common;

public class NoStack<T> {
    private T obj;
    private NoStack<T> next;

    public NoStack() {
    }

    public NoStack(NoStack<T> next) {
        this.next = next;
    }

    public NoStack(T obj, NoStack<T> next) {
        this.obj = obj;
        this.next = next;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public NoStack<T> getNext() {
        return next;
    }

    public void setNext(NoStack<T> next) {
        this.next = next;
    }
}
