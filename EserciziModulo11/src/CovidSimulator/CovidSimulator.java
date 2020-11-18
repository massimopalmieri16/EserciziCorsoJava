package CovidSimulator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;

import static java.lang.Math.abs;

public class CovidSimulator {
	public static void main(String[] args) throws IOException {
		String fileOutput = "files_persone/output.txt";
		BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(fileOutput));

		ThreadParseFile t0 = new ThreadParseFile("files_persone/centro.txt", bufferedWriter);
		ThreadParseFile t1 = new ThreadParseFile("files_persone/nord.txt", bufferedWriter);
		ThreadParseFile t2 = new ThreadParseFile("files_persone/sud.txt", bufferedWriter);

		// start thread
		t0.start();
		t1.start();
		t2.start();

		// aspetto thread
		try {
			t0.join();
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		finally{
			bufferedWriter.close();	// chiudo canale write
		}

		checkFile();	// controllo se i due file sono uguali
	}

	public static void checkFile() {
		HashSet<String> setNew = new HashSet<>();
		HashSet<String> setOrig = new HashSet<>();

		popolaSet(setNew, "files_persone/output.txt");
		popolaSet(setOrig, "files_persone/output_orig.txt");

		System.out.println("Size new file: " + setNew.size());
		if(setNew.size() != setOrig.size()){
			System.out.println("I file contengono numeri diversi di ID");
		}else {
			setNew.retainAll(setOrig);
			if (setNew.size() != setOrig.size()) {
				System.out.println("I file contengono " + abs(setNew.size() - setOrig.size()) + " diversi ID");
			} else {
				System.out.println("I file contengono gli stessi ID");
			}
		}
	}

	public static void popolaSet(HashSet<String> set, String filePath) {
		try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filePath))) {
			while (bufferedReader.ready()) {
				set.add(bufferedReader.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
