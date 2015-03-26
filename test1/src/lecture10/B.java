package lecture10;

public class B {
	Changeable a = new A();

	public void setWorker(final Changeable a) {
		this.a = a;
	}
	
	void use() {
		a.change();
	}
}
