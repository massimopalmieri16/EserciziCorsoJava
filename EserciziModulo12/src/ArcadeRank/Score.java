package ArcadeRank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

//public class Score implements Comparable<Score>{
public class Score{
	private final Player player;
	private final int score;
	private final LocalDateTime date;

	public Score(Player player, int score) {
		this.player = player;
		this.score = score;
		this.date = LocalDateTime.now();
	}

	public Player getPlayer() {
		return player;
	}

	public int getScore() {
		return score;
	}

	public LocalDateTime getDate() {
		return date;
	}

	/*@Override
	public int compareTo(Score score) {
		return -Integer.compare(this.score, score.score);
	}*/

	@Override
	public String toString() {
		return player.toString() + " score: " + score + " date " + date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
	}
}
