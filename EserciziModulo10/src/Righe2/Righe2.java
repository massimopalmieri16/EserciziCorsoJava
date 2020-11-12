package Righe2;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Righe2 {
	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get("src/Righe2/righe2.txt"))) {
			String line;
			while (br.ready()) {
				line = br.readLine();
				String[] split = line.split(":");
				if(split.length < 2){
					System.out.println("File not valid");
					break;
				}
				hashMap.put(split[0], new ArrayList<String>(Arrays.asList(split[1].split(","))));
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}

		for (Map.Entry<String, ArrayList<String>> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
	}
}
