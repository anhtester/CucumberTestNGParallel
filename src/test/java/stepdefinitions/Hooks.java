package stepdefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseStepDef {

    public Hooks(TestContext context) {
        super(context);
    }

    @Before
    public void beforeScenario() {
        System.out.println("Starting Driver: " + driver);
    }

    @After
    public void afterScenario() {
        System.out.println("Stop Driver: " + driver);
        driver.quit();
    }
}
