package ArcadeRank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArcadeRank {
	private HashSet<Player> players;
	private HashSet<Videogame> videogames;

	public ArcadeRank() {
		players = new HashSet<>();
		videogames = new HashSet<>();
	}

	public boolean addPlayer(Player player){
		return players.add(player);
	}

	public boolean addVideogame(Videogame videogame){
		return videogames.add(videogame);
	}

	public boolean addScore(Player player, Videogame videogame, int score){
		if(videogames.contains(videogame)){
			videogame.addScore(player, score);
			return true;
		}else{
			return false;
		}
	}

	public List<Score> getLeaderboard(Videogame videogame, int numTopPlayers){
		if(videogames.contains(videogame)){
			//return videogame.getLeaderboard().entrySet().stream().sorted(Map.Entry.<Player, Integer>comparingByValue().reversed()).limit(numTopPlayers).map(m -> m.getKey().toString() + m.getValue()).collect(Collectors.toList());
			return videogame.getLeaderboard().stream()
					.sorted(Comparator.comparing(Score::getScore).reversed())
					.limit(numTopPlayers)
					.collect(Collectors.toList());
		}else {
			return null;
		}
	}

	public List<Score> getLastScore(int numScore){
		return videogames.stream()
				.map(m -> m.getLeaderboard())
				.flatMap(Collection::stream)
				.sorted(Comparator.comparing(Score::getDate).reversed())
				.limit(numScore)
				.collect(Collectors.toList());
	}

	public List<Score> getGlobalLeaderboard(int numScore){
		return videogames.stream()
				.flatMap(m -> m.getLeaderboard().stream())
				.sorted(Comparator.comparing(Score::getScore).reversed())
				.limit(numScore)
				.collect(Collectors.toList());
	}
}
