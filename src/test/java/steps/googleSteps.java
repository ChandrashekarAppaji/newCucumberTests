package steps;

import org.openqa.selenium.WebDriver;
import pages.testPage;
import utilities.cucumberHooks;

public class googleSteps {

    testPage testpage;

    public  void googlePageActions()
    {
        //TODO Remove Driver Caller
        testpage=new testPage(cucumberHooks.driver);
        testpage.clickGoogleSearch();
    }
}
