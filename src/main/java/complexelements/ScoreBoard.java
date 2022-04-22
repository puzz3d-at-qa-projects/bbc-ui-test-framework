package complexelements;

import manager.PageFactoryManager;
import org.jetbrains.annotations.NotNull;
import pageobjects.ScoresAndFixturesPage;

public class ScoreBoard {

    PageFactoryManager pageFactoryManager;
    ScoresAndFixturesPage scoresAndFixturesPage;

    public ScoreBoard(@NotNull PageFactoryManager pageFactoryManager) {
        this.pageFactoryManager = pageFactoryManager;
        scoresAndFixturesPage = pageFactoryManager.getScoresAndFixturesPage();
    }

    public Score getScore(String team1, String team2) {
        String team1Score = scoresAndFixturesPage.getMatchScore(team1, team2, "home").getText();
        String team2Score = scoresAndFixturesPage.getMatchScore(team1, team2, "away").getText();
        return new Score(team1Score, team2Score);
    }
}
