package stepdefinitions;

import cucumber.TestContext;
import org.openqa.selenium.WebDriver;
import report.AllureManager;

public class BaseStepDef {

    protected WebDriver driver = null;
    protected TestContext testContext;

    public BaseStepDef(TestContext context) {
        driver = context.getDriver();
        testContext = context;
        AllureManager.setAllureEnvironmentInformation();
    }
}
