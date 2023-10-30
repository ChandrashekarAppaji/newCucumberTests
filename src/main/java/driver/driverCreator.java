package driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class driverCreator {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String EDGE_DRIVER_PROPERTY = "webdriver.edge.driver";

    public WebDriver createDriver(String browserType) {
        String projectPath=System.getProperty("user.dir");
        switch (browserType.toLowerCase()) {
            case "firefox" -> driver = new FirefoxDriver();
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                System.setProperty(CHROME_DRIVER_PROPERTY, projectPath + "/src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver(options);
            }
            case "edge"->{
                System.setProperty(EDGE_DRIVER_PROPERTY, projectPath + "/src/test/resources/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
