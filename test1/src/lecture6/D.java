package lecture6;

public class D {

	public static D create(final int x, final int y) {
		if (x + y != 100)
			return null;

		return new D(x, y);
	}

	final private int _x;
	final private int _y;

	private D(final int x, final int y) {
		// if (x + y != 100) {
		// System.err.println("bad data!");
		// return;
		// }
		_x = x;
		_y = y;
	}

	public int getX() {
		return _x;
	}

	public int getY() {
		return _y;
	}

}
