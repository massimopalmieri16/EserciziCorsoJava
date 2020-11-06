package Questionari;

import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.MessageToSend;
import com.botticelli.bot.request.methods.types.*;

import java.util.ArrayList;
import java.util.List;

public class Questionari extends Bot {
	private ArrayList<Questionario> questionari;
	private ArrayList<Utente> listaUtenti;

	public Questionari(String token) {
		super(token);
		questionari = new ArrayList<>();
		listaUtenti = new ArrayList<>();
	}

	@Override
	public void textMessage(Message message) {
		System.out.println("Stringa ricevuta: " + message.getText());
		MessageToSend messageToSend;
		Long iDUtente = message.getChat().getId();
		Integer indiceUtente = null;
		for(int i = 0; i < listaUtenti.size(); i++){
			Utente utente = listaUtenti.get(i);
			if(iDUtente.equals(utente.getiDUtente())){
				indiceUtente = i;
			}
		}
		if (indiceUtente == null) {
			listaUtenti.add(new Utente(iDUtente));
			indiceUtente = listaUtenti.size() - 1;
		}

		//System.out.println(listaUtenti.toString());
		System.out.println("Indice utente " + indiceUtente);

		Questionario questionarioCorrente = listaUtenti.get(indiceUtente).getQuestionarioCorrente();
		Domanda domandaCorrente = listaUtenti.get(indiceUtente).getDomandaCorrente();
		int punteggioCorrente = listaUtenti.get(indiceUtente).getPunteggioCorrente();

		if(questionarioCorrente != null){
			// se risposta corretta
			if(domandaCorrente.checkRispostaCorretta(message.getText())) {
				punteggioCorrente++;
				listaUtenti.get(indiceUtente).setPunteggioCorrente(punteggioCorrente);
			}
			// passo alla risposta successiva
			int indexDomanda = questionarioCorrente.getDomande().indexOf(domandaCorrente);
			if(indexDomanda < questionarioCorrente.getDomande().size() - 1){
				domandaCorrente = questionarioCorrente.getDomande().get(indexDomanda + 1);
				listaUtenti.get(indiceUtente).setDomandaCorrente(domandaCorrente);
				stampaDomanda(message, domandaCorrente);
			}else{
				messageToSend = new MessageToSend(message.getChat().getId(), "Questionario completato, hai risposto correttamente a " + punteggioCorrente + " domande");
				sendMessage(messageToSend);

				initQuestionari(message);

				listaUtenti.get(indiceUtente).setQuestionarioCorrente(null);
				listaUtenti.get(indiceUtente).setDomandaCorrente(null);
				listaUtenti.get(indiceUtente).setPunteggioCorrente(0);
			}
		}
		if(message.getText().equalsIgnoreCase("/start")){
			messageToSend = new MessageToSend(message.getChat().getId(), "Benvenuto nel Bot Questionari");
			sendMessage(messageToSend);

			// Stampo tastiera con questionari disponibili se presenti
			if(questionari.size() != 0){
				initQuestionari(message);
			}else{
				messageToSend = new MessageToSend(message.getChat().getId(), "Nessun questionario presente");
				sendMessage(messageToSend);
			}
		}else{
			// controllare se messaggio = nome questionario
			for (Questionario questionario : questionari) {
				if(questionario.getNomeQuestionario().equals(message.getText())){
					messageToSend = new MessageToSend(message.getChat().getId(), "Hai selezionato questionario " + message.getText());
					sendMessage(messageToSend);

					// Imposto questionario corrente
					listaUtenti.get(indiceUtente).setQuestionarioCorrente(questionario);
					listaUtenti.get(indiceUtente).setDomandaCorrente(questionario.getDomande().get(0));
					listaUtenti.get(indiceUtente).setPunteggioCorrente(0);

					// Stampo prima domanda
					stampaDomanda(message, listaUtenti.get(indiceUtente).getDomandaCorrente());
				}
			}
		}
	}

	public void stampaDomanda(Message message, Domanda domanda){
		MessageToSend messageToSend = new MessageToSend(message.getChat().getId(), domanda.getDomanda());

		List<List<KeyboardButton>> keyboard = new ArrayList<>();
		List<KeyboardButton> line;
		for (Risposta i : domanda.getRisposte()) {
			line = new ArrayList<>();
			line.add(new KeyboardButton(i.getRisposta()));
			keyboard.add(line);
		}
		ReplyKeyboardMarkupWithButtons replyKeyboard = new ReplyKeyboardMarkupWithButtons(keyboard);
		replyKeyboard.setResizeKeyboard(true);

		messageToSend.setReplyMarkup(replyKeyboard);
		sendMessage(messageToSend);
	}

	public void initQuestionari(Message message){
		List<List<KeyboardButton>> keyboard = new ArrayList<>();
		List<KeyboardButton> line;
		for (Questionario questionario : questionari) {
			line = new ArrayList<>();
			line.add(new KeyboardButton(questionario.getNomeQuestionario()));
			keyboard.add(line);
		}
		ReplyKeyboardMarkupWithButtons replyKeyboard = new ReplyKeyboardMarkupWithButtons(keyboard);
		replyKeyboard.setResizeKeyboard(true);

		MessageToSend messageToSend = new MessageToSend(message.getChat().getId(), "Seleziona un questionario");
		messageToSend.setReplyMarkup(replyKeyboard);
		sendMessage(messageToSend);
	}

	public void addQuestionario(String nome, ArrayList<Domanda> domande){
		questionari.add(new Questionario(nome, domande));
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
