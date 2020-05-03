package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import loader.ResourceLoader;

public class Banana extends Fruit{


	public Banana() {
		super();
		setImageView();
	}
	
	@Override
	public BufferedImage[] getBufferedImages() throws IOException {
		BufferedImage [] fruitImages = new BufferedImage[2];
		fruitImages[0] = new BufferedImage(240, 240, BufferedImage.TYPE_4BYTE_ABGR);
		fruitImages[1] = new BufferedImage(240, 240, BufferedImage.TYPE_4BYTE_ABGR);
		fruitImages[0] = ImageIO.read(ResourceLoader.load("/images/banana.png"));
		fruitImages[1] = ImageIO.read(ResourceLoader.load("/images/slicedBanana.png"));
		return fruitImages;
	}

}
