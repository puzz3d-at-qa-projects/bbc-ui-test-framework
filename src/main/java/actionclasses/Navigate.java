package actionclasses;

import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import pageobjects.NewsNavigationBar;
import pageobjects.NewsPage;
import pageobjects.TopMenuBar;

public class Navigate {

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    TopMenuBar topMenuBar;
    NewsNavigationBar newsNavigationBar;
    NewsPage newsPage;
    private static final String BBC_URL = "https://bbc.com/";

    public Navigate(WebDriver driver, PageFactoryManager pageFactoryManager) {
        this.driver = driver;
        this.pageFactoryManager = pageFactoryManager;
    }

    public void toTheBBCHomepage() {
        driver.get(BBC_URL);
    }

    public void toTopMenuItem(String menuItem) {
        topMenuBar = pageFactoryManager.getTopMenuBar();
        topMenuBar.itemForTopMenu(menuItem).click();
    }

    public void toMainNewsMenuItem(String menuItem) {
        newsNavigationBar = pageFactoryManager.getNewsNavigationBar();
        newsNavigationBar.itemForMainMenu(menuItem).click();
    }

    public void toSecondaryNewsMenuItem(String menuItem) {
        newsNavigationBar.itemForSecondaryMenu(menuItem).click();
    }

    public void toArticleByItsTitle(String articleTitle) {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.getPromoArticleByItsTitle(articleTitle).click();
    }
}
