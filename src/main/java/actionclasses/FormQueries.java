package actionclasses;

import manager.POFactory;
import org.jetbrains.annotations.NotNull;
import pageobjects.forms.QuestionForm;

public class FormQueries {

    QuestionForm questionForm;
    POFactory poFactory;

    public FormQueries(@NotNull POFactory poFactory) {
        this.poFactory = poFactory;
        questionForm = poFactory.getPage(QuestionForm.class);
    }

    public void clickTermsOfService() {
        questionForm.getTermsOfServiceCheckbox().click();
    }

    public String errorMessage() {
        questionForm.waitVisibilityOfElement(20, questionForm.getFormErrorMessage());
        return questionForm.getFormErrorMessage().getText();
    }
}
