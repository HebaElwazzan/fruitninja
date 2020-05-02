package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Apple extends Fruit{
	
	public Apple() {
		super();
		setImageView();
	}

	@Override
	public BufferedImage[] getBufferedImages() throws IOException {
		BufferedImage [] fruitImages = new BufferedImage[2];
		fruitImages[0] = new BufferedImage(240, 240, BufferedImage.TYPE_4BYTE_ABGR);
		fruitImages[1] = new BufferedImage(240, 240, BufferedImage.TYPE_4BYTE_ABGR);
		String path = System.getProperty("user.dir") + "/resources/images/apple.png";
		File image = new File(path);
		fruitImages[0] = ImageIO.read(image);
		path = System.getProperty("user.dir") + "/resources/images/slicedApple.png";
		image = new File(path);
		fruitImages[1] = ImageIO.read(image);
		return fruitImages;
	}

}
