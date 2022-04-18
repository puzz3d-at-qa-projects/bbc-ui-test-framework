package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//h3[contains(@class,'gel-canon-bold')]")
    private WebElement headlineTitle;

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#1']//a[contains(@class, 'section-link')]/span")
    private WebElement headlineCategory;

    @FindBy(xpath = "//div[contains(@class,'nw-c-5-slice')]//h3")
    private List<WebElement> promoArticles;

    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement closeRegisterAlertButton;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHeadlineTitle() {
        return headlineTitle;
    }

    public WebElement getHeadlineCategory() {
        return headlineCategory;
    }

    public List<WebElement> getPromoArticles() {
        return promoArticles;
    }

    public WebElement getCloseRegisterAlertButton() {
        return closeRegisterAlertButton;
    }

    public WebElement getPromoArticleByItsTitle(String articleTitle) {
        return promoArticles.stream()
                .filter(e -> Objects.equals(e.getText(), articleTitle))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No Article found containing " + articleTitle))
                .findElement(By.xpath("./..")); // h3 not clickable, so returning its parent <a> element
    }
}
