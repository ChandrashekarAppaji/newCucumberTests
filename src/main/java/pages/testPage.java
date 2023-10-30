package pages;

import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.BatchInfo;

public class testPage {

    private String applitToolKey="nYPNgP0ugIs6kiyxYQbXpYcSQTPztx0WMi2xDbY106sFs110";
    private static BatchInfo batch;
    private static Configuration config;
    private static EyesRunner runner;

    WebDriver driver;

    @FindBy(xpath="//textarea[@type='search']")
    public WebElement googleSearch;

    public testPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    // Initialize the Eyes object

    Eyes eyes = new Eyes(runner);


    public void clickGoogleSearch()
    {
        driver.get("http://www.google.com");
        googleSearch.click();

    }
}
