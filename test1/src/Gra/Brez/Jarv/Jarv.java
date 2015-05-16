package Gra.Brez.Jarv;

import java.util.LinkedList;
import java.util.List;

///http://hardfire.ru/jarvis

public class Jarv {

	public static LinkedList<Integer> ip = new LinkedList<>();
	public static List<Point2d> p = Context.point;

	private static Integer getMaxLeft() {
		int p = 0;
		for (int i = 0; i < Context.point.size(); i++) {

		}
		return p;
	}

	public static int getFirst(){
		int first = 0;
		for (int i = 1; i < p.size(); ++i)
			if (p.get(i)._x < p.get(first)._x
					|| (p.get(i)._x == p.get(first)._x && p.get(i)._y < p
							.get(first)._y)) {
				first = i;
			}
		return first;
	}
	
	public static void calc() {
		int n = p.size();
		int first, q, next, i;
		double sign;
		// находим самую нижнюю из самых левых точек
		first = getFirst();
		q = first; // текущая точка
		do {
			ip.add(q);
			next = q;

			for (i = n - 1; i >= 0; --i) {
				if (p.get(i)._x != p.get(q)._x || p.get(i)._y != p.get(q)._y) {
					sign = areaTriangle(p.get(q), p.get(i), p.get(next));
					if (next == q
							|| sign > 0
							|| (sign == 0 && point_in_box(p.get(next),
									p.get(q), p.get(i))))
						next = i;
				}
			}
			q = next;
		} while (q != first);

	}

	private static boolean point_in_box(final Point2d p1,
			final Point2d b1, final Point2d b2) {
		return ((p1._x >= Math.min(b1._x, b2._x)) && (p1._x <= Math.max(b1._x, b2._x))
				&& (p1._y >= Math.min(b1._y, b2._y)) && (p1._y <= Math.max(b1._y, b2._y)));
	}

	private static double areaTriangle(final Point2d a, final Point2d b,
			final Point2d c) {
		return 0.5 * (a._x * b._y + b._x * c._y + c._x * a._y - a._y * b._x
				- b._y * c._x - c._y * a._x);

	}
}
