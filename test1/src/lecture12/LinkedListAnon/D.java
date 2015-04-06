package lecture12.LinkedListAnon;

public abstract class D {

	public static D createUpper(final String init) {
		return new D(init) {
			@Override
			public void doTHomething() {
				System.out.println(state.toUpperCase());
			}
		};
	}

	public static D createLower(final String init) {
		return new D(init) {
			@Override
			public void doTHomething() {
				System.out.println(state.toLowerCase());
			}
		};
	}

	public static D createNatural(final String init) {
		return new D(init){};
	}

	String state = new String();

	public D(final String s) {
		state = s;
	}
	
	public void doTHomething() {
		System.out.println(state);
	}
}
