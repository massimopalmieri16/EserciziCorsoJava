package TweetsParser;

public class TestTweetsParser {
	public static void main(String[] args) {
		TweetsParser tweetsParser = new TweetsParser("src/TweetsParser/trumptweets.csv");
		System.out.println("Most used words in file: trumptweets.csv");
		tweetsParser.stampaParolePiuUsate();
		tweetsParser = new TweetsParser("src/TweetsParser/realdonaldtrump.csv");
		System.out.println("Most used words in file: realdonaldtrump.csv");
		tweetsParser.stampaParolePiuUsate();
	}
}
