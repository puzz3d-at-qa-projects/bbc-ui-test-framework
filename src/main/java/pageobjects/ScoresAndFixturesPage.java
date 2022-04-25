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

    private WebElement team1Element;

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

    public WebElement getMatch(String team1, String team2, String team1Score, String team2Score) {
        WebElement match = driver.findElement(By.xpath(
                "//div[@class='sp-c-fixture__wrapper' " +
                        "and descendant::span[text()='" + team1 + "'] " +
                        "and descendant::span[text()='" + team2 + "'] " +
                        "and descendant::span[contains(@class,'home') and text()='" + team1Score + "'] " +
                        "and descendant::span[contains(@class,'away') and text()='" + team2Score + "']]"));
        team1Element = match.findElement(By.xpath(".//span[text()='" + team1 + "']"));
        return match;
    }

    public WebElement getTeam1Element() {
        return team1Element;
    }

    public WebElement getMatchScore(String team1, String team2, String position) {
        return driver.findElement(By.xpath(
                "//div[@class='sp-c-fixture__wrapper' " +
                        "and descendant::span[text()='" + team1 + "'] " +
                        "and descendant::span[text()='" + team2 + "']]" +
                        "//span[contains(@class,'" + position + " sp-c-fixture__number--ft')]"));

    }
}