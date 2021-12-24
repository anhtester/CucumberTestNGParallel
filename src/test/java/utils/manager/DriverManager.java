package utils.manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver() {
        if (driver.get() == null) {
            setWebDriver(new LocalDriverFactory().createInstance(null));
        }
        //log.debug("Getting instance of remote driver" + driver.get().getClass());
        return driver.get();
    }

    public void setWebDriver(WebDriver _driver) {
        this.driver.set(_driver);
    }

    /**
     * Returns a string containing current browser name, its version and OS name.
     * This method is used in the the *WebDriverListeners to change the test name.
     */
    public String getBrowserInfo() {
        //log.debug("Getting browser info");
        // we have to cast WebDriver object to RemoteWebDriver here, because the first one does not have a method
        // that would tell you which browser it is driving. (sick!)
        Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
        String b = cap.getBrowserName();
        String os = cap.getPlatform().toString();
        String v = cap.getVersion();
        return String.format("%s v:%s %s", b, v, os);
    }

    // Hàm initBaseTestSetup sẽ chạy trước nhất trong project này nếu có kế thừa class này
//    @Parameters({"browserType"})
//    @BeforeSuite
//    public void initBaseTestSetup(String browserType) {
//        try {
//            // Thực thi để khởi tạo driver với browser tương ứng
//            createDriver(browserType);
//            System.out.println("Tests are starting!");
//        } catch (Exception e) {
//            System.out.println("Error initialize driver..." + e.getStackTrace());
//            System.out.println("Error initialize driver");
//        }
//    }

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.get().close();
//            System.out.println("Close browser");
//        }
//    }
}
