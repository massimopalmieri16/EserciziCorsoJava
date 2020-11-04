import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.MessageToSend;
import com.botticelli.bot.request.methods.types.*;

import java.util.ArrayList;
import java.util.List;

public class PrimoBot extends Bot {

	public PrimoBot(String token)
	{
		super(token);
	}

	@Override
	public void textMessage(Message message) {
		System.out.println("Stringa ricevuta: " + message.getText());
		Comando c = Comando.fromString(message.getText());
		MessageToSend messageToSend;
		switch (c) {
			case SALUTA:
				String stringMessage = "Ciao " + message.getChat().getUserName() + ", come stai?";
				messageToSend = new MessageToSend(message.getChat().getId(), stringMessage);
				sendMessage(messageToSend);
				break;
			case MONOPATTINO:
				messageToSend = new MessageToSend(message.getChat().getId(), "Esercizio facile");
				sendMessage(messageToSend);
				break;
			case SCOOTER:
				messageToSend = new MessageToSend(message.getChat().getId(), "Esercizio medio");
				sendMessage(messageToSend);
				break;
			case MOTO:
				messageToSend = new MessageToSend(message.getChat().getId(), "Esercizio difficile");
				sendMessage(messageToSend);
				break;
			case TASTIERA:
				List<List<KeyboardButton>> keyboard = new ArrayList<>();
				List<KeyboardButton> line = new ArrayList<>();
				line.add(new KeyboardButton(Comando.MONOPATTINO.toString()));
				line.add(new KeyboardButton(Comando.SCOOTER.toString()));
				line.add(new KeyboardButton(Comando.MOTO.toString()));
				keyboard.add(line);
				ReplyKeyboardMarkupWithButtons replyKeyboard = new ReplyKeyboardMarkupWithButtons(keyboard);
				replyKeyboard.setResizeKeyboard(true);

				MessageToSend mts = new MessageToSend(message.getFrom().getId(), "Ecco la tastiera");
				mts.setReplyMarkup(replyKeyboard);
				sendMessage(mts);
				break;
			case START:
				messageToSend = new MessageToSend(message.getChat().getId(), "Benvenuto nel Primo Bot");
				sendMessage(messageToSend);
				break;
			case ERRORE:
				messageToSend = new MessageToSend(message.getChat().getId(), "Comando non valido");
				sendMessage(messageToSend);
				break;
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
