package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MatchOverviewPage extends BasePage {

    public MatchOverviewPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getMatch(String team1, String team2, String team1Score, String team2Score) {
        return driver.findElement(By.xpath(
                "//div[@class='sp-c-fixture__wrapper' " +
                        "and descendant::span[text()='" + team1 + "'] " +
                        "and descendant::span[text()='" + team2 + "'] " +
                        "and descendant::span[contains(@class,'home') and text()='" + team1Score + "'] " +
                        "and descendant::span[contains(@class,'away') and text()='" + team2Score + "']]"));
    }
}
