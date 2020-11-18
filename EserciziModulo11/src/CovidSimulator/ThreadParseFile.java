package CovidSimulator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ThreadParseFile extends Thread{
	private final String filePath;
	private final BufferedWriter bwOutput;

	public ThreadParseFile(String filePath, BufferedWriter bwOutput) {
		this.filePath = filePath;
		this.bwOutput = bwOutput;
	}

	@Override
	public void run() {
		try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(this.filePath))){
			while (bufferedReader.ready()) {
				checkRischio(bufferedReader.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void checkRischio(String strInput){
		String[] arrStr = strInput.split(";");
		if(arrStr.length == 7) {
			float temp = Float.parseFloat(arrStr[1]);
			int eta = Integer.parseInt(arrStr[2]);
			boolean gusto = Boolean.parseBoolean(arrStr[3]);
			boolean tosse = Boolean.parseBoolean(arrStr[4]);
			boolean debolezza = Boolean.parseBoolean(arrStr[5]);
			String situazioneClinica = arrStr[6];

			if (temp >= 40.0 ||
					(temp >= 38.0 && gusto && tosse && debolezza) ||
					(situazioneClinica.equalsIgnoreCase("critica") && (temp >= 38.5 || gusto || tosse || debolezza)) ||
					(eta >= 50 && temp >= 37.0) || (eta >= 60 && ((gusto && situazioneClinica.equalsIgnoreCase("cautela")) ||
					(tosse && situazioneClinica.equalsIgnoreCase("critica"))))) {
				try {
					synchronized (bwOutput) {
						bwOutput.write(arrStr[0]);
						bwOutput.newLine();
					}
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
