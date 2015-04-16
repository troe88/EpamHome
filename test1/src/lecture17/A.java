package lecture17;

import javax.management.RuntimeErrorException;

public class A {
	public static void main(final String[] args) {
		B a = new B();
		a.a = 0;	
	}

	public A() throws Exception{
		// TODO Auto-generated constructor stub
		throw new RuntimeErrorException(null, "qwe");
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
}
