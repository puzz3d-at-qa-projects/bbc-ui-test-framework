package stepdefinitions;

import actionclasses.NewsQueries;
import actionclasses.Navigate;
import actionclasses.SearchQueries;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import sharedcontext.Context;
import sharedcontext.ScenarioContext;
import sharedcontext.TestContext;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NewsSteps {

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    Navigate navigate;
    NewsQueries article;
    SearchQueries search;
    ScenarioContext scenarioContext;


    public NewsSteps(@NotNull TestContext testContext) {
        driver = testContext.getDriver();
        pageFactoryManager = testContext.getPageFactoryManager();
        navigate = testContext.getNavigate();
        scenarioContext = testContext.scenarioContext;

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

    @And("Headline article title is")
    public void headlineArticleNameIs(String articleTitle) {
        assertTrue(article.headlineTitle().equalsIgnoreCase(articleTitle));
    }

    @And("Titles of the promo articles are")
    public void titlesOfThePromoArticlesAre(List<String> listOfTitles) {
        assertEquals(article.promoTitles(), listOfTitles);
    }

    @And("User memorize the Category of the headline article")
    public void userMemorizeTheCategoryOfTheHeadlineArticle() {
        scenarioContext.setContext(Context.HEADLINE_CATEGORY, article.headlineCategory());
    }

    @And("User made a search by this word")
    public void userMadeASearchByThisWord() {
        navigate.toTopMenuItem("Search");
        search.thisText(scenarioContext.getContext(Context.HEADLINE_CATEGORY).toString());
    }

    @And("The name of the first article in search results is")
    public void theNameOfTheFirstArticleInSearchResultsIs(String articleTitle) {
        assertEquals(search.firstSearchResultsTitle(), articleTitle);
    }

    @And("User finds a form named {string}")
    public void userFindsAnAskYourQuestionForm(String articleTitle) { //would be much easier to hardcode form's URL https://www.bbc.com/news/52143212 and get it ☺
        navigateToTopMenuItem("News");
        navigate.toMainNewsMenuItem("Coronavirus");
        navigate.toSecondaryNewsMenuItem("Your Coronavirus Stories");
        navigate.toArticleByItsTitle(articleTitle);
    }

}
