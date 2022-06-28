package stepdefinitions;

import actionclasses.SportScoresQueries;
import complexelements.ScoreBoard;
import io.cucumber.java.en.And;
import manager.POFactory;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import sharedcontext.TestContext;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SportScoresSteps {

    WebDriver driver;
    POFactory poFactory;
    SportScoresQueries scores;
    ScoreBoard scoreBoard;

    public SportScoresSteps(@NotNull TestContext testContext) {
        driver = testContext.getDriver();
        poFactory = testContext.getPoFactory();
        scores = new SportScoresQueries(poFactory);
        scoreBoard = new ScoreBoard(poFactory);
    }

    @And("the user made a search by {string}")
    public void userMadeASearchByChampionshipName(String league) {
        scores.searchLeague(league);
        scores.clickOnLeagueInDropdownNamed(league);
    }

    @And("the user select a {string}")
    public void userSelectAMonth(String month) {
        scores.clickOnMonth(month);
    }

    @And("there is a match between {string} and {string} with {string} - {string} on the Scores & Fixtures page")
    public void thereIsAMatchOnTheScoresFixturesPage(String team1, String team2, String team1Score, String team2Score) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        assertTrue(scores.matchIsOnTheScoresAndFixturesPage(team1, team2, team1Score, team2Score));
    }

    @And("the user clicks on 'Home team'")
    public void userClicksOnTeam1() {
        scores.clickOnTeam1();
    }

    @And("there is a match between {string} and {string} with {string} - {string} on the Match Overview page")
    public void thereIsAMatchOnTheOverviewPage(String team1, String team2, String team1Score, String team2Score) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        assertTrue(scores.matchIsOnTheMatchOverviewPage(team1, team2, team1Score, team2Score));
    }

    @And("the score of the match between {string} and {string} is {string} - {string}")
    public void theScoreOfTheMatchBetweenTeamAndTeamIs(String team1, String team2, String team1Score, String team2Score) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        assertEquals(team1Score + " - " + team2Score, scoreBoard.getScore(team1, team2).toString());
    }
}
