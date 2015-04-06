package lecture11_linkedList;

import java.util.Iterator;

public class LinkedList implements Iterable<Object>{

	Node first;
	Node last;
	
	public void add(final Object item) {
//		first = new Node(item, first);
		
		Node fresh = new Node(item, null);
		
		if(first == null){
			first = fresh;
			last = fresh;
		} else {
			last.next = fresh;
			last = fresh;
		}
	}

	public void print() {
		Node temp = first;
		while (temp != null) {
			System.out.println(temp.item);
			temp = temp.next;
		}
	}

	@Override
	public Iterator iterator() {
		return new ListIterator(this);
	}
	
}
