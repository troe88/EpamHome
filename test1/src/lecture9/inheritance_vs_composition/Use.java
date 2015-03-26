package lecture9.inheritance_vs_composition;

public class Use {
	public static void main(final String[] args) {
		B b = new B();
		b.use();
		
		D d1 = new D(new A());
		d1.use();
		d1.set(new Y());
		d1.use();
	}
}
