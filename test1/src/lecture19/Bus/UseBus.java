package lecture19.Bus;

public class UseBus {
	public static void main(final String[] args) {
		Bus bus = new Bus();
		new A(bus);
		A a1 = new A(bus);
		new B(bus);
		new B(bus);
		new B(bus);

		a1.change();
		
	}
}
