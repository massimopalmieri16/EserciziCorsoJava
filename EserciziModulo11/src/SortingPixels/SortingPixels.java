package SortingPixels;

import ElaboraBordiImmagine.ThreadImmagine;
import SommaThread.ThreadSomma;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class SortingPixels {
	private static ArrayList<Color> pixels = new ArrayList<>();

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		BufferedImage inputImage = null;
		try {
			// leggo immagine
			inputImage = ImageIO.read(new File("gris.png"));

			// scorro pixel e le aggiungo a lista
			for(int row = 0; row < inputImage.getHeight(); row++)
				for(int col = 0; col < inputImage.getWidth(); col++)
					pixels.add(new Color(inputImage.getRGB(col, row)));

			pixels = mergeSortPixel(pixels);
			// TODO da finire mergesort parallelo
			//pixels = mergeSortPixelThread(pixels);

			if(!pixels.isEmpty()) {
				BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_4BYTE_ABGR); // creazione immagine output
				int indexPixels = 0;
				for (int row = 0; row < inputImage.getHeight(); row++)
					for (int col = 0; col < inputImage.getWidth(); col++) {
						outputImage.setRGB(col, row, pixels.get(indexPixels).getRGB());
						indexPixels++;
					}
				ImageIO.write(outputImage, "png", new File("sortedpixels_out.png"));
			}
			System.out.println("Tempo esecuzione " + (System.currentTimeMillis() - startTime));


		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static ArrayList<Color> mergeSortPixelThread(ArrayList<Color> pixels){
		if(pixels.size() == 1)
			return pixels;

		int centro = pixels.size() / 2;

		ThreadMergeSortPixel threadSinistra = new ThreadMergeSortPixel(new ArrayList<>(pixels.subList(0, centro)));
		ThreadMergeSortPixel threadDestra = new ThreadMergeSortPixel(new ArrayList<>(pixels.subList(centro, pixels.size())));
		threadSinistra.start();
		threadDestra.start();

		try{
			threadSinistra.join();
			threadDestra.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ArrayList<Color> sinistra = new ArrayList<>();
		ArrayList<Color> destra =  new ArrayList<>();


		return SortingPixels.merge(destra, sinistra);
	}

	private static ArrayList<Color> mergeSortPixel(ArrayList<Color> pixels){
		if(pixels.size() == 1)
			return pixels;

		int centro = pixels.size() / 2;

		ArrayList<Color> sinistra = new ArrayList<>(pixels.subList(0, centro));
		ArrayList<Color> destra = new ArrayList<>(pixels.subList(centro, pixels.size()));
		sinistra = mergeSortPixel(sinistra);
		destra = mergeSortPixel(destra);

		return merge(destra, sinistra);
	}

	public static ArrayList<Color> merge(ArrayList<Color> destra, ArrayList<Color> sinistra){
		ArrayList<Color> pixels = new ArrayList<>();
		int i = 0;
		int j = 0;
		while(i < sinistra.size() && j < destra.size()){
			if((sinistra.get(i).getRed() + sinistra.get(i).getGreen() + sinistra.get(i).getBlue()) < (destra.get(j).getRed() + destra.get(j).getGreen() + destra.get(j).getBlue())){
				pixels.add(sinistra.get(i));
				i++;
			}else{
				pixels.add(destra.get(j));
				j++;
			}
		}

		while (i < sinistra.size()){
			pixels.add(sinistra.get(i));
			i++;
		}

		while (j < destra.size()){
			pixels.add(destra.get(j));
			j++;
		}
		return pixels;
	}
}
