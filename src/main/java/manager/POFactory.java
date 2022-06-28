package manager;

import org.openqa.selenium.WebDriver;
import pageobjects.BasePage;
import pageobjects.menus.TopMenuBar;

public class POFactory {

    WebDriver driver;
    TopMenuBar topMenuBar;

    public POFactory(WebDriver driver) {
        this.driver = driver;
    }

    public  <T extends BasePage> T getPage (Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
