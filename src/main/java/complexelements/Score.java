package complexelements;

public class Score {
    private String team1Score;
    private String team2Score;

    public Score(String team1Score, String team2Score) {
        this.team1Score = team1Score;
        this.team2Score = team2Score;
    }

    @Override
    public String toString() {
        return team1Score + " - " + team2Score;
    }
}
