package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuBar extends BasePage{

    @FindBy(xpath = "//div[@id='orb-header']")
    private WebElement topMenu;

    public TopMenuBar(WebDriver driver) {
        super(driver);
    }

    public WebElement itemForTopMenu(String menuItem) {
        return topMenu.findElement(By.partialLinkText(menuItem));
    }
}
