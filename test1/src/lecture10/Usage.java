package lecture10;

public class Usage {
	public static void main(final String[] args) {
		C c = new C();
		c.use();
		
		B b = new B();
		b.use();
		b.setWorker(new A());
		b.use();
		b.setWorker(new Multiplier());
		
		A a = new A();
		Changeable ch = a;
		
		a = (A)ch;
		
		
		
	}
}
