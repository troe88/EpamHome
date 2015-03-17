package lecture6;

public class C {

	// pass ref by val
	private int _state = 0;

	public C(final int init_state) {
		_state = init_state;
		// TODO Auto-generated constructor stub
	}

	public static void main(final String[] args) {
		C c1 = new C(10);
		C c2 = c1;

		proc(c1);

		System.out.println(c1._state);
	}

	private static void proc(final C c) {
		// c = new C(30);
		c._state = 10;
	}

}
