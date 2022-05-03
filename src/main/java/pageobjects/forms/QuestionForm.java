package pageobjects.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;

public class QuestionForm extends BasePage {

    @FindBy(xpath = "//div[@class='embed-content-container']")
    private WebElement form;

    public QuestionForm(WebDriver driver) {
        super(driver);
    }

    public WebElement getFormElement(String placeholder) {
        return form.findElement(By.cssSelector("*[placeholder*='" + placeholder + "']"));
    }

    public WebElement getTermsOfServiceCheckbox() {
        return form.findElement(By.xpath(".//input[@type='checkbox']"));
    }

    public WebElement getSubmitButton() {
        return form.findElement(By.xpath(".//button[@class='button']"));
    }

    public WebElement getFormErrorMessage() {
        return form.findElement(By.xpath(".//div[@class='input-error-message']"));
    }
}
