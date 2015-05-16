package Gra.Brez;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
	public static void main(final String[] args) throws IOException {
		BufferedImage img = new BufferedImage(256, 256,
				BufferedImage.TYPE_INT_RGB);
		int r = 255;// red component 0...255
		int g = 0;// green component 0...255
		int b = 0;// blue component 0...255
		int col = (r << 16) | (g << 8) | b;
		img.setRGB(128, 128, col);
		ImageIO.write(img, "PNG", new File("/tmp/MyFile.png"));
		
		Graphics gra = img.getGraphics();
	}
}
