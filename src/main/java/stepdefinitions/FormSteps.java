package stepdefinitions;

import actionclasses.FormQueries;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import sharedcontext.ScenarioContext;
import sharedcontext.TestContext;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class FormSteps {

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    FormQueries form;
    ScenarioContext scenarioContext;

    public FormSteps(@NotNull TestContext testContext) {
        driver = testContext.getDriver();
        pageFactoryManager = testContext.getPageFactoryManager();
//        navigate = testContext.getNavigate();
        scenarioContext = testContext.scenarioContext;
        form = new FormQueries(pageFactoryManager);
    }

    @And("User trying to submit the form with incorrect entered data")
    public void userTryingToSubmitTheFormWithIncorrectEnteredData(List<Map<String,String>> formData) {
        form.fillForm(formData);
        form.acceptTermsOfService();
        form.submit();
    }

    @And("Error message {string} displayed")
    public void errorMessageCanTBeBlankDisplayed(String errorMessage) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        System.out.println("Error msg: " + errorMessage);
//        System.out.println("Error before clicks? " + form.errorDisplayed(errorMessage));
        form.clickTermsOfService(); // had to add these clicks to clear error from previous iteration
        form.clickTermsOfService(); // it was "cached" somehow, couldn't fix it with any waits but Thread.sleep, which is forbidden))
        form.clickTermsOfService(); // with just one click test was unstable, with three works fine ☺
//        System.out.println("Error after clicks? " + form.errorDisplayed(errorMessage));
        assertTrue(form.errorDisplayed(errorMessage));
    }
}
