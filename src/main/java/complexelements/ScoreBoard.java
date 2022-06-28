package complexelements;

import manager.POFactory;
import org.jetbrains.annotations.NotNull;
import pageobjects.ScoresAndFixturesPage;

public class ScoreBoard {

    POFactory poFactory;
    ScoresAndFixturesPage scoresAndFixturesPage;

    public ScoreBoard(@NotNull POFactory poFactory) {
        this.poFactory = poFactory;
        scoresAndFixturesPage = poFactory.getPage(ScoresAndFixturesPage.class);
    }

    public Score getScore(String team1, String team2) {
        String team1Score = scoresAndFixturesPage.getMatchScore(team1, team2, "home").getText();
        String team2Score = scoresAndFixturesPage.getMatchScore(team1, team2, "away").getText();
        return new Score(team1Score, team2Score);
    }
}
