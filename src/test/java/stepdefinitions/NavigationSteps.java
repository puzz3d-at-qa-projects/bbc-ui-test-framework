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
import sharedcontext.TestContext;

public class NavigationSteps {

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    Navigate navigate;
    NewsQueries article;
    SearchQueries search;

    public NavigationSteps(@NotNull TestContext testContext) {
        driver = testContext.getDriver();
        pageFactoryManager = testContext.getPageFactoryManager();
        navigate = testContext.getNavigate();

    }

    @Before
    public void testsSetup() {
        article = new NewsQueries(pageFactoryManager);
        search = new SearchQueries(pageFactoryManager);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("a web browser is at BBC homepage")
    public void openHomePage() {
        navigate.toTheBBCHomepage();
    }

    @And("^the user navigates to the (.*) page$")
    public void navigateToTopMenuItem(String linkText) {
        navigate.toTopMenuItem(linkText);
        if (driver.getCurrentUrl().contains("https://www.bbc.com/news")) {
            article.closeRegisterAlert();
        }
    }

    @And("the user finds a form named {string}")
    public void userFindsAnAskYourQuestionForm(String articleTitle) { //would be much easier to hardcode form's URL https://www.bbc.com/news/52143212 and get it ☺
        navigateToTopMenuItem("News");
        navigate.toMainNewsMenuItem("Coronavirus");
        navigate.toSecondaryNewsMenuItem("Your Coronavirus Stories");
        navigate.toArticleByItsTitle(articleTitle);
    }

    @And("the user navigates to Football Scores & Fixtures")
    public void userNavigatesToFootballScoresAndFixtures() {
        navigate.toTopMenuItem("Sport");
        navigate.toMainSportMenuItem("Football");
        navigate.toSecondarySportMenuItem("Scores");
    }
}
