package Gra.Brez.Jarv;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Context {
	static char screen[][];
	private static int _h;
	private static int _w;
	static List<Point2d> point;

	static void init(final int h, final int w) {
		_w = w;
		_h = h;
		screen = new char[_w][_h];
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				screen[i][j] = 'o';
			}
		}

		point = new LinkedList<>();

		Random random = new Random();

		int min = 3;

//		point = Arrays.asList(new Point2d(0, 0), new Point2d(14, 4),
//				new Point2d(20, 14));

		for (int i = 0; i < 25; i++) {
			int r_x = random.nextInt((_h - 5 - min) + 1) + min;
			int r_y = random.nextInt((_w - 5 - min) + 1) + min;

			point.add(new Point2d(r_x, r_y));
		}
	}

	public static void draw() {
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				System.out.print(screen[i][j]);
			}
			System.out.println();
		}
	}

	public static void clear() {
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				screen[i][j] = '.';
			}
		}
	}

	static void drawPoint(final int x, final int y) {
		if (y >= _w || x >= _h || x < 0 || y < 0)
			return;
		screen[y][x] = '*';
	}

	static void drawPoint(final int x, final int y, final char t) {
		if (y >= _w || x >= _h || x < 0 || y < 0)
			return;
		screen[y][x] = t;
	}

	static void drawPoint(final Point2d point1) {
		if (point1._y >= _w || point1._x >= _h || point1._x < 0
				|| point1._y < 0)
			return;
		screen[point1._y][point1._x] = '*';
	}

	static void drawPoint(final Point2d point1, final char t) {
		if (point1._y >= _w || point1._x >= _h || point1._x < 0
				|| point1._y < 0)
			return;
		screen[point1._y][point1._x] = t;
	}

	private static int sign(final int x) {
		return (x > 0) ? 1 : (x < 0) ? -1 : 0;
	}

	public static void drawBresenhamLine(final int x0, final int y0,
			final int x1, final int y1)
	{
		int x, y, dx, dy, incx, incy, pdx, pdy, es, el, err;
		dx = x1 - x0;
		dy = y1 - y0;
		incx = sign(dx);
		/* Если dx < 0, т.е.
		 * отрезок идёт справа налево по иксу, то incx будет равен -1. Это будет
		 * использоваться в цикле постороения.
		 */
		incy = sign(dy);
		/*
		 * Аналогично. Если рисуем отрезок снизу вверх - это будет отрицательный
		 * сдвиг для y (иначе - положительный).
		 */
		if (dx < 0)
			dx = -dx;// далее мы будем сравнивать: "if (dx < dy)"
		if (dy < 0)
			dy = -dy;// поэтому необходимо сделать dx = |dx|; dy = |dy|
		// эти две строчки можно записать и так: dx = Math.abs(dx); dy =
		// Math.abs(dy);
		if (dx > dy)
		// определяем наклон отрезка:
		{
			/*
			 * Если dx > dy, то значит отрезок "вытянут" вдоль оси икс, т.е. он
			 * скорее длинный, чем высокий. Значит в цикле нужно будет идти по
			 * икс (строчка el = dx;), значит "протягивать" прямую по иксу надо
			 * в соответствии с тем, слева направо и справа налево она идёт (pdx
			 * = incx;), при этом по y сдвиг такой отсутствует.
			 */
			pdx = incx;
			pdy = 0;
			es = dy;
			el = dx;
		} else// случай, когда прямая скорее "высокая", чем длинная, т.е.
				// вытянута по оси y
		{
			pdx = 0;
			pdy = incy;
			es = dx;
			el = dy;// тогда в цикле будем двигаться по y
		}
		x = x0;
		y = y0;
		err = el / 2;
		drawPoint(x, y, '@');
		// все последующие точки возможно надо сдвигать, поэтому первую ставим
		// вне цикла
		for (int t = 0; t < el; t++)// идём по всем точкам, начиная со второй и
									// до последней
		{
			err -= es;
			if (err < 0) {
				err += el;
				x += incx;// сдвинуть прямую (сместить вверх или вниз, если цикл
							// проходит по иксам)
				y += incy;// или сместить влево-вправо, если цикл проходит по y
			} else {
				x += pdx;// продолжить тянуть прямую дальше, т.е. сдвинуть влево
							// или вправо, если
				y += pdy;// цикл идёт по иксу; сдвинуть вверх или вниз, если по
							// y
			}
			drawPoint(x, y, '@');
		}
	}

	static void drawLine_mod(final int x0, final int y0, final int x1,
			final int y1) {
		int d_x = Math.abs(x1 - x0);
		int d_y = Math.abs(y1 - y0);
		float err = 0;
		float d_err = d_y;
		int y = y0;

		for (int x = x0; x <= x1; x++) {
			drawPoint(x, y);
			err += d_err;
			if (2 * err >= d_x) {
				y += 1;
				err -= d_x;
			}
		}

	}

	static void drawLine(final int x0, final int y0, final int x1, final int y1) {
		int d_x = Math.abs(x1 - x0);
		int d_y = Math.abs(y1 - y0);
		float err = 0;
		float d_err = (float) d_y / (float) d_x;
		int y = y0;

		for (int x = x0; x <= x1; x++) {
			drawPoint(x, y, '@');
			err += d_err;
			if (err >= 0.5f) {
				y += 1;
				err -= 1.0f;
			}
		}

	}

	public static void main(final String[] args) throws InterruptedException {
		init(60, 20);

		while (true) {
			System.out.print("\033[H\033[2J");
			System.out.println();
			clear();

			// drawLine(0, 0, 40, 10);
			// drawBresenhamLine(15, 2, 20, 14);

			for (Point2d p : point) {
				drawPoint(p);
			}

			Jarv2.calc();

			for (Integer p : Jarv2.ip) {
				drawPoint(point.get(p), '#');
			}

			draw();
			Thread.sleep(100);
			System.exit(0);
		}

	}

}
