package pageobjects.menus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;

public class NewsNavigationBar extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'news-wide-navigation')]")
    private WebElement newsMenu;

    @FindBy(xpath = "//nav[@class='nw-c-nav__wide-secondary']")
    private WebElement newsSecondaryMenu;

    public NewsNavigationBar(WebDriver driver) {
        super(driver);
    }

    public WebElement itemForMainMenu(String menuItem) {
        return newsMenu.findElement(By.partialLinkText(menuItem));
    }

    public WebElement itemForSecondaryMenu(String menuItem) {
        return newsSecondaryMenu.findElement(By.partialLinkText(menuItem));
    }

}
