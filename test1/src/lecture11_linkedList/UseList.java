package lecture11_linkedList;

import java.util.Iterator;

public class UseList {
	public static void main(final String[] args) {
		LinkedList list = new LinkedList();
		System.out.println("start");
		// list.print();

		list.add("ONE");
		list.add("TWO");
		list.add("THERE");

		for (Object item : list) {
			System.out.println(item);
		}

		System.out.println("19");

		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object item = it.next();
			System.out.println(item);
		}
		System.out.println("26");
		// list.print();

	}
}
