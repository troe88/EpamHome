package lecture12;

public class A {

	String _state = "hello";

	static class B implements I {

		@Override
		public int calc() {
			return 0;
		}

	}

	public I getI() {
		return new B();
	}

	public I getAnonI() {
		return new I() {
			@Override
			public int calc() {

				System.out.println(A.this._state);

				return 0;
			}
		};
	}

	public static void main(final String[] args) {
		A a = new A();
		I i = a.getAnonI();
		i.calc();
		System.out.println(i);
	}
}
