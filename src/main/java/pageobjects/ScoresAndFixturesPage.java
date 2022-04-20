package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScoresAndFixturesPage extends BasePage {

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='sp-c-content-slider__scroller']")
    private WebElement dateScroller;

    private WebElement homeTeamElement;

    public ScoresAndFixturesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getDateScroller() {
        return dateScroller;
    }

    public WebElement getLeagueSuggestion(String league) {
        return driver.findElement(By.xpath("//li[contains(@class,'search__result')][contains(., '" + league + "')]"));
    }

    public WebElement getMonth(String month) {
        return dateScroller.findElement(By.cssSelector("*[href*='" + month + "']"));
    }

    public WebElement getMatch(String homeTeam, String awayTeam, String homeScore, String awayScore) {
        WebElement match = driver.findElement(By.xpath(
                "//div[@class='sp-c-fixture__wrapper' " +
                        "and descendant::span[text()='" + homeTeam + "'] " +
                        "and descendant::span[text()='" + awayTeam + "'] " +
                        "and descendant::span[contains(@class,'home') and text()='" + homeScore + "'] " +
                        "and descendant::span[contains(@class,'away') and text()='" + awayScore + "']]"));
        homeTeamElement = match.findElement(By.xpath("//span[text()='" + homeTeam + "']"));
        return match;
    }

    public WebElement getHomeTeamElement() {
        return homeTeamElement;
    }
}