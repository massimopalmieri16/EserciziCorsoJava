package Righe1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Righe1 {
	public static void main(String[] args) {
		ArrayDeque<String> righe = new ArrayDeque<>();
		try (BufferedReader br = Files.newBufferedReader(Paths.get("src/Righe1/righe.txt"))) {
			while (br.ready()) {
				righe.offer(br.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("src/Righe1/righeInverse.txt"))) {
			while (!righe.isEmpty()) {
				bw.write(righe.pollLast());
				bw.newLine();
				//System.out.println(righe.pollLast());
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
