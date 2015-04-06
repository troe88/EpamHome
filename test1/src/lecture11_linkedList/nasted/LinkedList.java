package lecture11_linkedList.nasted;

import java.util.Iterator;

public class LinkedList implements Iterable<Object> {

	private static class Node {
		Object _item;
		Node _next;

		public Node(final Object item, final Node next) {
			this._item = item;
			this._next = next;
		}

	}
	
	private static class ListIterator implements Iterator<Object> {

		private LinkedList _linkedList;
		private Node tmp;

		public ListIterator(final LinkedList linkedList) {
			_linkedList = linkedList;
			tmp = _linkedList.first;
		}

		@Override
		public boolean hasNext() {
			return tmp != null;
		}

		@Override
		public Object next() {
			Object item = tmp._item;
			tmp = tmp._next;
			return item;
		}

		@Override
		public void remove() {
		}

	}
	
	Node first;
	Node last;

	public void add(final Object item) {
		Node fresh = new Node(item, null);
		if (first == null) {
			first = fresh;
			last = fresh;
		} else {
			last._next = fresh;
			last = fresh;
		}
	}

	@Override
	public Iterator<Object> iterator() {
		return new ListIterator(this);
	}

}
