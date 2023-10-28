package stepDefinitions;

import driver.driverCreator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;


public class testDefinition {

    driverCreator driver;
    WebDriver chrome;


    @Given("Hit Google")
    public void hit_google()
    {
      driver=new driverCreator();
      chrome= driver.createDriver("Edge");
     // chrome.get("http://www.google.com");
    }

    @Then("Enter the search")
    public void enter_the_search()
    {
        System.out.println("This is search tag");
    }
}

