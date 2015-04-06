package lecture11_linkedList.nasted;

public class UseList {
	public static void main(final String[] args) {
		LinkedList list = new LinkedList();
		list.add("ONE");
		list.add("TWO");
		list.add("THERE");

		for (Object item : list) {
			System.out.println(item);
		}

	}
}
