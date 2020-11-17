package ElaboraBordiImmagine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BordiParallela {


	public static void main(String[] args) {


		long startTime = System.currentTimeMillis();
		BufferedImage inputImage = null;
		try {
			inputImage = ImageIO.read(new File("gris.png")); //caricamento immagine
		} catch (IOException e) {
		}

		BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_4BYTE_ABGR); // creazione immagine output


		ThreadImmagine t0 = new ThreadImmagine(inputImage, outputImage, 0, inputImage.getWidth() / 2, 0, inputImage.getHeight() / 2);
		ThreadImmagine t1 = new ThreadImmagine(inputImage, outputImage, 0, inputImage.getWidth() / 2, inputImage.getHeight() / 2, inputImage.getHeight());
		ThreadImmagine t2 = new ThreadImmagine(inputImage, outputImage, inputImage.getWidth() / 2, inputImage.getWidth(), 0, inputImage.getHeight() / 2);
		ThreadImmagine t3 = new ThreadImmagine(inputImage, outputImage, inputImage.getWidth() / 2, inputImage.getWidth(), inputImage.getHeight() / 2, inputImage.getHeight());

		t0.start();
		t1.start();
		t2.start();
		t3.start();

		try{
			t0.join();
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			ImageIO.write(outputImage, "png", new File("outputImage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(System.currentTimeMillis() - startTime);

	}

}
