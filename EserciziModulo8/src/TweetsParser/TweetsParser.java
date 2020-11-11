package TweetsParser;

import java.io.*;
import java.util.*;

public class TweetsParser {
	private String filePath;
	private HashSet<String> stopWords;
	private HashMap<String, Integer> parole;
	private HashMap<String, Integer> parolePiuUsate;

	public TweetsParser(String filePath) {
		this.filePath = filePath;
		parole = new HashMap<>();
		parolePiuUsate = new HashMap<>();
		stopWords = new HashSet<>();
		readStopWord();
		parseFile(filePath);
	}

	private void parseFile(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			br.readLine(); // leggo la prima riga ma la ignoro
			while ((line = br.readLine()) != null) {
				ArrayList<String> paroleRiga = new ArrayList<>(Arrays.asList(line.split(",")[2].split(" "))); // splitto parola della riga per spazi e le metto in Arraylist
				for (String s : paroleRiga) {
					s = s.toLowerCase();
					if(s.matches("\\w.+") && !stopWords.contains(s)) { // se è una parola che inizia per un carattere
						if (parole.containsKey(s)) {
							parole.put(s, parole.get(s) + 1);
						} else {
							parole.put(s, 1);
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// cerco le parole più usate
		int minOccurrencesVal = 0;
		String minOccurrencesKey = "";
		for (Map.Entry<String, Integer> entryParole : parole.entrySet()) {
			if(parolePiuUsate.size() < 10){
				parolePiuUsate.put(entryParole.getKey(), entryParole.getValue());
			}else{
				if(entryParole.getValue() > minOccurrencesVal){
					parolePiuUsate.remove(minOccurrencesKey);
					parolePiuUsate.put(entryParole.getKey(), entryParole.getValue());
				}
			}
			minOccurrencesKey = trovaMenoFrequente();
			minOccurrencesVal = parole.get(minOccurrencesKey);
		}
	}

	private String trovaMenoFrequente() {
		int minOcc = Integer.MAX_VALUE;
		String minOccKey = "";
		for (Map.Entry<String, Integer> entry : parolePiuUsate.entrySet()) {
			if (entry.getValue() < minOcc){
				minOccKey = entry.getKey();
				minOcc = entry.getValue();
			}
		}
		return minOccKey;
	}

	private void readStopWord(){
		try (BufferedReader br = new BufferedReader(new FileReader("src/TweetsParser/english_stopwords.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				stopWords.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void stampaParolePiuUsate() {
		for (Map.Entry<String, Integer> entry : parolePiuUsate.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue() + " times");
		}
	}
}
