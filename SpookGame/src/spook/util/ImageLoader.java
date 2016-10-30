package spook.util;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage loadImage(String name)
	{
		try {
			return ImageIO.read(ImageLoader.class.getResourceAsStream("/image/"+name));
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
}
