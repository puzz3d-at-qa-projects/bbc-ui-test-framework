package actionclasses;

import manager.PageFactoryManager;
import org.jetbrains.annotations.NotNull;
import pageobjects.forms.QuestionForm;

public class FormQueries {

    QuestionForm questionForm;
    PageFactoryManager pageFactoryManager;

    public FormQueries(@NotNull PageFactoryManager pageFactoryManager) {
        this.pageFactoryManager = pageFactoryManager;
        questionForm = pageFactoryManager.getQuestionForm();
    }

    public void clickTermsOfService() {
        questionForm.getTermsOfServiceCheckbox().click();
    }

    public String errorMessage() {
        questionForm.waitVisibilityOfElement(20, questionForm.getFormErrorMessage());
        return questionForm.getFormErrorMessage().getText();
    }
}
