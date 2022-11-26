package stackstructure.stack;

import stackstructure.common.NoStack;
import stackstructure.stackinterface.IStack;

public class LinkedStackImpl<T> implements IStack<T> {
    private NoStack<T> top;
    private NoStack<T> first;
    private int counter;

    public LinkedStackImpl() {
    	this.clear();
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

	@Override
    public void push(T obj) {
        if (this.isEmpty()) {
        	this.first = new NoStack<>();
        	this.top = new NoStack<>();

            this.first.setObj(obj);
            this.top = this.first;
        } else {
            this.top.setNext(new NoStack<>(obj, null));
            this.top = this.top.getNext();
        }
        this.counter++;
    }

	@Override
	public T pop() {
		T result = this.top.getObj();

        if (this.counter > 1) {
        	NoStack<T> aux = this.first;
        	for (int i = 0; i < this.counter - 2; i++) {
        		aux = aux.getNext();
        	}
        	this.top = aux;
        	this.top.setNext(null);
        } else {
        	this.clear();
        }
        this.counter--;
        return result;
	}

	@Override
	public T top() {
		return this.top.getObj();
	}

	@Override
	public int size() {
		return this.counter;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public void clear() {
        this.top = null;
        this.first = null;
        this.counter = 0;
	}
}