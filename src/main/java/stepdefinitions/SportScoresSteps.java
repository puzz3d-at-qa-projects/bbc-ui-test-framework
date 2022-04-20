package stepdefinitions;

import actionclasses.SportScoresQueries;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import sharedcontext.ScenarioContext;
import sharedcontext.TestContext;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class SportScoresSteps {

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    SportScoresQueries scores;
    ScenarioContext scenarioContext;

    public SportScoresSteps(@NotNull TestContext testContext) {
        driver = testContext.getDriver();
        pageFactoryManager = testContext.getPageFactoryManager();
        scenarioContext = testContext.scenarioContext;
        scores = new SportScoresQueries(pageFactoryManager);
    }

    @And("User made a search by {string}")
    public void userMadeASearchByChampionshipName(String league) {
        scores.searchLeague(league);
        scores.clickOnLeagueInDropdownNamed(league);
    }

    @And("User select a {string}")
    public void userSelectAMonth(String month) {
        scores.clickOnMonth(month);
    }

    @And("There is a match between {string} and {string} with {string} - {string} on the Scores & Fixtures page")
    public void thereIsAMatchOnTheScoresFixturesPage(String homeTeam, String awayTeam, String homeScore, String awayScore) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        assertTrue(scores.matchIsOnTheScoresAndFixturesPage(homeTeam, awayTeam, homeScore, awayScore));
    }

    @And("User clicks on 'Home team' name")
    public void userClicksOnHomeTeam() {
        scores.clickOnHomeTeam();
    }

    @And("There is a match between {string} and {string} with {string} - {string} on the Match Overview page")
    public void thereIsAMatchOnTheOverviewPage(String homeTeam, String awayTeam, String homeScore, String awayScore) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        assertTrue(scores.matchIsOnTheMatchOverviewPage(homeTeam, awayTeam, homeScore, awayScore));

    }
}
