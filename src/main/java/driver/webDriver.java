package driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class webDriver {

    private WebDriver driver;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";


//    public WebDriver getDriver() {
//        return createDriver();
//    }
    public WebDriver createDriver() {
        String projectPath=System.getProperty("user.dir");
     /*   ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty(CHROME_DRIVER_PROPERTY,projectPath+"/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver(options);*/
        driver=new FirefoxDriver();
        return driver;
    }

}
