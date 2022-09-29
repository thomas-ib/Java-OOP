package rockpaperscissors;
public class Score {
    
    private int totalNumberGames;
    private int gamesWonByUser;

    public void incrementTotal() {
        totalNumberGames++;
    }

    public void incrementGameWonByUser() {
        gamesWonByUser++;
    }

    public int getGamesWonByUser() {
        return this.gamesWonByUser;
    }

    public int getTotalNumberGames() {
        return this.totalNumberGames;
    }
}
