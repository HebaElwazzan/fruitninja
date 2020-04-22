package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Banana extends NormalFruit{


	@Override
	public BufferedImage[] getBufferedImages() throws IOException {
		BufferedImage [] fruitImages = new BufferedImage[2];
		fruitImages[0] = new BufferedImage(240, 240, BufferedImage.TYPE_4BYTE_ABGR);
		fruitImages[1] = new BufferedImage(240, 240, BufferedImage.TYPE_4BYTE_ABGR);
		File image = new File("banana.png");
		fruitImages[0] = ImageIO.read(image);
		image = new File("slicedBanana.png");
		fruitImages[1] = ImageIO.read(image);
		return fruitImages;
	}

}
