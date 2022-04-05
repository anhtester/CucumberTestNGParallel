package stepdefinitions;

import common.TestContext;
import org.openqa.selenium.WebDriver;
import report.AllureManager;

public class BaseSteps {

    protected WebDriver driver = null;
    protected TestContext testContext;

    public BaseSteps(TestContext context) {
        driver = context.getDriver();
        testContext = context;
        AllureManager.setAllureEnvironmentInformation();
    }
}
