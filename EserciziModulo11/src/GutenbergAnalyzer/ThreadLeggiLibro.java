package GutenbergAnalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.Callable;

import static GutenbergAnalyzer.GutenbergAnalyzer.libri;

public class ThreadLeggiLibro implements Runnable {
	private String filePath;

	public ThreadLeggiLibro(String filePath) {
		this.filePath = filePath;
	}


	@Override
	public void run() {
		int[] out = new int[26];
		//System.out.println("Inizio file " + this.filePath);
		try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(this.filePath))){
			while (bufferedReader.ready()) {
				char[] linea = bufferedReader.readLine().toLowerCase().toCharArray();
				for (char c : linea) {
					if((int) c >= 97 && (int) c <= 122){
						int index = (int) c - 97;
						out[index] ++;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		synchronized (libri) {
			libri.put(filePath, out);
		}
		//System.out.println("Fine file " + this.filePath);

	}
}
