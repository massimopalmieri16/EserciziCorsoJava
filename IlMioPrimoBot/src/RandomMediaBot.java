import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.*;
import com.botticelli.bot.request.methods.types.*;
import java.util.ArrayList;

public class RandomMediaBot extends Bot {
	private ArrayList<String> referencesSticker;
	private ArrayList<String> referencesMedia;
	private ArrayList<String> referencesPhoto;
	private ArrayList<String> referencesAudio;
	private ArrayList<String> referencesVoice;

	public RandomMediaBot(String token) {
		super(token);
		referencesSticker = new ArrayList<>();
		referencesMedia = new ArrayList<>();
		referencesPhoto = new ArrayList<>();
		referencesAudio = new ArrayList<>();
		referencesVoice = new ArrayList<>();
	}

	@Override
	public void textMessage(Message message) {

	}

	@Override
	public void audioMessage(Message message) {
		referencesAudio.add(message.getAudio().getFileID());
		String audioReferenceToSend = referencesAudio.get(RandomRange.getRandomNumber(0,referencesAudio.size() - 1));
		sendAudiobyReference(new AudioReferenceToSend(message.getFrom().getId(), audioReferenceToSend));
	}

	@Override
	public void videoMessage(Message message) {

	}

	@Override
	public void voiceMessage(Message message) {
		referencesVoice.add(message.getVoice().getFileID());
		String voiceReferenceToSend = referencesVoice.get(RandomRange.getRandomNumber(0,referencesVoice.size() - 1));
		sendVoicebyReference(new VoiceReferenceToSend(message.getFrom().getId(), voiceReferenceToSend));
	}

	@Override
	public void stickerMessage(Message message) {
		referencesSticker.add(message.getSticker().getFileID());
		String stickerReferenceToSend = referencesSticker.get(RandomRange.getRandomNumber(0,referencesSticker.size() - 1));
		sendStickerbyReference(new StickerReferenceToSend(message.getFrom().getId(), stickerReferenceToSend));
	}

	@Override
	public void documentMessage(Message message) {
		referencesMedia.add(message.getDocument().getFileID());
		String mediaReferenceToSend = referencesMedia.get(RandomRange.getRandomNumber(0,referencesMedia.size() - 1));
		sendDocumentbyReference(new DocumentReferenceToSend(message.getFrom().getId(), mediaReferenceToSend));
	}

	@Override
	public void photoMessage(Message message) {
		for(PhotoSize i:message.getPhoto()){
			referencesPhoto.add(i.getFileID());
		}
		String photoReferenceToSend = referencesPhoto.get(RandomRange.getRandomNumber(0,referencesPhoto.size() - 1));
		sendPhotobyReference(new PhotoReferenceToSend(message.getFrom().getId(), photoReferenceToSend));
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
