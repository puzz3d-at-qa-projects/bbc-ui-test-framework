package stepdefinitions;

import actionclasses.Navigate;
import actionclasses.NewsQueries;
import actionclasses.SearchQueries;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import sharedcontext.ScenarioContext;
import sharedcontext.TestContext;

public class NavigationSteps {

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    Navigate navigate;
    NewsQueries article;
    SearchQueries search;
    ScenarioContext scenarioContext;

    public NavigationSteps(@NotNull TestContext testContext) {
        driver = testContext.getDriver();
        pageFactoryManager = testContext.getPageFactoryManager();
        navigate = testContext.getNavigate();
//        scenarioContext = testContext.scenarioContext;

    }
//    private static final int DEFAULT_TIMEOUT = 40;

    @Before
    public void testsSetup() {
        article = new NewsQueries(pageFactoryManager);
        search = new SearchQueries(pageFactoryManager);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("A web browser is at BBC homepage")
    public void openHomePage() {
        navigate.toTheBBCHomepage();
    }

    @And("^User navigates to (.*) page$")
    public void navigateToTopMenuItem(String linkText) {
        navigate.toTopMenuItem(linkText);
        if (driver.getCurrentUrl().contains("https://www.bbc.com/news")) {
            article.closeRegisterAlert();
        }
    }

    @And("User finds a form named {string}")
    public void userFindsAnAskYourQuestionForm(String articleTitle) { //would be much easier to hardcode form's URL https://www.bbc.com/news/52143212 and get it ☺
        navigateToTopMenuItem("News");
        navigate.toMainNewsMenuItem("Coronavirus");
        navigate.toSecondaryNewsMenuItem("Your Coronavirus Stories");
        navigate.toArticleByItsTitle(articleTitle);
    }

    @And("User navigates to Football Scores & Fixtures")
    public void userNavigatesToFootballScoresAndFixtures() {
        navigate.toTopMenuItem("Sport");
        navigate.toMainSportMenuItem("Football");
        navigate.toSecondarySportMenuItem("Scores");
    }
}
