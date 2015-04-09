package lecture14;

public class UseMyStack {
	public static void main(final String[] args) {
		try {
			MyStack myStack = new MyStack(-123);
			myStack.push(1);
			myStack.push(2);
			myStack.push(3);
			myStack.push(4);
			myStack.push(5);
			while (!myStack.isEmty()) {
				System.out.println(myStack.pop());
			}
		} catch(StackEmptyException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		// myStack.print();
	}
}
