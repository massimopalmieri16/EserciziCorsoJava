package ArcadeRank;


public class TestArcadeRank {
	public static void main(String[] args) throws InterruptedException {
		ArcadeRank arcadeRank = new ArcadeRank();
		Player player1 = new Player("player1");
		Player player2 = new Player("player2");
		Player player3 = new Player("player3");
		Player player4 = new Player("player4");
		Videogame videogame1 = new Videogame("game1", 1);
		Videogame videogame2 = new Videogame("game2", 1);

		arcadeRank.addPlayer(player1);
		arcadeRank.addPlayer(player2);
		arcadeRank.addPlayer(player3);
		arcadeRank.addPlayer(player4);
		arcadeRank.addVideogame(videogame1);
		arcadeRank.addVideogame(videogame2);

		arcadeRank.addScore(player1, videogame1, 42000);
		arcadeRank.addScore(player2, videogame1, 72000);
		arcadeRank.addScore(player3, videogame1, 16000);
		arcadeRank.addScore(player4, videogame1, 35000);
		arcadeRank.addScore(player1, videogame2, 120000);
		Thread.sleep(1000);
		arcadeRank.addScore(player2, videogame2, 150000);
		arcadeRank.addScore(player3, videogame2, 10000);
		Thread.sleep(1000);
		arcadeRank.addScore(player4, videogame2, 30000);


		System.out.println("Leaderboard of " + videogame1.toString());
		System.out.println(arcadeRank.getLeaderboard(videogame1, 3).toString());
		System.out.println("Last 3 score");
		System.out.println(arcadeRank.getLastScore(3).toString());
		System.out.println("Global leaderboard");
		System.out.println(arcadeRank.getGlobalLeaderboard(3).toString());
	}
}
