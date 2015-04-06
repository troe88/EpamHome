package Lecture13.Exseption;

import java.util.Iterator;

public class MyStack implements Iterable{

	private Object[] items;
	private int tos; // top of stack

	public MyStack(final int capacity) throws MyStackFullExseption {
		if (capacity < 1){
//			throw new IllegalArgumentException("Stack capasity must be > 0");
			throw new MyStackFullExseption("Stack capasity must be > 0");
		}
		items = new Object[capacity];
		tos = -1;
	}

	public boolean isEmty() {
		return -1 == tos;
	}

	public void push(final Object o) {
		if (tos== items.length - 1) {
			Object[] temp = new Object[items.length];
			System.arraycopy(items, 0, temp, 0, items.length);
			items = new Object[items.length * 2];
			System.arraycopy(temp, 0, items, 0, temp.length);
		}

		items[++tos] = o;
	}

	public Object top() {
		if (-1 == tos)
			throw new IllegalAccessError("Stack is empty");
		return items[tos];
	}

	public Object pop() {
		if (-1 == tos)
			throw new IllegalAccessError("Stack is empty");

		Object temp = items[tos];
		items[tos--] = null;
		return temp;
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
