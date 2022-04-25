package actionclasses;

import manager.PageFactoryManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import pageobjects.NewsPage;

import java.util.List;

public class NewsQueries {

    NewsPage newsPage;
    PageFactoryManager pageFactoryManager;

    public NewsQueries(@NotNull PageFactoryManager pageFactoryManager) {
        this.pageFactoryManager = pageFactoryManager;
        newsPage = pageFactoryManager.getNewsPage();
    }

    public String headlineTitle() {
        return newsPage.getHeadlineTitle().getText();
    }

    public String headlineCategory() {
        return newsPage.getHeadlineCategory().getText();
    }

    public List<String> promoTitles() {
        return newsPage.getPromoArticles().stream().map(WebElement::getText).toList();
    }

    public void closeRegisterAlert() {
        newsPage.waitVisibilityOfElement(30, newsPage.getCloseRegisterAlertButton());
        newsPage.getCloseRegisterAlertButton().click();
    }
}
