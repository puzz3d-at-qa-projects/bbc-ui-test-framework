package actionclasses;

import manager.PageFactoryManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Keys;
import pageobjects.QuestionForm;

import java.util.List;
import java.util.Map;

public class FormQueries {

    QuestionForm questionForm;
    PageFactoryManager pageFactoryManager;

    public FormQueries(@NotNull PageFactoryManager pageFactoryManager) {
        this.pageFactoryManager = pageFactoryManager;
        questionForm = pageFactoryManager.getQuestionForm();
    }

    public void fillForm(@NotNull List<Map<String, String>> dataTable) {
        dataTable
                .stream()
                .peek(e -> e.forEach((k, v) -> questionForm
                        .getFormElement(k).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE)))
                .forEach(e -> e.forEach((k, v) -> questionForm
                        .getFormElement(k).sendKeys(v.replaceFirst("\\[blank]", ""))));
    }

    public void acceptTermsOfService() {
        if (!questionForm.getTermsOfServiceCheckbox().isSelected()) {
            questionForm.getTermsOfServiceCheckbox().click();
        }
    }

    public void clickTermsOfService() {
        questionForm.getTermsOfServiceCheckbox().click();
    }

    public void submit() {
        questionForm.getSubmitButton().click();
    }

    public boolean errorDisplayed(String errorMessage) {
        questionForm.waitVisibilityOfElement(20, questionForm.getFormErrorMessage(errorMessage));
        return questionForm.getFormErrorMessage(errorMessage).isDisplayed();
    }
}
