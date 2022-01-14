package utils.manager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        System.out.println("ThreadLocal driver: " + driver.get());
        if (driver.get() == null) {
            setWebDriver(new LocalDriverFactory().createInstance(null));
        }
        System.out.println("Created driver: " + driver.get());
        return driver.get();
    }

    public static void setWebDriver(WebDriver _driver) {
        driver.set(_driver);
    }

    public static String getBrowserInfo() {
        Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
        String b = cap.getBrowserName();
        String os = cap.getPlatformName().toString();
        String v = cap.getBrowserVersion();
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
