package actionclasses;

import manager.POFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pageobjects.SearchPage;

import java.util.List;

public class SearchQueries {

    SearchPage searchPage;
    POFactory poFactory;

    public SearchQueries(POFactory poFactory) {
        this.poFactory = poFactory;
        searchPage = poFactory.getPage(SearchPage.class);
    }

    public void thisText(String query) {
        searchPage.getSearchInput().clear();
        searchPage.getSearchInput().sendKeys(query + Keys.ENTER);
    }

    private List<String> searchResultsTitles() {
        return searchPage.getSearchResultsTitles()
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public String firstSearchResultsTitle() {
        return searchResultsTitles().get(0);
    }
}
