package sharedcontext;

import actionclasses.Navigate;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class TestContext {

    private WebDriver driver;
    private PageFactoryManager pageFactoryManager;
    private Navigate navigate;
    public ScenarioContext scenarioContext;

    public TestContext() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
        navigate = new Navigate(driver, pageFactoryManager);
        scenarioContext = new ScenarioContext();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public PageFactoryManager getPageFactoryManager() {
        return pageFactoryManager;
    }

    public Navigate getNavigate() {
        return navigate;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
