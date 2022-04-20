package pageobjects.menus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;

public class SportNavigationBar extends BasePage {

    @FindBy(xpath = "//nav[@aria-label='BBC Sport']")
    private WebElement sportMenu;

    @FindBy(xpath = "//ul[@id='sp-nav-secondary']")
    private WebElement sportSecondaryMenu;

    public SportNavigationBar(WebDriver driver) {
        super(driver);
    }

    public WebElement itemForMainMenu(String menuItem) {
        return sportMenu.findElement(By.partialLinkText(menuItem));
    }

    public WebElement itemForSecondaryMenu(String menuItem) {
        return sportSecondaryMenu.findElement(By.partialLinkText(menuItem));
    }
}
