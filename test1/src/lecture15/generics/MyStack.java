package lecture15.generics;

import java.util.Iterator;

public class MyStack<T> implements Iterable {

	private static final int INITIAL_CAPACITY = 10;
	private T[] items;
	private int tos;

	public MyStack() {
		items = (T[]) new Object[INITIAL_CAPACITY];
		tos = -1;
	}

	public boolean isEmpty() {
		return -1 == tos;
	}

	private void changeCapacity(final int new_cap) {
		System.out.println("change cap to:" + new_cap);
		T[] temp = (T[]) new Object[new_cap];
		System.arraycopy(items, 0, temp, 0, tos + 1);
		items = temp;
	}

	public void push(final T o) {
		if (tos == items.length - 1) {
			changeCapacity(items.length * 2);
		}
		items[++tos] = o;
	}

	public T top() {
		return isEmpty() ? null : items[tos];
	}

	public T pop() {

		if (tos < items.length / 4 && items.length > INITIAL_CAPACITY) {
			changeCapacity(items.length / 2);
		}

		return isEmpty() ? null : items[tos--];
	}

	@Override
	public Iterator iterator() {
		return new Iterator() {
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Object next() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub

			}
		};
	}
}
