package ArcadeRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.UUID;

public class Videogame {
	private final UUID id;
	private final String name;
	private final int difficulty;
	//private TreeSet<Score> leaderboard;
	private ArrayList<Score> leaderboard;

	public Videogame(String name, int difficulty) {
		this.name = name;
		this.id = UUID.randomUUID();
		this.difficulty = difficulty;
		this.leaderboard = new ArrayList<>();
	}

	public ArrayList<Score> getLeaderboard() {
		return leaderboard;
	}

	public void addScore(Player player, int score){
		leaderboard.add(new Score(player, score * difficulty));
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Videogame)) return false;
		Videogame v = (Videogame) o;
		return this.id.equals(v.id) && this.name.equals(v.name);
	}

	@Override
	public String toString() {
		return name;
	}
}
