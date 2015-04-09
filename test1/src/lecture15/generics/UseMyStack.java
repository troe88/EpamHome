package lecture15.generics;

public class UseMyStack {
	public static void main(final String[] args) {

		MyStack<Integer> myStack = new MyStack<Integer>();
		
		
		for (int i = 0; i < 1000; i++) {
			myStack.push(i);
		}
		
		int sum = 0;
		
		while (!myStack.isEmpty())
			sum += myStack.pop();
		
		System.out.println(sum);
	}
	

}
