package Gra.Brez.Jarv;

public class Point2d {
	public Point2d(final int x, final int y) {
		_x = x;
		_y = y;
	}
	public int _x;
	public int _y;
	
	@Override
	public String toString() {
		String s = new String();
		s += "x: ";
		s += Integer.toString(_x);
		s += " y: ";
		s += Integer.toString(_y);
		return s;
	}
	
	int x() { return _x; }
	int y() { return _y; }
	
}
