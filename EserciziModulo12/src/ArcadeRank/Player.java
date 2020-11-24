package ArcadeRank;

import java.util.UUID;

public class Player {
	private final UUID id;
	private final String username;

	public Player(String username) {
		this.username = username;
		this.id = UUID.randomUUID();
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Player)) return false;
		Player p = (Player) o;
		return this.id.equals(p.id) && this.username.equals(p.username);
	}

	@Override
	public String toString() {
		return "Player: " + username + " score: ";
	}
}
