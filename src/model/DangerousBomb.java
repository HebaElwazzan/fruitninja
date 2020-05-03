package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import loader.ResourceLoader;

public class DangerousBomb extends Bomb{

	public DangerousBomb() {
		super();
		setImageView();
	}

	@Override
	public BufferedImage[] getBufferedImages() throws IOException {
		BufferedImage [] fruitImages = new BufferedImage[2];
		fruitImages[0] = new BufferedImage(240, 240, BufferedImage.TYPE_4BYTE_ABGR);
		fruitImages[1] = new BufferedImage(240, 240, BufferedImage.TYPE_4BYTE_ABGR);
		fruitImages[0] = ImageIO.read(ResourceLoader.load("/images/dangerousBomb.png"));
		fruitImages[1] = ImageIO.read(ResourceLoader.load("/images/bombDetonated.png"));
		return fruitImages;
	}

}
