package common;

import org.openqa.selenium.WebDriver;
import driver.BrowserFactory;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private final WebDriver driver;
    private final Map<String, Object> contextList = new HashMap<>();

    public TestContext() {
        driver = new BrowserFactory().createInstance("chrome");
    }

    public Object getContext(String key) {
        return contextList.get(key);
    }

    public WebDriver getDriver(){
        return driver;
    }

}
