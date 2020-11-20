package BoxBlur;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BoxBlur {
	public static void blurImage(String inPathFile, String outPathFile, int radius){
		try {
			long startTime = System.currentTimeMillis();
			BufferedImage inputImage = ImageIO.read(new File(inPathFile)); // leggo immagine
			BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_4BYTE_ABGR); // creazione immagine output

			int numThread = Runtime.getRuntime().availableProcessors(); // leggo quanti core disponibili
			int yCoordBlock = inputImage.getHeight() / numThread;
			int yCoordStart = 0;
			int yCoordEnd = yCoordBlock;
			ArrayList<ThreadBlur> listaThread = new ArrayList<>();
			for(int i = 0; i < numThread; i ++){
				ThreadBlur threadBlur = new ThreadBlur(inputImage, outputImage,yCoordStart, yCoordEnd, radius);
				threadBlur.start();
				yCoordStart += yCoordBlock;
				yCoordEnd += yCoordBlock;
				if(yCoordEnd + yCoordBlock > inputImage.getHeight()) yCoordEnd = inputImage.getHeight();
				listaThread.add(threadBlur);
			}
			try{
				for (ThreadBlur threadBlur : listaThread) {
					threadBlur.join();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Scrittura immagine su disco
			ImageIO.write(outputImage, "png", new File(outPathFile));

			System.out.println(System.currentTimeMillis() - startTime);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
