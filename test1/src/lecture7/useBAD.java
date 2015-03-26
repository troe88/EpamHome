package lecture7;

import lecture7.other.D;

public class useBAD {
	public static void main(final String[] args) {
		A a = new A();
		a.change();
		System.out.println(a.state);
		
		B b = new B();
		b.change();
		System.out.println(b.state);
		
		D d = new D();
		d.change();
		System.out.println(d.get());
	}
}
