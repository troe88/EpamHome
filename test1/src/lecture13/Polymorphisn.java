package lecture13;

public class Polymorphisn {
	static class A {

	}

	static class B extends A {

	}

	static class C extends B {
		@Override
		public String toString() {

			return "qwe";
		}
	}

	public static void main(final String[] args) {
		B b = new B();
		A a = b;
		Object o = a;

		C c = new C();

		MyPrint(c);
	}

	public static void MyPrint(final A o) {
		System.out.println(o.toString());
	}

}
