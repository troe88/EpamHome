package lecture9.inheritance_vs_composition;

public class D {
	A a;

	public D(final A a) {
		this.a = a;
	}

	public void set(final A a) {
		this.a = a;
	}

	public void use() {
		a.change();
		System.out.println(a.getState());
	}

}
