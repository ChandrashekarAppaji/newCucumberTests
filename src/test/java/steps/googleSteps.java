package steps;

import org.openqa.selenium.WebDriver;
import pages.testPage;
public class googleSteps {

    testPage testpage;
    public void googlePageActions(WebDriver driver)
    {
        testpage=new testPage(driver);
        testpage.clickGoogleSearch();
    }
}
