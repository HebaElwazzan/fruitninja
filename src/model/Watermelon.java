package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import loader.ResourceLoader;

public class Watermelon extends Fruit{

	public Watermelon() {
		super();
		setImageView();
	}

	@Override
	public BufferedImage[] getBufferedImages() throws IOException {
		BufferedImage [] fruitImages = new BufferedImage[2];
		fruitImages[0] = new BufferedImage(240, 240, BufferedImage.TYPE_4BYTE_ABGR);
		fruitImages[1] = new BufferedImage(240, 240, BufferedImage.TYPE_4BYTE_ABGR);
		fruitImages[0] = ImageIO.read(ResourceLoader.load("/images/watermelon.png"));
		fruitImages[1] = ImageIO.read(ResourceLoader.load("/images/slicedWatermelon.png"));
		return fruitImages;
		
		
	}

}
