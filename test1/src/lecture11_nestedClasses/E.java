package lecture11_nestedClasses;

public class E {
	class I {
		void print() {
			System.out.println(_state);
		}
	}

	I i;
	int _state;

	public E() {
		i = new I();
	}
}
