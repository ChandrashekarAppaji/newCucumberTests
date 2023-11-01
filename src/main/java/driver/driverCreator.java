package driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class driverCreator {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String EDGE_DRIVER_PROPERTY = "webdriver.edge.driver";
    private static final String FIREFOX_DRIVER_PROPERTY="webdriver.gecko.driver";

    public WebDriver createDriver(String browserType) {
        String projectPath=System.getProperty("user.dir");
        switch (browserType.toLowerCase()) {
            case "firefox" -> {
                driver = new FirefoxDriver();}
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                options.setBinary(projectPath + "/src/test/resources/drivers/chromedriver.exe");
                System.setProperty(CHROME_DRIVER_PROPERTY, projectPath + "/src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver(options);
            }
            case "edge"->{
                System.setProperty(EDGE_DRIVER_PROPERTY, projectPath + "/src/test/resources/drivers/msedgedriver.exe");
                EdgeOptions edgeOptions = new EdgeOptions();
              //  edgeOptions.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
              //  System.setProperty("webdriver.edge.verboseLogging", "true");
                driver = new EdgeDriver(edgeOptions);
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        return driver;
    }

/*    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }*/
    }


