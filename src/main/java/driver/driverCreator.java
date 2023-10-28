package driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class driverCreator {

    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String EDGE_DRIVER_PROPERTY = "webdriver.edge.driver";

    public WebDriver createDriver(String browserType) {
        String projectPath=System.getProperty("user.dir");
        WebDriver driver=null;
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
        return driver;
    }

}
