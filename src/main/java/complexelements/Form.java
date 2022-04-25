package complexelements;

import manager.PageFactoryManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Keys;
import pageobjects.forms.QuestionForm;

import java.util.List;
import java.util.Map;

public class Form {

    PageFactoryManager pageFactoryManager;
    QuestionForm questionForm;

    public Form(@NotNull PageFactoryManager pageFactoryManager) {
        this.pageFactoryManager = pageFactoryManager;
        questionForm = pageFactoryManager.getQuestionForm();
    }

    public void fillForm(List<Map<String, String>> values) {
        values.forEach(e -> e.forEach((k, v) -> questionForm
                .getFormElement(k).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE)));
        values.forEach(e -> e.forEach((k, v) -> questionForm
                .getFormElement(k).sendKeys(v.replaceFirst("\\[blank]", ""))));
        if (!questionForm.getTermsOfServiceCheckbox().isSelected()) {
            questionForm.getTermsOfServiceCheckbox().click();
        }
        questionForm.getSubmitButton().click();
    }

    public void fillForm(Map<String, String> values) {
        values.forEach((k, v) -> questionForm
                .getFormElement(k).sendKeys(v.replaceFirst("\\[blank]", "")));
        if (!questionForm.getTermsOfServiceCheckbox().isSelected()) {
            questionForm.getTermsOfServiceCheckbox().click();
        }
        questionForm.getSubmitButton().click();
    }
}

