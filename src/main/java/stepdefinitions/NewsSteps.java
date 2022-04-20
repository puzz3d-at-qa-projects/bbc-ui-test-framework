package stepdefinitions;

import actionclasses.Navigate;
import actionclasses.NewsQueries;
import actionclasses.SearchQueries;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import sharedcontext.ContextStorage;
import sharedcontext.ScenarioContext;
import sharedcontext.TestContext;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NewsSteps {

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    Navigate navigate;
    NewsQueries news;
    SearchQueries search;
    ScenarioContext scenarioContext;

    public NewsSteps(@NotNull TestContext testContext) {
        driver = testContext.getDriver();
        pageFactoryManager = testContext.getPageFactoryManager();
        navigate = testContext.getNavigate();
        scenarioContext = testContext.scenarioContext;
        news = new NewsQueries(pageFactoryManager);
        search = new SearchQueries(pageFactoryManager);
    }
//    private static final int DEFAULT_TIMEOUT = 40;

    @And("Headline article title is")
    public void headlineArticleNameIs(String articleTitle) {
        assertTrue(news.headlineTitle().equalsIgnoreCase(articleTitle));
    }

    @And("Titles of the promo articles are")
    public void titlesOfThePromoArticlesAre(List<String> listOfTitles) {
        assertEquals(news.promoTitles(), listOfTitles);
    }

    @And("User memorize the Category of the headline article")
    public void userMemorizeTheCategoryOfTheHeadlineArticle() {
        scenarioContext.setContext(ContextStorage.HEADLINE_CATEGORY, news.headlineCategory());
    }

    @And("User made a search by this word")
    public void userMadeASearchByThisWord() {
        navigate.toTopMenuItem("Search");
        search.thisText(scenarioContext.getContext(ContextStorage.HEADLINE_CATEGORY).toString());
    }

    @And("The name of the first article in search results is")
    public void theNameOfTheFirstArticleInSearchResultsIs(String articleTitle) {
        assertEquals(search.firstSearchResultsTitle(), articleTitle);
    }
}
