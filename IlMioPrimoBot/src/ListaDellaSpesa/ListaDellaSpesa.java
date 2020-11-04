package ListaDellaSpesa;

import PrimoBot.ComandoPrimoBot;
import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.MessageToSend;
import com.botticelli.bot.request.methods.types.*;

import java.util.ArrayList;
import java.util.List;

public class ListaDellaSpesa extends Bot {
	ArrayList<ArrayList<Prodotto>> listeDellaSpesa;
	ArrayList<Long> listaUtenti;
	boolean aggiuntaInCorso;
	boolean rimozioneInCorso;

	public ListaDellaSpesa(String token) {
		super(token);

		listeDellaSpesa = new ArrayList<>();
		listeDellaSpesa.add(new ArrayList<>());
		listaUtenti = new ArrayList<>();
		aggiuntaInCorso = false;
		rimozioneInCorso = false;
	}

	@Override
	public void textMessage(Message message) {
		System.out.println("Stringa ricevuta: " + message.getText());
		MessageToSend messageToSend;

		if(aggiuntaInCorso){
			System.out.println("Aggiunta in corso");
			String[] parts = message.getText().split("-");
			int indiceUtente = listaUtenti.indexOf(message.getChat().getId());
			int quantita = 0;
			if(parts.length == 2) {
				quantita = Integer.parseInt(parts[1]);
			}else {
				quantita = 1;
			}
			listeDellaSpesa.get(indiceUtente).add(new Prodotto(parts[0], quantita));

			messageToSend = new MessageToSend(message.getChat().getId(), "Aggiunto " + parts[0] + " quantita " + quantita);
			sendMessage(messageToSend);

			aggiuntaInCorso = false;
		}else if(rimozioneInCorso){
			System.out.println("Rimozione in corso");

			int indiceUtente = listaUtenti.indexOf(message.getChat().getId());
			boolean rimosso = false;

			for(int i = 0; i < listeDellaSpesa.get(indiceUtente).size(); i++){
				if(listeDellaSpesa.get(indiceUtente).get(i).getNome().compareTo(message.getText()) == 0){
					listeDellaSpesa.get(indiceUtente).remove(i);
					rimosso = true;
					break;
				}
			}
			if(rimosso) {
				messageToSend = new MessageToSend(message.getChat().getId(), "Prodotto " + message.getText() + " rimosso");
			}else{
				messageToSend = new MessageToSend(message.getChat().getId(), "Prodotto da rimuovere non trovato");
			}

			sendMessage(messageToSend);

			rimozioneInCorso = false;
		}else {
			aggiuntaInCorso = false;
			rimozioneInCorso = false;
			ComandoListaDellaSpesa c = ComandoListaDellaSpesa.fromString(message.getText());
			System.out.println(c.toString());

			switch (c) {
				case START:
					List<List<KeyboardButton>> keyboard = new ArrayList<>();
					List<KeyboardButton> line = new ArrayList<>();
					line.add(new KeyboardButton(ComandoListaDellaSpesa.LISTA_DELLA_SPESA.toString()));
					keyboard.add(line);
					line = new ArrayList<>();
					line.add(new KeyboardButton(ComandoListaDellaSpesa.AGGIUNGI.toString()));
					line.add(new KeyboardButton(ComandoListaDellaSpesa.RIMUOVI.toString()));
					keyboard.add(line);
					ReplyKeyboardMarkupWithButtons replyKeyboard = new ReplyKeyboardMarkupWithButtons(keyboard);
					replyKeyboard.setResizeKeyboard(true);

					messageToSend = new MessageToSend(message.getFrom().getId(), "Benvenuto nel Bot Lista Della Spesa");
					messageToSend.setReplyMarkup(replyKeyboard);
					sendMessage(messageToSend);
					break;
				case LISTA_DELLA_SPESA:
					System.out.println("Stampo lista della spesa");
					System.out.println(listaUtenti.toString());
					if (listeDellaSpesa.size() != 0 && listeDellaSpesa.get(0).size() != 0) {
						System.out.println("Lista popolata");
						String strOut = "";
						for (Prodotto i : listeDellaSpesa.get(0)) {
							strOut += i.toString() + "\n";
						}
						System.out.println(strOut);
						messageToSend = new MessageToSend(message.getFrom().getId(), strOut);
					} else {
						// Lista vuota
						System.out.println("Lista vuota");
						messageToSend = new MessageToSend(message.getFrom().getId(), "Lista Vuota");
					}
					sendMessage(messageToSend);
					break;
				case AGGIUNGI:
					Long iDUtente = message.getChat().getId();
					// se utente non presente lo aggiungo
					if (!listaUtenti.contains(iDUtente)) {
						listaUtenti.add(iDUtente);
					}
					int indiceUtente = listaUtenti.indexOf(iDUtente);
					System.out.println("Indice utente" + indiceUtente);

					aggiuntaInCorso = true;
					rimozioneInCorso = false;

					break;
				case RIMUOVI:
					iDUtente = message.getChat().getId();
					indiceUtente = listaUtenti.indexOf(iDUtente);
					System.out.println("Indice utente" + indiceUtente);

					aggiuntaInCorso = false;
					rimozioneInCorso = true;
					break;
				case ERRORE:
					messageToSend = new MessageToSend(message.getChat().getId(), "Comando non valido");
					sendMessage(messageToSend);
					break;
			}
		}
	}

	@Override
	public void audioMessage(Message message) {

	}

	@Override
	public void videoMessage(Message message) {

	}

	@Override
	public void voiceMessage(Message message) {

	}

	@Override
	public void stickerMessage(Message message) {

	}

	@Override
	public void documentMessage(Message message) {

	}

	@Override
	public void photoMessage(Message message) {

	}

	@Override
	public void contactMessage(Message message) {

	}

	@Override
	public void locationMessage(Message message) {

	}

	@Override
	public void venueMessage(Message message) {

	}

	@Override
	public void newChatMemberMessage(Message message) {

	}

	@Override
	public void newChatMembersMessage(Message message) {

	}

	@Override
	public void leftChatMemberMessage(Message message) {

	}

	@Override
	public void newChatTitleMessage(Message message) {

	}

	@Override
	public void newChatPhotoMessage(Message message) {

	}

	@Override
	public void groupChatPhotoDeleteMessage(Message message) {

	}

	@Override
	public void groupChatCreatedMessage(Message message) {

	}

	@Override
	public void inLineQuery(InlineQuery inlineQuery) {

	}

	@Override
	public void chose_inline_result(ChosenInlineResult chosenInlineResult) {

	}

	@Override
	public void callback_query(CallbackQuery callbackQuery) {

	}

	@Override
	public void gameMessage(Message message) {

	}

	@Override
	public void videoNoteMessage(Message message) {

	}

	@Override
	public void pinnedMessage(Message message) {

	}

	@Override
	public void preCheckOutQueryMessage(PreCheckoutQuery preCheckoutQuery) {

	}

	@Override
	public void shippingQueryMessage(ShippingQuery shippingQuery) {

	}

	@Override
	public void invoiceMessage(Message message) {

	}

	@Override
	public void successfulPaymentMessage(Message message) {

	}

	@Override
	public void routine() {

	}
}
