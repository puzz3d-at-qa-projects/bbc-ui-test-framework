package actionclasses;

import manager.PageFactoryManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pageobjects.SearchPage;

import java.util.List;
import java.util.stream.Collectors;

public class SearchQueries {

    SearchPage searchPage;
    PageFactoryManager pageFactoryManager;

    public SearchQueries(PageFactoryManager pageFactoryManager) {
        this.pageFactoryManager = pageFactoryManager;
    }

    public void thisText(String query) {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.getSearchInput().clear();
        searchPage.getSearchInput().sendKeys(query + Keys.ENTER);
    }

    private List<String> searchResultsTitles() {
        return searchPage.getSearchResultsTitles()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String firstSearchResultsTitle() {
        return searchResultsTitles().get(0);
    }
}
