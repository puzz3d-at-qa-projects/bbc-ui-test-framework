package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//input[@id='search-input']")
    private WebElement searchInput;

    @FindBy(xpath = "//p[contains(@class,'PromoHeadline')]/span")
    private List<WebElement> searchResultsTitles;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public List<WebElement> getSearchResultsTitles() {
        return searchResultsTitles;
    }
}
