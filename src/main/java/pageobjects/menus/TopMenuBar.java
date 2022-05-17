package pageobjects.menus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;

public class TopMenuBar extends BasePage {

    @FindBy(css = "#orb-header")
    @CacheLookup
    private WebElement topMenu;

    public TopMenuBar(WebDriver driver) {
        super(driver);
    }

    public WebElement itemForTopMenu(String menuItem) {
        return topMenu.findElement(By.partialLinkText(menuItem));
    }
}
