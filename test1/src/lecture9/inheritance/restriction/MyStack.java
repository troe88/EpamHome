package lecture9.inheritance.restriction;

import java.util.ArrayDeque;

public class MyStack extends ArrayDeque{
	@Override
	public void addLast(final Object e) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Object removeFirst() {
		throw new UnsupportedOperationException();
	}
}
