import java.io.File;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import ListaDellaSpesa.ListaDellaSpesa;
import Questionari.Questionari;
import Questionari.Domanda;
import com.botticelli.bot.Bot;
import com.botticelli.messagereceiver.MessageReceiver;

public class Main {

	public static String filePath;

	public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException, UnknownHostException, SocketException
	{
		filePath = new File("").getAbsolutePath() + System.getProperty("file.separator");
		File tokenFile = new File(filePath + "token.txt");
		String token = "";
		try (Scanner s = new Scanner(tokenFile))
		{
			while (s.hasNext())
			{
				token = s.nextLine();
			}
		}

		// Primo esercizio
		//Bot bot = new PrimoBot(token);
		// Secondo esercizio, media random
		//Bot bot = new RandomMediaBot(token);
		// Terzo esercizio, Lista della spesa
		//Bot bot = new ListaDellaSpesa(token);
		// Quarto esercizio, questionari
		Questionari botQuestionari = new Questionari(token);
		botQuestionari.addQuestionario("Sport", Domanda.generateDomandeSport());
		botQuestionari.addQuestionario("Arte", Domanda.generateDomandeArte());
		MessageReceiver mr = new MessageReceiver(botQuestionari, 500, 1);
		mr.ignoreEditedMessages();
		mr.start();
	}
}
