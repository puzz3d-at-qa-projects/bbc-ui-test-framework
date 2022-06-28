package actionclasses;

import manager.POFactory;
import org.jetbrains.annotations.NotNull;
import pageobjects.MatchOverviewPage;
import pageobjects.ScoresAndFixturesPage;

public class SportScoresQueries {

    POFactory poFactory;
    ScoresAndFixturesPage scoresAndFixturesPage;
    MatchOverviewPage matchOverviewPage;

    public SportScoresQueries(@NotNull POFactory poFactory) {
        this.poFactory = poFactory;
        scoresAndFixturesPage = poFactory.getPage(ScoresAndFixturesPage.class);
        matchOverviewPage = poFactory.getPage(MatchOverviewPage.class);
    }

    public void searchLeague(String league) {
        scoresAndFixturesPage.getSearchInput().sendKeys(league);
    }

    public void clickOnLeagueInDropdownNamed(String league) {
        scoresAndFixturesPage.waitVisibilityOfElement(20, scoresAndFixturesPage.getLeagueSuggestion(league));
        scoresAndFixturesPage.getLeagueSuggestion(league).click();
    }

    public void clickOnMonth(String month) {
        scoresAndFixturesPage.getMonth(month).click();
    }

    public boolean matchIsOnTheScoresAndFixturesPage(String team1, String team2, String team1Score, String team2Score) {
        return scoresAndFixturesPage.getMatch(team1, team2, team1Score, team2Score).isDisplayed();
    }

    public void clickOnTeam1() {
        scoresAndFixturesPage.getTeam1Element().click();
    }

    public boolean matchIsOnTheMatchOverviewPage(String team1, String team2, String team1Score, String team2Score) {
        return matchOverviewPage.getMatch(team1, team2, team1Score, team2Score).isDisplayed();
    }
}

