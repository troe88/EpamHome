package Gra.Brez;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame {
	static BufferedImage img;
	{
		try {
			int w = 256;
			int h = 256;
			img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

			long s_t = System.currentTimeMillis();
			drawLine(0, 0, w - 1, h - 1);
			System.out.println("Stand: " + (System.currentTimeMillis() - s_t));
			ImageIO.write(img, "PNG", new File("/tmp/stand.png"));

			s_t = System.currentTimeMillis();
			drawLine_mod(0, 0, w - 1, h - 1);
			System.out.println("Mod: " + (System.currentTimeMillis() - s_t));
			ImageIO.write(img, "PNG", new File("/tmp/mod.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Frame() {
		super();
	}

	static void drawLine_mod(final int x0, final int y0, final int x1,
			final int y1) {
		int d_x = Math.abs(x1 - x0);
		int d_y = Math.abs(y1 - y0);
		float err = 0;
		float d_err = d_y;
		int y = y0;

		for (int x = x0; x <= x1; x++) {
			img.setRGB(x, y, 0xff0000);
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
			img.setRGB(x, y, 0x00ff00);
			err += d_err;
			if (err > 0.5f) {
				y += 1;
				err -= 1.0f;
			}
		}

	}

	public static void main(final String[] arg) {
		Frame frame = new Frame();

		// ImageIO.write(img, "PNG", new File("/tmp/MyFile.png"));

		frame.setContentPane(new JLabel(new ImageIcon(img)));
		frame.setSize(img.getWidth() + 50, img.getHeight() + 50);
		frame.setVisible(true);
	}
}
