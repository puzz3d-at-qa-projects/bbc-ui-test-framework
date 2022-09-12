package stepdefinitions;

import actionclasses.FormQueries;
import complexelements.Form;
import io.cucumber.java.en.And;
import manager.POFactory;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import sharedcontext.TestContext;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class FormSteps {

    WebDriver driver;
    POFactory poFactory;
    FormQueries form;
    Form formToMeetTaskRequirements;

    public FormSteps(@NotNull TestContext testContext) {
        driver = testContext.getDriver();
        poFactory = testContext.getPoFactory();
        form = new FormQueries(poFactory);
        formToMeetTaskRequirements = new Form(poFactory);
    }

    @And("the user trying to submit the form with incorrectly entered data")
    public void userTryingToSubmitTheFormWithIncorrectEnteredData(List<Map<String,String>> formData) {
        formToMeetTaskRequirements.fillForm(formData);
    }

    @And("the error message {string} displayed")
    public void errorMessageCanTBeBlankDisplayed(String expectedErrorMessage) {
        form.clickTermsOfService(); // had to add these clicks to clear error from previous iteration
        form.clickTermsOfService(); // it was "cached" somehow, couldn't fix it with any waits but Thread.sleep, which is forbidden))
        form.clickTermsOfService(); // with just one click test was unstable, with three-four works fine ☺
        form.clickTermsOfService();
        assertTrue("The expected Error message wasn't found!"
                , form.errorMessage().contains(expectedErrorMessage));
    }

    @And("the user trying to submit the form with missing data")
    public void theUserTryingToSubmitTheFormWithMissingData(Map<String,String> formData) {
        formToMeetTaskRequirements.fillForm(formData);
    }

    @And("the error message displayed")
    public void theErrorErrormsgDisplayed(@NotNull Map<String, String> expectedErrorMessage) {
        String key = expectedErrorMessage.keySet().iterator().next();
        assertTrue("The expected Error message wasn't found!"
                , form.errorMessage().contains(expectedErrorMessage.get(key)));
    }
}
