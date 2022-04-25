package stepdefinitions;

import actionclasses.FormQueries;
import complexelements.Form;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import sharedcontext.TestContext;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class FormSteps {

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    FormQueries form;
    Form formToMeetTaskRequirements;

    public FormSteps(@NotNull TestContext testContext) {
        driver = testContext.getDriver();
        pageFactoryManager = testContext.getPageFactoryManager();
        form = new FormQueries(pageFactoryManager);
        formToMeetTaskRequirements = new Form(pageFactoryManager);
    }

    @And("the user trying to submit the form with incorrectly entered data")
    public void userTryingToSubmitTheFormWithIncorrectEnteredData(List<Map<String,String>> formData) {
        formToMeetTaskRequirements.fillForm(formData);
    }

    @And("the error message {string} displayed")
    public void errorMessageCanTBeBlankDisplayed(String expectedErrorMessage) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        form.clickTermsOfService(); // had to add these clicks to clear error from previous iteration
        form.clickTermsOfService(); // it was "cached" somehow, couldn't fix it with any waits but Thread.sleep, which is forbidden))
        form.clickTermsOfService(); // with just one click test was unstable, with three works fine ☺
        System.out.println("fem:"+form.errorMessage());
        System.out.println("eem:"+expectedErrorMessage);
        assertTrue(form.errorMessage().contains(expectedErrorMessage));
    }

    @And("the user trying to submit the form with incorrectly entered dataData")
    public void theUserTryingToSubmitTheFormWithIncorrectlyEnteredData(Map<String,String> formData) {
        formToMeetTaskRequirements.fillForm(formData);
    }

    @And("the error message displayed")
    public void theErrorErrormsgDisplayed(@NotNull Map<String, String> expectedErrorMessage) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String key = expectedErrorMessage.keySet().iterator().next();
        assertTrue(form.errorMessage().contains(expectedErrorMessage.get(key)));
    }
}
