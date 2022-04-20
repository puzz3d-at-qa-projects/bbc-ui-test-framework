package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MatchOverviewPage extends BasePage {

    public MatchOverviewPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getMatch(String homeTeam, String awayTeam, String homeScore, String awayScore) {
        return driver.findElement(By.xpath(
                "//div[@class='sp-c-fixture__wrapper' " +
                        "and descendant::span[text()='" + homeTeam + "'] " +
                        "and descendant::span[text()='" + awayTeam + "'] " +
                        "and descendant::span[contains(@class,'home') and text()='" + homeScore + "'] " +
                        "and descendant::span[contains(@class,'away') and text()='" + awayScore + "']]"));
    }
}
