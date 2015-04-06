package lecture11_nestedClasses;

public class D { // outer
	static class S {
		D d;

		public S(final D d) {
			this.d = d;
		}

		void print() {
			System.out.println(d._state);
		}
	}

	int _state;
	S s;

	public D() {
		s = new S(this);
		s.d = this;
	}

}
