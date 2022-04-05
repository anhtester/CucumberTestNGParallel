package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.time.Duration;

public class BrowserFactory {

    private WebDriver driver;

    public static final int IMPLICIT_WAIT = 10;
    public static final int PAGE_LOAD_TIMEOUT = 20;

    public WebDriver createInstance(String browserName) {
        browserName = (browserName != null) ? browserName : "chrome";
        switch (Browser.valueOf(browserName.toUpperCase())) {
            case CHROME:
                System.out.println("Launching " + browserName + " browser...");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
                break;
            case FIREFOX:
                System.out.println("Launching " + browserName + " browser...");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
                break;
            case OPERA:
                System.out.println("Launching " + browserName + " browser...");
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
                break;
            case EDGE:
                System.out.println("Launching " + browserName + " browser...");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
                break;
        }

        return driver;
    }

    private enum Browser {
        CHROME,
        EDGE,
        FIREFOX,
        OPERA
    }
}
