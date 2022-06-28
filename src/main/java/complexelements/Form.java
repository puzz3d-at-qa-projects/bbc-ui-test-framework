package complexelements;

import manager.POFactory;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Keys;
import pageobjects.forms.QuestionForm;

import java.util.List;
import java.util.Map;

public class Form {

    POFactory poFactory;
    QuestionForm questionForm;

    public Form(@NotNull POFactory poFactory) {
        this.poFactory = poFactory;
        questionForm = poFactory.getPage(QuestionForm.class);
    }

    public void fillForm(@NotNull List<Map<String, String>> values) {
        values.forEach(e -> e.forEach((k, v) -> questionForm
                .getFormElement(k).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE)));
        values.forEach(e -> e.forEach((k, v) -> questionForm
                .getFormElement(k).sendKeys(v.replaceFirst("\\[blank]", ""))));
        if (!questionForm.getTermsOfServiceCheckbox().isSelected()) {
            questionForm.getTermsOfServiceCheckbox().click();
        }
        questionForm.getSubmitButton().click();
    }

    public void fillForm(@NotNull Map<String, String> values) {
        values.forEach((k, v) -> questionForm
                .getFormElement(k).sendKeys(v.replaceFirst("\\[blank]", "")));
        if (!questionForm.getTermsOfServiceCheckbox().isSelected()) {
            questionForm.getTermsOfServiceCheckbox().click();
        }
        questionForm.getSubmitButton().click();
    }
}

