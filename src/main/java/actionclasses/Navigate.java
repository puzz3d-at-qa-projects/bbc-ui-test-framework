package actionclasses;

import manager.POFactory;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import pageobjects.menus.NewsNavigationBar;
import pageobjects.NewsPage;
import pageobjects.menus.SportNavigationBar;
import pageobjects.menus.TopMenuBar;

public class Navigate {

    WebDriver driver;
    POFactory poFactory;
    TopMenuBar topMenuBar;
    NewsNavigationBar newsNavigationBar;
    SportNavigationBar sportNavigationBar;
    NewsPage newsPage;
    private static final String BBC_URL = "https://bbc.com/";

    public Navigate(WebDriver driver, @NotNull POFactory poFactory) {
        this.driver = driver;
        this.poFactory = poFactory;
        topMenuBar = poFactory.getPage(TopMenuBar.class);
        newsNavigationBar = poFactory.getPage(NewsNavigationBar.class);
        newsPage = poFactory.getPage(NewsPage.class);
        sportNavigationBar = poFactory.getPage(SportNavigationBar.class);
    }

    public void toTheBBCHomepage() {
        driver.get(BBC_URL);
    }

    public void toTopMenuItem(String menuItem) {
        topMenuBar.itemForTopMenu(menuItem).click();
    }

    public void toMainNewsMenuItem(String menuItem) {
        newsNavigationBar.itemForMainMenu(menuItem).click();
    }

    public void toSecondaryNewsMenuItem(String menuItem) {
        newsNavigationBar.itemForSecondaryMenu(menuItem).click();
    }

    public void toArticleByItsTitle(String articleTitle) {
        newsPage.getPromoArticleByItsTitle(articleTitle).click();
    }

    public void toMainSportMenuItem(String menuItem) {
        sportNavigationBar.itemForMainMenu(menuItem).click();
    }

    public void toSecondarySportMenuItem(String menuItem) {
        sportNavigationBar.itemForSecondaryMenu(menuItem).click();
    }
}