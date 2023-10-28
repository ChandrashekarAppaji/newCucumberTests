package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class testPage {

    WebDriver driver;

    @FindBy(xpath="")
    public WebElement googleSearch;

    public testPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickGoogleSearch()
    {
        googleSearch.click();
    }
}
