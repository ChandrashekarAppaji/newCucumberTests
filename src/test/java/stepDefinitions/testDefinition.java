package stepDefinitions;

import driver.driverCreator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import steps.googleSteps;

public class testDefinition {

    driverCreator driver;
    WebDriver browserType;

    //All the step objects are initialized here
    googleSteps googlesteps=new googleSteps();

    @Given("Hit Google")
    public void hit_google()
    {
        driver=new driverCreator();
        browserType= driver.createDriver("Edge");
        googlesteps.googlePageActions(browserType);
    }

    @Then("Enter the search")
    public void enter_the_search()
    {
        System.out.println("This is search tag");
    }
}

