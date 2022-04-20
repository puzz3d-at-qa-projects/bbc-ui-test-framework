package actionclasses;

import manager.PageFactoryManager;
import org.jetbrains.annotations.NotNull;
import pageobjects.MatchOverviewPage;
import pageobjects.ScoresAndFixturesPage;

public class SportScoresQueries {

    ScoresAndFixturesPage scoresAndFixturesPage;
    MatchOverviewPage matchOverviewPage;
    PageFactoryManager pageFactoryManager;

    public SportScoresQueries(@NotNull PageFactoryManager pageFactoryManager) {
        this.pageFactoryManager = pageFactoryManager;
        scoresAndFixturesPage = pageFactoryManager.getScoresAndFixturesPage();
        matchOverviewPage = pageFactoryManager.getMatchOverviewPage();
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

    public boolean matchIsOnTheScoresAndFixturesPage(String homeTeam, String awayTeam, String homeScore, String awayScore) {
        return scoresAndFixturesPage.getMatch(homeTeam, awayTeam, homeScore, awayScore).isDisplayed();
    }

    public void clickOnHomeTeam() {
        scoresAndFixturesPage.getHomeTeamElement().click();
    }

    public boolean matchIsOnTheMatchOverviewPage(String homeTeam, String awayTeam, String homeScore, String awayScore) {
        return matchOverviewPage.getMatch(homeTeam, awayTeam, homeScore, awayScore).isDisplayed();
    }
}
