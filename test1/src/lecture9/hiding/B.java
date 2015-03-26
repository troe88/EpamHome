package lecture9.hiding;


public class B extends A {
	int _state1 = 0;

	@Override
	public void change() {
		_state1 += 2;
	}
	
	public static void main(final String[] args) {
		B b = new B();
		System.out.println(b._state1);

		b.change();

		System.out.println(b.getState());

	}
}
