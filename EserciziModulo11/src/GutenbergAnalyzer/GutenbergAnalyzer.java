package GutenbergAnalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;

public class GutenbergAnalyzer {
	public static HashMap<String, int[]> libri = new HashMap<>();

	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println("Parsando i libri...");
		long startTime = System.currentTimeMillis();	// timestamp inizio

		cartellaLibri();	// leggo cartella libri

		ExecutorService pool = Executors.newFixedThreadPool(8);    // creo pull

		for (Map.Entry<String, int[]> entry : libri.entrySet()) {	// un submit per ogni libro
			ThreadLeggiLibro threadLeggiLibro = new ThreadLeggiLibro(entry.getKey());
			pool.submit(threadLeggiLibro);
		}
		pool.shutdown();
		try {
			pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
			System.out.println("Lettura finita in " + (System.currentTimeMillis() - startTime));	// stampo tempo di esecuzione

			startTime = System.currentTimeMillis();
			System.out.println("Calcolo distanza");
			for(Map.Entry<String, int[]> entryI : libri.entrySet()){
				System.out.println(System.lineSeparator() + "Distanza di " + entryI.getKey());
				for(Map.Entry<String, Double> entryJ : calcolaDistanza(entryI.getKey()).entrySet()){
					System.out.println(entryJ.toString());
				}
			}
			System.out.println("Calcolo distanza finita in " + (System.currentTimeMillis() - startTime));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static HashMap<String, Double> calcolaDistanza(String libro){
		int[] lettereLibroIn = libri.get(libro);
		HashMap<String, Double> distanzeOut = new HashMap<>();
		for (Map.Entry<String, int[]> entry : libri.entrySet()) {
			if(entry.getKey().equalsIgnoreCase(libro)) continue;
			double distanza = 0.0;
			for(int i = 0; i < lettereLibroIn.length; i ++){
				distanza = distanza + Math.pow(Math.abs(lettereLibroIn[i] - entry.getValue()[i]), lettereLibroIn.length);
			}
			distanza = Math.pow(distanza, 1.0 / (double) lettereLibroIn.length);
			distanzeOut.put(entry.getKey(), distanza);
		}

		return distanzeOut;
	}

	private static void cartellaLibri() throws IOException {
		String[] contents = new File("books").list();
		for(int i = 0; i< Objects.requireNonNull(contents).length; i++) {
			libri.put("books/" + contents[i], null);
		}
	}
}
