package ElaboraBordiImmagine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BordiParallela {


	public static void main(String[] args) {


		long startTime = System.currentTimeMillis();
		BufferedImage inputImage = null;
		try {
			inputImage = ImageIO.read(new File("gris.png")); //caricamento immagine
		} catch (IOException e) {
		}

		BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_4BYTE_ABGR); // creazione immagine output

		// Test divisione dinamica
		int numThread = 50; // Usare variabile numThread per variare il numero di Thread da far partire
		int heightPart = inputImage.getHeight() / numThread;
		int heigthStart = 0;
		int heigthEnd = heightPart;
		ArrayList<ThreadImmagine> listaThread = new ArrayList<>();
		for(int i = 0; i < numThread; i ++){
			ThreadImmagine threadImmagine = new ThreadImmagine(inputImage, outputImage,heigthStart, heigthEnd);
			threadImmagine.start();
			heigthStart += heightPart;
			heigthEnd += heightPart;
			if(heigthEnd + heightPart > inputImage.getHeight()) heigthEnd = inputImage.getHeight();
			listaThread.add(threadImmagine);
		}
		try{
			for (ThreadImmagine threadImmagine : listaThread) {
				threadImmagine.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Scrittura immagine su disco
		try {
			ImageIO.write(outputImage, "png", new File("outputImage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(System.currentTimeMillis() - startTime);

	}

}
