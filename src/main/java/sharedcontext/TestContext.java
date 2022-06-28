package sharedcontext;

import actionclasses.Navigate;
import manager.POFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class TestContext {

    private WebDriver driver;
    private POFactory poFactory;
    private Navigate navigate;
    public ScenarioContext scenarioContext;

    public TestContext() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        poFactory = new POFactory(driver);
        navigate = new Navigate(driver, poFactory);
        scenarioContext = new ScenarioContext();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public POFactory getPoFactory() {
        return poFactory;
    }

    public Navigate getNavigate() {
        return navigate;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
