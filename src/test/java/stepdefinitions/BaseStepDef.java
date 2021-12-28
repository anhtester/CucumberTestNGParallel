package stepdefinitions;

import cucumber.TestContext;
import org.openqa.selenium.WebDriver;
import utils.manager.LocalDriverFactory;

public class BaseStepDef {

    protected WebDriver driver = null;
    protected LocalDriverFactory localDriverFactory;
    protected TestContext testContext;

    public BaseStepDef(TestContext context) {
        localDriverFactory = new LocalDriverFactory();
        driver = context.getDriver();
        testContext = context;
    }
}
