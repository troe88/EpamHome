package Gra.Brez;

public class Context {
	static char screen[][];
	private static int _h;
	private static int _w;

	static void init(final int h, final int w) {
		_w = w;
		_h = h;
		screen = new char[_w][_h];
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				screen[i][j] = 'o';
			}
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
		screen[y][x] = '+';
	}

	static void drawLine_mod(final int x0, final int y0, final int x1, final int y1){
		int d_x = Math.abs(x1 - x0);
		int d_y = Math.abs(y1 - y0);
		float err = 0;
		float d_err = d_y;
		int y = y0;
		
		for (int x = x0; x <= x1; x++) {
			drawPoint(x, y);
			err += d_err;
			if(2 * err >= d_x){
				y += 1;
				err -= d_x;
			}
		}
		
	}
	
	static void drawLine(final int x0, final int y0, final int x1, final int y1){
		int d_x = Math.abs(x1 - x0);
		int d_y = Math.abs(y1 - y0);
		float err = 0;
		float d_err = (float)d_y / (float)d_x;
		int y = y0;
		
		for (int x = x0; x <= x1; x++) {
			drawPoint(x, y);
			err += d_err;
			if(err > 0.5f){
				y += 1;
				err -= 1.0f;
			}
		}
		
	}
	
	public static void main(final String[] args) throws InterruptedException {
		init(41, 16);
		
		int x0 = 0, y0 = 0;
		int x1 = 40, y1 = 15;
		int dy = 1;
		
		while (true) {
			System.out.print("\033[H\033[2J");
			clear();
	
			if(y0 == _w - 1)
				dy = -1;
			else if(y0 == 0)
				dy = 1;
			
			drawLine(x0, y0, x1, y1);

			y0 += dy ;
			
			draw();
			Thread.sleep(100);
//			System.exit(0);
		}

	}
}
