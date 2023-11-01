package pages;

import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.fluent.Target;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.BatchInfo;


public class testPage {



    WebDriver driver;

    @FindBy(xpath="//textarea[@type='search']")
    public WebElement googleSearch;

    public testPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    // Initialize the Eyes object

    public void clickGoogleSearch()
    {
        driver.get("http://www.google.com");
        googleSearch.click();

    }
}
