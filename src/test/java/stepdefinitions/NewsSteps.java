package stepdefinitions;

import actionclasses.Navigate;
import actionclasses.NewsQueries;
import actionclasses.SearchQueries;
import io.cucumber.java.en.And;
import manager.POFactory;
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
    POFactory poFactory;
    Navigate navigate;
    NewsQueries news;
    SearchQueries search;
    ScenarioContext scenarioContext;

    public NewsSteps(@NotNull TestContext testContext) {
        driver = testContext.getDriver();
        poFactory = testContext.getPoFactory();
        navigate = testContext.getNavigate();
        scenarioContext = testContext.scenarioContext;
        news = new NewsQueries(poFactory);
        search = new SearchQueries(poFactory);
    }

    @And("the Headline article title is")
    public void headlineArticleNameIs(String articleTitle) {
        assertTrue("The title doesn't match the given condition!"
                , news.headlineTitle().equalsIgnoreCase(articleTitle));
    }

    @And("the titles of the promo articles are")
    public void titlesOfThePromoArticlesAre(List<String> listOfTitles) {
        assertEquals(listOfTitles, news.promoTitles());
    }

    @And("the user memorize the Category of the headline article")
    public void userMemorizeTheCategoryOfTheHeadlineArticle() {
        scenarioContext.setContext(ContextStorage.HEADLINE_CATEGORY, news.headlineCategory());
    }

    @And("the user enters this Category into the search bar")
    public void userMadeASearchByThisWord() {
        navigate.toTopMenuItem("Search");
        search.thisText(scenarioContext.getContext(ContextStorage.HEADLINE_CATEGORY).toString());
    }

    @And("the name of the first article in the search results is")
    public void theNameOfTheFirstArticleInSearchResultsIs(String articleTitle) {
        assertEquals(articleTitle, search.firstSearchResultsTitle());
    }
}
