package BoxBlur;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ThreadBlur extends Thread{
	public ThreadBlur(BufferedImage inputImage, BufferedImage outputImage, int yCoordStart, int yCoordEnd, int radius) {
		for(int yCoord = yCoordStart; yCoord < yCoordEnd; yCoord++) {
			for (int xCoord = 0; xCoord < inputImage.getWidth(); xCoord++) {
				int redValue = 0;
				int greenValue = 0;
				int blueValue = 0;
				int totPixel = 0;

				for(int internalYCoord = radius * -1; internalYCoord < radius + 1; internalYCoord ++){
					for(int internalXCoord = radius * -1; internalXCoord < radius + 1; internalXCoord ++){
						if (internalXCoord == 0 && internalYCoord == 0) continue; // se sono nello stesso pixel di partenza
						int neighboorYCoord = yCoord + internalYCoord;
						if(neighboorYCoord < 0 || neighboorYCoord >= inputImage.getHeight()) continue; // se la coordinata Y è fuori
						int neighboorXCoord = xCoord + internalXCoord;
						if(neighboorXCoord < 0 || neighboorXCoord >= inputImage.getWidth()) continue; // se la coordinata X è fuori

						Color colorTemp = new Color(inputImage.getRGB(neighboorXCoord, neighboorYCoord));
						redValue += colorTemp.getRed();
						greenValue += colorTemp.getGreen();
						blueValue += colorTemp.getBlue();
						totPixel ++;
					}
				}

				redValue = redValue / totPixel;
				greenValue = greenValue / totPixel;
				blueValue = blueValue / totPixel;
				Color color = new Color(redValue, greenValue, blueValue	);
				outputImage.setRGB(xCoord, yCoord, color.getRGB());
			}
		}
	}
}
